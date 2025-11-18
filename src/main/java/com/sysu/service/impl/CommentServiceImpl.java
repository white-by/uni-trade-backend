package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Comment;
import com.sysu.service.CommentService;
import com.sysu.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    public IPage<Comment> getCommentPage(String searchQuery, Integer pageNum, Integer pageSize) {
        // 创建分页对象
        Page<Comment> page = new Page<>(pageNum, pageSize);

        // 调用自定义方法，传入 page 对象
        return commentMapper.selectComment(page, searchQuery);
    }

    @Override
    public boolean deleteComment(Integer commentID) {
        int rows = commentMapper.deleteById(commentID);
        return rows > 0;
    }
}




