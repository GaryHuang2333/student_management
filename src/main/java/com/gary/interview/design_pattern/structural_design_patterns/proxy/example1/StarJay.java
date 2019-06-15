/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example1;

public class StarJay implements Star {
    private String name = "Jay";

    @Override
    public void sing() {
        System.out.println(this.name + " sing");
    }

    @Override
    public void signContract() {
        System.out.println(this.name + " sign contract");
    }

    @Override
    public void collectMoney() {
        System.out.println(this.name + " collect money");
    }

    @Override
    public void handleConcert() {
        System.out.println(this.name + " handle concert");
    }
}
