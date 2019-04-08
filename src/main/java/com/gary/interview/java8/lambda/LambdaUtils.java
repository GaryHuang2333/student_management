/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.lambda;

import com.gary.interview.java8.lambda.functionalInterface.MyCalculation;
import com.gary.interview.java8.lambda.functionalInterface.MyStringOpr;
import com.gary.interview.java8.commonUtils.Person;

import java.util.Comparator;

public class LambdaUtils<T, R> {

    public static String stringOpr(String str, MyStringOpr<String> myStringOpr){
        return myStringOpr.getValue(str);
    }

    public static Integer calcualtion(Long a, Long b, MyCalculation<Long, Integer> myCalculation){
        return myCalculation.operation(a, b);
    }

    public static int sort(Person a, Person b, Comparator<Person> personComparator){
        return personComparator.compare(a, b);
    }


    public T stringOpr2(T str, MyStringOpr<T> myStringOpr){
        return myStringOpr.getValue(str);
    }

    public R calcualtion2(T a, T b, MyCalculation<T, R> myCalculation){
        return myCalculation.operation(a, b);
    }


}
