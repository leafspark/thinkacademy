package com.adyen.checkout.wechatpay;

import android.app.Application;
import android.content.Intent;
import com.adyen.checkout.components.model.payments.response.WeChatPaySdkData;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONException;
import org.json.JSONObject;

public final class WeChatPayUtils {
    private static final String RESULT_CODE = "resultCode";
    private static final String RESULT_EXTRA_KEY = "_wxapi_baseresp_errstr";

    public static boolean isResultIntent(Intent intent) {
        return (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey(RESULT_EXTRA_KEY)) ? false : true;
    }

    static boolean isAvailable(Application application) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(application, (String) null, true);
        boolean isWXAppInstalled = createWXAPI.isWXAppInstalled();
        boolean z = 570425345 <= createWXAPI.getWXAppSupportAPI();
        createWXAPI.detach();
        if (!isWXAppInstalled || !z) {
            return false;
        }
        return true;
    }

    static PayReq generatePayRequest(WeChatPaySdkData weChatPaySdkData, String str) {
        PayReq payReq = new PayReq();
        payReq.appId = weChatPaySdkData.getAppid();
        payReq.partnerId = weChatPaySdkData.getPartnerid();
        payReq.prepayId = weChatPaySdkData.getPrepayid();
        payReq.packageValue = weChatPaySdkData.getPackageValue();
        payReq.nonceStr = weChatPaySdkData.getNoncestr();
        payReq.timeStamp = weChatPaySdkData.getTimestamp();
        payReq.sign = weChatPaySdkData.getSign();
        payReq.options = new PayReq.Options();
        payReq.options.callbackClassName = str;
        return payReq;
    }

    static JSONObject parseResult(BaseResp baseResp) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", baseResp.errCode);
            return jSONObject;
        } catch (JSONException e) {
            throw new CheckoutException("Error parsing result.", e);
        }
    }

    private WeChatPayUtils() {
        throw new NoConstructorException();
    }
}
