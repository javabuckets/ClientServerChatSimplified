package com.thom.cc.utility;

import java.util.Calendar;

public class DateUtil {
    public static String getDate() {
        String currDate = Calendar.DAY_OF_MONTH + "-" + Calendar.MONTH + "-" + Calendar.YEAR;
        return currDate;
    }

    public static String getTime() {
        String currTime = Calendar.HOUR_OF_DAY + ":" + Calendar.MINUTE + ":" + Calendar.SECOND + ":" + Calendar.MILLISECOND;
        return currTime;
    }
}