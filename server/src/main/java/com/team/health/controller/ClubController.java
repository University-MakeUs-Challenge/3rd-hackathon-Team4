package com.team.health.controller;

import com.team.health.BaseResponse;
import com.team.health.dto.*;
import com.team.health.service.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @ResponseBody
    @PostMapping("/club-create")    // POST 방식의 요청을 매핑하기 위한 어노테이션
    public BaseResponse<PostClubRes> createUser(@RequestBody PostClubReq postClubReq) {
        PostClubRes postClubRes = clubService.createClub(postClubReq);
        return new BaseResponse<>(postClubRes);
    }

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetClubRes>> getClub(@RequestParam(required = false) String nickname) {
        List<GetClubRes> getClubRes = null;
        if (nickname == null) {
            getClubRes = clubService.getClub();
            return new BaseResponse<>(getClubRes);
        }
        return new BaseResponse<>(getClubRes);
    }

    @ResponseBody
    @PostMapping("/clubApply-create")    // POST 방식의 요청을 매핑하기 위한 어노테이션
    public BaseResponse<PostClubApplyRes> createClubApply(@RequestBody PostClubApplyReq postClubApplyReq) {
        PostClubApplyRes postClubApplyRes = clubService.createClubApply(postClubApplyReq);
        return new BaseResponse<>(postClubApplyRes);
    }

    @ResponseBody
    @GetMapping("/allow")
    public BaseResponse<List<GetClubAllowRes>> getAllowClub(@RequestParam(required = false) int reservationId) {
        List<GetClubAllowRes> getClubAllowRes = null;
        if (reservationId != 0) {
            getClubAllowRes = clubService.getAllowClub(reservationId);
            return new BaseResponse<>(getClubAllowRes);
        }
        return new BaseResponse<>(getClubAllowRes);
    }

}
