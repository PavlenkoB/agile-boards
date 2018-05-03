package ua.com.mycompany.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ua.com.mycompany.domain.Task;
import ua.com.mycompany.dto.TaskDto;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@Service
public class TaskConverter implements Converter<Task, TaskDto> {
    @Override
    public TaskDto convert(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setOrder(task.getOrder());
        taskDto.setBoardId(task.getBoardId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        return taskDto;
    }
}
