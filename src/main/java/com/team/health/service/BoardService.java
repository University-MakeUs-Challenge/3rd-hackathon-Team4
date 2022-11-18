package com.team.health.service;

import com.team.health.dao.BoardDao;
import com.team.health.domain.Board;
import com.team.health.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardDao boardDao;
    private int result;

    public List<Board> findAll() {
        List<Board> results = boardDao.findAll();
        return results;
    }

    public List<Board> findByUser(BoardDto BoardDto) {
        List<Board> results = boardDao.findByUser(BoardDto);
        return results;
    }

    public int delete(BoardDto BoardDto) {
        result = boardDao.delete(BoardDto.getBoard_id());
        return result;
    }

    public int save(BoardDto BoardDto) {
        result = boardDao.save(BoardDto.getUser_id(), BoardDto.getContent());
        return result;
    }
}
