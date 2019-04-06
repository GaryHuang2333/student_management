/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import java.util.Arrays;
import java.util.List;

import static com.gary.interview.java8.stream.PersonConstants.*;


public class MockPerson {
    private static List<PersonModel> list = null;


    static{
        PersonModel p1 = new PersonModel("Tom", GENDER_MALE, 10);
        PersonModel p2 = new PersonModel("Ben", GENDER_MALE, 18);
        PersonModel p3 = new PersonModel("Jack", GENDER_MALE, 29);
        PersonModel p4 = new PersonModel("Winson", GENDER_MALE, 30);
        PersonModel p5 = new PersonModel("Jonny", GENDER_MALE, 31);
        PersonModel p6 = new PersonModel("Betty", GENDER_FEMALE, 10);
        PersonModel p7 = new PersonModel("Marry", GENDER_FEMALE, 18);
        PersonModel p8 = new PersonModel("Lily", GENDER_FEMALE, 29);
        PersonModel p9 = new PersonModel("Tiffany", GENDER_FEMALE, 30);
        PersonModel p10 = new PersonModel("Rosia", GENDER_FEMALE, 31);
        list = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public static List<PersonModel> getDate(){
        return list;
    }



}
