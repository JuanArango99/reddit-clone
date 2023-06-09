package com.example.springredditclone.controller;

import com.example.springredditclone.dto.VoteDto;
import com.example.springredditclone.model.Vote;
import com.example.springredditclone.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/votes/")
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote>  vote(@RequestBody VoteDto voteDto){
        voteService.vote(voteDto);
        return new ResponseEntity<>(OK);
    }



}
