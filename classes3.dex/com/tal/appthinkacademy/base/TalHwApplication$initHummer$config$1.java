package com.tal.appthinkacademy.base;

import android.content.Context;
import android.content.Intent;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.DefaultIntentCreator;
import com.tal.app.thinkacademy.business.bus_hummer.HwHummerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/appthinkacademy/base/TalHwApplication$initHummer$config$1", "Lcom/didi/hummer/adapter/navigator/impl/DefaultIntentCreator;", "createHummerIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "page", "Lcom/didi/hummer/adapter/navigator/NavPage;", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
public final class TalHwApplication$initHummer$config$1 extends DefaultIntentCreator {
    TalHwApplication$initHummer$config$1() {
    }

    public Intent createHummerIntent(Context context, NavPage navPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navPage, "page");
        Intent intent = new Intent(context, HwHummerActivity.class);
        appendBaseIntentParams(intent, navPage);
        return intent;
    }
}
