package com.team.health.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class User {
    @Id
    private Integer userId;
}
