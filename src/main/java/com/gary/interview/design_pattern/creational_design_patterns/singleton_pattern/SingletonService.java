/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern;

import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation.EarlyInstantiationService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation.MyClass;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.enums.EnumsService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.LazyInstantiationService;
import com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.static_inner_class.StaticInnerClassService;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * 单例模式 :
 * 1. 核心作用 :
 * 保证一个类只有一个实例, 并且提供一个访问该实例的全局访问点
 * 2. 优点 :
 * 只生成一个实例, 减少系统开销.
 * 设置全局访问点, 优化环共享资源访问.
 * 3. 实现方式 :
 * 3.1. 饿汉式 Early Instantiation
 * - 线程安全, 调用效率高, 不能延时加载
 * 3.2. 懒汉式 Lazy Instantiation
 * - 线程安全, 调用效率低, 可延时加载
 * 3.3. 静态内部类式 static inner class
 * - 线程安全, 调用效率高, 可延时加载
 * 3.4. 枚举单例 enums
 * - 线程安全, 调用效率高, 不能延时加载, 天然防止通过反射和反序列化来破坏单例的漏洞
 * <p>
 * 4. 如何选用 ?
 * 4.1. 单例对象占用资源 少, 不需要 延时加载
 * --> 枚举式 > 饿汉式
 * 4.2. 单例对象占用资源 大, 需要 延时加载
 * --> 静态内部类 > 懒汉式
 * <p>
 * 5. 破解单例模式
 * 5.1. 通过反射, 破解(除枚举式以外)单例模式, 创建多个实例
 * 5.2. 通过序列化和反序列化, 破解(除枚举式以外)单例模式, 创建多个实例
 * <p>
 * 6. 多线程测试各种单例模式
 * 结论 :
 */
public class SingletonService {
    private EarlyInstantiationService earlyInstantiationService = new EarlyInstantiationService();
    private LazyInstantiationService lazyInstantiationService = new LazyInstantiationService();
    private StaticInnerClassService staticInnerClassService = new StaticInnerClassService();
    private EnumsService enumsService = new EnumsService();

    /**
     * 3.1. 饿汉式 Early Instantiation
     * - 线程安全, 调用效率高, 不能延时加载
     *
     * @return
     */
    EarlyInstantiationService getEarlyInstantiationService() {
        return earlyInstantiationService;
    }

    /**
     * 3.2. 懒汉式 Lazy Instantiation
     * - 线程安全, 调用效率低, 可延时加载
     *
     * @return
     */
    LazyInstantiationService getLazyInstantiationService() {
        return lazyInstantiationService;
    }

    /**
     * 3.3. 静态内部类式 static inner class
     * - 线程安全, 调用效率高, 可延时加载
     *
     * @return
     */
    StaticInnerClassService getStaticInnerClassService() {
        return staticInnerClassService;
    }

    /**
     * 3.4. 枚举单例 enums
     * - 线程安全, 调用效率高, 不能延时加载, 天然防止通过反射和反序列化来破坏单例的漏洞
     *
     * @return
     */
    EnumsService getEnumsService() {
        return enumsService;
    }

    /**
     * 5.1. 通过反射, 破解(除枚举式以外)单例模式, 创建多个实例
     */
    void breakSingletonByReflection() {
        IMyClass instance1 = earlyInstantiationService.getMyClassInstance();
        IMyClass instance2 = earlyInstantiationService.getMyClassInstance();

        Class<MyClass> myClazz = null;
        try {
            myClazz = (Class<MyClass>) Class.forName("com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.early_instantiation.MyClass");
            Constructor<MyClass> constructor = myClazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            MyClass instance3 = constructor.newInstance();
            MyClass instance4 = constructor.newInstance();

            System.out.println("breakSingletonByReflection : ");
            System.out.println("instance1 : " + instance1 + "; " + instance1.hashCode());
            System.out.println("instance2 : " + instance2 + "; " + instance2.hashCode());
            System.out.println("instance3 : " + instance3 + "; " + instance3.hashCode());
            System.out.println("instance4 : " + instance4 + "; " + instance4.hashCode());

            System.out.println("equals : 1 vs 2 = " + instance1.equals(instance2));
            System.out.println("equals : 1 vs 3 = " + instance1.equals(instance3));
            System.out.println("equals : 1 vs 4 = " + instance1.equals(instance4));
            System.out.println("equals : 3 vs 4 = " + instance3.equals(instance4));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 5.2. 通过序列化和反序列化, 破解(除枚举式以外)单例模式, 创建多个实例
     */
    void breakSingletonBySerialization() {
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass instance1 = lazyInstantiationService.getMyClassInstance();
        com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass instance2 = lazyInstantiationService.getMyClassInstance();

        try {
            // 序列化
            FileOutputStream fos = new FileOutputStream("/Users/nuojiya/IdeaProjects/springLearning/student_management/src/main/java/com/gary/interview/design_pattern/creational_design_patterns/singleton_pattern/objectOutput/breakSingletonBySerialization.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance1);
            oos.close();
            fos.close();

            // 反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/nuojiya/IdeaProjects/springLearning/student_management/src/main/java/com/gary/interview/design_pattern/creational_design_patterns/singleton_pattern/objectOutput/breakSingletonBySerialization.txt"));
            com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass instance3 = (com.gary.interview.design_pattern.creational_design_patterns.singleton_pattern.lazy_instantiation.MyClass) ois.readObject();

            System.out.println("breakSingletonBySerialization : ");
            System.out.println("instance1 : " + instance1 + "; " + instance1.hashCode());
            System.out.println("instance2 : " + instance2 + "; " + instance2.hashCode());
            System.out.println("instance3 : " + instance3 + "; " + instance3.hashCode());

            System.out.println("equals : 1 vs 2 = " + instance1.equals(instance2));
            System.out.println("equals : 1 vs 3 = " + instance1.equals(instance3));
            System.out.println("equals : 2 vs 3 = " + instance2.equals(instance3));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    void performanceTest(int threadNum, int instanceNum, IInstanceService service) {

        System.out.println();
        System.out.println("################################");
        System.out.println("#### " + service.getClass().getSimpleName() + " start ");

        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < instanceNum; i1++) {
                    Object o = service.getMyClassInstance();
                }

                countDownLatch.countDown();
            }).start();
        }

        try {
            // main线程阻塞, 直到计数器变为0, 才会继续往下执行!
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("总耗时 : " + (end - start));

        System.out.println("#### " + service.getClass().getSimpleName() + " end ");
        System.out.println("################################");
        System.out.println();
    }
}
