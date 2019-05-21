/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.deep_clone;

import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Owner;
import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Sheep;

import java.util.Date;

/**
 * 深克隆的例子,
 * 克隆后, 克隆实例和原型实例的birthday属性分别指向不用的内存空间.
 * 改变其中一个不会影响另外一个.
 */
public class DeepSheep extends Sheep implements Cloneable {

    public DeepSheep(String name, Date birthday, Owner owner) {
        super(name, birthday, owner);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //直接调用object对象的clone()方法
        Object obj = super.clone();

        // 添加如下代码实现深复制
        DeepSheep sheep = (DeepSheep) obj;
        //把属性也克隆
        sheep.birthday = (Date) this.birthday.clone();
        sheep.owner = (Owner) this.owner.clone();

        return sheep;
    }

    @Override
    public String toString() {
        return "DeepSheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", owner=" + owner +
                '}';
    }
}
