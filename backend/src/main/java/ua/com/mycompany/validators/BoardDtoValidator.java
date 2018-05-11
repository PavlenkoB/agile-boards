package ua.com.mycompany.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import ua.com.mycompany.dto.BoardDto;

public class BoardDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BoardDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "order", "order.empty");
        BoardDto board = (BoardDto) target;
        if (board.getName().length() < 1) {
            errors.rejectValue("name", "Name cant be empty");
        } else if (board.getOrder() < 0) {
            errors.rejectValue("order", "Order cant be lover zero");
        }
        //todo add checkers
    }
}
