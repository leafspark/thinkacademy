package com.luck.picture.lib.language;

import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Locale;

public class LocaleTransform {
    public static Locale getLanguage(int i) {
        switch (i) {
            case 1:
                return Locale.TRADITIONAL_CHINESE;
            case 2:
                return Locale.ENGLISH;
            case 3:
                return Locale.KOREA;
            case 4:
                return Locale.GERMANY;
            case 5:
                return Locale.FRANCE;
            case 6:
                return Locale.JAPAN;
            case 7:
                return new Locale("vi");
            case 8:
                return new Locale("es", "ES");
            case 9:
                return new Locale("pt", AssistPushConsts.MSG_VALUE_PAYLOAD);
            default:
                return Locale.CHINESE;
        }
    }
}
