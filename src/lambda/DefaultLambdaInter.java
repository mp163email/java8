package lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda默认的4个核心接口
 * 指定参数：Comsumer<T>
 * 指定返回值：Supplier<R>
 * 指定参数和返回值：Function<T, R>
 * 指定参数，返回boolean值：Predicate<T>
 * Auth: miaopeng
 * Date: 2018-12-01 11:12:36
 */
public class DefaultLambdaInter {

    /**
     * 指定参数，没有返回值
     */
    @Test
    public void consumer () {
        returnStr("Hello Lambda", x -> System.out.println(x));
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Hello World");
    }

    public void returnStr (String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    /**
     * 指定返回值，没有参数
     */
    @Test
    public void supplier() {
        getIntList(10, () -> {
            Random random = new Random();
            return random.nextInt(100);
        }).forEach(System.out::println);
    }

    public List<Integer> getIntList (int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    /**
     * 指定参数，指定返回值
     */
    @Test
    public void function() {
        int strLen = staticsStrLen("I am Chinese peaple", (s) -> s.length());
        System.out.println(strLen);
    }

    public int staticsStrLen (String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    /**
     * 指定参数，返回值是boolean
     */
    @Test
    public void predicate() {
        staticsstrLen(Arrays.asList("china", "nb", "bang"), (s) -> s.length() > 4).forEach(System.out::println);
    }

    public List<String> staticsstrLen (List<String> strList, Predicate<String> predicate) {
        List<String> list = new ArrayList<>();
        for (String str : strList) {
            if (predicate.test(str)) {
                list.add(str);
            }
        }
        return list;
    }
}
