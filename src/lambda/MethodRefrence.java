package lambda;

import org.junit.Test;

import java.util.function.*;

/**
 * 方法引用-参数列表跟参数也全部省掉，自动匹配
 * 18-12-01
 *
 * 方法引用
 *      对象::实例方法
 *      类  ::静态方法
 *      类  ::实例方法 (第一个参数是方法的调用者，第二个参数是方法的参数时，才能用这种方式)  或者其中某一个即是传过来的参数，而且又调用了他的方法
 *
 *
 * 构造方法的引用
 * 类::new
 *
 * 初始化数组的引用
 * 类[]::new
 */
public class MethodRefrence {

    /**
     * 对象::实例方法
     */
    @Test
    public void test1 () {
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("Hello");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Method Refrence");

        Employee employee = new Employee();
        employee.setAge(1);
        employee.setName("1");
        employee.setSalary(1);

        Consumer<Employee> consumer = (e) -> e.getAge();
        Consumer<Employee> consumer3 = Employee::getAge;//既是参数，又是调用者



    }

    /**
     * 类::静态方法
     */
    @Test
    public void test2() {
        BiFunction<Integer, Integer, Integer> biFunction1 = (x, y) -> Integer.compare(x, y);
        System.out.println(biFunction1.apply(1, 10));

        BiFunction<Integer, Integer, Integer> biFunction2 = Integer::compare;
        System.out.println(biFunction2.apply(3, 1));
    }

    /**
     * 类::实例方法
     */
    @Test
    public void test3() {
        BiPredicate<String, String> biPredicate1 = (x, y) -> x.equals(y);
        System.out.println(biPredicate1.test("a", "a"));

        BiPredicate<String, String> biPredicate2 = String::equals;
        System.out.println(biPredicate2.test("a", "b"));
    }

    /**
     * 类::new
     */
    @Test
    public void test4() {
        Supplier<Employee> supplier1 = () -> new Employee();
        Supplier<Employee> supplier2 = Employee::new;

        Function<Integer, Employee> function1 = (x) -> new Employee(x);
        Function<Integer, Employee> function2 = Employee::new;
        function2.apply(1);
    }

    /**
     * 数组[]::new
     */
    @Test
    public void test5() {
        Function<Integer, String[]> function1 = (x) -> new String[x];
        Function<Integer, String[]> function2 = String[]::new;
    }

    @Test
    public void test6() {
        Consumer<String> consumer = this::say;
        consumer.accept("Hello Jdk8");
    }

    public void say (String str) {
        System.out.println(str);
    }
}
