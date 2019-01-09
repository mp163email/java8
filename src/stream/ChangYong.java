package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 常用的一些方法
 * 模拟字典表操作
 */
public class ChangYong {



    List<Employee> list = Arrays.asList(new Employee(1,"zhang", 30, 1),
            new Employee(2,"wang", 60, 2),
            new Employee(3,"li", 120, 2),
            new Employee(4,"zhao", 3, 3));

    /**
     * 按条件找到一条
     * filter+findFirst+orElseThrow的组合使用
     */
    @Test
    public void test1 () {
        Optional<Employee> employeeOp = list.stream().filter(e -> {
            if (e.getName().equals("zhang") && e.getAge() == 30) {
                return true;
            }
            return false;
        }).findFirst();

        Employee employee = employeeOp.orElseThrow(IllegalArgumentException::new);
        System.out.println(employee);
    }

    /**
     * 找到id最大的那条记录
     * max,  Collectors.maxByd的使用
     */
    @Test
    public void test2 () {

        //最大的
        Optional<Employee> max = list.stream().max(Comparator.comparing(Employee::getId));
        System.out.println(max.get());
        //最小的
        Optional<Employee> min = list.stream().min(Comparator.comparing(Employee::getId));
        System.out.println(min.get());

        //最大的第二种方式
        Optional<Employee> max1 = list.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getId)));
        System.out.println(max1.get());

        //最小的第二种方式
        Optional<Employee> min1 = list.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getId)));
        System.out.println(min1.get());
    }

}
