/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.design_pattern.behavioral_design_patterns.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class GZWeatherStation implements IObservable, IWeatherStation {
    private List<IObserver> observerList;

    public GZWeatherStation() {
        this.observerList = new ArrayList<>();
    }

    public GZWeatherStation(List<IObserver> observerList) {
        this.observerList = observerList;
    }

    public List<IObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<IObserver> observerList) {
        this.observerList = observerList;
    }

    @Override
    public void add(IObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void myNotify() {
        this.observerList.stream().forEach(IObserver::update);
    }

    @Override
    public int getTemperature() {
        return 60;
    }

    @Override
    public int getPressure() {
        return 80;
    }

    @Override
    public int getHumidity() {
        return 90;
    }
}
