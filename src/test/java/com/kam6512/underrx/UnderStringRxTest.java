package com.kam6512.underrx;

import org.junit.Test;

import java.util.Arrays;

public class UnderStringRxTest {

    private UnderStringRx test = new UnderStringRx();

    @Test
    public void camelCase() {
        test.camelCase("FooBar").subscribe(UnderStringRxTest::print);
        test.camelCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.camelCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        test.camelCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void capitalize(){
        test.capitalize("FRED").subscribe(UnderStringRxTest::print);
    }
    @Test
    public void deburr(){
        test.deburr("déjà vu").subscribe(UnderStringRxTest::print);
        test.deburr("Árvíztűrő tükörfúrógép").subscribe(UnderStringRxTest::print);
    }
    @Test
    public void kebabCase() {
        test.kebabCase("FooBar").subscribe(UnderStringRxTest::print);
        test.kebabCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.kebabCase("fooBar").subscribe(UnderStringRxTest::print);
        test.kebabCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }
    @Test
    public void lowerCase() {
        test.lowerCase("FooBar").subscribe(UnderStringRxTest::print);
        test.lowerCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.lowerCase("fooBar").subscribe(UnderStringRxTest::print);
        test.lowerCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }
    @Test
    public void lowerFirst() {
        test.lowerFirst("Fred").subscribe(UnderStringRxTest::print);
        test.lowerFirst("FRED").subscribe(UnderStringRxTest::print);
    }


    private static void print(String print) {
        System.out.println(print);
    }

}