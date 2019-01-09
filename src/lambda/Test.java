package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambda表达式意义-不用写实现类， 不用写匿名内部类（面向函数式接口的），直接用实现代码替代实现方法
 * 方法引用的意义：不用写实现类， 不用写匿名内部类（面向函数式接口的），直接用一个方法替代实现方法
 * 以上都是面向函数式接口的，对其提供便利（语法糖）， 其目的都是不再写实现类，或匿名类。用代码或某个方法来替代
 * 默认函数式接口意义-不用自己再定义接口
 * Auth: miaopeng
 * Date: 2018-11-29 17:45:00
 */
public class Test {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("1", 1, 1),
                new Employee("2", 2, 2),
                new Employee("3", 3, 3));

        Function<Employee, String> function = Employee::getName;
        Function<Employee, String> function1 = (e) -> e.getName();
        System.out.println(function.apply(employeeList.get(1)));

        System.out.println("==================");


        List<Employee> employeeListnew = new ArrayList<>();
        Predicate<Employee> predicate = (x) -> x.getAge() > 1;//这里的接口，是显示的。看来接口是得显示的定义，不然不知道是哪个接口
        Predicate<Employee> predicate1 = Test::methodRefreence;//方法引用
        for (Employee e : employeeList) {
            if (predicate.test(e)) {
                employeeListnew.add(e);
            }
        }
        System.out.println(employeeListnew);

        System.out.println("=========================");

        employeeFileter(new EmployeeFilterAge(), employeeList).forEach(System.out::println);

        System.out.println("==========================");
        employeeFileter((o) -> o.getAge() > 0, employeeList).forEach(System.out::println);
        System.out.println("==========================");

        employeeList.stream().filter((e) -> e.getAge() > 2).forEach(System.out::print);
        employeeList.stream().map(ep -> ep.getName()).forEach(System.out::print);

    }

    //我的接口名-EmployeeFilter, 对方的接口名：MyPredicate
    //我的实现类名-EmployeeFilterAge, 对方的实现类名：FilterEmployeeByAge（动词在前，介词相连）

    //我的方法名：employeeFileter, 对方的方法名：filterEmployee（动词在前）
    //我的方法变量名： filt（丑）, listnew（低级）  对方的方法变量名：mp(缩写), emps（缩写）

    //泛型：是为了不把类定死，然后传什么类就能访问这个类的方法。 如果把类定死，就仅限于掉这个定死的类的方法。这就是泛型。

    /**
     * 1.泛型更活泛，传什么类，就能使用这个类的东西， 定死就真定死了
     * 2.变量定义可以用缩写
     * 3.类和方法的定义，动词在前，介词相连
     */

    //方法命名filterEmployee(一个总称)?  变量命名?  接口命名--MyPredicate? 接口内方法命名-test  实现类命名-FilterEmployeeByAge(动词在前，通过介词链接)
    public static List<Employee> employeeFileter (EmployeeFilter<Employee> filt, List<Employee> list) {
        List<Employee> listnew = new ArrayList<>();//对方是emps
        for (Employee employee : list) {
            if (filt.filter(employee)) {
                listnew.add(employee);
            }
        }
        return listnew;
    }

    public static boolean methodRefreence (Employee e) {
        if (e.getAge() > 1) {
            return true;
        }
        return false;
    }
}
