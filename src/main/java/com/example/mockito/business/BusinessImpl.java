package com.example.mockito.business;

import java.util.Arrays;

public class BusinessImpl {



    private SomeDataService dataService;

    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] input){
        return Arrays.stream(input).reduce(Integer::sum).orElse(0);
    }

    public int calculateSum_DateService(){
        int sum=0;
        int[] input= dataService.retrieveAllData();
        for(int value:input){
            sum+=value;
        }
        return sum;
    }


}
