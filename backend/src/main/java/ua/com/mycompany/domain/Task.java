package ua.com.mycompany.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@Getter
@Setter
@Document(collection = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task implements Serializable, Comparable<Task> {
    @Id
    @Field(value = "id")
    private Long id;
    @Field(value = "boardId")
    private Long boardId;
    @Field(value = "name")
    private String name;
    @Field(value = "description")
    private String description;
    @Field(value = "order")
    private Long order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(boardId, task.boardId) &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Task task) {
        if (this.getOrder().equals(task.getOrder())) {
            return 0;
        }
        if (this.getOrder() < task.getOrder()) {
            return -1;
        } else {
            return 1;
        }
    }
}
