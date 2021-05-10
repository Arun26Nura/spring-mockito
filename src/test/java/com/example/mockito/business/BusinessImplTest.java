package com.example.mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplTest {

    @Test
    void calculateSum_Test() {
        BusinessImpl impl=new BusinessImpl();
        int actualResult= impl.calculateSum(new int[] {1,2,3});
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_Empty() {
        BusinessImpl impl=new BusinessImpl();
        int actualResult= impl.calculateSum(new int[] {});
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

}