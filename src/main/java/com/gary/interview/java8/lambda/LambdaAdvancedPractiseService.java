/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.lambda;

import com.gary.interview.java8.commonUtils.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 *  (上接 高级语法 LambdaAdvancedGrammerService.java)
 *
 *  1. test1
 *     调用Collections.sort()方法, 通过定制排序比较两个Person(先按年龄比, 年龄相同按姓名比),
 *     使用Lambda作为参数传递.
 *
 *  2. test2
 *     ①声明函数式接口, 接口中声明抽象方法, public String getValue(String str);
 *     ②声明类TestLambda, 类中编写方法使用接口作为参数, 将一个字符串转换成大写, 并作为方法的返回值.
 *     ③再将个字符串的第2个和第4个索引位置进行截取子串.
 *
 *  3. test3
 *     ①声明一个带两个泛型的函数式接口, 泛型类型为<T,R> T为参数, R为返回值
 *     ②接口中声明对应抽象方法
 *     ③在TestLambda类中声明方法, 使用接口作为参数, 计算两个long型参数的和.
 *     ④再计算两个long型参数的乘积.
 *
 *
 *
 */
public class LambdaAdvancedPractiseService {
    LambdaUtils<Long, Integer> lambdaUtils = new LambdaUtils();

    /**
     * 1. test1
     * 调用Collections.sort()方法, 通过定制排序比较两个Person(先按年龄比, 年龄相同按姓名比),
     * 使用Lambda作为参数传递.
     */
    public void test1() {
        List<Person> list = Arrays.asList(new Person("A",19), new Person("A", 18), new Person("B", 20));
        List<Person> list2 = Arrays.asList(new Person("A",19), new Person("A", 18), new Person("B", 20));
        //old
        Comparator<Person> com1 = (a,b) -> Integer.compare(a.getAge(),b.getAge());
        Comparator<Person> com2 = (a,b) -> a.getName().compareToIgnoreCase(b.getName());
        Collections.sort(list, com1);
        Collections.sort(list, com2);
        System.out.println(list);

        //new
        Comparator<Person> com11 = Comparator.comparingInt(Person::getAge);
        Collections.sort(list2, com11);
        Collections.sort(list2, com2);
        System.out.println(list2);

    }


    /**
     *  2. test2
     *     ①声明函数式接口, 接口中声明抽象方法, public String getValue(String str);
     *     ②声明类TestLambda, 类中编写方法使用接口作为参数, 将一个字符串转换成大写, 并作为方法的返回值.
     *     ③再将一个字符串的第2个和第4个索引位置进行截取子串.
     */
    public void test2() {
        String str = "Hello World my Lambda";

        //old
        BiFunction<Integer, Integer, String> fun = (a, b) -> str.substring(a, b);
        UnaryOperator<String> opr = (x) -> x.toUpperCase();
        System.out.println("old string = " + opr.apply(fun.apply(5, 11)));

        //new
        BiFunction<Integer, Integer, String> fun1 = str::substring;
        UnaryOperator<String> opr1 = String::toUpperCase;
        System.out.println("new string = " + opr1.apply(fun1.apply(5, 11)));

    }

    /**
     *  3. test3
     *     ①声明一个带两个泛型的函数式接口, 泛型类型为<T,R> T为参数, R为返回值
     *     ②接口中声明对应抽象方法
     *     ③在TestLambda类中声明方法, 使用接口作为参数, 计算两个long型参数的和.
     *     ④再计算两个long型参数的乘积.
     */
    public void test3() {
        Long l1 = 10L;
        Long l2 = 20L;
        Long[] longs = {l1, l2};

        // sum
        BinaryOperator<Long> sum = Long::sum;
        ToIntFunction<Long> intValue = Long::intValue;
        System.out.println("sum result = " + intValue.applyAsInt(sum.apply(l1, l2)));

        // times
        Function<Long[], Integer> times = x -> x[0].intValue() * x[1].intValue();
        System.out.println("times result = " + times.apply(longs));


    }
}


