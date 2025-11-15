package com.sysu.mapper;

import com.sysu.entity.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【announcement】的数据库操作Mapper
* @createDate 2025-11-15 13:30:08
* @Entity com.sysu.entity.Announcement
*/
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

}




