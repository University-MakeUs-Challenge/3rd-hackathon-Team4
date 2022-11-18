package com.team.health.controller;

import com.team.health.domain.Feed;
import com.team.health.dto.FeedDto;
import com.team.health.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FeedController {
    private final FeedService feedService;
    private FeedDto feedDto;

    @GetMapping("/feed")
    public List<Feed> findAll() {
        List<Feed> feeds = feedService.findAll();
        return feeds;
    }

    @PostMapping("/feed")
    public int save(FeedDto feedDto) {
        int result = feedService.save(feedDto);
        return result;
    }

    @GetMapping("/feed/{id}")
    public List<Feed> findByUser(@PathVariable int id) {
        feedDto = new FeedDto();
        feedDto.setUser_id(id);
        List<Feed> feeds = feedService.findByUser(feedDto);
        return feeds;
    }

    @DeleteMapping("/feed/{id}")
    public int delete(@PathVariable int id) {
        feedDto = new FeedDto();
        feedDto.setFeed_id(id);
        int result = feedService.delete(feedDto);
        return result;
    }
}
