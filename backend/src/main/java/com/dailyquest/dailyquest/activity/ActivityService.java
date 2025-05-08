package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public ActivityModel updateActivity(Long id, ActivityModel requestBody) {
        ActivityModel activityModel = activityRepo.findById(id).orElseThrow(
                () -> new ActivityDoesNotExistException(id)
        );

        if (requestBody.getTitle() != null)
            activityModel.setTitle(requestBody.getTitle());

        if (requestBody.getLogDate() != null)
            activityModel.setLogDate(requestBody.getLogDate());

        return activityModel;
    }

    public void deleteActivity(Long id) {
        if (!activityRepo.existsById(id)) {
            throw new ActivityDoesNotExistException(id);
        }
        activityRepo.deleteById(id);
    }
}
