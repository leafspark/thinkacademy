package com.tal.app.thinkacademy.live.business.schulte;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.abilitypack.schulte.SchulteTableViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "source", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginDriver.kt */
final class SchulteTablePluginDriver$observeListener$1$submit$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ float $duration;
    final /* synthetic */ String $interactId;
    final /* synthetic */ SchulteTablePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTablePluginDriver$observeListener$1$submit$1(SchulteTablePluginDriver schulteTablePluginDriver, String str, float f) {
        super(1);
        this.this$0 = schulteTablePluginDriver;
        this.$interactId = str;
        this.$duration = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        SchulteTablePluginDriver schulteTablePluginDriver = this.this$0;
        schulteTablePluginDriver.mSubmitTimes = schulteTablePluginDriver.mSubmitTimes + 1;
        XesLog.a(SchulteTablePluginDriver.TAG, str + "重试提交游戏结果,重试次数:" + this.this$0.mSubmitTimes + "，互动id:" + this.$interactId + "，成绩:" + this.$duration);
        SchulteTableViewModel access$getMViewModel$p = this.this$0.mViewModel;
        if (access$getMViewModel$p != null) {
            access$getMViewModel$p.submitSchulteTableUserData(this.this$0.mPlanId, this.$interactId, Float.valueOf(this.$duration));
        }
    }
}
