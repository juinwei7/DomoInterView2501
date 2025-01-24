package com.weiwei.announcement.controller;

import com.weiwei.announcement.model.AnnouncementVo;
import com.weiwei.announcement.service.AnnouncementService;
import com.weiwei.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // 查看公告頁面
    @GetMapping("/view")
    public String view(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "2") int size,
                       Model model) {
        List<AnnouncementVo> allAnnouncements = announcementService.getAnnouncements();

        if (allAnnouncements.isEmpty()) {
            model.addAttribute("pagination", null);
            model.addAttribute("msg", "目前沒有公告");
            return "announcementView";
        }

        int totalItems = allAnnouncements.size();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }

        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, totalItems);
        List<AnnouncementVo> currentPageItems = allAnnouncements.subList(startIndex, endIndex);
        Pagination<AnnouncementVo> pagination = new Pagination<>(page, size, totalItems, currentPageItems);

        model.addAttribute("pagination", pagination);
        return "announcementView"; // 返回 JSP 頁面名稱
    }

    // 查看公告詳情
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable String id) {
        AnnouncementVo announcementVo = announcementService.getAnnouncement(Integer.parseInt(id));
        model.addAttribute("announcement", announcementVo);
        return "announcementViewOne";
    }

    // 新增公告頁面
    @GetMapping("/create")
    public String create() {
        return "announcementCreate";
    }

    // 新增公告
    @PostMapping("/create")
    public String postCreate(AnnouncementVo announcementVo, Model model) {
        announcementVo.setPublishDate(new Date());
        if (announcementVo.getExpireDate().before(new Date())) {
            model.addAttribute("msg", "時間請勿低於當下時間");
            return "announcementCreate";
        }

        announcementService.insert(announcementVo);
        return "redirect:/announcement/view";
    }

    // 更新公告
    @GetMapping("/edit/{id}")
    public String update(Model model, @PathVariable String id) {
        AnnouncementVo announcementVo = announcementService.getAnnouncement(Integer.parseInt(id));
        model.addAttribute("announcement", announcementVo);
        return "announcementUpdate";
    }

    // 提交更新公告
    @PostMapping("/edit/{id}")
    public String putUpdate(AnnouncementVo announcementVo, @PathVariable String id, Model model) {
        AnnouncementVo announcementVo2 = announcementService.getAnnouncement(Integer.parseInt(id));
        announcementVo.setPublishDate(announcementVo2.getPublishDate());
        if (announcementVo.getExpireDate() == null) {
            model.addAttribute("announcement", announcementVo);
            model.addAttribute("msg", "時間不能為空");
            return "announcementUpdate";
        }

        if (announcementVo.getExpireDate().before(announcementVo2.getPublishDate())) {
            model.addAttribute("announcement", announcementVo);
            model.addAttribute("msg", "時間請高於發布時間");
            return "announcementUpdate";
        }

        announcementService.update(announcementVo);
        return "redirect:/announcement/view";
    }


    // 刪除公告
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        announcementService.delete(Integer.parseInt(id));
        return "redirect:/announcement/view";
    }





}
