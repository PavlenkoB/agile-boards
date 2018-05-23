import React from 'react';
import {Provider} from 'react-redux'
import ReactDOM from 'react-dom';
import Routes from './routes';


import configureStore from './store/configureStore';

export const store = configureStore();

ReactDOM.render(
    <Provider store={store}>
        <Routes/>
    </Provider>,
    document.getElementById('root')
);