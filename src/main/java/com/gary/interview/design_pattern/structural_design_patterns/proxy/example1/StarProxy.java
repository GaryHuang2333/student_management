/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example1;

public class StarProxy extends StarJay implements Star {
    private String name = "proxy";
    private StarJay starJay;

    public StarProxy(StarJay starJay) {
        this.starJay = starJay;
    }
    public void sing() {
        starJay.sing();
    }

    public void signContract() {
        System.out.println(this.name + " sign contract");
    }

    public void collectMoney() {
        System.out.println(this.name + " collect money");
    }

    public void handleConcert() {
        System.out.println(this.name + " handle concert");
    }
}
