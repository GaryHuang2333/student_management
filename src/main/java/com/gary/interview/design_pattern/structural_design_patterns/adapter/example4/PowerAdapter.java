/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example4;

public class PowerAdapter extends AC220V implements IDC5V {
    private AC220V power;

    public PowerAdapter(AC220V power) {
        this.power = power;
    }

    @Override
    public int output5VPower() {
        int inputPower = power.output220VPower();
        int outputPower = power.output220VPower() / 44;
        System.out.println("input power =  " + inputPower + "V; output power = " + outputPower + "V");
        return outputPower;
    }
}
