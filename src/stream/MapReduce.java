package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapReduce {

    List<Employee> list1 = Arrays.asList(new Employee("zhang", 2, 1),
            new Employee("zhang", 2, 2),
            new Employee("li", 2, 3));

    @Test
    public void test1 () {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //求和方式一：
        int aa = list.stream().collect(Collectors.summingInt(x -> x));
        System.out.println(aa);

        //求和方式二：
        int bb = list.stream().reduce(0, (x, y) -> x + y);//规约，统计性的操作
        System.out.println(bb);

        //求employee的工资总和   map-reduce
        Optional<Double> cc = list1.stream().map(Employee::getSalary).reduce(Double::sum);//没有指定初始值，有空的情况
        System.out.println(cc.get());

    }

}
