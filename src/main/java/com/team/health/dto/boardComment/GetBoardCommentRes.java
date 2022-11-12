package com.team.health.dto.boardComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class GetBoardCommentRes {
    int commentId;
    String content;
    Integer parentCommentId;
    Integer order;
}
