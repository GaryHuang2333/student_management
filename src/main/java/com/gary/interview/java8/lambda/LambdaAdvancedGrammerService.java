/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.lambda;

import com.gary.interview.java8.commonUtils.Person;
import com.gary.interview.java8.commonUtils.PersonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static com.gary.interview.java8.commonUtils.PersonConstants.GENDER_MALE;

/**
 *  Lambda表达式高级语法
 *  (上接 基本语法 LambdaGrammerService.java)
 *
 * **********************************************************
 *
 *  四, 方法引用
 *      对象::实例方法名
 *      类名::静态方法名
 *      类名::实例方法名
 *
 *  !!!
 *      1.
 *     lambda体中的调用方法的参数列表和返回值类型
 *      == 保持一致 ==
 *      函数式接口中的抽象方法的函数列表和返回值类型
 *      2.
 *      若lambda参数列表中的第一个参数是实例方法的调用者,
 *      而第二个参数是实例方法的参数时,可以使用类名::方法名
 *      eg: Comparator<Integer> com = (x,y) -> x.equals(y)
 *          ==>
 *          Comparator<Integer> com = String::equals ;
 *          int result = com.compare(10,100);
 *  !!!
 *
 ***********************************************************
 *
 *  五, 构造器引用
 *      类名::new
 *
 *  !!!
 *      被调用的构造器的参数列表
 *      == 保持一致 ==
 *      函数式接口中抽象方法的参数列表
 *  !!!
 *
 ***********************************************************
 *
 *  六, 数组引用
 *      数组类型[]::new
 *
 *
 */
public class LambdaAdvancedGrammerService {

    /**
     *  四, 方法引用
     *      对象::实例方法名
     *      类名::静态方法名
     *      类名::实例方法名
     */
    public void function(){
        // 类名::实例方法名
        //old
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello old consumer");
        //new
        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("hello new consumer");

        // 对象::实例方法名
        Person person = new Person();
        System.out.println("before person = " + person);
        //old
        Consumer<String> con1 = (x) -> person.setName(x);
        con1.accept("TOM");
        System.out.println("Old person = " + person);
        //new
        Consumer<String> con2 = person::setGender;
        con2.accept(GENDER_MALE);
        System.out.println("new person age : " + person);

        // 类名::静态方法名
        //old
        Function<Integer, String> func2 = (x) -> PersonUtils.ageRangeCheck(x);
        System.out.println("old age range is " + func2.apply(30));
        //new
        Function<Integer, String > integerStringFunction = PersonUtils::ageRangeCheck;
        System.out.println("new age range is " + integerStringFunction.apply(30));

    }

    /**
     *  五, 构造器引用
     *      类名::new
     */
    public void constructor() {
        Person p1 = new Person();

        // 无参构造器
        Supplier<Person> supplier = Person::new;
        System.out.println("supplier = " + supplier.get());

        // 有参构造器
        BiFunction<String, Integer, Person> biFunction = Person::new;
        System.out.println("biFUnction = " + biFunction.apply("Jack", 28));
    }

    /**
     *  六, 数组引用
     *      数组类型[]::new
     */
    public void array() {
        List<Integer> integerList = Arrays.asList(12, 123, 124, 124);

        //old
        int num = 10;
        Integer[] ints = new Integer[num];
        System.out.println("old length = " + ints.length);
        System.out.println("old array = " + Arrays.asList(ints));

        //new
        Function<Integer, Integer[]> fun = Integer[]::new;
        System.out.println("new length = " + fun.apply(num).length);
        System.out.println("new array = " + Arrays.asList(fun.apply(num)).toString());
    }


}
