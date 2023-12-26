package com.tal.app.thinkacademy.live.business.redpackagerain;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.listenbody.RedPackageRainListenerBody;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainCoinSettlementListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainCoinSettlementPluginView;
import com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView;
import com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainPluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@PluginAnnotation(desc = "红包雨插件", ircType = {"red_packet_rain"}, moduleId = "3011")
@ViewLevels({@ViewLevel(level = 30, name = "RedPackageRainPluginView"), @ViewLevel(level = 31, name = "RedPackageRainDowngradePluginView"), @ViewLevel(level = 30, name = "RedPackageRainCoinSettlementPluginView")})
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J!\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u0010&\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\u001c\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u001fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/RedPackageRainPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainListener;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainCoinSettlementListener;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mInterId", "", "mRedPackageRainCoinSettlementPluginView", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainCoinSettlementPluginView;", "mRedPackageRainDowngradePluginView", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainDowngradePluginView;", "mRedPackageRainPluginView", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainPluginView;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "destroyCoinSettlementView", "", "destroyDowngradeView", "destroyView", "loadCoinSettlementView", "interactId", "coin", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "loadDowngradeView", "redPackageRainMsg", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainDowngradeStatus", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "loadView", "redPackageRainResBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "observeListener", "onCoinSettlementAnimationEnd", "onDestroy", "onMessage", "ircTypeKey", "message", "updateUserCoins", "userCoins", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainPluginDriver.kt */
public final class RedPackageRainPluginDriver extends BaseLivePluginDriver implements RedPackageRainListener, RedPackageRainCoinSettlementListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    public static final String TARGET = "RedPackageRainPluginDriver.Observer";
    private Context mContext;
    private String mInterId;
    private RedPackageRainCoinSettlementPluginView mRedPackageRainCoinSettlementPluginView;
    private RedPackageRainDowngradePluginView mRedPackageRainDowngradePluginView;
    private RedPackageRainPluginView mRedPackageRainPluginView;
    private RedPackageRainViewModel mViewModel;
    private final Observer<RedPackageRainListenerBody> observer = new RedPackageRainPluginDriver$$ExternalSyntheticLambda0(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPackageRainPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        XesLog.i(TAG, "红包雨插件激活");
        this.mContext = (Context) this.mLiveRoomProvider.getWeakRefContext().get();
        this.mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RedPackageRainViewModel.class);
        observeListener();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/RedPackageRainPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observer$lambda-2  reason: not valid java name */
    public static final void m405observer$lambda2(RedPackageRainPluginDriver redPackageRainPluginDriver, RedPackageRainListenerBody redPackageRainListenerBody) {
        RedPackageRainDowngradeStatus redPackageRainDowngradeStatus;
        Intrinsics.checkNotNullParameter(redPackageRainPluginDriver, "this$0");
        if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.LoadGameMessage) {
            redPackageRainPluginDriver.destroyView();
            redPackageRainPluginDriver.destroyCoinSettlementView();
            RedPackageRainListenerBody.LoadGameMessage loadGameMessage = (RedPackageRainListenerBody.LoadGameMessage) redPackageRainListenerBody;
            redPackageRainPluginDriver.loadView(loadGameMessage.getRedPackageRainMsgBean(), loadGameMessage.getRedPackageRainResBean());
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.PlayGameMessage) {
            RedPackageRainPluginView redPackageRainPluginView = redPackageRainPluginDriver.mRedPackageRainPluginView;
            if (redPackageRainPluginView != null) {
                redPackageRainPluginView.playGame();
            }
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.GetGameCoinMessage) {
            RedPackageRainPluginView redPackageRainPluginView2 = redPackageRainPluginDriver.mRedPackageRainPluginView;
            if (redPackageRainPluginView2 != null) {
                redPackageRainPluginView2.getGameCoin();
            }
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.GameEndMessage) {
            redPackageRainPluginDriver.destroyView();
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.CoinSettlementMessage) {
            RedPackageRainListenerBody.CoinSettlementMessage coinSettlementMessage = (RedPackageRainListenerBody.CoinSettlementMessage) redPackageRainListenerBody;
            redPackageRainPluginDriver.loadCoinSettlementView(coinSettlementMessage.getInteractId(), coinSettlementMessage.getCoin());
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.LoadDowngradeMessage) {
            RedPackageRainListenerBody.LoadDowngradeMessage loadDowngradeMessage = (RedPackageRainListenerBody.LoadDowngradeMessage) redPackageRainListenerBody;
            RedPackageRainMsgBean redPackageRainMsgBean = loadDowngradeMessage.getRedPackageRainMsgBean();
            if (redPackageRainMsgBean != null && (redPackageRainDowngradeStatus = loadDowngradeMessage.getRedPackageRainDowngradeStatus()) != null) {
                redPackageRainPluginDriver.loadDowngradeView(redPackageRainMsgBean, redPackageRainDowngradeStatus);
            }
        } else if (redPackageRainListenerBody instanceof RedPackageRainListenerBody.DestroyDowngradeMessage) {
            redPackageRainPluginDriver.destroyDowngradeView();
        }
    }

    private final void observeListener() {
        ListenerData<RedPackageRainListenerBody> mListenerBody;
        RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
        if (!(redPackageRainViewModel == null || (mListenerBody = redPackageRainViewModel.getMListenerBody()) == null)) {
            mListenerBody.observeForever(this.observer);
        }
        LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new RedPackageRainPluginDriver$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeListener$lambda-6  reason: not valid java name */
    public static final void m404observeListener$lambda6(RedPackageRainPluginDriver redPackageRainPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(redPackageRainPluginDriver, "this$0");
        RedPackageRainPluginView redPackageRainPluginView = redPackageRainPluginDriver.mRedPackageRainPluginView;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = redPackageRainPluginView == null ? null : redPackageRainPluginView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams3);
            RedPackageRainPluginView redPackageRainPluginView2 = redPackageRainPluginDriver.mRedPackageRainPluginView;
            if (redPackageRainPluginView2 != null) {
                redPackageRainPluginView2.setLayoutParams(layoutParams3);
            }
        }
        RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView = redPackageRainPluginDriver.mRedPackageRainCoinSettlementPluginView;
        ViewGroup.LayoutParams layoutParams4 = redPackageRainCoinSettlementPluginView == null ? null : redPackageRainCoinSettlementPluginView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams5 = layoutParams4 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams4 : null;
        if (layoutParams5 != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams5);
            RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView2 = redPackageRainPluginDriver.mRedPackageRainCoinSettlementPluginView;
            if (redPackageRainCoinSettlementPluginView2 != null) {
                redPackageRainCoinSettlementPluginView2.setLayoutParams(layoutParams5);
            }
        }
        RedPackageRainDowngradePluginView redPackageRainDowngradePluginView = redPackageRainPluginDriver.mRedPackageRainDowngradePluginView;
        ViewGroup.LayoutParams layoutParams6 = redPackageRainDowngradePluginView == null ? null : redPackageRainDowngradePluginView.getLayoutParams();
        if (layoutParams6 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams6;
        }
        if (layoutParams != null) {
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            RedPackageRainDowngradePluginView redPackageRainDowngradePluginView2 = redPackageRainPluginDriver.mRedPackageRainDowngradePluginView;
            if (redPackageRainDowngradePluginView2 != null) {
                redPackageRainDowngradePluginView2.setLayoutParams(layoutParams);
            }
        }
    }

    public void onMessage(String str, String str2) {
        if (Intrinsics.areEqual(str, "red_packet_rain")) {
            if (str2 != null) {
                try {
                    new JSONObject(str2).optJSONObject("data");
                } catch (Exception unused) {
                }
            }
            RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
            if (redPackageRainViewModel != null) {
                redPackageRainViewModel.onReceiveRedPackageRainMessage(str2, false);
            }
        }
    }

    private final void loadView(RedPackageRainMsgBean redPackageRainMsgBean, RedPackageRainResBean redPackageRainResBean) {
        Context context = this.mContext;
        if (context != null) {
            RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
            if (redPackageRainViewModel != null) {
                redPackageRainViewModel.reportExposure(redPackageRainMsgBean == null ? null : redPackageRainMsgBean.getInteractId());
            }
            RedPackageRainPluginView redPackageRainPluginView = new RedPackageRainPluginView(context, redPackageRainMsgBean, redPackageRainResBean);
            this.mRedPackageRainPluginView = redPackageRainPluginView;
            redPackageRainPluginView.setRedPackageRainListener(this);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mRedPackageRainPluginView, "RedPackageRainPluginView", LiveAreaContext.get().getPptLp().newLp());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadDowngradeView(com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean r5, com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus r6) {
        /*
            r4 = this;
            com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView r0 = r4.mRedPackageRainDowngradePluginView
            if (r0 != 0) goto L_0x002f
            r0 = r4
            com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver r0 = (com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver) r0
            android.content.Context r1 = r0.mContext
            if (r1 != 0) goto L_0x000c
            goto L_0x002f
        L_0x000c:
            com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView r2 = new com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView
            r2.<init>(r1, r5)
            r0.mRedPackageRainDowngradePluginView = r2
            com.tal.app.thinkacademy.live.core.layout.LiveAreaContext r5 = com.tal.app.thinkacademy.live.core.layout.LiveAreaContext.get()
            com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams r5 = r5.getPptLp()
            android.widget.FrameLayout$LayoutParams r5 = r5.newLp()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r0.mLiveRoomProvider
            r2 = r0
            com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r2 = (com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver) r2
            com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView r0 = r0.mRedPackageRainDowngradePluginView
            com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView r0 = (com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView) r0
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            java.lang.String r3 = "RedPackageRainDowngradePluginView"
            r1.addView(r2, r0, r3, r5)
        L_0x002f:
            com.tal.app.thinkacademy.live.business.redpackagerain.view.RedPackageRainDowngradePluginView r5 = r4.mRedPackageRainDowngradePluginView
            if (r5 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r5.refreshStatus(r6)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver.loadDowngradeView(com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean, com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus):void");
    }

    private final void destroyDowngradeView() {
        RedPackageRainDowngradePluginView redPackageRainDowngradePluginView = this.mRedPackageRainDowngradePluginView;
        if (redPackageRainDowngradePluginView != null) {
            XesLog.i(TAG, "红包雨降级View销毁");
            redPackageRainDowngradePluginView.destroy();
            this.mLiveRoomProvider.removeView((View) redPackageRainDowngradePluginView);
            this.mRedPackageRainDowngradePluginView = null;
        }
    }

    private final void loadCoinSettlementView(String str, Integer num) {
        Context context = this.mContext;
        if (context != null && num != null) {
            Number number = num;
            number.intValue();
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            if (str == null) {
                str = "";
            }
            hWEventTracking.ostaIaCoinshower(str, number);
            RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView = new RedPackageRainCoinSettlementPluginView(context, num.intValue());
            this.mRedPackageRainCoinSettlementPluginView = redPackageRainCoinSettlementPluginView;
            redPackageRainCoinSettlementPluginView.setListener(this);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mRedPackageRainCoinSettlementPluginView, "RedPackageRainCoinSettlementPluginView", LiveAreaContext.get().getPptLp().newLp());
        }
    }

    private final void destroyCoinSettlementView() {
        RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView = this.mRedPackageRainCoinSettlementPluginView;
        if (redPackageRainCoinSettlementPluginView != null) {
            XesLog.i(TAG, "红包雨金币结算View销毁");
            redPackageRainCoinSettlementPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) redPackageRainCoinSettlementPluginView);
            this.mRedPackageRainCoinSettlementPluginView = null;
        }
    }

    private final void destroyView() {
        RedPackageRainPluginView redPackageRainPluginView = this.mRedPackageRainPluginView;
        if (redPackageRainPluginView != null) {
            XesLog.i(TAG, "红包雨View销毁");
            redPackageRainPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) redPackageRainPluginView);
            this.mRedPackageRainPluginView = null;
        }
    }

    public void onDestroy() {
        ListenerData<RedPackageRainListenerBody> mListenerBody;
        XesLog.i(TAG, "红包雨插件销毁");
        destroyView();
        destroyCoinSettlementView();
        RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
        if (!(redPackageRainViewModel == null || (mListenerBody = redPackageRainViewModel.getMListenerBody()) == null)) {
            mListenerBody.removeObserver(this.observer);
        }
        LiveAreaContext.get().layoutObserver.removeObservers((LifecycleOwner) this);
    }

    public void onCoinSettlementAnimationEnd() {
        destroyCoinSettlementView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r0 = r0.getUserInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateUserCoins(int r14) {
        /*
            r13 = this;
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r13.mLiveRoomProvider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            r1 = 0
            if (r0 != 0) goto L_0x000b
        L_0x0009:
            r0 = r1
            goto L_0x001a
        L_0x000b:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r0.getUserInfo()
            if (r0 != 0) goto L_0x0012
            goto L_0x0009
        L_0x0012:
            int r0 = r0.getGoldNum()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x001a:
            if (r0 != 0) goto L_0x001e
            r0 = r14
            goto L_0x0028
        L_0x001e:
            java.lang.Number r0 = (java.lang.Number) r0
            r0.intValue()
            int r0 = r0.intValue()
            int r0 = r0 + r14
        L_0x0028:
            com.tal.app.thinkacademy.live.core.plugin.PluginEventData r2 = new com.tal.app.thinkacademy.live.core.plugin.PluginEventData
            java.lang.Class<com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver> r3 = com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver.class
            java.lang.String r4 = java.lang.String.valueOf(r0)
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData r12 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            java.lang.String r6 = "红包雨"
            r5 = r12
            r7 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11)
            java.lang.String r14 = "usercoins_key"
            r2.<init>(r3, r14, r4, r12)
            com.tal.app.thinkacademy.live.core.plugin.PluginEventBus.onEvent(r14, r2)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r14 = r13.mLiveRoomProvider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r14 = r14.getDataStorage()
            if (r14 != 0) goto L_0x004f
            goto L_0x0053
        L_0x004f:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r1 = r14.getUserInfo()
        L_0x0053:
            if (r1 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            r1.setGoldNum(r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver.updateUserCoins(int):void");
    }
}
