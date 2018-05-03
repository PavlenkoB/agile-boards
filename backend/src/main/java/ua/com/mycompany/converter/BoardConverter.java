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
public class BoardConverter implements Converter<Board, BoardDto> {
    @Override
    public BoardDto convert(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setOrder(board.getOrder());
        boardDto.setName(board.getName());
        return boardDto;
    }
}
