/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.escapeTowerImpl;

import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.EscapeTower;

public class HighEscapeTower implements EscapeTower {
    private static final String name = "HighEscapeTower";

    public static String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HighEscapeTower{}";
    }
}
