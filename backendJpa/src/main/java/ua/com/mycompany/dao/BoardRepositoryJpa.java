package ua.com.mycompany.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.mycompany.domain.Board;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@Repository
public interface BoardRepositoryJpa extends BoardRepository, CrudRepository<Board, Long> {
}
