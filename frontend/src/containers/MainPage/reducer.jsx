import * as con from "./constants";

const initState = {
    boards: []
};

export default function MainReduser(state = initState, action) {
    let payload = action.payload;
    switch (action.type) {
        case con.FETCH_BOARD_LIST_SUCCESS:
            let boards = payload.taskData;
            boards.map((e) => {
                e.tasks = [];
                return e;
            });
            return {
                boards: payload.taskData
            };
        default:
            return state;
    }
};
