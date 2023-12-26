package com.tal.app.thinkacademy.common.bonree;

import android.app.Application;
import com.bonree.sdk.agent.Bonree;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/bonree/BonreeInit;", "", "()V", "init", "", "application", "Landroid/app/Application;", "appKey", "", "updateUserInfo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BonreeInit.kt */
public final class BonreeInit {
    public static final BonreeInit INSTANCE = new BonreeInit();

    private BonreeInit() {
    }

    public final void init(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        try {
            Bonree.withAppID(str).withConfigAddress("https://bornee-admin.thethinkacademy.com/config").start(application);
            updateUserInfo();
        } catch (Exception unused) {
            XesLog.et("", "博睿初始化失败");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[Catch:{ Exception -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateUserInfo() {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x006b }
            r2.<init>()     // Catch:{ Exception -> 0x006b }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x006b }
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r3 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion     // Catch:{ Exception -> 0x006b }
            com.tal.app.thinkacademy.common.user.UserInfoBll r3 = r3.getInstance()     // Catch:{ Exception -> 0x006b }
            com.tal.app.thinkacademy.common.user.UserInfo r3 = r3.getUserInfoEntity()     // Catch:{ Exception -> 0x006b }
            if (r3 != 0) goto L_0x0016
            goto L_0x0057
        L_0x0016:
            java.lang.String r4 = r3.getUid()     // Catch:{ Exception -> 0x006b }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x006b }
            if (r4 == 0) goto L_0x0027
            int r4 = r4.length()     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r1
        L_0x0028:
            if (r4 != 0) goto L_0x003a
            java.lang.String r4 = "hw_user_id"
            java.lang.String r5 = r3.getUid()     // Catch:{ Exception -> 0x006b }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = r3.getUid()     // Catch:{ Exception -> 0x006b }
            com.bonree.sdk.agent.Bonree.setUserID(r4)     // Catch:{ Exception -> 0x006b }
        L_0x003a:
            java.lang.String r4 = r3.getNickName()     // Catch:{ Exception -> 0x006b }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x006b }
            if (r4 == 0) goto L_0x004b
            int r4 = r4.length()     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r4 = r0
            goto L_0x004c
        L_0x004b:
            r4 = r1
        L_0x004c:
            if (r4 != 0) goto L_0x0057
            java.lang.String r4 = "hw_nickname"
            java.lang.String r3 = r3.getNickName()     // Catch:{ Exception -> 0x006b }
            r2.put(r4, r3)     // Catch:{ Exception -> 0x006b }
        L_0x0057:
            java.lang.String r3 = "hw_device_id"
            java.lang.String r4 = com.tal.app.thinkacademy.lib.util.DeviceUtils.getUniqueDeviceId()     // Catch:{ Exception -> 0x006b }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x006b }
            boolean r3 = r2.isEmpty()     // Catch:{ Exception -> 0x006b }
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0076
            com.bonree.sdk.agent.Bonree.setExtraInfo(r2)     // Catch:{ Exception -> 0x006b }
            goto L_0x0076
        L_0x006b:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "博睿更新用户信息失败"
            r1[r0] = r2
            java.lang.String r0 = ""
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r0, r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.bonree.BonreeInit.updateUserInfo():void");
    }
}
