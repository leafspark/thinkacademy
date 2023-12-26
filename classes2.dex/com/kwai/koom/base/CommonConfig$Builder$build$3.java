package com.kwai.koom.base;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "it", "Landroid/content/SharedPreferences;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
final class CommonConfig$Builder$build$3 extends Lambda implements Function1<SharedPreferences, Set<String>> {
    public static final CommonConfig$Builder$build$3 INSTANCE = new CommonConfig$Builder$build$3();

    CommonConfig$Builder$build$3() {
        super(1);
    }

    public final Set<String> invoke(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "it");
        return sharedPreferences.getAll().keySet();
    }
}
