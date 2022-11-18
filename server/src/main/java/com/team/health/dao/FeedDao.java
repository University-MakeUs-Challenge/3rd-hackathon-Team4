package com.team.health.dao;

import com.team.health.domain.Feed;
import com.team.health.dto.FeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FeedDao {

    private final JdbcTemplate jdbcTemplate;


    public List<Feed> findAll() {
        String findAllQuery = "select * from feed"; // 실행될 동적 쿼리문
        return this.jdbcTemplate.query(findAllQuery,
                (rs, rowNum) -> new Feed(
                        rs.getInt("user_id"),
                        rs.getInt("feed_id"),
                        rs.getString("content"),
                        rs.getString("updated_at"),
                        rs.getString("created_at")
                )
        );
    }

    public List<Feed> findByUser(FeedDto feedDto) {
        String findByUserQuery = "select * from feed where user_id = ?"; // 실행될 동적 쿼리문
        int getParameter = feedDto.getUser_id();
        return this.jdbcTemplate.query(findByUserQuery,
                (rs, rowNum) -> new Feed(
                        rs.getInt("user_id"),
                        rs.getInt("feed_id"),
                        rs.getString("content"),
                        rs.getString("updated_at"),
                        rs.getString("created_at")
                ), getParameter
        );
    }

    @Transactional
    public int delete(int feed_id) {
        String deleteQuery = "delete from feed where feed_id = ?";
        int getParameter = feed_id;
        return this.jdbcTemplate.update(deleteQuery, getParameter);
    }

    public int save(int user_id, String content) {
        return jdbcTemplate.update("insert into feed (content, user_id, created_at, updated_at) values (?, ?, sysdate(), sysdate())", content, user_id);
    }
}
