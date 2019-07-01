/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain;

import java.util.Random;

/**
 * This class could not be change
 */
public class AirCraft implements Flyable {
    private String name;

    public AirCraft(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " " + name + " aircraft is flying ...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " " + name + " aircraft is charging ...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void spark() {
        System.out.println(this.getClass().getSimpleName() + " " + name + " aircraft engine make big noise ...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
