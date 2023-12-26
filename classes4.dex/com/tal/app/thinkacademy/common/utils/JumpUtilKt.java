package com.tal.app.thinkacademy.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"jumpUrl", "", "context", "Landroid/content/Context;", "url", "", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: JumpUtil.kt */
public final class JumpUtilKt {
    public static final void jumpUrl(Context context, String str) {
        try {
            if (!(!StringsKt.isBlank(str == null ? "" : str))) {
                return;
            }
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } catch (Exception unused) {
        }
    }
}
