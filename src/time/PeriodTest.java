package time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算两个日期间隔
 */
public class PeriodTest {

    /**
     * 根据两个毫秒数，获取间隔的天数
     */
    @Test
    public void test1 () {
        LocalDate localDate = LocalDate.of(2018, 12, 6);
        LocalDate localDate1 = LocalDate.ofEpochDay(Instant.now().toEpochMilli() / (1000 * 60 * 60 * 24));
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
    }

    /**
     * 计算相隔天数的两种方式
     * 1.toEpochDay()
     * 2.until方法
     */
    @Test
    public void test2 () {
        LocalDate localDate1 = LocalDate.of(2017, 12, 31);
        LocalDate localDate2 = LocalDate.of(2019, 1, 1);
        long interval = localDate1.toEpochDay() - localDate2.toEpochDay();
        System.out.println(Math.abs(interval));//相差天数
        long until = localDate1.until(localDate2, ChronoUnit.DAYS);//until方法很好用，哈哈，很好用，很有意思
        System.out.println(until);
    }

    @Test
    public void test3 () {
        LocalDate localDate1 = LocalDate.of(2018, 12, 31);
        LocalDate localDate2 = LocalDate.of(2019, 1, 1);
        long until = localDate1.until(localDate2, ChronoUnit.MONTHS);
        System.out.println(until);
    }

}
