package ua.com.mycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.service.BoardService;

@SpringBootApplication
public class Application implements ApplicationRunner {
    private final BoardService boardService;

    @Autowired
    public Application(BoardService boardService) {
        this.boardService = boardService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        boardService.create(new Board(1L, 0L, "test"));
    }
}
