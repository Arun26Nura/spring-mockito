package com.example.mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void sizeBasic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void sizeBasic_Different(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void parameters(){
        when(mock.get(0)).thenReturn("Arun");
        assertEquals("Arun",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void parameters_Any(){
        when(mock.get(anyInt())).thenReturn("Arun");
        assertEquals("Arun",mock.get(0));
        assertEquals("Arun",mock.get(6));
    }

    @Test
    public void verification_Basic(){
        String firstString=mock.get(0);
        String secondString=mock.get(1);

     verify(mock).get(0);
     verify(mock,atLeast(1)).get(anyInt());
     verify(mock,times(2)).get(anyInt());
     verify(mock,never()).get(2);
    }

    @Test
    public void argumentCapturing(){

        mock.add("Hello");
        ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("Hello",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){

        mock.add("Hello");
        mock.add("Hi");
        ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> values=captor.getAllValues();
        assertEquals("Hello",values.get(0));
        assertEquals("Hi",values.get(1));
    }


}
