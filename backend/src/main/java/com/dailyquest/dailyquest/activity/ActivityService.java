package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDto;
import com.dailyquest.dailyquest.activity.dto.ActivityDtoMapper;
import com.dailyquest.dailyquest.activity.dto.CreateActivityDTO;
import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import com.dailyquest.dailyquest.user.UserModel;
import com.dailyquest.dailyquest.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepo activityRepo;
    private final HabitRepo habitRepo;
    private final UserRepo userRepo;
    private final ActivityDtoMapper activityDtoMapper;

    @Autowired
    public ActivityService(ActivityRepo activityRepo, HabitRepo habitRepo, UserRepo userRepo, ActivityDtoMapper activityDtoMapper) {
        this.activityRepo = activityRepo;
        this.habitRepo = habitRepo;
        this.userRepo = userRepo;
        this.activityDtoMapper = activityDtoMapper;
    }

    public List<ActivityDto> findAll(String username) {
        return activityRepo.findAllByUsername(username)
                .stream()
                .map(activityDtoMapper)
                .collect(Collectors.toList());
    }

    // TODO: change username to Long id
    public ActivityDto createActivity(CreateActivityDTO request, String username) {
        // Retrieve the existing habit from the database using the injected instance
        HabitModel habit = habitRepo.findById(request.habitId())
                .orElseThrow(() -> new RuntimeException("Habit not found")); // TODO: implement custom exception
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found")); // TODO: implement custom exception

        // Create activity with existing habit
        ActivityModel activity = new ActivityModel(request.logDate(), request.title(), habit, user);
        activityRepo.save(activity);

        return activityDtoMapper.apply(activity);
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
