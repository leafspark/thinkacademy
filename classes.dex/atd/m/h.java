package atd.m;

import android.content.Context;
import android.os.Build;
import atd.i.b;
import atd.i.c;
import atd.s0.a;
import java.lang.reflect.Field;
import java.util.Locale;

public final class h implements b {
    static {
        a.a(-71960840956480L);
    }

    /* renamed from: b */
    public String a(Context context) throws c {
        Field[] fields = Build.VERSION_CODES.class.getFields();
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field field = fields[i];
            try {
                int i2 = field.getInt((Object) null);
                if (i2 == Build.VERSION.SDK_INT) {
                    return String.format(Locale.US, a.a(-71604358670912L), new Object[]{field.getName(), Build.VERSION.RELEASE, Integer.valueOf(i2)});
                }
                i++;
            } catch (IllegalAccessException unused) {
            }
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    public String a() {
        return a.a(-71557114030656L);
    }
}
