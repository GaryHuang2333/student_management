/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example1;

/**
 * 客户端类
 * (相当于例子中的笔记本, 只有USB接口)
 *
 */
public class Client {
    public void test1(Target t ){
        t.handleReq();
    }

    public void test1() {
        Client client = new Client();
        Target target = new Adapter();
        client.test1(target);
    }

    public void test2() {
        Client client = new Client();
        Target target = new Adapter2(new Adaptee());
        client.test1(target);

    }

    public static void main(String[] args) {
        new Client().test1();
        new Client().test2();
    }
}


