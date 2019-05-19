/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation.EarlyInstantiationService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums.EnumsService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums.MyClass;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.LazyInstantiationService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.StaticInnerClassService;
import org.junit.Test;

public class SingletonServiceTest {
    SingletonService singletonService = new SingletonService();


    @Test
    public void earlyInstantiationTest() {

        EarlyInstantiationService earlyService = singletonService.getEarlyInstantiationService();
        IMyClass myClassInstance1 = earlyService.getMyClassInstance();
        IMyClass myClassInstance2 = earlyService.getMyClassInstance();

//        MyClass myClass = new MyClass(); // not allow get instance just by new
        IMyClass myClass = com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation.MyClass.getInstance();

        System.out.println("instant1 = " + myClassInstance1 + "; " + myClassInstance1.hashCode());
        System.out.println("instant2 = " + myClassInstance2 + "; " + myClassInstance2.hashCode());
        System.out.println("myClass = " + myClass + "; " + myClass.hashCode());

        System.out.println("equals = " + myClassInstance1.equals(myClassInstance2));
        System.out.println("equals = " + myClassInstance1.equals(myClass));

    }

    @Test
    public void lazyInstantiationTest() {
        LazyInstantiationService lazyService = singletonService.getLazyInstantiationService();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass myClassInstance1 = lazyService.getMyClassInstance();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass myClassInstance2 = lazyService.getMyClassInstance();

        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass myClass = com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass.getInstance();

        // constructor is private.
//        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass myClass1 = new com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass();

        System.out.println("instant1 = " + myClassInstance1 + "; " + myClassInstance1.hashCode());
        System.out.println("instant2 = " + myClassInstance2 + "; " + myClassInstance2.hashCode());
        System.out.println("myClass = " + myClass + "; " + myClass.hashCode());

        System.out.println("equals = " + myClassInstance1.equals(myClassInstance2));
        System.out.println("equals = " + myClassInstance1.equals(myClass));
    }

    @Test
    public void staticInnerClassTest() {
        StaticInnerClassService staticInnerService = singletonService.getStaticInnerClassService();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass myClassInstance1 = staticInnerService.getMyClassInstance();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass myClassInstance2 = staticInnerService.getMyClassInstance();

        // constructor is private
//        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass myClass = new com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass myClass = com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.MyClass.getInstance();

        System.out.println("instant1 = " + myClassInstance1 + "; " + myClassInstance1.hashCode());
        System.out.println("instant2 = " + myClassInstance2 + "; " + myClassInstance2.hashCode());
        System.out.println("myClass = " + myClass + "; " + myClass.hashCode());

        System.out.println("equals = " + myClassInstance1.equals(myClassInstance2));
        System.out.println("equals = " + myClassInstance1.equals(myClass));
    }

    @Test
    public void enumsTest() {
        EnumsService enumsService = singletonService.getEnumsService();
        IMyClass myClassInstance1 = enumsService.getMyClassInstance();
        IMyClass myClassInstance2 = enumsService.getMyClassInstance();

        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums.MyClass myClass1 = MyClass.INSTANCE;
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums.MyClass myClass2 = MyClass.INSTANCE;

        System.out.println("instant1 = " + myClassInstance1 + "; " + myClassInstance1.hashCode());
        System.out.println("instant2 = " + myClassInstance2 + "; " + myClassInstance2.hashCode());
        System.out.println("myClass = " + myClass1 + "; " + myClass1.hashCode());
        System.out.println("myClass = " + myClass2 + "; " + myClass2.hashCode());

        System.out.println("equals = " + myClassInstance1.equals(myClassInstance2));
        System.out.println("equals = " + myClassInstance1.equals(myClass1));
        System.out.println("equals = " + myClass1.equals(myClass2));


    }

    @Test
    public void reflectionTest() {
        singletonService.breakSingletonByReflection();
    }

    @Test
    public void serializationTest() {
        singletonService.breakSingletonBySerialization();

    }

    @Test
    public void performanceTest() {
        int threadNum = 10;
        int instanceNum = 10000;
        EarlyInstantiationService earlyInstantiationService = singletonService.getEarlyInstantiationService();
        LazyInstantiationService lazyInstantiationService = singletonService.getLazyInstantiationService();
        StaticInnerClassService staticInnerClassService = singletonService.getStaticInnerClassService();
        EnumsService enumsService = singletonService.getEnumsService();

        singletonService.performanceTest(threadNum, instanceNum, earlyInstantiationService);
        singletonService.performanceTest(threadNum, instanceNum, lazyInstantiationService);
        singletonService.performanceTest(threadNum, instanceNum, staticInnerClassService);
        singletonService.performanceTest(threadNum, instanceNum, enumsService);


    }
}