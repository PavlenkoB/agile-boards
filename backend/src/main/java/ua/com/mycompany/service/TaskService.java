package ua.com.mycompany.service;

import ua.com.mycompany.domain.Task;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface TaskService {
    List<Task> getAll();

    Task create(Task task);

    Optional<Task> findById(Long id);

    Task update(Task task);

    void deleteById(Long id);
}
