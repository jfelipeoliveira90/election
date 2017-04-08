package br.com.jfelipe.domain.model.vote;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_vote")
@IdClass(VoteId.class)
public final class Vote implements Serializable {
    private static final long serialVersionUID = -3848472310482259522L;

    @Id
    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Id
    @OneToOne
    @JoinColumn(name = "voter_id")
    private Voter voter;

    @Id
    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;

    private Vote() {
        // jpa
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
