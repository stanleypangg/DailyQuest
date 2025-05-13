package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDto;
import com.dailyquest.dailyquest.activity.dto.CreateActivityDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<ActivityDto> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        return activityService.findAll(userDetails.getUsername());
    }

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(
            @Valid @RequestBody CreateActivityDTO request,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        // TODO: change getUsername to getId
        ActivityDto activity = activityService.createActivity(request, userDetails.getUsername());
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