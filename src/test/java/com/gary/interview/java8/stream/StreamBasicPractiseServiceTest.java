/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import com.gary.interview.java8.commonUtils.MockPerson;
import com.gary.interview.java8.commonUtils.Person;
import com.gary.interview.java8.commonUtils.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StreamBasicPractiseServiceTest {
    StreamBasicPractiseService service = new StreamBasicPractiseService();

    @Test
    public void powIntegerStream() {
        List<Integer> list = Arrays.asList(2,3,4,5,6);
        System.out.println(service.powIntegerStream(list));
    }

    @Test
    public void countPersonInStream() {
        List<Person> list = MockPerson.getNulData();
        System.out.println("Num = " + service.countPersonInStream(list));
    }

    @Test
    public void getTransactionByYearASC() {
        List<Transaction> list = service.getTransactionByYearASC(2011);
        System.out.println(list);
    }

    @Test
    public void getDistinctCitiesOfTraders() {
        System.out.println(service.getDistinctCitiesOfTraders());
    }

    @Test
    public void getTradersFromCityOrderByName() {
        System.out.println(service.getTradersFromCityOrderByName("Cambridge"));
    }

    @Test
    public void getAllTraderNames() {
        System.out.println(service.getAllTraderNames());
    }

    @Test
    public void anyTraderInCity() {
        System.out.println(service.anyTraderInCity("Milan"));
    }

    @Test
    public void getAllValueFromCityTrader() {
        System.out.println(service.getAllValueFromCityTrader("Cambridge"));
    }

    @Test
    public void maxValue() {
        System.out.println(service.maxValue());
    }

    @Test
    public void getMinValueTransaction() {
        System.out.println(service.getMinValueTransaction());
    }
}