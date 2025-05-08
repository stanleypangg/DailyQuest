package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepo activityRepo;

    @Autowired
    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public List<ActivityModel> findAll() {
        return activityRepo.findAll();
    }

    public ActivityModel createActivity(ActivityModel activity) {
        return activityRepo.save(activity);
    }

    public ActivityModel updateActivity(Long id) {
        boolean exists = activityRepo.existsById(id);
        if (!exists) {
            throw new ActivityDoesNotExistException(id);
        }
        return activityRepo.save(activityRepo.findById(id));
    }

    public void deleteActivity(Long id) {
        if (!activityRepo.existsById(id)) {
            throw new ActivityDoesNotExistException(id);
        }
        activityRepo.deleteById(id);
    }
}
