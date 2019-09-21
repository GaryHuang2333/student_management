/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.mulitThread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VolatileSerialTest {
    public static void main(String[] args) throws InterruptedException {
        SerialNoVolatile.test();
    }
}

class SerialNoVolatile {
    private static String x = "0", y = "0";

    public static void test() throws InterruptedException {
        Set<String> resultSet = new HashSet();
        Map<String, String> resultMap = new HashMap<>();

        for (int i = 1; i <= 1000000; i++) {
            x = "0";
            y = "0";
            resultMap.clear();

            Thread t1 = new Thread(() -> {
                String a = x;
                y = "1";
                resultMap.put("a", a);

            });

            Thread t2 = new Thread(() -> {
                String b = y;
                x = "1";
                resultMap.put("b", b);
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            resultSet.add("a=" + resultMap.get("a") + "_&_b=" + resultMap.get("b"));
            System.out.println("{" + resultSet + "}");
        }
    }

}