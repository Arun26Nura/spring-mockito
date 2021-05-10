package com.example.mockito.unittesting.controller;


import com.example.mockito.unittesting.model.Item;
import com.example.mockito.unittesting.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService service;

    @Test
    public void helloWorld_Basic() throws Exception{
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/dummy")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Mouse\",\"price\":100,\"quantity\":10}"))
                .andReturn();
        //assertEquals("Hello World!!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void helloWorld_Basic_HardCoded() throws Exception{
        when(service.getItems()).thenReturn(new Item(1,"Mouse",100,10));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Mouse\",\"price\":100,\"quantity\":10}"))
                .andReturn();
        //assertEquals("Hello World!!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void helloWorld_Basic_List() throws Exception{
        when(service.getAllItems()).thenReturn(
                Arrays.asList(new Item(1,"Mouse",100,10),
                        new Item(2,"Key",100,5)));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/items")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:Mouse,price:100,quantity:10},{id:2,name:Key,price:100,quantity:5}]"))
                .andReturn();
        //assertEquals("Hello World!!",mvcResult.getResponse().getContentAsString());

    }


}