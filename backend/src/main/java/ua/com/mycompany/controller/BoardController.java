package ua.com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.dto.BoardDto;
import ua.com.mycompany.service.BoardService;

import java.util.List;
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
    public List<BoardDto> getMembersPage() {
        List<Board> boardList = boardService.getAll();
        List<BoardDto> boardDtos = boardList
                .stream()
                .map(board -> conversionService.convert(board, BoardDto.class))
                .collect(Collectors.toList());
        return boardDtos;
    }
}
