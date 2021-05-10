package javaUtil.calendar.constructor;

import java.util.Calendar;

/**
 * @author ChenDan
 * @create 2021-05-07
 * @desc 特定瞬间，日期之间转换
 */
public class Constructors {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();  // 创建当前时间的日历对象
        System.out.println(calendar.getTime());
    }
}


