package com.dailyquest.dailyquest.activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepo extends JpaRepository<ActivityModel, Long> {
    List<ActivityModel> findAllByUserUsername(String username);
}
