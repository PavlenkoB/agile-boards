package ua.com.mycompany.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.com.mycompany.domain.Board;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface BoardRepositoryMongo extends MongoRepository<Board, Long> {
}
