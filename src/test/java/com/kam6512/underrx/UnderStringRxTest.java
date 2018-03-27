package com.kam6512.underrx;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UnderStringRxTest {

    private UnderStringRx test = new UnderStringRx();
    private UnderStringRxKt kt = new UnderStringRxKt();

    @Test
    public void camelCase() {
        test.camelCase("").subscribe(UnderStringRxTest::print);
        test.camelCase("FooBar").subscribe(UnderStringRxTest::print);
        test.camelCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.camelCase("fooBar").subscribe(UnderStringRxTest::print);
        test.camelCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        test.camelCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
        print("==============================================");
        kt.camelCase("").subscribe(UnderStringRxTest::print);
        kt.camelCase("FooBar").subscribe(UnderStringRxTest::print);
        kt.camelCase("Foo Bar").subscribe(UnderStringRxTest::print);
        kt.camelCase("fooBar").subscribe(UnderStringRxTest::print);
        kt.camelCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        kt.camelCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void capitalize() {
        test.capitalize("FRED").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void deburr() {
        test.deburr("déjà vu").subscribe(UnderStringRxTest::print);
        test.deburr("Árvíztűrő tükörfúrógép").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void kebabCase() {
        test.kebabCase("FooBar").subscribe(UnderStringRxTest::print);
        test.kebabCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.kebabCase("fooBar").subscribe(UnderStringRxTest::print);
        test.kebabCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        test.kebabCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
        print("==============================================");
        kt.kebabCase("").subscribe(UnderStringRxTest::print);
        kt.kebabCase("FooBar").subscribe(UnderStringRxTest::print);
        kt.kebabCase("Foo Bar").subscribe(UnderStringRxTest::print);
        kt.kebabCase("fooBar").subscribe(UnderStringRxTest::print);
        kt.kebabCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        kt.kebabCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void lowerCase() {
        test.lowerCase("FooBar").subscribe(UnderStringRxTest::print);
        test.lowerCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.lowerCase("fooBar").subscribe(UnderStringRxTest::print);
        test.lowerCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }
    @Test
    public void upperCase() {
        test.upperCase("FooBar").subscribe(UnderStringRxTest::print);
        test.upperCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.upperCase("fooBar").subscribe(UnderStringRxTest::print);
        test.upperCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }


    @Test
    public void lowerFirst() {
        test.lowerFirst("").subscribe(UnderStringRxTest::print);
        test.lowerFirst("Fred").subscribe(UnderStringRxTest::print);
        test.lowerFirst("FRED").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void repeat() {
        test.repeat("*", 3).subscribe(UnderStringRxTest::print);
        test.repeat("abc", 2).subscribe(UnderStringRxTest::print);
        test.repeat("FRED", 0).subscribe(UnderStringRxTest::print);
    }

    @Test
    public void snakeCase() {
        test.snakeCase("FooBar").subscribe(UnderStringRxTest::print);
        test.snakeCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.snakeCase("fooBar").subscribe(UnderStringRxTest::print);
        test.snakeCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        test.snakeCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void splitToList() {
        test.splitToList("a-b-c", "-", 1).subscribe(UnderStringRxTest::print);
        test.splitToList("a-b-c", "-", 2).subscribe(UnderStringRxTest::print);
        test.splitToList("a-b-c", "-", 3).subscribe(UnderStringRxTest::print);
        test.splitToList("a-_b-_c", "-_", 2).subscribe(UnderStringRxTest::print);
    }

    @Test
    public void startCase() {
        test.startCase("FooBar").subscribe(UnderStringRxTest::print);
        test.startCase("Foo Bar").subscribe(UnderStringRxTest::print);
        test.startCase("fooBar").subscribe(UnderStringRxTest::print);
        test.startCase("--foo-bar--").subscribe(UnderStringRxTest::print);
        test.startCase("__FOO_BAR__").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void trimStart() {
        test.trimStart("    |FooBar   |").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void trimEnd() {
        test.trimEnd("|    FooBar|    ").subscribe(UnderStringRxTest::print);
    }


    @Test
    public void upperFirst() {
        test.upperFirst("fred").subscribe(UnderStringRxTest::print);
        test.upperFirst("FRED").subscribe(UnderStringRxTest::print);
    }

    @Test
    public void word() {
        test.word("fred, barney, & pebbles").subscribe(UnderStringRxTest::print);
        test.word("'fred, barney, & pebbles'").subscribe(UnderStringRxTest::print);
    }

    private static void print(String print) {
        System.out.println(print);
    }

    private static void print(List<String> print) {
        System.out.println(print);
        System.out.println(print.size());
    }
}