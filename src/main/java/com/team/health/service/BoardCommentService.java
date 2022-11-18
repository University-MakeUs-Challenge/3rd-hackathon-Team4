package com.team.health.service;


import com.team.health.dao.BoardCommentDao;
import com.team.health.domain.BoardComment;
import com.team.health.dto.boardComment.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentService {
    private final BoardCommentDao boardCommentDao;

    public BoardCommentService(BoardCommentDao boardCommentDao) {
        this.boardCommentDao = boardCommentDao;
    }

    // 부모 댓글 생성
    public PostBoardCommentRes createParentBoardComment(PostBoardCommentReq postBoardCommentReq){
        return new PostBoardCommentRes(boardCommentDao.createParentBoardComment(postBoardCommentReq));
    }

    // 자식 댓글 생성
    public PostBoardCommentRes createChildBoardComment(PostBoardCommentReq postBoardCommentReq){
        return new PostBoardCommentRes(boardCommentDao.createChildBoardComment(postBoardCommentReq));
    }
    // 수정
    public PatchBoardCommentRes modifyBoardComment(PatchBoardCommentReq patchBoardCommentReq, int id){
        return boardCommentDao.modifyBoardComment(patchBoardCommentReq, id);
    }

    // 삭제
    public DeleteBoardCommentRes deleteBoardComment(int id){
        BoardComment findBoardComment = boardCommentDao.getComment(id);
        if(findBoardComment.getParentCommentId() == 0){// 부모면 자식까지 삭제
            boardCommentDao.deleteChildBoardComment(id);
        }

        return new DeleteBoardCommentRes(boardCommentDao.deleteOneBoardComment(id));
    }

    // 조회
    public List<GetBoardCommentRes> getBoardComments(){
        return boardCommentDao.getBoardComments();
    }
}