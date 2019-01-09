package time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustTest {

    /**
     * 自定义TemporalAdjust
     * 找下一个工作日
     */
    @Test
    public void test1 () {

        LocalDateTime localDateTime = LocalDateTime.now();

        //自定义了TemporalAdjust时间调整器
        LocalDateTime nextWorkDateTime = localDateTime.with((x) -> {
            LocalDateTime localDate = (LocalDateTime) x;
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                return localDate.plusDays(3);
            } else if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                return localDate.plusDays(2);
            } else {
                return localDate.plusDays(1);
            }
        });//果然内部调用了this自己, 我说怎么没见传参数呢
        System.out.println(nextWorkDateTime.toLocalDate());
    }

    /**
     * TemporalAdjust常用方法
     * 下一个月的第几天，等等
     */
    @Test
    public void test2 () {
        LocalDateTime localDateTime = LocalDateTime.now();
        //获取下一个星期日
        LocalDateTime localDateTime1 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(localDateTime1);
    }
}
