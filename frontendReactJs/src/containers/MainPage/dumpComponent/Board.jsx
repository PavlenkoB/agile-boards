import React, {Component} from 'react';
import PropTypes from 'prop-types';

export class Board extends Component {

    static propTypes = {
        board: PropTypes.shape({
            id: PropTypes.number,
            name: PropTypes.string,
            order: PropTypes.number
        })
    };

    constructor(props) {
        super(props);
        this.board = this.props.board;
    }

    render() {
        return <div className="board-body">
            BoardData
            <div>
                <p>
                    <b>Id:</b>{this.board.id}
                </p>
                <p>
                    <b>Name:</b>{this.board.name}
                </p>
                <p>
                    <b>Order:</b>{this.board.order}
                </p>
            </div>
        </div>
    };
};

export default Board;