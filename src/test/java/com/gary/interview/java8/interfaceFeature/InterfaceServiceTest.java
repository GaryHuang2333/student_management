/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.interfaceFeature;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceServiceTest {
    private InterfaceService interfaceService = new InterfaceService();

    @Test
    public void conflictBetweenFatherNInterface() {
        interfaceService.conflictBetweenFatherNInterface();
    }

    @Test
    public void conflictBetweenInterfaces() {
        interfaceService.conflictBetweenInterfaces();
    }

    @Test
    public void conflictBetweenFatherNInterfaces() {
        interfaceService.conflictBetweenFatherNInterfaces();
    }

    @Test
    public void printAgeFromStaticMethod() {
        interfaceService.printAgeFromStaticMethod();
    }
}