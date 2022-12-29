package com.cmqSystem.boot;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * @author key
 * @description
 * @create: 2022-12-29 21:28
 */

public class Junit5Test {

    @DisplayName("测试@DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了。。。。");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了。。。。");
    }

    @Disabled
    @Test
    @DisplayName("测试2注解")
    void test2() {
        System.out.println(2);
    }

    @Test
    @RepeatedTest(value = 3)
    void test5() {
        System.out.println(5);
    }

    @Test
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(501);
        System.out.println(3);
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了。。。。");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试结束了。。。。");
    }

}
