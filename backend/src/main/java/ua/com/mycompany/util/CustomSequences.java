package ua.com.mycompany.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Creator: Pavlenko Bohdan
 * Date: 04.05.2018
 * Project: agile-boards
 */
@Document(collection = "customSequences")
@Getter
@Setter
public class CustomSequences {
    @Id
    private String id;
    private int seq;
}
