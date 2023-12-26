package com.adyen.checkout.wechatpay;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.SavedStateHandle;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.base.BaseActionComponent;
import com.adyen.checkout.components.base.IntentHandlingComponent;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.components.model.payments.response.SdkAction;
import com.adyen.checkout.components.model.payments.response.WeChatPaySdkData;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WeChatPayActionComponent extends BaseActionComponent<WeChatPayActionConfiguration> implements IntentHandlingComponent {
    public static final ActionComponentProvider<WeChatPayActionComponent, WeChatPayActionConfiguration> PROVIDER = new WeChatPayActionComponentProvider();
    private static final String TAG = LogUtil.getTag();
    private final IWXAPI mApi;
    private final IWXAPIEventHandler mEventHandler = new IWXAPIEventHandler() {
        public void onReq(BaseReq baseReq) {
        }

        public void onResp(BaseResp baseResp) {
            if (baseResp != null) {
                WeChatPayActionComponent.this.notifyDetails(WeChatPayUtils.parseResult(baseResp));
            } else {
                WeChatPayActionComponent.this.notifyException(new ComponentException("WeChatPay SDK baseResp is null."));
            }
        }
    };

    public WeChatPayActionComponent(SavedStateHandle savedStateHandle, Application application, WeChatPayActionConfiguration weChatPayActionConfiguration) {
        super(savedStateHandle, application, weChatPayActionConfiguration);
        this.mApi = WXAPIFactory.createWXAPI(application, (String) null, true);
    }

    public void handleIntent(Intent intent) {
        this.mApi.handleIntent(intent, this.mEventHandler);
    }

    public boolean canHandleAction(Action action) {
        return PROVIDER.canHandleAction(action);
    }

    /* access modifiers changed from: protected */
    public void handleActionInternal(Activity activity, Action action) throws ComponentException {
        String str = TAG;
        Logger.d(str, "handleActionInternal: activity - " + activity.getLocalClassName());
        SdkAction sdkAction = (SdkAction) action;
        if (sdkAction.getSdkData() == null) {
            throw new ComponentException("WeChatPay Data not found.");
        } else if (!initiateWeChatPayRedirect((WeChatPaySdkData) sdkAction.getSdkData(), activity.getClass().getName())) {
            throw new ComponentException("Failed to initialize WeChat app.");
        }
    }

    private boolean initiateWeChatPayRedirect(WeChatPaySdkData weChatPaySdkData, String str) {
        Logger.d(TAG, "initiateWeChatPayRedirect");
        this.mApi.registerApp(weChatPaySdkData.getAppid());
        return this.mApi.sendReq(WeChatPayUtils.generatePayRequest(weChatPaySdkData, str));
    }
}
