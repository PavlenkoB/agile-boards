package ua.com.mycompany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mycompany.dao.BoardRepository;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.service.BoardService;

import java.util.List;
import java.util.Optional;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board create(Board board) {
        //todo generate new ID
        return boardRepository.save(board);
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board update(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
