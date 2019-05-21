/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern;

import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.deep_clone.DeepSheep;
import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Owner;
import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.domain.Sheep;
import com.gary.interview.design_pattern.creational_design_patterns.prototype_pattern.shallow_clone.ShallowSheep;

import java.io.*;
import java.util.Date;

/**
 * 原型模式 Prototype Design Pattern
 * <p>
 * 1. 特点
 * - 当new对象非常耗费资源时, 原型模式的克隆可以节省很多资源
 * - 基于Java中的克隆clone技术,
 * ---- 克隆对象具有原型对象的所有特点
 * ---- 克隆对象的改变不会影响原型对象
 * - 克隆的效率高, 避免了重新执行构造过程
 * <p>
 * 2. 实现
 * - 继承Cloneable接口
 * - 实现clone方法
 * <p>
 * 3. 深克隆 VS 浅克隆 (deep clone VS shallow clone)
 * 3.1 浅克隆:
 * -- 对于对象类型变量, 浅克隆只是引用的克隆, 克隆对象的变量和原型对象的变量仍指向同一内存空间, 修改会相互影响
 * 3.2 深克隆:
 * -- 让已经实现Cloneable接口的类中的属性也实现Cloneable接口
 * 3.3 深克隆的实现:
 * -- 通过序列化和反序列化实现深克隆
 * <p>
 * 4. 例子
 * - Spring中bean的创建实际就是两种: 单例模式和原型模式.
 * - (当然, 原型模式需要和工厂模式搭配起来)
 */
public class PrototypeService {

    /**
     * 3.1 浅克隆:
     * -- 对于对象类型变量, 浅克隆只是引用的克隆, 克隆对象的变量和原型对象的变量仍指向同一内存空间, 修改会相互影响
     *
     * @throws CloneNotSupportedException
     */
    public void shallowCLoneDemo() throws CloneNotSupportedException {
        Owner owner = new Owner("Jack", 28);
        ShallowSheep prototypeSheep = new ShallowSheep("sheep1", new Date(20180102l), owner);
        ShallowSheep cloneSheep = (ShallowSheep) prototypeSheep.clone();

        System.out.println("-----before change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

        cloneSheep.setName("sheep2");
        cloneSheep.getBirthday().setTime(9999999l);
        cloneSheep.getOwner().setAge(39);

        System.out.println("-----after change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

    }

    /**
     * 3.2 深克隆:
     * -- 让已经实现Cloneable接口的类中的属性也实现Cloneable接口
     *
     * @throws CloneNotSupportedException
     */
    public void deepCloneDemo() throws CloneNotSupportedException {
        Owner owner = new Owner("Jack", 28);
        DeepSheep prototypeSheep = new DeepSheep("sheep1", new Date(20180102l), owner);
        DeepSheep cloneSheep = (DeepSheep) prototypeSheep.clone();

        System.out.println("-----before change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

        cloneSheep.setName("sheep2");
        cloneSheep.getBirthday().setTime(9999999l);
        cloneSheep.getOwner().setAge(39);

        System.out.println("-----after change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

    }

    /**
     * 3.3 深克隆的实现:
     * -- 通过序列化和反序列化实现深克隆
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void deepCloneBySerialization() throws IOException, ClassNotFoundException {
        // 即使Sheep类不实现cloneable接口
        // 也可以通过序列化与反序列化实现深克隆
        Sheep prototypeSheep = new Sheep("sheep1", new Date(20180102l), new Owner("Jack", 28));

        System.out.println("-----before clone");
        System.out.println("prototypeSheep : " + prototypeSheep);

        //利用序列化和反序列化实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(prototypeSheep);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep cloneSheep = (Sheep) ois.readObject();

        System.out.println("-----before change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

        cloneSheep.setName("sheep2");
        cloneSheep.getBirthday().setTime(9999999l);
        cloneSheep.getOwner().setAge(39);

        System.out.println("-----after change");
        System.out.println("prototypeSheep : " + prototypeSheep);
        System.out.println("cloneSheep : " + cloneSheep);

    }
}
