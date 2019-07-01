/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Bird;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.staticProxy.FlyableLogProxy;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.staticProxy.FlyableTimeProxy;

public class TestMainClass {
    public static void main(String[] args) {
        TestMainClass testMainClass = new TestMainClass();


    }

    public void staticProxyTest(){

        // Time then log
        Bird birdTommy = new Bird("Tommy");
        FlyableTimeProxy flyableTimeProxy = new FlyableTimeProxy(birdTommy);
        FlyableLogProxy flyableLogProxy = new FlyableLogProxy(flyableTimeProxy);
        flyableLogProxy.fly();

        System.out.println("###################");

        // Log then time
        Bird birdJack = new Bird("Jack");
        FlyableLogProxy flyableLogProxy2 = new FlyableLogProxy(birdJack);
        FlyableTimeProxy flyableTimeProxy2 = new FlyableTimeProxy(flyableLogProxy2);
        flyableTimeProxy2.fly();

    }

    public void dynamicProxyTest(){

    }
}
