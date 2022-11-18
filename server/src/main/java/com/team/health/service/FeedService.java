package com.team.health.service;

import com.team.health.dao.FeedDao;
import com.team.health.domain.Feed;
import com.team.health.dto.FeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedDao feedDao;
    private int result;

    public List<Feed> findAll() {
        List<Feed> results = feedDao.findAll();
        return results;
    }

    public List<Feed> findByUser(FeedDto feedDto) {
        List<Feed> results = feedDao.findByUser(feedDto);
        return results;
    }

    public int delete(FeedDto feedDto) {
        result = feedDao.delete(feedDto.getFeed_id());
        return result;
    }

    public int save(FeedDto feedDto) {
        result = feedDao.save(feedDto.getUser_id(), feedDto.getContent());
        return result;
    }
}
