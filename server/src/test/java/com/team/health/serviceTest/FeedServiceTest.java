package com.team.health.serviceTest;

import com.team.health.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class FeedServiceTest {
    @Autowired
    FeedService feedService;
}
