package com.team.health.dao;

import com.team.health.config.CustomNoOpPasswordEncoder;
import com.team.health.config.DBUtil;
import com.team.health.dto.GetUserResponseDto;
import com.team.health.dto.PatchUserRequestDto;
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
        String sql = "INSERT INTO user(name, password, age, phone_number, email, university_id) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            conn = DBUtil.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPassword());
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
        String sql = "SELECT password FROM user WHERE student_id= ? and university_id= ?";
        boolean flag = false; // 로그인 성공했는 지 확인
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getStudentId());
            pstmt.setInt(2, dto.getUniversityId());
            rs = pstmt.executeQuery();

            if(rs.next()){
                if(rs.getString("password").contentEquals(dto.getPassword())){
                    flag = true;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt);
        }
        return flag;
    }

    public boolean delete(Integer userId) {
        String sql = "delete from user where user_id=?";
        boolean flag = false;
        try{
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int rn = pstmt.executeUpdate();
            if (rn == 1) {
                flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, pstmt);
        }
        return flag;
    }

    public boolean update(PatchUserRequestDto dto) {
        boolean flag = false;
        String sql = "UPDATE user SET phone_number=?, email=? where user_id=?";

        try{
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPhoneNumber());
            pstmt.setString(2, dto.getEmail());
            pstmt.setInt(3, dto.getId());
            int rn = pstmt.executeUpdate();
            if (rn == 1) {
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
