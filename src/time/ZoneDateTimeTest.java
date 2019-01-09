package time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeTest {

    /**
     * 获取所有时区
     */
    @Test
    public void test1 () {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);//获取所有时区
    }

    /**
     * 构建带时区的LocalDateTime
     */
    @Test
    public void test2 () {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Yekaterinburg"));
        System.out.println(localDateTime);
    }

    /**
     * 利用LocalDateTime构建ZoneDateTime
     */
    @Test
    public void test3 () {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }
}
