/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.lambda;

import com.gary.interview.java8.lambda.functionalInterface.MyCalculation;
import com.gary.interview.java8.lambda.functionalInterface.MyPredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class LambdaGrammarService {


/**
 *
 * Lambda表达式语法
 *
 * **********************************************************
 *
 *  一，基本语法：
 *      语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello lambda ! ");
 *
 *      语法格式二：一个参数，无返回值
 *      (x) -> System.out.println(x);
 *       x -> System.out.println(x);
 *      eg: Consumer
 *
 *      语法格式三：多个参数，有返回值
 *      -   lambda体中有多条语句
 *      (x,y) -> {x++;y++;return x+y;}
 *      -   lambda体只有一条语句
 *      (x,y) -> x+y;
 *      eg: Comparator
 *
 *      (tips)：类型推断（参数列表的数据类型可省略，JVM可根据上下文推断类型）
 *      (Integer x, Integer y ) -> Integer.compare(x, y);
 *      (x, y) -> Integer.compare(x, y);
 *
 * **********************************************************
 *
 *  二，Tips
 *      类型推断（参数列表的数据类型可省略，JVM可根据上下文推断类型）
 *      (Integer x, Integer y ) -> Integer.compare(x, y);
 *      (x, y) -> Integer.compare(x, y);
 *
 *      Lambda表达式需要“函数式接口”的支持
 *      函数式接口：接口，有且只有一个抽象方法，用@FunctionalInterface修饰
 *      eg: MyPredicate.java
 *
 * **********************************************************
 *
 *  三, Java8中内置的四大核心函数式接口
 *     消费型接口
 *     Consumer<T>
 *         void accept(T t);
 *
 *     供给型接口
 *      Supplier<T>
 *          T get();
 *
 *     函数型接口
 *      Function<T, R>
 *          R apply(T t);
 *
 *     段言型接口
 *      Predicate<T>
 *          boolean test(T t);
 *
 *     其他接口
 *      BiFunction<T, U, R>
 *          R apply(T t, U u);
 *
 *      UnaryOperator<T>
 *          T apply(T t);
 *
 *      BinaryOperator<T>
 *          T apply(T t1, T t2);
 *
 *      BiConsumer<T, U>
 *          void accept(T t, U u);
 *
 *      ToIntFunction<T>
 *          int applyAsInt(T t);
 *
 *      ToLongFunction<T>
 *          long applyAsLong(T t);
 *
 *      ToDoubleFunction<T>
 *          double applyAsDouble(T t);
 *
 *      IntFunction<R>
 *          R apply(int value);
 *
 *      LongFunction<R>
 *          R apply(long value);
 *
 *      DoubleFunction<R>
 *          R apply(double value);
 *
 * **********************************************************
 *
 *   (下接 高级语法 LambdaAdvancedGrammerService.java)
 *
 */


    /**
     * 语法格式一：无参数，无返回值
     * () -> System.out.println("Hello lambda ! ");
     */
    public void test1() {
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World ! " + num);
            }
        };

        r.run();

        System.out.println("----------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda ! ");
        r1.run();
    }

    /**
     * 语法格式二：有一个参数，无返回值
     * (x) -> System.out.println(x);
     * x -> System.out.println(x);
     * eg: Consumer
     */
    public void test2() {
        // x 是形参，随便定义
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello lambda");
    }


    /**
     * 语法格式三：有多个参数，有返回值，lambda体中有多条语句
     * (x,y) -> {x++;y++;return x+y;}
     * eg: Comparator
     */
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            x++;
            y++;
            return x + y;
        };

        int result = comparator.compare(10, 20);
        System.out.println("result = " + result);

        Comparator<Integer> comparator1 = (x, y) -> x + y;
        System.out.println(comparator1.compare(2, 3));
    }

    /**
     *  tips
     * 类型推断（参数列表的数据类型可省略，JVM可根据上下文推断类型）
     * (Integer x, Integer y ) -> Integer.compare(x, y);
     * (x, y) -> Integer.compare(x, y);
     */
    public void test4() {
        Comparator<Integer> comparator31 = (a, b) -> Integer.compare(a, b);
        Comparator<Integer> comparator32 = (Integer a, Integer b) -> Integer.compare(a, b);

        int result31 = comparator31.compare(10, 20);
        int result32 = comparator31.compare(10, 20);
        System.out.println("result31=" + result31);
        System.out.println("result32=" + result32);

//        Comparator<String> comparator = (String a, String b) -> Integer.parseInt(a + b);
//        Comparator<String> comparator2 = (a, b) -> Integer.parseInt(a + b);
//        int result = comparator.compare("2", "3");
//        System.out.println(result);
    }


    /**
     * tips
     * Lambda表达式需要“函数式接口”的支持
     * 函数式接口：接口，有且只有一个抽象方法，用@FunctionalInterface修饰
     * eg: MyPredicate.java
     */
    public void test5() {
        MyPredicate<String> myPredicate = x -> x == null ? true : false;
        String s1 = null;
        String s2 = "";
        String s3 = "test";
        System.out.println("s1 = " + myPredicate.predicate(s1));
        System.out.println("s2 = " + myPredicate.predicate(s2));
        System.out.println("s3 = " + myPredicate.predicate(s3));
    }


    /**
     * Test example part1:
     * 灵活实现任意两个数的任意运算操作
     */
    public void test6() {
        MyCalculation<Integer, Integer> myCalculation = (x, y) -> x + y;
        System.out.println(myCalculation.operation(10, 11));

        myCalculation = (x, y) -> x * y;
        System.out.println(myCalculation.operation(10, 11));

        System.out.println("**************");
        System.out.println(operation(1, 2, (x, y) -> x + y));
        System.out.println(operation(1, 2, (x, y) -> x * y));
        System.out.println(operation(1, 2, (x, y) -> x - y));


    }

    /**
     * Test example part2:
     * 灵活实现任意两个数的任意运算操作
     */
    private Integer operation(Integer a, Integer b, MyCalculation<Integer, Integer> myCalculation) {
        return myCalculation.operation(a, b);
    }

    /**
     * 三, Java8中内置的四大核心函数式接口
     * 消费型接口
     * Consumer<T>
     * void accept(T t);
     * <p>
     * 供给型接口
     * Supplier<T>
     * T get();
     * <p>
     * 函数型接口
     * Function<T, R>
     * R apply(T t);
     * <p>
     * 段言型接口
     * Predicate<T>
     * boolean test(T t);
     */
    public void test7() {
        consumerTest("hello world", x -> System.out.println(x));

        List<Integer> list = supplierTest(5, () -> (int) (Math.random() * 10));
        list.stream().forEach(System.out::println);

        System.out.println(functionTest(20L, x -> x.intValue() * 20));

        System.out.println(predicateTest(20, x -> x >= 18 ? true : false));
        System.out.println(predicateTest(20, x -> x > 18));
    }

    private void consumerTest(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    private List<Integer> supplierTest(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    private Integer functionTest(Long l, Function<Long, Integer> function) {
        return function.apply(l);
    }

    private boolean predicateTest(Integer i, Predicate<Integer> predicate) {
        return predicate.test(i);
    }
}


