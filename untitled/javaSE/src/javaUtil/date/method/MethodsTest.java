package javaUtil.date.method;

import java.util.Date;

/**
 * @author ChenDan
 * @create 2021-04-21
 * @desc Date方法
 * public boolean after(Date when) date1 > date2
 * public boolean before(Date when) date1 < date2
 * public int compareTo(Date anotherDate) date1 < = < date2 [-1 0 1]
 * public boolean equals(Object obj) ==
 * public long getTime() 毫秒值
 * public String toString() "EEE MMM dd HH:mm:ss zzz yyyy";
 */
public class MethodsTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(0);
        while(true){

            System.out.println(date1);
            System.out.println(date2);

            System.out.println(date1.after(date2));
            System.out.println(date1.before(date2));
            System.out.println(date1.compareTo(date2));
            System.out.println(date1.equals(date2));
            System.out.println(date1.getTime());
            System.out.println(date1.toString());
        }

    }
}
