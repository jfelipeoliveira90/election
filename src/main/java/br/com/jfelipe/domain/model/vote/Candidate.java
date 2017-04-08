package br.com.jfelipe.domain.model.vote;

import br.com.jfelipe.domain.shared.FullName;
import br.com.jfelipe.domain.shared.Photo;
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
@Table(name = "tb_candidate")
@JsonAutoDetect(fieldVisibility = ANY)
public final class Candidate implements Serializable {
    private static final long serialVersionUID = 805080004572873663L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Embedded
    private FullName fullName;

    @Embedded
    private Photo photo;

    private Candidate() {
        // jpa
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", photo=" + photo +
                '}';
    }
}