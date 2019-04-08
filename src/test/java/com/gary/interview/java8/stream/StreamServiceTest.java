/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import com.gary.interview.java8.utils.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.gary.interview.java8.utils.PersonConstants.*;

public class StreamServiceTest {
    private StreamService streamService = new StreamService();


    @Test
    public void filterGenderWithStream() {
        List<Person> personList = streamService.filterGenderWithStream();
        personList.stream().forEach(System.out::println);
        boolean allMatch = personList.stream().allMatch(person -> person.getGender().equalsIgnoreCase(GENDER_MALE));
        Assert.assertEquals(true, allMatch);
    }

    @Test
    public void filterGenderWithoutStream() {
        List<Person> personList = streamService.filterGenderWithoutStream();
        personList.stream().forEach(System.out::println);
        boolean allMatch = personList.stream().allMatch(person -> person.getGender().equalsIgnoreCase(GENDER_MALE));
        Assert.assertEquals(true, allMatch);
    }

    @Test
    public void filterGenderAndAgeWithoutStream() {
        List<Person> personList = streamService.filterGenderAndAgeWithoutStream();
        personList.stream().forEach(System.out::println);
        boolean anyMatch = personList.stream().anyMatch(person -> person.getAge() < AGE_ADULT || !person.getGender().equalsIgnoreCase(GENDER_MALE));
        Assert.assertEquals(false, anyMatch);
    }

    @Test
    public void filterGenderAndAgeWithStream() {
        List<Person> personList = streamService.filterGenderAndAgeWithStream();
        personList.stream().forEach(System.out::println);
        boolean allMatch = personList.stream().allMatch(person -> person.getGender().equalsIgnoreCase(GENDER_FEMALE) && person.getAge() >= AGE_ELDER);
        Assert.assertEquals(true, allMatch);
    }

    @Test
    public void getAllNamesWithoutStream() {
        List<String> nameList = streamService.getAllNamesWithoutStream();
        System.out.println("size : " + nameList.size());
        nameList.stream().forEach(System.out::println);
        boolean match = streamService.getPersonList().size() == nameList.size() ? true : false;
        Assert.assertEquals(true, match);
    }

    @Test
    public void getAllNamesWithStream1() {
        List<String> nameList = streamService.getAllNamesWithStream1();
        System.out.println("size : " + nameList.size());
        nameList.stream().forEach(System.out::println);
        boolean match = streamService.getPersonList().size() == nameList.size() ? true : false;
        Assert.assertEquals(true, match);
    }

    @Test
    public void getAllNamesWithStream2() {
        List<String> nameList = streamService.getAllNamesWithStream2();
        System.out.println("size : " + nameList.size());
        nameList.stream().forEach(System.out::println);
        boolean match = streamService.getPersonList().size() == nameList.size() ? true : false;
        Assert.assertEquals(true, match);
    }

    @Test
    public void getElderNameWithStream() {
        List<String> nameList = streamService.getElderNameWithStream();
        System.out.println("#### nameList=");
        nameList.stream().forEach(System.out::println);
        List<Person> allList = streamService.getPersonList();

        boolean allMatch = allList.stream()
                            .filter(person -> nameList.stream().allMatch(name -> person.getName().equalsIgnoreCase(name)))
                            .map(p -> p.getAge())
                            .allMatch(integer -> integer >= AGE_ELDER);

        Assert.assertEquals(true, allMatch);

    }
}