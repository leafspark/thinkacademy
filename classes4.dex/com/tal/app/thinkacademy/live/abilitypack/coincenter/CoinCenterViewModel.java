package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.yy.mobile.rollingtextview.RollingTextView;
import com.yy.mobile.rollingtextview.strategy.Direction;
import com.yy.mobile.rollingtextview.strategy.Strategy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010>J\n\u0010?\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010@\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020\u0006H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010C\u001a\u00020+H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010\u00062\u0006\u0010C\u001a\u00020+H\u0002J\b\u0010E\u001a\u00020:H\u0014J\u001a\u0010F\u001a\u00020:2\u0006\u0010G\u001a\u00020+2\b\b\u0002\u0010H\u001a\u00020\rH\u0002J\u0015\u0010I\u001a\u00020:2\b\u0010G\u001a\u0004\u0018\u00010+¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020#H\u0002J\b\u0010M\u001a\u00020:H\u0002J\u0010\u0010N\u001a\u00020:2\u0006\u0010C\u001a\u00020+H\u0002J-\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020+2\u0016\u0010Q\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010>0R\"\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010SJ-\u0010T\u001a\u00020:2\u0006\u0010P\u001a\u00020+2\u0016\u0010Q\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150R\"\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020:H\u0002J\u0010\u0010W\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0(X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R+\u00101\u001a\u00020+2\u0006\u00100\u001a\u00020+8B@BX\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b2\u0010-\"\u0004\b3\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinCenterViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "chatNameStr", "", "coinAnimationDataLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinAnimationData;", "getCoinAnimationDataLiveData", "()Landroidx/lifecycle/LiveData;", "isRunning", "", "lastEvent", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "mCoinAnimationData", "Landroidx/lifecycle/MutableLiveData;", "mCoinImageLocation", "", "mCoinImageView", "Landroid/widget/ImageView;", "getMCoinImageView", "()Landroid/widget/ImageView;", "setMCoinImageView", "(Landroid/widget/ImageView;)V", "mCoinTextView", "Lcom/yy/mobile/rollingtextview/RollingTextView;", "getMCoinTextView", "()Lcom/yy/mobile/rollingtextview/RollingTextView;", "setMCoinTextView", "(Lcom/yy/mobile/rollingtextview/RollingTextView;)V", "mContext", "Landroid/content/Context;", "mCurrentCoinInfo", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "mMedalsDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessAllMedalsBinding;", "observerUserCoins", "Landroidx/lifecycle/Observer;", "observerUserLevel", "planId", "", "getPlanId", "()I", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "<set-?>", "soundId", "getSoundId", "setSoundId", "(I)V", "soundId$delegate", "Lkotlin/properties/ReadWriteProperty;", "userInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "bindingCoinView", "", "coinImageView", "rollingTextView", "layout", "Landroid/view/View;", "getChatName", "getCoinDataFromNet", "getIRCRoomId", "getLevelUpMessage", "level", "getMedalsTip", "onVmDestroy", "playCoinPagAndTextScrollAnimation", "coins", "isPlayPAG", "playTextScrollAnimation", "(Ljava/lang/Integer;)V", "postUserInfo", "data", "resetIsRunningAndClearLastEvent", "sendLevelUpMsg", "setIndicator", "own", "list", "", "(I[Landroid/view/View;)V", "setSelected", "(I[Landroid/widget/ImageView;)V", "showCoinAndMedalDialog", "showMedals", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterViewModel.kt */
public final class CoinCenterViewModel extends AbilityViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {(KProperty) Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoinCenterViewModel.class, "soundId", "getSoundId()I", 0))};
    private String chatNameStr;
    /* access modifiers changed from: private */
    public boolean isRunning;
    private PluginEventData lastEvent;
    private final MutableLiveData<CoinAnimationData> mCoinAnimationData = new MutableLiveData<>();
    private int[] mCoinImageLocation;
    private ImageView mCoinImageView;
    private RollingTextView mCoinTextView;
    private Context mContext;
    /* access modifiers changed from: private */
    public CoinData mCurrentCoinInfo;
    private BaseBindDialog<LiveBusinessAllMedalsBinding> mMedalsDialog;
    private Observer<PluginEventData> observerUserCoins;
    private Observer<PluginEventData> observerUserLevel;
    private final int planId;
    private final ILiveRoomProvider provider;
    private final ReadWriteProperty soundId$delegate;
    private UserInfoProxy userInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoinCenterViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        String id = getMLiveRoomProvider().getDataStorage().getPlanInfo().getId();
        Intrinsics.checkNotNullExpressionValue(id, "mLiveRoomProvider.dataStorage.planInfo.id");
        this.planId = Integer.parseInt(id);
        this.mCoinImageLocation = new int[2];
        this.soundId$delegate = Delegates.INSTANCE.notNull();
        this.observerUserCoins = new CoinCenterViewModel$$ExternalSyntheticLambda2(this);
        this.observerUserLevel = new CoinCenterViewModel$$ExternalSyntheticLambda3(this);
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        this.userInfo = iLiveRoomProvider.getDataStorage().getUserInfo();
        setSoundId(SoundPoolUtils.preLoad(this.mContext, R.raw.fly_coin_sound));
        PluginEventBus.register(AbilityPack.Companion.get().getLifecycleOwner(), DataBusKey.USERCOINS_KEY, this.observerUserCoins);
        PluginEventBus.register(AbilityPack.Companion.get().getLifecycleOwner(), DataBusKey.LEVEL_KEY, this.observerUserLevel);
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final LiveData<CoinAnimationData> getCoinAnimationDataLiveData() {
        return (LiveData) this.mCoinAnimationData;
    }

    public final int getPlanId() {
        return this.planId;
    }

    public final RollingTextView getMCoinTextView() {
        return this.mCoinTextView;
    }

    public final void setMCoinTextView(RollingTextView rollingTextView) {
        this.mCoinTextView = rollingTextView;
    }

    public final ImageView getMCoinImageView() {
        return this.mCoinImageView;
    }

    public final void setMCoinImageView(ImageView imageView) {
        this.mCoinImageView = imageView;
    }

    private final int getSoundId() {
        return ((Number) this.soundId$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    private final void setSoundId(int i) {
        this.soundId$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerUserCoins$lambda-0  reason: not valid java name */
    public static final void m137observerUserCoins$lambda0(CoinCenterViewModel coinCenterViewModel, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(coinCenterViewModel, "this$0");
        String data = pluginEventData == null ? null : pluginEventData.getData();
        CoinData coinData = coinCenterViewModel.mCurrentCoinInfo;
        if (coinData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentCoinInfo");
            coinData = null;
        }
        if (StringsKt.equals$default(data, coinData.getTotalCoin(), false, 2, (Object) null)) {
            XesLog.i(Tag.COIN_CENTER, Intrinsics.stringPlus("observerUserCoins totalCoin is same, ignore event ", pluginEventData.getmClass()));
        } else if (coinCenterViewModel.isRunning) {
            XesLog.i(Tag.COIN_CENTER, Intrinsics.stringPlus("observerUserCoins isRunning data is ", pluginEventData.getmClass()));
            coinCenterViewModel.lastEvent = pluginEventData;
        } else {
            Object object = pluginEventData.getObject();
            Objects.requireNonNull(object, "null cannot be cast to non-null type com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData");
            CoinEventData coinEventData = (CoinEventData) object;
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("source", coinEventData.getSource());
                jsonObject.addProperty("coins", pluginEventData.getData());
                XesLog.ut("CoinCenter", jsonObject);
            } catch (Exception unused) {
            }
            if (!LiveAreaCompat.isSmallPad() || !coinEventData.isPlayScrollText()) {
                XesLog.i(Tag.COIN_CENTER, Intrinsics.stringPlus("大班金币逻辑，金币数量：", pluginEventData.getData()));
                if (coinEventData.isPlayScrollText()) {
                    coinCenterViewModel.playTextScrollAnimation(Integer.valueOf(coinEventData.getAddCoinNum()));
                } else {
                    coinCenterViewModel.getCoinDataFromNet();
                }
            } else {
                XesLog.i(Tag.COIN_CENTER, Intrinsics.stringPlus("小班pad走新的金币提醒逻辑,金币数量：", pluginEventData.getData()));
                coinCenterViewModel.playCoinPagAndTextScrollAnimation(coinEventData.getAddCoinNum(), coinEventData.isPlayCoinPAG());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerUserLevel$lambda-1  reason: not valid java name */
    public static final void m138observerUserLevel$lambda1(CoinCenterViewModel coinCenterViewModel, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(coinCenterViewModel, "this$0");
        String data = pluginEventData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "pluginEventData.data");
        coinCenterViewModel.sendLevelUpMsg(Integer.parseInt(data));
    }

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
        if (this.mCoinTextView != null) {
            this.mCoinTextView = null;
        }
        if (this.mCoinImageView != null) {
            this.mCoinImageView = null;
        }
        if (this.mMedalsDialog != null) {
            this.mMedalsDialog = null;
        }
        this.mContext = null;
        PluginEventBus.unregister(DataBusKey.USERCOINS_KEY, this.observerUserCoins);
        PluginEventBus.unregister(DataBusKey.LEVEL_KEY, this.observerUserLevel);
    }

    public final void bindingCoinView(ImageView imageView, RollingTextView rollingTextView, View view) {
        Intrinsics.checkNotNullParameter(imageView, "coinImageView");
        Intrinsics.checkNotNullParameter(rollingTextView, "rollingTextView");
        this.mCoinTextView = rollingTextView;
        this.mCoinImageView = imageView;
        if (view != null) {
            view.setOnClickListener(new CoinCenterViewModel$$ExternalSyntheticLambda1(this));
        }
        getCoinDataFromNet();
    }

    /* access modifiers changed from: private */
    /* renamed from: bindingCoinView$lambda-2  reason: not valid java name */
    public static final void m136bindingCoinView$lambda2(CoinCenterViewModel coinCenterViewModel, View view) {
        Intrinsics.checkNotNullParameter(coinCenterViewModel, "this$0");
        coinCenterViewModel.showCoinAndMedalDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
        r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r0.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showCoinAndMedalDialog() {
        /*
            r5 = this;
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r0 = r5.mMedalsDialog
            if (r0 != 0) goto L_0x0045
            r0 = r5
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel r0 = (com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel) r0
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = 1138491392(0x43dc0000, float:440.0)
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r1)
            r2 = 1130168320(0x435d0000, float:221.0)
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r2)
            r0.<init>(r1, r2)
            android.content.Context r1 = r5.mContext
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel$showCoinAndMedalDialog$1$1 r2 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel$showCoinAndMedalDialog$1$1
            r2.<init>(r1)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r2.layoutParams(r0)
            r1 = 17
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r0.gravity(r1)
            r1 = 1
            r0.canceledOnTouchOutside(r1)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r2 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r2
            r5.mMedalsDialog = r2
            VB r0 = r2.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r0
            if (r0 != 0) goto L_0x0038
            goto L_0x0045
        L_0x0038:
            android.widget.ImageView r0 = r0.medalsIvClose
            if (r0 != 0) goto L_0x003d
            goto L_0x0045
        L_0x003d:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel$$ExternalSyntheticLambda0 r1 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel$$ExternalSyntheticLambda0
            r1.<init>(r5)
            r0.setOnClickListener(r1)
        L_0x0045:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r0 = r5.mMedalsDialog
            r1 = 0
            if (r0 != 0) goto L_0x004c
        L_0x004a:
            r0 = r1
            goto L_0x0055
        L_0x004c:
            VB r0 = r0.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r0
            if (r0 != 0) goto L_0x0053
            goto L_0x004a
        L_0x0053:
            android.widget.TextView r0 = r0.medalsTvCurrentCoins
        L_0x0055:
            java.lang.String r2 = "mCurrentCoinInfo"
            if (r0 != 0) goto L_0x005a
            goto L_0x0071
        L_0x005a:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData r3 = r5.mCurrentCoinInfo
            if (r3 != 0) goto L_0x0062
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r1
        L_0x0062:
            java.lang.String r3 = r3.getPlanIdCoin()
            java.lang.String r4 = "+"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0071:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r0 = r5.mMedalsDialog
            if (r0 != 0) goto L_0x0077
        L_0x0075:
            r0 = r1
            goto L_0x0080
        L_0x0077:
            VB r0 = r0.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r0
            if (r0 != 0) goto L_0x007e
            goto L_0x0075
        L_0x007e:
            android.widget.TextView r0 = r0.medalsTvTotalCoins
        L_0x0080:
            if (r0 != 0) goto L_0x0083
            goto L_0x0094
        L_0x0083:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData r3 = r5.mCurrentCoinInfo
            if (r3 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r1
        L_0x008b:
            java.lang.String r3 = r3.getTotalCoin()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0094:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r0 = r5.mMedalsDialog
            if (r0 != 0) goto L_0x009a
        L_0x0098:
            r0 = r1
            goto L_0x00a3
        L_0x009a:
            VB r0 = r0.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r0
            if (r0 != 0) goto L_0x00a1
            goto L_0x0098
        L_0x00a1:
            android.widget.TextView r0 = r0.medalsTvTip
        L_0x00a3:
            if (r0 != 0) goto L_0x00a6
            goto L_0x00c3
        L_0x00a6:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData r3 = r5.mCurrentCoinInfo
            if (r3 != 0) goto L_0x00ae
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r1
        L_0x00ae:
            java.lang.String r3 = r3.getMedalNum()
            if (r3 != 0) goto L_0x00b6
            r3 = r1
            goto L_0x00be
        L_0x00b6:
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r3 = r5.getMedalsTip(r3)
        L_0x00be:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x00c3:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData r0 = r5.mCurrentCoinInfo
            if (r0 != 0) goto L_0x00cb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00cc
        L_0x00cb:
            r1 = r0
        L_0x00cc:
            java.lang.String r0 = r1.getMedalNum()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00d6
        L_0x00d3:
            r5.showMedals(r0)
        L_0x00d6:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r0 = r5.mMedalsDialog
            if (r0 != 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r0.show()
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel.showCoinAndMedalDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showCoinAndMedalDialog$lambda-5$lambda-4  reason: not valid java name */
    public static final void m139showCoinAndMedalDialog$lambda5$lambda4(CoinCenterViewModel coinCenterViewModel, View view) {
        Intrinsics.checkNotNullParameter(coinCenterViewModel, "this$0");
        BaseBindDialog<LiveBusinessAllMedalsBinding> baseBindDialog = coinCenterViewModel.mMedalsDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final String getMedalsTip(int i) {
        String str = null;
        if (i == 0) {
            Context context = this.mContext;
            if (context == null) {
                return null;
            }
            return context.getString(R.string.answer_question_level_up_tip);
        } else if (i != 7) {
            Context context2 = this.mContext;
            if (context2 != null) {
                str = context2.getString(R.string.advance_to_level_tip);
            }
            return Intrinsics.stringPlus(str, Integer.valueOf(i + 1));
        } else {
            Context context3 = this.mContext;
            if (context3 == null) {
                return null;
            }
            return context3.getString(R.string.reached_medals_tip);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1.binding;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showMedals(java.lang.String r11) {
        /*
            r10 = this;
            int r11 = java.lang.Integer.parseInt(r11)
            r0 = 7
            android.widget.ImageView[] r0 = new android.widget.ImageView[r0]
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            r2 = 0
            if (r1 != 0) goto L_0x000e
        L_0x000c:
            r1 = r2
            goto L_0x0017
        L_0x000e:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            android.widget.ImageView r1 = r1.medalsIvMedal1
        L_0x0017:
            r3 = 0
            r0[r3] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0020
        L_0x001e:
            r1 = r2
            goto L_0x0029
        L_0x0020:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            android.widget.ImageView r1 = r1.medalsIvMedal2
        L_0x0029:
            r4 = 1
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0032
        L_0x0030:
            r1 = r2
            goto L_0x003b
        L_0x0032:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x0039
            goto L_0x0030
        L_0x0039:
            android.widget.ImageView r1 = r1.medalsIvMedal3
        L_0x003b:
            r5 = 2
            r0[r5] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0044
        L_0x0042:
            r1 = r2
            goto L_0x004d
        L_0x0044:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            android.widget.ImageView r1 = r1.medalsIvMedal4
        L_0x004d:
            r6 = 3
            r0[r6] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0056
        L_0x0054:
            r1 = r2
            goto L_0x005f
        L_0x0056:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x005d
            goto L_0x0054
        L_0x005d:
            android.widget.ImageView r1 = r1.medalsIvMedal5
        L_0x005f:
            r7 = 4
            r0[r7] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0068
        L_0x0066:
            r1 = r2
            goto L_0x0071
        L_0x0068:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x006f
            goto L_0x0066
        L_0x006f:
            android.widget.ImageView r1 = r1.medalsIvMedal6
        L_0x0071:
            r8 = 5
            r0[r8] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x007a
        L_0x0078:
            r1 = r2
            goto L_0x0083
        L_0x007a:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x0081
            goto L_0x0078
        L_0x0081:
            android.widget.ImageView r1 = r1.medalsIvMedal7
        L_0x0083:
            r9 = 6
            r0[r9] = r1
            r10.setSelected(r11, r0)
            android.view.View[] r0 = new android.view.View[r9]
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x0091
        L_0x008f:
            r1 = r2
            goto L_0x009a
        L_0x0091:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x0098
            goto L_0x008f
        L_0x0098:
            android.widget.ImageView r1 = r1.medalsIvIndicator1
        L_0x009a:
            android.view.View r1 = (android.view.View) r1
            r0[r3] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x00a4
        L_0x00a2:
            r1 = r2
            goto L_0x00ad
        L_0x00a4:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x00ab
            goto L_0x00a2
        L_0x00ab:
            android.widget.ImageView r1 = r1.medalsIvIndicator2
        L_0x00ad:
            android.view.View r1 = (android.view.View) r1
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x00b7
        L_0x00b5:
            r1 = r2
            goto L_0x00c0
        L_0x00b7:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x00be
            goto L_0x00b5
        L_0x00be:
            android.widget.ImageView r1 = r1.medalsIvIndicator3
        L_0x00c0:
            android.view.View r1 = (android.view.View) r1
            r0[r5] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x00ca
        L_0x00c8:
            r1 = r2
            goto L_0x00d3
        L_0x00ca:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x00d1
            goto L_0x00c8
        L_0x00d1:
            android.widget.ImageView r1 = r1.medalsIvIndicator4
        L_0x00d3:
            android.view.View r1 = (android.view.View) r1
            r0[r6] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x00dd
        L_0x00db:
            r1 = r2
            goto L_0x00e6
        L_0x00dd:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x00e4
            goto L_0x00db
        L_0x00e4:
            android.widget.ImageView r1 = r1.medalsIvIndicator5
        L_0x00e6:
            android.view.View r1 = (android.view.View) r1
            r0[r7] = r1
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding> r1 = r10.mMedalsDialog
            if (r1 != 0) goto L_0x00ef
            goto L_0x00f8
        L_0x00ef:
            VB r1 = r1.binding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessAllMedalsBinding) r1
            if (r1 != 0) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            android.widget.ImageView r2 = r1.medalsIvIndicator6
        L_0x00f8:
            android.view.View r2 = (android.view.View) r2
            r0[r8] = r2
            r10.setIndicator(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel.showMedals(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void sendLevelUpMsg(int i) {
        String iRCRoomId = getIRCRoomId();
        IircControllerProvider ircControllerProvider = getMLiveRoomProvider().getIrcControllerProvider();
        if (ircControllerProvider != null) {
            ircControllerProvider.sendMessage(iRCRoomId, getLevelUpMessage(i));
        }
    }

    private final String getIRCRoomId() {
        List ircRooms = getMLiveRoomProvider().getDataStorage().getEnterConfig().getIrcRooms();
        if (ircRooms.size() <= 0) {
            return "";
        }
        Object obj = ircRooms.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "ircRooms[0]");
        return (String) obj;
    }

    private final String getLevelUpMessage(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "142");
            jSONObject.put("name", getChatName());
            UserInfoProxy userInfoProxy = this.userInfo;
            String str = null;
            jSONObject.put("path", Intrinsics.stringPlus("", userInfoProxy == null ? null : userInfoProxy.getAvatar()));
            jSONObject.put("msg", "");
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            if (userInfoEntity != null) {
                str = userInfoEntity.getUid();
            }
            jSONObject.put("userId", str);
            jSONObject.put("level", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    private final String getChatName() {
        if (TextUtils.isEmpty(this.chatNameStr)) {
            UserInfoProxy userInfoProxy = this.userInfo;
            String str = null;
            if (!StringUtils.isEmpty(userInfoProxy == null ? null : userInfoProxy.getNickName())) {
                UserInfoProxy userInfoProxy2 = this.userInfo;
                if (userInfoProxy2 != null) {
                    str = userInfoProxy2.getName();
                }
            } else {
                UserInfoProxy userInfoProxy3 = this.userInfo;
                if (!StringUtils.isEmpty(userInfoProxy3 == null ? null : userInfoProxy3.getName())) {
                    UserInfoProxy userInfoProxy4 = this.userInfo;
                    if (userInfoProxy4 != null) {
                        str = userInfoProxy4.getName();
                    }
                } else {
                    UserInfoProxy userInfoProxy5 = this.userInfo;
                    if (userInfoProxy5 != null) {
                        str = userInfoProxy5.getEnglishName();
                    }
                }
            }
            this.chatNameStr = str;
        }
        return this.chatNameStr;
    }

    /* access modifiers changed from: private */
    public final void postUserInfo(CoinData coinData) {
        PluginEventBus.onEvent(DataBusKey.COURSE_USERCOINS_KEY, PluginEventData.obtainData(getClass(), "fromFunction", coinData.getPlanIdCoin()));
        PluginEventBus.onEvent(DataBusKey.UPDATE_COINS, PluginEventData.obtainData(getClass(), "fromFunction", coinData.getTotalCoin()));
    }

    static /* synthetic */ void playCoinPagAndTextScrollAnimation$default(CoinCenterViewModel coinCenterViewModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        coinCenterViewModel.playCoinPagAndTextScrollAnimation(i, z);
    }

    private final void playCoinPagAndTextScrollAnimation(int i, boolean z) {
        ImageView imageView = this.mCoinImageView;
        if (imageView != null) {
            imageView.getLocationInWindow(this.mCoinImageLocation);
        }
        XesLog.i(Tag.COIN_CENTER, "mCoinTextViewLocationX = " + this.mCoinImageLocation[0] + ", mCoinTextViewLocationY = " + this.mCoinImageLocation[1]);
        this.isRunning = true;
        if (z) {
            this.mCoinAnimationData.postValue(new CoinAnimationData(i, true, this.mCoinImageLocation));
        } else {
            this.mCoinAnimationData.postValue(new CoinAnimationData(i, false, this.mCoinImageLocation));
        }
    }

    /* access modifiers changed from: private */
    public final void getCoinDataFromNet() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new CoinCenterViewModel$getCoinDataFromNet$1()), (CoroutineStart) null, new CoinCenterViewModel$getCoinDataFromNet$2(new CoinCenterRepository(), this, (Continuation<? super CoinCenterViewModel$getCoinDataFromNet$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void resetIsRunningAndClearLastEvent() {
        this.isRunning = false;
        PluginEventData pluginEventData = this.lastEvent;
        if (pluginEventData != null) {
            String data = pluginEventData == null ? null : pluginEventData.getData();
            CoinData coinData = this.mCurrentCoinInfo;
            if (coinData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentCoinInfo");
                coinData = null;
            }
            if (!StringsKt.equals$default(data, coinData.getTotalCoin(), false, 2, (Object) null)) {
                XesLog.i(Tag.COIN_CENTER, "totalCoin is not equals,execute getCoinDataFromNet");
                getCoinDataFromNet();
                this.lastEvent = null;
            }
        }
        XesLog.i(Tag.COIN_CENTER, "totalCoin is equals,not execute getCoinDataFromNet");
        this.lastEvent = null;
    }

    public final void playTextScrollAnimation(Integer num) {
        if (num != null) {
            try {
                num.intValue();
                RollingTextView mCoinTextView2 = getMCoinTextView();
                if (mCoinTextView2 != null) {
                    String obj = mCoinTextView2.getText().toString();
                    XesLog.i(Tag.COIN_CENTER, "playTextScrollAnimation totalNum = " + num + ", goldNum = " + obj);
                    if (!TextUtils.isEmpty(obj)) {
                        num = Integer.valueOf(num.intValue() + Integer.parseInt(obj));
                    }
                    mCoinTextView2.setAnimationDuration(1000);
                    mCoinTextView2.setCharStrategy(Strategy.SameDirectionAnimation(Direction.SCROLL_UP));
                    mCoinTextView2.addCharOrder("0123456789");
                    mCoinTextView2.setAnimationInterpolator(new AccelerateDecelerateInterpolator());
                    mCoinTextView2.setText(num.toString());
                    SoundPoolUtils.play(getSoundId(), 0);
                    mCoinTextView2.addAnimatorListener(new CoinCenterViewModel$playTextScrollAnimation$1$1$1(this));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final void setSelected(int i, ImageView... imageViewArr) {
        int length = imageViewArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            ImageView imageView = imageViewArr[i2];
            int i4 = i3 + 1;
            if (imageView != null) {
                imageView.setSelected(i3 < i);
            }
            i2++;
            i3 = i4;
        }
    }

    private final void setIndicator(int i, View... viewArr) {
        int length = viewArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            View view = viewArr[i2];
            int i4 = i3 + 1;
            CoinCenterViewModel coinCenterViewModel = this;
            if (i == 0 || i == 7) {
                if (view != null) {
                    view.setVisibility(8);
                }
            } else if (i3 == i - 1) {
                if (view != null) {
                    view.setVisibility(0);
                }
            } else if (view != null) {
                view.setVisibility(8);
            }
            i2++;
            i3 = i4;
        }
    }
}
