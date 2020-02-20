package com;

import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @Author: baojx
 * @Date: 2020/2/20 19:52
 * @Desc: Test
 */
public class LambdaTest {

    @Test
    public void test21() {
        //1
        Runnable runnable = () -> System.out.println("test");
        //2
        ActionListener actionListener = e -> System.out.println("test:" + e);
        //3
        Runnable runnable1 = () -> {
            System.out.println("test");
            System.out.println("test");
        };
        //4
        BinaryOperator<Long> add = (x, y) -> x + y;
        //5
        BinaryOperator<Long> addExplict = (Long x, Long y) -> x + y;
        //6
        BinaryOperator<Long> add1 = Long::sum;
    }

    @Test
    public void test25() {

        //2-11
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(15));
    }

    interface Intpred {
        boolean test(Integer value);
    }

    interface a {
        boolean check(Predicate<Integer> predicate);

        boolean check(Intpred intpred);
    }

    class A implements a {

        @Override
        public boolean check(Predicate<Integer> predicate) {
            return false;
        }

        @Override
        public boolean check(Intpred intpred) {
            return false;
        }
    }

    class B {
        public B() {
            A a = new A();
//            a.check(x -> x > 5);
            //不能区分出那个
        }
    }
}
