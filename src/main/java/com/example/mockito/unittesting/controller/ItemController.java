package com.example.mockito.unittesting.controller;

import com.example.mockito.unittesting.model.Item;
import com.example.mockito.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/dummy")
    public Item getAllItems(){
        return new Item(1,"Mouse", 100,10);
    }

    @GetMapping("/dummy-item")
    public Item getAllItemsFromService(){
        return service.getItems();
    }

    @GetMapping("/items")
    public List<Item> getAllItemsFromDB(){
        return service.getAllItems();
    }
}
