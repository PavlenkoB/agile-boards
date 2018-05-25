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
        actions: PropTypes.shape()
    };

    constructor(props) {
        super(props);
        this.board = this.props.board;
        this.deletFuncrtion = this.props.actions.deleteBoard;
        this.updateAction = this.props.actions.updateBoard;
        this.addTask = this.props.actions.createTask;
        this.runDelete = this.runDelete.bind(this);
        this.runUpdate = this.runUpdate.bind(this);
        this.moveLeft = this.moveLeft.bind(this);
        this.moveRight = this.moveRight.bind(this);
    }

    shouldComponentUpdate(newProps, nextState) {
        return true;
    }

    runDelete() {
        this.deletFuncrtion(this.board);
    }

    runUpdate() {
        this.updateAction(this.board);
    }

    moveLeft() {
        this.board.order = (0 < this.board.order - 1) ? this.board.order - 1 : 0;
        this.runUpdate();
    }

    moveRight() {
        this.board.order = this.board.order + 1;
        this.runUpdate();
    }

    addNewTask() {
        let newTask = {
            name: this.newTaskName,
            description: this.newTaskDescription,
            boardId: this.board.id,
            order: this.board.tasks.length
        }
    }

    render() {
        return <div className="board-body">
            <div className="actions">
                <button className="moveLeft" onClick={this.moveLeft}>
                    <FontAwesome name="arrow-left" size="2x"/>
                </button>
                <button className="deleteBoard" onClick={this.runDelete}>
                    <FontAwesome name="trash" size="2x"/>
                </button>
                <button className="moveRight" onClick={this.moveRight}>
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
                <div className="task-list">
                    {this.board.tasks.map((task, key) =>
                        <Task className="task-item" task={task} key={task.id}/>
                    )}
                </div>
                <div className="add-task">
                    Name:
                    <input className="taskName" ref={(node) => {
                        this.newTaskName = node
                    }}/>
                    <br/>
                    Description:
                    <input className="taskDescription" ref={(node) => {
                        this.newTaskDescription = node
                    }}/>
                    <br/>
                    <button onClick={this.addNewTask}>Add</button>
                </div>
            </div>
        </div>
    };
};

export default Board;