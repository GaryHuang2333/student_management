/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.optional;


import com.gary.interview.java8.commonUtils.Person;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Optional 容器类的常用方法:
 * Optional.of(T t) : 创建一个Optional实例, 如果t是null, 会报NPE
 * Optional.empty() : 创建一个空的Optional实例
 * Optional.ofNullable(T t) : 若t不为null, 创建t的Optional实例, 否则创建空实例
 *
 * isPresent() : 判断是否包含值
 * get() : 获取optional的值, 如果调用对象是null, 会报出NPE
 * orElse(T t) : 如果调用对象包含值, 返回该值, 否则返回t
 * orElseGet(Supplier s) : 如果调用对象包含值, 返回该值, 否则返回s获取的值
 * map(Function f) : 如果有值对其处理, 并返回处理后的Optional, 否则返回Optional.empty()
 * flatMap(Function mapper) : 与map类似, 要求Function返回值必须是Optional
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class OptionalService {

    public Optional personGetName_mapTest(Person person){
        Optional<Person> optional = Optional.ofNullable(person);
        Optional<String> op = optional.map(p -> p.getName());
        return op;
    }

    public Optional personGetName_flatMapTest(Person person){
        Optional<Person> optional = Optional.ofNullable(person);
        Optional<String> op = optional.flatMap(p -> Optional.ofNullable(p.getName()));
        return op;
    }
}
