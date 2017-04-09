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
import static com.google.common.base.Preconditions.checkNotNull;
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

    @SuppressWarnings("unused")
    private Voter() {
        // jpa
    }

    private Voter(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
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

    public static final class Builder {
        private long id;
        private FullName fullName;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withFullName(FullName fullName) {
            this.fullName = fullName;
            return this;
        }

        public Voter build() {
            checkNotNull(this.fullName);

            return new Voter(this);
        }
    }
}