package com.tal.app.thinkacademy.common.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"copyClipboard", "", "cxt", "Landroid/content/Context;", "shareContent", "", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClipboardUtil.kt */
public final class ClipboardUtilKt {
    public static final void copyClipboard(Context context, String str) {
        Context applicationContext;
        Object systemService;
        if (context != null && (applicationContext = context.getApplicationContext()) != null && (systemService = applicationContext.getSystemService("clipboard")) != null) {
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (str == null) {
                str = "";
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(r0, str));
        }
    }
}
