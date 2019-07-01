/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.behavioral_design_patterns.observer.example1;

public class MyTV implements IObserver, IDisplay {
    private String name;
    private IWeatherStation weatherStation;
    private final String separator = "################";

    public MyTV(String name, IWeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
    }

    @Override
    public void display(String content) {
        System.out.println(this.name + " Display on " + this.getClass().getSimpleName() + " screen");
        System.out.println(content);
        System.out.println(this.separator);
    }

    @Override
    public void update() {
        String content = "Humidity : " + this.weatherStation.getHumidity() + "Temperature : " + this.weatherStation.getTemperature() + "Pressure : " + this.weatherStation.getPressure();
        this.display(content);
    }
}
