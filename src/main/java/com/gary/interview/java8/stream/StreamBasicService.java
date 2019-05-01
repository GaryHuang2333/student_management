/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gary.interview.java8.stream.constants.StreamServiceConstants.*;

/**
 * 注意:
 * Stream自己不会存储数据
 * Stream不会改变源对象. 相反, 他们会返回一个持有结果的新Stream
 * Stream操作是延迟执行的. 这意味着他们会等到需要结果是才执行
 * <p>
 * Stream操作的三个步骤
 * - 创建Stream
 * <p>
 * - 中间操作
 * <p>
 * - 终止操作(终端操作)
 *
 *  ! 中间操作:不会执行任何结果
 *  ! 终止操作:一次性执行全部内容,即"惰性求值"
 */
public class StreamBasicService {

    /**
     * 创建Stream
     * 1. Collection.stream() / parallelStream()
     * 2. Arrays.stream()
     * 3. Stream.of()
     * 4. 创建无限流
     * 4.1 迭代
     * 4.2 生成
     *
     * @param operate
     * @return
     */
    public Stream<Integer> createStream(String operate) {
        Stream<Integer> resultStream = null;
        switch (operate) {
            case CREATE_COLLECTION:
                //1. Collection.stream() / parallelStream()
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
                resultStream = list.stream();
                break;

            case CREATE_ARRAYS:
                //2. Arrays.stream()
                Integer[] strArr = {1, 2, 3, 4, 5, 6};
                resultStream = Arrays.stream(strArr);
                break;

            case CREATE_STREAM_OF:
                // 3. Stream.of()
                resultStream = Stream.of(1, 2, 3, 4, 5, 6);
                break;

            case CREATE_STREAM_ITERATE:
                //4. 创建无限流
                //4.1 迭代
                resultStream = Stream.iterate(0, (x) -> x + 1);
                break;

            case CREATE_STREAM_GENRATE:
                //4. 创建无限流
                //4.2 生成
                resultStream = Stream.generate(() -> (int) (Math.random() * 10));
                break;

            default:
                System.out.println("Please input valid Operator.");
                break;
        }

        return resultStream;


    }

    // TODO format javadoc

    /**
     * 中间操作
     * 1. 筛选与切片
     * filter - 排除
     * limit(n) - 截断流,不超过n个元素
     * skip(n) - 跳过n个元素
     * distinct - 通过流所生成元素的hashCode()和equals()去除重复元素
     * <p>
     * 2. 映射
     * map
     * flatMap
     * <p>
     * 3. 排序
     * sorted() - 自然排序
     * sorted(Comparator com) - 定制排序
     *
     * @param stream
     * @param operator
     * @return
     */
    public Stream<Integer> operation(Stream<Integer> stream, String operator) {
        Stream<Integer> resultStream = null;

        switch (operator) {
            /**
             *  筛选与切片
             */
            // filter - 排除
            case OPERATOR_FILTER:
                resultStream = stream.filter(i -> Integer.compare(i, 10) < 0);
                break;
            // limit(n) - 截断流,不超过n个元素
            case OPERATOR_LIMIT:
                resultStream = stream.limit(10);
                break;
            // skip(n) - 跳过n个元素
            case OPERATOR_SKIP:
                resultStream = stream.skip(5);
                break;
            // distinct - 通过流所生成元素的hashCode()和equals()去除重复元素
            case OPERATOR_DISTINCT:
                resultStream = stream.distinct();
                break;

            /**
             * 映射
             */
            // map
            case OPERATOR_MAP:
                resultStream = stream.map(i -> i * -1);
                break;
            // flatMap
            case OPERATOR_FLATMAP:

                break;

            /**
             * 排序
             */
            // sorted() - 自然排序
            case OPERATOR_NATURAL_SORT:
                resultStream = stream.sorted();
                break;
            // sorted(Comparator com) - 定制排序
            case OPERATOR_SORT:
                resultStream = stream.sorted(Comparator.reverseOrder());
                break;

            default:
                System.out.println("Please input valid Operator.");
                break;
        }

        return resultStream;
    }

