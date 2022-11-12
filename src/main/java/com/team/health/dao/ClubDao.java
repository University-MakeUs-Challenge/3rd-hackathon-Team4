package com.team.health.dao;

import com.team.health.BaseException;
import com.team.health.dto.GetClubAllowRes;
import com.team.health.dto.GetClubRes;
import com.team.health.dto.PostClubApplyReq;
import com.team.health.dto.PostClubReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ClubDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //createClub
    public int createClub(PostClubReq postClubReq) {
        String createClubQuery = "insert into Club (name, total,  place, description ,time, user_id) VALUES (?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createClubParams = new Object[]{postClubReq.getName(), postClubReq.getTotal(), postClubReq.getPlace(),postClubReq.getDescription(), postClubReq.getTime(), postClubReq.getUserId()}; // 동적 쿼리의 ?부분에 주입될 값
        this.jdbcTemplate.update(createClubQuery, createClubParams);
        // email -> postUserReq.getEmail(), password -> postUserReq.getPassword(), nickname -> postUserReq.getNickname() 로 매핑(대응)시킨다음 쿼리문을 실행한다.
        // 즉 DB의 User Table에 (email, password, nickname)값을 가지는 유저 데이터를 삽입(생성)한다.

        String lastInserIdQuery = "select last_insert_id()"; // 가장 마지막에 삽입된(생성된) id값은 가져온다.
        return this.jdbcTemplate.queryForObject(lastInserIdQuery, int.class); // 해당 쿼리문의 결과 마지막으로 삽인된 유저의 userIdx번호를 반환한다.
    }
    public List<GetClubRes> getClub() {
        String getclubQuery = "select * from club"; //User 테이블에 존재하는 모든 회원들의 정보를 조회하는 쿼리
        return this.jdbcTemplate.query(getclubQuery,
                (rs, rowNum) -> new GetClubRes(
                        rs.getInt("club_id"),
                        rs.getString("name"),
                        rs.getInt("total"),
                        rs.getString("place"),
                        rs.getString("description"),
                        rs.getString("time"),
                        rs.getInt("user_Id"))
        ); // 복수개의 회원정보들을 얻기 위해 jdbcTemplate 함수(Query, 객체 매핑 정보)의 결과 반환(동적쿼리가 아니므로 Parmas부분이 없음)
    }
    public int createApply(PostClubApplyReq postClubApplyReq) {
        String createApplyQuery = "insert into reservation (club_id, user_id) VALUES (?,?)"; // 실행될 동적 쿼리문
        Object[] createApplyParams = new Object[]{postClubApplyReq.getClubId(), postClubApplyReq.getUsrId()}; // 동적 쿼리의 ?부분에 주입될 값
        this.jdbcTemplate.update(createApplyQuery, createApplyParams);
        // email -> postUserReq.getEmail(), password -> postUserReq.getPassword(), nickname -> postUserReq.getNickname() 로 매핑(대응)시킨다음 쿼리문을 실행한다.
        // 즉 DB의 User Table에 (email, password, nickname)값을 가지는 유저 데이터를 삽입(생성)한다.

        String lastInserIdQuery = "select last_insert_id()"; // 가장 마지막에 삽입된(생성된) id값은 가져온다.
        return this.jdbcTemplate.queryForObject(lastInserIdQuery, int.class); // 해당 쿼리문의 결과 마지막으로 삽인된 유저의 userIdx번호를 반환한다.
    }

    public List<GetClubAllowRes> getAllowClub(int clubId) {
        String getclubQuery = "select * from reservation WHERE is_allowed == true && club_id = ?"; //User 테이블에 존재하는 모든 회원들의 정보를 조회하는 쿼리
        return this.jdbcTemplate.query(getclubQuery,
                (rs, rowNum) -> new GetClubAllowRes(
                        rs.getInt("reservationId")
                ),
                clubId
        ); // 복수개의 회원정보들을 얻기 위해 jdbcTemplate 함수(Query, 객체 매핑 정보)의 결과 반환(동적쿼리가 아니므로 Parmas부분이 없음)
    }

}
