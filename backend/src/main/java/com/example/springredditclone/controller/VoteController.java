package com.example.springredditclone.controller;

import com.example.springredditclone.model.Vote;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@RequestMapping("/api/votes/")
public class VoteController {

    @PostMapping
    public ResponseEntity<Vote>  vote(@ResponseBody VoteDto voteDto){
        
    }



}
