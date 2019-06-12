/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example3;

public class Client {
    public static void main(String[] args) {
        new Client().handleNewRequest();
    }

    /**
     * handle old request , no need to adapter
     */
    public void handleOldRequest(){
        OldRequest oldRequest = new OldRequest();
        oldRequest.setOldName("OQ1");
        oldRequest.setOldAge("20");
        oldRequest.setOldGender("male");

        Api api = new Api();
        api.handleRequest(oldRequest);
    }

    public void handleNewRequest() {
        NewRequest newRequest = new NewRequest();
        newRequest.setNewName("NQ1");
        newRequest.setNewAge("30");
        newRequest.setNewGender("female");

        Api api = new Api();
        //api cannot handle new request, so we need a adapter
        //api.handleRequest(newRequest);

        //OldRequestAdapter Adaptee Target
        // Target - oldRequest - interface Request
        // Adaptee - newRequest
        // OldRequestAdapter - implements interface Request, with newRequest

        OldRequestAdapter oldRequestAdapter = new OldRequestAdapter(newRequest);
        api.handleRequest(oldRequestAdapter);

    }
}
