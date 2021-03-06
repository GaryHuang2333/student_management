/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example5;

public class KeyboardAdapter implements IUsb{
    private Ps2 ps2;

    public KeyboardAdapter(Ps2 ps2) {
        this.ps2 = ps2;
    }

    @Override
    public void type() {
            this.ps2.type();
    }
}
