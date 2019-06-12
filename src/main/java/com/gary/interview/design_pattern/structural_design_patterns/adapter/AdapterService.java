/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.structural_design_patterns.adapter;

/**
 * 适配器模式 :
 * 例子1 : 手机电源适配器
 * - 220V交流电 -> 适配器 -> 5V直流电
 * - Target : 5V直流电, 方法释放5V直流电
 * - Adaptee : 220V交流电, 方法释放220V交流电
 * - Adapter :
 * -- implements Target(5V直流电)
 * -- 成员变量 Adaptee(220V交流电)
 * -- 方法 : 实现 释放5V直流电 : Adaptee.220V交流电/44
 *
 *
 *
 */
public class AdapterService {
}
