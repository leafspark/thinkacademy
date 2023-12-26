package com.tal.app.thinkacademy.business.home.main.dialog;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/home/main/dialog/StoreLowWarnDialog$makeLinkClickable$clickable$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "view", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StoreLowWarnDialog.kt */
public final class StoreLowWarnDialog$makeLinkClickable$clickable$1 extends ClickableSpan {
    final /* synthetic */ StoreLowWarnDialog this$0;

    StoreLowWarnDialog$makeLinkClickable$clickable$1(StoreLowWarnDialog storeLowWarnDialog) {
        this.this$0 = storeLowWarnDialog;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.this$0.getContext().startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setColor(Color.parseColor("#2F9AFF"));
        textPaint.setUnderlineText(false);
    }
}
