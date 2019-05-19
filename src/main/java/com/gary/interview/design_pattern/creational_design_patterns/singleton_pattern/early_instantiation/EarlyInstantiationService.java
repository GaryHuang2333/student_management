/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IInstanceService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.IMyClass;

/**
 * 单例模式 : 饿汉式 (线程安全, 调用效率高, 不能延时加载)
 */
public class EarlyInstantiationService implements IInstanceService {
    @Override
    public IMyClass getMyClassInstance() {
        return MyClass.getInstance();
    }

}
