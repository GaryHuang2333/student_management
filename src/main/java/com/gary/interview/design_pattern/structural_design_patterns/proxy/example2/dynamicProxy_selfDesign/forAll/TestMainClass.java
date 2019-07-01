/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.dynamicProxy_selfDesign.forAll;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.AirCraft;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Bird;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;

import java.lang.reflect.Method;

public class TestMainClass {
    private static TestMainClass testMainClass = new TestMainClass();
    public static void main(String[] args) {
        try {
            testMainClass.testAirCraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testBird() throws Exception {
        Bird bird = new Bird("Jerry");
        InvocationHandler handler = new MyInvocationHandler(bird);
        Object proxyInstance = Proxy.newProxyInstance(Flyable.class, handler);

        Method[] methods = Flyable.class.getMethods();
        for(Method method : methods){
            handler.invoke(proxyInstance, method, new Object[] {});
            System.out.println("###############");

        }
    }

    public void testAirCraft() throws Exception {
        AirCraft airCraft = new AirCraft("A380");
        InvocationHandler handler = new MyInvocationHandler(airCraft);
        Object proxyInstance = Proxy.newProxyInstance(Flyable.class, handler);

        Method[] methods = Flyable.class.getMethods();
        for(Method method : methods){
            handler.invoke(proxyInstance, method, new Object[] {});
            System.out.println("###############");

        }
    }

}
