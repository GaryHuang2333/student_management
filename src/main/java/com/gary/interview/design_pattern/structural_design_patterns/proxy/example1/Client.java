/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.proxy.example1;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("-----no proxy-----");
        client.noProxy();
        System.out.println("-----with proxy-----");
        client.withProxy();
    }

    private void noProxy(){
        StarJay jay = new StarJay();
        jay.signContract();
        jay.handleConcert();
        jay.sing();
        jay.collectMoney();
    }

    private void withProxy() {
        StarJay jay = new StarJay();
        StarProxy proxy = new StarProxy(jay);
        proxy.signContract();
        proxy.handleConcert();
        proxy.sing();
        proxy.collectMoney();
    }
}
