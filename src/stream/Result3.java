package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * stream API 使用注意事项
 * 1.stream 不修改数据源
 * Stream流不是一种数据结构，不保存数据，它只是在原数据集上定义了一组操作，所以不会修改原数据。
 * 2.Stream对象只能使用一次，Stream不保存数据，故每个Stream流只能使用一次
 * 3.Stream的操作是惰性的，流只有在终止操作（Terminal operation）的时候才会进行计算
 */

/**
 * Collectors工厂类API
 * Stream API具有中间操作和结束操作
 * 中间操作有：peek、flatMap、limit、sort、distinct、map、filter
 * 结束操作有：noneMatch、allMatch、collect、findAny、findFirst、
 * anyMatch、toArray、reduce、min、max、forEach、count等。
 *
 *  * map(映射），对单个元素进行计算或者筛选，然后映射成一组新的元素
 *  * reduce(规约),对map映射以后的元素，进行迭代计算，比如求和等
 */
public class Result3 {

    /**
     * toList
     * 返回一个集合
     */
    @Test
    public void toList () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> collects = numbers.stream().collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * toSet
     * 返回一个set
     */
    @Test
    public void toSet () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Set<Integer> collects = numbers.stream().collect(Collectors.toSet());
        System.out.println(collects);
    }

    /**
     * toMap
     * 返回一个map
     */
    @Test
    public void toMap () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Map<Integer, Integer> collects = numbers.stream().collect(Collectors.toMap(x -> x * 100, y -> y));
        collects.put(1000, 1000);//返回的map是可以再继续操作的
        System.out.println(collects);
    }

    /**
     * averagingInt
     * 返回一个数值-平均数
     * double类型的
     */
    @Test
    public void averagingInt() {
        List<Integer> numbers = Arrays.asList(1,2,3);
        double aver = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println(aver);
    }

    /**
     * counting
     * 返回一个数值-元素个数
     * long类型的
     */
    @Test
    public void counting() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        long count = numbers.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    /**
     * summingInt
     * 返回一个数值-元素的和
     * int类型的
     */
    @Test
    public void summingInt() {
        List<Integer> numbers = Arrays.asList(1,2,3);
        int sum = numbers.stream().collect(Collectors.summingInt(x -> x));
        System.out.println(sum);
    }

    /**
     * partitioningBy
     * 返回2个集合，key为boolean
     * 满足条件(true)的一个，不满足条件(false)的一个
     * 将一组数据分为两组，key 为 ture 和 false 的两组数据（仅能分为两组）
     */
    @Test
    public void partitioningBy() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Map<Boolean, List<Integer>> numberList = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(numberList);
    }

    /**
     * groupingBy
     * 返回多个集合，key为泛型
     * 按照某个特定项分组（有参数，有返回值）
     * 分组成多个组，key是泛型（可以是任意类型）
     * 这里按年龄分组, 还可以对分组后的数据，再次进行操作-挺牛逼的
     */
    @Test
    public void groupingBy() {
        List<Employee> list = Arrays.asList(
                new Employee(1,"zhang", 4, 98),
                new Employee(2,"wang", 5, 100),
                new Employee(3,"li", 5, 95),
                new Employee(4,"zhao", 6, 99));

        //按年龄分组
        Map<Integer, List<Employee>> mapList = list.stream().collect(Collectors.groupingBy(x -> x.getAge()));
        System.out.println(mapList);

        //按年龄分组后，再对分组后的集合求平均值
        Map<Integer, Double> groupAver = list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.averagingDouble(x -> x.getSalary())));
        System.out.println(groupAver);
    }

    /**
     * joining
     * 返回一个字符串
     * 拼接后的字符串
     */
    @Test
    public void joining() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<String> strings = numbers.stream().map(x -> x + "").collect(Collectors.toList());
        String str = strings.stream().collect(Collectors.joining());
        System.out.println(str);
        str = strings.stream().collect(Collectors.joining("-"));
        System.out.println(str);
        str = strings.stream().collect(Collectors.joining("-", "[", "]"));
        System.out.println(str);
    }

}
