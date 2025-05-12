package com.dailyquest.dailyquest.habit;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<HabitModel> findAll() { return habitService.findAll(); }

    @PostMapping
    public HabitModel createHabit(@Valid @RequestBody HabitModel habit) {
        return habitService.createHabit(habit);
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
