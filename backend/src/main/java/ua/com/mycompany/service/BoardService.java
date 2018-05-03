package ua.com.mycompany.service;

import ua.com.mycompany.domain.Board;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface BoardService {
    List<Board> getAll();

    Board create(Board board);

    Optional<Board> findById(Long id);

    Board update(Board board);

    void deleteById(Long id);
}
