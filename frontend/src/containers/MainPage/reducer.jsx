import * as con from "./constants";

const initState = {
    boards: []
};

export default function MainReduser(state = initState, action) {
    let taskData = action.taskData;
    switch (action.type) {
        case con.FETCH_BOARD_LIST_SUCCESS:
        case con.DELETE_BOARD_SUCCESS:
        case con.UPDATE_BOARD_SUCCESS:
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
        default:
            return state;
    }
};
