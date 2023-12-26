package com.yanzhenjie.andserver.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class AcceptLanguage {
    private final Locale locale;
    private final double quality;

    protected AcceptLanguage(Locale locale2, double d) {
        this.locale = locale2;
        this.quality = d;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public double getQuality() {
        return this.quality;
    }

    public static List<AcceptLanguage> parse(String str) {
        if (StringUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        String[] split = str.split(",");
        if (ObjectUtils.isEmpty((Object[]) split)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String split2 : split) {
            String[] split3 = split2.split(";");
            if (split3.length == 2 && split3[1].length() > 2 && split3[1].charAt(0) == 'q' && split3[1].charAt(1) == '=') {
                try {
                    arrayList.add(new AcceptLanguage(new Locale(split3[1]), Double.parseDouble(split3[1].substring(2))));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
