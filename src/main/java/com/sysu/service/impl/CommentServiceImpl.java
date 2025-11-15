package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sysu.entity.Comment;
import com.sysu.service.CommentService;
import com.sysu.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author whiteby
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2025-11-15 21:18:58
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Resource
    private CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> getCommentPage(String searchQuery, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Comment> list = commentMapper.selectComment(searchQuery);

        return new PageInfo<>(list);
    }

    @Override
    public boolean deleteComment(Integer commentID) {
        int rows = commentMapper.deleteById(commentID);
        return rows > 0;
    }
}




