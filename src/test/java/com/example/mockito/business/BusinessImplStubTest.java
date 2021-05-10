package com.example.mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

public class BusinessImplStubTest {

    @Test
    void calculateSumUsingDataService_Test() {
        BusinessImpl impl=new BusinessImpl();
        impl.setDataService(new SomeDataServiceStub());
        int actualResult= impl.calculateSum_DateService();
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