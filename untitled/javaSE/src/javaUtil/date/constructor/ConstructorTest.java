package javaUtil.date.constructor;

import java.util.Date;

/**
 * @author ChenDan
 * @create 2021-04-21
 * @desc JDK 1.1 特定的瞬间，精确到毫秒，因为不易于国际化，现已经废弃
 *
 * public Date() : this(System.currentTimeMillis()); 当前时间
 * public Date(long date) : 1970/01/01/00:00:00 为0起点
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(0);

        System.out.println(date1);
        System.out.println(date2);
    }
}
