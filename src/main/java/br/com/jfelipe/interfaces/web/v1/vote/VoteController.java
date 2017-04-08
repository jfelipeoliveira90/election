package br.com.jfelipe.interfaces.web.v1.vote;

import br.com.jfelipe.application.VoteService;
import br.com.jfelipe.domain.model.vote.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("v1/votes")
public final class VoteController {

    @Autowired
    private VoteService service;

    @RequestMapping(method = POST)
    public ResponseEntity<Vote> vote(@RequestBody Vote vote) {
        return ResponseEntity
                .status(CREATED)
                .body(service.vote(vote));
    }
}
