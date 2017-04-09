package br.com.jfelipe.application.impl;

import br.com.jfelipe.application.VoteService;
import br.com.jfelipe.domain.model.vote.Candidate;
import br.com.jfelipe.domain.model.vote.CandidateRepository;
import br.com.jfelipe.domain.model.vote.Position;
import br.com.jfelipe.domain.model.vote.PositionRepository;
import br.com.jfelipe.domain.model.vote.Vote;
import br.com.jfelipe.domain.model.vote.VoteRepository;
import br.com.jfelipe.domain.model.vote.Voter;
import br.com.jfelipe.domain.model.vote.VoterRepository;
import br.com.jfelipe.interfaces.web.v1.vote.VoteDTO;
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
    public Vote vote(VoteDTO voteDTO) {
        Candidate candidate = candidateRepository.findOne(voteDTO.getCandidateId());
        Voter voter = voterRepository.findOne(voteDTO.getVoterId());
        Position position = positionRepository.findOne(voteDTO.getPositionId());

        Vote vote = new Vote.Builder()
                .withCandidate(candidate)
                .withVoter(voter)
                .withPosition(position)
                .build();

        return voteRepository.saveAndFlush(vote);
    }
}
