package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 相关联系
 */
public class API {

    /**
     * 求以下数组中平方的和
     */
    @Test
    public void test1 () {

        int[] ints = {1, 2, 3, 4, 5};
        OptionalInt result = Arrays.stream(ints).map(x -> x * x).reduce(Integer::sum);
        System.out.println(result.getAsInt());

        OptionalInt count = Arrays.stream((ints)).map(x -> 1).reduce(Integer::sum);
        System.out.println(count.getAsInt());

        int result1 =  Arrays.stream((ints)).reduce(0, (x, y) -> x + 1);
        System.out.println(result1);
    }
}
