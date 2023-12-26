package com.didi.hummer.module;

import android.text.TextUtils;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.lifecycle.ILifeCycle;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Component("Request")
public class Request implements ILifeCycle {
    @JsProperty("header")
    public Map<String, Object> header;
    private IHttpAdapter httpAdapter;
    private AtomicBoolean isDestroyed = new AtomicBoolean(false);
    private JSValue jsValue;
    @JsProperty("method")
    public String method = IHttpAdapter.METHOD_POST;
    @JsProperty("param")
    public Map<String, Object> param;
    @JsProperty("timeout")
    public int timeout = 10000;
    @JsProperty("url")
    public String url = "";

    public void onCreate() {
    }

    public Request(HummerContext hummerContext, JSValue jSValue) {
        this.jsValue = jSValue;
        this.httpAdapter = HummerAdapter.getHttpAdapter(hummerContext.getNamespace());
    }

    public void onDestroy() {
        this.isDestroyed.set(true);
        this.jsValue.unprotect();
    }

    public void setUrl(String str) {
        IHttpAdapter iHttpAdapter = this.httpAdapter;
        if (iHttpAdapter != null) {
            String onUrlIntercept = iHttpAdapter.onUrlIntercept(str);
            if (!TextUtils.isEmpty(onUrlIntercept)) {
                this.url = onUrlIntercept;
                return;
            }
        }
        this.url = str;
    }

    public void setMethod(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.method = str.toUpperCase();
        }
    }

    @JsMethod("send")
    public void send(JSCallback jSCallback) {
        this.jsValue.protect();
        this.httpAdapter.request(this.url, this.method, this.timeout, this.header, this.param, new Request$$ExternalSyntheticLambda0(this, jSCallback), Object.class);
    }

    public /* synthetic */ void lambda$send$0$Request(JSCallback jSCallback, HttpResponse httpResponse) {
        if (!this.isDestroyed.get()) {
            if (jSCallback != null) {
                jSCallback.call(httpResponse);
                jSCallback.release();
            }
            this.jsValue.unprotect();
        }
    }
}
