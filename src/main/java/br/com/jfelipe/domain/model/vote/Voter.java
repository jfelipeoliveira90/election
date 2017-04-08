package br.com.jfelipe.domain.model.vote;

import br.com.jfelipe.domain.shared.FullName;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_voter")
@JsonAutoDetect(fieldVisibility = ANY)
public final class Voter implements Serializable {
    private static final long serialVersionUID = 1465139602530174562L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Embedded
    private FullName fullName;

    private Voter() {
        // jpa
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return id == voter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", fullName=" + fullName +
                '}';
    }
}