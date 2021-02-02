package com.infoshare.controller;

import com.infoshare.model.ActivityDTO;
import com.infoshare.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final ActivityService activityService;

    @Autowired
    public IndexController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        List<ActivityDTO> allActivities = activityService.getAllActivities();

        if (allActivities.isEmpty()) {
            String info = "Unfortunately there's no activities on the list...";
            model.addAttribute("empty-info", info);
            return "emptyListView";
        } else {
            model.addAttribute("activities", allActivities);
            return "index";
        }

    }
}
