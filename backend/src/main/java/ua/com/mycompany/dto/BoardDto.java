package ua.com.mycompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto implements Serializable {
    private Long id;
    @NotNull
    @Min(value = 0, message = "Cant be lover zero")
    private Long order;
    @NotNull
    @NotEmpty
    private String name;
}
