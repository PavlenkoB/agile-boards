package ua.com.mycompany.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@Getter
public class RestException extends CustomException {
    private HttpStatus httpStatus;

    public RestException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}
