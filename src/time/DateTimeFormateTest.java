package time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * 时间格式化
 */
public class DateTimeFormateTest {

    /**
     * DateTimeFormat的使用
     */
    @Test
    public void test1 () {

        //默认的创建方式
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        String format = df.format(LocalDateTime.now());
        System.out.println(format);

        //自定义时间格式
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = df1.format(localDateTime);//都有format方法
        System.out.println(strDate);

        strDate = localDateTime.format(df1);//都有format方法
        System.out.println(strDate);

        //将时间格式字符串转换回时间
        TemporalAccessor parse = df1.parse(strDate);
        System.out.println(parse);

        LocalDateTime localDateTime1 = LocalDateTime.parse(strDate, df1);//使用LocalDateTime的静态方法转回去
        System.out.println(localDateTime1);
    }
}
