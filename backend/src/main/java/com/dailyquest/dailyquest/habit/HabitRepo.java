package com.dailyquest.dailyquest.habit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepo extends JpaRepository<HabitModel, Long> {
    List<HabitModel> findAllByUserUsername(String username);
}
