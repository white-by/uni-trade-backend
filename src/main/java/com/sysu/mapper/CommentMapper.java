package com.sysu.mapper;

import com.sysu.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author whiteby
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2025-11-15 21:18:58
* @Entity com.sysu.entity.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectComment(String searchQuery);
}




