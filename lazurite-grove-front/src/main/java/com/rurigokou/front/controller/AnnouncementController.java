package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.AnnouncementEntity;
import com.rurigokou.front.service.AnnouncementService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 公告表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/announcement")
public class AnnouncementController {

    @Resource(name = "announcementService")
    private AnnouncementService announcementService;

    @GetMapping("top")
    public List<String> getTop() {
        return announcementService.getTop();
    }

    @GetMapping("localData")
    public Map<String, Long> getLocalData() {
        return announcementService.getLocalData();
    }
}
