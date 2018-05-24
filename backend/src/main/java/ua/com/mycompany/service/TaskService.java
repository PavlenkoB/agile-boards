package ua.com.mycompany.service;

import org.springframework.lang.NonNull;
import ua.com.mycompany.domain.Task;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface TaskService {
    @NonNull
    List<Task> getAll();

    @NonNull
    List<Task> getAllTasksForBoard(Long boardId);

    @NonNull
    Task create(Task task);

    @NonNull
    Optional<Task> findById(Long id);

    @NonNull
    Task update(Task task);

    void deleteById(Long id);

    void deleteByBoardId(Long boardId);
}
