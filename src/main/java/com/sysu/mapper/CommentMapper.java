package com.sysu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author whiteby
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2025-11-15 21:18:58
* @Entity com.sysu.entity.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    // 返回 IPage 类型，第一个参数必须是 Page 类型
    IPage<Comment> selectComment(Page<Comment> page, @Param("searchQuery") String searchQuery);
}




