package com.team.health.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BoardComment {
    int commentId;
    String content;
    Integer parentCommentId;
    Integer sequence;
    LocalDateTime creaetedAt;
    LocalDateTime updatedAt;
}
