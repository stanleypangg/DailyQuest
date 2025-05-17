package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.habit.HabitRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO: write this test
@DataJpaTest
public class ActivityRepoTest {

    @Autowired
    private ActivityRepo underTest;
    @Autowired
    private HabitRepo habitRepo;

    @Test
    void itShouldFindAllByUserUsername() {

    }
}
