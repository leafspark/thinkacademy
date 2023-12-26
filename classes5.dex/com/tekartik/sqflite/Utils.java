package com.tekartik.sqflite;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import com.tekartik.sqflite.dev.Debug;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static List<Object> cursorRowToList(Cursor cursor, int i) {
        String str;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object cursorValue = cursorValue(cursor, i2);
            if (Debug.EXTRA_LOGV) {
                String str2 = null;
                if (cursorValue != null) {
                    if (cursorValue.getClass().isArray()) {
                        str2 = "array(" + cursorValue.getClass().getComponentType().getName() + ")";
                    } else {
                        str2 = cursorValue.getClass().getName();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i2);
                sb.append(" ");
                sb.append(cursor.getType(i2));
                sb.append(": ");
                sb.append(cursorValue);
                if (str2 == null) {
                    str = "";
                } else {
                    str = " (" + str2 + ")";
                }
                sb.append(str);
                Log.d(Constant.TAG, sb.toString());
            }
            arrayList.add(cursorValue);
        }
        return arrayList;
    }

    public static Object cursorValue(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i);
    }

    static Locale localeForLanguateTag(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return localeForLanguageTag21(str);
        }
        return localeForLanguageTagPre21(str);
    }

    static Locale localeForLanguageTag21(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale localeForLanguageTagPre21(String str) {
        String str2;
        String str3;
        String[] split = str.split("-");
        String str4 = "";
        if (split.length > 0) {
            String str5 = split[0];
            if (split.length > 1) {
                str3 = split[1];
                if (split.length > 2) {
                    str4 = split[split.length - 1];
                }
                str2 = str4;
            } else {
                str2 = str4;
                str3 = str2;
            }
            str4 = str5;
        } else {
            str2 = str4;
            str3 = str2;
        }
        return new Locale(str4, str3, str2);
    }
}
