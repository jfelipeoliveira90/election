package br.com.jfelipe.domain.shared;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@Embeddable
@JsonAutoDetect(fieldVisibility = ANY)
public final class FullName implements Serializable {
    private static final long serialVersionUID = -5525939606488141987L;

    @Column(name = "ds_name", length = 50, nullable = false)
    private String name;

    @Column(name = "ds_lastname", length = 50, nullable = false)
    private String lastName;

    @SuppressWarnings("unused")
    private FullName() {

    }

    private FullName(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public static FullName of(String name, String lastName) {
        checkArgument(hasText(name), "Name is mandatory");
        checkArgument(hasText(lastName), "Last name is mandatory");

        return new FullName(name, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(name, fullName.name) &&
                Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}