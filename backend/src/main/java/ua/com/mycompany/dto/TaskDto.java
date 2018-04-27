package ua.com.mycompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class TaskDto implements Serializable {
    private Long id;
    private Long boardId;
    private String name;
    private String description;
}
