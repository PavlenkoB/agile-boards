let headers_template = {'Content-type': 'application/json'};
let retJson = function (res) {
    return res.json();
};
export const getBoards = function () {
    return fetch("/api/board", {
        method: 'get',
        headers: headers_template
    }).then(retJson);
};
export const deleteBoard = function (board) {
    return fetch("/api/board/" + board.id, {
        method: 'DELETE',
        headers: headers_template
    }).then();
};
export const createBoard = function (newBoard) {
    return fetch("/api/board", {
        method: 'POST',
        headers: headers_template,
        body: JSON.stringify(newBoard)
    }).then(retJson);
};
export const updateBoard = function (updateBoard) {
    return fetch("/api/board/" + updateBoard.id, {
        method: 'PATCH',
        headers: headers_template,
        body: JSON.stringify(updateBoard)
    }).then(retJson);
};


export const getTaskForBoard = function (board) {
    return fetch("/api/task/forBoard/" + board.id, {
        method: 'GET',
        headers: headers_template,
    }).then(retJson);
};

export const getAllTask = function (task) {
    return fetch("/api/task", {
        method: 'GET',
        headers: headers_template,
    }).then(retJson);
};

export const createTask = function (task) {
    return fetch("/api/task", {
        method: 'POST',
        headers: headers_template,
        body: JSON.stringify(task)
    }).then(retJson);
};

export const updateTask = function (task) {
    return fetch("/api/task/" + task.id, {
        method: 'PATCH',
        headers: headers_template,
        body: JSON.stringify(task)
    }).then(retJson);
};

export const deleteTask = function (task) {
    return fetch("/api/task/" + task.id, {
        method: 'DELETE',
        headers: headers_template,
        body: JSON.stringify(task)
    }).then();
};
