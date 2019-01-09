package stream;

import lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map-相关测试
 *
 */
public class MapTest {

    List<Employee> employeeList = Arrays.asList(new Employee("zhang", 1, 1),
            new Employee("wang", 2, 2),
            new Employee("li", 3, 3));

    @Test
    public void test1 () {


        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            Employee next =  iterator.next();
        }

//        employeeList.stream().map(Employee::getName).forEach(System.out::println);
        Stream<Stream<Character>> characterStream = employeeList.stream().map(Employee::getName).map(this::secondMap);
        characterStream.forEach((stream) ->
            stream.forEach(System.out::println)
        );

        employeeList.stream().map(Employee::getName).flatMap(this::secondMap).forEach(System.out::println);
    }

    public Stream<Character> secondMap (String name) {
        List<Character> list = new ArrayList<>();
        for (Character character : name.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * flatmap扁平化多个流，合成一个
     */
    @Test
    public void test2 () {
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        String collect = playersInWorldCup2016.stream().flatMap(list -> list.stream()).collect(Collectors.joining("-"));
        System.out.println(collect);
    }
}
