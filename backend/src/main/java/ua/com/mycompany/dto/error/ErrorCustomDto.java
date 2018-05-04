package ua.com.mycompany.dto.error;

import lombok.*;

import java.io.Serializable;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorCustomDto implements Serializable {
    private String description;
}
