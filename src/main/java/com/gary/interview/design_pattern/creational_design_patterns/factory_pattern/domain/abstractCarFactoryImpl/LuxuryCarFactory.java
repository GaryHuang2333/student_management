/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.abstractCarFactoryImpl;

import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.*;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.engineImpl.LuxuryEngine;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.seatImpl.LuxurySeat;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.tyreImpl.LuxuryTyre;

public class LuxuryCarFactory implements AbstractCarFactory {

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }

    @Override
    public String toString() {
        return "LuxuryCarFactory{}";
    }
}
