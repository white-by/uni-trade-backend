package com.sysu.service;

import com.github.pagehelper.PageInfo;
import com.sysu.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【comment】的数据库操作Service
* @createDate 2025-11-15 21:18:58
*/
public interface CommentService extends IService<Comment> {

    PageInfo<Comment> getCommentPage(String searchQuery, Integer pageNum, Integer pageSize);

    boolean deleteComment(Integer commentID);
}
