package br.com.jfelipe.application.impl;

import br.com.jfelipe.application.VoterService;
import br.com.jfelipe.domain.model.vote.Voter;
import br.com.jfelipe.domain.model.vote.VoterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoterRepository repository;

    @Override
    public Voter create(Voter voter) {
        logger.info("Salvando eleitor na base de dados");

        return repository.save(voter);
    }
}
