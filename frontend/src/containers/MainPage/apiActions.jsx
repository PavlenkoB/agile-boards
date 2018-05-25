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
export const deleteBoard = function (boardId) {
    return fetch("/api/board/" + boardId, {
        method: 'DELETE',
        headers: headers_template
    }).then();
};