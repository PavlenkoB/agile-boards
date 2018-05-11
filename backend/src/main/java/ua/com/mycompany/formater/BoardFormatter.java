package ua.com.mycompany.formater;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.format.Formatter;
import ua.com.mycompany.domain.Board;

import java.text.ParseException;
import java.util.Locale;

public class BoardFormatter implements Formatter<Board> {
    @Override
    public Board parse(String text, Locale locale) throws ParseException {
        String[] split = text.split("|");
        Board board = new Board(Long.parseLong(split[0]), Long.parseLong(split[1]), split[2]);
        return board;
    }

    @Override
    public String print(Board object, Locale locale) {
        return object.getId() + "|" + object.getOrder() + "|" + object.getName();
    }
}
