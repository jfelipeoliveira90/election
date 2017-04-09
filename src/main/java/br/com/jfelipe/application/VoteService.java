package br.com.jfelipe.application;

import br.com.jfelipe.domain.model.vote.Vote;
import br.com.jfelipe.interfaces.web.v1.vote.dto.VoteDTO;

public interface VoteService {

    Vote vote(VoteDTO vote);
}
