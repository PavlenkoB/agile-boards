package ua.com.mycompany.dao;

import ua.com.mycompany.domain.Task;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface TaskRepository {
    List<Task> findByBoardId(Long id);
}
