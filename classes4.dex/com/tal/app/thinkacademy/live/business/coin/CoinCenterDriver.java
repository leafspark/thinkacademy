package com.tal.app.thinkacademy.live.business.coin;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinAnimationData;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.view.CoinCenterNotifyView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/coin/CoinCenterDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinCenterViewModel;", "onDestroy", "", "onMessage", "ircTypeKey", "", "message", "playCoinAnimation", "data", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinAnimationData;", "playRollTextAnimation", "coins", "", "resetLocation", "pagView", "Lorg/libpag/PAGView;", "location", "", "width", "height", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "金币中心", deviceType = 1, launchType = "enter", liveType = 0, moduleId = "-114")
@ViewLevels({@ViewLevel(level = 140, name = "CoinCenterNotifyView")})
/* compiled from: CoinCenterDriver.kt */
public final class CoinCenterDriver extends BaseLivePluginDriver {
    private Context mContext;
    private CoinCenterViewModel mViewModel;

    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoinCenterDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        LiveData<CoinAnimationData> coinAnimationDataLiveData;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        CoinCenterViewModel coinCenterViewModel = CoinCenterViewModelKt.getCoinCenterViewModel(AbilityPackKt.getAbilityPack());
        this.mViewModel = coinCenterViewModel;
        if (coinCenterViewModel != null && (coinAnimationDataLiveData = coinCenterViewModel.getCoinAnimationDataLiveData()) != null) {
            coinAnimationDataLiveData.observe((LifecycleOwner) this, new CoinCenterDriver$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m191_init_$lambda0(CoinCenterDriver coinCenterDriver, CoinAnimationData coinAnimationData) {
        Intrinsics.checkNotNullParameter(coinCenterDriver, "this$0");
        if (coinAnimationData.isShowToast()) {
            Intrinsics.checkNotNullExpressionValue(coinAnimationData, "it");
            coinCenterDriver.playCoinAnimation(coinAnimationData);
            return;
        }
        coinCenterDriver.playRollTextAnimation(coinAnimationData.getCoins());
    }

    private final void playCoinAnimation(CoinAnimationData coinAnimationData) {
        int[] location = coinAnimationData.getLocation();
        int coins = coinAnimationData.getCoins();
        Context context = this.mContext;
        if (context != null) {
            BaseLivePluginView coinCenterNotifyView = new CoinCenterNotifyView(context);
            PAGView animationView = coinCenterNotifyView.getAnimationView();
            PAGComposition Load = PAGFile.Load(context.getAssets(), "coin_center/fly_coin_new.pag");
            int dp2px = SizeUtils.dp2px((float) Load.width());
            int dp2px2 = SizeUtils.dp2px((float) Load.height());
            animationView.setComposition(Load);
            resetLocation(animationView, location, dp2px, dp2px2);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, coinCenterNotifyView, "CoinCenterNotifyView", LiveAreaContext.get().getScreenLp().newLp());
            animationView.addListener(new CoinCenterDriver$playCoinAnimation$1$1(this, coins, coinCenterNotifyView));
            animationView.play();
        }
    }

    public final void playRollTextAnimation(int i) {
        CoinCenterViewModel coinCenterViewModel = this.mViewModel;
        if (coinCenterViewModel != null) {
            coinCenterViewModel.playTextScrollAnimation(Integer.valueOf(i));
        }
    }

    private final void resetLocation(PAGView pAGView, int[] iArr, int i, int i2) {
        XesLog.i(Tag.COIN_CENTER, "resetLocation location[0] = " + iArr[0] + " location[1] = " + iArr[1]);
        XesLog.i(Tag.COIN_CENTER, "resetLocation width = " + i + " height = " + i2);
        pAGView.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        pAGView.setX(((float) iArr[0]) - ((float) (((double) i) * 0.7d)));
        pAGView.setY(0.0f);
    }
}
