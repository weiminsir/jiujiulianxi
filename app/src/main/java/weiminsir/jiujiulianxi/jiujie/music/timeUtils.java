package weiminsir.jiujiulianxi.jiujie.music;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Weimin on 2016/3/10.
 */
public class timeUtils {

    private  static  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.CHINA);

    private static Date date = new Date();

    public static String formatTime(long mills) {
        date.setTime(mills);
       return simpleDateFormat.format(date);

    }


}
