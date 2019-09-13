/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.redis;

import redis.clients.jedis.Jedis;

public class SimpleJedis {
    public static void simpleOperation() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Preparation ============");
        Jedis jedis = preparation();

        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Operation ==============");
        operation(jedis);

        System.out.println();
        System.out.println("=============================");
        System.out.println("==== Finalization ====");
        finalication(jedis);
    }

    /**
     * Preparation
     *
     * @return
     */
    private static Jedis preparation() {

        Jedis jedis = new Jedis("127.0.0.1", 6380);
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
    private static void finalication(Jedis jedis) {
        // check dbsize after all operation
        System.out.println("dbsize at last : " + jedis.dbSize());

        // get all keys after all operation
        System.out.println("all keys at last : " + jedis.keys("*"));

        // close in the end
        jedis.close();

        // check connection after close
        System.out.println("checkConnection : " + jedis.ping("connected"));
    }


    /**
     * commands of key, string, list, hash, set, zset
     *
     * @param jedis
     */
    private static void operation(Jedis jedis) {
        System.out.println("\n==== Key ================");
//        commandOfKey(jedis);
        System.out.println("\n==== String =============");
//        commandOfString(jedis);
        System.out.println("\n==== List ===============");
        commandOfList(jedis);
        System.out.println("\n==== Hash ===============");
        commandOfHash(jedis);
        System.out.println("\n==== Set ================");
        commandOfSet(jedis);
        System.out.println("\n==== ZSet ===============");
        commandOfZSet(jedis);
    }

    // commands of key
    private static void commandOfKey(Jedis jedis) {
        // get all keys
        System.out.println("all keys : " + jedis.keys("*"));

        // set key1
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");

        // check if key exists
        System.out.println("check key k1 exists : " + jedis.exists("k1"));
        System.out.println("check key k3 exists : " + jedis.exists("k3"));
        System.out.println("check key k1, k2, k3 exists : " + jedis.exists("k1", "k2", "k3"));

        // set key k1 expire time 20s
        System.out.println("set key k1 expire time 20s : " + jedis.expire("k1", 20));

        // sleep 3s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // check key k1 time to live
        System.out.println("check key k1 ttl : " + jedis.ttl("k1"));

        // check key type
        System.out.println("check key k1 type : " + jedis.type("k1"));

    }

    // commands of string
    private static void commandOfString(Jedis jedis) {
        // set key
        System.out.println("set key s1 : " + jedis.set("s1", "v1"));
        System.out.println("set key s2 : " + jedis.set("s2", "v2"));
        System.out.println("set key s3 : " + jedis.set("s3", "this is v3"));
        System.out.println("set key s4 : " + jedis.set("s4", "this is v4"));
        System.out.println("set key s5 : " + jedis.set("s5", "10"));
        System.out.println("set key s6 : " + jedis.set("s6", "10"));
        System.out.println("set key s7 : " + jedis.set("s7", "10"));
        System.out.println("set key s8 : " + jedis.set("s8", "10"));
        System.out.println("set key s9 : " + jedis.set("s9", "10.5"));
        System.out.println("set key s10 : " + jedis.set("s10", "10"));
        System.out.println("set key s11 : " + jedis.set("s11", "v11"));
        System.out.println();

        // append
        System.out.println("append key s1 \"this is appended\": " + jedis.append("s1", "this is appended"));

        // incr, decr, incrby, decrby
        System.out.println();
        System.out.println("incr s5 : " + jedis.incr("s5"));
        System.out.println("decr s6 : " + jedis.decr("s6"));
        System.out.println("incrBy s7 : " + jedis.incrBy("s7", 3));
        System.out.println("decrBy s8 : " + jedis.decrBy("s8", 3));
        System.out.println("incrByFloat s9 : " + jedis.incrByFloat("s9", 3.15));
        System.out.println();
        //System.out.println("incrByFloat s10 : " + jedis.incrByFloat("s10", 3.5)); // ERR value is not a valid float
        //System.out.println("incr s11 : " + jedis.incr("s11")); // ERR value is not an integer or out of range

        // get key
        System.out.println("get key s1 : " + jedis.get("s1"));
        System.out.println("mget s1 ~ s11 : " + jedis.mget("s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11"));

        // strlen
        System.out.println("get length of s1 : " + jedis.strlen("s1"));

        // setrange and getrange
        System.out.println("setrange of s1 [2, 5] = that : " + jedis.setrange("s1", 2, "that"));
        System.out.println("getrange of s1 [2, 5] : " + jedis.getrange("s1", 2, 5));

        // del
        System.out.println("del key s4 : " + jedis.del("s4"));

        System.out.println();

        // setex
        System.out.println("setex s12 10s : " + jedis.setex("s12", 10, "s12.ex=10"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ttl s12 : " + jedis.ttl("s12"));

        // setnx
        System.out.println("setnx s12= \"s12 setnx\" : " + jedis.setnx("s12", "s12 setnx"));
        System.out.println("get s12 value : " + jedis.get("s12"));
    }

    // commands of list
    private static void commandOfList(Jedis jedis) {
        //language=TEXT
        String commands = "\n" +
                "        jedis.lpush();\n" +
                "        jedis.rpush();\n" +
                "        jedis.lrange();\n" +
                "        jedis.lpop();\n" +
                "        jedis.rpop();\n" +
                "        jedis.lindex();\n" +
                "        jedis.llen();\n" +
                "        jedis.lrem();\n" +
                "        jedis.ltrim();\n" +
                "        jedis.rpoplpush();\n" +
                "        jedis.lset();\n" +
                "        jedis.linsert();";
        System.out.println("commands of list : " + commands);
    }

    // commands of hash
    private static void commandOfHash(Jedis jedis) {
        //language=TEXT
        String commands = "        \n" +
                "        jedis.hset();\n" +
                "        jedis.hget();\n" +
                "        jedis.hmset();\n" +
                "        jedis.hmget();\n" +
                "        jedis.hgetAll();\n" +
                "        jedis.hdel();\n" +
                "        jedis.hlen();\n" +
                "        jedis.hexists();\n" +
                "        jedis.hkeys();\n" +
                "        jedis.hvals();\n" +
                "        jedis.hincrBy();\n" +
                "        jedis.hincrByFloat();\n" +
                "        jedis.setnx();";

        System.out.println("commands of hash : " + commands);
    }

    // commands of set
    private static void commandOfSet(Jedis jedis) {
        //language=TEXT
        String commands = "\n" +
                "        jedis.sadd();\n" +
                "        jedis.smembers();\n" +
                "        jedis.sismember();\n" +
                "        jedis.scard();\n" +
                "        jedis.srandmember();\n" +
                "        jedis.spop();\n" +
                "        jedis.smove();\n" +
                "\n" +
                "        jedis.sdiff();\n" +
                "        jedis.sinter();\n" +
                "        jedis.sunion();";
        System.out.println("commands of set : " + commands);
    }

    // commands of zset
    private static void commandOfZSet(Jedis jedis) {
        //language=TEXT
        String commands = "\n" +
                "        jedis.zadd();\n" +
                "\n" +
                "        jedis.zrange();\n" +
                "        jedis.zrangeWithScores();\n" +
                "        jedis.zrangeByScore();\n" +
                "        jedis.zrangeByScoreWithScores();\n" +
                "        jedis.zrangeByLex();\n" +
                "\n" +
                "        jedis.zrem();\n" +
                "        jedis.zcard();\n" +
                "        jedis.zcount();\n" +
                "\n" +
                "        jedis.zrank();\n" +
                "        jedis.zscore();\n" +
                "        jedis.zrevrange();\n" +
                "        jedis.zrevrank();\n" +
                "        jedis.zrevrangeByScore();\";\n" +
                "        jedis.zadd();\n" +
                "\n" +
                "        jedis.zrange();\n" +
                "        jedis.zrangeWithScores();\n" +
                "        jedis.zrangeByScore();\n" +
                "        jedis.zrangeByScoreWithScores();\n" +
                "        jedis.zrangeByLex();\n" +
                "\n" +
                "        jedis.zrem();\n" +
                "        jedis.zcard();\n" +
                "        jedis.zcount();\n" +
                "\n" +
                "        jedis.zrank();\n" +
                "        jedis.zscore();\n" +
                "        jedis.zrevrange();\n" +
                "        jedis.zrevrank();\n" +
                "        jedis.zrevrangeByScore();";
        System.out.println("commands of zset : " + commands);

    }


}
