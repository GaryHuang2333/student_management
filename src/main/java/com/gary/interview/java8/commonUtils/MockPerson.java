/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.commonUtils;

import java.util.Arrays;
import java.util.List;

import static com.gary.interview.java8.commonUtils.PersonConstants.GENDER_FEMALE;
import static com.gary.interview.java8.commonUtils.PersonConstants.GENDER_MALE;


public class MockPerson {
    private static List<Person> list = null;
    private static List<Person> nullList= null;


    static{
        list = Arrays.asList(
                new Person("Tom", GENDER_MALE, 10),
                new Person("Ben", GENDER_MALE, 18),
                new Person("Jack", GENDER_MALE, 29),
                new Person("Winson", GENDER_MALE, 30),
                new Person("Jonny", GENDER_MALE, 31),
                new Person("Tony", GENDER_MALE, 59),
                new Person("Jason", GENDER_MALE, 60),
                new Person("Jerry", GENDER_MALE, 70),
                new Person("Betty", GENDER_FEMALE, 10),
                new Person("Marry", GENDER_FEMALE, 18),
                new Person("Lily", GENDER_FEMALE, 29),
                new Person("Tiffany", GENDER_FEMALE, 30),
                new Person("Rosia", GENDER_FEMALE, 31),
                new Person("Wendy", GENDER_FEMALE, 59),
                new Person("Nicole", GENDER_FEMALE, 60),
                new Person("Carrie", GENDER_FEMALE, 70)
        );

        nullList = Arrays.asList(
                new Person(),
                new Person(),
                new Person(),
                new Person("Carrie", GENDER_FEMALE, 70),
                new Person()
        );

    }

    public static List<Person> getData(){
        return list;
    }

    public static List<Person> getNulData(){
        return nullList;
    }




}
