/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example4;

public class Phone {
    public static void main(String[] args) {
        new Phone().test();
    }

    public void test() {
        Phone phone = new Phone();
        AC220V ac220V = new AC220V();
        DC5V dc5V = new DC5V();
        IDC5V adapter = new PowerAdapter(ac220V);
        adapter.output5VPower();

        System.out.println("-------");
        phone.charge(adapter);
        System.out.println("-------");
        phone.charge(dc5V);
        System.out.println("-------");
        //phone.charge(ac220V); // can`t charge direct with 220V
    }

    public void charge(IDC5V power) {
        int chargePower = power.output5VPower();
        System.out.println("charging phone with " + chargePower + "V power");
    }
}
