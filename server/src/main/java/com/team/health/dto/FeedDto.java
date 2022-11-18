package com.team.health.dto;

import lombok.Data;

@Data
public class FeedDto {
    private int user_id, feed_id;
    String content, updated_at, created_at;

    public FeedDto(int user_id, int feed_id, String content, String updated_at, String created_at) {
        this.user_id = user_id;
        this.feed_id = feed_id;
        this.content = content;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public FeedDto() {}

    public FeedDto(int user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
