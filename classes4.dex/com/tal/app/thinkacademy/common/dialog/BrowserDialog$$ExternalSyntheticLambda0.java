package com.tal.app.thinkacademy.common.dialog;

import android.webkit.ValueCallback;
import androidx.lifecycle.Observer;

public final /* synthetic */ class BrowserDialog$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ BrowserDialog f$0;

    public /* synthetic */ BrowserDialog$$ExternalSyntheticLambda0(BrowserDialog browserDialog) {
        this.f$0 = browserDialog;
    }

    public final void onChanged(Object obj) {
        BrowserDialog.m37initObservers$lambda1(this.f$0, (ValueCallback) obj);
    }
}
