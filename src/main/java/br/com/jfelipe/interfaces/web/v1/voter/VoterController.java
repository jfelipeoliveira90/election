package br.com.jfelipe.interfaces.web.v1.voter;

import br.com.jfelipe.application.VoterService;
import br.com.jfelipe.domain.model.vote.Voter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("v1/voters")
public class VoterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoterService service;

    //TODO Impl HATEOAS
    @RequestMapping(method = POST)
    public ResponseEntity<Voter> create(@RequestBody Voter voter) {
        logger.info("Iniciando fluxo para criar o eleitor {}", voter);

        return ResponseEntity
                .status(CREATED)
                .body(service.create(voter));
    }
}
