package br.com.jfelipe.domain.model.vote;


import java.io.Serializable;
import java.util.Objects;

public final class VoteId implements Serializable {
    private static final long serialVersionUID = -7787621258802361862L;

    private long candidate;
    private long voter;
    private long position;

    private VoteId() {

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
