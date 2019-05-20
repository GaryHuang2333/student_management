/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IInstanceService;

/**
 * 单例模式 : 静态内部类式 (线程安全, 调用效率高, 能延时加载)
 */
public class StaticInnerClassService implements IInstanceService {
    @Override
    public MyClass getMyClassInstance() {
        return MyClass.getInstance();
    }
}
