package com.team.health.controller;

import com.team.health.domain.Board;
import com.team.health.dto.BoardDto;
import com.team.health.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    private BoardDto boardDto;

    @GetMapping("/board")
    public List<Board> findAll() {
        List<Board> boards = boardService.findAll();
        return boards;
    }

    @PostMapping("/board")
    public int save(BoardDto boardDto) {
        int result = boardService.save(boardDto);
        return result;
    }

    @GetMapping("/board/{id}")
    public List<Board> findByUser(@PathVariable int id) {
        boardDto = new BoardDto();
        boardDto.setUser_id(id);
        List<Board> boards = boardService.findByUser(boardDto);
        return boards;
    }

    @DeleteMapping("/board/{id}")
    public int delete(@PathVariable int id) {
        boardDto = new BoardDto();
        boardDto.setBoard_id(id);
        int result = boardService.delete(boardDto);
        return result;
    }
}