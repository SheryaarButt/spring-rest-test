package guru.springframework.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import guru.springframework.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestApiServiceImpl implements RestApiService {

    private RestTemplate restTemplate;
    private UserRepository userRepository;

    public RestApiServiceImpl(RestTemplate restTemplate, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UserData userData = restTemplate.getForObject(
                "https://private-anon-0849ffae0c-apifaketory.apiary-mock.com/api/user?limit=" + limit
                ,UserData.class);
        return userData != null ? userData.getData() : null;
    }

    public void saveUsers(Integer limit){
        userRepository.saveAll(getUsers(limit));
    }

}
