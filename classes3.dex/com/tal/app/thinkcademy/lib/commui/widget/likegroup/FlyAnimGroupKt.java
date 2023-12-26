package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"dp2px", "", "context", "Landroid/content/Context;", "dp", "", "lib_commui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyAnimGroup.kt */
public final class FlyAnimGroupKt {
    /* access modifiers changed from: private */
    public static final int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
