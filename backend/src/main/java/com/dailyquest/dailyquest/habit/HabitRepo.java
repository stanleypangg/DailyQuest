package com.dailyquest.dailyquest.habit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepo extends JpaRepository<HabitModel, Long> {
}
