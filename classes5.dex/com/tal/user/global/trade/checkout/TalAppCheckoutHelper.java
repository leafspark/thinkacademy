package com.tal.user.global.trade.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.base.TalTradeLoadingDialog;
import com.tal.user.global.trade.config.TalTradeCode;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.http.TalTradeCallBackImp;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.ums.Producer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/user/global/trade/checkout/TalAppCheckoutHelper;", "", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "talTradeCheckoutPayReq", "Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "listener", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "(Ljava/lang/ref/WeakReference;Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;)V", "getListener", "()Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "setListener", "(Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;)V", "goToTalCheckOut", "", "openCheckout", "talTradePayDetailEntity", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutHelper.kt */
public final class TalAppCheckoutHelper {
    private TalTradeCheckoutListener listener;
    /* access modifiers changed from: private */
    public TALTradeCheckoutPayReq talTradeCheckoutPayReq;
    private WeakReference<Activity> weakActivity;

    public TalAppCheckoutHelper(WeakReference<Activity> weakReference, TALTradeCheckoutPayReq tALTradeCheckoutPayReq, TalTradeCheckoutListener talTradeCheckoutListener) {
        Intrinsics.checkNotNullParameter(weakReference, "weakActivity");
        Intrinsics.checkNotNullParameter(tALTradeCheckoutPayReq, "talTradeCheckoutPayReq");
        this.weakActivity = weakReference;
        this.talTradeCheckoutPayReq = tALTradeCheckoutPayReq;
        this.listener = talTradeCheckoutListener;
    }

    public final TalTradeCheckoutListener getListener() {
        return this.listener;
    }

    public final void setListener(TalTradeCheckoutListener talTradeCheckoutListener) {
        this.listener = talTradeCheckoutListener;
    }

    public final void goToTalCheckOut() {
        boolean z = true;
        if (!TalTradeSdk.Companion.getInstance().isInited()) {
            TalTradeCheckoutListener talTradeCheckoutListener = this.listener;
            if (talTradeCheckoutListener != null) {
                talTradeCheckoutListener.openFail(new TalTradeErrorMsg((int) TalTradeCode.ErrorCode.UNINIT, "please init first", true));
                return;
            }
            return;
        }
        if (this.weakActivity.get() != null) {
            Object obj = this.weakActivity.get();
            Intrinsics.checkNotNull(obj);
            Intrinsics.checkNotNullExpressionValue(obj, "weakActivity.get()!!");
            if (!((Activity) obj).isFinishing()) {
                TalTradeLoadingDialog talTradeLoadingDialog = new TalTradeLoadingDialog((Context) this.weakActivity.get());
                talTradeLoadingDialog.show();
                TalAppCheckoutSyncHelper.INSTANCE.postGotoCheckOutOrder(this.talTradeCheckoutPayReq, new TalTradeCallBackImp(new TalAppCheckoutHelper$goToTalCheckOut$talCallBack$1(this, talTradeLoadingDialog)).setDataClass(TalTradePayDetailEntity.class));
                CharSequence merchantOrderNo = this.talTradeCheckoutPayReq.getMerchantOrderNo();
                if (!(merchantOrderNo == null || merchantOrderNo.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    Producer.INSTANCE.setOrderNo(String.valueOf(this.talTradeCheckoutPayReq.getMerchantOrderNo()));
                }
                Producer.INSTANCE.oneSystemLog("04_00_00_01_QQXD");
                return;
            }
        }
        TalTradeCheckoutListener talTradeCheckoutListener2 = this.listener;
        if (talTradeCheckoutListener2 != null) {
            talTradeCheckoutListener2.openFail(new TalTradeErrorMsg(13240, "activity is null", true));
        }
    }

    /* access modifiers changed from: private */
    public final void openCheckout(TalTradePayDetailEntity talTradePayDetailEntity) {
        if (this.weakActivity.get() != null) {
            Object obj = this.weakActivity.get();
            Intrinsics.checkNotNull(obj);
            Intrinsics.checkNotNullExpressionValue(obj, "weakActivity.get()!!");
            if (!((Activity) obj).isFinishing()) {
                Intent intent = new Intent((Context) this.weakActivity.get(), TalAppCheckoutActivity.class);
                intent.putExtra("talTradePayDetailEntity", talTradePayDetailEntity);
                Object obj2 = this.weakActivity.get();
                Intrinsics.checkNotNull(obj2);
                ((Activity) obj2).startActivity(intent);
                return;
            }
        }
        TalTradeCheckoutListener talTradeCheckoutListener = this.listener;
        if (talTradeCheckoutListener != null) {
            talTradeCheckoutListener.openFail(new TalTradeErrorMsg(13240, "activity is null", true));
        }
    }
}
