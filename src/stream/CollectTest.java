package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 很好很强大
 * 对结果的收集，什么结果都能收集
 */
public class CollectTest {

    List<Employee> list = Arrays.asList(new Employee("zhang", 30, 1),
            new Employee("zhang", 60, 2),
            new Employee("zhang", 120, 2),
            new Employee("li", 3, 3));

    @Test
    public void test1 () {

        //返回最大的年龄
        Optional<Integer> max = list.stream().map(Employee::getAge).max(Integer::compare);
        System.out.println(max.get());

        //收集所有员工的名字，返回到一个list中
        List<String> strList = list.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(strList);

        //收集所有员工的名字，返回到一个set中
        Set<String> set = list.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(set);

        //收集所有员工的名字，返回到一个linkedHashSet中
        LinkedHashSet<String> linkedHashSet = list.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedHashSet);

        //收集所有员工的名字，返回到一个linkedList中
        LinkedList<String> linkedList = list.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);

        //count的使用
        long count = list.stream().collect(Collectors.counting());
        System.out.println(count);

        //average的使用
        double average = list.stream().map(Employee::getSalary).collect(Collectors.averagingDouble((e) -> e));
        double average1 = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("average=" + average + ", average1=" + average1);

        //sum的使用
        double sum = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //minBy的使用
        Optional<Employee> opMin = list.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
        System.out.println(opMin.get());

        //maxBy的使用
        Optional<Employee> opMax = list.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
        System.out.println(opMax.get());

        //group的使用,  按照年龄分组
        Map<Integer, List<Employee>> maplist = list.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(maplist);


        System.out.println("=================");

        //group多级分组， 先按照名字分，再按照年龄自定义分组，是自定义分组
        Map<String, Map<String, List<Employee>>> mapmaplist = list.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(mapmaplist);

        //part 分片
        Map<Boolean, List<Employee>> map = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 40));
        System.out.println(map);

        //统计函数-这个挺好
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("average=" + statistics.getAverage() + ", sum=" + statistics.getSum() + ", max=" + statistics.getMax() + ", count=" + statistics.getCount());

        //join字符串连接
        String str = list.stream().map(Employee::getName).collect(Collectors.joining(",", "===", "==="));
        System.out.println(str);
    }

}
