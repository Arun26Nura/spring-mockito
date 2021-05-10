package com.example.mockito.unittesting.service;

import com.example.mockito.unittesting.data.ItemRepository;
import com.example.mockito.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @InjectMocks
    ItemService service;

    @Mock
    ItemRepository repo;

    @Test
    void getAllItems_Mock() {
        when(repo.findAll()).thenReturn(Arrays.asList(new Item(1,"Mouse",100,10),
                new Item(2,"Key",100,5)));
        List<Item> items= service.getAllItems();
        assertEquals(1000,items.get(0).getValue());
    }
}