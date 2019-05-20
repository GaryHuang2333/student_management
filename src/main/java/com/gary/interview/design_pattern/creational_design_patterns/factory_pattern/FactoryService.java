/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.factory_pattern;

import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.*;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.abstractCarFactoryImpl.LowCarFactory;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.abstractCarFactoryImpl.LuxuryCarFactory;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carFactoryImpl.AudiFactory;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carFactoryImpl.BenzFactory;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carFactoryImpl.CadillacFactory;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.simple_factory.SimpleFactoryService;

/**
 * 工厂模式 Factory Design Patterns
 * 1. 特点 :
 * - 实现了创建者和调用者的分离解耦
 * - 用工厂方法代替new操作来实例化对象
 * <p>
 * 2. 面向对象设计的基本原则 :
 * - OCP (开闭原则 Open-Closed Principle) : 对拓展开放, 对修改关闭.
 * - DIP (依赖倒转原则 Dependence Inversion Principle) : 要针对接口编程, 不要针对实现编程.
 * - LoD (迪米特法则 Law of Demeter) : 只与你直接的朋友通信, 而避免和陌生人通信.
 * <p>
 * 3. 实现方式 :
 * 3.1. 简单工厂模式 simple factoryImpl
 * - 用于生产同一等级结构中的固定产品.
 * - 违反OCP 开闭原则 (对于新增加的产品, 需要修改已有代码)
 * <p>
 * 3.2. 工厂方法模式 factoryImpl method
 * - 用于生产同一等级结构中的任意产品. (支持增加任意产品)
 * - 通过增加工厂接口的实现类, 而不是修改原有工厂接口, 来扩展功能, 满足OCP开闭原则
 * <p>
 * 3.3. 抽象工厂模式 abstract factoryImpl
 * - 用于生产不同产品族的全部产品. (对于增加新产品, 无能为力, 支持增加产品族)
 */
public class FactoryService {
//    private SimpleFactoryService simpleFactoryService = new SimpleFactoryService();


    /**
     * 3.1. 简单工厂模式 simple factory
     * - 用于生产同一等级结构中的固定产品.
     * - 违反OCP 开闭原则 (对于新增加的产品, 需要修改已有代码)
     */
    public void simpleFactoryDemo() {

        // 方式一
        Car car1 = SimpleFactoryService.getCarInstance(CarConstant.HONDA);
        Car car2 = SimpleFactoryService.getCarInstance(CarConstant.CADILLAC);
        Car car3 = SimpleFactoryService.getCarInstance(CarConstant.BENZ);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        // 方式二
        Car car4 = SimpleFactoryService.getAudiInstance();
        System.out.println(car4);

    }

    /**
     * 3.2. 工厂方法模式 factory method
     * - 用于生产同一等级结构中的任意产品. (支持增加任意产品)
     * - 通过增加工厂接口的实现类, 而不是修改原有工厂接口, 来扩展功能, 满足OCP开闭原则
     */
    public void factoryMethodDemo() {

        Car car1 = AudiFactory.getCar();
        Car car2 = BenzFactory.getCar();
        Car car3 = CadillacFactory.getCar();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }


    /**
     * 3.3. 抽象工厂模式 abstract factoryImpl
     * - 用于生产不同产品族的全部产品. (对于增加新产品, 无能为力, 支持增加产品族)
     * <p>
     * LowTyre + LowSeat + LowEngine 组成了LowCar 产品族
     * LuxuryTyre + LuxurySeat + LuxuryEngine 组成了LuxuryCar 产品族
     */
    public void abstractFactoryDemo() {
        LowCarFactory lowCarFactory = new LowCarFactory();
        Engine lowEngine = lowCarFactory.createEngine();
        Seat lowSeat = lowCarFactory.createSeat();
        Tyre lowTyre = lowCarFactory.createTyre();
        AbstractCar lowCar = new AbstractCar(lowEngine, lowSeat, lowTyre);

        LuxuryCarFactory luxuryCarFactory = new LuxuryCarFactory();
        Engine luxuryEngine = luxuryCarFactory.createEngine();
        Seat luxurySeat = luxuryCarFactory.createSeat();
        Tyre luxuryTyre = luxuryCarFactory.createTyre();
        AbstractCar luxuryCar = new AbstractCar(luxuryEngine, luxurySeat, luxuryTyre);


        System.out.println(lowCar);
        System.out.println(luxuryCar);
    }
}
