/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream.constants;

public class StreamServiceConstants {
    /**
     *  创建Stream
     */
    // 1. Collection.stream() / parallelStream()
    public static final String CREATE_COLLECTION = "Collection.stream()";
    // 2. Arrays.stream()
    public static final String CREATE_ARRAYS = "Arrays.stream()";
    // 3. Stream.of()
    public static final String CREATE_STREAM_OF = "Stream.of()";
    // 4. 创建无限流
    // 4.1 迭代
    public static final String CREATE_STREAM_ITERATE = "Stream.iterate()";
    // 4.2 生成
    public static final String CREATE_STREAM_GENRATE = "Stream.generate()";


    // TODO 学习&改进enum
    public enum Create {
        COLLECTION,
        ARRAYS,
        STREAM_OF,
        STREAM_ITERATE,
        STREAM_GENERATE,
        OTHERS
    };


    /**
     * 中间操作
     */
    /* 筛选与切片 */
    // filter - 排除
    public static final String OPERATOR_FILTER = "filter";
    // limit(n) - 截断流,不超过n个元素
    public static final String OPERATOR_LIMIT = "limit";
    // skip(n) - 跳过n个元素
    public static final String OPERATOR_SKIP = "skip";
    // distinct - 通过流所生成元素的hashCode()和equals()去除重复元素
    public static final String OPERATOR_DISTINCT = "distinct";

    /* 映射 */
    // map - 将元素转换成其他形式或提取信息.接受一个函数作为参数,该函数会被应用到每一个新的元素
    public static final String OPERATOR_MAP = "map";
    // flatMap - 接受一个函数作为参数, 将流中的每个值都换成另一个流,然后把所有流连接成一个流
    public static final String OPERATOR_FLATMAP = "flatMap";

    /* 排序 */
    // sorted() - 自然排序
    public static final String OPERATOR_NATURAL_SORT = "natural_sort";
    // sorted(Comparator com) - 定制排序
    public static final String OPERATOR_SORT = "sort";


    /**
     * 终止操作
     *
     */
    /* 查找与匹配 */
    // allMatch
    public static final String TERMINAL_ALL_MATCH = "allMatch";
    // anyMatch
    public static final String TERMINAL_ANY_MATCH = "anyMatch";
    // noneMatch
    public static final String TERMINAL_NONE_MATCH = "noneMatch";
    // findFirst
    public static final String TERMINAL_FIND_FIRST = "findFirst";
    // findAny
    public static final String TERMINAL_FIND_ANY = "findAny";
    // count
    public static final String TERMINAL_COUNT = "count";
    // max
    public static final String TERMINAL_MAX = "max";
    // min
    public static final String TERMINAL_MIN = "min";
    // foreach
    public static final String TERMINAL_FOREACH = "foreach";

    /* 归约 */
    // reduce(T identity, BinaryOperator) - 可以将流中的元素反复给结合起来,得到一个值
    public static final String TERMINAL_REDUCE_IDENTITY = "reduce_identity";
    // reduce(BinaryOperator) - 可以将流中的元素反复给结合起来,得到一个值
    public static final String TERMINAL_REDUCE = "reduce";

    /* 收集 */
    // collect - 将流转换为其他形式.接受一个Collector接口的实现, 用于给Stream中元素做汇总的方法
    public static final String TERMINAL_COLLECT = "collect";



}
