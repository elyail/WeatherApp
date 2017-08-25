package com.example.gabdullinae.wheatherapplication.utils;

import android.content.Context;
import android.text.format.DateUtils;

public class TimeUtils {
    public static String prettyTime(Context context, long unixTime) {
        return DateUtils.formatDateTime(context, unixTime * 1000, DateUtils.FORMAT_SHOW_TIME);
    }

    public static String prettyDate(Context context, long unixTime) {
        return DateUtils.formatDateTime(context, unixTime*1000, DateUtils.FORMAT_SHOW_WEEKDAY);
    }
}
