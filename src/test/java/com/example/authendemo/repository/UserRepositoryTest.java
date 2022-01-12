package com.example.authendemo.repository;

import com.example.authendemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    void itShouldFindByUsername() {
        //given
        String username = "thai99";
        User user = new User(1L, "ROLE_USER", username, "1234",1);
        underTest.save(user);
        boolean expected = underTest.selectExistsUsername(username);
        assertThat(expected).isTrue();
    }
}