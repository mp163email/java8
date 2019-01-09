package stream;

import lambda.Employee;
import org.junit.Test;

import java.nio.file.OpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用于流的终止
 * allmatch  anyMatch, noneMatch
 * findFirst
 */
public class ZhongZhiTest {

    List<Employee> list = Arrays.asList(new Employee("zhang", 2, 1),
            new Employee("zhang", 2, 2),
            new Employee("li", 2, 3));

    @Test
    public void test1 () {
        boolean result = list.stream().allMatch(e -> e.getAge() == 1);//年龄都等于1
        System.out.println(result);
        result = list.stream().anyMatch(e -> e.getAge() == 1);//有一个年龄等于1
        System.out.println(result);
        result = list.stream().noneMatch(e -> e.getAge() == 1);//都不等于1
        System.out.println(result);
    }
    //(e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())

    @Test
    public void test2 () {
        Optional<Employee> op = list.stream().filter(e -> e.getAge() == 2).findFirst();
//        System.out.println(op.get());

        Optional<Employee> op2 = list.stream().filter(e -> e.getAge() == 2).findAny();//在串行的时候，其实还是返回的第一个
        System.out.println(op2.get());
    }

    @Test
    public void test3 () {

        List<Employee> employees = list.stream().filter(e -> e.getName().equals("zhang")).collect(Collectors.toList());
        System.out.println(employees);

        long count = list.stream().filter((e) -> e.getName().equals("zhang")).count();
        System.out.println(count);

        count = list.stream().filter((e) -> e.getName().equals("zhang")).collect(Collectors.counting());
        System.out.println(count);

        Optional<Employee> op = list.stream().max((e1, e2) -> {
            return -e1.getName().compareTo(e2.getName());
        });
        System.out.println(op.get());

        op = list.stream().min((e1, e2) -> {
            return -e1.getName().compareTo(e2.getName());
        });
        System.out.println(op.get());
    }

}
