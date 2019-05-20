/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation;


import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IMyClass;

import java.io.Serializable;

/**
 * 单例模式 : 懒汉式
 *
 * 1. 特点 :
 * 1.1. 懒 : 实例获取方法(getInstance())真正调用时才创建实例, 延时加载(懒加载 lazy load), 资源利用率高
 * 1.2. 线程安全: 获取方法(getInstance())每次调用都要同步, 并发效率低
 *
 * 2. 优点 : 资源利用率高
 *
 * 3. 缺点 : 并发效率低
 *
 */

public class MyClass implements Serializable, IMyClass {
    private static final String name = "LazyInstantiation";
    private static MyClass instance;

    // 私有化构造器
    private MyClass() {
    }

    // 全局访问点
    public static synchronized MyClass getInstance() {
        if (instance == null) {
            instance = new MyClass();
        }

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
