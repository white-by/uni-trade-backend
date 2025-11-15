package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sysu.entity.Announcement;
import com.sysu.service.AnnouncementService;
import com.sysu.mapper.AnnouncementMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author whiteby
* @description 针对表【announcement】的数据库操作Service实现
* @createDate 2025-11-15 13:30:08
*/
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService{
    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    public PageInfo<Announcement> getAnnouncementPage(String searchQuery, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<Announcement> wrapper = new QueryWrapper<>();
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            wrapper.like("anTitle", searchQuery);
        }

        List<Announcement> list = announcementMapper.selectList(wrapper);

        return new PageInfo<>(list);
    }

    @Override
    public int addAnnouncement(Announcement announcement) {
        announcement.setAnTime(new Date());  // 当前时间
        announcementMapper.insert(announcement);
        return announcement.getAnnouncementID();
    }

    @Override
    public boolean updateAnnouncement(Announcement announcement) {
        announcement.setAnTime(new Date());  // 当前时间
        int rows = announcementMapper.updateById(announcement);
        return rows > 0;
    }

    @Override
    public boolean deleteAnnouncement(Integer announcementID) {
        int rows = announcementMapper.deleteById(announcementID);
        return rows > 0;
    }
}




