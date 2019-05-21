/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipDirectorImpl;

import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.*;

public class AirshipDirectorImpl implements AirshipDirector {
    @Override
    public Airship createAirship(AirshipBuilder airshipBuilder) {
        Engine engine = airshipBuilder.buildEngine();
        OrbitalModule orbitalModule = airshipBuilder.buildOrbitalModule();
        EscapeTower escapeTower = airshipBuilder.buildEscapeTower();
        return new Airship(orbitalModule, engine, escapeTower);
    }
}
