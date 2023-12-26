package com.tal.app.thinkacademy.live.business.collectivespeech.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0014J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/collectivespeech/view/CollectiveSpeechView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessCollectiveSpeechBinding;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isHaveMicPermission", "", "isSpeak", "volume", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "goneEncourage", "", "goneResult", "initData", "initViews", "loadView", "onDestroy", "removePlugin", "reset", "showResult", "isHadSentIt", "updateVolume", "whetherToSpeak", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectiveSpeechView.kt */
public final class CollectiveSpeechView extends BaseVBLivePluginView<LiveBusinessCollectiveSpeechBinding> {
    private boolean isHaveMicPermission;
    private boolean isSpeak;
    private int volume;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectiveSpeechView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CollectiveSpeechView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectiveSpeechView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectiveSpeechView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessCollectiveSpeechBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessCollectiveSpeechBinding inflate = LiveBusinessCollectiveSpeechBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void initViews() {
        CollectiveSpeechView.super.initViews();
        if (PadUtils.isPad(Utils.getApp())) {
            RelativeLayout relativeLayout = this.mBinding.rlSpeechMic;
            ViewGroup.LayoutParams layoutParams = relativeLayout == null ? null : relativeLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.getMarginStart(), 0, 0, SizeUtils.dp2px(81.0f));
        }
    }

    public void initData() {
        CollectiveSpeechView.super.initData();
        RoundLinearLayout roundLinearLayout = this.mBinding.llSpeechSettings;
        if (roundLinearLayout != null) {
            roundLinearLayout.setOnClickListener(CollectiveSpeechView$$ExternalSyntheticLambda0.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m193initData$lambda1(View view) {
        PermissionUtils.launchAppDetailsSettings();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void loadView(boolean z) {
        this.isHaveMicPermission = z;
        if (z) {
            RoundLinearLayout roundLinearLayout = this.mBinding.llSpeechSettings;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView = this.mBinding.ivLottieSpeechMic;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            ImageView imageView = this.mBinding.ivSpeechMic;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView2 = this.mBinding.ivLottieSpeechMic;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setIgnoreDisabledSystemAnimations(true);
            }
            LottieAnimationView lottieAnimationView3 = this.mBinding.ivLottieSpeechMic;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.playAnimation();
                return;
            }
            return;
        }
        RoundLinearLayout roundLinearLayout2 = this.mBinding.llSpeechSettings;
        if (roundLinearLayout2 != null) {
            roundLinearLayout2.setVisibility(0);
        }
        ImageView imageView2 = this.mBinding.ivSpeechMic;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.cancelAnimation();
        }
        ImageView imageView3 = this.mBinding.ivSpeechMic;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_speech_microphone_no_permission);
        }
    }

    public final void whetherToSpeak(boolean z) {
        if (z) {
            ImageView imageView = this.mBinding.ivSpeechPrompt;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mBinding.ivSpeechPrompt;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.mBinding.ivSpeechPrompt;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_speech_microphone_encourage);
        }
    }

    public final void goneEncourage() {
        ImageView imageView = this.mBinding.ivSpeechPrompt;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void updateVolume(int i) {
        this.volume = i;
    }

    public final void reset() {
        ImageView imageView = this.mBinding.ivSpeechMic;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        ImageView imageView2 = this.mBinding.ivSpeechMic;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.icon_speech_microphone_no_permission);
        }
        RoundLinearLayout roundLinearLayout = this.mBinding.llSpeechSettings;
        if (roundLinearLayout != null) {
            roundLinearLayout.setVisibility(8);
        }
        ImageView imageView3 = this.mBinding.ivSpeechPrompt;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        RoundTextView roundTextView = this.mBinding.tvSpeechShutDown;
        if (roundTextView != null) {
            roundTextView.setVisibility(8);
        }
        this.isSpeak = false;
        ImageView imageView4 = this.mBinding.ivSpeechPrompt;
        if (imageView4 != null) {
            imageView4.setImageResource(R.drawable.icon_speech_microphone_encourage);
        }
    }

    public final void removePlugin() {
        ImageView imageView = this.mBinding.ivSpeechMic;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        ImageView imageView2 = this.mBinding.ivSpeechMic;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.icon_speech_microphone_end);
        }
        RoundLinearLayout roundLinearLayout = this.mBinding.llSpeechSettings;
        if (roundLinearLayout != null) {
            roundLinearLayout.setVisibility(8);
        }
        ImageView imageView3 = this.mBinding.ivSpeechPrompt;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        RoundTextView roundTextView = this.mBinding.tvSpeechShutDown;
        if (roundTextView != null) {
            roundTextView.setVisibility(8);
        }
    }

    public final void showResult(boolean z) {
        if (z) {
            ImageView imageView = this.mBinding.ivSpeechPrompt;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_speech_microphone_join);
            }
        } else {
            ImageView imageView2 = this.mBinding.ivSpeechPrompt;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.icon_speech_microphone_no_join);
            }
        }
        ImageView imageView3 = this.mBinding.ivSpeechPrompt;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
    }

    public final void goneResult() {
        ImageView imageView = this.mBinding.ivSpeechPrompt;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void onDestroy() {
        LottieAnimationView lottieAnimationView = this.mBinding.ivLottieSpeechMic;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }
}
