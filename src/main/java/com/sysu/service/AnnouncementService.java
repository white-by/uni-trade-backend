package com.sysu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【announcement】的数据库操作Service
* @createDate 2025-11-15 13:30:08
*/
public interface AnnouncementService extends IService<Announcement> {

    Page<Announcement> getAnnouncementPage(String searchQuery, Integer pageNum, Integer pageSize);

    int addAnnouncement(Announcement announcement);

    boolean updateAnnouncement(Announcement announcement);

    boolean deleteAnnouncement(Integer announcementID);
}
