package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.user.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class HabitRepoTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    private HabitRepo underTest;
    private UserModel u1;
    private UserModel u2;

    @BeforeEach
    void setup() {
        u1 = em.persistFlushFind(
                new UserModel("user1", "user1@email.com", "password")
        );
    }

    @Test
    void itShouldFindAllByUserUsername() {
        // given
        HabitModel h1 = new HabitModel();
        h1.setUser(u1);
        h1.setName("Habit 1");
        h1.setGoalCount(0);
        h1.setGoalPeriod("random");
        em.persist(h1);

        HabitModel h2 = new HabitModel();
        h2.setUser(u1);
        h2.setName("Habit 2");
        h2.setGoalCount(0);
        h2.setGoalPeriod("random");
        em.persist(h2);

        HabitModel h3 = new HabitModel();
        h3.setUser(u1);
        h3.setName("Habit 3");
        h3.setGoalCount(0);
        h3.setGoalPeriod("random");
        em.persist(h3);

        em.flush();

        // when
        List<HabitModel> found = underTest.findAllByUserUsername(u1.getUsername());

        assertThat(found)
                .hasSize(3)
                .extracting(HabitModel::getName)
                .containsExactlyInAnyOrder("Habit 1", "Habit 2", "Habit 3");
    }
}
