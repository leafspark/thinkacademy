package com.kwai.koom.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.kwai.koom.base.CommonConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "it", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
final class CommonConfig$Builder$build$2 extends Lambda implements Function1<String, SharedPreferences> {
    final /* synthetic */ CommonConfig.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonConfig$Builder$build$2(CommonConfig.Builder builder) {
        super(1);
        this.this$0 = builder;
    }

    public final SharedPreferences invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        Application access$getMApplication$p = CommonConfig.Builder.access$getMApplication$p(this.this$0);
        return !(access$getMApplication$p instanceof Context) ? access$getMApplication$p.getSharedPreferences("performance", 0) : XMLParseInstrumentation.getSharedPreferences(access$getMApplication$p, "performance", 0);
    }
}
