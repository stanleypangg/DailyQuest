package com.dailyquest.dailyquest;

import com.dailyquest.dailyquest.user.UserModel;
import com.dailyquest.dailyquest.user.UserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepoTest {

    @Autowired
    private UserRepo underTest;

    private static final String USERNAME = "testuser";
    private static final String EMAIL = "test@email.com";
    private static final String PASSWORD = "testPassword";
    private static UserModel user;

    @BeforeAll
    static void setup(@Autowired UserRepo repo) {
        // given
        user = new UserModel(USERNAME, EMAIL, PASSWORD);
        // repo is the exact same bean as underTest
        repo.saveAndFlush(user);
    }

    @Test
    void itShouldFindByUsername() {
        // when
        var found = underTest.findByUsername(USERNAME)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // then
        assertThat(found).isEqualTo(user);
    }

    @Test
    void itShouldExistByUsername() {
        assertThat(underTest.existsByUsername(USERNAME)).isTrue();
    }

    @Test
    void itShouldExistByEmail() {
        assertThat(underTest.existsByEmail(EMAIL)).isTrue();
    }
}
