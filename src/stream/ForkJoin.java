package stream;

import java.util.concurrent.RecursiveTask;

/**
 * Fork-join实例
 */
public class ForkJoin extends RecursiveTask<Long> {

    private long start;

    private long end;

    private final long interval = 10000000L;

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        System.out.println("00000000000start=" + start + ",   end=" + end);
        long length = end - start;
        if (length <= interval) {
            System.out.println("11111111111111start=" + start + ",   end=" + end);
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            System.out.println("22222222222222start=" + start + ",   end=" + end);
            long middle = (start + end) / 2;
            ForkJoin left = new ForkJoin(start, middle);
            left.fork();

            ForkJoin right = new ForkJoin(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
