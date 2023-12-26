package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;

public final /* synthetic */ class LogoConnectionTask$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ LogoConnectionTask f$0;
    public final /* synthetic */ BitmapDrawable f$1;

    public /* synthetic */ LogoConnectionTask$$ExternalSyntheticLambda1(LogoConnectionTask logoConnectionTask, BitmapDrawable bitmapDrawable) {
        this.f$0 = logoConnectionTask;
        this.f$1 = bitmapDrawable;
    }

    public final void run() {
        LogoConnectionTask.m39notifyLogo$lambda1(this.f$0, this.f$1);
    }
}
