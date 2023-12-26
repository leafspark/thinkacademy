package com.tal.app.thinkacademy.live.business.continuous.window;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding;
import com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\"\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0018H\u0014J\u001a\u0010$\u001a\u00020%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010'H\u0002J\u0006\u0010(\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020%H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\nH\u0002J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u001cJ\u000e\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u0018J\u000e\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u001aJ\u0018\u0010;\u001a\u00020%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010'J\u0018\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessVoteSubmitDialogBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SUB_TAG", "", "levelMedalList", "", "[Ljava/lang/Integer;", "mAwardViewRunnable", "Ljava/lang/Runnable;", "mHandler", "Landroid/os/Handler;", "mMaxScale", "", "mNeedScale", "", "mParams", "Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultParams;", "mTag", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "needNotifyCoinsCenter", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "delayCloseDialog", "", "callback", "Lkotlin/Function0;", "getNeedNotifyCoinsCenter", "hide", "initView", "isAttach", "refreshLayout", "setAnswer", "level", "isTopLevel", "setAwardType", "type", "Lcom/tal/app/thinkacademy/live/business/continuous/window/AwardType;", "setCoins", "coins", "setLogTag", "tag", "setNeedScale", "needScale", "setParams", "params", "show", "updateUserCoins", "userCoins", "addCoins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitResultView.kt */
public final class SubmitResultView extends BaseVBLivePluginView<LiveBusinessVoteSubmitDialogBinding> {
    private final String SUB_TAG = "奖励弹窗";
    private final Integer[] levelMedalList = {Integer.valueOf(R.drawable.img_iron_large), Integer.valueOf(R.drawable.img_bronze_large), Integer.valueOf(R.drawable.img_sliver_large), Integer.valueOf(R.drawable.img_gold_large), Integer.valueOf(R.drawable.img_platinum_large), Integer.valueOf(R.drawable.img_diamond_large), Integer.valueOf(R.drawable.img_crown_large)};
    private Runnable mAwardViewRunnable;
    private Handler mHandler;
    private float mMaxScale = 1.0f;
    private boolean mNeedScale = true;
    private SubmitResultParams mParams;
    private XesLogTag mTag = Tag.PHOTO_BOX;
    private boolean needNotifyCoinsCenter;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubmitResultView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwardType.values().length];
            iArr[AwardType.UPLOAD.ordinal()] = 1;
            iArr[AwardType.RIGHT.ordinal()] = 2;
            iArr[AwardType.WRONG.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean isAttach() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubmitResultView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubmitResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubmitResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        initView();
    }

    public final boolean getNeedNotifyCoinsCenter() {
        return this.needNotifyCoinsCenter;
    }

    public final void setNeedScale(boolean z) {
        this.mNeedScale = z;
    }

    public final void setLogTag(XesLogTag xesLogTag) {
        Intrinsics.checkNotNullParameter(xesLogTag, "tag");
        this.mTag = xesLogTag;
    }

    public final void setParams(SubmitResultParams submitResultParams) {
        Intrinsics.checkNotNullParameter(submitResultParams, "params");
        this.mParams = submitResultParams;
        setAwardType(submitResultParams.getType());
        setCoins(submitResultParams.getAddCoins());
        setAnswer(submitResultParams.getLevel(), submitResultParams.isTopLevel());
    }

    private final void setAwardType(AwardType awardType) {
        int i = WhenMappings.$EnumSwitchMapping$0[awardType.ordinal()];
        if (i == 1) {
            this.mBinding.ivResultSuccessTitle.setImageResource(R.drawable.img_award_submit_success);
            this.mBinding.tvResultSuccessTitle.setText(getContext().getString(R.string.submit_successfully));
        } else if (i == 2) {
            this.mBinding.ivResultSuccessTitle.setImageResource(R.drawable.img_award_submit_right);
            this.mBinding.tvResultSuccessTitle.setText(getContext().getString(R.string.correct_and_good_job));
        } else if (i == 3) {
            this.mBinding.ivResultSuccessTitle.setImageResource(R.drawable.img_award_submit_wrong);
            this.mBinding.tvResultSuccessTitle.setText(getContext().getString(R.string.opps_answer_wrong));
            this.mBinding.tvMedalDesc.setText(getContext().getString(R.string.better_luck_next_time));
            SubmitResultParams submitResultParams = this.mParams;
            if ((submitResultParams == null ? 0 : submitResultParams.getAddCoins()) > 0) {
                this.mBinding.tvMedalDesc.setVisibility(8);
            } else {
                this.mBinding.tvMedalDesc.setVisibility(0);
            }
        }
    }

    private final void setCoins(int i) {
        if (i > 0) {
            this.mBinding.llResultSuccessBgCoins.setVisibility(0);
            this.mBinding.tvResultSuccessBgCoins.setText(Intrinsics.stringPlus("+ ", Integer.valueOf(i)));
            this.needNotifyCoinsCenter = true;
            return;
        }
        this.mBinding.llResultSuccessBgCoins.setVisibility(8);
        this.needNotifyCoinsCenter = false;
    }

    private final void setAnswer(int i, boolean z) {
        if (i > 0) {
            SubmitResultParams submitResultParams = this.mParams;
            if ((submitResultParams == null ? null : submitResultParams.getType()) == AwardType.RIGHT) {
                this.mBinding.tvMedalDesc.setVisibility(0);
                this.mBinding.layoutMedal.setVisibility(0);
                if (z || i >= 7) {
                    this.mBinding.tvMedalDesc.setText(getContext().getString(R.string.medal_upgrade_hightest));
                    this.mBinding.imgMedalLast.setVisibility(8);
                    this.mBinding.imgMedalNew.setImageResource(((Number) ArraysKt.last(this.levelMedalList)).intValue());
                    this.mBinding.imgMedalArrow.setVisibility(8);
                    return;
                } else if (i == 1) {
                    this.mBinding.tvMedalDesc.setText(getContext().getString(R.string.medal_upgrade_new_level, new Object[]{String.valueOf(i)}));
                    this.mBinding.imgMedalNew.setVisibility(8);
                    this.mBinding.imgMedalLast.setImageResource(((Number) ArraysKt.first(this.levelMedalList)).intValue());
                    this.mBinding.imgMedalArrow.setVisibility(8);
                    return;
                } else {
                    if (2 <= i && i < 7) {
                        this.mBinding.tvMedalDesc.setText(getContext().getString(R.string.medal_upgrade_new_level, new Object[]{String.valueOf(i)}));
                        int i2 = i - 1;
                        this.mBinding.imgMedalLast.setImageResource(this.levelMedalList[i2 - 1].intValue());
                        this.mBinding.imgMedalNew.setImageResource(this.levelMedalList[i2].intValue());
                        return;
                    }
                    return;
                }
            }
        }
        this.mBinding.layoutMedal.setVisibility(8);
    }

    public static /* synthetic */ void show$default(SubmitResultView submitResultView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        submitResultView.show(function0);
    }

    public final void show(Function0<Unit> function0) {
        if (this.mNeedScale) {
            refreshLayout();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBinding.getRoot(), View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(200);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.0f, this.mMaxScale * 0.56f);
        float f = this.mMaxScale;
        Keyframe ofFloat3 = Keyframe.ofFloat(0.56f * f, f * 1.1f);
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, this.mMaxScale);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mBinding.getRoot(), new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{ofFloat2, ofFloat3, ofFloat4}), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{ofFloat2, ofFloat3, ofFloat4})});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(m…ing.root, scaleX, scaleY)");
        Animator animator = ofPropertyValuesHolder;
        animator.setDuration(360);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(animator);
        animatorSet.start();
        XesLog.i(this.mTag, this.SUB_TAG, Intrinsics.stringPlus("显示，参数是：", this.mParams));
        setVisibility(0);
        SubmitResultParams submitResultParams = this.mParams;
        if ((submitResultParams == null ? null : submitResultParams.getType()) == AwardType.RIGHT) {
            this.mBinding.pagResultSuccessTitle.setVisibility(0);
            this.mBinding.pagResultSuccessTitle.setPath("assets://pags/award_dialog_answer_right.pag");
            this.mBinding.pagResultSuccessTitle.play();
        }
        delayCloseDialog(function0);
    }

    static /* synthetic */ void delayCloseDialog$default(SubmitResultView submitResultView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        submitResultView.delayCloseDialog(function0);
    }

    private final void delayCloseDialog(Function0<Unit> function0) {
        Handler handler;
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.mAwardViewRunnable;
        if (runnable == null) {
            this.mAwardViewRunnable = new SubmitResultView$$ExternalSyntheticLambda0(this, function0);
        } else {
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                Intrinsics.checkNotNull(runnable);
                handler2.removeCallbacks(runnable);
            }
        }
        Runnable runnable2 = this.mAwardViewRunnable;
        if (runnable2 != null && (handler = this.mHandler) != null) {
            handler.postDelayed(runnable2, 3000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: delayCloseDialog$lambda-2  reason: not valid java name */
    public static final void m200delayCloseDialog$lambda2(SubmitResultView submitResultView, Function0 function0) {
        Intrinsics.checkNotNullParameter(submitResultView, "this$0");
        submitResultView.hide();
        SubmitResultParams submitResultParams = submitResultView.mParams;
        if (submitResultParams != null && submitResultParams.getAddCoins() > 0) {
            submitResultView.needNotifyCoinsCenter = false;
            submitResultView.updateUserCoins(submitResultParams.getTotalCoins(), submitResultParams.getAddCoins());
            XesLogTag xesLogTag = submitResultView.mTag;
            XesLog.i(xesLogTag, submitResultView.SUB_TAG, "通知金币中心 总金币数：" + submitResultParams.getTotalCoins() + " ，新加金币数：" + submitResultParams.getAddCoins());
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void hide() {
        Handler handler;
        XesLog.i(this.mTag, this.SUB_TAG, "隐藏");
        setVisibility(8);
        this.mBinding.pagResultSuccessTitle.pause();
        Runnable runnable = this.mAwardViewRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private final void refreshLayout() {
        FrameLayout.LayoutParams newLp = LiveAreaCompat.pptCenterLp().newLp();
        Intrinsics.checkNotNullExpressionValue(newLp, "pptCenterLp().newLp()");
        int dp2px = SizeUtils.dp2px(822.0f);
        float f = (((float) newLp.width) * 1.0f) / ((float) dp2px);
        ViewScaleUtil.scale(this.mBinding.getRoot(), f);
        this.mMaxScale = f;
        XesLogTag xesLogTag = this.mTag;
        XesLog.i(xesLogTag, this.SUB_TAG, "缩放，ppt宽 = " + newLp.width + " , 设计稿宽 = " + dp2px + " , 缩放" + f + 20493);
    }

    public final void initView() {
        setBackgroundResource(R.color.COLOR_80000000);
        setClickable(true);
        setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.mBinding.getRoot(), layoutParams);
    }

    private final void updateUserCoins(int i, int i2) {
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(GamePluginDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(i), new CoinEventData(GoldSource.GAME_GOLD, i2, false, false, 12, (DefaultConstructorMarker) null)));
    }

    /* access modifiers changed from: protected */
    public LiveBusinessVoteSubmitDialogBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessVoteSubmitDialogBinding inflate = LiveBusinessVoteSubmitDialogBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
