import React, {Component} from 'react';
import {bindActionCreators} from "redux";
import {connect} from 'react-redux';
import * as actions from "./actions";

import Board from './dumpComponent/Board';

export class MainPage extends Component {
    componentWillMount() {
        this.props.actions.getBoardsList();
    }

    render() {
        return <div>
            qwesad
        </div>
    };
};

function mapStateToProps(state) {
    return {
        pageData: state.AdministrationReducer
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