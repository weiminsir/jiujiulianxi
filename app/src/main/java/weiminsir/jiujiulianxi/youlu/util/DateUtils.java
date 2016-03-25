package weiminsir.jiujiulianxi.youlu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Weimin on 2016/3/14.
 */
public class DateUtils {
    public static String parse(long date) {

        Calendar now = Calendar.getInstance();
        Calendar other = Calendar.getInstance();
        other.setTimeInMillis(date);
        if (now.get(Calendar.DAY_OF_YEAR) == other.get(Calendar.DAY_OF_YEAR)&&
                now.get(Calendar.YEAR)==other.get(Calendar.YEAR)) {

            return new SimpleDateFormat("HH:mm").format(other.getTime());
        }
        now.set(Calendar.DAY_OF_YEAR,-1);
        if (now.get(Calendar.DAY_OF_YEAR) == other.get(Calendar.DAY_OF_YEAR)&&
                now.get(Calendar.YEAR)==other.get(Calendar.YEAR)) {
            return "昨天";
        }
        int day = other.get(Calendar.DAY_OF_WEEK);
        String dayString = "";
        switch (day) {
            case Calendar.MONDAY:
                dayString = "星期一";
                break;
            case Calendar.TUESDAY:
                dayString = "星期二";
                break;
            case Calendar.WEDNESDAY:
                dayString = "星期三";
                break;
            case Calendar.THURSDAY:
                dayString = "星期四";
                break;
            case Calendar.FRIDAY:
                dayString = "星期五";
                break;
            case Calendar.SATURDAY:
                dayString = "星期六";
                break;
            case Calendar.SUNDAY:
                dayString = "星期日";
                break;
        }

        return dayString;
    }


}
