package br.com.jfelipe.domain.model.vote;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Entity
@Table(name = "tb_vote")
@IdClass(VoteId.class)
@JsonAutoDetect(fieldVisibility = ANY)
public final class Vote implements Serializable {
    private static final long serialVersionUID = -3848472310482259522L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_candidate")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_voter")
    private Voter voter;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;

    private Vote() {
        // jpa
    }

    // TODO mover GETs e SETs para design patterns builder
    public Candidate getCandidate() {
        return candidate;
    }

    public Voter getVoter() {
        return voter;
    }

    public Position getPosition() {
        return position;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(candidate, vote.candidate) &&
                Objects.equals(voter, vote.voter) &&
                Objects.equals(position, vote.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, voter, position);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "candidate=" + candidate +
                ", voter=" + voter +
                ", position=" + position +
                '}';
    }
}
