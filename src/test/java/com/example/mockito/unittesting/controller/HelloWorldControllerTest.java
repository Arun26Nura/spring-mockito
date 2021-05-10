package com.example.mockito.unittesting.controller;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloWorld_Basic() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"))
                .andReturn();
        //assertEquals("Hello World!!",mvcResult.getResponse().getContentAsString());

    }

}