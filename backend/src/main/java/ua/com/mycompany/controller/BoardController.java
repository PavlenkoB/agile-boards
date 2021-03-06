package ua.com.mycompany.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.dto.BoardDto;
import ua.com.mycompany.exception.RestException;
import ua.com.mycompany.service.BoardService;
import ua.com.mycompany.service.TaskService;

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
@RequestMapping(value = "/api/board", consumes = {"application/json"})
@Api(value = "board", description = "Operations on boards")
public class BoardController {

    private final BoardService boardService;
    private final TaskService taskService;
    private final ConversionService conversionService;

    @Autowired
    public BoardController(BoardService boardService, TaskService taskService, ConversionService conversionService) {
        this.boardService = boardService;
        this.taskService = taskService;
        this.conversionService = conversionService;
    }

    @GetMapping
    @ApiOperation("Get all boards")
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
    @ApiOperation("Create board")
    public BoardDto createBoard(@RequestBody @Valid BoardDto boardDto) {
        Board board = conversionService.convert(boardDto, Board.class);
        Board createdBoard = boardService.create(board);
        return conversionService.convert(createdBoard, BoardDto.class);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update board")
    public BoardDto updateBoard(@RequestBody @Valid BoardDto boardDto,
                                @PathVariable("id") Long id) {
        Board boardWithIdIsExist = this.boardWithIdIsExist(id);
        Board board = conversionService.convert(boardDto, Board.class);
        if (!board.getId().equals(id)) {
            throw new RestException("Board id and id in url not same", HttpStatus.BAD_REQUEST);
        }
        board.setVersion(boardWithIdIsExist.getVersion());
        Board updatedBoard = boardService.update(board);
        return conversionService.convert(updatedBoard, BoardDto.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get board by id")
    public BoardDto getBoardById(@PathVariable("id") Long id) {
        Board board = this.boardWithIdIsExist(id);
        return conversionService.convert(board, BoardDto.class);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Board board by id")
    public void deleteBoardById(
            @PathVariable("id") Long id
    ) {
        Board board = this.boardWithIdIsExist(id);
        taskService.deleteByBoardId(id);
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
