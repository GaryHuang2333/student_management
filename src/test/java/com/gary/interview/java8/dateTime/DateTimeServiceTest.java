/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.dateTime;

import org.junit.Test;

import java.time.*;

public class DateTimeServiceTest {
    DateTimeService dateTimeService = new DateTimeService();


    @Test
    public void test1() {
        dateTimeService.localDateTimeTest();
    }

    @Test
    public void test2() {
        dateTimeService.instantTest();
    }
}