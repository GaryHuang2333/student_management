/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.builder_pattern;

import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.Airship;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.AirshipBuilder;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.AirshipDirector;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipBuilderImpl.HighAirshipBuilder;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipBuilderImpl.LowAirshipBuilder;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipBuilderImpl.MixAirshipBuilder;
import com.gary.interview.design_pattern.creational_design_patterns.builder_pattern.domain.airshipDirectorImpl.AirshipDirectorImpl;

/**
 * 建造者模式 Builder Design Pattern
 * 1. 特点
 * - 适用于复杂对象(对象中包含多种不同组件)的复杂构建(每个组件创建复杂和整体对象组装复杂)
 * - 实现了构建(Builder)和装配(Director)的解耦
 *
 * 2. 例子
 *  - StringBuilder类的append方法
 *  - SQL中的PreparedStatement
 *  - JDOM中, DomBuilder, SAXBuilder
 */
public class BuilderService {

    public void builderDemo() {

        AirshipBuilder lowBuilder = new LowAirshipBuilder();
        AirshipBuilder highBuilder = new HighAirshipBuilder();
        AirshipBuilder mixBuilder = new MixAirshipBuilder();

        AirshipDirector director = new AirshipDirectorImpl();

        Airship lowShip = director.createAirship(lowBuilder);
        Airship highShip = director.createAirship(highBuilder);
        Airship mixShip = director.createAirship(mixBuilder);

        System.out.println("lowShip = " + lowShip);
        System.out.println("highShip = " + highShip);
        System.out.println("mixShip = " + mixShip);
    }
}
