package com.team.health.controller;

import com.team.health.dao.UserDAO;
import com.team.health.dto.GetUserResponseDto;
import com.team.health.dto.PatchUserRequestDto;
import com.team.health.dto.PostUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserDAO userDAO;

    @PostMapping("/user")
    public ResponseEntity<Boolean> join(@RequestBody PostUserRequestDto dto) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(userDAO.join(dto), header, HttpStatus.CREATED);
    } // 1이면 회원가입 성공

    @GetMapping("/user")
    public ResponseEntity<Boolean> login(@RequestBody GetUserResponseDto dto){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(userDAO.login(dto), header, HttpStatus.OK);
    } // 1이면 로그인 성공

    @PatchMapping("/user")
    public ResponseEntity<Boolean> update(@RequestBody PatchUserRequestDto dto){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(userDAO.update(dto), header, HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Boolean> delete(@RequestParam Integer userId){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return new ResponseEntity<>(userDAO.delete(userId), header, HttpStatus.OK);
    }
}
