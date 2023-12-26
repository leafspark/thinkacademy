package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.app.Activity;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "list", "", "", "score", "remark", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsDelegate.kt */
final class NpsDelegate$delayShowDialog$1$1 extends Lambda implements Function3<List<? extends Integer>, Integer, String, Unit> {
    final /* synthetic */ String $planId;
    final /* synthetic */ Activity $topActivity;
    final /* synthetic */ NpsDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NpsDelegate$delayShowDialog$1$1(String str, NpsDelegate npsDelegate, Activity activity) {
        super(3);
        this.$planId = str;
        this.this$0 = npsDelegate;
        this.$topActivity = activity;
    }

    public final void invoke(List<Integer> list, int i, String str) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(str, "remark");
        String str2 = "";
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) next).intValue();
            str2 = Intrinsics.stringPlus(str2, i2 == 0 ? String.valueOf(intValue) : Intrinsics.stringPlus(",", Integer.valueOf(intValue)));
            i2 = i3;
        }
        HWEventTracking.Companion.get().ostaNpsSubmit(this.$planId, String.valueOf(i), str2, str);
        this.this$0.saveNps(this.$topActivity, this.$planId, list, i, str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<Integer>) (List) obj, ((Number) obj2).intValue(), (String) obj3);
        return Unit.INSTANCE;
    }
}
