package br.com.jfelipe.application.impl;

import br.com.jfelipe.application.VoterService;
import br.com.jfelipe.domain.model.vote.Voter;
import br.com.jfelipe.domain.model.vote.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository repository;

    @Override
    public Voter create(Voter voter) {
        return repository.save(voter);
    }
}
