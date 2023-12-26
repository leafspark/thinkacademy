package com.yanzhenjie.andserver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDateFormat {
    private static final SimpleDateFormat FORMAT;
    private static final SimpleDateFormat[] FORMATS_TEMPLATE = {new SimpleDateFormat(RFC1123_DATE, Locale.US), new SimpleDateFormat("EEEEEE, dd-MMM-yy HH:mm:ss zzz", Locale.US), new SimpleDateFormat("EEE MMMM d HH:mm:ss yyyy", Locale.US)};
    private static final TimeZone GMT_ZONE;
    private static final String RFC1123_DATE = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        GMT_ZONE = timeZone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC1123_DATE, Locale.US);
        FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public static String getCurrentDate() {
        String format;
        SimpleDateFormat simpleDateFormat = FORMAT;
        synchronized (simpleDateFormat) {
            format = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        }
        return format;
    }

    public static String formatDate(long j) {
        String format;
        synchronized (HttpDateFormat.class) {
            format = FORMAT.format(new Date(j));
        }
        return format;
    }

    public static long parseDate(String str) {
        Date date = null;
        for (SimpleDateFormat parse : FORMATS_TEMPLATE) {
            try {
                date = parse.parse(str);
            } catch (ParseException unused) {
            }
        }
        if (date == null) {
            return -1;
        }
        return date.getTime();
    }
}
