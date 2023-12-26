package atd.q0;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import atd.d.f;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

public final class b extends a<f, atd.p0.b> {
    static final Charset c = com.adyen.threeds2.internal.b.a;
    private final WebView b;

    static {
        atd.s0.a.a(-840644022823488L);
        atd.s0.a.a(-840656907725376L);
        atd.s0.a.a(-840665497659968L);
        atd.s0.a.a(-840704152365632L);
        atd.s0.a.a(-841034864847424L);
    }

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(f fVar) {
        a(fVar.b());
    }

    public void b(f fVar) {
        a(fVar.c());
    }

    /* access modifiers changed from: protected */
    public int getChallengeContainerLayoutId() {
        return R.layout.a3ds2_view_challenge_html_container;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String c2 = atd.r0.a.a().c(str);
            WebView webView = this.b;
            String a2 = atd.s0.a.a(-840790051711552L);
            String a3 = atd.s0.a.a(-840785756744256L);
            WebView webView2 = webView;
            String str2 = a2;
            String str3 = c2;
            String str4 = a3;
            String charset = c.toString();
            webView2.loadDataWithBaseURL(str2, str3, str4, charset, (String) null);
            SensorsDataAutoTrackHelper.loadDataWithBaseURL2(webView2, str2, str3, str4, charset, (String) null);
        }
    }

    private final class a extends WebViewClient {
        a() {
        }

        private WebResourceResponse a(Uri uri) {
            if (atd.s0.a.a(-841185188702784L).equals(uri.getScheme())) {
                return null;
            }
            if (!atd.s0.a.a(-841198073604672L).equalsIgnoreCase(uri.getScheme()) || !atd.s0.a.a(-841241023277632L).equalsIgnoreCase(uri.getHost()) || !atd.s0.a.a(-841554555890240L).equalsIgnoreCase(uri.getPath())) {
                return a(atd.s0.a.a(-841606095497792L) + uri.toString());
            }
            if (b.this.getChallengeListener() != null) {
                ((atd.p0.b) b.this.getChallengeListener()).b(uri.getQuery());
            }
            return a(atd.s0.a.a(-841576030726720L));
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebViewInstrumentation.webViewPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebViewInstrumentation.onReceivedError(webView, i, str, str2);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebViewInstrumentation.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            WebViewInstrumentation.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            WebViewInstrumentation.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                return a(Uri.parse(str));
            } catch (Exception unused) {
                return a(atd.s0.a.a(-841382757198400L) + str);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl());
        }

        private WebResourceResponse a(String str) {
            return new WebResourceResponse(atd.s0.a.a(-841515901184576L), b.c.toString(), new ByteArrayInputStream(str.getBytes(b.c)));
        }
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        WebView webView = (WebView) findViewById(R.id.webView_htmlChallengeContainer);
        this.b = webView;
        webView.getSettings().setJavaScriptEnabled(false);
        a aVar = new a();
        if (!(webView instanceof WebView)) {
            webView.setWebViewClient(aVar);
        } else {
            WebViewInstrumentation.setsetWebViewClient(webView, aVar);
        }
    }
}
