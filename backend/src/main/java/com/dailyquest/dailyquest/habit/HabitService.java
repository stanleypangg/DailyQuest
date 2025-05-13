package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.habit.dto.CreateHabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTOMapper;
import com.dailyquest.dailyquest.habit.exception.HabitDoesNotExistException;
import com.dailyquest.dailyquest.user.UserModel;
import com.dailyquest.dailyquest.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitService {

    private final HabitRepo habitRepo;
    private final HabitDTOMapper habitDTOMapper;
    private final UserRepo userRepo;

    @Autowired
    public HabitService(HabitRepo habitRepo, HabitDTOMapper habitDTOMapper, UserRepo userRepo) {
        this.habitRepo = habitRepo;
        this.habitDTOMapper = habitDTOMapper;
        this.userRepo = userRepo;
    }

    public List<HabitDTO> findAll() {
        return habitRepo.findAll()
                .stream()
                .map(habitDTOMapper)
                .collect(Collectors.toList());
    }

    public HabitDTO createHabit(CreateHabitDTO dto, String username) {
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        HabitModel habit = new HabitModel(user, dto.name(), dto.goalCount(), dto.goalPeriod());
        habitRepo.save(habit);

        return habitDTOMapper.apply(habit);
    }

    // TODO: looks like updating user may need to be updated to fetch user
    @Transactional
    public HabitModel updateHabit(Long id, HabitModel requestBody) {
        HabitModel habitModel = habitRepo.findById(id).orElseThrow(
                () -> new HabitDoesNotExistException(id)
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
            throw new HabitDoesNotExistException(id);
        }
        habitRepo.deleteById(id);
    }

}
