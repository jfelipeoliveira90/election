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
    public Vote vote(Vote vote) {
        long voterId = vote.getVoter().getId();
        long candidateId = vote.getCandidate().getId();
        long positionId = vote.getPosition().getId();

        Voter voter = voterRepository.findOne(voterId);
        Candidate candidate = candidateRepository.findOne(candidateId);
        Position position = positionRepository.findOne(positionId);

        vote.setVoter(voter);
        vote.setCandidate(candidate);
        vote.setPosition(position);

        return voteRepository.saveAndFlush(vote);
    }
}
