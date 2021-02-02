package com.infoshare.controller;

import com.infoshare.model.ActivityDTO;
import com.infoshare.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ServiceController {

    private final ActivityService activityService;

    @Autowired
    public ServiceController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping("/activity/add")
    public String fillForm(Model model) {
        model.addAttribute("newActivity", new ActivityDTO());
        return "addFormView";
    }

    @PostMapping("/activity/add/send")
    public String saveForm(@Valid @ModelAttribute("newActivity") ActivityDTO activityDTO,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addFormView";
        }

        activityService.addActivity(activityDTO);
        return "addFormSucceedView";
    }
}
