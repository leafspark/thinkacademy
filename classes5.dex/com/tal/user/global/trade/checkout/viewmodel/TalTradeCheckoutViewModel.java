package com.tal.user.global.trade.checkout.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Component;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration;
import com.adyen.checkout.card.CardComponent;
import com.adyen.checkout.card.CardConfiguration;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.StoredPaymentComponentProvider;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.redirect.RedirectComponent;
import com.adyen.checkout.redirect.RedirectConfiguration;
import com.adyen.checkout.wechatpay.WeChatPayActionComponent;
import com.adyen.checkout.wechatpay.WeChatPayActionConfiguration;
import com.adyen.checkout.wechatpay.WeChatPayProvider;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.base.TalTradeLoadingDialog;
import com.tal.user.global.trade.checkout.TalAppCheckoutSyncHelper;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.PayInfoEntity;
import com.tal.user.global.trade.entity.PayOrderStatusQueryEntity;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.http.TalHttpRequestParams;
import com.tal.user.global.trade.http.TalTradeCallBackImp;
import com.tal.user.global.trade.util.TalTradeAES;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0010\u0010I\u001a\u0004\u0018\u0001082\u0006\u0010J\u001a\u00020KJ\u0006\u0010L\u001a\u00020FJ\u0006\u0010M\u001a\u00020FJ\u0006\u0010N\u001a\u00020FJ\u000e\u0010O\u001a\u00020F2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010P\u001a\u00020FH\u0002J\u0010\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020FH\u0002J\u0010\u0010U\u001a\u00020F2\u0006\u0010R\u001a\u00020SH\u0002J\u000e\u0010V\u001a\u00020F2\u0006\u0010R\u001a\u00020SJ\u0010\u0010W\u001a\u0004\u0018\u00010\u00042\u0006\u0010R\u001a\u00020SJ\u0010\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u0004H\u0002J\u0006\u0010Z\u001a\u00020FR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u0002040\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006["}, d2 = {"Lcom/tal/user/global/trade/checkout/viewmodel/TalTradeCheckoutViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "adyenKeyStr", "", "cardComponent", "Lcom/adyen/checkout/card/CardComponent;", "getCardComponent", "()Lcom/adyen/checkout/card/CardComponent;", "setCardComponent", "(Lcom/adyen/checkout/card/CardComponent;)V", "choosePosition", "Landroidx/lifecycle/MutableLiveData;", "", "getChoosePosition", "()Landroidx/lifecycle/MutableLiveData;", "setChoosePosition", "(Landroidx/lifecycle/MutableLiveData;)V", "isAvailable", "", "setAvailable", "isValid", "setValid", "mActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getMActivity", "setMActivity", "payDataInfo", "Lcom/tal/user/global/trade/entity/PayInfoEntity;", "getPayDataInfo", "setPayDataInfo", "payInfoEntity", "payOrderStatus", "getPayOrderStatus", "setPayOrderStatus", "paymentAlipayActionString", "paymentAlipayHKActionString", "paymentCardActionString", "paymentDetailActionStringtemp", "getPaymentDetailActionStringtemp", "()Ljava/lang/String;", "setPaymentDetailActionStringtemp", "(Ljava/lang/String;)V", "paymentGrabpayActionString", "paymentWechatActionString", "redirectComponent", "Lcom/adyen/checkout/redirect/RedirectComponent;", "getRedirectComponent", "()Lcom/adyen/checkout/redirect/RedirectComponent;", "setRedirectComponent", "(Lcom/adyen/checkout/redirect/RedirectComponent;)V", "talTradeLoadingDialog", "Lcom/tal/user/global/trade/base/TalTradeLoadingDialog;", "getTalTradeLoadingDialog", "setTalTradeLoadingDialog", "talTradePayDetailEntity", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "threedsComponent", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "getThreedsComponent", "()Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "setThreedsComponent", "(Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;)V", "weChatPayActionComponent", "Lcom/adyen/checkout/wechatpay/WeChatPayActionComponent;", "getWeChatPayActionComponent", "()Lcom/adyen/checkout/wechatpay/WeChatPayActionComponent;", "setWeChatPayActionComponent", "(Lcom/adyen/checkout/wechatpay/WeChatPayActionComponent;)V", "dismissProgressDialog", "", "getEnvironment", "Lcom/adyen/checkout/core/api/Environment;", "getTalTradePayDetailEntity", "intent", "Landroid/content/Intent;", "gotoCheckOrdePayStatus", "gotoGetPaymentDetail", "gotoGetStripePaymentDetail", "initActivity", "initAdyen3Ds", "initAdyenCard", "payWayConfigOne", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$PayWayConfig;", "initAdyenRedirect", "initAdyenWechatPay", "isWxInstall", "judgePayWay", "postPaymentDetailInfo2Server", "paymentDetailActionString", "showProgressDialog", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
public final class TalTradeCheckoutViewModel extends ViewModel {
    private String adyenKeyStr;
    private CardComponent cardComponent;
    private MutableLiveData<Integer> choosePosition = new MutableLiveData<>();
    private MutableLiveData<Boolean> isAvailable = new MutableLiveData<>();
    private MutableLiveData<Boolean> isValid = new MutableLiveData<>();
    private MutableLiveData<AppCompatActivity> mActivity = new MutableLiveData<>();
    private MutableLiveData<PayInfoEntity> payDataInfo = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public PayInfoEntity payInfoEntity;
    private MutableLiveData<Integer> payOrderStatus = new MutableLiveData<>();
    private String paymentAlipayActionString;
    private String paymentAlipayHKActionString;
    /* access modifiers changed from: private */
    public String paymentCardActionString;
    private String paymentDetailActionStringtemp = "";
    private String paymentGrabpayActionString;
    private String paymentWechatActionString;
    private RedirectComponent redirectComponent;
    private MutableLiveData<TalTradeLoadingDialog> talTradeLoadingDialog = new MutableLiveData<>();
    private TalTradePayDetailEntity talTradePayDetailEntity;
    private Adyen3DS2Component threedsComponent;
    private WeChatPayActionComponent weChatPayActionComponent;

    public final MutableLiveData<AppCompatActivity> getMActivity() {
        return this.mActivity;
    }

    public final void setMActivity(MutableLiveData<AppCompatActivity> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mActivity = mutableLiveData;
    }

    public final MutableLiveData<TalTradeLoadingDialog> getTalTradeLoadingDialog() {
        return this.talTradeLoadingDialog;
    }

    public final void setTalTradeLoadingDialog(MutableLiveData<TalTradeLoadingDialog> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.talTradeLoadingDialog = mutableLiveData;
    }

    public final RedirectComponent getRedirectComponent() {
        return this.redirectComponent;
    }

    public final void setRedirectComponent(RedirectComponent redirectComponent2) {
        this.redirectComponent = redirectComponent2;
    }

    public final WeChatPayActionComponent getWeChatPayActionComponent() {
        return this.weChatPayActionComponent;
    }

    public final void setWeChatPayActionComponent(WeChatPayActionComponent weChatPayActionComponent2) {
        this.weChatPayActionComponent = weChatPayActionComponent2;
    }

    public final CardComponent getCardComponent() {
        return this.cardComponent;
    }

    public final void setCardComponent(CardComponent cardComponent2) {
        this.cardComponent = cardComponent2;
    }

    public final Adyen3DS2Component getThreedsComponent() {
        return this.threedsComponent;
    }

    public final void setThreedsComponent(Adyen3DS2Component adyen3DS2Component) {
        this.threedsComponent = adyen3DS2Component;
    }

    public final MutableLiveData<Integer> getChoosePosition() {
        return this.choosePosition;
    }

    public final void setChoosePosition(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.choosePosition = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isAvailable() {
        return this.isAvailable;
    }

    public final void setAvailable(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isAvailable = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isValid() {
        return this.isValid;
    }

    public final void setValid(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isValid = mutableLiveData;
    }

    public final MutableLiveData<Integer> getPayOrderStatus() {
        return this.payOrderStatus;
    }

    public final void setPayOrderStatus(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payOrderStatus = mutableLiveData;
    }

    public final MutableLiveData<PayInfoEntity> getPayDataInfo() {
        return this.payDataInfo;
    }

    public final void setPayDataInfo(MutableLiveData<PayInfoEntity> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payDataInfo = mutableLiveData;
    }

    public final TalTradePayDetailEntity getTalTradePayDetailEntity(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        TalTradePayDetailEntity talTradePayDetailEntity2 = (TalTradePayDetailEntity) intent.getSerializableExtra("talTradePayDetailEntity");
        this.talTradePayDetailEntity = talTradePayDetailEntity2;
        TalTradePayDetailEntity.ExtendConfig extendConfig = null;
        if ((talTradePayDetailEntity2 != null ? talTradePayDetailEntity2.getChannelConfig() : null) != null) {
            TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
            TalTradePayDetailEntity.ExtendConfig channelConfig = talTradePayDetailEntity3 != null ? talTradePayDetailEntity3.getChannelConfig() : null;
            Intrinsics.checkNotNull(channelConfig);
            if (channelConfig.getAdyenClientKey().length() > 0) {
                TalTradePayDetailEntity talTradePayDetailEntity4 = this.talTradePayDetailEntity;
                if (talTradePayDetailEntity4 != null) {
                    extendConfig = talTradePayDetailEntity4.getChannelConfig();
                }
                Intrinsics.checkNotNull(extendConfig);
                this.adyenKeyStr = TalTradeAES.aesPasswordDecode(extendConfig.getAdyenClientKey());
                TalTradeLoggerFactory.getLogger().i(this.adyenKeyStr);
            }
        }
        return this.talTradePayDetailEntity;
    }

    public final void initActivity(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "mActivity");
        this.mActivity.setValue(appCompatActivity);
    }

    public final void gotoGetPaymentDetail() {
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig;
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig2;
        TalHttpRequestParams talHttpRequestParams = new TalHttpRequestParams();
        Integer num = (Integer) this.choosePosition.getValue();
        if (num == null) {
            num = 0;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        TalTradePayDetailEntity talTradePayDetailEntity2 = this.talTradePayDetailEntity;
        Integer num2 = null;
        talHttpRequestParams.addBodyParam("merchantOrderNo", talTradePayDetailEntity2 != null ? talTradePayDetailEntity2.getMerchantOrderNo() : null);
        Object value = this.choosePosition.getValue();
        Intrinsics.checkNotNull(value);
        int intValue = ((Number) value).intValue();
        TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
        Integer valueOf = (talTradePayDetailEntity3 == null || (payWayConfig2 = talTradePayDetailEntity3.getPayWayConfig()) == null) ? null : Integer.valueOf(payWayConfig2.size());
        Intrinsics.checkNotNull(valueOf);
        if (Intrinsics.compare(intValue, valueOf.intValue()) < 0) {
            TalTradePayDetailEntity talTradePayDetailEntity4 = this.talTradePayDetailEntity;
            TalTradePayDetailEntity.PayWayConfig payWayConfig3 = (talTradePayDetailEntity4 == null || (payWayConfig = talTradePayDetailEntity4.getPayWayConfig()) == null) ? null : payWayConfig.get(num.intValue());
            if (payWayConfig3 != null) {
                num2 = Integer.valueOf(payWayConfig3.getPayProduct());
            }
            Intrinsics.checkNotNull(num2);
            intRef.element = num2.intValue();
            talHttpRequestParams.addBodyParam("payProduct", String.valueOf(intRef.element));
            talHttpRequestParams.addBodyParam("extendParam", judgePayWay(payWayConfig3));
        }
        showProgressDialog();
        TalAppCheckoutSyncHelper.INSTANCE.postGotoPayImmediately(talHttpRequestParams, new TalTradeCallBackImp(new TalTradeCheckoutViewModel$gotoGetPaymentDetail$talCallBack$1(this, intRef)).setDataClass(PayInfoEntity.class));
    }

    public final void gotoGetStripePaymentDetail() {
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig;
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig2;
        TalHttpRequestParams talHttpRequestParams = new TalHttpRequestParams();
        Integer num = (Integer) this.choosePosition.getValue();
        if (num == null) {
            num = 0;
        }
        TalTradePayDetailEntity talTradePayDetailEntity2 = this.talTradePayDetailEntity;
        Integer num2 = null;
        talHttpRequestParams.addBodyParam("merchantOrderNo", talTradePayDetailEntity2 != null ? talTradePayDetailEntity2.getMerchantOrderNo() : null);
        Object value = this.choosePosition.getValue();
        Intrinsics.checkNotNull(value);
        int intValue = ((Number) value).intValue();
        TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
        Integer valueOf = (talTradePayDetailEntity3 == null || (payWayConfig2 = talTradePayDetailEntity3.getPayWayConfig()) == null) ? null : Integer.valueOf(payWayConfig2.size());
        Intrinsics.checkNotNull(valueOf);
        if (Intrinsics.compare(intValue, valueOf.intValue()) < 0) {
            TalTradePayDetailEntity talTradePayDetailEntity4 = this.talTradePayDetailEntity;
            TalTradePayDetailEntity.PayWayConfig payWayConfig3 = (talTradePayDetailEntity4 == null || (payWayConfig = talTradePayDetailEntity4.getPayWayConfig()) == null) ? null : payWayConfig.get(num.intValue());
            if (payWayConfig3 != null) {
                num2 = Integer.valueOf(payWayConfig3.getPayProduct());
            }
            Intrinsics.checkNotNull(num2);
            talHttpRequestParams.addBodyParam("payProduct", String.valueOf(num2.intValue()));
        }
        showProgressDialog();
        TalAppCheckoutSyncHelper.INSTANCE.postGotoPayImmediately(talHttpRequestParams, new TalTradeCallBackImp(new TalTradeCheckoutViewModel$gotoGetStripePaymentDetail$talCallBack$1(this)).setDataClass(PayInfoEntity.class));
    }

    public final void gotoCheckOrdePayStatus() {
        if (TalTradeSdk.Companion.getInstance().isNetAvailable()) {
            TalAppCheckoutSyncHelper.INSTANCE.postGotoOrderStatusQuery(this.talTradePayDetailEntity, new TalTradeCallBackImp(new TalTradeCheckoutViewModel$gotoCheckOrdePayStatus$talCallBack$1(this)).setDataClass(PayOrderStatusQueryEntity.class));
        }
    }

    public final Environment getEnvironment() {
        String str = this.adyenKeyStr;
        Intrinsics.checkNotNull(str);
        if (StringsKt.startsWith$default(str, "test", false, 2, (Object) null)) {
            Environment environment = Environment.TEST;
            Intrinsics.checkNotNullExpressionValue(environment, "Environment.TEST");
            return environment;
        }
        String str2 = this.adyenKeyStr;
        Intrinsics.checkNotNull(str2);
        if (StringsKt.startsWith$default(str2, "live", false, 2, (Object) null)) {
            Environment environment2 = Environment.LIVE;
            Intrinsics.checkNotNullExpressionValue(environment2, "Environment.LIVE");
            return environment2;
        }
        Environment environment3 = Environment.LIVE;
        Intrinsics.checkNotNullExpressionValue(environment3, "Environment.LIVE");
        return environment3;
    }

    private final void initAdyenCard(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        CharSequence charSequence = this.adyenKeyStr;
        if (!(charSequence == null || charSequence.length() == 0) && this.mActivity.getValue() != null) {
            Object value = this.mActivity.getValue();
            Intrinsics.checkNotNull(value);
            String str = this.adyenKeyStr;
            Intrinsics.checkNotNull(str);
            Configuration configuration = (CardConfiguration) new CardConfiguration.Builder((Context) value, str).setHolderNameRequired(true).setEnvironment(getEnvironment()).setShowStorePaymentField(false).setShopperLocale(TalTradeSdk.Companion.getInstance().getLanguageLocal()).build();
            PaymentMethod paymentMethod = new PaymentMethod();
            List brands = paymentMethod.getBrands();
            if (brands != null) {
                brands.addAll(payWayConfig.getBrands());
            }
            paymentMethod.setName("Credit Card");
            paymentMethod.setType(payWayConfig.getType());
            StoredPaymentComponentProvider provider = CardComponent.Companion.getPROVIDER();
            Object value2 = this.mActivity.getValue();
            Intrinsics.checkNotNull(value2);
            CardComponent cardComponent2 = provider.get((SavedStateRegistryOwner) value2, paymentMethod, configuration);
            this.cardComponent = cardComponent2;
            if (cardComponent2 != null) {
                Object value3 = this.mActivity.getValue();
                Intrinsics.checkNotNull(value3);
                cardComponent2.observe((LifecycleOwner) value3, new TalTradeCheckoutViewModel$initAdyenCard$1(this));
            }
            initAdyen3Ds();
        }
    }

    private final void initAdyenRedirect() {
        LifecycleOwner lifecycleOwner;
        CharSequence charSequence = this.adyenKeyStr;
        if (!(charSequence == null || charSequence.length() == 0) && (lifecycleOwner = (AppCompatActivity) this.mActivity.getValue()) != null) {
            String str = this.adyenKeyStr;
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "it");
            RedirectComponent redirectComponent2 = RedirectComponent.PROVIDER.get((SavedStateRegistryOwner) lifecycleOwner, lifecycleOwner.getApplication(), (RedirectConfiguration) new RedirectConfiguration.Builder((Context) lifecycleOwner, str).setEnvironment(getEnvironment()).setShopperLocale(TalTradeSdk.Companion.getInstance().getLanguageLocal()).build());
            this.redirectComponent = redirectComponent2;
            if (redirectComponent2 != null) {
                redirectComponent2.observe(lifecycleOwner, new TalTradeCheckoutViewModel$initAdyenRedirect$$inlined$let$lambda$1(this));
            }
        }
    }

    private final void initAdyenWechatPay(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        CharSequence charSequence = this.adyenKeyStr;
        if (!(charSequence == null || charSequence.length() == 0) && this.mActivity.getValue() != null) {
            isWxInstall(payWayConfig);
            Object value = this.mActivity.getValue();
            Intrinsics.checkNotNull(value);
            String str = this.adyenKeyStr;
            Intrinsics.checkNotNull(str);
            ActionComponentProvider actionComponentProvider = WeChatPayActionComponent.PROVIDER;
            Object value2 = this.mActivity.getValue();
            Intrinsics.checkNotNull(value2);
            Object value3 = this.mActivity.getValue();
            Intrinsics.checkNotNull(value3);
            Intrinsics.checkNotNullExpressionValue(value3, "mActivity.value!!");
            WeChatPayActionComponent weChatPayActionComponent2 = actionComponentProvider.get((SavedStateRegistryOwner) value2, ((AppCompatActivity) value3).getApplication(), (WeChatPayActionConfiguration) new WeChatPayActionConfiguration.Builder((Context) value, str).setEnvironment(getEnvironment()).setShopperLocale(TalTradeSdk.Companion.getInstance().getLanguageLocal()).build());
            this.weChatPayActionComponent = weChatPayActionComponent2;
            if (weChatPayActionComponent2 != null) {
                Object value4 = this.mActivity.getValue();
                Intrinsics.checkNotNull(value4);
                weChatPayActionComponent2.observe((LifecycleOwner) value4, new TalTradeCheckoutViewModel$initAdyenWechatPay$1(this));
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LinkHeader.Parameters.Type, payWayConfig.getType());
            jSONObject.put("paymentMethod", jSONObject2);
            this.paymentWechatActionString = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        }
    }

    public final void isWxInstall(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        Intrinsics.checkNotNullParameter(payWayConfig, "payWayConfigOne");
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName("WeChat Pay");
        paymentMethod.setType(payWayConfig.getType());
        WeChatPayProvider weChatPayProvider = new WeChatPayProvider();
        Object value = this.mActivity.getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "mActivity.value!!");
        Application application = ((AppCompatActivity) value).getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "mActivity.value!!.application");
        weChatPayProvider.isAvailable(application, paymentMethod, (Configuration) null, new TalTradeCheckoutViewModel$isWxInstall$1(this));
    }

    private final void initAdyen3Ds() {
        LifecycleOwner lifecycleOwner;
        CharSequence charSequence = this.adyenKeyStr;
        if (!(charSequence == null || charSequence.length() == 0) && (lifecycleOwner = (AppCompatActivity) this.mActivity.getValue()) != null) {
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "it");
            String str = this.adyenKeyStr;
            Intrinsics.checkNotNull(str);
            Adyen3DS2Component adyen3DS2Component = Adyen3DS2Component.PROVIDER.get((SavedStateRegistryOwner) lifecycleOwner, lifecycleOwner.getApplication(), (Adyen3DS2Configuration) new Adyen3DS2Configuration.Builder((Context) lifecycleOwner, str).setEnvironment(getEnvironment()).build());
            this.threedsComponent = adyen3DS2Component;
            if (adyen3DS2Component != null) {
                adyen3DS2Component.observe(lifecycleOwner, new TalTradeCheckoutViewModel$initAdyen3Ds$$inlined$let$lambda$1(this));
            }
        }
    }

    public final String getPaymentDetailActionStringtemp() {
        return this.paymentDetailActionStringtemp;
    }

    public final void setPaymentDetailActionStringtemp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paymentDetailActionStringtemp = str;
    }

    /* access modifiers changed from: private */
    public final void postPaymentDetailInfo2Server(String str) {
        PayInfoEntity payInfoEntity2;
        if (!Intrinsics.areEqual(str, this.paymentDetailActionStringtemp) && (payInfoEntity2 = this.payInfoEntity) != null) {
            TalTradeCallBackImp<?> dataClass = new TalTradeCallBackImp(new TalTradeCheckoutViewModel$postPaymentDetailInfo2Server$$inlined$let$lambda$1(this, str)).setDataClass(PayOrderStatusQueryEntity.class);
            showProgressDialog();
            TalAppCheckoutSyncHelper.INSTANCE.postPaymentDetailInfo2Adyen(this.talTradePayDetailEntity, payInfoEntity2.getPayTradeNo(), str, dataClass);
            this.paymentDetailActionStringtemp = str;
        }
    }

    public final String judgePayWay(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        Intrinsics.checkNotNullParameter(payWayConfig, "payWayConfigOne");
        int payProduct = payWayConfig.getPayProduct();
        if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getCardAPPCode()) {
            if (this.cardComponent == null) {
                initAdyenCard(payWayConfig);
            }
            return this.paymentCardActionString;
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getWechatAPPCode()) {
            if (this.weChatPayActionComponent == null) {
                initAdyenWechatPay(payWayConfig);
            }
            return this.paymentWechatActionString;
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayAPPCode()) {
            initAdyenRedirect();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LinkHeader.Parameters.Type, payWayConfig.getType());
            jSONObject.put("paymentMethod", jSONObject2);
            Object value = this.mActivity.getValue();
            Intrinsics.checkNotNull(value);
            jSONObject.put("returnUrl", RedirectComponent.getReturnUrl((Context) value));
            String jSONObject3 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            this.paymentAlipayActionString = jSONObject3;
            return jSONObject3;
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayHKAPPCode()) {
            initAdyenRedirect();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(LinkHeader.Parameters.Type, payWayConfig.getType());
            jSONObject4.put("paymentMethod", jSONObject5);
            Object value2 = this.mActivity.getValue();
            Intrinsics.checkNotNull(value2);
            jSONObject4.put("returnUrl", RedirectComponent.getReturnUrl((Context) value2));
            String jSONObject6 = !(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4);
            this.paymentAlipayHKActionString = jSONObject6;
            return jSONObject6;
        } else if (payProduct != TalTradeConstant.TalTradePayProductCode.INSTANCE.getGrabpayAPPCode()) {
            return "";
        } else {
            initAdyenRedirect();
            JSONObject jSONObject7 = new JSONObject();
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(LinkHeader.Parameters.Type, payWayConfig.getType());
            jSONObject7.put("paymentMethod", jSONObject8);
            Object value3 = this.mActivity.getValue();
            Intrinsics.checkNotNull(value3);
            jSONObject7.put("returnUrl", RedirectComponent.getReturnUrl((Context) value3));
            String jSONObject9 = !(jSONObject7 instanceof JSONObject) ? jSONObject7.toString() : JSONObjectInstrumentation.toString(jSONObject7);
            this.paymentGrabpayActionString = jSONObject9;
            return jSONObject9;
        }
    }

    public final void showProgressDialog() {
        if (this.talTradeLoadingDialog.getValue() != null) {
            Object value = this.mActivity.getValue();
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "mActivity.value!!");
            if (!((AppCompatActivity) value).isFinishing()) {
                Object value2 = this.talTradeLoadingDialog.getValue();
                Intrinsics.checkNotNull(value2);
                ((TalTradeLoadingDialog) value2).show();
            }
        }
    }

    public final void dismissProgressDialog() {
        if (this.talTradeLoadingDialog.getValue() != null) {
            Object value = this.mActivity.getValue();
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "mActivity.value!!");
            if (!((AppCompatActivity) value).isFinishing()) {
                Object value2 = this.talTradeLoadingDialog.getValue();
                Intrinsics.checkNotNull(value2);
                Intrinsics.checkNotNullExpressionValue(value2, "talTradeLoadingDialog.value!!");
                if (((TalTradeLoadingDialog) value2).isShowing()) {
                    Object value3 = this.talTradeLoadingDialog.getValue();
                    Intrinsics.checkNotNull(value3);
                    ((TalTradeLoadingDialog) value3).dismiss();
                }
            }
        }
    }
}
