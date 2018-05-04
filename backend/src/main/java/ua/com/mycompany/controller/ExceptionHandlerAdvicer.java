package ua.com.mycompany.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.mycompany.dto.error.ErrorCustomDto;
import ua.com.mycompany.dto.error.ErrorDto;
import ua.com.mycompany.exception.RestException;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvicer {

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> accessDeniedExceptionHandler(RestException ex) {
        log.error(ex.getMessage(), ex);
        ErrorDto<ErrorCustomDto> errorDto = new ErrorDto<>();
        errorDto.setHttpStatus(ex.getHttpStatus().value());
        errorDto.addError(new ErrorCustomDto("Error: " + ex.getMessage()));
        return new ResponseEntity<ErrorDto>(errorDto, ex.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> generalExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        ErrorDto<ErrorCustomDto> errorDto = new ErrorDto<>();
        errorDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.addError(new ErrorCustomDto("Something went wrong " + ex.getMessage()));
        return new ResponseEntity<ErrorDto>(
                errorDto,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
