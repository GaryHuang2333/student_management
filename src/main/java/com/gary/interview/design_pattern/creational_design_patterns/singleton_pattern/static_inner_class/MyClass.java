/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IMyClass;

/**
 * 单例模式 : 静态内部类
 *
 * 1. 特点 :
 * 1.1. 懒加载 : 因为静态内部类(StaticInnerClass)在调用(getInstance())时才创建, 属于懒加载, 没有资源浪费风险
 * 1.2. 并发效率高 : 因为实例获取方法(getInstance())没有加同步锁, 所以效率高
 *
 * 2. 优点 : 懒加载, 资源利用率高, 并发效率高
 *
 * * 补充知识点:
 * 与类的静态代码块, 类的静态变量不同, 类的静态内部类在调用时才创建.
 *
 */
public class MyClass implements IMyClass {
    private String name = "StaticInnerClass";

    // 静态内部类
    private static class StaticInnerClass {
        private static final MyClass instance = new MyClass();
    }

    // 私有化构造器
    private MyClass() {
    }

    public static MyClass getInstance() {
        return StaticInnerClass.instance;
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
