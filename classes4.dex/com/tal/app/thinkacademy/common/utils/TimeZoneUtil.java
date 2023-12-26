package com.tal.app.thinkacademy.common.utils;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/TimeZoneUtil;", "", "()V", "appTimeZoneEqualsBranchSchool", "", "appTimeZoneEqualsSetting", "getAppTimeZone", "", "getBranchSchoolTimeZone", "getTimeZone", "isFirstVersionShowTimeZone", "isShowTimeZoneBranchSchool", "setTimeZoneEqualsBranchSchool", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneUtil.kt */
public final class TimeZoneUtil {
    public static final TimeZoneUtil INSTANCE = new TimeZoneUtil();

    private TimeZoneUtil() {
    }

    public final String getTimeZone() {
        if (!isShowTimeZoneBranchSchool()) {
            return "";
        }
        ShareDataManager instance = ShareDataManager.getInstance();
        CharSequence id = TimeZone.getDefault().getID();
        String string = instance.getString(ShareDataKey.REAL_SHOW_TIME_ZONE, id == null || StringsKt.isBlank(id) ? getBranchSchoolTimeZone() : TimeZone.getDefault().getID(), ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…EDATA_NOT_CLEAR\n        )");
        return string;
    }

    public final String getAppTimeZone() {
        String string = ShareDataManager.getInstance().getString(ShareDataKey.TIME_ZONE, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
        return string;
    }

    public final boolean appTimeZoneEqualsSetting() {
        return ShareDataManager.getInstance().getString(ShareDataKey.TIME_ZONE, "", ShareDataManager.SHAREDATA_NOT_CLEAR).equals(TimeZone.getDefault().getID());
    }

    public final boolean appTimeZoneEqualsBranchSchool() {
        return ShareDataManager.getInstance().getString(ShareDataKey.TIME_ZONE, "", ShareDataManager.SHAREDATA_NOT_CLEAR).equals(getBranchSchoolTimeZone());
    }

    public final boolean setTimeZoneEqualsBranchSchool() {
        return TimeZone.getDefault().getID().equals(getBranchSchoolTimeZone());
    }

    public final boolean isFirstVersionShowTimeZone() {
        return AppUtils.getAppVersionCode() > ShareDataManager.getInstance().getInt(ShareDataKey.FIRST_SHOW_TIME_ZONE_VERSION_CODE, -1, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.get(com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance().getString("school_code", "415", com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getBranchSchoolTimeZone() {
        /*
            r6 = this;
            com.tal.app.thinkacademy.common.imconfig.ImConfig r0 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.util.HashMap r0 = r0.getTimeZoneV2Map()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000b
            goto L_0x0023
        L_0x000b:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r4 = "school_code"
            java.lang.String r5 = "415"
            java.lang.String r2 = r2.getString(r4, r5, r3)
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.utils.TimeZoneUtil.getBranchSchoolTimeZone():java.lang.String");
    }

    public final boolean isShowTimeZoneBranchSchool() {
        List<String> timeZoneSwitchSchool = ImConfig.INSTANCE.getTimeZoneSwitchSchool();
        if (timeZoneSwitchSchool == null) {
            return false;
        }
        return timeZoneSwitchSchool.contains(ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR));
    }
}
