package com.codezjx.dribbbledroid.utils;

import java.util.Date;

/**
 * Created by codezjx on 2016/6/28.<br/>
 */
public class DateUtils {

    public static String formatDate(Date date) {
        return date == null ? "" :
                android.text.format.DateUtils.getRelativeTimeSpanString(
                        date.getTime(),
                        System.currentTimeMillis(),
                        android.text.format.DateUtils.MINUTE_IN_MILLIS)
                        .toString().toLowerCase();
    }
}
