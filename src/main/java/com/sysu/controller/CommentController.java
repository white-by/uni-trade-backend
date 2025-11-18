package com.sysu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sysu.common.Result;
import com.sysu.entity.Comment;
import com.sysu.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/admin/comment")
    public Result getComment(
      @RequestParam(required = false) String searchQuery,
      @RequestParam(defaultValue = "1") Integer pageNum,
      @RequestParam(defaultValue = "10") Integer pageSize
    ){
        IPage<Comment> page = commentService.getCommentPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("commentList", page.getRecords());

        return Result.success(data);
    }

    @DeleteMapping("/admin/comment/{commentID}")
    public Result deleteComment(@PathVariable Integer commentID){
        boolean ok = commentService.deleteComment(commentID);
        if (!ok) {
            return Result.error("评论不存在或已删除");
        }
        return Result.success();
    }
}
