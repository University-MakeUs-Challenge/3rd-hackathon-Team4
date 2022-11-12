package com.team.health.dto;

import lombok.Getter;

@Getter
public class PostUserRequestDto {
    private String name;
    private String age;
    private String phoneNumber;
    private String email;
    private Integer universityId;
    private String password;
}
