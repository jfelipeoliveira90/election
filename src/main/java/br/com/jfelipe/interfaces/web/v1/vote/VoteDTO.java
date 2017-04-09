package br.com.jfelipe.interfaces.web.v1.vote;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class VoteDTO {

    @JsonProperty(value = "candidate-id", required = true)
    private long candidateId;

    @JsonProperty(value = "voter-id", required = true)
    private long voterId;

    @JsonProperty(value = "position-id", required = true)
    private long positionId;

    private VoteDTO() {

    }

    public long getCandidateId() {
        return candidateId;
    }

    public long getVoterId() {
        return voterId;
    }

    public long getPositionId() {
        return positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return candidateId == voteDTO.candidateId &&
                voterId == voteDTO.voterId &&
                positionId == voteDTO.positionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, voterId, positionId);
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "candidateId=" + candidateId +
                ", voterId=" + voterId +
                ", positionId=" + positionId +
                '}';
    }
}
