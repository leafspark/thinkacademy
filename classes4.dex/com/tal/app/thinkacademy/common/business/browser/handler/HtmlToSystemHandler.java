package com.tal.app.thinkacademy.common.business.browser.handler;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/handler/HtmlToSystemHandler;", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "()V", "onUrlLoading", "", "url", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HtmlToSystemHandler.kt */
public final class HtmlToSystemHandler extends WebViewLifeHandler {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[Catch:{ Exception -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onUrlLoading(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 != 0) goto L_0x0006
        L_0x0004:
            r2 = r1
            goto L_0x0016
        L_0x0006:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = "mailto:"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 2
            r5 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default(r2, r3, r1, r4, r5)
            if (r2 != r0) goto L_0x0004
            r2 = r0
        L_0x0016:
            if (r2 == 0) goto L_0x007c
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = "android.intent.action.SEND"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0077 }
            android.net.MailTo r3 = android.net.MailTo.parse(r9)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = "android.intent.extra.EMAIL"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0077 }
            java.lang.String r6 = ""
            if (r3 != 0) goto L_0x002d
        L_0x002b:
            r7 = r6
            goto L_0x0034
        L_0x002d:
            java.lang.String r7 = r3.getTo()     // Catch:{ Exception -> 0x0077 }
            if (r7 != 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            r5[r1] = r7     // Catch:{ Exception -> 0x0077 }
            r2.putExtra(r4, r5)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = "android.intent.extra.TEXT"
            if (r3 != 0) goto L_0x003f
        L_0x003d:
            r4 = r6
            goto L_0x0046
        L_0x003f:
            java.lang.String r4 = r3.getBody()     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x0046
            goto L_0x003d
        L_0x0046:
            r2.putExtra(r1, r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = "android.intent.extra.SUBJECT"
            if (r3 != 0) goto L_0x004f
        L_0x004d:
            r4 = r6
            goto L_0x0056
        L_0x004f:
            java.lang.String r4 = r3.getSubject()     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x0056
            goto L_0x004d
        L_0x0056:
            r2.putExtra(r1, r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = "android.intent.extra.CC"
            if (r3 != 0) goto L_0x005e
            goto L_0x0066
        L_0x005e:
            java.lang.String r3 = r3.getCc()     // Catch:{ Exception -> 0x0077 }
            if (r3 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r6 = r3
        L_0x0066:
            r2.putExtra(r1, r6)     // Catch:{ Exception -> 0x0077 }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r1)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = "message/rfc822"
            r2.setType(r1)     // Catch:{ Exception -> 0x0077 }
            com.tal.app.thinkacademy.lib.util.ActivityUtils.startActivity((android.content.Intent) r2)     // Catch:{ Exception -> 0x0077 }
            goto L_0x0080
        L_0x0077:
            boolean r0 = super.onUrlLoading(r9)
            goto L_0x0080
        L_0x007c:
            boolean r0 = super.onUrlLoading(r9)
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.business.browser.handler.HtmlToSystemHandler.onUrlLoading(java.lang.String):boolean");
    }
}
