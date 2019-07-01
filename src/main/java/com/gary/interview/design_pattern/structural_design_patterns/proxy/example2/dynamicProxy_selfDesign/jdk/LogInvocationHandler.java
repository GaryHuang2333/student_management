/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example2.dynamicProxy_selfDesign.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class LogInvocationHandler implements InvocationHandler {
    Object targetObject;

    public Object getProxyInstance(Object targetObject){
        Class<?> clazz = targetObject.getClass();
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start log");
        Object returnObj = method.invoke(targetObject, args);
        System.out.println("End log");
        return returnObj;
    }
}
