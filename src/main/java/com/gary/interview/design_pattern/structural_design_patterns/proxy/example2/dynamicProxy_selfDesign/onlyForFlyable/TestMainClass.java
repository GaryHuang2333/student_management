/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.dynamicProxy_selfDesign.onlyForFlyable;

import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Bird;
import com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.domain.Flyable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestMainClass {
    public static void main(String[] args) {
        TestMainClass testMainClass = new TestMainClass();
        testMainClass.run();

    }

    public void compose() {
        // 生成TimeProxy源码
        try {
            Proxy.newProxyInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compile() {
        // 编译TimeProxy源码
        try {
            JavaCompiler.compile(new File(Constants.sourcePath + Constants.packagePath + Constants.className + ".java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // 加载到内存中并创建对象
        URL[] urls = new URL[0];
        try {
            urls = new URL[]{new URL("file:/" + Constants.sourcePath)};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class clazz = classLoader.loadClass(Constants.packageName + "." + Constants.className);
            Constructor constructor = clazz.getConstructor(Flyable.class);
            constructor.setAccessible(true);
            Flyable flyable = (Flyable) constructor.newInstance(new Bird("Tom"));
            flyable.fly();
            System.out.println("#################");
            flyable.eat();
            System.out.println("#################");
            flyable.spark();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
