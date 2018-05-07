package com.kam6512.underrx;

import org.junit.Test;

import java.util.List;

public class UnderNumberRxTest {

    private UnderNumberRx test = new UnderNumberRx();

    @Test
    public void clamp() {
        test.clamp(-10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.clamp(10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.clamp(10, 5, -5).subscribe(UnderNumberRxTest::print);
    }

    @Test
    public void isRange() {
        test.inRange(-10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.inRange(10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.inRange(10, 5, -5).subscribe(UnderNumberRxTest::print);

        test.inRange(3, 2, 4).subscribe(UnderNumberRxTest::print);
        test.inRange(4, 8).subscribe(UnderNumberRxTest::print);
        test.inRange(4, 2).subscribe(UnderNumberRxTest::print);
        test.inRange(2, 2).subscribe(UnderNumberRxTest::print);
        test.inRange(1.2, 2).subscribe(UnderNumberRxTest::print);
        test.inRange(5.2, 4).subscribe(UnderNumberRxTest::print);
        test.inRange(-3, -2, -6).subscribe(UnderNumberRxTest::print);
    }

    @Test
    public void random() {
        test.random(5, 1000f, 2000f).subscribe(UnderNumberRxTest::print);
        test.random(10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.random(10, -5, 5).subscribe(UnderNumberRxTest::print);
        test.random(10, 5, -5).subscribe(UnderNumberRxTest::print);

        test.random(3, 2, 4).subscribe(UnderNumberRxTest::print);
        test.random(4, 8).subscribe(UnderNumberRxTest::print);
        test.random(4, 2).subscribe(UnderNumberRxTest::print);
        test.random(2, 2).subscribe(UnderNumberRxTest::print);
        test.random(1, 2).subscribe(UnderNumberRxTest::print);
        test.random(5, 4).subscribe(UnderNumberRxTest::print);
        test.random(3, -2, -6).subscribe(UnderNumberRxTest::print);
    }


    private static void print(Integer print) {
        System.out.println(print);
    }

    private static void print(Long print) {
        System.out.println(print);
    }

    private static void print(Double print) {
        System.out.println(print);
    }

    private static void print(Boolean print) {
        System.out.println(print);
    }

    private static void print(String print) {
        System.out.println(print);
    }

    private static void print(List<String> print) {
        System.out.println(print);
        System.out.println(print.size());
    }
}