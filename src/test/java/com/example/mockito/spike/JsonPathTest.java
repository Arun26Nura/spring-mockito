package com.example.mockito.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import javax.swing.text.Document;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPathTest {


    @Test
    public void jsonPathTest(){
        String response="[{\"id\":1001,\"name\":\"Item1\",\"price\":100,\"quantity\":10,\"value\":1000}," +
                "{\"id\":1002,\"name\":\"Item2\",\"price\":200,\"quantity\":20,\"value\":4000}," +
                "{\"id\":1003,\"name\":\"Item3\",\"price\":50,\"quantity\":5,\"value\":250}]";

        DocumentContext jsonValue= JsonPath.parse(response);

        int length = jsonValue.read("$.length()");
        assertEquals(3,length);
        System.out.println(jsonValue.read("$.[0:2]").toString());
        System.out.println(jsonValue.read("$.[?(@.name=='Item1')]").toString());
    }
}
