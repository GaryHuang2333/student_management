/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import static com.gary.interview.java8.stream.constants.StreamServiceConstants.*;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamBasicServiceTest {
    private StreamBasicService service = new StreamBasicService();

    @Test
    public void streamTest() {
        Stream<Integer> stream = service.createStream(CREATE_STREAM_ITERATE);
        Stream<Integer> temp1 =  service.operation(stream, OPERATOR_LIMIT);
        Stream<Integer> temp2 = service.operation(temp1, OPERATOR_SKIP);
        Stream<Integer> temp3 = service.operation(temp2, OPERATOR_SORT);
        temp3.forEach(System.out::print);
    }

    @Test
    public void reduceTest() {
        Stream<Integer> stream =  service.createStream(CREATE_STREAM_ITERATE).limit(10);
//        stream.forEach(System.out::print);
        Optional result = service.terminal(stream, TERMINAL_REDUCE);
        System.out.println(result.orElse("no result"));

        Stream<Integer> stream1 =  service.createStream(CREATE_STREAM_ITERATE).limit(10);
        Optional result1 = service.terminal(stream1, TERMINAL_REDUCE_IDENTITY);
        System.out.println(result1.orElse("no result"));

        Stream<Integer> stream2 =  service.createStream(CREATE_STREAM_ITERATE).limit(10);
        Optional result2 = service.terminal(stream2, TERMINAL_FOREACH);
        System.out.println(result2.orElse("no result"));
    }

    @Test
    public void collectTest() {
        Stream<Integer> stream =  service.createStream(CREATE_STREAM_ITERATE).limit(20);
        Optional result =  service.terminal(stream, TERMINAL_COLLECT);
        System.out.println(result.orElse("no result"));
    }
}