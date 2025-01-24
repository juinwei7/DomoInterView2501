package com.weiwei.announcement.service;

import com.weiwei.announcement.model.AnnouncementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementDAO announcementDAO;

    // 獲取所有公告
    public List<AnnouncementVo> getAnnouncements() {
        return announcementDAO.getAnnouncements();
    }

    // 獲取指定公告
    public AnnouncementVo getAnnouncement(int id) {
        return announcementDAO.getAnnouncement(id);
    }

    // 新增公告
    public void insert(AnnouncementVo announcementVo) {
        announcementDAO.insert(announcementVo);
    }

    // 更新公告
    public void update(AnnouncementVo announcementVo) {
        announcementDAO.update(announcementVo);
    }

    // 刪除公告
    public void delete(Integer id) {
        announcementDAO.delete(id);
    }
}
