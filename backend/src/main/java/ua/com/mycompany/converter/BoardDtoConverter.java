package ua.com.mycompany.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.dto.BoardDto;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@Service
public class BoardDtoConverter implements Converter<BoardDto, Board> {
    @Override
    public Board convert(BoardDto dto) {
        Board board = new Board();
        if (board.getId() != null) {
            board.setId(dto.getId());
        }
        board.setName(dto.getName());
        if (board.getId() != null) {
            board.setOrder(dto.getOrder());
        }
        return board;
    }
}
