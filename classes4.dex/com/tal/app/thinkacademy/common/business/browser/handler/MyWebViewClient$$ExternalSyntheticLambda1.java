package com.tal.app.thinkacademy.common.business.browser.handler;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;

public final /* synthetic */ class MyWebViewClient$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslError f$0;
    public final /* synthetic */ SslErrorHandler f$1;

    public /* synthetic */ MyWebViewClient$$ExternalSyntheticLambda1(SslError sslError, SslErrorHandler sslErrorHandler) {
        this.f$0 = sslError;
        this.f$1 = sslErrorHandler;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MyWebViewClient.lambda$showSslErrorDialog$1(this.f$0, this.f$1, dialogInterface, i);
    }
}
