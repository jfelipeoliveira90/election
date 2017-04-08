package br.com.jfelipe.domain.model.vote;


import java.io.Serializable;
import java.util.Objects;

public final class VoteId implements Serializable {
    private static final long serialVersionUID = -7787621258802361862L;

    private final long candidate;
    private final long voter;
    private final long position;

    @SuppressWarnings("unused")
    private VoteId() {
        this.candidate = 0L;
        this.voter = 0L;
        this.position = 0L;
    }

    private VoteId(long candidate, long voter, long position) {
        this.candidate = candidate;
        this.voter = voter;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteId voteId = (VoteId) o;
        return candidate == voteId.candidate &&
                voter == voteId.voter &&
                position == voteId.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, voter, position);
    }

    @Override
    public String toString() {
        return "VoteId{" +
                "candidate=" + candidate +
                ", voter=" + voter +
                ", position=" + position +
                '}';
    }
}
