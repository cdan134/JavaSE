package JavaText.simpleDateFormat.constructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ChenDan
 * @create 2021-04-21
 * @desc 格式化日期形式
 */
public class ConstructorsTest {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat();
        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyy年MM月dd日 HH时mm分ss", Locale.FRANCE);

        System.out.println(sdf1.format(date));
        System.out.println(sdf2.format(date));
        System.out.println(sdf3.format(date));
    }
}
