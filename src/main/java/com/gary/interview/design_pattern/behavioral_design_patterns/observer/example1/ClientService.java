/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.behavioral_design_patterns.observer.example1;

public class ClientService {
    public static void main(String[] args) {
        GZWeatherStation gzWeatherStation = new GZWeatherStation();

        IObserver myPhone1 = new MyPhone("nokia", gzWeatherStation);
        IObserver myPhone2 = new MyPhone("iphone", gzWeatherStation);
        IObserver myPhone3 = new MyPhone("xiaomi", gzWeatherStation);
        IObserver myPhone4 = new MyPhone("p30", gzWeatherStation);

        IObserver myWatch1 = new MyWatch("iWatch", gzWeatherStation);
        IObserver myWatch2 = new MyWatch("miWatch", gzWeatherStation);

        IObserver myTV1 = new MyTV("xiaomiTV", gzWeatherStation);
        IObserver myTV2 = new MyTV("leshiTV", gzWeatherStation);
        IObserver myTV3 = new MyTV("sonyTV", gzWeatherStation);

        gzWeatherStation.add(myPhone1);
        gzWeatherStation.add(myPhone2);
        gzWeatherStation.add(myPhone3);
        gzWeatherStation.add(myPhone4);
        gzWeatherStation.add(myWatch1);
        gzWeatherStation.add(myWatch2);
        gzWeatherStation.add(myTV1);
        gzWeatherStation.add(myTV2);
        gzWeatherStation.add(myTV3);

        gzWeatherStation.myNotify();
    }
}
