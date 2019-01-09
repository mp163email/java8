package stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 并行-fork-join
 */
public class ForkJoinTest {

    @Test
    public void test1 () {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoin(0, 100000000L);
        long sum = pool.invoke(forkJoinTask);
        System.out.println(sum);
    }

    @Test
    public void test2 () {
        Instant start = Instant.now();//新时间API  InstantTest
        OptionalLong reduce = LongStream.rangeClosed(0, 100000000L).parallel().reduce(Long::sum);
        System.out.println(reduce.getAsLong());
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());//新时间API Duration
    }

}
