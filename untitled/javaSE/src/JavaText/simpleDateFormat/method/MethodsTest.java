package JavaText.simpleDateFormat.method;

/**
 * @author ChenDan
 * @create 2021-04-21
 * @desc SimpleDateFormat extends DateFormat 格式化日期
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/** 简写
 * Letter	Date or Time Component	Presentation	Examples
 * G	Era designator	Text	AD
 * y	Year	Year	1996; 96
 * Y	Week year	Year	2009; 09
 * M	Month in year (context sensitive)	Month	July; Jul; 07
 * L	Month in year (standalone form)	Month	July; Jul; 07
 * w	Week in year	Number	27
 * W	Week in month	Number	2
 * D	Day in year	Number	189
 * d	Day in month	Number	10
 * F	Day of week in month	Number	2
 * E	Day name in week	Text	Tuesday; Tue
 * u	Day number of week (1 = Monday, ..., 7 = Sunday)	Number	1
 * a	Am/pm marker	Text	PM
 * H	Hour in day (0-23)	Number	0
 * k	Hour in day (1-24)	Number	24
 * K	Hour in am/pm (0-11)	Number	0
 * h	Hour in am/pm (1-12)	Number	12
 * m	Minute in hour	Number	30
 * s	Second in minute	Number	55
 * S	Millisecond	Number	978
 * z	Time zone	General time zone	Pacific Standard Time; PST; GMT-08:00
 * Z	Time zone	RFC 822 time zone	-0800
 * X	Time zone	ISO 8601 time zone	-08; -0800; -08:00
* */
public class MethodsTest {
    /**
     * public final String format(Date date) ： 根据SimpleDateFormat格式化Date
     * public void applyLocalizedPattern(String pattern) ： 应用pattern格式
     * public String toLocalizedPattern() : 获取本地化pattern  本地化是什么意思？？
     * public Object clone() : 复制SimpleDateFormat对象
     * public String toPattern() : 输出SimpleDateFormat的pattern格式
     * public Date get2DigitYearStart() : ???
     * */
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH时mm分ss");
        System.out.println(sdf.format(date));

        sdf.applyLocalizedPattern("aaaa-hh-mm-ss");
        System.out.println(sdf.format(date));
        System.out.println(sdf.toLocalizedPattern());

        SimpleDateFormat sdf1 = (SimpleDateFormat) sdf.clone();
        System.out.println("toPattern:         " + sdf1.toPattern());

        Date date1 = sdf.get2DigitYearStart();
        System.out.println(date1);

    }

}
