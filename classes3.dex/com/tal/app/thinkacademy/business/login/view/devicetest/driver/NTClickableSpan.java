package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/NTClickableSpan;", "Landroid/text/style/ClickableSpan;", "color", "", "(I)V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTestDriver.kt */
abstract class NTClickableSpan extends ClickableSpan {
    private int color;

    public NTClickableSpan(int i) {
        this.color = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(false);
    }
}
