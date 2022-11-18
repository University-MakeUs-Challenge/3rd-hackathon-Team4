package com.team.health.dao;

import com.team.health.domain.BoardComment;
import com.team.health.dto.boardComment.GetBoardCommentRes;
import com.team.health.dto.boardComment.PatchBoardCommentReq;
import com.team.health.dto.boardComment.PatchBoardCommentRes;
import com.team.health.dto.boardComment.PostBoardCommentReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardCommentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 부모 댓글 생성
    public int createParentBoardComment(PostBoardCommentReq postBoardCommentReq){
        String createParentBoardCommentQuery = "insert into boardcomment (content, board_id, user_id) values(?, ?, ?)";
        Object[] createParentBoardCommentParams = new Object[]{
                postBoardCommentReq.getContent(),
                postBoardCommentReq.getBoardId(),
                postBoardCommentReq.getUserId()
        };
        this.jdbcTemplate.update(createParentBoardCommentQuery, createParentBoardCommentParams);

        String lastInsertQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertQuery, int.class);
    }

    // 자식 댓글 생성
    public int createChildBoardComment(PostBoardCommentReq postBoardCommentReq){
        String createChildBoardCommentQuery = "insert into boardcomment (content, parent_comment_id, sequence, board_id, user_id) values(?, ?, ?, ?, ?)";
        Object[] createChildBoardCommentParams = new Object[]{
                postBoardCommentReq.getContent(),
                postBoardCommentReq.getParentCommentId(),
                postBoardCommentReq.getOrder(),
                postBoardCommentReq.getBoardId(),
                postBoardCommentReq.getUserId()
        };
        this.jdbcTemplate.update(createChildBoardCommentQuery, createChildBoardCommentParams);

        String lastInsertQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertQuery, int.class);
    }

    // 조회
    public List<GetBoardCommentRes> getBoardComments(){
        String getBoardCommentsQuery = "select * from boardcomment";
        return this.jdbcTemplate.query(getBoardCommentsQuery,
                (rs, rowNum) -> new GetBoardCommentRes(
                        rs.getInt("comment_id"),
                        rs.getString("content"),
                        rs.getInt("parent_comment_id"),
                        rs.getInt("sequence")
                ));
    }

    // 삭제
    public int deleteOneBoardComment(int commentId){
        String deleteOneBoardCommentQuery = "delete from boardcomment where comment_id = ?";
        int deleteOneBoardCommentParams = commentId;

        int result = this.jdbcTemplate.update(deleteOneBoardCommentQuery, deleteOneBoardCommentParams);
        if(result == 1){
            return commentId;
        }else{
            // exception 삭제 실패
            return 0;
        }
    }

    // 자식 댓글 삭제
    public void deleteChildBoardComment(int parentCommentId){
        String deleteChildBoardCommentQuery = "delete from boardcomment where parent_comment_id = ?";
        int deleteChildBoardCommentParams = parentCommentId;

        int result = this.jdbcTemplate.update(deleteChildBoardCommentQuery, deleteChildBoardCommentParams);

        if(result >= 1){ // 성공
        }else{
            // exception 삭제 실패
        }
    }



    // 수정
    public PatchBoardCommentRes modifyBoardComment(PatchBoardCommentReq patchBoardCommentReq, int id){
        String modifyBoardCommentQuery = "update boardcomment set content = ? where comment_id = ?";
        Object[] modifyBoardCommentParams = new Object[] {patchBoardCommentReq.getContent(), id};

        int result = this.jdbcTemplate.update(modifyBoardCommentQuery, modifyBoardCommentParams); // 성공 1, 실패 0

        return new PatchBoardCommentRes(id);
    }

    // commentId로 1개 댓글 조회
    public BoardComment getComment(int id){
        String getCommentQuery = "select * from boardcomment where comment_id = ?";
        int getCommentParams = id;

        return this.jdbcTemplate.queryForObject(getCommentQuery,
                (rs, rowNum) -> new BoardComment(
                        rs.getInt("comment_id"),
                        rs.getString("content"),
                        rs.getInt("parent_comment_id"),
                        rs.getInt("sequence"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ),
                getCommentParams);
    }

}