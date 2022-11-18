package com.team.health.domain;

import lombok.Data;

@Data
public class Board {
    private int board_id, user_id;
    private String content, updated_at, created_at;

    public Board() {};

    public Board(int board_id, int user_id, String content, String updated_at, String created_at) {
        this.content = content;
        this.user_id = user_id;
        this.updated_at = updated_at;
        this.board_id = board_id;
        this. created_at = created_at;
    }
}
