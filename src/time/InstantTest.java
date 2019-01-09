package time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {

    @Test
    public void test1 () {
        Instant instant = Instant.now();
        System.out.println(instant);//好奇怪，输出一下instant，下面获取毫秒数的时候竟然会不同
        System.out.println(instant.toEpochMilli() + "," + System.currentTimeMillis());//获取毫秒数
        if (instant.toEpochMilli() == System.currentTimeMillis()) {
            System.out.println("相同");
        } else {
            System.out.println("不同");
        }

        //由Instant创建带偏移量的OffsetDateTime
        Instant instant1 = Instant.now();
        System.out.println(instant1.toEpochMilli() + "--" + System.currentTimeMillis());
        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));//带偏移量的时间戳
        System.out.println(offsetDateTime);

        Instant instant2 = Instant.ofEpochMilli(1);//格林尼治时间加1毫秒
        System.out.println(instant2);

    }

}
