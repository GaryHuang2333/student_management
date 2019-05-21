/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.orbitalModuleImpl;

import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.OrbitalModule;

public class HighOrbitalModule implements OrbitalModule {
    private static final String name = "HighOrbitalModule";

    public static String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HighOrbitalModule{}";
    }

}
