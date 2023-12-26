package com.tal.app.thinkacademy.live.business.schulte.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ+\u0010\u001b\u001a\u00020\u000f2#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bR+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGuideView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "level", "", "pos", "num", "", "(Landroid/content/Context;IILjava/lang/String;)V", "clickHole", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "", "holeView", "Landroid/widget/TextView;", "lottieArrow", "Lcom/airbnb/lottie/LottieAnimationView;", "mBoxSize", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "setClickCallback", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableGuideView.kt */
public final class SchulteTableGuideView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "引导";
    private static final Tag TAG = Tag.SCHULTE_TABLE;
    private Function1<? super Boolean, Unit> clickHole;
    private TextView holeView;
    private LottieAnimationView lottieArrow;
    private final int mBoxSize;
    private Paint paint = new Paint();
    private RectF rectF;
    private PorterDuffXfermode xfermode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTableGuideView(Context context, int i, int i2, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "num");
        Tag tag = TAG;
        XesLog.i(tag, SUB_TAG, "引导 level = " + i + " ,pos = " + i2 + " , num = " + str);
        int dp2px = SizeUtils.dp2px(((232.0f - ((float) ((i + -1) * 8))) / ((float) i)) - 0.5f);
        this.mBoxSize = dp2px;
        int i3 = i2 / i;
        int i4 = i2 % i;
        int dp2px2 = SizeUtils.dp2px(((float) ((i4 * 8) + 36)) - 0.0f) + (dp2px * i4);
        int dp2px3 = SizeUtils.dp2px(((float) ((i3 * 8) + 61)) - 0.0f) + (dp2px * i3);
        int i5 = 24;
        if (i == 3) {
            i5 = 32;
        } else if (i != 4 && i == 5) {
            i5 = 18;
        }
        TextView textView = new TextView(context);
        this.holeView = textView;
        textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        this.holeView.setTextSize(1, (float) i5);
        this.holeView.setTypeface(Typeface.create(ResourcesCompat.getFont(context, R.font.montserrat_bold), 1));
        this.holeView.setGravity(17);
        this.holeView.setText(str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.leftMargin = dp2px2;
        layoutParams.topMargin = dp2px3;
        this.holeView.setBackgroundResource(R.drawable.ic_schulte_table_box_guide);
        addView(this.holeView, layoutParams);
        this.lottieArrow = new LottieAnimationView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(SizeUtils.dp2px(40.0f), SizeUtils.dp2px(21.0f));
        layoutParams2.leftMargin = layoutParams.leftMargin + dp2px + SizeUtils.dp2px(8.0f);
        layoutParams2.topMargin = ((layoutParams.topMargin + dp2px) - (dp2px / 2)) - (SizeUtils.dp2px(21.0f) / 2);
        addView(this.lottieArrow, layoutParams2);
        this.lottieArrow.setImageAssetsFolder("schulte/images");
        this.lottieArrow.setAnimation("schulte/jiantou.json");
        this.lottieArrow.setRepeatCount(-1);
        this.lottieArrow.playAnimation();
        this.paint.setAntiAlias(true);
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.rectF = new RectF(100.0f, 100.0f, ((float) dp2px) + 100.0f, ((float) dp2px) + 100.0f);
        setWillNotDraw(false);
        setOnClickListener(new SchulteTableGuideView$$ExternalSyntheticLambda0(this));
        this.holeView.setOnClickListener(new SchulteTableGuideView$$ExternalSyntheticLambda1(this));
        XesLog.i(tag, SUB_TAG, "引导镂空大小 " + dp2px + " , row = " + i3 + " , column = " + i4 + " , left = " + dp2px2 + " ,top = " + dp2px3);
    }

    public final void setClickCallback(Function1<? super Boolean, Unit> function1) {
        this.clickHole = function1;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGuideView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableGuideView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m429_init_$lambda0(SchulteTableGuideView schulteTableGuideView, View view) {
        Intrinsics.checkNotNullParameter(schulteTableGuideView, "this$0");
        schulteTableGuideView.lottieArrow.cancelAnimation();
        schulteTableGuideView.setVisibility(8);
        Function1<? super Boolean, Unit> function1 = schulteTableGuideView.clickHole;
        if (function1 != null) {
            function1.invoke(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m430_init_$lambda1(SchulteTableGuideView schulteTableGuideView, View view) {
        Intrinsics.checkNotNullParameter(schulteTableGuideView, "this$0");
        schulteTableGuideView.lottieArrow.cancelAnimation();
        schulteTableGuideView.setVisibility(8);
        Function1<? super Boolean, Unit> function1 = schulteTableGuideView.clickHole;
        if (function1 != null) {
            function1.invoke(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
