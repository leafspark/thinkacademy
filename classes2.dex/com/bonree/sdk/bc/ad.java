package com.bonree.sdk.bc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class ad {
    private static NumberFormat a;
    private static NumberFormat b;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        a = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        b = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(4);
        b.setGroupingUsed(false);
    }

    private ad() {
    }

    public static String a(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        StringBuffer stringBuffer = new StringBuffer();
        gregorianCalendar.setTime(date);
        stringBuffer.append(b.format((long) gregorianCalendar.get(1)));
        stringBuffer.append(a.format((long) (gregorianCalendar.get(2) + 1)));
        stringBuffer.append(a.format((long) gregorianCalendar.get(5)));
        stringBuffer.append(a.format((long) gregorianCalendar.get(11)));
        stringBuffer.append(a.format((long) gregorianCalendar.get(12)));
        stringBuffer.append(a.format((long) gregorianCalendar.get(13)));
        return stringBuffer.toString();
    }

    public static Date a(String str) throws dc {
        if (str.length() == 14) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.clear();
            try {
                gregorianCalendar.set(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(4, 6)) - 1, Integer.parseInt(str.substring(6, 8)), Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(10, 12)), Integer.parseInt(str.substring(12, 14)));
                return gregorianCalendar.getTime();
            } catch (NumberFormatException unused) {
                throw new dc("Invalid time encoding: " + str);
            }
        } else {
            throw new dc("Invalid time encoding: " + str);
        }
    }
}
