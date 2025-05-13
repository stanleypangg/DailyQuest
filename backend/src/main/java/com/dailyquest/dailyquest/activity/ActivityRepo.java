package com.dailyquest.dailyquest.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepo extends JpaRepository<ActivityModel, Long> {
    @Query(
            value = "SELECT * FROM activity_model WHERE user.username = :username",
            nativeQuery = true
    )
    List<ActivityModel> findAllByUsername(@Param("username") String username);
}
