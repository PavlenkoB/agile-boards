import $ from 'jquery';
import * as con from "./constants";
import * as fetchActions from "./apiActions";


let headers_template = {'Content-type': 'application/json'};

export function getBoardsList() {
    return dispatch => {
        fetchActions.getBoards().then((res) => {
            dispatch({
                type: con.FETCH_BOARD_LIST_SUCCESS,
                taskData: res
            });
        });
    };
}

export function deleteBoard(board) {
    return dispatch => {
        fetchActions.deleteBoard(board).then((res) => {
            fetchActions.getBoards().then((responce) => {
                dispatch({
                    type: con.FETCH_BOARD_LIST_SUCCESS,
                    taskData: responce
                });
            });
        });
    }
}

export function updateBoard(board) {
    return dispatch => {
        fetchActions.updateBoard(board).then((res) => {
            fetchActions.getBoards().then((responce) => {
                dispatch({
                    type: con.UPDATE_BOARD_SUCCESS,
                    taskData: responce
                });
            });
        });
    }
}

export function createBoard(board) {
    return dispatch => {
        fetchActions.createBoard(board).then((res) => {
            fetchActions.getBoards().then((responce) => {
                dispatch({
                    type: con.UPDATE_BOARD_SUCCESS,
                    taskData: responce
                });
            })
        })
    }

}

export function getTaskInfo(taskId) {
    return dispatch => {
        $.get('/rs/admin/tasks/' + taskId, function (taskData) {
            dispatch({
                type: con.FETCH_TASK_SUCCESS,
                payload: {
                    taskData: taskData
                }
            })
        })
    };
}

