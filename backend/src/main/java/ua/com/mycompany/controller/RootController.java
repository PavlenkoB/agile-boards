package ua.com.mycompany.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ua.com.mycompany.domain.Board;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@RestController
@RequestMapping("/")
@Slf4j
public class RootController {
    @GetMapping
    public String getMainPage() {
        return "<a href='/swagger-ui.html'>Swagger UI</a>";
    }

    @GetMapping("read/board/{boardId}")
    public Board getPage(@PathVariable("boardId") String boardId) {
        RestTemplate restTemplate = new RestTemplate();

        log.info("Transfer board rest api id=" + boardId);
        Board board = restTemplate.getForObject("http://localhost:8080/api/board/" + boardId, Board.class);
        return board;
    }
}
