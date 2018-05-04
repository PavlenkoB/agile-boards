package ua.com.mycompany.exception;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
public abstract class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
