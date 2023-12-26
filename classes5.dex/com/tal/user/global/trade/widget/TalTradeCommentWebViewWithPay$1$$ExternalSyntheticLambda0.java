package com.tal.user.global.trade.widget;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
import com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay;

public final /* synthetic */ class TalTradeCommentWebViewWithPay$1$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler f$0;

    public /* synthetic */ TalTradeCommentWebViewWithPay$1$$ExternalSyntheticLambda0(SslErrorHandler sslErrorHandler) {
        this.f$0 = sslErrorHandler;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TalTradeCommentWebViewWithPay.AnonymousClass1.lambda$onReceivedSslError$0(this.f$0, dialogInterface, i);
    }
}
