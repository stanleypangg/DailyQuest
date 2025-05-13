package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDTO;
import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities")
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

//    @PostMapping
//    public ActivityModel createActivity(@Valid @RequestBody ActivityModel activity) {
//        return activityService.createActivity(activity);
//    }

    @PostMapping
    public ResponseEntity<ActivityModel> createActivity(@Valid @RequestBody ActivityDTO request) {
        ActivityModel activity = activityService.createActivity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(activity);
    }

    @PatchMapping(value = "/{id}")
    public ActivityModel updateActivity(
            @PathVariable(name = "id") Long id,
            @RequestBody ActivityModel requestBody) {
        return activityService.updateActivity(id, requestBody);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteActivity(@PathVariable(name = "id") Long id) {
        activityService.deleteActivity(id);
    }
}