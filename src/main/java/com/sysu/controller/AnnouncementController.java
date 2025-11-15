package com.sysu.controller;

import com.github.pagehelper.PageInfo;
import com.sysu.common.Result;
import com.sysu.entity.Announcement;
import com.sysu.service.AnnouncementService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AnnouncementController {
    @Resource
    private AnnouncementService announcementService;

    @GetMapping("/admin/announcement")
    public Result getAnnouncement(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageInfo<Announcement> page = announcementService.getAnnouncementPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getPageNum());
        data.put("announcementList", page.getList());

        return Result.success(data);
    }

    @PostMapping("/admin/announcement")
    public Result addAnnouncement(@RequestBody Announcement announcement) {
        int announcementID = announcementService.addAnnouncement(announcement);

        HashMap<String, Object> data = new HashMap<>();
        data.put("announcementID", announcementID);

        return Result.success(data);
    }

    @PutMapping("/admin/announcement/{announcementID}")
    public Result updateAnnouncement(@PathVariable Integer announcementID, @RequestBody Announcement announcement) {
        // 确保实体里的主键正确
        announcement.setAnnouncementID(announcementID);

        boolean ok = announcementService.updateAnnouncement(announcement);
        if (!ok) {
            return Result.error("公告不存在");
        }
        return Result.success();
    }

    @DeleteMapping("/admin/announcement/{announcementID}")
    public Result deleteAnnouncement(@PathVariable Integer announcementID) {
        boolean ok = announcementService.deleteAnnouncement(announcementID);
        if (!ok) {
            return Result.error("公告不存在或已删除");
        }
        return Result.success();
    }
}
