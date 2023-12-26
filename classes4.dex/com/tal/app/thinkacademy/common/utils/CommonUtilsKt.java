package com.tal.app.thinkacademy.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"MIN_CLICK_DELAY_TIME", "", "lastClickTime", "isFastClick", "", "startCallEmail", "", "email", "", "context", "Landroid/content/Context;", "startCallPhoneNumber", "phoneNum", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonUtils.kt */
public final class CommonUtilsKt {
    private static final long MIN_CLICK_DELAY_TIME = 500;
    private static long lastClickTime;

    public static final boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = lastClickTime;
        if (currentTimeMillis > j && currentTimeMillis - j < MIN_CLICK_DELAY_TIME) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static final void startCallPhoneNumber(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "phoneNum");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(Intrinsics.stringPlus("tel:", str)));
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[Catch:{ Exception -> 0x0070 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void startCallEmail(java.lang.String r6, android.content.Context r7) {
        /*
            java.lang.String r0 = "email"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "android.intent.action.SEND"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "mailto:"
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r6)     // Catch:{ Exception -> 0x0070 }
            android.net.MailTo r6 = android.net.MailTo.parse(r6)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "android.intent.extra.EMAIL"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0070 }
            r3 = 0
            java.lang.String r4 = ""
            if (r6 != 0) goto L_0x0027
        L_0x0025:
            r5 = r4
            goto L_0x002e
        L_0x0027:
            java.lang.String r5 = r6.getTo()     // Catch:{ Exception -> 0x0070 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0025
        L_0x002e:
            r2[r3] = r5     // Catch:{ Exception -> 0x0070 }
            r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "android.intent.extra.TEXT"
            if (r6 != 0) goto L_0x0039
        L_0x0037:
            r2 = r4
            goto L_0x0040
        L_0x0039:
            java.lang.String r2 = r6.getBody()     // Catch:{ Exception -> 0x0070 }
            if (r2 != 0) goto L_0x0040
            goto L_0x0037
        L_0x0040:
            r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "android.intent.extra.SUBJECT"
            if (r6 != 0) goto L_0x0049
        L_0x0047:
            r2 = r4
            goto L_0x0050
        L_0x0049:
            java.lang.String r2 = r6.getSubject()     // Catch:{ Exception -> 0x0070 }
            if (r2 != 0) goto L_0x0050
            goto L_0x0047
        L_0x0050:
            r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r1 = "android.intent.extra.CC"
            if (r6 != 0) goto L_0x0058
            goto L_0x0060
        L_0x0058:
            java.lang.String r6 = r6.getCc()     // Catch:{ Exception -> 0x0070 }
            if (r6 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r4 = r6
        L_0x0060:
            r0.putExtra(r1, r4)     // Catch:{ Exception -> 0x0070 }
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r6)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r6 = "message/rfc822"
            r0.setType(r6)     // Catch:{ Exception -> 0x0070 }
            r7.startActivity(r0)     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.utils.CommonUtilsKt.startCallEmail(java.lang.String, android.content.Context):void");
    }
}
