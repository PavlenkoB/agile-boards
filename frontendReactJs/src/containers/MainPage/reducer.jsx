import * as con from "./constants";

const initState = {
    boards: null
};

export default function MainReduser(state = initState, action) {
    let payload = action.payload;
    switch (action.type) {
        case con.FETCH_BOARD_LIST_SUCCESS:
            return {
                boards: payload.taskData
            };
        default:
            return state;
    }
};
