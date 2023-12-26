package com.tal.app.thinkacademy.common.business.browser.helper;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.entity.OrderPayRequestBean;
import com.tal.app.thinkacademy.common.entity.OrderPlayResponseBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.pay.PayManager;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/helper/PayHelp;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivityWef", "Ljava/lang/ref/WeakReference;", "mOrderId", "", "getPayInfo", "Lcom/tal/app/thinkacademy/common/entity/OrderPlayResponseBean;", "body", "Lcom/tal/app/thinkacademy/common/entity/OrderPayRequestBean;", "(Lcom/tal/app/thinkacademy/common/entity/OrderPayRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoPayResult", "", "startRequestOrder", "orderId", "startSendPay", "orderRes", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayHelp.kt */
public final class PayHelp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PayHelp";
    private WeakReference<FragmentActivity> mActivityWef;
    private long mOrderId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/helper/PayHelp$Companion;", "", "()V", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PayHelp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PayHelp(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.mActivityWef = new WeakReference<>(fragmentActivity);
    }

    public final void startRequestOrder(long j) {
        this.mOrderId = j;
        OrderPayRequestBean orderPayRequestBean = new OrderPayRequestBean(Long.valueOf(j));
        WeakReference<FragmentActivity> weakReference = this.mActivityWef;
        FragmentActivity fragmentActivity = weakReference == null ? null : (FragmentActivity) weakReference.get();
        if (fragmentActivity != null) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) fragmentActivity), new HandlerException(new PayHelp$startRequestOrder$1()), (CoroutineStart) null, new PayHelp$startRequestOrder$2(this, orderPayRequestBean, (Continuation<? super PayHelp$startRequestOrder$2>) null), 2, (Object) null);
        } else {
            ToastUtils.showLong("activity is null", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void startSendPay(OrderPlayResponseBean orderPlayResponseBean) {
        TALTradeCheckoutPayReq tALTradeCheckoutPayReq = new TALTradeCheckoutPayReq();
        tALTradeCheckoutPayReq.setMerchantCode(orderPlayResponseBean.getMerchantCode());
        tALTradeCheckoutPayReq.setMerchantOrderNo(orderPlayResponseBean.getMerchantOrderNo());
        tALTradeCheckoutPayReq.setGoodsName(orderPlayResponseBean.getGoodsName());
        tALTradeCheckoutPayReq.setGoodsDetail(orderPlayResponseBean.getGoodsDetail());
        tALTradeCheckoutPayReq.setTotalFee(orderPlayResponseBean.getTotalFee());
        tALTradeCheckoutPayReq.setTimeOut(orderPlayResponseBean.getTimeOut());
        tALTradeCheckoutPayReq.setCurrency(orderPlayResponseBean.getCurrency());
        tALTradeCheckoutPayReq.setNotifyUrl(orderPlayResponseBean.getNotifyUrl());
        TalTradeCheckoutListener payHelp$startSendPay$talTradeCheckoutListener$1 = new PayHelp$startSendPay$talTradeCheckoutListener$1(this);
        WeakReference<FragmentActivity> weakReference = this.mActivityWef;
        FragmentActivity fragmentActivity = weakReference == null ? null : (FragmentActivity) weakReference.get();
        if (fragmentActivity != null) {
            PayManager.INSTANCE.sendCheckoutPayRequest((Activity) fragmentActivity, tALTradeCheckoutPayReq, payHelp$startSendPay$talTradeCheckoutListener$1);
        } else {
            XesLog.dt(TAG, "startSendPay activity is null");
        }
    }

    /* access modifiers changed from: private */
    public final void gotoPayResult() {
        String str;
        if (UserInfoBll.Companion.getInstance().getShoppingMallReviewed()) {
            str = UrlUtils.INSTANCE.getTouchHost();
        } else {
            str = SchoolConstants.INSTANCE.getSchoolMallTouchUrlHost(SchoolConstants.SCHOOL_MARS);
        }
        Bundle bundle = new Bundle();
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append("/app-v2/order/result/" + this.mOrderId + "?fromClientType=native");
        bundle.putString("jump_key", stringBuffer.toString());
        bundle.putSerializable("agent_config", new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:23:0x0079, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPayInfo(com.tal.app.thinkacademy.common.entity.OrderPayRequestBean r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.OrderPlayResponseBean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$getPayInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$getPayInfo$1 r0 = (com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$getPayInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$getPayInfo$1 r0 = new com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$getPayInfo$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007c
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006f
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r10 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r10 = r10.getInstance()
            boolean r10 = r10.getShoppingMallReviewed()
            if (r10 == 0) goto L_0x0051
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0053
        L_0x0051:
            java.lang.String r10 = "8601"
        L_0x0053:
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r6 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r6 = r6.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.common.network.CommonApi> r7 = com.tal.app.thinkacademy.common.network.CommonApi.class
            java.lang.Object r6 = com.tal.app.thinkacademy.lib.network.Api.create(r6, r7)
            com.tal.app.thinkacademy.common.network.CommonApi r6 = (com.tal.app.thinkacademy.common.network.CommonApi) r6
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r10 = r6.gePayInfo(r10, r9, r0)
            if (r10 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r9 = r2
        L_0x006f:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x007c
            return r1
        L_0x007c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.business.browser.helper.PayHelp.getPayInfo(com.tal.app.thinkacademy.common.entity.OrderPayRequestBean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
