package br.com.jfelipe.application.impl;

import br.com.jfelipe.application.VoteService;
import br.com.jfelipe.domain.model.vote.Vote;
import br.com.jfelipe.domain.model.vote.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote vote(Vote vote) {
        return voteRepository.saveAndFlush(vote);
    }
}
