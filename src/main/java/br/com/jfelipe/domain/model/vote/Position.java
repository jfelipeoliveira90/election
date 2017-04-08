package br.com.jfelipe.domain.model.vote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_position")
public final class Position implements Serializable {
    private static final long serialVersionUID = 4457350522632261569L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Column(name = "ds_description", length = 100, nullable = false)
    private String description;

    private Position() {
        // jpa
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id == position.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
