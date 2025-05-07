package com.dailyquest.dailyquest.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityModel> findAll() {
        return activityService.findAll();
    }

    @PostMapping
    public ActivityModel createActivity(@RequestBody ActivityModel activity) {
        return activityService.createActivity(activity);
    }








}
