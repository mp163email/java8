package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的几种创建方式
 * 针对集合的有一个
 * 针对数组的有两个，一个是Arrays的stream一个是Stream自己的of方法
 * 不常用的是无限流
 */
public class Create {

    @Test
    public void test1 () {

        //1-集合流：Collections接口的stream的方法
        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> stream1 = list.stream();

        //2-数组流：Arrays.stream方法
        Integer [] ints = {1, 2, 3};
        Stream<Integer> stream2 = Arrays.stream(ints);

        //3-Stream自带的Of方法--主要针对数组
        Stream<List<Integer>> stream3_1 = Stream.of(list);
        Stream<Integer> stream3_2 = Stream.of(1, 2, 3);
        Stream<Integer> stream3_3 = Stream.of(ints);

        //4-Stream的无限流 按照一定的一元操作，不停的产生数据的流，一般要限制条数，不然就是死循环
        //4-1: iterate方法，有参数，有返回值的。 Consumer类型的-从0开始，不断加2，并打印
        Stream<Integer> stream4_1 = Stream.iterate(0, (x) -> x + 2);
        stream4_1.limit(10).forEach(System.out::println);

        //4-2：gnerate方法
        Stream<Double> stream4_2 = Stream.generate(() -> Math.random());
        stream4_2.limit(10).forEach(System.out::println);

    }

}
