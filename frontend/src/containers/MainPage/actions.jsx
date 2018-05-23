import $ from 'jquery';

import * as con from "./constants";

export function getBoardsList() {
    return dispatch => {
        $.ajax({
            url: '/api/board',
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (taskData) {
            dispatch({
                type: con.FETCH_BOARD_LIST_SUCCESS,
                payload: {
                    taskData: taskData
                }
            })
        });
    };
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

