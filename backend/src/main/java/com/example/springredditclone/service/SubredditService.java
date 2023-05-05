package com.example.springredditclone.service;

import com.example.springredditclone.dto.SubredditDto;
import com.example.springredditclone.model.Subreddit;
import com.example.springredditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService
{
    private final SubredditRepository subredditRepository;

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return  subredditRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(mapSubredditDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional
    private Subreddit mapSubredditDto(SubredditDto subredditDto){
        return Subreddit.builder().name(subredditDto.getName())
                .description(subredditDto.getDescription())
                .build();
    }

     private SubredditDto mapToDto(Subreddit subreddit) {
        return SubredditDto.builder().name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPost(subreddit.getPosts().size())
                .build();
    }



}

