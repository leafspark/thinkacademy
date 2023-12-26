package com.tal.app.thinkacademy.common;

import android.view.ViewGroup;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0006"}, d2 = {"format", "", "Landroid/view/ViewGroup$MarginLayoutParams;", "formatBadResult", "Lcom/tal/app/thinkacademy/common/entity/StateData;", "formatDevice", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonKtx.kt */
public final class CommonKtxKt {
    public static final String formatBadResult(StateData<?> stateData) {
        int i;
        Intrinsics.checkNotNullParameter(stateData, "<this>");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
            return null;
        }
        if (stateData.getStatus() == StateData.DataStatus.FAILURE) {
            i = stateData.getMStatus();
        } else {
            i = stateData.getCode();
        }
        return i + " : " + stateData.getMsg();
    }

    public static final String formatDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return DeviceUtils.getUniqueDeviceId() + 10 + str;
    }

    public static final String format(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        return "width = " + marginLayoutParams.width + ", height = " + marginLayoutParams.height + "\nleftMargin = " + marginLayoutParams.leftMargin + ", topMargin = " + marginLayoutParams.topMargin + ", rightMargin = " + marginLayoutParams.rightMargin + ", bottomMargin = " + marginLayoutParams.bottomMargin;
    }
}
