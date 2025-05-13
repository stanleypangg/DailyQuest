package com.dailyquest.dailyquest.habit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitRepo extends JpaRepository<HabitModel, Long> {
    @Query("SELECT h FROM HabitModel h WHERE h.user.username = :username")
    List<HabitModel> findAllByUsername(@Param("username") String username);
}
