package com.example.mockito.unittesting.data;

import com.example.mockito.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository repo;

    @Test
    public void findAllTest(){
        List<Item> itemList= repo.findAll();
        assertEquals(3,itemList.size());
    }


}