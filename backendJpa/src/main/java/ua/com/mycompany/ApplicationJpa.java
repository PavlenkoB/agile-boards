package ua.com.mycompany;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ApplicationJpa {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationJpa.class, args);
    }

}
