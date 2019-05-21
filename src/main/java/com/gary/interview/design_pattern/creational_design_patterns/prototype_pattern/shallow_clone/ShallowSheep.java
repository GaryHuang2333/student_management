/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.shallow_clone;

import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Owner;
import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Sheep;

import java.util.Date;

/**
 * 浅克隆的例子,
 * 克隆后, 克隆实例的birthday属性仍然指向原型实例的birthday属性的内存空间,
 * (因为: 基本数据类型变量存放的是实际的值, 而对象类型变量存放的是指针)
 * 如果改变原型实例的birthday属性, 克隆实例相应也会改变. 这里就存在问题了.
 */
public class ShallowSheep extends Sheep implements Cloneable {
    public ShallowSheep(String name, Date birthday, Owner owner) {
        super(name, birthday, owner);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //直接调用object对象的clone()方法
        return super.clone();

    }

    @Override
    public String toString() {
        return "ShallowSheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", owner=" + owner +
                '}';
    }

}
