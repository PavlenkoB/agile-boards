package ua.com.mycompany.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.com.mycompany.domain.Task;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface TaskRepository extends MongoRepository<Task, Long> {
}
