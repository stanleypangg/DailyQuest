package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.habit.dto.CreateHabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.habit.dto.UpdateHabitDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/habits")
@Validated
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<HabitDTO> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        return habitService.findAll(userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public HabitDTO getHabitById(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return habitService.getHabitById(id, userDetails.getUsername());
    }

    @PostMapping
    public ResponseEntity<HabitDTO> createHabit(
            @Valid @RequestBody CreateHabitDTO habit,
            @AuthenticationPrincipal UserDetails userDetails)
    {
        HabitDTO dto = habitService.createHabit(habit, userDetails.getUsername());
        URI location = URI.create("/api/habits" + dto.id());
        return ResponseEntity.created(location).body(dto);
    }

    @PatchMapping(value = "/{id}")
    public HabitDTO updateHabit(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody UpdateHabitDTO requestBody,
            @AuthenticationPrincipal UserDetails userDetails) {
        return habitService.updateHabit(id, requestBody, userDetails.getUsername());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable(name = "id") Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
