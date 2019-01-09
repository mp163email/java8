package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * OptionalTest
 */
public class OptionTest {

    /**
     * 构造一个Optional
     */
    @Test
    public void test1 () {
        Optional<Employee> optional1 = Optional.of(new Employee());
        Optional<Employee> optional2 = Optional.of(null);//报错
    }

    /**
     * 返回一个空的empty
     */
    @Test
    public void test2 () {
        Optional<Employee> optional1 = Optional.empty();
        Optional<Employee> optional2 = Optional.ofNullable(null);
    }

    /**
     * 如果是空则new一个对象放上
     * optional.orElse orElseGet orElseThrow
     */
    @Test
    public void test3 () {
        Optional<Employee> optional = Optional.ofNullable(null);
        Employee employee = optional.orElse(new Employee());//手动new的方式
        System.out.println(employee.getAge());

        Optional<Employee> optional2 = Optional.ofNullable(null);
        Employee employee1 = optional2.orElseGet(Employee::new);//函数式接口的方式
        System.out.println(employee1.getAge());

        Optional<Employee> optional3 = Optional.ofNullable(null);
        Employee aThrow = optional3.orElseThrow(IllegalArgumentException::new);//如果是空就抛出异常, 这个挺实用
        System.out.println(aThrow.getAge());
    }

    /**
     * 非空判断， 如果不为空做什么
     */
    @Test
    public void test4 () {
        Optional<Employee> optional3 = Optional.ofNullable(null);
        if (optional3.isPresent()) {
            System.out.println("非空");
        } else {
            System.out.println("空");
        }

        //使用函数式接口来指定如果不为空则做什么
        Optional<Employee> optional = Optional.ofNullable(new Employee());
        optional.ifPresent(e -> System.out.println(e));//如果不为空做什么
    }

    /**
     * optional的map和filter的使用
     */
    @Test
    public void test5 () {
        Employee employee = new Employee();
        employee.setAge(10);
        Optional<Employee> optional = Optional.ofNullable(employee);
        Optional<Employee> optional1 = optional.filter(e -> e.getAge() > 1);
        System.out.println(optional1.get());

        Optional<Integer> integer = optional.map(Employee::getAge);
        System.out.println(integer.get());
    }

}
