/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.commonUtils;

import java.util.Arrays;
import java.util.List;

public class MockTransaction {
    private static List<Transaction> transactionList=null;
    private static List<Trader> traderList = null;


    static{
        traderList = Arrays.asList(
                new Trader("Raoul","Cambridge"),
                new Trader("Mario","Milan"),
                new Trader("Alan","Cambridge"),
                new Trader("Brain","Cambridge")
        );

        transactionList = Arrays.asList(
                new Transaction(traderList.get(3), 2011, 300),
                new Transaction(traderList.get(0), 2012, 1000),
                new Transaction(traderList.get(0), 2011, 400),
                new Transaction(traderList.get(1), 2012, 710),
                new Transaction(traderList.get(1), 2012, 700),
                new Transaction(traderList.get(2), 2012, 950)

        );
    }




    public static List<Transaction> getData(){
        return transactionList;
    }
}
