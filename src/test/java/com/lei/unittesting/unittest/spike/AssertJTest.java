package com.lei.unittesting.unittest.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {
    @Test
    public void learning(){
        List<Integer> numbers= Arrays.asList(12,15,45);
        assertThat(numbers)
                .hasSize(3)
                .contains(12,15)
                .allMatch(x->x>10);
        assertThat("")
                .isEmpty();
        assertThat("ABCDE").contains("BCD").startsWith("A").endsWith("CDE");


//        assertThat(numbers,hasSize(3));
//        assertThat(numbers, hasItems(12,45));
//        assertThat(numbers,everyItem(greaterThan(10)));
//        assertThat(numbers,everyItem(lessThan(100)));


    }


}
