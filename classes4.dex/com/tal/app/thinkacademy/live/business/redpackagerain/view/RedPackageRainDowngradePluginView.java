package com.tal.app.thinkacademy.live.business.redpackagerain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainDowngradeListener;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\tJ\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainDowngradePluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRedPackageRainDowngradeBinding;", "context", "Landroid/content/Context;", "redPackageRainMsg", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;)V", "mListener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainDowngradeListener;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "getRedPackageRainMsg", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "", "initEvent", "initListener", "initView", "initializeData", "refreshStatus", "status", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "setListener", "listener", "showDeviceLowAlertView", "showGetCoinView", "showLoadingView", "unInitEvent", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainDowngradePluginView.kt */
public final class RedPackageRainDowngradePluginView extends BaseInteractBoxPluginView<LiveBusinessLayoutRedPackageRainDowngradeBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    private RedPackageRainDowngradeListener mListener;
    private RedPackageRainViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RedPackageRainViewModel.class);
    private final RedPackageRainMsgBean redPackageRainMsg;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainDowngradePluginView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RedPackageRainDowngradeStatus.values().length];
            iArr[RedPackageRainDowngradeStatus.STATUS_LOADING.ordinal()] = 1;
            iArr[RedPackageRainDowngradeStatus.STATUS_DEVICE_LOW_ALERT.ordinal()] = 2;
            iArr[RedPackageRainDowngradeStatus.STATUS_GET_COIN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void initEvent() {
    }

    private final void unInitEvent() {
    }

    public final RedPackageRainMsgBean getRedPackageRainMsg() {
        return this.redPackageRainMsg;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPackageRainDowngradePluginView(Context context, RedPackageRainMsgBean redPackageRainMsgBean) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.redPackageRainMsg = redPackageRainMsgBean;
        initEvent();
        initView();
        initListener();
        initializeData();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainDowngradePluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainDowngradePluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setListener(RedPackageRainDowngradeListener redPackageRainDowngradeListener) {
        Intrinsics.checkNotNullParameter(redPackageRainDowngradeListener, "listener");
        this.mListener = redPackageRainDowngradeListener;
    }

    private final void initView() {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
        ConstraintLayout.LayoutParams layoutParams = null;
        if (newLp == null) {
            num4 = null;
            num3 = null;
            num2 = null;
            num = null;
        } else {
            int intValue = Integer.valueOf(newLp.height).intValue();
            if (intValue - getResources().getDimensionPixelOffset(R.dimen.size_90dp) >= getResources().getDimensionPixelOffset(R.dimen.size_222dp)) {
                num3 = Integer.valueOf(getResources().getDimensionPixelOffset(R.dimen.size_222dp));
                num2 = Integer.valueOf(getResources().getDimensionPixelOffset(R.dimen.size_240dp));
            } else {
                num3 = Integer.valueOf(intValue - getResources().getDimensionPixelOffset(R.dimen.size_90dp));
                num2 = Integer.valueOf(((intValue - getResources().getDimensionPixelOffset(R.dimen.size_90dp)) * 240) / 222);
            }
            if (intValue - getResources().getDimensionPixelOffset(R.dimen.size_50dp) >= getResources().getDimensionPixelOffset(R.dimen.size_276dp)) {
                num4 = Integer.valueOf(getResources().getDimensionPixelOffset(R.dimen.size_276dp));
                num = Integer.valueOf(getResources().getDimensionPixelOffset(R.dimen.size_371dp));
            } else {
                Integer valueOf = Integer.valueOf(intValue - getResources().getDimensionPixelOffset(R.dimen.size_50dp));
                num = Integer.valueOf(((intValue - getResources().getDimensionPixelOffset(R.dimen.size_50dp)) * 371) / 276);
                num4 = valueOf;
            }
        }
        LottieAnimationView lottieAnimationView = this.mBinding.lottieLoading;
        if (lottieAnimationView != null) {
            ConstraintLayout.LayoutParams layoutParams2 = lottieAnimationView.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams3 = layoutParams2 instanceof ConstraintLayout.LayoutParams ? layoutParams2 : null;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                if (layoutParams3 != null) {
                    layoutParams3.width = intValue2;
                }
            }
            if (num3 != null) {
                int intValue3 = num3.intValue();
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue3;
                }
            }
        }
        ConstraintLayout constraintLayout = this.mBinding.clTip;
        if (constraintLayout != null) {
            ConstraintLayout.LayoutParams layoutParams4 = constraintLayout.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams5 = layoutParams4 instanceof ConstraintLayout.LayoutParams ? layoutParams4 : null;
            if (num != null) {
                int intValue4 = num.intValue();
                if (layoutParams5 != null) {
                    layoutParams5.width = intValue4;
                }
            }
            if (num4 != null) {
                int intValue5 = num4.intValue();
                if (layoutParams5 != null) {
                    layoutParams5.height = intValue5;
                }
            }
        }
        if (num4 != null) {
            int intValue6 = num4.intValue();
            TextView textView = this.mBinding.tvDeviceLowAlert;
            if (textView != null) {
                ConstraintLayout.LayoutParams layoutParams6 = textView.getLayoutParams();
                ConstraintLayout.LayoutParams layoutParams7 = layoutParams6 instanceof ConstraintLayout.LayoutParams ? layoutParams6 : null;
                if (layoutParams7 != null) {
                    layoutParams7.height = (intValue6 * 77) / 276;
                }
                if (layoutParams7 != null) {
                    layoutParams7.width = (intValue6 * 301) / 276;
                }
                if (layoutParams7 != null) {
                    layoutParams7.topMargin = (intValue6 * 119) / 276;
                }
                textView.setTextSize(0, (((float) intValue6) * 14.0f) / ((float) 276));
            }
            TextView textView2 = this.mBinding.tvGetCoin;
            if (textView2 != null) {
                ConstraintLayout.LayoutParams layoutParams8 = textView2.getLayoutParams();
                if (layoutParams8 instanceof ConstraintLayout.LayoutParams) {
                    layoutParams = layoutParams8;
                }
                if (layoutParams != null) {
                    layoutParams.height = (intValue6 * 59) / 276;
                }
                if (layoutParams != null) {
                    layoutParams.width = (intValue6 * 159) / 276;
                }
                textView2.setPadding(textView2.getPaddingLeft(), (intValue6 * 17) / 276, textView2.getPaddingRight(), textView2.getPaddingBottom());
                textView2.setTextSize(0, (((float) intValue6) * 12.0f) / ((float) 276));
            }
        }
    }

    private final void initListener() {
        TextView textView = this.mBinding.tvGetCoin;
        if (textView != null) {
            textView.setOnClickListener(new RedPackageRainDowngradePluginView$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-12  reason: not valid java name */
    public static final void m411initListener$lambda12(RedPackageRainDowngradePluginView redPackageRainDowngradePluginView, View view) {
        List<Integer> redbagQueue;
        Intrinsics.checkNotNullParameter(redPackageRainDowngradePluginView, "this$0");
        RedPackageRainViewModel redPackageRainViewModel = redPackageRainDowngradePluginView.mViewModel;
        if (redPackageRainViewModel != null) {
            redPackageRainViewModel.sendDestroyDowngradeEvent();
        }
        RedPackageRainMsgBean redPackageRainMsgBean = redPackageRainDowngradePluginView.redPackageRainMsg;
        if (!(redPackageRainMsgBean == null || (redbagQueue = redPackageRainMsgBean.getRedbagQueue()) == null)) {
            int i = 0;
            for (Integer intValue : redbagQueue) {
                i += intValue.intValue();
            }
            double d = 0.5d;
            RedPackageRainViewModel redPackageRainViewModel2 = redPackageRainDowngradePluginView.mViewModel;
            if (redPackageRainViewModel2 != null) {
                d = redPackageRainViewModel2.getDowngradeCoinRatio();
            }
            int ceil = (int) Math.ceil(((double) i) * d);
            if (ceil <= 0) {
                ceil = 1;
            }
            XesLog.i(TAG, "总金币数=" + i + "，降级积分比率=" + d + "，降级方案发送金币数=" + ceil);
            RedPackageRainViewModel redPackageRainViewModel3 = redPackageRainDowngradePluginView.mViewModel;
            if (redPackageRainViewModel3 != null) {
                redPackageRainViewModel3.sendCoinSettlementEvent(redPackageRainDowngradePluginView.getRedPackageRainMsg().getInteractId(), Integer.valueOf(ceil));
            }
            RedPackageRainViewModel redPackageRainViewModel4 = redPackageRainDowngradePluginView.mViewModel;
            if (redPackageRainViewModel4 != null) {
                redPackageRainViewModel4.reportRedPackageRainCoin(redPackageRainDowngradePluginView.getRedPackageRainMsg().getInteractId(), Integer.valueOf(ceil), (List<Integer>) null, (List<Integer>) null);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initializeData() {
        RedPackageRainViewModel redPackageRainViewModel = this.mViewModel;
        boolean z = false;
        if (redPackageRainViewModel != null && redPackageRainViewModel.isLowDevice()) {
            z = true;
        }
        if (z) {
            TextView textView = this.mBinding.tvDeviceLowAlert;
            if (textView != null) {
                textView.setText(R.string.red_package_rain_low_device_alert);
                return;
            }
            return;
        }
        TextView textView2 = this.mBinding.tvDeviceLowAlert;
        if (textView2 != null) {
            textView2.setText(R.string.red_package_rain_low_device_alert_time_out);
        }
    }

    public final void refreshStatus(RedPackageRainDowngradeStatus redPackageRainDowngradeStatus) {
        if (redPackageRainDowngradeStatus != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[redPackageRainDowngradeStatus.ordinal()];
            if (i == 1) {
                showLoadingView();
            } else if (i == 2) {
                showDeviceLowAlertView();
            } else if (i == 3) {
                showGetCoinView();
            }
        }
    }

    private final void showLoadingView() {
        XesLog.i(TAG, "显示Loading");
        LottieAnimationView lottieAnimationView = this.mBinding.lottieLoading;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottieLoading;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setImageAssetsFolder("red_package_rain/loading/images");
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottieLoading;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setAnimation("red_package_rain/loading/jiazai.json");
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottieLoading;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.playAnimation();
        }
        ConstraintLayout constraintLayout = this.mBinding.clLoading;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.mBinding.clTip;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
    }

    private final void showDeviceLowAlertView() {
        XesLog.i(TAG, "显示设备低提醒");
        ImageView imageView = this.mBinding.ivTip;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.red_package_rain_bg_device_low_alert);
        }
        TextView textView = this.mBinding.tvGetCoin;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.mBinding.clTip;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.mBinding.clLoading;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
    }

    private final void showGetCoinView() {
        XesLog.i(TAG, "显示领金币");
        ImageView imageView = this.mBinding.ivTip;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.red_package_rain_bg_get_coin);
        }
        TextView textView = this.mBinding.tvGetCoin;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ConstraintLayout constraintLayout = this.mBinding.clTip;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.mBinding.clLoading;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
    }

    public final void destroy() {
        unInitEvent();
    }

    /* access modifiers changed from: protected */
    public LiveBusinessLayoutRedPackageRainDowngradeBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessLayoutRedPackageRainDowngradeBinding inflate = LiveBusinessLayoutRedPackageRainDowngradeBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
