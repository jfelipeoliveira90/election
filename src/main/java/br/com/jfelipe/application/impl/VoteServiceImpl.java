package br.com.jfelipe.application.impl;

import br.com.jfelipe.application.VoteService;
import br.com.jfelipe.domain.model.vote.CandidateRepository;
import br.com.jfelipe.domain.model.vote.PositionRepository;
import br.com.jfelipe.domain.model.vote.Vote;
import br.com.jfelipe.domain.model.vote.VoteRepository;
import br.com.jfelipe.domain.model.vote.VoterRepository;
import br.com.jfelipe.interfaces.web.v1.vote.dto.VoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Vote vote(VoteDTO vote) {
        return voteRepository.saveAndFlush(null);
    }
}
