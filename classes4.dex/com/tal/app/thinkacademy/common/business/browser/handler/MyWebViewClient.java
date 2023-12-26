package com.tal.app.thinkacademy.common.business.browser.handler;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyWebViewClient extends WebViewClient {
    private static Boolean mIsAllow = false;
    private IWebViewClient iWebViewClient;
    private AlertDialog mDialog = null;
    private List<WebViewLifeHandler> mWebHandlers;

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewInstrumentation.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewInstrumentation.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public MyWebViewClient(List<WebViewLifeHandler> list, IWebViewClient iWebViewClient2) {
        this.mWebHandlers = list;
        this.iWebViewClient = iWebViewClient2;
    }

    public void setWebHandlers(List<WebViewLifeHandler> list) {
        this.mWebHandlers = list;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        XesLog.dt("MyWebViewClient", "Leather***********shouldOverrideUrlLoading url***********" + str);
        if (webView != null && XesWebViewCookieUtils.isOwnHost(str)) {
            XesWebViewCookieUtils.syncCookie(str, (Map<String, String>) null, webView);
        }
        IWebViewClient iWebViewClient2 = this.iWebViewClient;
        if (iWebViewClient2 == null || !iWebViewClient2.onUrlLoading(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (str == null || !str.contains("redbagrainPackage")) {
            XesLog.it("MyWebViewClient", "当前时间戳：" + System.currentTimeMillis() + "，onPageStarted>>>url=" + str);
        } else {
            Tag tag = Tag.RED_PACKAGE_RAIN;
            XesLog.i(tag, "当前时间戳：" + System.currentTimeMillis() + "，onPageStarted>>>url=" + str);
        }
        for (WebViewLifeHandler onPageStart : this.mWebHandlers) {
            onPageStart.onPageStart(str);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        WebViewInstrumentation.webViewPageFinished(webView, str);
        if (str == null || !str.contains("redbagrainPackage")) {
            XesLog.it("MyWebViewClient", "当前时间戳：" + System.currentTimeMillis() + "，onPageFinished>>>url=" + str);
        } else {
            Tag tag = Tag.RED_PACKAGE_RAIN;
            XesLog.i(tag, "当前时间戳：" + System.currentTimeMillis() + "，onPageFinished>>>url=" + str);
        }
        for (WebViewLifeHandler onPageFinish : this.mWebHandlers) {
            onPageFinish.onPageFinish(str);
        }
        super.onPageFinished(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewInstrumentation.onReceivedError(webView, webResourceRequest, webResourceError);
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String uri = webResourceRequest.getUrl().toString();
        XesLog.et("MyWebViewClient", "Leather***********onReceivedError url***********" + uri + (", errorMsg code:" + webResourceError.getErrorCode() + ", msg" + webResourceError.getDescription().toString()));
        if (webResourceRequest.isForMainFrame()) {
            for (WebViewLifeHandler next : this.mWebHandlers) {
                if (XesWebViewCookieUtils.validHost(uri)) {
                    next.onReceivedError(uri, webResourceError);
                }
            }
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    private void showSslErrorDialog(Context context, SslErrorHandler sslErrorHandler, SslError sslError) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        int primaryError = sslError.getPrimaryError();
        String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? "A generic error occurred." : "The date of the certificate is invalid." : "The certificate authority is not trusted." : "The certificate Hostname mismatch." : "The certificate has expired." : "The certificate is not yet valid.";
        builder.setTitle(context.getString(R.string.common_error_ssl_cert_invalid));
        builder.setMessage(str);
        builder.setPositiveButton(context.getString(R.string.common_error_ssl_cert_continue), new MyWebViewClient$$ExternalSyntheticLambda0(sslError, sslErrorHandler));
        builder.setNegativeButton(context.getString(R.string.common_error_ssl_cert_cancel), new MyWebViewClient$$ExternalSyntheticLambda1(sslError, sslErrorHandler));
        AlertDialog create = builder.create();
        this.mDialog = create;
        create.setOnDismissListener(new MyWebViewClient$$ExternalSyntheticLambda2(this));
        if (mIsAllow.booleanValue()) {
            sslErrorHandler.proceed();
        } else {
            this.mDialog.show();
        }
    }

    static /* synthetic */ void lambda$showSslErrorDialog$0(SslError sslError, SslErrorHandler sslErrorHandler, DialogInterface dialogInterface, int i) {
        XesLog.dt("MyWebViewClient", "ssl弹窗点击继续:" + sslError.toString());
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
        mIsAllow = true;
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    static /* synthetic */ void lambda$showSslErrorDialog$1(SslError sslError, SslErrorHandler sslErrorHandler, DialogInterface dialogInterface, int i) {
        XesLog.dt("MyWebViewClient", "ssl弹窗点击取消:" + sslError.toString());
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    public /* synthetic */ void lambda$showSslErrorDialog$2$MyWebViewClient(DialogInterface dialogInterface) {
        this.mDialog = null;
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewInstrumentation.onReceivedSslError(webView, sslErrorHandler, sslError);
        try {
            Context context = webView.getContext();
            if (context != null) {
                if (this.mDialog == null) {
                    showSslErrorDialog(context, sslErrorHandler, sslError);
                } else {
                    sslErrorHandler.cancel();
                    XesLog.dt("MyWebViewClient", "显示过弹窗了，不需要再弹" + sslError.toString());
                }
            }
        } catch (Exception unused) {
            sslErrorHandler.cancel();
            XesLog.dt("MyWebViewClient", "显示ssl弹窗失败:" + sslError.toString());
        }
        XesLog.dt("MyWebViewClient", "UserInfo:uid=" + UserInfoBll.getInstance().getUserInfoEntity().getUid() + "onReceivedSslError=SslError:" + sslError.toString());
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        super.onScaleChanged(webView, f, f2);
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    private boolean chkMySSLCNCert(SslCertificate sslCertificate) {
        byte[] hexToBytes = hexToBytes("EC783E7D9DF1EFC10305C234D85DF5C75A0C40A5CC884C4DA22B2384680F8488");
        byte[] hexToBytes2 = hexToBytes("6743BB3688A196B646050DCA87885198D05FDF949BB6FC5C2AE9687008802402");
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray == null) {
            return false;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray))).getEncoded());
            if (Arrays.equals(digest, hexToBytes) || Arrays.equals(digest, hexToBytes2)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] hexToBytes(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        int length = str.length() / 2;
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int indexOf = "0123456789abcdef".indexOf(charArray[i2]) << 4;
            int indexOf2 = "0123456789abcdef".indexOf(charArray[i2 + 1]);
            if (indexOf == -1 || indexOf2 == -1) {
                return null;
            }
            bArr[i] = (byte) (indexOf2 | indexOf);
        }
        return bArr;
    }
}
