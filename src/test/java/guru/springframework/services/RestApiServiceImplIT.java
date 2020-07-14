package guru.springframework.services;

import guru.springframework.api.domain.User;
import guru.springframework.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RestApiServiceImplIT {

    @Autowired
    RestApiServiceImpl restApiService;

    @Autowired
    UserRepository userRepository;

    @Test
    void getUsers() {
        List<User> users = restApiService.getUsers(1);
        assertEquals(1,users.size());
    }

    @Test
    void saveUsers(){
        restApiService.saveUsers(1);
        assertTrue(userRepository.count() >= 1);
    }
}