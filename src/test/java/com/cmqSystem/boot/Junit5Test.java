package com.cmqSystem.boot;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author key
 * @description
 * @create: 2022-12-29 21:28
 */

public class Junit5Test {




    /**
     * 前置条件
     * 不同之处在于不满足的断言会使得测试方法失败，而不满足的前置条件只会使得测试方法的执行终止。
     * */
    @Test
    @DisplayName("测试前置条件")
    void testAssumptions() {

        Assumptions.assumeTrue(false,"不是true");
        System.out.println("1111");
    }


    /**
     * 断言：前面断言失败，后面的代码都不会执行
     * */
    @Test
    @DisplayName("simple assertion")
    public void simple() {
        assertEquals(3, 1 + 2, "simple math");
        assertNotEquals(3, 1 + 1);

        assertNotSame(new Object(), new Object());
        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0),"需要抛出异常");
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }


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
