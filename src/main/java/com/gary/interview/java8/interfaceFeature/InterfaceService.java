/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.interfaceFeature;

/**
 * Java8的接口,支持
 *
 * 默认方法
 *  default修饰
 *  具有方法体
 *      eg: default String getName(){return "name";}
 *
 * !!! tips
 *  父类方法和父接口默认方法的冲突 : 父类方法优先
 *  多个父接口默认方法的冲突 : 必须覆盖冲突方法
 *  父类方法和多个父接口默认方法的冲突 : 父类方法优先
 *
 * 静态方法
 *      eg: static int getAge(){return 18;}
 *
 *
 */
public class InterfaceService {

    /**
     * 默认方法
     */

    /**
     * 父类方法和父接口默认方法的冲突 : 类优先
     */
    class MySonClass1 extends MyFatherClass implements MyInterface1{

    }

    public void conflictBetweenFatherNInterface(){
        MySonClass1 mySonClass1 = new MySonClass1();
        System.out.println(mySonClass1.getName());;
    }

    /**
     * 多个父接口默认方法的冲突 : 必须覆盖冲突方法
     */
    class MySonClass2 implements MyInterface1, MyInterface2{
        @Override
        public String getName() {
            return MyInterface2.super.getName();
        }
    }

    public void conflictBetweenInterfaces(){
        MySonClass2 mySonClass2 = new MySonClass2();
        System.out.println(mySonClass2.getName());
    }

    /**
     * 父类方法和多个父接口默认方法的冲突 : 类优先
     */
    class MySonClass3 extends MyFatherClass implements MyInterface1, MyInterface3{

    }

    public void conflictBetweenFatherNInterfaces(){
        MySonClass3 mySonClass3 = new MySonClass3();
        System.out.println(mySonClass3.getName());;
    }

    /**
     * 静态方法
     */
    public void printAgeFromStaticMethod(){
        System.out.println(MyInterface1.getAge());
    }

}
