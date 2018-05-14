package ua.com.mycompany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mycompany.dao.TaskRepositoryJpa;
import ua.com.mycompany.domain.Task;
import ua.com.mycompany.service.TaskService;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@Service
public class TaskServiceImpl implements TaskService {
    private static String sequenceName = "taskIdSequence";
    private final TaskRepositoryJpa taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepositoryJpa taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllTasksForBoard(Long boardId) {
        return taskRepository.findByBoardId(boardId);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