    /**
     * 终止操作
     * <p>
     * 1. 查找与匹配
     * allMatch
     * anyMatch
     * noneMatch
     * findFirst
     * findAny
     * count
     * max
     * min
     * foreach
     * <p>
     * 2. 归约
     * reduce(T identity, BinaryOperator) - 可以将流中的元素反复给结合起来,得到一个值
     * reduce(BinaryOperator) - 可以将流中的元素反复给结合起来,得到一个值
     * <p>
     * 3. 收集
     * collect - 将流转换为其他形式.接受一个Collector接口的实现, 用于给Stream中元素做汇总的方法
     * -> 常规操作 - Collectors.toList()
     * -> 收集到指定类型集合 - Collectors.toCollection
     * <p>
     * -> 总数量 - Collectors.counting
     * -> 平均值 - Collectors.averagingInt
     * -> 总和 - Collectors.summarizingInt
     * -> 最大值 - Collectors.maxBy
     * -> 最小值 - Collectors.minBy
     * <p>
     * -> 统计数据 - Collectors.summarizingInt
     * <p>
     * -> 分组 - Collectors.groupingBy(Function) - 按照Function的值分多组
     * -> 多级分组 - Collectors.groupingBy(Function, groupingBy(Function1)) - 大组内又按照Function1的值继续分组
     * -> 分区 - Collectors.partitioningBy - 满足条件的一个区,不满足的一个区
     * <p>
     * -> 连接字符串 - Collectors.joining(", ")
     *
     * @param stream
     * @param operator
     * @return
     */
    public Optional terminal(Stream<Integer> stream, String operator) {
        Object result = null;

        switch (operator) {
            /**
             * 1. 查找与匹配
             *
             */
            case TERMINAL_ALL_MATCH:
                result = stream.allMatch(i -> i > 5);
                break;
            case TERMINAL_ANY_MATCH:
                result = stream.anyMatch(i -> i > 5);
                break;
            case TERMINAL_NONE_MATCH:
                result = stream.noneMatch(i -> i > 5);
                break;
            case TERMINAL_FIND_FIRST:
                result = stream.findFirst().orElse(-1);
                break;
            case TERMINAL_FIND_ANY:
                result = stream.findAny().orElse(-1);
                break;
            case TERMINAL_COUNT:
                result = stream.count();
                break;
            case TERMINAL_MAX:
                result = stream.max(Integer::compareTo).orElse(-1);
                break;
            case TERMINAL_MIN:
                result = stream.min(Integer::compareTo).orElse(-1);
                break;
            case TERMINAL_FOREACH:
                stream.forEach(System.out::println);
                break;

            /**
             * 2. 归约
             *
             */
            case TERMINAL_REDUCE:
                BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
                result = stream.reduce(binaryOperator).orElse(-1);
                break;
            case TERMINAL_REDUCE_IDENTITY:
                BinaryOperator<Integer> binaryOperator1 = (x, y) -> x - y;
                result = stream.reduce(1, binaryOperator1);
                break;

            /**
             *  3. 收集
             *
             * */
            case TERMINAL_COLLECT:
                List<Integer> list = stream.collect(Collectors.toList());
                Stream<Integer> tmpStream1 = list.stream();
                Stream<Integer> tmpStream2 = list.stream();
                Stream<Integer> tmpStream3 = list.stream();
                Stream<Integer> tmpStream4 = list.stream();
                Stream<Integer> tmpStream5 = list.stream();
                Stream<Integer> tmpStream6 = list.stream();
                Stream<Integer> tmpStream7 = list.stream();
                Stream<Integer> tmpStream8 = list.stream();
                Stream<Integer> tmpStream9 = list.stream();
                Stream<Integer> tmpStream10 = list.stream();
                Stream<Integer> tmpStream11 = list.stream();
                Stream<Integer> tmpStream12 = list.stream();
                Stream<Integer> tmpStream13 = list.stream();

                //常规操作 - Collectors.toList()
                Object result1 = tmpStream1.collect(Collectors.toList());
                Object result2 = tmpStream2.collect(Collectors.toSet());
                //收集到指定类型集合 - Collectors.toCollection
                Object result3 = tmpStream3.collect(Collectors.toCollection(HashSet::new));

                //总数量 - Collectors.counting
                Object result4 = tmpStream4.collect(Collectors.counting());
                //平均值 - Collectors.averagingInt
                Object result5 = tmpStream5.collect(Collectors.averagingInt(i -> i.intValue()));
                //总和 - Collectors.summarizingInt
                Object result6 = tmpStream6.collect(Collectors.summarizingInt(i -> i.intValue()));
                //最大值 - Collectors.maxBy
                Object result7 = tmpStream7.collect(Collectors.maxBy(Integer::compare));
                //最小值 - Collectors.minBy
                Object result8 = tmpStream8.collect(Collectors.minBy(Integer::compare));

                //统计数据 - Collectors.summarizingInt
                Object result9_1 = tmpStream9.collect(Collectors.summarizingInt(Integer::intValue));
                double ave = ((IntSummaryStatistics) result9_1).getAverage();
                long count = ((IntSummaryStatistics) result9_1).getCount();
                int max = ((IntSummaryStatistics) result9_1).getMax();
                int min = ((IntSummaryStatistics) result9_1).getMin();
                long sum = ((IntSummaryStatistics) result9_1).getSum();
                String result9 = "Average-" + ave + "  Count-" + count + "  Max-" + max + "  Min-" + min + "  Sum-" + sum;

                //分组 - Collectors.groupingBy - 按照Function的值分多组
                Object result10 = tmpStream10.collect(Collectors.groupingBy(i -> i % 4));
                //多级分组 - Collectors.groupingBy(Function, groupingBy()) - 大组内又按照Function的值继续分组
                Object result11 = tmpStream11.collect(Collectors.groupingBy(i -> i % 4, Collectors.groupingBy(i -> i >= 10)));
                //分区 - Collectors.partitioningBy - 满足条件的一个区,不满足的一个区
                Object result12 = tmpStream12.collect(Collectors.partitioningBy(i -> i >= 10));

                //连接字符串 - Collectors.joining(", ")
                Object result13 = tmpStream13.map(Object::toString).collect(Collectors.joining(", "));

                result = result13;
                break;

            default:
                System.out.println("Please input valid Operator.");
                break;
        }

        return Optional.ofNullable(result);
    }

}
