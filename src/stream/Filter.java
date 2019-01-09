package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 中间的一些操作
 */
public class Filter {


    List<Employee> employeeList = Arrays.asList(new Employee("1", 1, 1),
            new Employee("2", 2, 2),
            new Employee("2", 2, 2),
            new Employee("3", 3, 3));

    @Test
    public void test1 () {
        employeeList.stream().filter((e) -> e.getAge() > 1).distinct().skip(1).limit(1).forEach(System.out::println);
    }

}
