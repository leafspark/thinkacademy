package com.tal.user.global.trade.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Component;
import com.adyen.checkout.card.CardComponent;
import com.adyen.checkout.card.CardListAdapter;
import com.adyen.checkout.card.CardView;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.components.ViewableComponent;
import com.adyen.checkout.components.api.ImageLoader;
import com.adyen.checkout.redirect.RedirectComponent;
import com.adyen.checkout.wechatpay.WeChatPayActionComponent;
import com.adyen.checkout.wechatpay.WeChatPayUtils;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.adapter.TalTradePayWayAdapter;
import com.tal.user.global.trade.api.ITalTradeApi;
import com.tal.user.global.trade.api.TalTradeApiFactory;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.base.TalTradeBaseAdapter;
import com.tal.user.global.trade.base.TalTradeViewHolder;
import com.tal.user.global.trade.checkout.viewmodel.TalTradeCheckoutViewModel;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.entity.TalTradeResp;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.listener.TalTradePayClickListener;
import com.tal.user.global.trade.ums.Producer;
import com.tal.user.global.trade.util.KotlinUtilsKt;
import com.tal.user.global.trade.util.TalDeviceUtils;
import com.tal.user.global.trade.util.TalTradeLanguageUtils;
import com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020/H\u0002J\b\u00107\u001a\u00020\u000eH\u0002J\u0012\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020/H\u0002J0\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020/H\u0002J\u0012\u0010G\u001a\u00020/2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\u0018\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0007H\u0016J\u001a\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010R\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020\u000eH\u0016J\b\u0010U\u001a\u00020/H\u0002J\b\u0010V\u001a\u00020/H\u0002J\b\u0010W\u001a\u00020/H\u0002J\b\u0010X\u001a\u00020/H\u0002J\u0010\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u000205H\u0002J\b\u0010[\u001a\u00020/H\u0002J\u0010\u0010[\u001a\u00020/2\u0006\u0010\\\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/tal/user/global/trade/checkout/TalAppCheckoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/tal/user/global/trade/base/TalTradeBaseAdapter$OnItemClickListener;", "()V", "binding", "Lcom/tal/user/global/trade/databinding/ActivityTalAppCheckoutBinding;", "choosePosition", "", "countLoding", "getCountLoding", "()I", "setCountLoding", "(I)V", "isSystemCancel", "", "()Z", "setSystemCancel", "(Z)V", "iscallSuccess", "getIscallSuccess", "setIscallSuccess", "listener", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "mContext", "Landroid/app/Activity;", "payWayBaseAdapter", "Lcom/tal/user/global/trade/adapter/TalTradePayWayAdapter;", "startTime", "", "startTimeOutViewTime", "supportConfig", "", "talAppAdyenCardDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "talTradePayDetailEntity", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "task", "Ljava/util/TimerTask;", "getTask", "()Ljava/util/TimerTask;", "setTask", "(Ljava/util/TimerTask;)V", "timer", "Ljava/util/Timer;", "viewModel", "Lcom/tal/user/global/trade/checkout/viewmodel/TalTradeCheckoutViewModel;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "cancelTime", "choosePayWayCodeToUms", "onePayWay", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$PayWayConfig;", "closeCheckOut", "getSupportConfig", "handleIntent", "intent", "Landroid/content/Intent;", "initData", "initDialogView", "view", "Landroid/view/View;", "cardComponent", "Lcom/adyen/checkout/card/CardComponent;", "payWayConfig", "showTextStr", "", "talTradePayClickListener", "Lcom/tal/user/global/trade/listener/TalTradePayClickListener;", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "holder", "Lcom/tal/user/global/trade/base/TalTradeViewHolder;", "position", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "onWindowFocusChanged", "hasFocus", "payOrderSuccess", "setBottomBtnResources", "setCheckBoxResources", "setCurrencySymbolText", "showCardInputView", "payWayConfigOne", "startTimeAccount", "delay", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
public final class TalAppCheckoutActivity extends AppCompatActivity implements TalTradeBaseAdapter.OnItemClickListener {
    /* access modifiers changed from: private */
    public ActivityTalAppCheckoutBinding binding;
    /* access modifiers changed from: private */
    public int choosePosition;
    private int countLoding;
    private boolean isSystemCancel;
    private boolean iscallSuccess;
    /* access modifiers changed from: private */
    public TalTradeCheckoutListener listener;
    private volatile Activity mContext;
    /* access modifiers changed from: private */
    public TalTradePayWayAdapter payWayBaseAdapter;
    private long startTime;
    /* access modifiers changed from: private */
    public long startTimeOutViewTime;
    private final Map<Integer, Integer> supportConfig = new HashMap();
    /* access modifiers changed from: private */
    public BottomSheetDialog talAppAdyenCardDialog;
    /* access modifiers changed from: private */
    public TalTradePayDetailEntity talTradePayDetailEntity;
    private TimerTask task;
    private Timer timer;
    /* access modifiers changed from: private */
    public TalTradeCheckoutViewModel viewModel;

    public void finish() {
        TalAppCheckoutActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        TalAppCheckoutActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        TalAppCheckoutActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        TalAppCheckoutActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        TalAppCheckoutActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        TalAppCheckoutActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public static final /* synthetic */ ActivityTalAppCheckoutBinding access$getBinding$p(TalAppCheckoutActivity talAppCheckoutActivity) {
        ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = talAppCheckoutActivity.binding;
        if (activityTalAppCheckoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return activityTalAppCheckoutBinding;
    }

    public static final /* synthetic */ TalTradeCheckoutViewModel access$getViewModel$p(TalAppCheckoutActivity talAppCheckoutActivity) {
        TalTradeCheckoutViewModel talTradeCheckoutViewModel = talAppCheckoutActivity.viewModel;
        if (talTradeCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return talTradeCheckoutViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        TalAppCheckoutActivity.super.onCreate(bundle);
        if (!TalTradeSdk.Companion.getInstance().isInited()) {
            ActivityInfo.endTraceActivity(getClass().getName());
            return;
        }
        ActivityTalAppCheckoutBinding inflate = ActivityTalAppCheckoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "ActivityTalAppCheckoutBi…g.inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setContentView(inflate.getRoot());
        this.mContext = (Activity) this;
        ITalTradeApi talTradeApi = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        TalTradeCheckoutListener talTradeCheckoutListener = null;
        if ((talTradeApi != null ? talTradeApi.getTalTradeCheckoutListener() : null) != null) {
            ITalTradeApi talTradeApi2 = TalTradeApiFactory.INSTANCE.getTalTradeApi();
            if (talTradeApi2 != null) {
                talTradeCheckoutListener = talTradeApi2.getTalTradeCheckoutListener();
            }
            this.listener = talTradeCheckoutListener;
        }
        TalTradeCheckoutViewModel talTradeCheckoutViewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(TalTradeCheckoutViewModel.class);
        Intrinsics.checkNotNullExpressionValue(talTradeCheckoutViewModel, "ViewModelProvider(this).…outViewModel::class.java)");
        TalTradeCheckoutViewModel talTradeCheckoutViewModel2 = talTradeCheckoutViewModel;
        this.viewModel = talTradeCheckoutViewModel2;
        if (talTradeCheckoutViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        talTradeCheckoutViewModel2.initActivity((AppCompatActivity) this);
        TalTradeCheckoutViewModel talTradeCheckoutViewModel3 = this.viewModel;
        if (talTradeCheckoutViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        TalTradePayDetailEntity talTradePayDetailEntity2 = talTradeCheckoutViewModel3.getTalTradePayDetailEntity(intent);
        this.talTradePayDetailEntity = talTradePayDetailEntity2;
        if (talTradePayDetailEntity2 == null) {
            TalTradeCheckoutListener talTradeCheckoutListener2 = this.listener;
            if (talTradeCheckoutListener2 != null) {
                talTradeCheckoutListener2.openFail(new TalTradeErrorMsg(13240, getResources().getString(R.string.tal_trade_un_support_payment), true));
            }
            closeCheckOut();
            ActivityInfo.endTraceActivity(getClass().getName());
        } else if (!getSupportConfig()) {
            TalTradeCheckoutListener talTradeCheckoutListener3 = this.listener;
            if (talTradeCheckoutListener3 != null) {
                talTradeCheckoutListener3.openFail(new TalTradeErrorMsg(13240, getResources().getString(R.string.tal_trade_un_support_payment), true));
            }
            closeCheckOut();
            ActivityInfo.endTraceActivity(getClass().getName());
        } else {
            initData();
            initView();
            ActivityInfo.endTraceActivity(getClass().getName());
        }
    }

    private final void handleIntent(Intent intent) {
        Uri data = intent != null ? intent.getData() : null;
        if (data != null) {
            String uri = data.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "data.toString()");
            if (StringsKt.startsWith$default(uri, "adyencheckout://", false, 2, (Object) null)) {
                TalTradeCheckoutViewModel talTradeCheckoutViewModel = this.viewModel;
                if (talTradeCheckoutViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                if (talTradeCheckoutViewModel.getRedirectComponent() != null) {
                    TalTradeCheckoutViewModel talTradeCheckoutViewModel2 = this.viewModel;
                    if (talTradeCheckoutViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    RedirectComponent redirectComponent = talTradeCheckoutViewModel2.getRedirectComponent();
                    if (redirectComponent != null) {
                        redirectComponent.handleIntent(intent);
                    }
                } else {
                    TalTradeCheckoutViewModel talTradeCheckoutViewModel3 = this.viewModel;
                    if (talTradeCheckoutViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    Adyen3DS2Component threedsComponent = talTradeCheckoutViewModel3.getThreedsComponent();
                    if (threedsComponent != null) {
                        threedsComponent.handleIntent(intent);
                    }
                }
                try {
                    Producer.INSTANCE.oneSDKLog("pay", "redirect_result_scheme");
                } catch (Exception unused) {
                }
            }
        }
        if (intent != null && WeChatPayUtils.isResultIntent(intent)) {
            TalTradeCheckoutViewModel talTradeCheckoutViewModel4 = this.viewModel;
            if (talTradeCheckoutViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            WeChatPayActionComponent weChatPayActionComponent = talTradeCheckoutViewModel4.getWeChatPayActionComponent();
            if (weChatPayActionComponent != null) {
                weChatPayActionComponent.handleIntent(intent);
            }
            try {
                Producer.INSTANCE.oneSDKLog("pay", "wxapi_baseresp_errstr");
            } catch (Exception unused2) {
            }
        }
    }

    private final boolean getSupportConfig() {
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig;
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig2;
        this.supportConfig.put(31, 31);
        this.supportConfig.put(33, 33);
        this.supportConfig.put(34, 34);
        this.supportConfig.put(35, 35);
        this.supportConfig.put(36, 36);
        this.supportConfig.put(40, 40);
        TalTradePayDetailEntity talTradePayDetailEntity2 = this.talTradePayDetailEntity;
        if (!(talTradePayDetailEntity2 == null || (payWayConfig2 = talTradePayDetailEntity2.getPayWayConfig()) == null || !(!payWayConfig2.isEmpty()))) {
            ArrayList arrayList = new ArrayList();
            TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
            Intrinsics.checkNotNull(talTradePayDetailEntity3);
            Iterator<TalTradePayDetailEntity.PayWayConfig> it = talTradePayDetailEntity3.getPayWayConfig().iterator();
            while (it.hasNext()) {
                TalTradePayDetailEntity.PayWayConfig next = it.next();
                if (this.supportConfig.containsKey(Integer.valueOf(next.getPayProduct()))) {
                    arrayList.add(next);
                }
            }
            TalTradePayDetailEntity talTradePayDetailEntity4 = this.talTradePayDetailEntity;
            if (talTradePayDetailEntity4 != null) {
                talTradePayDetailEntity4.setPayWayConfig(arrayList);
            }
        }
        TalTradePayDetailEntity talTradePayDetailEntity5 = this.talTradePayDetailEntity;
        if (!(talTradePayDetailEntity5 == null || (payWayConfig = talTradePayDetailEntity5.getPayWayConfig()) == null)) {
            Collection collection = payWayConfig;
            if (collection == null || collection.isEmpty()) {
                Toast.makeText((Context) this, getResources().getString(R.string.tal_trade_un_support_payment), 1).show();
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0221  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView() {
        /*
            r8 = this;
            r8.setCheckBoxResources()
            r8.setBottomBtnResources()
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            java.lang.String r1 = "binding"
            if (r0 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x000f:
            android.widget.TextView r0 = r0.tvTalTradeGotoPay
            int r2 = com.tal.user.global.trade.R.drawable.tal_trade_shape_range_24_color_primary
            r0.setBackgroundResource(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x001d:
            android.widget.TextView r0 = r0.tvTalTradeGoodsName
            java.lang.String r2 = "binding.tvTalTradeGoodsName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            r3 = 0
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r2.getGoodsName()
            goto L_0x002f
        L_0x002e:
            r2 = r3
        L_0x002f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x003b:
            android.widget.TextView r0 = r0.tvTalTradeGoodsDetail
            java.lang.String r2 = "binding.tvTalTradeGoodsDetail"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r2.getGoodsDetail()
            goto L_0x004c
        L_0x004b:
            r2 = r3
        L_0x004c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0058
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0058:
            android.widget.TextView r0 = r0.tvTalTradeGoodsCurrencySymbol
            java.lang.String r2 = "binding.tvTalTradeGoodsCurrencySymbol"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            if (r2 == 0) goto L_0x0068
            java.lang.String r2 = r2.getCurrencySymbol()
            goto L_0x0069
        L_0x0068:
            r2 = r3
        L_0x0069:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0075
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0075:
            android.widget.TextView r0 = r0.tvTalTradeGoodsTotalFee
            java.lang.String r2 = "binding.tvTalTradeGoodsTotalFee"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            if (r2 == 0) goto L_0x0085
            java.lang.String r2 = r2.getShowFee()
            goto L_0x0086
        L_0x0085:
            r2 = r3
        L_0x0086:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r0 = r8.talTradePayDetailEntity
            if (r0 == 0) goto L_0x0098
            int r0 = r0.getExpireTime()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0099
        L_0x0098:
            r0 = r3
        L_0x0099:
            if (r0 == 0) goto L_0x00f3
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r0 = r8.talTradePayDetailEntity
            if (r0 == 0) goto L_0x00a8
            int r0 = r0.getExpireTime()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00a9
        L_0x00a8:
            r0 = r3
        L_0x00a9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00f3
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00b9:
            com.tal.user.global.trade.widget.TimeCountDownTextView r0 = r0.tvTalTradeGoodsTimmer
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            if (r2 == 0) goto L_0x00c8
            int r2 = r2.getExpireTime()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x00c9
        L_0x00c8:
            r2 = r3
        L_0x00c9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.intValue()
            r0.setTimeDuration(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00da
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00da:
            com.tal.user.global.trade.widget.TimeCountDownTextView r0 = r0.tvTalTradeGoodsTimmer
            r0.startCountDow()
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00e6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00e6:
            com.tal.user.global.trade.widget.TimeCountDownTextView r0 = r0.tvTalTradeGoodsTimmer
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$1 r2 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$1
            r2.<init>(r8)
            com.tal.user.global.trade.widget.TimeCountDownTextView$TimeCountDownListener r2 = (com.tal.user.global.trade.widget.TimeCountDownTextView.TimeCountDownListener) r2
            r0.setTimeCountDowListener(r2)
            goto L_0x0106
        L_0x00f3:
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00fa:
            com.tal.user.global.trade.widget.TimeCountDownTextView r0 = r0.tvTalTradeGoodsTimmer
            java.lang.String r2 = "binding.tvTalTradeGoodsTimmer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 8
            r0.setVisibility(r2)
        L_0x0106:
            com.tal.user.global.trade.adapter.TalTradePayWayAdapter r0 = new com.tal.user.global.trade.adapter.TalTradePayWayAdapter
            com.tal.user.global.trade.entity.TalTradePayDetailEntity r2 = r8.talTradePayDetailEntity
            if (r2 == 0) goto L_0x0110
            java.util.ArrayList r3 = r2.getPayWayConfig()
        L_0x0110:
            java.util.List r3 = (java.util.List) r3
            int r2 = com.tal.user.global.trade.R.layout.adapter_tal_app_checkout_item
            r0.<init>(r3, r2)
            r8.payWayBaseAdapter = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r2 = r8
            com.tal.user.global.trade.base.TalTradeBaseAdapter$OnItemClickListener r2 = (com.tal.user.global.trade.base.TalTradeBaseAdapter.OnItemClickListener) r2
            r0.setOnItemClickListenerButton(r2)
            com.tal.user.global.trade.adapter.TalTradePayWayAdapter r0 = r8.payWayBaseAdapter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setOnItemClickListener(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0131
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0131:
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvTalTradePayWay
            java.lang.String r2 = "binding.rvTalTradePayWay"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.app.Activity r4 = r8.mContext
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r0.setLayoutManager(r3)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x014d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x014d:
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvTalTradePayWay
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.user.global.trade.adapter.TalTradePayWayAdapter r2 = r8.payWayBaseAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r0.setAdapter(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0160
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0160:
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r0 = r0.rlScTimeout
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$2 r2 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$2
            r2.<init>(r8)
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout$OnClickListener r2 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout.OnClickListener) r2
            r0.setClickListener(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0173
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0173:
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r0 = r0.rlSc
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$3 r2 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$3
            r2.<init>(r8)
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout$OnClickListener r2 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout.OnClickListener) r2
            r0.setClickListener(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0186
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0186:
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r0 = r0.rlScPaying
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$4 r2 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$4
            r2.<init>(r8)
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout$OnClickListener r2 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout.OnClickListener) r2
            r0.setClickListener(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0199
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0199:
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r0 = r0.rlScFail
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$5 r2 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$5
            r2.<init>(r8)
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout$OnClickListener r2 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout.OnClickListener) r2
            r0.setClickListener(r2)
            com.tal.user.global.trade.checkout.viewmodel.TalTradeCheckoutViewModel r0 = r8.viewModel
            if (r0 != 0) goto L_0x01ae
            java.lang.String r2 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x01ae:
            androidx.lifecycle.MutableLiveData r0 = r0.getTalTradeLoadingDialog()
            com.tal.user.global.trade.base.TalTradeLoadingDialog r2 = new com.tal.user.global.trade.base.TalTradeLoadingDialog
            android.app.Activity r3 = r8.mContext
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            r0.setValue(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x01c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01c5:
            android.widget.ImageView r0 = r0.ivTalTradeTancengCloseIcon
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r3 = 0
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$6 r0 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$6
            r0.<init>(r8)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 1
            r7 = 0
            com.tal.user.global.trade.util.KotlinUtilsKt.clickWithTrigger$default(r2, r3, r5, r6, r7)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x01e0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01e0:
            android.widget.TextView r0 = r0.tvTalTradeWebViewCloseIcon
            int r2 = com.tal.user.global.trade.R.drawable.tal_trade_shape_range_24_color_primary
            r0.setBackgroundResource(r2)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x01ee
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01ee:
            android.widget.TextView r0 = r0.tvTalTradeWebViewCloseIcon
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r3 = 0
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$7 r0 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$7
            r0.<init>(r8)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 1
            r7 = 0
            com.tal.user.global.trade.util.KotlinUtilsKt.clickWithTrigger$default(r2, r3, r5, r6, r7)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0209
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0209:
            android.widget.ImageView r0 = r0.ivTalTradeWvCloseIcon
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r3 = 0
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$8 r0 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$8
            r0.<init>(r8)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r6 = 1
            r7 = 0
            com.tal.user.global.trade.util.KotlinUtilsKt.clickWithTrigger$default(r2, r3, r5, r6, r7)
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0224
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0224:
            android.widget.TextView r0 = r0.tvTalTradeGotoPay
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            r2 = 0
            com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$9 r0 = new com.tal.user.global.trade.checkout.TalAppCheckoutActivity$initView$9
            r0.<init>(r8)
            r4 = r0
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 1
            r6 = 0
            com.tal.user.global.trade.util.KotlinUtilsKt.clickWithTrigger$default(r1, r2, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.checkout.TalAppCheckoutActivity.initView():void");
    }

    public final int getCountLoding() {
        return this.countLoding;
    }

    public final void setCountLoding(int i) {
        this.countLoding = i;
    }

    private final void initData() {
        TalTradeCheckoutListener talTradeCheckoutListener = this.listener;
        if (talTradeCheckoutListener != null) {
            talTradeCheckoutListener.openSuccess(new TalTradeResp.StringResp());
        }
        this.startTime = System.currentTimeMillis();
        TalTradeCheckoutViewModel talTradeCheckoutViewModel = this.viewModel;
        if (talTradeCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        talTradeCheckoutViewModel.getPayOrderStatus().observe(lifecycleOwner, new TalAppCheckoutActivity$initData$1(this));
        TalTradeCheckoutViewModel talTradeCheckoutViewModel2 = this.viewModel;
        if (talTradeCheckoutViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        talTradeCheckoutViewModel2.getChoosePosition().observe(lifecycleOwner, new TalAppCheckoutActivity$initData$2(this));
        TalTradeCheckoutViewModel talTradeCheckoutViewModel3 = this.viewModel;
        if (talTradeCheckoutViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        talTradeCheckoutViewModel3.getChoosePosition().setValue(0);
        TalTradeCheckoutViewModel talTradeCheckoutViewModel4 = this.viewModel;
        if (talTradeCheckoutViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        talTradeCheckoutViewModel4.getPayDataInfo().observe(lifecycleOwner, new TalAppCheckoutActivity$initData$3(this));
        handleIntent(getIntent());
    }

    public void onItemClick(TalTradeViewHolder talTradeViewHolder, int i) {
        TalTradePayWayAdapter talTradePayWayAdapter;
        Intrinsics.checkNotNullParameter(talTradeViewHolder, "holder");
        setCheckBoxResources();
        TalTradeCheckoutViewModel talTradeCheckoutViewModel = this.viewModel;
        if (talTradeCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer num = (Integer) talTradeCheckoutViewModel.getChoosePosition().getValue();
        if (num == null || i != num.intValue()) {
            TalTradeCheckoutViewModel talTradeCheckoutViewModel2 = this.viewModel;
            if (talTradeCheckoutViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Integer num2 = (Integer) talTradeCheckoutViewModel2.getChoosePosition().getValue();
            if (!(num2 == null || (talTradePayWayAdapter = this.payWayBaseAdapter) == null)) {
                Intrinsics.checkNotNull(talTradePayWayAdapter);
                talTradePayWayAdapter.notifyItemChanged(num2.intValue());
            }
            TalTradeCheckoutViewModel talTradeCheckoutViewModel3 = this.viewModel;
            if (talTradeCheckoutViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            talTradeCheckoutViewModel3.getChoosePosition().setValue(Integer.valueOf(i));
            this.choosePosition = i;
        }
    }

    /* access modifiers changed from: private */
    public final void showCardInputView(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        BottomSheetDialog bottomSheetDialog;
        if (this.talAppAdyenCardDialog == null) {
            Context context = (Context) this;
            this.talAppAdyenCardDialog = new BottomSheetDialog(context, R.style.DialogNotFullScreen);
            LayoutInflater from = LayoutInflater.from(context);
            int i = R.layout.dialog_tal_trade_adyen_card;
            View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(this…l_trade_adyen_card, null)");
            BottomSheetDialog bottomSheetDialog2 = this.talAppAdyenCardDialog;
            if (bottomSheetDialog2 != null) {
                bottomSheetDialog2.setContentView(inflate);
            }
            TalTradeCheckoutViewModel talTradeCheckoutViewModel = this.viewModel;
            if (talTradeCheckoutViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            CardComponent cardComponent = talTradeCheckoutViewModel.getCardComponent();
            Intrinsics.checkNotNull(cardComponent);
            ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = this.binding;
            if (activityTalAppCheckoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = activityTalAppCheckoutBinding.tvTalTradeGotoPay;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTalTradeGotoPay");
            initDialogView(inflate, cardComponent, payWayConfig, textView.getText().toString(), new TalAppCheckoutActivity$showCardInputView$1(this));
        }
        if (!isFinishing() && (bottomSheetDialog = this.talAppAdyenCardDialog) != null) {
            bottomSheetDialog.show();
        }
    }

    private final void initDialogView(View view, CardComponent cardComponent, TalTradePayDetailEntity.PayWayConfig payWayConfig, String str, TalTradePayClickListener talTradePayClickListener) {
        KotlinUtilsKt.clickWithTrigger$default((ImageView) view.findViewById(R.id.ivTalTradeCardCloseIcon), 0, new TalAppCheckoutActivity$initDialogView$1(this), 1, (Object) null);
        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
        CardView findViewById = view.findViewById(R.id.cardView);
        RecyclerView findViewById2 = view.findViewById(R.id.recyclerViewCardList);
        TextView textView2 = (TextView) view.findViewById(R.id.tvTalTradeGotoPay);
        Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
        textView.setText(payWayConfig.getPayProductName());
        textView2.setBackgroundResource(R.drawable.tal_trade_shape_range_24_color_primary);
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTalTradeGotoPay");
        textView2.setText(str);
        KotlinUtilsKt.clickWithTrigger$default(textView2, 0, new TalAppCheckoutActivity$initDialogView$2(talTradePayClickListener), 1, (Object) null);
        List mutableList = CollectionsKt.toMutableList(new ArrayList());
        int i = 0;
        for (Object next : payWayConfig.getBrands()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CardType byBrandName = CardType.getByBrandName((String) next);
            if (byBrandName != null) {
                mutableList.add(byBrandName);
            }
            i = i2;
        }
        LifecycleOwner lifecycleOwner = this;
        findViewById.attach((ViewableComponent) cardComponent, lifecycleOwner);
        ImageLoader.Companion companion = ImageLoader.Companion;
        Context context = (Context) lifecycleOwner;
        TalTradeCheckoutViewModel talTradeCheckoutViewModel = this.viewModel;
        if (talTradeCheckoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        RecyclerView.Adapter cardListAdapter = new CardListAdapter(companion.getInstance(context, talTradeCheckoutViewModel.getEnvironment()), mutableList);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "recyclerViewCardList");
        findViewById2.setAdapter(cardListAdapter);
    }

    public void onWindowFocusChanged(boolean z) {
        TalAppCheckoutActivity.super.onWindowFocusChanged(z);
        if (z) {
            startTimeAccount(0);
        } else {
            cancelTime();
        }
    }

    public final TimerTask getTask() {
        return this.task;
    }

    public final void setTask(TimerTask timerTask) {
        this.task = timerTask;
    }

    public final boolean isSystemCancel() {
        return this.isSystemCancel;
    }

    public final void setSystemCancel(boolean z) {
        this.isSystemCancel = z;
    }

    /* access modifiers changed from: private */
    public final void startTimeAccount() {
        startTimeAccount(5000);
    }

    /* access modifiers changed from: private */
    public final void startTimeAccount(long j) {
        if (!this.isSystemCancel) {
            if (this.timer == null) {
                this.timer = new Timer();
            }
            TimerTask timerTask = this.task;
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask talAppCheckoutActivity$startTimeAccount$1 = new TalAppCheckoutActivity$startTimeAccount$1(this);
            this.task = talAppCheckoutActivity$startTimeAccount$1;
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.schedule(talAppCheckoutActivity$startTimeAccount$1, j, 5000);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void cancelTime() {
        if (this.timer != null) {
            TimerTask timerTask = this.task;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = null;
        }
    }

    public final boolean getIscallSuccess() {
        return this.iscallSuccess;
    }

    public final void setIscallSuccess(boolean z) {
        this.iscallSuccess = z;
    }

    /* access modifiers changed from: private */
    public final void payOrderSuccess() {
        if (!this.iscallSuccess) {
            TalTradeCheckoutListener talTradeCheckoutListener = this.listener;
            if (talTradeCheckoutListener != null) {
                talTradeCheckoutListener.paySuccess(TalTradeConstant.TALTradePaymentSuccessCallbackSource.FromCheckoutPage);
            }
            this.iscallSuccess = true;
        }
        closeCheckOut();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        TalAppCheckoutActivity.super.onNewIntent(intent);
        handleIntent(intent);
    }

    /* access modifiers changed from: private */
    public final void closeCheckOut() {
        try {
            TalTradePayDetailEntity talTradePayDetailEntity2 = this.talTradePayDetailEntity;
            Integer num = null;
            if ((talTradePayDetailEntity2 != null ? Integer.valueOf(talTradePayDetailEntity2.getExpireTime()) : null) != null) {
                TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
                if (talTradePayDetailEntity3 != null) {
                    num = Integer.valueOf(talTradePayDetailEntity3.getExpireTime());
                }
                Intrinsics.checkNotNull(num);
                if (num.intValue() > 0) {
                    ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = this.binding;
                    if (activityTalAppCheckoutBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    activityTalAppCheckoutBinding.tvTalTradeGoodsTimmer.cancleCountDown();
                }
            }
            cancelTime();
            long currentTimeMillis = System.currentTimeMillis();
            Producer producer = Producer.INSTANCE;
            long j = this.startTime;
            producer.onePvLog("04_01_00_00_JRSYT", j, currentTimeMillis - j, currentTimeMillis);
        } catch (Exception unused) {
        } catch (Throwable th) {
            finish();
            throw th;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public final void choosePayWayCodeToUms(TalTradePayDetailEntity.PayWayConfig payWayConfig) {
        int payProduct = payWayConfig.getPayProduct();
        if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getCardAPPCode()) {
            Producer.INSTANCE.oneClickLog("04_01_00_00_XZKZF");
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getWechatAPPCode()) {
            Producer.INSTANCE.oneClickLog("04_01_00_00_XZWXZF");
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayAPPCode()) {
            Producer.INSTANCE.oneClickLog("04_01_00_00_XZZFBZF");
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayHKAPPCode()) {
            Producer.INSTANCE.oneClickLog("04_01_00_00_XZXGZFBZF");
        }
    }

    /* access modifiers changed from: private */
    public final void setCurrencySymbolText() {
        int i = this.choosePosition;
        TalTradePayDetailEntity talTradePayDetailEntity2 = this.talTradePayDetailEntity;
        Intrinsics.checkNotNull(talTradePayDetailEntity2);
        if (i < talTradePayDetailEntity2.getPayWayConfig().size()) {
            ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = this.binding;
            if (activityTalAppCheckoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = activityTalAppCheckoutBinding.tvTalTradeGotoPay;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTalTradeGotoPay");
            StringBuilder sb = new StringBuilder();
            TalTradePayDetailEntity talTradePayDetailEntity3 = this.talTradePayDetailEntity;
            Intrinsics.checkNotNull(talTradePayDetailEntity3);
            sb.append(talTradePayDetailEntity3.getPayWayConfig().get(this.choosePosition).getPayBtnText());
            sb.append(' ');
            TalTradePayDetailEntity talTradePayDetailEntity4 = this.talTradePayDetailEntity;
            Intrinsics.checkNotNull(talTradePayDetailEntity4);
            sb.append(talTradePayDetailEntity4.getCurrencySymbol());
            TalTradePayDetailEntity talTradePayDetailEntity5 = this.talTradePayDetailEntity;
            Intrinsics.checkNotNull(talTradePayDetailEntity5);
            sb.append(talTradePayDetailEntity5.getShowFee());
            textView.setText(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public final void setCheckBoxResources() {
        Drawable drawable = getResources().getDrawable(R.drawable.tal_trade_shape_range_10_color_primary);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        Drawable findDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.checkbox_bg);
        Objects.requireNonNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) findDrawableByLayerId).setColor(TalTradeSdk.Companion.getInstance().getPrimaryColor());
    }

    private final void setBottomBtnResources() {
        Drawable drawable = getResources().getDrawable(R.drawable.tal_trade_shape_range_24_color_primary);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(TalTradeSdk.Companion.getInstance().getPrimaryColor());
        gradientDrawable.setCornerRadius((float) TalDeviceUtils.Dp2Px(this.mContext, (float) TalTradeSdk.Companion.getInstance().getBtnRadiusDp()));
        ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = this.binding;
        if (activityTalAppCheckoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        activityTalAppCheckoutBinding.llTop.setBackgroundColor(TalTradeSdk.Companion.getInstance().getPrimaryColor());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return TalAppCheckoutActivity.super.onKeyDown(i, keyEvent);
        }
        ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding = this.binding;
        if (activityTalAppCheckoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = activityTalAppCheckoutBinding.llwxGotoPay;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llwxGotoPay");
        if (linearLayout.getVisibility() == 0) {
            ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding2 = this.binding;
            if (activityTalAppCheckoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = activityTalAppCheckoutBinding2.llwxGotoPay;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.llwxGotoPay");
            linearLayout2.setVisibility(8);
            return true;
        }
        ActivityTalAppCheckoutBinding activityTalAppCheckoutBinding3 = this.binding;
        if (activityTalAppCheckoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout = activityTalAppCheckoutBinding3.rlSc;
        Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout, "binding.rlSc");
        talTradeSecondaryConfirmationLayout.setVisibility(0);
        Producer.INSTANCE.oneClickLog("04_01_00_00_DJTC");
        return true;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        TalAppCheckoutActivity.super.attachBaseContext(TalTradeLanguageUtils.updateResources(context, TalTradeSdk.Companion.getInstance().getLanguageLocal()));
    }
}
