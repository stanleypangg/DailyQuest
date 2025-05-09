package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.activity.ActivityModel;
import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepo habitRepo;

    @Autowired
    public HabitService(HabitRepo habitRepo) {
        this.habitRepo = habitRepo;
    }

    public List<HabitModel> findAll() {
        return habitRepo.findAll();
    }

    public HabitModel createHabit(HabitModel habit) {
        return habitRepo.save(habit);
    }

    @Transactional
    public HabitModel updateHabit(Long id, HabitModel requestBody) {
        HabitModel habitModel = habitRepo.findById(id).orElseThrow(
                () -> new ActivityDoesNotExistException(id)
        );
        if (requestBody.getUser() != null) {
            habitModel.setUser(requestBody.getUser());
        }
        if (requestBody.getName() != null) {
            habitModel.setName(requestBody.getName());
        }
        if (requestBody.getGoalCount() != null) {
            habitModel.setGoalCount(requestBody.getGoalCount());
        }
        if (requestBody.getGoalPeriod() != null) {
            habitModel.setGoalPeriod(requestBody.getGoalPeriod());
        }
        if (requestBody.getCurrentStreak() != null) {
            habitModel.setCurrentStreak(requestBody.getCurrentStreak());
        }
        if (requestBody.getBestStreak() != null) {
            habitModel.setBestStreak(requestBody.getBestStreak());
        }

        return habitModel;
    }

    public void deleteHabit(Long id) {
        if (!habitRepo.existsById(id)) {
            throw new ActivityDoesNotExistException(id);
        }
        habitRepo.deleteById(id);
    }

}
