package ua.com.mycompany;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.service.BoardService;

@SpringBootApplication
@Slf4j
@Api(description = "Main Run")
public class Application implements ApplicationRunner {
    private final BoardService boardService;
    private final ConversionService conversionService;

    @Autowired
    public Application(BoardService boardService, ConversionService conversionService) {
        this.boardService = boardService;
        this.conversionService = conversionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        boardService.create(new Board(null, 0L, "test", null));
        boardService.create(new Board(null, 0L, "test2", null));
    }
}
