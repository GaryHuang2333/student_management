/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IMyClass;

/**
 * 单例模式 : 枚举单例
 *
 * 1. 特点 :
 * 1.1. 天然单例
 * 1.2. 没有延时加载
 * 1.3. JVM保障, 避免通过反射和反序列化来破坏单例的漏洞
 *
 */
public enum MyClass implements IMyClass {

    // 定义一个枚举的元素, 他代表了Singleton的一个实例
    INSTANCE;

    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation() {
        // 功能处理
    }
}
