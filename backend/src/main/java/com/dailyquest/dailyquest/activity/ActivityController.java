package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDto;
import com.dailyquest.dailyquest.activity.dto.CreateActivityDTO;
import com.dailyquest.dailyquest.activity.dto.UpdateActivityDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/activities")
@Validated
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
        ActivityDto activity = activityService.createActivity(request, userDetails.getUsername());
        URI location = URI.create("/api/activities" + activity.id());
        return ResponseEntity.created(location).body(activity);
    }

    @PatchMapping(value = "/{id}")
    public ActivityModel updateActivity(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody UpdateActivityDTO requestBody,
            @AuthenticationPrincipal UserDetails userDetails) {
        return activityService.updateActivity(id, requestBody, userDetails.getUsername());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable(name = "id") Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }
}