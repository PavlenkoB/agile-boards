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
public class TaskDtoConverter implements Converter<TaskDto, Task> {
    @Override
    public Task convert(TaskDto taskDto) {
        Task task = new Task();

        if (taskDto.getId() != null) {
            task.setId(taskDto.getId());
        }
        if (taskDto.getOrder() != null) {
            task.setOrder(taskDto.getOrder());
        }
        task.setBoardId(taskDto.getBoardId());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        return task;
    }
}
