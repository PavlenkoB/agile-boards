package ua.com.mycompany.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
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
@Document(collection = "boards")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeAlias("Board")
public class Board implements Serializable, Comparable<Board> {
    @Id
    @Field(value = "id")
    private Long id;

    @Field(value = "order")
    private Long order;

    @Field(value = "name")
    private String name;

    @Field
    @Version
    private Long version;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(id, board.id) &&
                Objects.equals(name, board.name) &&
                Objects.equals(order, board.order);
    }

    @Override
    public int compareTo(Board board) {
        if (this.getOrder().equals(board.getOrder())) {
            return 0;
        }
        if (this.getOrder() < board.getOrder()) {
            return -1;
        } else {
            return 1;
        }
    }
}
