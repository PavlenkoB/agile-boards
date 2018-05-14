import React, {Component} from 'react';
import {bindActionCreators} from "redux";
import {connect} from 'react-redux';
import * as actions from "./actions";

import Board from './dumpComponent/Board';

import './boards.css';

export class MainPage extends Component {
    componentWillMount() {
        this.props.actions.getBoardsList();
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
                    <Board board={board} key={index}/>
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