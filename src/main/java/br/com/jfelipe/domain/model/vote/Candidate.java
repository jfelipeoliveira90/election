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
import static com.google.common.base.Preconditions.checkNotNull;
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

    @SuppressWarnings("unused")
    private Candidate() {
        // jpa
    }

    private Candidate(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.photo = builder.photo;
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

    public static final class Builder {
        private long id;
        private FullName fullName;
        private Photo photo;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withFullName(FullName fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder withPhoto(Photo photo) {
            this.photo = photo;
            return this;
        }

        public Candidate build() {
            checkNotNull(fullName);
            checkNotNull(photo);

            return new Candidate(this);
        }
    }
}