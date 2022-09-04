package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 操作map的基本思路：
 * 操作的是map的EntrySet()方法
 */
public class OPerMap {

    Map<Integer, Employee> map = new HashMap<>();

    {
        map.put(1, new Employee(11, "zhang", 30, 1));
        map.put(2, new Employee(2, "wang", 60, 2));
        map.put(3, new Employee(3, "li", 120, 2));
        map.put(4, new Employee(4, "zhao", 3, 3));
    }

    @Test
    public void forEach() {
        map.entrySet().stream().forEach(x -> System.out.println(x.getKey() + "--" + x.getValue()));
    }

    @Test
    public void filter () {
        map.entrySet().stream().filter(x -> x.getValue().getName().equals("li")).peek(System.out::println).findFirst().get();
    }

    @Test
    public void sorted () {
        //map.entrySet().stream().sorted((x, y) -> x.getValue().getId() - y.getValue().getId()).collect(Collectors.toList());
        System.out.println(map.entrySet().stream().sorted(Comparator.comparingInt(x -> x.getValue().getId())).collect(Collectors.toList()));
    }

    @Test
    public void listToMap () {
        List<Employee> list = Arrays.asList(new Employee(1,"zhang", 30, 1),
                new Employee(2,"wang", 60, 2),
                new Employee(3,"li", 120, 2),
                new Employee(4,"zhao", 3, 3));
        System.out.println(list.stream().collect(Collectors.toMap(x -> x.getName(), x -> x)));
    }
}
