import React, {Component} from 'react';
import {bindActionCreators} from "redux";
import {connect} from 'react-redux';
import * as actions from "./actions";

import Board from './dumpComponent/Board';

import './style/boards.scss';

export class MainPage extends Component {
    componentWillMount() {
        this.props.actions.getBoardsList();
        this.deleteThisBoard = this.deleteThisBoard.bind(this);
    }

    deleteThisBoard(board) {
        this.props.actions.deleteBoard(board);
    }

    componentNeedUpdate(nextState) {
        return true;
    }

    render() {
        return <div className="main-page">
            Some data
            <div className="boardsContainer">
                {this.props.pageData.boards.map((board, index) =>
                    <Board board={board} key={board.id} deleteAction={this.deleteThisBoard}/>
                )}
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