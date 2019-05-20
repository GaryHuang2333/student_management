/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IMyClass;

/**
 * 单例模式 : 饿汉式
 * <p>
 * 1. 特点 :
 * 1.1. 饿 : 类初始化时就立即创建实例(没有延时), 若实例的创建很耗费资源, 并且后续没有调用, 则会造成资源浪费
 * 1.2. 线程安全 : 由于实例instance是静态变量, 类中有且只有一个, 所以实例获取方法(getInstance())不需要synchronize标注, 调用效率高
 * <p>
 * 2. 优点 : 并发效率高
 * <p>
 * 3. 缺点 : 资源浪费风险
 */

public class MyClass implements IMyClass {
    private static final String name = "EarlyInstantiation";
    private static MyClass instance = new MyClass();

    // 私有化构造器
    private MyClass() {
    }

    // 全局访问点
    public static /*synchronized*/ MyClass getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
