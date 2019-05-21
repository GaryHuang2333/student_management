/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipBuilderImpl;

import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.AirshipBuilder;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.Engine;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.EscapeTower;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.OrbitalModule;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.engineImpl.LowEngine;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.escapeTowerImpl.LowEscapeTower;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.orbitalModuleImpl.LowOrbitalModule;

public class LowAirshipBuilder implements AirshipBuilder {
    @Override
    public Engine buildEngine() {
        return new LowEngine();
    }

    @Override
    public OrbitalModule buildOrbitalModule() {
        return new LowOrbitalModule();
    }

    @Override
    public EscapeTower buildEscapeTower() {
        return new LowEscapeTower();
    }
}
