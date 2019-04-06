/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.gary.interview.java8.stream.PersonConstants.GENDER_MALE;
import static org.junit.Assert.*;

public class StreamServiceTest {
    private StreamService streamService = new StreamService();

    @Test
    public void filterOutFemaleWithStream() {
        List<PersonModel> personModelList = streamService.filterOutFemaleWithStream();
        personModelList.stream().forEach(System.out::println);
        boolean allMatch = personModelList.stream().allMatch(personModel -> personModel.getGender().equalsIgnoreCase(GENDER_MALE));
        Assert.assertEquals(true, allMatch);
    }

    @Test
    public void filterOutFemaleWithoutStream() {
        List<PersonModel> personModelList = streamService.filterOutFemaleWithStream();
        personModelList.stream().forEach(System.out::println);
        boolean allMatch = personModelList.stream().allMatch(personModel -> personModel.getGender().equalsIgnoreCase(GENDER_MALE));
        Assert.assertEquals(true, allMatch);
    }

}