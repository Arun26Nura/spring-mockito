package com.example.mockito.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchTest {

    @Test
    public void hamcrest_Test(){
        List<Integer> list= Arrays.asList(1,3,4);
        assertThat(list,hasSize(3));
        assertThat(list,hasItems(3,4));

        assertThat("",emptyString());
        assertThat("Arune",startsWith("A"));

    }
}
