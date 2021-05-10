package com.example.mockito.unittesting.service;

import com.example.mockito.unittesting.data.ItemRepository;
import com.example.mockito.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository repo;

    public Item getItems() {
        return new Item(1,"Mouse", 100,10);
    }

    public List<Item> getAllItems(){
        List<Item> list=repo.findAll();
        for(Item item:list){
            item.setValue(item.getPrice()* item.getQuantity());
        }
        return list;
    }
}
