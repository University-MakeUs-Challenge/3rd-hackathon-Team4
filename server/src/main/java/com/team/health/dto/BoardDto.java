package com.team.health.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int user_id, board_id;
    String content, updated_at, created_at;

    public BoardDto(int user_id, int board_id, String content, String updated_at, String created_at) {
        this.user_id = user_id;
        this.board_id = board_id;
        this.content = content;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public BoardDto() {}

    public BoardDto(int user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
