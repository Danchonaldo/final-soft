package soft.softfinal.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import soft.softfinal.dto.UserRequestDTO;
import soft.softfinal.dto.UserResponseDTO;

import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void registerUserTest() {
        UserRequestDTO request = new UserRequestDTO();
        request.setEmail("student@test.com");
        request.setFullName("Ivan Ivanov");
        request.setPassword("qwerty");

        UserResponseDTO response = userService.register(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("student@test.com", response.getEmail());
    }

    @Test
    void changePasswordSuccessTest() {
        boolean result = userService.changePassword(1L, "1234", "new_pass");

        Assertions.assertTrue(result);
    }

    @Test
    void changePasswordFailTest() {
        boolean result = userService.changePassword(1L, "wrong_old_pass", "new_pass");

        Assertions.assertFalse(result);
    }
}
