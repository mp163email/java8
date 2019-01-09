package time;

import org.junit.Test;

import java.time.*;

/**
 * 计算时间间隔
 */
public class DurationTest {

    /**
     * 计算Instant时间
     */
    @Test
    public void test1 () {
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        for (int i = 1; i < 1000 * 10000; i++) {

        }
        Instant instant2 = Instant.now();
        System.out.println(instant2);
        Duration between = Duration.between(instant1, instant2);
        System.out.println(between.toMillis());
    }

    /**
     * 计算localTime
     */
    @Test
    public void test2 () {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plusHours(1);
        Duration duration = Duration.between(localTime, localTime1);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toHours());
    }

    /**
     * 计算LocalDateTime
     */
    @Test
    public void test3 () {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        for (int i = 1; i < 1000 * 10000; i++) {

        }
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        Duration duration = Duration.between(localDateTime, localDateTime1);
        System.out.println(duration.toMillis());
    }



}
