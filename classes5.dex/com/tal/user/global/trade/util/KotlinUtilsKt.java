package com.tal.user.global.trade.util;

import android.view.View;
import com.tal.user.global.trade.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u0003H\u0002¢\u0006\u0002\u0010\u000e\u001a7\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0002\u0010\u0014\"2\u0010\u0002\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0006\u0010\u0000\u001a\u00020\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\"2\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0006\u0010\u0000\u001a\u00020\u00018B@BX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"value", "", "triggerDelay", "T", "Landroid/view/View;", "getTriggerDelay", "(Landroid/view/View;)J", "setTriggerDelay", "(Landroid/view/View;J)V", "triggerLastTime", "getTriggerLastTime", "setTriggerLastTime", "clickEnable", "", "(Landroid/view/View;)Z", "clickWithTrigger", "", "delay", "block", "Lkotlin/Function1;", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "android_taltradeglobal_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: KotlinUtils.kt */
public final class KotlinUtilsKt {
    public static /* synthetic */ void clickWithTrigger$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        clickWithTrigger(view, j, function1);
    }

    public static final <T extends View> void clickWithTrigger(T t, long j, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "$this$clickWithTrigger");
        Intrinsics.checkNotNullParameter(function1, "block");
        setTriggerDelay(t, j);
        t.setOnClickListener(new KotlinUtilsKt$clickWithTrigger$1(t, function1));
    }

    private static final <T extends View> long getTriggerLastTime(T t) {
        if (t.getTag(R.id.triggerLastTimeKeyAssembly) == null) {
            return 0;
        }
        Object tag = t.getTag(R.id.triggerLastTimeKeyAssembly);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    private static final <T extends View> void setTriggerLastTime(T t, long j) {
        t.setTag(R.id.triggerLastTimeKeyAssembly, Long.valueOf(j));
    }

    private static final <T extends View> long getTriggerDelay(T t) {
        if (t.getTag(R.id.triggerDelayKeyAssembly) == null) {
            return -1;
        }
        Object tag = t.getTag(R.id.triggerDelayKeyAssembly);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    private static final <T extends View> void setTriggerDelay(T t, long j) {
        t.setTag(R.id.triggerDelayKeyAssembly, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static final <T extends View> boolean clickEnable(T t) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - getTriggerLastTime(t) >= getTriggerDelay(t);
        setTriggerLastTime(t, currentTimeMillis);
        return z;
    }
}
