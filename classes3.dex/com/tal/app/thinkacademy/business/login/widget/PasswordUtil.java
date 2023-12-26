package com.tal.app.thinkacademy.business.login.widget;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.lib.logger.util.MD5Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/PasswordUtil;", "", "()V", "getPassword", "", "text", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordUtil.kt */
public final class PasswordUtil {
    public static final PasswordUtil INSTANCE = new PasswordUtil();

    private PasswordUtil() {
    }

    public final String getPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        String md5 = MD5Utils.md5(MD5Utils.md5(str));
        Intrinsics.checkNotNullExpressionValue(md5, DbParams.KEY_CHANNEL_RESULT);
        return md5;
    }
}
