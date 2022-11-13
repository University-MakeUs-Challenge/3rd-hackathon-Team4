package com.team.health.controller;

import com.team.health.dto.boardComment.*;
import com.team.health.service.BoardCommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/comments")
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }

    @ResponseBody
    @PostMapping("")
    public PostBoardCommentRes createBoardComment(@RequestBody PostBoardCommentReq postBoardCommentReq){

        if(postBoardCommentReq.getParentCommentId() == null){
            return boardCommentService.createParentBoardComment(postBoardCommentReq);
        }else{
            return boardCommentService.createChildBoardComment(postBoardCommentReq);
        }

    }

    @ResponseBody
    @PatchMapping("/{id}")
    public PatchBoardCommentRes modifyBoardComment(@PathVariable int id, @RequestBody PatchBoardCommentReq patchBoardCommentReq){
        return boardCommentService.modifyBoardComment(patchBoardCommentReq, id);
    }


    @ResponseBody
    @DeleteMapping("/{id}")
    public DeleteBoardCommentRes deleteBoardComment(@PathVariable int id){
        return boardCommentService.deleteBoardComment(id);
    }

    @ResponseBody
    @GetMapping("")
    public List<GetBoardCommentRes> getComments(){
        return boardCommentService.getBoardComments();
    }


}
