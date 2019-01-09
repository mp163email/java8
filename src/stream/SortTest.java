package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * sort-相关测试
 * sorted
 */
public class SortTest {

    List<Employee> list = Arrays.asList(new Employee("zhang", 1, 1),
            new Employee("zhang", 2, 2),
            new Employee("li", 3, 3));

    @Test
    public void test1 () {
        Stream.of("aaa", "ddd", "bbb").sorted().forEach(System.out::println);
    }

    @Test
    public void test2() {
        list.stream().sorted((e1, e2) -> {
            if (e1.getName().equals(e2.getName())) {
                return -Integer.compare(e1.getAge(), e2.getAge());
            } else {
                return e1.getName().compareTo(e2.getName());
            }
        }).forEach(System.out::println);
    }
}
