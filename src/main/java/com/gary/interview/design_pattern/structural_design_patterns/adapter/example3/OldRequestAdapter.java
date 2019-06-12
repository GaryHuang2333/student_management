/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example3;

public class OldRequestAdapter implements IOldRequest {
    private NewRequest newRequest;

    public OldRequestAdapter(NewRequest newRequest) {
        this.newRequest = newRequest;
    }

    public OldRequest transfer() {
        OldRequest oldRequest = new OldRequest();
        oldRequest.setOldName(this.newRequest.getNewName());
        oldRequest.setOldGender(this.newRequest.getNewGender());
        oldRequest.setOldAge(this.newRequest.getNewAge());
        return oldRequest;
    }

    @Override
    public void postApi() {
        this.newRequest.newPostApi();
    }
}
