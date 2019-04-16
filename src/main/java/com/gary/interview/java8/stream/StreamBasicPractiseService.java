/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import com.gary.interview.java8.commonUtils.MockTransaction;
import com.gary.interview.java8.commonUtils.Person;
import com.gary.interview.java8.commonUtils.Trader;
import com.gary.interview.java8.commonUtils.Transaction;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * (上接 高级语法 StreamBasicService.java)
 * <p>
 * 1. test1
 * 给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?
 * eg: 给定[1,2,3,4,5], 返回[1,3,9,16,25]
 * <p>
 * 2. test2
 * 怎样用map和reduce方法数一数流中有多少个Person呢
 * <p>
 * 3. test3
 * 对于给定的类:
 * Trader{String name, String city}
 * Transaction{Trader trader, int year, int value}
 * TestTransaction{List<Transaction> transactions}
 * 3.1 找出2011年发生的所有交易,并按交易额排序(从低到高)
 * 3.2 交易员都在哪些不同的城市工作过?
 * 3.3 查找所有来自剑桥的交易员,并按姓名排序
 * 3.4 返回所有交易员的姓名字符串,按照字母顺序排序
 * 3.5 有没有交易员是在米兰工作的
 * 3.6 打印生活在剑桥的交易员的所有交易额
 * 3.7 所有交易中,最高的交易额是多少
 * 3.8 找到交易额最小的交易
 */
public class StreamBasicPractiseService {
    private List<Transaction> transactionList = MockTransaction.getData();

    /**
     * 1. test1
     * 给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?
     * eg: 给定[1,2,3,4,5], 返回[1,3,9,16,25]
     */
    public List<Integer> powIntegerStream(List<Integer> list) {
        return list.stream().map(i -> (int) Math.pow(i, 2)).collect(Collectors.toList());
    }

    /**
     * 2. test2
     * 怎样用map和reduce方法数一数流中有多少个Person呢
     *
     * @param list
     * @return
     */
    public int countPersonInStream(List<Person> list) {
        Optional<Integer> num = list.stream().map(Person::getName).distinct().map(name -> StringUtils.isEmpty(name) ? 0 : 1).reduce((x, y) -> x + y);
        return num.orElse(0);
    }


    /**
     * 3.1 找出2011年发生的所有交易,并按交易额排序(从低到高)
     */
    public List<Transaction> getTransactionByYearASC(int year) {
        List<Transaction> list = transactionList.stream().filter(x -> x.getYear() == year).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        return list;
    }

    /**
     * 3.2 交易员都在哪些不同的城市工作过?
     */
    public String getDistinctCitiesOfTraders() {
        String cityStr = transactionList.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().sorted().collect(Collectors.joining(", "));
        return cityStr;
    }

    /**
     * 3.3 查找所有来自剑桥的交易员,并按姓名排序
     */
    public List<Trader> getTradersFromCityOrderByName(String city) {
        List<Trader> traderList = transactionList.stream().map(Transaction::getTrader).filter(t -> city.equalsIgnoreCase(t.getCity())).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        return traderList;
    }

    /**
     * 3.4 返回所有交易员的姓名字符串,按照字母顺序排序
     */
    public String getAllTraderNames() {
        String nameStr = transactionList.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.joining(", "));
        return nameStr;
    }

    /**
     * 3.5 有没有交易员是在米兰工作的
     */
    public boolean anyTraderInCity(String city) {
        boolean anyMatch = transactionList.stream().map(Transaction::getTrader).anyMatch(t -> city.equalsIgnoreCase(t.getCity()));
        return anyMatch;
    }

    /**
     * 3.6 打印生活在剑桥的交易员的所有交易额
     */
    public String getAllValueFromCityTrader(String city) {
        String valueStr = transactionList.stream().filter(t -> city.equalsIgnoreCase(t.getTrader().getCity())).map(Transaction::getValue).map(v -> v.toString()).collect(Collectors.joining(", "));
        return valueStr;
    }

    /**
     * 3.7 所有交易中,最高的交易额是多少
     */
    public int maxValue() {
        Optional<Integer> max = transactionList.stream().map(Transaction::getValue).max(Comparator.comparing(Integer::intValue));
        return max.orElse(0);
    }

    /**
     * 3.8 找到交易额最小的交易
     */
    public Transaction getMinValueTransaction() {
        Optional<Transaction> minTran = transactionList.stream().min(Comparator.comparingInt(Transaction::getValue));
        return minTran.orElse(new Transaction());
    }
}
