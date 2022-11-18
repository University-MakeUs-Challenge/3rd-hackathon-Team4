package com.team.health.dto;

import lombok.Getter;

@Getter
public class PatchUserRequestDto {
    private Integer id;
    private String phoneNumber;
    private String email;
}
