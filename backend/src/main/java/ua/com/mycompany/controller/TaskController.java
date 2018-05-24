package ua.com.mycompany.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.mycompany.domain.Task;
import ua.com.mycompany.dto.TaskDto;
import ua.com.mycompany.exception.RestException;
import ua.com.mycompany.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@RestController
@RequestMapping(value = "/api/task")
@Api
public class TaskController {
    private final TaskService taskService;
    private final ConversionService conversionService;

    @Autowired
    public TaskController(TaskService taskService, ConversionService conversionService) {
        this.taskService = taskService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskService.getAll();
        List<TaskDto> taskDtoList = taskList
                .stream()
                .map(task -> conversionService.convert(task, TaskDto.class))
                .collect(Collectors.toList());
        return taskDtoList;
    }

    @GetMapping("/forBoard/{boardId}")
    public List<TaskDto> getAllTasksForBoard(@PathVariable("boardId") Long boardId) {
        List<Task> taskList = taskService.getAllTasksForBoard(boardId);
        List<TaskDto> taskDtoList = taskList
                .stream()
                .map(task -> conversionService.convert(task, TaskDto.class))
                .collect(Collectors.toList());
        return taskDtoList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task task = conversionService.convert(taskDto, Task.class);
        Task createdTask = taskService.create(task);
        return conversionService.convert(createdTask, TaskDto.class);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto updateTask(@RequestBody TaskDto taskDto,
                              @PathVariable("id") Long id) {
        Task taskWithIdIsExist = this.taskWithIdIsExist(id);
        Task task = conversionService.convert(taskDto, Task.class);
        if (!task.getId().equals(id)) {
            throw new RestException("Task id and id in url not same", HttpStatus.BAD_REQUEST);
        }
        task.setVersion(taskWithIdIsExist.getVersion());
        Task updatedTask = taskService.update(task);
        return conversionService.convert(updatedTask, TaskDto.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto getTaskById(Long id) {
        Task task = this.taskWithIdIsExist(id);
        return conversionService.convert(task, TaskDto.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable("id") Long id) {
        this.taskWithIdIsExist(id);
        taskService.deleteById(id);
    }

    private Task taskWithIdIsExist(Long id) {
        Optional<Task> optionalTask = taskService.findById(id);
        if (!optionalTask.isPresent()) {
            throw new RestException("Task with id=" + id + " not found", HttpStatus.NOT_FOUND);
        }
        return optionalTask.get();
    }

}
