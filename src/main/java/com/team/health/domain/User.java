package com.team.health.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
public class User {
    @Id
    @Column("user_id")
    private Integer userId;

    private String name;

    private String password; // Hashed Value

    private Integer age;

    private Rank rank = Rank.BRONZE;

    private String phoneNumber;

    private String email;

    private LocalDateTime createdAt;

    private Integer universityId;
}
