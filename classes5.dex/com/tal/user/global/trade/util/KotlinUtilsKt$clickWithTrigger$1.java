package com.tal.user.global.trade.util;

import android.view.View;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: KotlinUtils.kt */
final class KotlinUtilsKt$clickWithTrigger$1 implements View.OnClickListener {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ View $this_clickWithTrigger;

    KotlinUtilsKt$clickWithTrigger$1(View view, Function1 function1) {
        this.$this_clickWithTrigger = view;
        this.$block = function1;
    }

    public final void onClick(View view) {
        MethodInfo.onClickEventEnter(view, KotlinUtilsKt.class);
        if (KotlinUtilsKt.clickEnable(this.$this_clickWithTrigger)) {
            this.$block.invoke(this.$this_clickWithTrigger);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
