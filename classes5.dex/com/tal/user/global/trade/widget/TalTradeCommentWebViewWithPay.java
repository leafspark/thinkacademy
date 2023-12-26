package com.tal.user.global.trade.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.listener.TalTradeWebviewListener;
import com.tal.user.global.trade.ums.Producer;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;

public class TalTradeCommentWebViewWithPay extends TalTradeCommentWebView {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String loadUrl = "";
    /* access modifiers changed from: private */
    public TalTradeWebviewListener talTradeWebviewListener = null;
    boolean timeout = true;

    private void init() {
    }

    public TalTradeCommentWebViewWithPay(Context context2) {
        super(context2);
        this.context = context2;
    }

    public TalTradeCommentWebViewWithPay(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public TalTradeCommentWebViewWithPay(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    public void setTalTradeWebviewListener(TalTradeWebviewListener talTradeWebviewListener2) {
        this.talTradeWebviewListener = talTradeWebviewListener2;
    }

    public void setUrl(String str) {
        this.loadUrl = str;
        this.timeout = true;
        setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                WebViewInstrumentation.onReceivedSslError(webView, sslErrorHandler, sslError);
                AlertDialog.Builder builder = new AlertDialog.Builder(TalTradeCommentWebViewWithPay.this.context);
                int primaryError = sslError.getPrimaryError();
                String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? "A generic error occurred." : "The date of the certificate is invalid." : "The certificate authority is not trusted." : "The certificate Hostname mismatch." : "The certificate has expired." : "The certificate is not yet valid.";
                builder.setTitle(R.string.tal_trade_notification_error_ssl_cert_invalid);
                builder.setMessage(str);
                builder.setPositiveButton(R.string.tal_trade_notification_error_ssl_cert_continue, new TalTradeCommentWebViewWithPay$1$$ExternalSyntheticLambda0(sslErrorHandler));
                builder.setNegativeButton(R.string.tal_trade_notification_error_ssl_cert_cancel, new TalTradeCommentWebViewWithPay$1$$ExternalSyntheticLambda1(sslErrorHandler));
                AlertDialog create = builder.create();
                try {
                    if (TalTradeCommentWebViewWithPay.this.context != null) {
                        create.show();
                    }
                } catch (Exception unused) {
                }
            }

            static /* synthetic */ void lambda$onReceivedSslError$0(SslErrorHandler sslErrorHandler, DialogInterface dialogInterface, int i) {
                if (sslErrorHandler != null) {
                    sslErrorHandler.proceed();
                }
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            }

            static /* synthetic */ void lambda$onReceivedSslError$1(SslErrorHandler sslErrorHandler, DialogInterface dialogInterface, int i) {
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.access$000(r4.this$0).startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.access$100(r4.this$0))));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d3, code lost:
                return true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d4, code lost:
                return false;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00bb */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean shouldOverrideUrlLoading(android.webkit.WebView r5, java.lang.String r6) {
                /*
                    r4 = this;
                    java.lang.String r5 = "weixin://"
                    boolean r5 = r6.startsWith(r5)
                    r0 = 0
                    java.lang.String r1 = "android.intent.action.VIEW"
                    r2 = 1
                    if (r5 == 0) goto L_0x0035
                    android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x0025 }
                    r5.<init>()     // Catch:{ Exception -> 0x0025 }
                    r5.setAction(r1)     // Catch:{ Exception -> 0x0025 }
                    android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0025 }
                    r5.setData(r6)     // Catch:{ Exception -> 0x0025 }
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r6 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this     // Catch:{ Exception -> 0x0025 }
                    android.content.Context r6 = r6.context     // Catch:{ Exception -> 0x0025 }
                    r6.startActivity(r5)     // Catch:{ Exception -> 0x0025 }
                    return r2
                L_0x0025:
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    android.content.Context r5 = r5.context
                    int r6 = com.tal.user.global.trade.R.string.tal_trade_wechat_un_installed
                    android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r0)
                    r5.show()
                    return r2
                L_0x0035:
                    java.lang.String r5 = "alipays:"
                    boolean r5 = r6.startsWith(r5)
                    if (r5 != 0) goto L_0x00a8
                    java.lang.String r5 = "alipay"
                    boolean r5 = r6.startsWith(r5)
                    if (r5 == 0) goto L_0x0046
                    goto L_0x00a8
                L_0x0046:
                    java.lang.String r5 = "https://pay.thethinkacademy/app/h5/pay_cancel"
                    boolean r5 = r6.contains(r5)
                    if (r5 == 0) goto L_0x0060
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    com.tal.user.global.trade.listener.TalTradeWebviewListener r5 = r5.talTradeWebviewListener
                    if (r5 == 0) goto L_0x005f
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    com.tal.user.global.trade.listener.TalTradeWebviewListener r5 = r5.talTradeWebviewListener
                    r5.webviewPayBack()
                L_0x005f:
                    return r2
                L_0x0060:
                    java.lang.String r5 = "https://pay.thethinkacademy/app/h5/pay_success"
                    boolean r5 = r6.contains(r5)
                    if (r5 == 0) goto L_0x007a
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    com.tal.user.global.trade.listener.TalTradeWebviewListener r5 = r5.talTradeWebviewListener
                    if (r5 == 0) goto L_0x0079
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    com.tal.user.global.trade.listener.TalTradeWebviewListener r5 = r5.talTradeWebviewListener
                    r5.webviewPaSuccess()
                L_0x0079:
                    return r2
                L_0x007a:
                    java.lang.String r5 = "http:"
                    boolean r5 = r6.startsWith(r5)
                    if (r5 != 0) goto L_0x009f
                    java.lang.String r5 = "https:"
                    boolean r5 = r6.startsWith(r5)
                    if (r5 == 0) goto L_0x008b
                    goto L_0x009f
                L_0x008b:
                    android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x009e }
                    android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x009e }
                    r5.<init>(r1, r6)     // Catch:{ Exception -> 0x009e }
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r6 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this     // Catch:{ Exception -> 0x009e }
                    android.content.Context r6 = r6.context     // Catch:{ Exception -> 0x009e }
                    r6.startActivity(r5)     // Catch:{ Exception -> 0x009e }
                    return r2
                L_0x009e:
                    return r0
                L_0x009f:
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this
                    r5.loadUrl(r6)
                    com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.loadUrl2(r5, r6)
                    return r2
                L_0x00a8:
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r5 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this     // Catch:{ Exception -> 0x00bb }
                    android.content.Context r5 = r5.context     // Catch:{ Exception -> 0x00bb }
                    android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x00bb }
                    android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00bb }
                    r3.<init>(r1, r6)     // Catch:{ Exception -> 0x00bb }
                    r5.startActivity(r3)     // Catch:{ Exception -> 0x00bb }
                    return r2
                L_0x00bb:
                    android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x00d4 }
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r6 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r6 = r6.loadUrl     // Catch:{ Exception -> 0x00d4 }
                    android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00d4 }
                    r5.<init>(r1, r6)     // Catch:{ Exception -> 0x00d4 }
                    com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r6 = com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.this     // Catch:{ Exception -> 0x00d4 }
                    android.content.Context r6 = r6.context     // Catch:{ Exception -> 0x00d4 }
                    r6.startActivity(r5)     // Catch:{ Exception -> 0x00d4 }
                    return r2
                L_0x00d4:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay.AnonymousClass1.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                WebViewInstrumentation.webViewPageFinished(webView, str);
                super.onPageFinished(webView, str);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                WebViewInstrumentation.onReceivedError(webView, webResourceRequest, webResourceError);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23) {
                    TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
                    logger.i("weberror:" + webResourceError.getErrorCode() + "--" + webResourceError.getDescription());
                    if (TalTradeCommentWebViewWithPay.this.talTradeWebviewListener != null) {
                        TalTradeCommentWebViewWithPay.this.talTradeWebviewListener.webviewPageError();
                    }
                    try {
                        Producer producer = Producer.INSTANCE;
                        producer.oneSDKLog("weberror", webResourceError.getErrorCode() + "--" + webResourceError.getDescription());
                    } catch (Exception unused) {
                    }
                }
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                WebViewInstrumentation.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
                logger.i("webhttperror:" + webResourceResponse.toString());
                if (TalTradeCommentWebViewWithPay.this.talTradeWebviewListener != null) {
                    TalTradeCommentWebViewWithPay.this.talTradeWebviewListener.webviewPageError();
                }
                try {
                    Producer.INSTANCE.oneSDKLog("webhttperror", webResourceResponse.toString());
                } catch (Exception unused) {
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                WebViewInstrumentation.onReceivedError(webView, i, str, str2);
                super.onReceivedError(webView, i, str, str2);
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
                logger.i("weberror:" + str);
                if (TalTradeCommentWebViewWithPay.this.talTradeWebviewListener != null) {
                    TalTradeCommentWebViewWithPay.this.talTradeWebviewListener.webviewPageError();
                }
                try {
                    Producer.INSTANCE.oneSDKLog("weberror", str);
                } catch (Exception unused) {
                }
            }
        });
        loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(this, str);
    }
}
