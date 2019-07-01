/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.dynamicProxy_selfDesign.forAll;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Bird;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Bird bird;
    private Flyable flyable;

    public MyInvocationHandler(Bird bird) {
        this.bird = bird;
    }

    public MyInvocationHandler(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void invoke(Object proxy, Method method, Object[] args) {
        System.out.println("start log time");
        long start = System.currentTimeMillis();

        try {
            method.invoke(flyable, new Object[] {});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
        System.out.println("end log time");
    }
}