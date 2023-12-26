package com.tal.user.global.trade.http;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.FastJsonInstrumentation;
import com.tal.user.global.trade.BuildConfig;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.http.TalHttpCode;
import com.tal.user.global.trade.util.JNISecurity;
import com.tal.user.global.trade.util.TalDeviceUtils;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import com.tekartik.sqflite.Constant;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class TalHttpManager extends TalTradeBaseHttp {
    private static TalHttpManager instance;
    private ExecutorService mExecutorService = new ThreadPoolExecutor(0, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque());

    public static TalHttpManager getInstance() {
        if (instance == null) {
            synchronized (TalHttpManager.class) {
                if (instance == null) {
                    instance = new TalHttpManager();
                }
            }
        }
        return instance;
    }

    public void postWithDefaultParam(String str, TalHttpRequestParams talHttpRequestParams, TalHttpCallBack talHttpCallBack) {
        setDefaultParam(talHttpRequestParams);
        post(str, talHttpRequestParams, 1, true, talHttpCallBack);
    }

    private TalHttpManager() {
    }

    /* access modifiers changed from: private */
    public void post(String str, TalHttpRequestParams talHttpRequestParams, int i, boolean z, TalHttpCallBack talHttpCallBack) {
        talHttpCallBack.setUrl(str);
        final String str2 = str;
        final TalHttpRequestParams talHttpRequestParams2 = talHttpRequestParams;
        final TalHttpCallBack talHttpCallBack2 = talHttpCallBack;
        final int i2 = i;
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                try {
                    TalHttpResponse sendPost = TalHttpManager.this.sendPost(str2, talHttpRequestParams2);
                    TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                    logger.i("url:" + str2 + "  param:" + FastJsonInstrumentation.toJSONString(talHttpRequestParams2) + "   res:" + sendPost.getCode() + sendPost.getResult());
                    TalHttpManager.this.handleHttpResult(talHttpRequestParams2.getBodyParam(), str2, sendPost, talHttpCallBack2, "");
                } catch (Exception e) {
                    if (i2 <= 0 || !TalTradeSdk.getInstance().isNetAvailable()) {
                        TalTradeLogger logger2 = TalTradeLoggerFactory.getLogger("");
                        logger2.i("url:" + str2 + "   err:" + e);
                        TalHttpManager.this.handleHttpResult(talHttpRequestParams2.getBodyParam(), str2, new TalHttpResponse(TalHttpManager.this.getErrorCode(e), TalTradeSdk.getInstance().getApplication().getResources().getString(R.string.tal_trade_net_error)), talHttpCallBack2, e.toString());
                        return;
                    }
                    TalHttpManager.this.post(str2, talHttpRequestParams2, i2 - 1, false, talHttpCallBack2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleHttpResult(Map<String, String> map, String str, final TalHttpResponse talHttpResponse, final TalHttpCallBack talHttpCallBack, String str2) {
        final String str3;
        String str4;
        Handler handler = new Handler(Looper.getMainLooper());
        if (talHttpResponse.getCode() == 200) {
            try {
                JSONObject jSONObject = new JSONObject(talHttpResponse.getResult());
                if (jSONObject.has(Constant.PARAM_ERROR_CODE)) {
                    if (jSONObject.has(Constant.PARAM_ERROR_DATA)) {
                        jSONObject.has("msg");
                    }
                }
                int optInt = jSONObject.optInt(Constant.PARAM_ERROR_CODE);
                final String optString = jSONObject.optString("msg");
                if (jSONObject.has("subCode")) {
                    str3 = jSONObject.optString("subCode");
                } else {
                    str3 = "";
                }
                if (jSONObject.has("subMsg")) {
                    str4 = jSONObject.optString("subMsg");
                } else {
                    str4 = "";
                }
                final Object opt = jSONObject.opt(Constant.PARAM_ERROR_DATA);
                if (optInt != 10000 || !"200".equals(str3)) {
                    if (!TextUtils.isEmpty(str4)) {
                        optString = str4;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = optInt + "";
                    }
                    AnonymousClass3 r6 = new Runnable() {
                        public void run() {
                            TalHttpCallBack talHttpCallBack = talHttpCallBack;
                            if (talHttpCallBack != null) {
                                talHttpCallBack.onError(str3, optString);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r6);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r6);
                    }
                } else {
                    AnonymousClass2 r62 = new Runnable() {
                        public void run() {
                            TalHttpCallBack talHttpCallBack = talHttpCallBack;
                            if (talHttpCallBack != null) {
                                talHttpCallBack.onSuccess(opt);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r62);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r62);
                    }
                }
            } catch (JSONException unused) {
                AnonymousClass4 r63 = new Runnable() {
                    public void run() {
                        TalHttpCallBack talHttpCallBack = talHttpCallBack;
                        if (talHttpCallBack != null) {
                            talHttpCallBack.onError(13201, TalTradeSdk.getInstance().getApplication().getResources().getString(R.string.tal_trade_data_parse_error));
                        }
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r63);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r63);
                }
            } catch (Exception e) {
                AnonymousClass5 r7 = new Runnable() {
                    public void run() {
                        TalHttpCallBack talHttpCallBack = talHttpCallBack;
                        if (talHttpCallBack != null) {
                            talHttpCallBack.onFail(13240, e.getMessage());
                        }
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r7);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r7);
                }
            }
        } else {
            AnonymousClass6 r64 = new Runnable() {
                public void run() {
                    TalHttpCallBack talHttpCallBack = talHttpCallBack;
                    if (talHttpCallBack != null) {
                        talHttpCallBack.onFail(Integer.valueOf(talHttpResponse.getCode()), talHttpResponse.getResult());
                    }
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r64);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r64);
            }
        }
    }

    private void setDefaultParam(TalHttpRequestParams talHttpRequestParams) {
        talHttpRequestParams.addHeaderParam("business-code", TalTradeSdk.getInstance().getBusinessCode());
        talHttpRequestParams.addHeaderParam("env", "4");
        talHttpRequestParams.addHeaderParam("package-name", TalTradeSdk.getInstance().getPackageName());
        talHttpRequestParams.addHeaderParam("User-agent", getUa());
        talHttpRequestParams.addHeaderParam("language", TalTradeSdk.getInstance().getLanguageStr2server());
        talHttpRequestParams.addHeaderParam("ver-num", TalDeviceUtils.getVersionName(TalTradeSdk.getInstance().getApplication()) + "|" + BuildConfig.VERSION_NAME);
        signParam(talHttpRequestParams);
    }

    private void signParam(TalHttpRequestParams talHttpRequestParams) {
        try {
            StringBuilder sb = new StringBuilder();
            String str = System.currentTimeMillis() + "";
            if (talHttpRequestParams.getBodyParam() != null && !talHttpRequestParams.getBodyParam().isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (Map.Entry<String, String> key : talHttpRequestParams.getBodyParam().entrySet()) {
                    arrayList.add(key.getKey());
                }
                Collections.sort(arrayList);
                for (String str2 : arrayList) {
                    String str3 = talHttpRequestParams.getBodyParam().get(str2);
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                }
            }
            talHttpRequestParams.addHeaderParam("signature", JNISecurity.signJava(sb.toString(), str));
            talHttpRequestParams.addHeaderParam("timestamp", str);
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i(e.getMessage());
        }
    }

    private String getUa() {
        Application application = TalTradeSdk.getInstance().getApplication();
        return decodeChinese(TalDeviceUtils.getAppName(application) + "/" + TalDeviceUtils.getVersionName(application) + "(" + TalDeviceUtils.getDeviceName() + ";" + "android" + Build.VERSION.RELEASE + ";" + "TALTradeSDK" + BuildConfig.VERSION_NAME + ")");
    }

    private String decodeChinese(String str) {
        if (str.length() >= str.getBytes().length) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i(e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: private */
    public int getErrorCode(Exception exc) {
        if (!TalTradeSdk.getInstance().isNetAvailable()) {
            return TalHttpCode.ErrorCode.WEB_ERROR_NO_NET;
        }
        if (exc instanceof UnknownHostException) {
            return TalHttpCode.ErrorCode.WEB_DNS_ERROR;
        }
        if (exc instanceof ConnectException) {
            return TalHttpCode.ErrorCode.WEB_CONNECT_ERROR;
        }
        if (exc instanceof SocketException) {
            return 13213;
        }
        if (exc instanceof SocketTimeoutException) {
            return TalHttpCode.ErrorCode.WEB_TIMEOUT;
        }
        if (exc instanceof IOException) {
            return 13213;
        }
        return TalHttpCode.ErrorCode.WEB_ERROR;
    }
}
