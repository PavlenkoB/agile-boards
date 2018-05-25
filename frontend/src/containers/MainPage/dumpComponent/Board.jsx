import React, {Component} from 'react';
import PropTypes from 'prop-types';
import FontAwesome from 'react-fontawesome';

import Task from './Task';

export class Board extends Component {

    static propTypes = {
        board: PropTypes.shape({
            id: PropTypes.number,
            name: PropTypes.string,
            order: PropTypes.number,
            tasks: PropTypes.array
        }),
        deleteAction: PropTypes.func
    };


    constructor(props) {
        super(props);
        this.board = this.props.board;
        this.deletfuncrtion = this.props.deleteAction;
        this.runDelete = this.runDelete.bind(this);
    }

    runDelete() {
        console.log("Delete....");
        console.log(this);
        this.deletfuncrtion(this.board);
    }

    render() {
        return <div className="board-body">
            <div className="actions">
                <button className="moveLeft">
                    <FontAwesome name="arrow-left" size="2x"/>
                </button>
                <button className="deleteBoard" onClick={this.runDelete}>
                    <FontAwesome name="trash" size="2x"/>
                </button>
                <button className="moveRight">
                    <FontAwesome name="arrow-right" size="2x"/>
                </button>
            </div>
            <div>
                <p>
                    <b>Id:</b>{this.board.id}
                    <br/>
                    <b>Name:</b>{this.board.name}
                    <br/>
                    <b>Order:</b>{this.board.order}
                </p>
            </div>
            <div className="task-list">
                {this.board.tasks.map((task, key) =>
                    <Task task={task} key={task.id}/>
                )}
            </div>
            <div className="add-task">
                Name:<input className="taskName"/>
                <br/>
                Description:<input className="taskDescription"/>
            </div>
        </div>
    };
};

export default Board;