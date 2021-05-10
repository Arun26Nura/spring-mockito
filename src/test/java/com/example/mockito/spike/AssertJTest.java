package com.example.mockito.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {

    @Test
    public void assertJtest(){
        List<Integer> integerList= Arrays.asList(1,2,3,4,5);
        assertThat(integerList).hasSize(5)
                .contains(1,2)
                .allMatch(e -> e<100)
                .allMatch(e -> e >0)
                .noneMatch(e -> e<0);

        assertThat("Arum").startsWith("A").hasSize(4);

    }
}
