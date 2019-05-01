/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.optional;

import com.gary.interview.java8.commonUtils.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalServiceTest {
    private OptionalService optionalService = new OptionalService();

    @Test
    public void test() {
        Person person = new Person("Tom", 18);
//        Person person = new Person(null, 18);
//        person = null;

        Optional mapOpt = optionalService.personGetName_mapTest(person);
        Optional flatMapOpt = optionalService.personGetName_flatMapTest(person);

        System.out.println("map = " + mapOpt.get());
        System.out.println("flatma p = " + flatMapOpt.get());

        System.out.println("================");
    }
}