import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'

import MainPage from './containers/MainPage/';

import {PAGE_PATH} from './pathCons';

export default () => (
    <div>
        <BrowserRouter>
            <div>
                <div className="container-fluid">
                    <div className="header">
                    </div>
                    <div className="row main-content">
                        <div className="col-md-2 menu-bar">
                        </div>
                        <div className="col-md-10 content-container">
                            <Switch>
                                <Route exact path='/' component={MainPage}/>
                            </Switch>
                        </div>
                    </div>
                    <div className="footer">
                    </div>
                </div>
            </div>
        </BrowserRouter>
    </div>
);
