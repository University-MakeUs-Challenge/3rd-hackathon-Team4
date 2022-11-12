package com.team.health.service;

import com.team.health.BaseException;
import com.team.health.dao.ClubDao;
import com.team.health.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.team.health.BaseResponseStatus.DATABASE_ERROR;

@Service
public class ClubService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ClubDao clubDao = null;

    public ClubService(ClubDao clubDao) {
        this.clubDao = clubDao;
    }
    //club 생성
    public static PostClubRes createClub(PostClubReq postClubReq) /*throws BaseException */{
        //try {
            int userIdx = clubDao.createClub(postClubReq);
            return new PostClubRes(userIdx);
      //} catch (Exception exception) { // DB에 이상이 있는 경우 에러 메시지를 보냅니다.
        //    throw new BaseException(DATABASE_ERROR);
       // }
    }
    public List<GetClubRes> getClub() {

            List<GetClubRes> getClubRes = clubDao.getClub();
            return getClubRes;

    }
    public static PostClubApplyRes createClubApply(PostClubApplyReq postClubApplyReq) /*throws BaseException */{
        //try {
        int clubIdx = clubDao.createApply(postClubApplyReq);
        return new PostClubApplyRes(clubIdx);
        //} catch (Exception exception) { // DB에 이상이 있는 경우 에러 메시지를 보냅니다.
        //    throw new BaseException(DATABASE_ERROR);
        // }
    }
    public List<GetClubAllowRes> getAllowClub(int clubId) {

        List<GetClubAllowRes> getClubAllowRes = clubDao.getAllowClub(clubId);
        return getClubAllowRes;

    }

}
