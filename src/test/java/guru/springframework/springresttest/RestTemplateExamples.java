package guru.springframework.springresttest;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RestTemplateExamples {

    @Value("${api.url.petstore}")
    String API_URL;

    String PET_RESOURCE = "/pet";

    @Test
    public void postPet(){
        Map<String,Object> petMap =  new HashMap<>();

        Map<String,Object> categoryMap = new HashMap<>();
        categoryMap.put("id",1);
        categoryMap.put("name","feline");

        petMap.put("category",categoryMap);
        petMap.put("name","freddy");

        List<String> photoURLs = new ArrayList<>();
        photoURLs.add("randomURL");

        petMap.put("photoUrls",photoURLs);

        List<Map<String,Object>> tags = new ArrayList<>();

        Map<String,Object> tagMap = new HashMap<>();
        tagMap.put("id",1);
        tagMap.put("name","testTag");

        tags.add(tagMap);

        petMap.put("tags",tags);
        petMap.put("status","available");

        RestTemplate restTemplate = new RestTemplate();

        JsonNode response = restTemplate.postForEntity(API_URL+PET_RESOURCE, petMap, JsonNode.class).getBody();


        System.out.println("Saved the following pet: " + response);
        if(response != null){
            long id = response.get("id").asLong();
            System.out.println("Checking if pet of ID " + id + " exists.");
            JsonNode getResponse = restTemplate.getForEntity(API_URL+PET_RESOURCE+"/"+id,JsonNode.class).getBody();
            if(getResponse != null){
                System.out.println("Got the following pet: " + getResponse);
                System.out.println("Deleting added pet");
                restTemplate.delete(API_URL+PET_RESOURCE+"/"+id);
                System.out.println("Trying to get again - should throw exception");
                Assertions.assertThrows(Exception.class, () ->
                        restTemplate.getForEntity(API_URL+PET_RESOURCE+"/"+id,JsonNode.class)
                );
            }
        }
    }
}
