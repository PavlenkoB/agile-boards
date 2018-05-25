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
        body: newBoard
    }).then(retJson);
};
export const updateBoard = function (updateBoard) {
    return fetch("/api/board" + updateBoard.id, {
        method: 'PATCH',
        headers: headers_template,
        body: updateBoard
    }).then(retJson);
};