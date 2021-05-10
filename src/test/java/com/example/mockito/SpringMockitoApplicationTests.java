package com.example.mockito;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringMockitoApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/items", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]",response,false);
    }

}
