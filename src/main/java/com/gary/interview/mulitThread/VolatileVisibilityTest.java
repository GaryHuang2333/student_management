/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.mulitThread;

public class VolatileVisibilityTest {
    public static void main(String[] args) throws InterruptedException {
//        VisibilityNoVolatile.test();
        VisibilityWithVolatile.test();
    }

}

class VisibilityWithVolatile {
    private static volatile boolean exitLoop = false;

    public static void test() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin loop");

                while (!exitLoop) {
                }

                System.out.println("end loop");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin change exit ind ");
                exitLoop = true;
                System.out.println("end change exit ind ");


            }
        }).start();
    }

}

class VisibilityNoVolatile {
    private boolean exitLoop = false;

    public void test() throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin loop");

                while (!exitLoop) {
                }

                System.out.println("end loop");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin change exit ind ");
                exitLoop = true;
                System.out.println("end change exit ind ");


            }
        }).start();
    }
}
