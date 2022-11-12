package com.team.health.dao;

import com.team.health.config.CustomNoOpPasswordEncoder;
import com.team.health.config.DBUtil;
import com.team.health.dto.GetUserResponseDto;
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

    CustomNoOpPasswordEncoder encoder;

    public boolean join(PostUserRequestDto dto){
        boolean flag = false;
        String sql = "INSERT INTO user(name, password, age, rank, phone_number, email, university_id) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            conn = DBUtil.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, encoder.encode(dto.getPassword()));
            pstmt.setString(3, dto.getAge());
            pstmt.setString(4, dto.getPhoneNumber());
            pstmt.setString(5, dto.getEmail());
            pstmt.setInt(6, dto.getUniversityId());

            int rn = pstmt.executeUpdate();
            if(rn == 1)
                flag = true;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return flag;
    }

    public boolean login(GetUserResponseDto dto) {
        String sql = "SELECT password FROM user WHERE name student_id=? and university_id=?";
        boolean flag = false; // 로그인 성공했는 지 확인
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getStudentId());
            pstmt.setInt(2, dto.getUniversityId());
            rs = pstmt.executeQuery();

            if(rs.getString("password")== dto.getPassword()){
                flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return flag;
    }

}
