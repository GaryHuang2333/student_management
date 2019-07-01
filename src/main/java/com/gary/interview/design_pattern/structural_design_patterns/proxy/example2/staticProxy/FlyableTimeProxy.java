/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.staticProxy;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;

public class FlyableTimeProxy implements Flyable {
    private Flyable flyable;

    public FlyableTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("start log time");
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("end log time, " + this.getClass().getSimpleName() + " Flyable fly time is " + (end - start));
    }

    @Override
    public void eat() {

    }

    @Override
    public void spark() {

    }
}
