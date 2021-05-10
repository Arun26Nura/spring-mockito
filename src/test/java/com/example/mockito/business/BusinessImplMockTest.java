package com.example.mockito.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BusinessImplMockTest {

    @InjectMocks
    BusinessImpl impl;

    @Mock
    SomeDataService mock;
    /*
    @BeforeEach
    public void before(){
        impl.setDataService(mock);
    }*/

    @Test
    void calculateSumUsingDataService_Test() {
        when(mock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,impl.calculateSum_DateService());
    }

    @Test
    void calculateSumUsingDataService_Empty() {
        when(mock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,impl.calculateSum_DateService());
    }

    @Test
    void calculateSumUsingDataService_OneValue() {
        when(mock.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1,impl.calculateSum_DateService());
    }

}