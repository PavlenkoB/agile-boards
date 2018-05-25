import React, {Component} from 'react';
import {bindActionCreators} from "redux";
import {connect} from 'react-redux';
import * as actions from "./actions";

import Board from './dumpComponent/Board';

import './style/boards.scss';

export class MainPage extends Component {
    componentWillMount() {
        this.props.actions.getBoardsList();
    }

    shouldComponentUpdate(newProps, nextState) {
        return true;
    }


    constructor(props) {
        super(props);
        this.createNewTask = this.createNewTask.bind(this);
    }

    createNewTask() {
        let newBoard = {
            name: this.newBoardName.value
        };
        this.props.actions.createBoard(newBoard);
        this.newBoardName.value = '';
    }

    render() {
        return <div className="app-div">
            Some data
            <div className="boardsContainer">
                {this.props.pageData.boards.map((board, index) =>
                    <Board board={board} key={board.id}
                           actions={this.props.actions}
                    />
                )}
            </div>
            <div className="add-new-board">
                Add new Board:
                <input ref={(node) => {
                    this.newBoardName = node
                }}/>
                <button onClick={this.createNewTask}>Create</button>
            </div>
        </div>
    };

};

function mapStateToProps(state) {
    return {
        pageData: state.MainReduser
    }
}

function actionsStateToProps(dispatch) {
    return {
        actions: bindActionCreators(actions, dispatch)
    }
}

export default connect(
    mapStateToProps,
    actionsStateToProps
)(MainPage);