package ua.com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.dto.BoardDto;
import ua.com.mycompany.exception.RestException;
import ua.com.mycompany.service.BoardService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
@RestController
@RequestMapping(value = "/api/board")
public class BoardController {

    private final BoardService boardService;
    private final ConversionService conversionService;

    @Autowired
    public BoardController(BoardService boardService, ConversionService conversionService) {
        this.boardService = boardService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<BoardDto> getBoards() {
        List<Board> boardList = boardService.getAll();
        List<BoardDto> boardDtos = boardList
                .stream()
                .map(board -> conversionService.convert(board, BoardDto.class))
                .collect(Collectors.toList());
        return boardDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardDto createBoard(@RequestBody BoardDto boardDto) {
        Board board = conversionService.convert(boardDto, Board.class);
        Board createdBoard = boardService.create(board);
        return conversionService.convert(createdBoard, BoardDto.class);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardDto updateBoard(@Valid @RequestBody BoardDto boardDto,
                                @PathVariable("id") Long id) {
        this.boardWithIdIsExist(id);
        Board board = conversionService.convert(boardDto, Board.class);
        if (!board.getId().equals(id)) {
            throw new RestException("Board id and id in url not same", HttpStatus.BAD_REQUEST);
        }
        Board createdBoard = boardService.update(board);
        return conversionService.convert(createdBoard, BoardDto.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardDto getBoardById(Long id) {
        Board board = this.boardWithIdIsExist(id);
        return conversionService.convert(board, BoardDto.class);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoardById(
            @PathVariable("id") Long id
    ) {
        this.boardWithIdIsExist(id);
        boardService.deleteById(id);
    }

    private Board boardWithIdIsExist(Long id) {
        Optional<Board> optionalBoard = boardService.findById(id);
        if (!optionalBoard.isPresent()) {
            throw new RestException("Board with id=" + id + " not found", HttpStatus.NOT_FOUND);
        }
        return optionalBoard.get();
    }
}
