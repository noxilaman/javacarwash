package com.noxil.carwash;

import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    void testCreate() throws BaseException {
        User user = userService.create(
                TestData.email,
                TestData.username,
                TestData.password,
                TestData.firstname,
                TestData.lastname);
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals(user.getEmail(),TestData.email);
        Assertions.assertEquals(user.getUsername(),TestData.username);
        Assertions.assertEquals(user.getFirstname(),TestData.firstname);
        Assertions.assertEquals(user.getLastname(),TestData.lastname);
        boolean chkpassword = userService.matchPassword(TestData.password, user.getPassword());
        Assertions.assertTrue(chkpassword);
    }

    void testUpdate() {

    }

    void testDelete() {

    }

    interface TestData {
        String email = "pong@g.com";
        String username = "pkp";
        String password = "12345678";
        String firstname = "pong";
        String lastname = "test";
    }
}
