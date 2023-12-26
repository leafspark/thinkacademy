package com.tal.app.thinkacademy.common.widget.gold;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.commui.widget.BezierDirection;
import com.tal.app.thinkacademy.lib.commui.widget.BezierEvaluator;
import com.tal.app.thinkacademy.lib.commui.widget.EaseCubicInterpolator;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.yy.mobile.rollingtextview.RollingTextView;
import com.yy.mobile.rollingtextview.strategy.Direction;
import com.yy.mobile.rollingtextview.strategy.Strategy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0002\u00105J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0002J\"\u0010:\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u001bJ!\u0010=\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00103\u001a\u0004\u0018\u000104¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020'H\u0002J\u0017\u0010@\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020'2\b\b\u0001\u0010C\u001a\u00020\tJ3\u0010D\u001a\u00020'2\b\u0010E\u001a\u0004\u0018\u00010\t2\b\u0010F\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010\t2\b\u0010H\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020'2\b\u0010K\u001a\u0004\u0018\u00010\u0016J\u000e\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u0019J\u000e\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\u001dJ\u0010\u0010P\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010\u001fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivLine1Coin1", "Landroid/widget/ImageView;", "ivLine1Coin2", "ivLine1Coin3", "ivLine2Coin1", "ivLine2Coin2", "ivLine2Coin3", "ivLine3Coin1", "ivLine3Coin2", "ivLine3Coin3", "mCoinTextView", "Lcom/yy/mobile/rollingtextview/RollingTextView;", "mContext", "mListener", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinListener;", "mOpenScale", "", "mScaleRatio", "", "mToView", "Landroid/view/View;", "mToViewAnimationIsRunning", "getMToViewAnimationIsRunning", "()Z", "setMToViewAnimationIsRunning", "(Z)V", "targetSize", "flyCoin", "", "line1Coin1", "line2Coin1", "line3Coin1", "line1Coin2", "line2Coin2", "line3Coin2", "line1Coin3", "line2Coin3", "line3Coin3", "toView", "coin", "flyCoinConfig", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinConfig;", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/view/View;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinConfig;)V", "getBezierDirection", "Lcom/tal/app/thinkacademy/lib/commui/widget/BezierDirection;", "direction", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineDirection;", "initView", "openCoinScale", "openScale", "playFlyCoinAnimation", "(Ljava/lang/Integer;Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinConfig;)V", "playToViewAnimation", "rollingText", "(Ljava/lang/Integer;)V", "setCoinImageResource", "resId", "setCoinLayoutParams", "width", "height", "leftMargin", "topMargin", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCoinTextView", "coinTextView", "setListener", "listener", "setScaleRatio", "scaleRatio", "setToView", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyCoinView.kt */
public final class FlyCoinView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FlyGoldView";
    private ImageView ivLine1Coin1;
    private ImageView ivLine1Coin2;
    private ImageView ivLine1Coin3;
    private ImageView ivLine2Coin1;
    private ImageView ivLine2Coin2;
    private ImageView ivLine2Coin3;
    private ImageView ivLine3Coin1;
    private ImageView ivLine3Coin2;
    private ImageView ivLine3Coin3;
    private RollingTextView mCoinTextView;
    private Context mContext;
    /* access modifiers changed from: private */
    public FlyCoinListener mListener;
    private boolean mOpenScale;
    private float mScaleRatio;
    private View mToView;
    private boolean mToViewAnimationIsRunning;
    private float targetSize;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlyCoinView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlyCoinLineDirection.values().length];
            iArr[FlyCoinLineDirection.DOWN.ordinal()] = 1;
            iArr[FlyCoinLineDirection.UP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlyCoinView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlyCoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.targetSize = 0.8f;
        this.mScaleRatio = 1.0f;
        initView(context, attributeSet, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlyCoinView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlyCoinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean getMToViewAnimationIsRunning() {
        return this.mToViewAnimationIsRunning;
    }

    public final void setMToViewAnimationIsRunning(boolean z) {
        this.mToViewAnimationIsRunning = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinView$Companion;", "", "()V", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlyCoinView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void initView(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.live_business_layout_fly_gold;
        ViewGroup viewGroup = this;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i2, viewGroup, true);
        } else {
            XMLParseInstrumentation.inflate(from, i2, viewGroup, true);
        }
        this.ivLine1Coin1 = (ImageView) findViewById(R.id.iv_line1_coin1);
        this.ivLine1Coin2 = (ImageView) findViewById(R.id.iv_line1_coin2);
        this.ivLine1Coin3 = (ImageView) findViewById(R.id.iv_line1_coin3);
        this.ivLine2Coin1 = (ImageView) findViewById(R.id.iv_line2_coin1);
        this.ivLine2Coin2 = (ImageView) findViewById(R.id.iv_line2_coin2);
        this.ivLine2Coin3 = (ImageView) findViewById(R.id.iv_line2_coin3);
        this.ivLine3Coin1 = (ImageView) findViewById(R.id.iv_line3_coin1);
        this.ivLine3Coin2 = (ImageView) findViewById(R.id.iv_line3_coin2);
        this.ivLine3Coin3 = (ImageView) findViewById(R.id.iv_line3_coin3);
    }

    public final void setListener(FlyCoinListener flyCoinListener) {
        Intrinsics.checkNotNullParameter(flyCoinListener, "listener");
        this.mListener = flyCoinListener;
    }

    public final void setToView(View view) {
        this.mToView = view;
    }

    public final void setCoinTextView(RollingTextView rollingTextView) {
        this.mCoinTextView = rollingTextView;
    }

    public final void setCoinImageResource(int i) {
        ImageView imageView = this.ivLine1Coin1;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        ImageView imageView2 = this.ivLine1Coin2;
        if (imageView2 != null) {
            imageView2.setImageResource(i);
        }
        ImageView imageView3 = this.ivLine1Coin3;
        if (imageView3 != null) {
            imageView3.setImageResource(i);
        }
        ImageView imageView4 = this.ivLine2Coin1;
        if (imageView4 != null) {
            imageView4.setImageResource(i);
        }
        ImageView imageView5 = this.ivLine2Coin2;
        if (imageView5 != null) {
            imageView5.setImageResource(i);
        }
        ImageView imageView6 = this.ivLine2Coin3;
        if (imageView6 != null) {
            imageView6.setImageResource(i);
        }
        ImageView imageView7 = this.ivLine3Coin1;
        if (imageView7 != null) {
            imageView7.setImageResource(i);
        }
        ImageView imageView8 = this.ivLine3Coin2;
        if (imageView8 != null) {
            imageView8.setImageResource(i);
        }
        ImageView imageView9 = this.ivLine3Coin3;
        if (imageView9 != null) {
            imageView9.setImageResource(i);
        }
    }

    public final void setCoinLayoutParams(Integer num, Integer num2, Integer num3, Integer num4) {
        ImageView imageView = this.ivLine1Coin1;
        ConstraintLayout.LayoutParams layoutParams = null;
        ConstraintLayout.LayoutParams layoutParams2 = imageView == null ? null : imageView.getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = layoutParams2;
        }
        if (num != null) {
            int intValue = num.intValue();
            if (layoutParams != null) {
                layoutParams.width = intValue;
            }
        }
        if (num2 != null) {
            int intValue2 = num2.intValue();
            if (layoutParams != null) {
                layoutParams.height = intValue2;
            }
        }
        if (num3 != null) {
            int intValue3 = num3.intValue();
            if (layoutParams != null) {
                layoutParams.leftMargin = intValue3;
            }
        }
        if (num4 != null) {
            int intValue4 = num4.intValue();
            if (layoutParams != null) {
                layoutParams.topMargin = intValue4;
            }
        }
    }

    public final void openCoinScale(boolean z) {
        this.mOpenScale = z;
    }

    public final void setScaleRatio(float f) {
        this.mScaleRatio = f;
    }

    public static /* synthetic */ void playFlyCoinAnimation$default(FlyCoinView flyCoinView, Integer num, FlyCoinConfig flyCoinConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            flyCoinConfig = new DefaultFlyCoinConfig();
        }
        flyCoinView.playFlyCoinAnimation(num, flyCoinConfig);
    }

    public final void playFlyCoinAnimation(Integer num, FlyCoinConfig flyCoinConfig) {
        Unit unit;
        View view = this.mToView;
        Unit unit2 = null;
        if (view != null) {
            if (flyCoinConfig == null) {
                unit = null;
            } else {
                flyCoin(this.ivLine1Coin1, this.ivLine2Coin1, this.ivLine3Coin1, this.ivLine1Coin2, this.ivLine2Coin2, this.ivLine3Coin2, this.ivLine1Coin3, this.ivLine2Coin3, this.ivLine3Coin3, view, num, flyCoinConfig);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                FlyCoinView flyCoinView = this;
                FlyCoinListener flyCoinListener = this.mListener;
                if (flyCoinListener != null) {
                    flyCoinListener.onFlyCoinEnd();
                    unit2 = Unit.INSTANCE;
                }
            } else {
                unit2 = unit;
            }
        }
        if (unit2 == null) {
            FlyCoinView flyCoinView2 = this;
            FlyCoinListener flyCoinListener2 = this.mListener;
            if (flyCoinListener2 != null) {
                flyCoinListener2.onFlyCoinEnd();
            }
        }
    }

    private final void flyCoin(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, View view, Integer num, FlyCoinConfig flyCoinConfig) {
        ImageView imageView10 = imageView;
        if (imageView10 != null) {
            imageView10.post(new FlyCoinView$$ExternalSyntheticLambda9(this, flyCoinConfig, view, imageView, imageView4, imageView7, imageView2, imageView5, imageView8, imageView3, imageView6, imageView9, num));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22  reason: not valid java name */
    public static final void m64flyCoin$lambda22(FlyCoinView flyCoinView, FlyCoinConfig flyCoinConfig, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, Integer num) {
        PointF pointF;
        PointF pointF2;
        String str;
        String str2;
        PointF pointF3;
        AnimatorSet animatorSet;
        FlyCoinView flyCoinView2 = flyCoinView;
        FlyCoinConfig flyCoinConfig2 = flyCoinConfig;
        View view2 = view;
        ImageView imageView10 = imageView;
        ImageView imageView11 = imageView2;
        ImageView imageView12 = imageView3;
        ImageView imageView13 = imageView4;
        ImageView imageView14 = imageView5;
        ImageView imageView15 = imageView6;
        ImageView imageView16 = imageView7;
        ImageView imageView17 = imageView8;
        ImageView imageView18 = imageView9;
        Intrinsics.checkNotNullParameter(flyCoinView2, "this$0");
        Intrinsics.checkNotNullParameter(flyCoinConfig2, "$flyCoinConfig");
        Intrinsics.checkNotNullParameter(view2, "$toView");
        View view3 = flyCoinView2.mToView;
        if (view3 != null) {
            if (!(view3.getWidth() > 0 && flyCoinView2.mOpenScale)) {
                view3 = null;
            }
            if (view3 != null) {
                flyCoinView2.targetSize = (((float) view3.getWidth()) * 1.0f) / ((float) imageView.getWidth());
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
        }
        XesLog.it(TAG, "开始飞金币动画");
        if (flyCoinConfig.isPlaySound()) {
            SoundPoolUtils.play(flyCoinView.getContext(), R.raw.fly_coin, 0);
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr);
        imageView10.getLocationInWindow(iArr2);
        PointF pointF4 = new PointF(0.0f, 0.0f);
        PointF pointF5 = new PointF(((float) ((iArr[0] + ((view.getWidth() - imageView.getWidth()) / 2)) - iArr2[0])) / flyCoinView2.mScaleRatio, ((float) ((iArr[1] + ((view.getHeight() - imageView.getHeight()) / 2)) - iArr2[1])) / flyCoinView2.mScaleRatio);
        AnimatorSet animatorSet2 = new AnimatorSet();
        FlyCoinLineConfig line1 = flyCoinConfig.getLine1();
        if (line1 == null) {
            pointF2 = pointF5;
            pointF = pointF4;
        } else {
            ValueAnimator ofObject = ValueAnimator.ofObject(new BezierEvaluator(pointF4, pointF5, flyCoinView2.getBezierDirection(line1.getDirection()), line1.getOffset()), new Object[]{pointF4, pointF5});
            ofObject.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject.setDuration(line1.getAnimatorDuration());
            ImageView imageView19 = imageView;
            ofObject.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda7(imageView19));
            ofObject.addListener(new FlyCoinView$flyCoin$1$3$2(imageView19, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration = ObjectAnimator.ofFloat(imageView19, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(line1Coin1, \"sca…1Config.animatorDuration)");
            ImageView imageView20 = imageView;
            ObjectAnimator objectAnimator = duration;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(imageView20, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(line1Coin1, \"sca…1Config.animatorDuration)");
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(imageView20, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(line1Coin1, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject2 = ValueAnimator.ofObject(new BezierEvaluator(pointF4, pointF5, flyCoinView2.getBezierDirection(line1.getDirection()), line1.getOffset()), new Object[]{pointF4, pointF5});
            ObjectAnimator objectAnimator2 = duration2;
            ObjectAnimator objectAnimator3 = duration3;
            ofObject2.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject2.setDuration(line1.getAnimatorDuration());
            ofObject2.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda3(imageView11));
            ofObject2.addListener(new FlyCoinView$flyCoin$1$3$4(imageView11, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(imageView11, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(line1Coin2, \"sca…1Config.animatorDuration)");
            ObjectAnimator objectAnimator4 = duration4;
            ValueAnimator valueAnimator = ofObject2;
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(imageView11, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration5, "ofFloat(line1Coin2, \"sca…1Config.animatorDuration)");
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(imageView11, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration6, "ofFloat(line1Coin2, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject3 = ValueAnimator.ofObject(new BezierEvaluator(pointF4, pointF5, flyCoinView2.getBezierDirection(line1.getDirection()), line1.getOffset()), new Object[]{pointF4, pointF5});
            pointF2 = pointF5;
            pointF = pointF4;
            ofObject3.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ObjectAnimator objectAnimator5 = duration6;
            ObjectAnimator objectAnimator6 = duration5;
            ofObject3.setDuration(line1.getAnimatorDuration());
            ImageView imageView21 = imageView3;
            ofObject3.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda1(imageView21));
            ofObject3.addListener(new FlyCoinView$flyCoin$1$3$6(imageView21, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(imageView21, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration7, "ofFloat(line1Coin3, \"sca…1Config.animatorDuration)");
            ImageView imageView22 = imageView3;
            ValueAnimator valueAnimator2 = valueAnimator;
            ObjectAnimator duration8 = ObjectAnimator.ofFloat(imageView22, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line1.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration8, "ofFloat(line1Coin3, \"sca…1Config.animatorDuration)");
            ObjectAnimator duration9 = ObjectAnimator.ofFloat(imageView22, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration9, "ofFloat(line1Coin3, \"alp…, 0.0f).setDuration(100L)");
            Animator animator = objectAnimator2;
            animatorSet2.play(ofObject).with(objectAnimator).with(animator);
            animatorSet2.play(objectAnimator3).after(animator);
            Animator animator2 = objectAnimator6;
            animatorSet2.play(valueAnimator2).with(objectAnimator4).with(animator2).after(120);
            animatorSet2.play(objectAnimator5).after(animator2);
            Animator animator3 = duration8;
            animatorSet2.play(ofObject3).with(duration7).with(animator3).after(240);
            animatorSet2.play(duration9).after(animator3);
        }
        FlyCoinLineConfig line2 = flyCoinConfig.getLine2();
        if (line2 == null) {
            str2 = "scaleY";
            str = "scaleX";
            pointF3 = pointF2;
        } else {
            PointF pointF6 = pointF2;
            PointF pointF7 = pointF;
            ValueAnimator ofObject4 = ValueAnimator.ofObject(new BezierEvaluator(pointF7, pointF6, flyCoinView2.getBezierDirection(line2.getDirection()), line2.getOffset()), new Object[]{pointF7, pointF6});
            ofObject4.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject4.setDuration(line2.getAnimatorDuration());
            ImageView imageView23 = imageView4;
            ofObject4.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda0(imageView23));
            ofObject4.addListener(new FlyCoinView$flyCoin$1$4$2(imageView23, flyCoinConfig2, flyCoinView2));
            ValueAnimator valueAnimator3 = ofObject4;
            ObjectAnimator duration10 = ObjectAnimator.ofFloat(imageView23, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration10, "ofFloat(line2Coin1, \"sca…2Config.animatorDuration)");
            ObjectAnimator duration11 = ObjectAnimator.ofFloat(imageView23, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration11, "ofFloat(line2Coin1, \"sca…2Config.animatorDuration)");
            ObjectAnimator duration12 = ObjectAnimator.ofFloat(imageView4, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration12, "ofFloat(line2Coin1, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject5 = ValueAnimator.ofObject(new BezierEvaluator(pointF7, pointF6, flyCoinView2.getBezierDirection(line2.getDirection()), line2.getOffset()), new Object[]{pointF7, pointF6});
            ObjectAnimator objectAnimator7 = duration12;
            ofObject5.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject5.setDuration(line2.getAnimatorDuration());
            ImageView imageView24 = imageView5;
            ofObject5.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda5(imageView24));
            ofObject5.addListener(new FlyCoinView$flyCoin$1$4$4(imageView24, flyCoinConfig2, flyCoinView2));
            ObjectAnimator objectAnimator8 = duration10;
            ObjectAnimator duration13 = ObjectAnimator.ofFloat(imageView24, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration13, "ofFloat(line2Coin2, \"sca…2Config.animatorDuration)");
            ObjectAnimator objectAnimator9 = duration13;
            AnimatorSet animatorSet3 = animatorSet2;
            ObjectAnimator duration14 = ObjectAnimator.ofFloat(imageView24, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration14, "ofFloat(line2Coin2, \"sca…2Config.animatorDuration)");
            ObjectAnimator duration15 = ObjectAnimator.ofFloat(imageView24, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration15, "ofFloat(line2Coin2, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject6 = ValueAnimator.ofObject(new BezierEvaluator(pointF7, pointF6, flyCoinView2.getBezierDirection(line2.getDirection()), line2.getOffset()), new Object[]{pointF7, pointF6});
            pointF3 = pointF6;
            ofObject6.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject6.setDuration(line2.getAnimatorDuration());
            ImageView imageView25 = imageView6;
            ofObject6.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda4(imageView25));
            ofObject6.addListener(new FlyCoinView$flyCoin$1$4$6(imageView25, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration16 = ObjectAnimator.ofFloat(imageView25, "scaleX", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration16, "ofFloat(line2Coin3, \"sca…2Config.animatorDuration)");
            ImageView imageView26 = imageView6;
            str2 = "scaleY";
            str = "scaleX";
            ObjectAnimator duration17 = ObjectAnimator.ofFloat(imageView26, "scaleY", new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line2.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration17, "ofFloat(line2Coin3, \"sca…2Config.animatorDuration)");
            ObjectAnimator duration18 = ObjectAnimator.ofFloat(imageView26, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration18, "ofFloat(line2Coin3, \"alp…, 0.0f).setDuration(100L)");
            animatorSet2 = animatorSet3;
            Animator animator4 = duration11;
            animatorSet2.play(valueAnimator3).with(objectAnimator8).with(animator4);
            animatorSet2.play(objectAnimator7).after(animator4);
            Animator animator5 = duration14;
            animatorSet2.play(ofObject5).with(objectAnimator9).with(animator5).after(80);
            animatorSet2.play(duration15).after(animator5);
            Animator animator6 = duration17;
            animatorSet2.play(ofObject6).with(duration16).with(animator6).after(160);
            animatorSet2.play(duration18).after(animator6);
        }
        FlyCoinLineConfig line3 = flyCoinConfig.getLine3();
        if (line3 == null) {
            animatorSet = animatorSet2;
        } else {
            PointF pointF8 = pointF;
            PointF pointF9 = pointF3;
            ValueAnimator ofObject7 = ValueAnimator.ofObject(new BezierEvaluator(pointF8, pointF9, flyCoinView2.getBezierDirection(line3.getDirection()), line3.getOffset()), new Object[]{pointF8, pointF9});
            ofObject7.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject7.setDuration(line3.getAnimatorDuration());
            ImageView imageView27 = imageView7;
            ofObject7.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda6(imageView27));
            ofObject7.addListener(new FlyCoinView$flyCoin$1$5$2(imageView27, flyCoinConfig2, flyCoinView2));
            String str3 = str;
            ObjectAnimator duration19 = ObjectAnimator.ofFloat(imageView27, str3, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration19, "ofFloat(line3Coin1, \"sca…3Config.animatorDuration)");
            String str4 = str2;
            ObjectAnimator duration20 = ObjectAnimator.ofFloat(imageView27, str4, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration20, "ofFloat(line3Coin1, \"sca…3Config.animatorDuration)");
            ObjectAnimator duration21 = ObjectAnimator.ofFloat(imageView7, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration21, "ofFloat(line3Coin1, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject8 = ValueAnimator.ofObject(new BezierEvaluator(pointF8, pointF9, flyCoinView2.getBezierDirection(line3.getDirection()), line3.getOffset()), new Object[]{pointF8, pointF9});
            ObjectAnimator objectAnimator10 = duration20;
            ObjectAnimator objectAnimator11 = duration21;
            ofObject8.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject8.setDuration(line3.getAnimatorDuration());
            ImageView imageView28 = imageView8;
            ofObject8.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda2(imageView28));
            ofObject8.addListener(new FlyCoinView$flyCoin$1$5$4(imageView28, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration22 = ObjectAnimator.ofFloat(imageView28, str3, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration22, "ofFloat(line3Coin2, \"sca…3Config.animatorDuration)");
            ImageView imageView29 = imageView8;
            AnimatorSet animatorSet4 = animatorSet2;
            ValueAnimator valueAnimator4 = ofObject8;
            ObjectAnimator duration23 = ObjectAnimator.ofFloat(imageView29, str4, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration23, "ofFloat(line3Coin2, \"sca…3Config.animatorDuration)");
            ObjectAnimator duration24 = ObjectAnimator.ofFloat(imageView29, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration24, "ofFloat(line3Coin2, \"alp…, 0.0f).setDuration(100L)");
            ValueAnimator ofObject9 = ValueAnimator.ofObject(new BezierEvaluator(pointF8, pointF9, flyCoinView2.getBezierDirection(line3.getDirection()), line3.getOffset()), new Object[]{pointF8, pointF9});
            ofObject9.setInterpolator(new EaseCubicInterpolator(0.57f, 0.0f, 0.0f, 1.0f));
            ofObject9.setDuration(line3.getAnimatorDuration());
            ImageView imageView30 = imageView9;
            ofObject9.addUpdateListener(new FlyCoinView$$ExternalSyntheticLambda8(imageView30));
            ofObject9.addListener(new FlyCoinView$flyCoin$1$5$6(imageView30, flyCoinConfig2, flyCoinView2));
            ObjectAnimator duration25 = ObjectAnimator.ofFloat(imageView30, str3, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration25, "ofFloat(line3Coin3, \"sca…3Config.animatorDuration)");
            ObjectAnimator duration26 = ObjectAnimator.ofFloat(imageView30, str4, new float[]{1.2f, flyCoinView2.targetSize}).setDuration(line3.getAnimatorDuration());
            Intrinsics.checkNotNullExpressionValue(duration26, "ofFloat(line3Coin3, \"sca…3Config.animatorDuration)");
            ObjectAnimator duration27 = ObjectAnimator.ofFloat(imageView30, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration27, "ofFloat(line3Coin3, \"alp…, 0.0f).setDuration(100L)");
            animatorSet = animatorSet4;
            AnimatorSet.Builder with = animatorSet.play(ofObject7).with(duration19);
            Animator animator7 = objectAnimator10;
            with.with(animator7);
            animatorSet.play(objectAnimator11).after(animator7);
            Animator animator8 = duration23;
            animatorSet.play(valueAnimator4).with(duration22).with(animator8).after(80);
            animatorSet.play(duration24).after(animator8);
            Animator animator9 = duration26;
            animatorSet.play(ofObject9).with(duration25).with(animator9).after(160);
            animatorSet.play(duration27).after(animator9);
        }
        animatorSet.addListener(new FlyCoinView$flyCoin$1$6(flyCoinView2, num));
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-13$lambda-10  reason: not valid java name */
    public static final void m65flyCoin$lambda22$lambda13$lambda10(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        imageView.setTranslationX(pointF.x);
        imageView.setTranslationY(pointF.y);
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-13$lambda-11  reason: not valid java name */
    public static final void m66flyCoin$lambda22$lambda13$lambda11(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-13$lambda-12  reason: not valid java name */
    public static final void m67flyCoin$lambda22$lambda13$lambda12(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-17$lambda-14  reason: not valid java name */
    public static final void m68flyCoin$lambda22$lambda17$lambda14(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-17$lambda-15  reason: not valid java name */
    public static final void m69flyCoin$lambda22$lambda17$lambda15(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-17$lambda-16  reason: not valid java name */
    public static final void m70flyCoin$lambda22$lambda17$lambda16(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-21$lambda-18  reason: not valid java name */
    public static final void m71flyCoin$lambda22$lambda21$lambda18(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-21$lambda-19  reason: not valid java name */
    public static final void m72flyCoin$lambda22$lambda21$lambda19(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: flyCoin$lambda-22$lambda-21$lambda-20  reason: not valid java name */
    public static final void m73flyCoin$lambda22$lambda21$lambda20(ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        if (imageView != null) {
            imageView.setTranslationX(pointF.x);
        }
        if (imageView != null) {
            imageView.setTranslationY(pointF.y);
        }
    }

    /* access modifiers changed from: private */
    public final void rollingText(Integer num) {
        if (num != null) {
            try {
                num.intValue();
                RollingTextView rollingTextView = this.mCoinTextView;
                if (rollingTextView != null) {
                    String obj = rollingTextView.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        num = Integer.valueOf(num.intValue() + Integer.parseInt(obj));
                    }
                    rollingTextView.setAnimationDuration(200);
                    rollingTextView.setCharStrategy(Strategy.SameDirectionAnimation(Direction.SCROLL_UP));
                    rollingTextView.addCharOrder("0123456789");
                    rollingTextView.setAnimationInterpolator(new AccelerateDecelerateInterpolator());
                    rollingTextView.setText(num.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final BezierDirection getBezierDirection(FlyCoinLineDirection flyCoinLineDirection) {
        if (flyCoinLineDirection == null) {
            FlyCoinView flyCoinView = this;
            return BezierDirection.DOWN;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[flyCoinLineDirection.ordinal()];
        if (i == 1) {
            return BezierDirection.DOWN;
        }
        if (i == 2) {
            return BezierDirection.UP;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final void playToViewAnimation() {
        View view = this.mToView;
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 1.2f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(it, \"scaleX\", 1f, 1.2f).setDuration(100)");
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 1.2f}).setDuration(100);
            Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(it, \"scaleY\", 1f, 1.2f).setDuration(100)");
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.2f, 1.0f}).setDuration(50);
            Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(it, \"scaleX\", 1.2f, 1f).setDuration(50)");
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.2f, 1.0f}).setDuration(50);
            Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(it, \"scaleY\", 1.2f, 1f).setDuration(50)");
            Animator animator = duration;
            animatorSet.play(animator).with(duration2);
            animatorSet.play(duration3).with(duration4).after(animator);
            animatorSet.addListener(new FlyCoinView$playToViewAnimation$1$1(this));
            animatorSet.start();
        }
    }
}
