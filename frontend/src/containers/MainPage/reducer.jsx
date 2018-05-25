import * as con from "./constants";

const initState = {
    boards: []
};

export default function MainReduser(state = initState, action) {

    switch (action.type) {
        case con.FETCH_BOARD_LIST_SUCCESS:
        case con.DELETE_BOARD_SUCCESS:
        case con.UPDATE_BOARD_SUCCESS:
        case con.CREATE_TASK_SUCCESS:
            let taskData = action.taskData;
            taskData.map((e) => {
                e.tasks = [];
                return e;
            });
            taskData.sort((a, b) => {
                return a.order - b.order;
            });
            return {
                boards: taskData
            };
        case con.FETCH_TASKS_FOR_BOARD_SUCCESS:
            let newState = state;
            newState.boards.forEach((board, i, arr) => {
                if (board.id === action.boardId) {
                    board.tasks = action.tasks;
                }
            });
            return newState;
        default:
            return state;
    }
};
