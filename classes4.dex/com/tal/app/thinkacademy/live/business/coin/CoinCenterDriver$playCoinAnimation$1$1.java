package com.tal.app.thinkacademy.live.business.coin;

import android.view.View;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.view.CoinCenterNotifyView;
import kotlin.Metadata;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/tal/app/thinkacademy/live/business/coin/CoinCenterDriver$playCoinAnimation$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterDriver.kt */
public final class CoinCenterDriver$playCoinAnimation$1$1 implements PAGView.PAGViewListener {
    final /* synthetic */ int $coins;
    final /* synthetic */ CoinCenterNotifyView $notifyView;
    final /* synthetic */ CoinCenterDriver this$0;

    public void onAnimationCancel(PAGView pAGView) {
    }

    public void onAnimationRepeat(PAGView pAGView) {
    }

    public void onAnimationStart(PAGView pAGView) {
    }

    public void onAnimationUpdate(PAGView pAGView) {
    }

    CoinCenterDriver$playCoinAnimation$1$1(CoinCenterDriver coinCenterDriver, int i, CoinCenterNotifyView coinCenterNotifyView) {
        this.this$0 = coinCenterDriver;
        this.$coins = i;
        this.$notifyView = coinCenterNotifyView;
    }

    public void onAnimationEnd(PAGView pAGView) {
        XesLog.i(Tag.COIN_CENTER, "onAnimationEnd");
        this.this$0.playRollTextAnimation(this.$coins);
        this.this$0.mLiveRoomProvider.removeView((View) this.$notifyView);
    }
}
