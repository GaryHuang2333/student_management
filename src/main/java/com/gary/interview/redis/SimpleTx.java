/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleTx {
    private static String host = "localhost";
    private static int ip = 6379;

    public static void tx() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Preparation ============");
        Jedis jedis = preparation(host, ip);

        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Operation ==============");
        try {
            operation6(jedis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Finalization ==============");
        finalize(new Jedis(host, ip));
    }


    /**
     * Preparation
     *
     * @return
     */
    private static Jedis preparation(String host, int port) {

        Jedis jedis = new Jedis(host, port);
        // check connection
        System.out.println("checkConnection : " + jedis.ping("connected"));

        // flushDB
        System.out.println("flush db : " + jedis.flushDB());

        // check dbsize
        System.out.println("dbsize : " + jedis.dbSize());

        return jedis;
    }

    /**
     * @param jedis
     */
    private static void finalize(Jedis jedis) {
        Set<String> keys = jedis.keys("*");
        String keyValues = keys.stream().map(key -> key + " : " + jedis.get(key)).collect(Collectors.joining("\n"));
        System.out.println("get all key-value : \n" + keyValues);
    }

    /**
     * case1 正常执行
     *
     * @param jedis
     * @throws Exception
     */
    private static void operation1(Jedis jedis) throws Exception {
        Transaction transaction = jedis.multi();
        transaction.set("k1", "v1");
        transaction.set("k2", "v2");
        transaction.set("k3", "v3");
        List<Object> execResult = transaction.exec();
        System.out.println("operation1 successfully; exec result = " + execResult);

        transaction.close();
    }

    /**
     * case 2 放弃事务
     */
    private static void operation2(Jedis jedis) {
        Transaction transaction = jedis.multi();
        transaction.set("k1", "v1");
        transaction.set("k2", "v2");
        transaction.set("k3", "v3");
        String discardResult = transaction.discard();
        System.out.println("operation2 successfully; discard result = " + discardResult);

        transaction.close();
    }

    /**
     * case 3 全体连坐
     *
     * @param jedis
     */
    private static void operation3(Jedis jedis) throws Exception {
        boolean falseInd = true;
        Transaction transaction = jedis.multi();
        transaction.set("k1", "v1");
        transaction.set("k2", "v2");
        transaction.set("k3", "v3");
        if (falseInd) {
            throw new Exception("false inside transaction");
        }
        List<Object> execResult = transaction.exec();
        System.out.println("operation3 successfully; exec result = " + execResult);

        transaction.close();

    }

    /**
     * case 4 冤头债主
     *
     * @param jedis
     */
    private static void operation4(Jedis jedis) {
        Transaction transaction = jedis.multi();
        transaction.set("k1", "v1");
        transaction.incr("k1"); // opr fail, k1 still = v1, but other tx run successfully
        transaction.incr("v1");
        transaction.set("k2", "v2");
        transaction.set("k3", "v3");
        transaction.incrBy("k3", 10); // opr fail, k3 still = v3, but other tx run successfully
        transaction.set("k4", "4");
        transaction.incr("k4");
        List<Object> execResult = transaction.exec();
        System.out.println("operation4 successfully; exec result = " + execResult);

        transaction.close();
    }

    /**
     * case 5.1 [watch监控] 没有加塞篡改
     *
     * @param jedis
     */
    private static void operation5_1(Jedis jedis) {
        String balanceKey = "balance";
        String debtKey = "debt";

        String balanceValue = "0";
        String debtValue = "0";

        String difference = "20";

        jedis.mset(balanceKey, "100", debtKey, "0");
        balanceValue = jedis.get(balanceKey);
        debtValue = jedis.get(debtKey);
        System.out.println(balanceKey + "=" + balanceValue);
        System.out.println(debtKey + "=" + debtValue);

        String watch = jedis.watch(balanceKey, debtKey);
        Transaction transaction = jedis.multi();
        transaction.decrBy(balanceKey, Long.valueOf(difference));
        transaction.incrBy(debtKey, Long.valueOf(difference));
        List<Object> execResult = transaction.exec();

        System.out.println("operation5_1 successfully, difference = " + difference + "; exec result = " + execResult);
    }

    /**
     * case 5.2 [watch监控] watch后, multi前, 有加塞篡改
     *
     * @param jedis
     */
    private static void operation5_2(Jedis jedis) {
        String balanceKey = "balance";
        String debtKey = "debt";

        String balanceValue = "0";
        String debtValue = "0";

        String difference = "20";

        jedis.mset(balanceKey, "100", debtKey, "0");
        balanceValue = jedis.get(balanceKey);
        debtValue = jedis.get(debtKey);
        System.out.println(balanceKey + "=" + balanceValue);
        System.out.println(debtKey + "=" + debtValue);

        String watch = jedis.watch(balanceKey, debtKey);

        // watch后, multi前, 有加塞篡改
        change(balanceKey, "200");

        Transaction transaction = jedis.multi();
        transaction.decrBy(balanceKey, Long.valueOf(difference));
        transaction.incrBy(debtKey, Long.valueOf(difference));
        List<Object> execResult = transaction.exec();

        System.out.println("operation5_2 successfully, difference = " + difference + "; exec result = " + execResult);
    }


    /**
     * case 5.3 [watch监控] watch后, multi期间, 有加塞篡改
     *
     * @param jedis
     */
    private static void operation5_3(Jedis jedis) {
        String balanceKey = "balance";
        String debtKey = "debt";

        String balanceValue = "0";
        String debtValue = "0";

        String difference = "20";

        jedis.mset(balanceKey, "100", debtKey, "0");
        balanceValue = jedis.get(balanceKey);
        debtValue = jedis.get(debtKey);
        System.out.println(balanceKey + "=" + balanceValue);
        System.out.println(debtKey + "=" + debtValue);

        String watch = jedis.watch(balanceKey, debtKey);

        Transaction transaction = jedis.multi();
        transaction.decrBy(balanceKey, Long.valueOf(difference));
        transaction.incrBy(debtKey, Long.valueOf(difference));

        // watch后, multi期间, 有加塞篡改
        change(balanceKey, "200");

        List<Object> execResult = transaction.exec();

        System.out.println("operation5_3 successfully, difference = " + difference + "; exec result = " + execResult);
    }

    /**
     * case 6 unwatch
     * <p>
     * 如果watch的key因为加塞篡改导致事务被打断
     * 解决办法 : 先unwatch, 再watch, 再重新执行事务.
     *
     * @param jedis
     */
    private static void operation6(Jedis jedis) {
        String balanceKey = "balance";
        String debtKey = "debt";

        String balanceValue = "0";
        String debtValue = "0";

        String difference = "20";
        int i = 0;

        jedis.mset(balanceKey, "100", debtKey, "0");
        System.out.println(balanceKey + "=" + jedis.get(balanceKey));
        System.out.println(debtKey + "=" + jedis.get(debtKey));

        List<Object> execResult = null;

        while (execResult == null) {
            jedis.unwatch();
            jedis.watch(balanceKey, debtKey);

            if (i <= 5) {
                change(balanceKey, String.valueOf(i));
                i ++;
            }

            Transaction transaction = jedis.multi();
            transaction.decrBy(balanceKey, Long.valueOf(difference));
            transaction.incrBy(debtKey, Long.valueOf(difference));

            execResult = transaction.exec();

            System.out.println(balanceKey + "=" + jedis.get(balanceKey));
            System.out.println(debtKey + "=" + jedis.get(debtKey));
            System.out.println("operation6 successfully, difference = " + difference + "; exec result = " + execResult);
        }
    }

    private static void change(String key, String value) {
        Jedis jedis = new Jedis(host, ip);
        jedis.set(key, value);
    }
}
