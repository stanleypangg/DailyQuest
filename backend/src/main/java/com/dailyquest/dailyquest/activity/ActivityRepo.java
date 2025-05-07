package com.dailyquest.dailyquest.activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<ActivityModel, Long> {
}
