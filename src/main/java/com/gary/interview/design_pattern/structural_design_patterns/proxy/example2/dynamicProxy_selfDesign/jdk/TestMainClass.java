/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.dynamicProxy_selfDesign.jdk;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Bird;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Car;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Runable;

import java.lang.reflect.Method;

public class TestMainClass {


    public static void main(String[] args) {
        TestMainClass test = new TestMainClass();
        test.runnableTest();

    }

    public void flyableTest() {

        Flyable birdTom = new Bird("Tom");
        Method[] methods = Flyable.class.getMethods();

        LogInvocationHandler handler = new LogInvocationHandler();
        Object proxyInstance = handler.getProxyInstance(birdTom);

        Flyable f1 = (Flyable) proxyInstance;
        f1.spark();
        System.out.println("#######3");
        f1.eat();
        System.out.println("#######");

    }

    public void runnableTest() {
        Runable car = new Car();
        LogInvocationHandler handler = new LogInvocationHandler();
        Object proxyInstance = handler.getProxyInstance(car);
        Runable carProxy = (Runable) proxyInstance;

        carProxy.run();

    }
}
