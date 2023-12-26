package com.bonree.sdk.be;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public final class e implements f {
    private static HiLogLabel f = new HiLogLabel(0, 6849065, "BRSDK-HMAgent");
    private static HiLogLabel g = new HiLogLabel(0, 6849065, "ZJR-HM");
    private static Pattern h = Pattern.compile("%[sdbxofae]");

    public final int a() {
        return 0;
    }

    public final void a(int i) {
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = h.matcher(str);
        int i = 1;
        while (matcher.find()) {
            sb.insert(matcher.start() + i, "{public}");
            i += 8;
        }
        return sb.toString();
    }

    public final void a(String str, Object... objArr) {
        HiLog.debug(f, b(str), objArr);
    }

    public final void b(String str, Object... objArr) {
        HiLog.fatal(f, b(str), objArr);
    }

    public final void c(String str, Object... objArr) {
        HiLog.info(f, b(str), objArr);
    }

    public final void a(String str) {
        HiLog.info(g, str, new Object[0]);
    }

    public final void d(String str, Object... objArr) {
        HiLog.warn(f, b(str), objArr);
    }

    public final void e(String str, Object... objArr) {
        HiLog.error(f, b(str), objArr);
    }

    public final void a(String str, Throwable th) {
        HiLog.error(f, str, new Object[]{th});
    }
}
