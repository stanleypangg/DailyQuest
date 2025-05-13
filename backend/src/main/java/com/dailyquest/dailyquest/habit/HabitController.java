package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.habit.dto.CreateHabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
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
    public List<HabitDTO> findAll() { return habitService.findAll(); }

    @PostMapping
    public HabitDTO createHabit(
            @Valid @RequestBody CreateHabitDTO habit,
            @AuthenticationPrincipal UserDetails userDetails)
    {
        return habitService.createHabit(habit, userDetails.getUsername());
    }

    @PatchMapping(value = "/{id}")
    public HabitModel updateHabit(
            @PathVariable(name = "id") Long id,
            @RequestBody HabitModel requestBody) {
        return habitService.updateHabit(id, requestBody);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHabit(@PathVariable(name = "id") Long id) {
        habitService.deleteHabit(id);
    }
}
