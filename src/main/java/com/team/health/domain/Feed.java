package com.team.health.domain;

import lombok.Data;

@Data
public class Feed {
    private int user_id, feed_id;
    private String content, updated_at, created_at;

    public Feed() {};

    public Feed(int user_id, int feed_id, String content, String updated_at, String created_at) {
        this.content = content;
        this.feed_id = feed_id;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this. created_at = created_at;
    }
}
