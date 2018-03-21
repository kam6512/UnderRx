package com.kam6512.underrx;

import org.junit.Test;

import java.util.Arrays;

public class UnderArrayRxTest {

    private UnderArrayRx test = new UnderArrayRx();

    @Test
    public void chunk() {
        test.chunk(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3)
                .subscribe(System.out::println);
    }

    @Test
    public void compactInteger() {
        test.compactInteger(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 0, -1))
                .subscribe(System.out::println, throwable -> {
                    System.out.println(throwable.toString());
                });
    }

    @Test
    public void compactString() {
        test.compactString(Arrays.asList("a", "b", "c", ""))
                .subscribe(System.out::println, throwable -> {
                    System.out.println(throwable.toString());
                });
    }
}