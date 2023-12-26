package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ChooseTimeZoneActivity$startObserve$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ ChooseTimeZoneActivity this$0;

    public ChooseTimeZoneActivity$startObserve$$inlined$observe$1(ChooseTimeZoneActivity chooseTimeZoneActivity) {
        this.this$0 = chooseTimeZoneActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r0 = r0.getList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(T r8) {
        /*
            r7 = this;
            com.tal.app.thinkacademy.common.entity.StateData r8 = (com.tal.app.thinkacademy.common.entity.StateData) r8
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r0 = r7.this$0
            com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding r0 = r0.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r0 = r0.loadStatusView
            if (r0 != 0) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            r0.restoreView()
        L_0x0010:
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r8.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 != r1) goto L_0x00c0
            java.lang.Object r0 = r8.getData()
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r0 = (com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity) r0
            r2 = 0
            if (r0 != 0) goto L_0x002a
        L_0x0028:
            r0 = r2
            goto L_0x003b
        L_0x002a:
            java.util.ArrayList r0 = r0.getList()
            if (r0 != 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x0028
            r0 = r1
        L_0x003b:
            if (r0 == 0) goto L_0x00ba
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r0 = r7.this$0
            com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter r0 = r0.mChooseTimeZoneAdapter
            if (r0 != 0) goto L_0x0046
            goto L_0x0059
        L_0x0046:
            java.lang.Object r3 = r8.getData()
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r3 = (com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity) r3
            if (r3 != 0) goto L_0x0050
            r3 = 0
            goto L_0x0054
        L_0x0050:
            java.util.ArrayList r3 = r3.getList()
        L_0x0054:
            java.util.Collection r3 = (java.util.Collection) r3
            r0.setList(r3)
        L_0x0059:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Object r3 = r8.getData()
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "time_zone_list"
            r0.saveCacheGsonEntity(r3, r5, r4)
            r0 = -1
            java.lang.Object r8 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r8 = (com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity) r8
            java.util.ArrayList r8 = r8.getList()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r3 = r2
        L_0x007d:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x00ab
            java.lang.Object r4 = r8.next()
            int r5 = r3 + 1
            if (r3 >= 0) goto L_0x008e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x008e:
            com.tal.app.thinkacademy.business.login.entity.TimeZone r4 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r4
            java.lang.String r4 = r4.getId()
            if (r4 != 0) goto L_0x0098
        L_0x0096:
            r4 = r2
            goto L_0x00a5
        L_0x0098:
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r6 = r7.this$0
            java.lang.String r6 = r6.getCurrentTimeZone()
            boolean r4 = r4.equals(r6)
            if (r4 != r1) goto L_0x0096
            r4 = r1
        L_0x00a5:
            if (r4 == 0) goto L_0x00a9
            r0 = r3
            goto L_0x00ab
        L_0x00a9:
            r3 = r5
            goto L_0x007d
        L_0x00ab:
            if (r0 < 0) goto L_0x00c5
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r8 = r7.this$0
            androidx.recyclerview.widget.LinearLayoutManager r8 = r8.mLayoutManager
            if (r8 != 0) goto L_0x00b6
            goto L_0x00c5
        L_0x00b6:
            r8.scrollToPositionWithOffset(r0, r2)
            goto L_0x00c5
        L_0x00ba:
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r8 = r7.this$0
            r8.showMainDataEmpty()
            goto L_0x00c5
        L_0x00c0:
            com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r8 = r7.this$0
            r8.showMainDataEmpty()
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity$startObserve$$inlined$observe$1.onChanged(java.lang.Object):void");
    }
}
