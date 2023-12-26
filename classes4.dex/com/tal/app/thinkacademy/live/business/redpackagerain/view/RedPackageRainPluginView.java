package com.tal.app.thinkacademy.live.business.redpackagerain.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.RedPackageRainGameLoadResult;
import com.tal.app.thinkacademy.common.entity.RedPackageRainGameRewardCoin;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.EncodeUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainBinding;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainAction;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainGameStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.dialog.RedPackageRainDialog;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.GameResUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.RedPackageRainTrackUtil;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ \u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0006\u0010,\u001a\u00020'J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020'H\u0002J\u000e\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u000fJ\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u00020'H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRedPackageRainBinding;", "context", "Landroid/content/Context;", "redPackageRainMsg", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainResBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;)V", "mDialog", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/dialog/RedPackageRainDialog;", "mHandler", "Landroid/os/Handler;", "mListener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainListener;", "mRedPackageRainGameLoadResultObserver", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameLoadResult;", "mRedPackageRainGameRewardCoinObserver", "Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameRewardCoin;", "mRunnable", "Ljava/lang/Runnable;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "getRedPackageRainMsg", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "getRedPackageRainResBean", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "", "getGameCoin", "initEvent", "initView", "initializeData", "playGame", "removeLoadGameTimeoutListener", "setLoadGameTimeoutListener", "setRedPackageRainListener", "redPackageRainListener", "showLoadFailedDialog", "unInitEvent", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainPluginView.kt */
public final class RedPackageRainPluginView extends BaseInteractBoxPluginView<LiveBusinessLayoutRedPackageRainBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    private RedPackageRainDialog mDialog;
    private Handler mHandler;
    private RedPackageRainListener mListener;
    private final Observer<RedPackageRainGameLoadResult> mRedPackageRainGameLoadResultObserver = new RedPackageRainPluginView$$ExternalSyntheticLambda2(this);
    private final Observer<RedPackageRainGameRewardCoin> mRedPackageRainGameRewardCoinObserver = new RedPackageRainPluginView$$ExternalSyntheticLambda3(this);
    private Runnable mRunnable;
    private RedPackageRainViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RedPackageRainViewModel.class);
    private WebAgent mWebAgent;
    private final RedPackageRainMsgBean redPackageRainMsg;
    private final RedPackageRainResBean redPackageRainResBean;

    public final RedPackageRainMsgBean getRedPackageRainMsg() {
        return this.redPackageRainMsg;
    }

    public final RedPackageRainResBean getRedPackageRainResBean() {
        return this.redPackageRainResBean;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPackageRainPluginView(Context context, RedPackageRainMsgBean redPackageRainMsgBean, RedPackageRainResBean redPackageRainResBean2) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.redPackageRainMsg = redPackageRainMsgBean;
        this.redPackageRainResBean = redPackageRainResBean2;
        initEvent();
        initView();
        initializeData();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mRedPackageRainGameLoadResultObserver$lambda-1  reason: not valid java name */
    public static final void m414mRedPackageRainGameLoadResultObserver$lambda1(RedPackageRainPluginView redPackageRainPluginView, RedPackageRainGameLoadResult redPackageRainGameLoadResult) {
        RedPackageRainViewModel redPackageRainViewModel;
        RedPackageRainViewModel redPackageRainViewModel2;
        Intrinsics.checkNotNullParameter(redPackageRainPluginView, "this$0");
        Tag tag = TAG;
        XesLog.i(tag, "当前时间戳：" + System.currentTimeMillis() + "，红包雨游戏加载结果（1：成功，0：失败）=" + GsonUtil.getInstance().objToJson(redPackageRainGameLoadResult));
        if (redPackageRainGameLoadResult != null) {
            Integer status = redPackageRainGameLoadResult.getStatus();
            int status2 = RedPackageRainGameStatus.GAME_STATUS_SUCCESS.getStatus();
            String str = null;
            if (status != null && status.intValue() == status2) {
                XesLog.s(tag, "红包雨游戏加载成功");
                redPackageRainPluginView.removeLoadGameTimeoutListener();
                RedPackageRainTrackUtil.INSTANCE.loadRedPackageRainSuccess();
                RedPackageRainMsgBean redPackageRainMsg2 = redPackageRainPluginView.getRedPackageRainMsg();
                if (Intrinsics.areEqual(redPackageRainMsg2 == null ? null : redPackageRainMsg2.getAction(), RedPackageRainAction.START.getValue())) {
                    RedPackageRainViewModel redPackageRainViewModel3 = redPackageRainPluginView.mViewModel;
                    if (redPackageRainViewModel3 != null) {
                        redPackageRainViewModel3.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_SUCCESS.getStatus()));
                    }
                } else {
                    RedPackageRainMsgBean redPackageRainMsg3 = redPackageRainPluginView.getRedPackageRainMsg();
                    if (redPackageRainMsg3 != null) {
                        str = redPackageRainMsg3.getAction();
                    }
                    if (Intrinsics.areEqual(str, RedPackageRainAction.PLAY.getValue()) && (redPackageRainViewModel2 = redPackageRainPluginView.mViewModel) != null) {
                        redPackageRainViewModel2.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_PLAYING.getStatus()));
                    }
                }
                RedPackageRainViewModel redPackageRainViewModel4 = redPackageRainPluginView.mViewModel;
                if (redPackageRainViewModel4 != null) {
                    redPackageRainViewModel4.sendDestroyDowngradeEvent();
                    return;
                }
                return;
            }
            Integer status3 = redPackageRainGameLoadResult.getStatus();
            int status4 = RedPackageRainGameStatus.GAME_STATUS_FAILED.getStatus();
            if (status3 != null && status3.intValue() == status4) {
                XesLog.e(tag, "红包雨游戏加载失败");
                redPackageRainPluginView.removeLoadGameTimeoutListener();
                RedPackageRainMsgBean redPackageRainMsg4 = redPackageRainPluginView.getRedPackageRainMsg();
                if (Intrinsics.areEqual(redPackageRainMsg4 == null ? null : redPackageRainMsg4.getAction(), RedPackageRainAction.START.getValue())) {
                    RedPackageRainViewModel redPackageRainViewModel5 = redPackageRainPluginView.mViewModel;
                    if (redPackageRainViewModel5 != null) {
                        redPackageRainViewModel5.sendLoadDowngradeEvent(redPackageRainPluginView.getRedPackageRainMsg(), RedPackageRainDowngradeStatus.STATUS_DEVICE_LOW_ALERT);
                    }
                } else {
                    RedPackageRainMsgBean redPackageRainMsg5 = redPackageRainPluginView.getRedPackageRainMsg();
                    if (redPackageRainMsg5 != null) {
                        str = redPackageRainMsg5.getAction();
                    }
                    if (Intrinsics.areEqual(str, RedPackageRainAction.PLAY.getValue()) && (redPackageRainViewModel = redPackageRainPluginView.mViewModel) != null) {
                        redPackageRainViewModel.sendLoadDowngradeEvent(redPackageRainPluginView.getRedPackageRainMsg(), RedPackageRainDowngradeStatus.STATUS_GET_COIN);
                    }
                }
                RedPackageRainTrackUtil.INSTANCE.loadRedPackageRainFail();
                RedPackageRainViewModel redPackageRainViewModel6 = redPackageRainPluginView.mViewModel;
                if (redPackageRainViewModel6 != null) {
                    redPackageRainViewModel6.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_FAILED.getStatus()));
                }
                RedPackageRainViewModel redPackageRainViewModel7 = redPackageRainPluginView.mViewModel;
                if (redPackageRainViewModel7 != null) {
                    redPackageRainViewModel7.sendGameEndEvent();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mRedPackageRainGameRewardCoinObserver$lambda-2  reason: not valid java name */
    public static final void m415mRedPackageRainGameRewardCoinObserver$lambda2(RedPackageRainPluginView redPackageRainPluginView, RedPackageRainGameRewardCoin redPackageRainGameRewardCoin) {
        Intrinsics.checkNotNullParameter(redPackageRainPluginView, "this$0");
        XesLog.i(TAG, Intrinsics.stringPlus("红包雨游戏挣得金币=", GsonUtil.getInstance().objToJson(redPackageRainGameRewardCoin)));
        RedPackageRainViewModel redPackageRainViewModel = redPackageRainPluginView.mViewModel;
        if (redPackageRainViewModel != null) {
            redPackageRainViewModel.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_END.getStatus()));
        }
        RedPackageRainViewModel redPackageRainViewModel2 = redPackageRainPluginView.mViewModel;
        if (redPackageRainViewModel2 != null) {
            redPackageRainViewModel2.sendGameEndEvent();
        }
        RedPackageRainViewModel redPackageRainViewModel3 = redPackageRainPluginView.mViewModel;
        String str = null;
        if (redPackageRainViewModel3 != null) {
            RedPackageRainMsgBean redPackageRainMsgBean = redPackageRainPluginView.redPackageRainMsg;
            redPackageRainViewModel3.sendCoinSettlementEvent(redPackageRainMsgBean == null ? null : redPackageRainMsgBean.getInteractId(), redPackageRainGameRewardCoin.getCoin());
        }
        RedPackageRainViewModel redPackageRainViewModel4 = redPackageRainPluginView.mViewModel;
        if (redPackageRainViewModel4 != null) {
            RedPackageRainMsgBean redPackageRainMsgBean2 = redPackageRainPluginView.redPackageRainMsg;
            if (redPackageRainMsgBean2 != null) {
                str = redPackageRainMsgBean2.getInteractId();
            }
            redPackageRainViewModel4.reportRedPackageRainCoin(str, redPackageRainGameRewardCoin.getCoin(), redPackageRainGameRewardCoin.getGrabRedbagQueue(), redPackageRainGameRewardCoin.getGrabBombQueue());
        }
    }

    public final void setRedPackageRainListener(RedPackageRainListener redPackageRainListener) {
        Intrinsics.checkNotNullParameter(redPackageRainListener, "redPackageRainListener");
        this.mListener = redPackageRainListener;
    }

    private final void initView() {
        FragmentActivity fragmentActivity = this.mContext;
        FragmentActivity fragmentActivity2 = fragmentActivity instanceof FragmentActivity ? fragmentActivity : null;
        if (fragmentActivity2 != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Tag tag = TAG;
            XesLog.i(tag, Intrinsics.stringPlus("初始化红包雨WebView开始，当前时间戳：", Long.valueOf(System.currentTimeMillis())));
            this.mWebAgent = new WebAgent(fragmentActivity2).applyConfig(new AgentConfig.Builder().setShowProgressBar(false).setShowTitle(false).build()).setWebAgentParent(this.mBinding.webParent, new ViewGroup.LayoutParams(-1, -1));
            XesLog.i(tag, "初始化红包雨WebView结束，当前时间戳：" + System.currentTimeMillis() + "，初始化耗时=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private final void initializeData() {
        RedPackageRainResBean redPackageRainResBean2;
        String str;
        boolean z;
        RedPackageRainMsgBean redPackageRainMsgBean = this.redPackageRainMsg;
        if (redPackageRainMsgBean != null && (redPackageRainResBean2 = getRedPackageRainResBean()) != null) {
            boolean z2 = true;
            if (!ServerManager.getInstance().isServerRunning() || !GameResUtil.Companion.get().checkGameResIsDownLoad(redPackageRainMsgBean.getName())) {
                str = redPackageRainResBean2.getOnlinePath();
                z = null;
            } else {
                z = true;
                str = "http://localhost:8080/" + redPackageRainMsgBean.getName() + "/index.html";
            }
            if (str != null) {
                String str2 = str + "?redbagQueue=" + EncodeUtils.urlEncode(GsonUtil.getInstance().objToJson(redPackageRainMsgBean.getRedbagQueue())) + "&bombQueue=" + EncodeUtils.urlEncode(GsonUtil.getInstance().objToJson(redPackageRainMsgBean.getBombQueue())) + "&redbagDuration=" + redPackageRainMsgBean.getRedbagDuration() + "&action=" + redPackageRainMsgBean.getAction() + "&schoolCode=" + SchoolConstants.INSTANCE.schoolCode();
                if (!TextUtils.isEmpty(redPackageRainMsgBean.getParameter())) {
                    str2 = str2 + '&' + redPackageRainMsgBean.getParameter();
                }
                XesLog.i(TAG, "当前时间戳：" + System.currentTimeMillis() + "，红包雨游戏加载地址=" + str2);
                RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
                if (redPackageRainViewModel == null || !redPackageRainViewModel.checkGameStatusIsLoading()) {
                    z2 = false;
                }
                if (z2) {
                    RedPackageRainTrackUtil.INSTANCE.reLoadRedPackageRain(str2, z);
                } else {
                    RedPackageRainTrackUtil.INSTANCE.loadRedPackageRain(str2, z);
                }
                RedPackageRainViewModel redPackageRainViewModel2 = this.mViewModel;
                if (redPackageRainViewModel2 != null) {
                    redPackageRainViewModel2.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_START_LOAD.getStatus()));
                }
                setLoadGameTimeoutListener();
                WebAgent webAgent = this.mWebAgent;
                if (webAgent != null) {
                    webAgent.loadUrl(str2);
                }
            }
        }
    }

    private final void initEvent() {
        FragmentActivity context = getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
        if (fragmentActivity != null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) fragmentActivity;
            XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_LOAD_RESULT).observe(lifecycleOwner, this.mRedPackageRainGameLoadResultObserver);
            XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_REWARD_COIN).observe(lifecycleOwner, this.mRedPackageRainGameRewardCoinObserver);
        }
    }

    private final void unInitEvent() {
        XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_LOAD_RESULT).removeObserver(this.mRedPackageRainGameLoadResultObserver);
        XesDataBus.with(DataBusKey.RED_PACKAGE_RAIN_GAME_REWARD_COIN).removeObserver(this.mRedPackageRainGameRewardCoinObserver);
    }

    public final void playGame() {
        RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
        if (redPackageRainViewModel != null) {
            redPackageRainViewModel.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_PLAYING.getStatus()));
        }
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", "{\"type\":\"redpackage_rain_play\"}");
        }
    }

    public final void getGameCoin() {
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.jsCallBack("window.clientMessageHandlers", "{\"type\":\"redpackage_rain_result\"}");
        }
    }

    private final void setLoadGameTimeoutListener() {
        Tag tag = TAG;
        XesLog.i(tag, "设置加载游戏超时监听");
        if (this.mHandler == null) {
            RedPackageRainPluginView redPackageRainPluginView = this;
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mRunnable == null) {
            RedPackageRainPluginView redPackageRainPluginView2 = this;
            this.mRunnable = new RedPackageRainPluginView$$ExternalSyntheticLambda4(this);
        }
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            int i = 5;
            RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
            if (redPackageRainViewModel != null) {
                i = redPackageRainViewModel.getTimeout();
            }
            XesLog.i(tag, "超时配置" + i + 31186);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(runnable, ((long) i) * 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setLoadGameTimeoutListener$lambda-10$lambda-9  reason: not valid java name */
    public static final void m416setLoadGameTimeoutListener$lambda10$lambda9(RedPackageRainPluginView redPackageRainPluginView) {
        RedPackageRainViewModel redPackageRainViewModel;
        Intrinsics.checkNotNullParameter(redPackageRainPluginView, "this$0");
        XesLog.e(TAG, "红包雨游戏加载超时");
        RedPackageRainMsgBean redPackageRainMsgBean = redPackageRainPluginView.redPackageRainMsg;
        String str = null;
        if (Intrinsics.areEqual(redPackageRainMsgBean == null ? null : redPackageRainMsgBean.getAction(), RedPackageRainAction.START.getValue())) {
            RedPackageRainViewModel redPackageRainViewModel2 = redPackageRainPluginView.mViewModel;
            if (redPackageRainViewModel2 != null) {
                redPackageRainViewModel2.sendLoadDowngradeEvent(redPackageRainPluginView.redPackageRainMsg, RedPackageRainDowngradeStatus.STATUS_DEVICE_LOW_ALERT);
            }
        } else {
            RedPackageRainMsgBean redPackageRainMsgBean2 = redPackageRainPluginView.redPackageRainMsg;
            if (redPackageRainMsgBean2 != null) {
                str = redPackageRainMsgBean2.getAction();
            }
            if (Intrinsics.areEqual(str, RedPackageRainAction.PLAY.getValue()) && (redPackageRainViewModel = redPackageRainPluginView.mViewModel) != null) {
                redPackageRainViewModel.sendLoadDowngradeEvent(redPackageRainPluginView.redPackageRainMsg, RedPackageRainDowngradeStatus.STATUS_GET_COIN);
            }
        }
        RedPackageRainTrackUtil.INSTANCE.loadRedPackageRainTimeout();
        RedPackageRainViewModel redPackageRainViewModel3 = redPackageRainPluginView.mViewModel;
        if (redPackageRainViewModel3 != null) {
            redPackageRainViewModel3.setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_TIME_OUT.getStatus()));
        }
        RedPackageRainViewModel redPackageRainViewModel4 = redPackageRainPluginView.mViewModel;
        if (redPackageRainViewModel4 != null) {
            redPackageRainViewModel4.sendGameEndEvent();
        }
    }

    private final void removeLoadGameTimeoutListener() {
        Handler handler;
        XesLog.i(TAG, "移除游戏加载超时监听");
        Runnable runnable = this.mRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private final void showLoadFailedDialog() {
        if (this.mDialog == null) {
            RedPackageRainPluginView redPackageRainPluginView = this;
            RedPackageRainDialog redPackageRainDialog = new RedPackageRainDialog(this.mContext);
            this.mDialog = redPackageRainDialog;
            redPackageRainDialog.setOnCancelListener(new RedPackageRainPluginView$$ExternalSyntheticLambda0(this));
            RedPackageRainDialog redPackageRainDialog2 = this.mDialog;
            if (redPackageRainDialog2 != null) {
                redPackageRainDialog2.setOnDismissListener(new RedPackageRainPluginView$$ExternalSyntheticLambda1(this));
            }
        }
        RedPackageRainDialog redPackageRainDialog3 = this.mDialog;
        if (redPackageRainDialog3 != null) {
            redPackageRainDialog3.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLoadFailedDialog$lambda-17$lambda-15  reason: not valid java name */
    public static final void m417showLoadFailedDialog$lambda17$lambda15(RedPackageRainPluginView redPackageRainPluginView, DialogInterface dialogInterface) {
        List<Integer> redbagQueue;
        int i;
        Intrinsics.checkNotNullParameter(redPackageRainPluginView, "this$0");
        XesLog.i(TAG, "加载失败弹窗消失");
        RedPackageRainMsgBean redPackageRainMsgBean = redPackageRainPluginView.redPackageRainMsg;
        if (redPackageRainMsgBean != null && (redbagQueue = redPackageRainMsgBean.getRedbagQueue()) != null) {
            int i2 = 0;
            for (Integer intValue : redbagQueue) {
                i2 += intValue.intValue();
            }
            if (i2 % 2 != 0) {
                i = (i2 / 2) + 1;
            } else if (i2 == 0) {
                i = 1;
            } else {
                i = i2 / 2;
            }
            XesLog.i(TAG, Intrinsics.stringPlus("降级方案发送金币数=", Integer.valueOf(i)));
            RedPackageRainViewModel redPackageRainViewModel = redPackageRainPluginView.mViewModel;
            if (redPackageRainViewModel != null) {
                redPackageRainViewModel.sendCoinSettlementEvent(redPackageRainPluginView.getRedPackageRainMsg().getInteractId(), Integer.valueOf(i));
            }
            RedPackageRainViewModel redPackageRainViewModel2 = redPackageRainPluginView.mViewModel;
            if (redPackageRainViewModel2 != null) {
                redPackageRainViewModel2.reportRedPackageRainCoin(redPackageRainPluginView.getRedPackageRainMsg().getInteractId(), Integer.valueOf(i), (List<Integer>) null, (List<Integer>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showLoadFailedDialog$lambda-17$lambda-16  reason: not valid java name */
    public static final void m418showLoadFailedDialog$lambda17$lambda16(RedPackageRainPluginView redPackageRainPluginView, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(redPackageRainPluginView, "this$0");
        XesLog.i(TAG, "加载失败弹窗销毁");
        redPackageRainPluginView.mDialog = null;
    }

    public final void destroy() {
        unInitEvent();
        removeLoadGameTimeoutListener();
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
        this.mHandler = null;
        this.mRunnable = null;
    }

    /* access modifiers changed from: protected */
    public LiveBusinessLayoutRedPackageRainBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessLayoutRedPackageRainBinding inflate = LiveBusinessLayoutRedPackageRainBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
