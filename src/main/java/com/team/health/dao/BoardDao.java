package com.team.health.dao;

import com.team.health.domain.Board;
import com.team.health.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;


    public List<Board> findAll() {
        String findAllQuery = "select * from board"; // 실행될 동적 쿼리문
        return this.jdbcTemplate.query(findAllQuery,
                (rs, rowNum) -> new Board(
                        rs.getInt("board_id"),
                        rs.getInt("user_id"),
                        rs.getString("content"),
                        rs.getString("updated_at"),
                        rs.getString("created_at")
                )
        );
    }

    public List<Board> findByUser(BoardDto BoardDto) {
        String findByUserQuery = "select * from board where user_id = ?"; // 실행될 동적 쿼리문
        int getParameter = BoardDto.getUser_id();
        return this.jdbcTemplate.query(findByUserQuery,
                (rs, rowNum) -> new Board(
                        rs.getInt("board_id"),
                        rs.getInt("user_id"),
                        rs.getString("content"),
                        rs.getString("updated_at"),
                        rs.getString("created_at")
                ), getParameter
        );
    }

    @Transactional
    public int delete(int board_id) {
        String deleteQuery = "delete from Board where board_id = ?";
        int getParameter = board_id;
        return this.jdbcTemplate.update(deleteQuery, getParameter);
    }

    public int save(int user_id, String content) {
        return jdbcTemplate.update("insert into Board (content, user_id, created_at, updated_at) values (?, ?, sysdate(), sysdate())", content, user_id);
    }
}
