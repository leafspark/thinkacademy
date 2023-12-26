package com.tal.user.global.trade.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.tal.user.global.trade.api.TalTradeApiCallBack;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradeResp;
import com.tal.user.global.trade.ums.Producer;
import com.tekartik.sqflite.Constant;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/user/global/trade/http/TalTradeCallBackImp;", "T", "Lcom/tal/user/global/trade/http/TalHttpCallBack;", "callBack", "Lcom/tal/user/global/trade/api/TalTradeApiCallBack;", "type", "", "(Lcom/tal/user/global/trade/api/TalTradeApiCallBack;I)V", "(Lcom/tal/user/global/trade/api/TalTradeApiCallBack;)V", "dataClass", "Ljava/lang/reflect/Type;", "mCallBack", "mType", "onError", "", "errCode", "", "msg", "", "onFail", "code", "onSuccess", "data", "setDataClass", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCallBackImp.kt */
public final class TalTradeCallBackImp<T> extends TalHttpCallBack {
    private Type dataClass;
    private TalTradeApiCallBack<T> mCallBack;
    private int mType;

    public TalTradeCallBackImp(TalTradeApiCallBack<T> talTradeApiCallBack, int i) {
        this.mCallBack = talTradeApiCallBack;
        this.mType = i;
    }

    public TalTradeCallBackImp(TalTradeApiCallBack<T> talTradeApiCallBack) {
        this(talTradeApiCallBack, 0);
    }

    public final TalTradeCallBackImp<?> setDataClass(Type type) {
        this.dataClass = type;
        return this;
    }

    public void onSuccess(Object obj) {
        Intrinsics.checkNotNullParameter(obj, Constant.PARAM_ERROR_DATA);
        if (this.mCallBack != null) {
            try {
                Object parseObject = JSON.parseObject(obj.toString(), this.dataClass, new Feature[0]);
                TalTradeApiCallBack<T> talTradeApiCallBack = this.mCallBack;
                if (talTradeApiCallBack != null) {
                    talTradeApiCallBack.onSuccess(parseObject);
                }
            } catch (Exception e) {
                if (Intrinsics.areEqual(this.dataClass, TalTradeResp.StringResp.class)) {
                    TalTradeApiCallBack<T> talTradeApiCallBack2 = this.mCallBack;
                    if (talTradeApiCallBack2 != null) {
                        talTradeApiCallBack2.onSuccess(new TalTradeResp.StringResp(obj.toString(), System.currentTimeMillis()));
                        return;
                    }
                    return;
                }
                TalTradeApiCallBack<T> talTradeApiCallBack3 = this.mCallBack;
                if (talTradeApiCallBack3 != null) {
                    talTradeApiCallBack3.onError(new TalTradeErrorMsg(13202, e.getMessage(), true));
                }
            }
        }
    }

    public void onError(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, "errCode");
        super.onError(obj, str);
        TalTradeApiCallBack<T> talTradeApiCallBack = this.mCallBack;
        if (talTradeApiCallBack != null) {
            if (obj instanceof Integer) {
                if (talTradeApiCallBack != null) {
                    talTradeApiCallBack.onError(new TalTradeErrorMsg(((Number) obj).intValue(), str, true));
                }
            } else if ((obj instanceof String) && talTradeApiCallBack != null) {
                talTradeApiCallBack.onError(new TalTradeErrorMsg((String) obj, str, true));
            }
        }
        try {
            Producer producer = Producer.INSTANCE;
            producer.oneSDKLog("onError", "code:" + obj + ",msg:" + str);
        } catch (Exception unused) {
        }
    }

    public void onFail(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, Constant.PARAM_ERROR_CODE);
        super.onFail(obj, str);
        TalTradeApiCallBack<T> talTradeApiCallBack = this.mCallBack;
        if (talTradeApiCallBack != null) {
            if (obj instanceof Integer) {
                if (talTradeApiCallBack != null) {
                    talTradeApiCallBack.onError(new TalTradeErrorMsg(((Number) obj).intValue(), str, true));
                }
            } else if ((obj instanceof String) && talTradeApiCallBack != null) {
                talTradeApiCallBack.onError(new TalTradeErrorMsg((String) obj, str, true));
            }
        }
        try {
            Producer producer = Producer.INSTANCE;
            producer.oneSDKLog("onFail", "code:" + obj + ",msg:" + str);
        } catch (Exception unused) {
        }
    }
}
