package cyou;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteFutureMain {
    public static void main(String[] args) throws Exception {
        //基本使用一
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {

                    }
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {

                    }
                    System.out.println("inner--" + Thread.currentThread().getName());
                    return "aaa";
                }
        );
        completableFuture.thenAcceptAsync((x) -> System.out.println("execute finish~~" + x));
        System.out.println("main finish");
        TimeUnit.SECONDS.sleep(5);

        //基本使用二-处理异常的
        CompletableFuture cf = new CompletableFuture();
        cf.completeExceptionally(new RuntimeException("发生异常le~~"));
        cf.exceptionally(throwable -> {System.out.println(throwable); return null;});
    }
}
