package ua.com.mycompany.dto.error;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto<T extends Serializable> implements Serializable {
    private List<T> errorList = new ArrayList<>();
    private int httpStatus;
    private T object;

    public void addError(T errorCustomDto) {
        errorList.add(errorCustomDto);
    }
}
