/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter.example3;

public class NewRequest {
    private String newName;
    private String newAge;
    private String newGender;

    public NewRequest() {
    }

    public NewRequest(String newName, String newAge, String newGender) {
        this.newName = newName;
        this.newAge = newAge;
        this.newGender = newGender;
    }

    public void newPostApi(){
        System.out.println("newRequest new post Api - " + this.toString());
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewAge() {
        return newAge;
    }

    public void setNewAge(String newAge) {
        this.newAge = newAge;
    }

    public String getNewGender() {
        return newGender;
    }

    public void setNewGender(String newGender) {
        this.newGender = newGender;
    }

    @Override
    public String toString() {
        return "NewRequest{" +
                "newName='" + newName + '\'' +
                ", newAge='" + newAge + '\'' +
                ", newGender='" + newGender + '\'' +
                '}';
    }
}
