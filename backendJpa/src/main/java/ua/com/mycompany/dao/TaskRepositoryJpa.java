package ua.com.mycompany.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mycompany.domain.Task;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@Repository
public interface TaskRepositoryJpa extends TaskRepository, CrudRepository<Task, Long> {
    List<Task> findByBoardId(Long id);
}
