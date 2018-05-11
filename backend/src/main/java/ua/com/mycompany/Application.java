package ua.com.mycompany;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import ua.com.mycompany.converter.TaskConverter;
import ua.com.mycompany.domain.Board;
import ua.com.mycompany.dto.BoardDto;
import ua.com.mycompany.enums.Colors;
import ua.com.mycompany.enums.Stikers;
import ua.com.mycompany.service.BoardService;

@SpringBootApplication
@Slf4j
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
    public void run(ApplicationArguments args) throws Exception {
        boardService.create(new Board(1L, 0L, "test"));
        this.haveConverter(String.class, Colors.class);
        this.haveConverter(String.class, Stikers.class);
        this.haveConverter(String.class, BoardService.class);
        this.haveConverter(Board.class, BoardDto.class);
        Colors red = this.conversionService.convert("RED", Colors.class);
    }

    private boolean haveConverter(Class src, Class target) {
        boolean canConvert = this.conversionService.canConvert(src, target);
        log.info("Can convert from" + src.getCanonicalName() + " to " + target.getCanonicalName() + ":" + canConvert);
        return canConvert;
    }
}
