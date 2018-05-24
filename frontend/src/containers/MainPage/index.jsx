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

    deleteThisBoard(id) {
        console.log("Delete....", id);
        console.log("this", this);
        // this.props.actions.deleteBoard(id);
    }

    componentNeedUpdate(nextState) {
        return true;
    }

    render() {
        console.log(this.props);
        return <div className="main-page">
            Some data
            <div className="boardsContainer">
                {this.props.pageData.boards.map((board, index) =>
                    <Board board={board} key={index} deleteAction={this.deleteThisBoard}/>
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