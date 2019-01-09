package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream API 使用注意事项
 * 1.stream 不修改数据源
 *      Stream流不是一种数据结构，不保存数据，它只是在原数据集上定义了一组操作，所以不会修改原数据。
 * 2.Stream对象只能使用一次，Stream不保存数据，故每个Stream流只能使用一次
 * 3.Stream的操作是惰性的，流只有在终止操作（Terminal operation）的时候才会进行计算
 */


/**
 * 中间操作API
 * Stream API具有中间操作和结束操作
 * 中间操作有：peek、flatMap、limit、sort、distinct、map、filter
 * 结束操作有：noneMatch、allMatch、collect、findAny、findFirst、
 * anyMatch、toArray、reduce、min、max、forEach、collect、count等。
 *
 * map(映射），对单个元素进行计算或者筛选，然后映射成一组新的元素
 * reduce(规约),对map映射以后的元素，进行迭代计算，比如求和等
 */
public class Result1 {

    /**
     * map
     * 遍历每一个元素作为参数, 且返回一个值
     * 对集合列表执行操作,接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * collect:收集，汇合，汇集，集合
     * 中间操作：给每个数3次方， 汇集成新的集合
     * map接收的是function类型的函数（有参数，有返回值-返回值不是boolean）
     */
    @Test
    public void map () {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> collects = numbers.stream().map(x -> (int)Math.pow(x, 3)).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * flatMap
     * 遍历每一个集合元素，, 且返回一个流
     * 接受一个函数作为参数，将流中的每个值都换成另一个流，然后所有流连接成一个流。
     * 把大list里种每个小list的值，汇集成一个list
     * flat:平行的
     */
    @Test
    public void flatMap() {
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(11,12,13);
        List<Integer> numbers3 = Arrays.asList(21,22,23);
        List<List<Integer> > numbers = Arrays.asList(numbers1, numbers2, numbers3);
        List<Integer> collects = numbers.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * filter
     * Filter是我们最常用的操作了，可以用来过滤流中的某些元素。
     * 找到所有的偶数
     * filter接收的是Predicate(断言)类型的函数， 有参数，返回值为boolean的
     */
    @Test
    public void filter() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> collects = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * sorted
     * 用于对stream进行排序
     * sorted()：自然排序-升序，流中元素需实现Comparable接口
     * sorted(Comparator com)：定制排序，自定义Comparator排序器
     */
    @Test
    public void sorted() {
        List<Integer> numbers = Arrays.asList(11,2,3,4,5,6);
        List<Integer> collects = numbers.stream().sorted().collect(Collectors.toList());//默认升序
        System.out.println(collects);
        List<Integer> collects2 = numbers.stream().sorted((x, y) -> y - x).collect(Collectors.toList());//自定义Comparable,降序
        System.out.println(collects2);
    }

    /**
     * distinct
     * 通过流中元素的 hashCode() 和 equals() 去除重复元素
     */
    @Test
    public void distinct() {
        List<Integer> numbers = Arrays.asList(1,1,3,4,5,1);
        List<Integer> collects = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * peek
     * 得到流中的每一个元素，peek接收Consumer类型的函数，没有返回值，一般用于打印（瞥一眼值是啥，验证结果）
     */
    @Test
    public void peek() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,7);
        List<Integer> collects = numbers.stream().filter(x -> x % 2 == 0).peek(System.out::println).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * limit
     * 获取指定个数的元素
     */
    @Test
    public void limit() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,7);
        List<Integer> collects = numbers.stream().limit(3).collect(Collectors.toList());
        System.out.println(collects);
    }

    /**
     * skip
     * 跳过几个元素
     * 常联合limit实现分页
     */
    @Test
    public void skip() {
        int pageSize = 2;
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,7);
        for (int i = 0; i < 3; i++) {
            System.out.println("=========第" + (i + 1) + "页=======");
            numbers.stream().skip(i * pageSize).limit(pageSize).peek(x -> System.out.println(x)).collect(Collectors.toList());
        }
    }

}
