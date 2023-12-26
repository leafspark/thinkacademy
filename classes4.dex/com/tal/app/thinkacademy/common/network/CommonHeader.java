package com.tal.app.thinkacademy.common.network;

import com.tal.app.thinkacademy.common.utils.ChannelUtil;
import com.tal.app.thinkacademy.lib.utils.TableUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/CommonHeader;", "", "()V", "clientType", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonHeader.kt */
public final class CommonHeader {
    public static final CommonHeader INSTANCE = new CommonHeader();

    private CommonHeader() {
    }

    public final String clientType() {
        if (ChannelUtil.INSTANCE.isXPadChannel()) {
            return "ANDROID_HD_STUDENT_XPAD";
        }
        boolean isGoogleChannel = ChannelUtil.INSTANCE.isGoogleChannel();
        return TableUtils.isTable() ? isGoogleChannel ? "ANDROID_HD_STUDENT_GOOG" : "ANDROID_HD_STUDENT" : isGoogleChannel ? "ANDROID_PHONE_STUDENT_GOOG" : "ANDROID_PHONE_STUDENT";
    }
}
