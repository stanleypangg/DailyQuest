package com.dailyquest.dailyquest.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepoTest {

    @Autowired
    private UserRepo underTest;

    private final String USERNAME = "testuser";
    private final String EMAIL = "test@email.com";
    private UserModel user;

    @BeforeEach
   void setup(@Autowired UserRepo repo) {
        underTest.deleteAll();

        user = new UserModel();
        user.setUsername(USERNAME);
        user.setEmail(EMAIL);

        underTest.saveAndFlush(user);
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
