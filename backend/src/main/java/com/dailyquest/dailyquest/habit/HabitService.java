package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.habit.dto.CreateHabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTOMapper;
import com.dailyquest.dailyquest.habit.dto.UpdateHabitDTO;
import com.dailyquest.dailyquest.habit.exception.HabitAccessDeniedException;
import com.dailyquest.dailyquest.habit.exception.HabitDoesNotExistException;
import com.dailyquest.dailyquest.user.UserModel;
import com.dailyquest.dailyquest.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<HabitDTO> findAll(String username) {
        return habitRepo.findAllByUserUsername(username)
                .stream()
                .map(habitDTOMapper)
                .collect(Collectors.toList());
    }

    public HabitDTO getHabitById(Long id, String username) {
        HabitModel habitModel = habitRepo.findById(id)
                .orElseThrow(() -> new HabitDoesNotExistException(id));

        // Verify user ownership
        if (!habitModel.getUser().getUsername().equals(username)) {
            throw new HabitAccessDeniedException(id);
        }

        return habitDTOMapper.apply(habitModel);
    }

    public HabitDTO createHabit(CreateHabitDTO dto, String username) {
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        HabitModel habitModel = new HabitModel(user, dto.name(), dto.goalCount(), dto.goalPeriod());
        habitRepo.save(habitModel);

        return habitDTOMapper.apply(habitModel);
    }

    @Transactional
    public HabitDTO updateHabit(Long id, UpdateHabitDTO dto, String username) {
        HabitModel habitModel = habitRepo.findById(id).orElseThrow(
                () -> new HabitDoesNotExistException(id)
        );

        // Verify this habit belongs to user
        if (!habitModel.getUser().getUsername().equals(username)) {
            throw new HabitAccessDeniedException(id);
        }

        if (dto.name() != null) {
            habitModel.setName(dto.name());
        }
        if (dto.goalCount() != null) {
            habitModel.setGoalCount(dto.goalCount());
        }
        if (dto.goalPeriod() != null) {
            habitModel.setGoalPeriod(dto.goalPeriod());
        }

        return habitDTOMapper.apply(habitModel);
    }

    public void deleteHabit(Long id) {
        if (!habitRepo.existsById(id)) {
            throw new HabitDoesNotExistException(id);
        }
        habitRepo.deleteById(id);
    }

}
