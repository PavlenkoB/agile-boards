import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'

import FontAwesome from 'react-fontawesome';
import 'font-awesome/css/font-awesome.min.css';
import MainPage from './containers/MainPage/';

export default () => (
    <div>
        <BrowserRouter>
            <div>
                <b>
                    Boards: <FontAwesome name='trello' size="2x"/>
                </b>
                <div className="container-fluid">
                    <div className="main-content">
                        <div className="menu-bar">
                        </div>
                        <div className="content-container">
                            <Switch>
                                <Route exact path='/' component={MainPage}/>
                            </Switch>
                        </div>
                    </div>
                </div>
            </div>
        </BrowserRouter>
    </div>
);
