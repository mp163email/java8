package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * stream API 使用注意事项
 * 1.stream 不修改数据源
 * Stream流不是一种数据结构，不保存数据，它只是在原数据集上定义了一组操作，所以不会修改原数据。
 * 2.Stream对象只能使用一次，Stream不保存数据，故每个Stream流只能使用一次
 * 3.Stream的操作是惰性的，流只有在终止操作（Terminal operation）的时候才会进行计算
 */

/**
 * 终止操作API
 * Stream API具有中间操作和结束操作
 * 中间操作有：peek、flatMap、limit、sort、distinct、map、filter
 * 结束操作有：noneMatch、allMatch、collect、findAny、findFirst、
 * anyMatch、toArray、reduce、min、max、forEach、collect、count等。
 *
 *  * map(映射），对单个元素进行计算或者筛选，然后映射成一组新的元素
 *  * reduce(规约),对map映射以后的元素，进行迭代计算，比如求和等
 */
public class Result2 {

    /**
     * collect
     * 最常用的终止操作，
     * 返回一个集合
     * 接受一个Collector实例，将流中元素收集成另外的数据结构
     */
    @Test
    public void collect () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> collects = numbers.stream().map(x -> (int)Math.pow(x, 3)).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * count
     * 返回long型的总个数
     * 隶属于reduce,因为常用，被收录到标准库
     */
    @Test
    public void count () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        long count = numbers.stream().count();
        System.out.println(count);
    }

    /**
     * max
     * 返回最大值
     * 隶属于reduce,因为常用，被收录到标准库
     */
    @Test
    public void max () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().max((x, y) -> (x - y) < 0 ? -1 : ((x == y) ? 0 : 1)).get());
    }

    /**
     * min{}
     * 返回最小值
     * 隶属于reduce,因为常用，被收录到标准库
     */
    @Test
    public void min() {
        List<Integer> numbers = Arrays.asList(11,2,3,4,5);
        System.out.println(numbers.stream().min(Integer::compareTo).get());
    }

    /**
     * allMatch
     * 返回一个boolean
     * 接受一个 Predicate 函数，全部元素都满足该断言则返回true，否则返回false
     */
    @Test
    public void allMatch() {
        List<Integer> numbers = Arrays.asList(-1,2,3,4,5);
        boolean allmatch = numbers.stream().allMatch(x -> x > 0);
        System.out.println(allmatch);
    }

    /**
     * anyMatch
     * 返回一个boolean
     * 接受一个 Predicate 函数，只要有一个元素满足该断言则返回true，否则返回false
     */
    @Test
    public void anyMatch () {
        List<Integer> numbers = Arrays.asList(-1,2,3,4,5);
        boolean anyMatch = numbers.stream().anyMatch(x -> x > 0);
        System.out.println(anyMatch);
    }

    /**
     * noneMatch
     * 返回一个boolean
     * 接受一个 Predicate 函数，都不满足该断言则返回true，否则返回false
     */
    @Test
    public void noneMatch() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        boolean noneMatch = numbers.stream().noneMatch(x -> x < 0);
        System.out.println(noneMatch);
    }

    /**
     * findFirst
     * 返回流中第一个元素
     */
    @Test
    public void findFirst () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int first = numbers.stream().findFirst().get();
        System.out.println(first);
    }

    /**
     * findAny
     * 返回流中任意一个元素
     * 区分是串行流还是并行流
     */
    @Test
    public void findAny () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(numbers.stream().findAny().get());//这个地方如果是串行流的话，一直返回第一个
        System.out.println(numbers.parallelStream().findAny().get());//这个地方如果是并行流的话，会返回任意一个
    }

    /**
     * forEach
     * 用于循环迭代结果集合，与传统for循环的方法相同
     */
    @Test
    public void forEach() {
        List<Integer> numbers = Arrays.asList(11,2,3,4,5);
        numbers.stream().forEach(System.out::println);
    }

    /**
     * reduce
     * 规约，对map映射后的元素，进行迭代计算，比如求和等
     * map-reduce
     * filter-reduce
     * 都可以连用
     * reduce可以有2个参数，第1个参数是初始值，第二个参数有2个（中间值，当前值）
     */
    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
