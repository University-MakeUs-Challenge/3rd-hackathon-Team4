package com.team.health.dto.boardComment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostBoardCommentReq {
    String content;
    Integer parentCommentId;
    Integer order;
    int boardId;
    int userId;
}
