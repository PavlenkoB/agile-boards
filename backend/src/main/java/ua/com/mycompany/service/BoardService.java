package ua.com.mycompany.service;

import org.springframework.lang.NonNull;
import ua.com.mycompany.domain.Board;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface BoardService {
    @NonNull
    List<Board> getAll();

    @NonNull
    Board create(Board board);

    @NonNull
    Optional<Board> findById(Long id);

    @NonNull
    Board update(Board board);

    void deleteById(Long id);
}
