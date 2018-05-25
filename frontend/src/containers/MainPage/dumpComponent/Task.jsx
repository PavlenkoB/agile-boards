import React, {Component} from 'react';
import PropTypes from 'prop-types';

export class Task extends Component {

    static propTypes = {
        task: PropTypes.shape({
            id: PropTypes.number,
            boardId: PropTypes.number,
            order: PropTypes.number,
            name: PropTypes.string,
            description: PropTypes.string
        })
    };

    constructor(props) {
        super(props);
        this.task = this.props.task;
    }

    render() {
        return <div className="task-body">
            <div>ID:{this.task.id}</div>
            <div>Name:{this.task.name}</div>
        </div>
    };
};

export default Task;