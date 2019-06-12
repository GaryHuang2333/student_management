/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.job_puzzle.threadlocal;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal {
    private static final Set<ThreadLocal<String>> threadLocals = Collections.newSetFromMap(new ConcurrentHashMap<ThreadLocal<String>, Boolean>());
    public static final ThreadLocal<String> testThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<String> create(){
        ThreadLocal<String> myThreadLocal = new ThreadLocal<>();
        threadLocals.add(myThreadLocal);

        return myThreadLocal;
    }
}
