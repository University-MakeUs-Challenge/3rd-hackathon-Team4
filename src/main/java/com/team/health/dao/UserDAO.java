package com.team.health.dao;

import com.team.health.config.DBUtil;
import com.team.health.dto.PostUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RequiredArgsConstructor
@Repository
public class UserDAO {
    Connection conn = null;

    PreparedStatement pstmt = null;

    ResultSet rs = null;

    public boolean join(PostUserRequestDto dto){
        boolean flag = false;
        String sql = "INSERT INTO user(name, password, age, rank, phone_number, email, university_id) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            conn = DBUtil.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPassword());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return flag;
    }

}
