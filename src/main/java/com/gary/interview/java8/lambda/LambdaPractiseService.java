/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.lambda;

import com.gary.interview.java8.utils.MockPerson;
import com.gary.interview.java8.utils.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.gary.interview.java8.utils.PersonConstants.GENDER_MALE;

/**
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
public class LambdaPractiseService {
    LambdaUtils<Long, Integer> lambdaUtils = new LambdaUtils();
    /**
     *  1. test1
     *     调用Collections.sort()方法, 通过定制排序比较两个Person(先按年龄比, 年龄相同按姓名比),
     *     使用Lambda作为参数传递.
     */
    public void test1(){
        Comparator<Person> personComparator = (x, y) -> {
            if (x.getAge() > y.getAge()) {
                return 1;
            } else if (x.getAge() < y.getAge()) {
                return -1;
            } else {
                return x.getName().compareToIgnoreCase(y.getName());
            }
        };

        List<Person> personList = MockPerson.getData();

        System.out.println("before sort : " + personList);

        Collections.sort(personList, personComparator);

        System.out.println("after sort : " + personList);
    }

    public void test11(){
        Person p1 = new Person("Jack", GENDER_MALE, 20);
        Person p2 = new Person("Tom", GENDER_MALE, 30);

        LambdaUtils.sort(p1, p2, (a,b)-> a.getAge()>b.getAge()? 1 : -1);


    }

    /**
     *  2. test2
     *     ①声明函数式接口, 接口中声明抽象方法, public String getValue(String str);
     *     ②声明类TestLambda, 类中编写方法使用接口作为参数, 将一个字符串转换成大写, 并作为方法的返回值.
     *     ③再将一个字符串的第2个和第4个索引位置进行截取子串.
     */
    public void test2() {
        System.out.println(LambdaUtils.stringOpr("Hello World", x -> x.toUpperCase()));
        System.out.println(LambdaUtils.stringOpr("this_is_test_demo", x -> x.substring(2, 5)));

    }

    /**
     *  3. test3
     *     ①声明一个带两个泛型的函数式接口, 泛型类型为<T,R> T为参数, R为返回值
     *     ②接口中声明对应抽象方法
     *     ③在TestLambda类中声明方法, 使用接口作为参数, 计算两个long型参数的和.
     *     ④再计算两个long型参数的乘积.
     */
    public void test3() {
        System.out.println(LambdaUtils.calcualtion(12L, 32L, (a, b) -> a.intValue() + b.intValue()));
        System.out.println(LambdaUtils.calcualtion(3L, 4L, (a, b) -> a.intValue() * b.intValue()));

        System.out.println(lambdaUtils.calcualtion2(10L, 29L, (a, b) -> a.intValue() + b.intValue()));
    }
}


