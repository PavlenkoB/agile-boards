import React, {Component} from 'react';
import PropTypes from 'prop-types';
import FontAwesome from 'react-fontawesome';

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
            <div className="actions">
                <button className="moveLeft">
                    <FontAwesome name="arrow-left" size="2x"/>
                </button>
                <button className="deleteBoard">
                    <FontAwesome name="trash" size="2x"/>
                </button>
                <button className="moveRight">
                    <FontAwesome name="arrow-right" size="2x"/>
                </button>
            </div>
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