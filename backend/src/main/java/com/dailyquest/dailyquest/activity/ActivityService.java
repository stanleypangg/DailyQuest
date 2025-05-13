package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDTO;
import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisAnnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepo activityRepo;
    private final HabitRepo habitRepo;

    @Autowired
    public ActivityService(ActivityRepo activityRepo, HabitRepo habitRepo) {
        this.activityRepo = activityRepo;
        this.habitRepo = habitRepo;
    }

    public List<ActivityModel> findAll() {
        return activityRepo.findAll();
    }

//    public ActivityModel createActivity(ActivityModel activity) {
//        return activityRepo.save(activity);
//    }

    public ActivityModel createActivity(ActivityDTO request) {
        // Retrieve the existing habit from the database using the injected instance
        HabitModel habit = habitRepo.findById(request.getHabitId())
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        // Create activity with existing habit
        ActivityModel activity = new ActivityModel(request.getLogDate(), request.getTitle(), habit);
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
