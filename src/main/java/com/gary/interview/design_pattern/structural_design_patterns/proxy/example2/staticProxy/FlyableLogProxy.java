/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.staticProxy;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;

public class FlyableLogProxy implements Flyable {
    private Flyable flyable;

    public FlyableLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("start fly");
        flyable.fly();
        System.out.println("end fly");
    }

    @Override
    public void eat() {

    }

    @Override
    public void spark() {

    }
}
