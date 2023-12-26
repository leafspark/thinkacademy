package com.tal.app.thinkacademy.live.business.allonstage.adapter;

import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.tal.app.thinkacademy.live.business.allonstage.adapter.AllOnStagePhoneAdapter$showMicLight$lambda-9$lambda-8$$inlined$Runnable$1  reason: invalid class name */
/* compiled from: Runnable.kt */
public final class AllOnStagePhoneAdapter$showMicLight$lambda9$lambda8$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ StudentVideoBean.ListBean $item$inlined;
    final /* synthetic */ Integer $pos$inlined;
    final /* synthetic */ AllOnStagePhoneAdapter this$0;

    public AllOnStagePhoneAdapter$showMicLight$lambda9$lambda8$$inlined$Runnable$1(StudentVideoBean.ListBean listBean, AllOnStagePhoneAdapter allOnStagePhoneAdapter, Integer num) {
        this.$item$inlined = listBean;
        this.this$0 = allOnStagePhoneAdapter;
        this.$pos$inlined = num;
    }

    public final void run() {
        this.$item$inlined.setShowMicLight(false);
        AllOnStagePhoneAdapter allOnStagePhoneAdapter = this.this$0;
        Intrinsics.checkNotNullExpressionValue(this.$pos$inlined, "pos");
        allOnStagePhoneAdapter.notifyPos(this.$pos$inlined.intValue());
        this.this$0.mHighLightRunnableMap.remove(this.$pos$inlined);
    }
}
