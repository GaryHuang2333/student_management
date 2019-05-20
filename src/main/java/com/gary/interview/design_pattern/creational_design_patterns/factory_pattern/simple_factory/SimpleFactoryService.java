/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.simple_factory;

import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.*;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carImpl.Audi;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carImpl.Benz;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carImpl.Cadillac;
import com.gary.interview.design_pattern.creational_design_patterns.factory_pattern.domain.carImpl.Honda;

/**
 * 简单工厂模式 SimpleFactory
 * 又叫 静态工厂方法 StaticFactory
 * <p>
 * - 用于生产同一等级结构中的固定产品.
 * - 违反OCP 开闭原则(对于新增加的产品, 需要修改已有代码)
 */
public class SimpleFactoryService {

    // 方式一
    public static Car getCarInstance(String name) {

        switch (name) {
            case CarConstant.AUDI:
                return new Audi();
            case CarConstant.BENZ:
                return new Benz();
            case CarConstant.CADILLAC:
                return new Cadillac();
            case CarConstant.HONDA:
                return new Honda();
            default:
                return null;
        }
    }

    // 方式二
    public static Car getAudiInstance() {
        return new Audi();
    }

    // 方式二
    public static Car getBenzInstance() {
        return new Benz();
    }

    // 方式二
    public static Car getHondaInstance() {
        return new Honda();
    }

    // 方式二
    public static Car getCadillac() {
        return new Cadillac();
    }

}
