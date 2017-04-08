package br.com.jfelipe.domain.shared;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.hasText;

@Embeddable
@JsonAutoDetect(fieldVisibility = ANY)
public final class Photo implements Serializable {
    private static final long serialVersionUID = 4216581677541765888L;

    @Lob
    @Column(name = "ds_url_photo", length = 512, nullable = false)
    private String url;

    @SuppressWarnings("unused")
    private Photo() {
        this.url = null;
    }

    private Photo(String url) {
        this.url = url;
    }

    public static Photo of(String url) {
        //TODO Validar melhor a URL
        checkArgument(hasText(url));

        return new Photo(url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(url, photo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "url='" + url + '\'' +
                '}';
    }
}