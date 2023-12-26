package com.tal.app.thinkacademy.business.home.main;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class LaunchActivity$startObserve$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ LaunchActivity this$0;

    public LaunchActivity$startObserve$$inlined$observe$1(LaunchActivity launchActivity) {
        this.this$0 = launchActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(T r7) {
        /*
            r6 = this;
            com.tal.app.thinkacademy.common.entity.StateData r7 = (com.tal.app.thinkacademy.common.entity.StateData) r7
            com.tal.app.thinkacademy.business.home.main.LaunchActivity r0 = r6.this$0
            r0.hideLoading()
            java.lang.Object r0 = r7.getData()
            com.tal.app.thinkacademy.business.home.main.bean.SchoolCode r0 = (com.tal.app.thinkacademy.business.home.main.bean.SchoolCode) r0
            r1 = 0
            if (r0 != 0) goto L_0x0012
            r0 = r1
            goto L_0x0016
        L_0x0012:
            java.lang.String r0 = r0.getSchoolCode()
        L_0x0016:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            if (r2 == 0) goto L_0x0026
            com.tal.app.thinkacademy.business.home.main.LaunchActivity r7 = r6.this$0
            com.tal.app.thinkacademy.business.home.main.LaunchActivity.goNormalNext$default(r7, r1, r3, r1)
            goto L_0x0081
        L_0x0026:
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r7 = r7.getStatus()
            int[] r2 = com.tal.app.thinkacademy.business.home.main.LaunchActivity.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r2[r7]
            if (r7 != r3) goto L_0x007c
            r7 = 0
            if (r0 != 0) goto L_0x0038
            goto L_0x003d
        L_0x0038:
            int r1 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x003d }
            goto L_0x003e
        L_0x003d:
            r1 = r7
        L_0x003e:
            com.tal.app.thinkacademy.common.constants.SchoolConstants r2 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            boolean r2 = r2.getIsAutoSelectSchool(r1)
            java.lang.String r4 = "LaunchActivity分校信息"
            if (r2 == 0) goto L_0x006b
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "schoolCode="
            r3.append(r5)
            r3.append(r0)
            java.lang.String r0 = "，主动设置分校"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2[r7] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r2)
            com.tal.app.thinkacademy.business.home.main.LaunchActivity r7 = r6.this$0
            r7.setChosenSchool(r1)
            goto L_0x0081
        L_0x006b:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "不在分校国家，进入选择分校"
            r0[r7] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r0)
            com.tal.app.thinkacademy.business.home.main.LaunchActivity r7 = r6.this$0
            java.lang.String r0 = "outside_white_list"
            r7.goNormalNext(r0)
            goto L_0x0081
        L_0x007c:
            com.tal.app.thinkacademy.business.home.main.LaunchActivity r7 = r6.this$0
            com.tal.app.thinkacademy.business.home.main.LaunchActivity.goNormalNext$default(r7, r1, r3, r1)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.LaunchActivity$startObserve$$inlined$observe$1.onChanged(java.lang.Object):void");
    }
}
