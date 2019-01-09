package time;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * 用户使用的本地日期
 */
public class LocalDataTimeTest {

    /**
     * LocalData - 获取实例
     */
    @Test
    public void test1 () {

        //获取实例1 - 当前日期
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        //获取实例2 - 指定年月日
        LocalDate localDate2 = LocalDate.of(2019, 1, 1);
        System.out.println(localDate2);

        //获取实例3 - 某一年的第几天
        LocalDate localDate3 = LocalDate.ofYearDay(2019, 51);
        System.out.println(localDate3);

        //获取实例4 - 格林尼治后的第几天
        LocalDate localDate4 = LocalDate.ofEpochDay(1);
        System.out.println(localDate4);

        //获取实例5 - 某个时区下的日期
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);//Asia/Shanghai
        LocalDate localDate5 = LocalDate.now(zoneId);
        System.out.println(localDate5);

        Clock clock = Clock.system(ZoneId.systemDefault());
        System.out.println(clock);
    }

    /**
     * LocalDate的操作
     * 日期的加减法
     */
    @Test
    public void test2 () {
        ////////////加法///////////////
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = localDate.plus(1, ChronoUnit.DAYS);//加一天
        System.out.println(localDate);
        localDate = localDate.plus(1, ChronoUnit.WEEKS);//加一个星期
        System.out.println(localDate);
        localDate = localDate.plus(1, ChronoUnit.MONTHS);//加一个月
        System.out.println(localDate);
        localDate = localDate.plus(1, ChronoUnit.YEARS);//加一年
        System.out.println(localDate);
        ////////////减法////////////////
        localDate = localDate.minus(1, ChronoUnit.YEARS);
        System.out.println(localDate);
    }

    /**
     * LocalDate的其他方法
     */
    @Test
    public void test3() {
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.now().plus(1, ChronoUnit.YEARS);
        System.out.println(localDate1.compareTo(localDate2));//两个日期之间的比较，小于后者返回-1， 等于返回0， 大于返回1
        int dayOfWeek = localDate1.get(ChronoField.DAY_OF_WEEK);//get某个语境的具体数字
        System.out.println(dayOfWeek);
        int dayOfMonth = localDate1.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        int dayOfYear = localDate1.get(ChronoField.DAY_OF_YEAR);
        System.out.println(dayOfYear);
        System.out.println(localDate1.isAfter(localDate2));//是否在一个日期后面
        System.out.println(localDate1.lengthOfYear());//这个年有多少天
        System.out.println(localDate1.lengthOfMonth());//这个月有多少天
        System.out.println(localDate1.withYear(2035));//将当前日期改变成某一个日期
    }

    /**
     * LocalTime
     */
    @Test
    public void test4 () {
        LocalTime localTime = LocalTime.now();//当前时间
        System.out.println(localTime);

        localTime = LocalTime.of(10, 10, 10);//of方法，手动指定
        System.out.println(localTime);

        localTime = LocalTime.ofSecondOfDay(1);//手动指定成当天的第几秒
        System.out.println(localTime);

    }

    /**
     * 加减法
     */
    @Test
    public void test5 () {
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plus(1, ChronoUnit.HOURS);
        System.out.println(localTime);
        localTime = localTime.plus(1, ChronoUnit.MINUTES);
        System.out.println(localTime);

        localTime = localTime.minus(1, ChronoUnit.HOURS);
        System.out.println(localTime);
    }

    /**
     * LocalTime的其他方法
     */
    @Test
    public void test6() {
        LocalTime localTime = LocalTime.now();
        System.out.println("时=" + localTime.getHour() + ", 分=" + localTime.getMinute() + ", 秒=" + localTime.getSecond());
        localTime = localTime.withHour(10);
        localTime = localTime.withMinute(10);
        localTime = localTime.withSecond(10);
        System.out.println("时=" + localTime.get(ChronoField.HOUR_OF_DAY) + ", 分=" + localTime.get(ChronoField.MINUTE_OF_HOUR) + ", 秒=" + localTime.get(ChronoField.SECOND_OF_MINUTE));
    }

    /**
     * LocalDataTime
     * toInstat 转换成Instant，为了获取毫秒数
     * ofInstant方法, 将Instant转换成LocalDateTime, 从毫秒-LocalDateTime
     * 都是借助了Instant
     */
    @Test
    public void test7 () {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        localDateTime = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println(localDateTime);
        localDateTime = localDateTime.withYear(2020);
        localDateTime = localDateTime.withMonth(1);
        localDateTime = localDateTime.withDayOfMonth(1);
        localDateTime = localDateTime.withHour(1);
        localDateTime = localDateTime.withMinute(1);
        localDateTime = localDateTime.withSecond(1);
        System.out.println(localDateTime);
        /**
         * 很奇怪，LocalDateTime有获取1970年到现在多少秒的方法，但是没有毫秒的方法，还要先转成Instant才有
         */
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());//localDateTime转换成毫秒
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime());
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));//localDateTime转换成秒
        long timestamp = System.currentTimeMillis();
        //将秒转换成LocalDateTime, 这时候是必须要用上时区的ZoneOffset
        LocalDateTime localDateTime1 = LocalDateTime.ofEpochSecond(timestamp / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime1);

        //将毫秒转换成LocalDateTime   通过Instant来获取
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault());
        System.out.println(localDateTime2);

    }

    /**
     * LocalDataTime其他用法
     */
    @Test
    public void test8() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour() + "-" + localDateTime.getMinute() + "-" + localDateTime.getSecond());
        System.out.println(localDateTime.getLong(ChronoField.DAY_OF_WEEK));//获取星期几
        System.out.println(localDateTime.getDayOfWeek().getValue());//获取星期几
        LocalDateTime localDateTime1 = localDateTime.plus(1, ChronoUnit.YEARS);
        System.out.println(localDateTime1);
    }

}
