package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.habit.dto.CreateHabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.habit.dto.UpdateHabitDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<HabitDTO> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        return habitService.findAll(userDetails.getUsername());
    }

    @PostMapping
    public HabitDTO createHabit(
            @Valid @RequestBody CreateHabitDTO habit,
            @AuthenticationPrincipal UserDetails userDetails)
    {
        return habitService.createHabit(habit, userDetails.getUsername());
    }

    // TODO: change HabitModel response to DTO
    @PatchMapping(value = "/{id}")
    public HabitDTO updateHabit(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateHabitDTO requestBody,
            @AuthenticationPrincipal UserDetails userDetails) {
        return habitService.updateHabit(id, requestBody, userDetails.getUsername());
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHabit(@PathVariable(name = "id") Long id) {
        habitService.deleteHabit(id);
    }
}
