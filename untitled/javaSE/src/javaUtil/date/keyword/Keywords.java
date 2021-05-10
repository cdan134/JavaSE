package javaUtil.date.keyword;

import java.util.Calendar;

/**
 * @author ChenDan
 * @create 2021-05-07
 * @desc 关键字
 *
 */
public class Keywords {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();  // 创建当前时间的日历对象
        System.out.println(calendar.getTime());

        calendarInfo(calendar);

    }
    /**
     * YEAR,MONTH,DATE,HOUR/HOUR_OF_DAY,MINUTE,SECOND 年月日，时分秒
     * AM_PM 上下午
     * DAY_OF_YEAR/MONTH/WEEK 这年/月/周第几天
     */
    public static void calendarInfo(Calendar calendar) {
        System.out.println(calendar.get(Calendar.YEAR));  // 年
        System.out.println(calendar.get(Calendar.AM_PM));  // 上午/下午 0/1
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));  // 这个月的第几天？
    }
}
