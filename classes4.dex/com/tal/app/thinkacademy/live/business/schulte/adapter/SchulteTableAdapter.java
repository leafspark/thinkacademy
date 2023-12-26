package com.tal.app.thinkacademy.live.business.schulte.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.FlexboxLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.schulte.view.BoxView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u0011J \u0010!\u001a\u00020\u00112\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/adapter/SchulteTableAdapter;", "", "mContext", "Landroid/content/Context;", "mData", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "mAnimatNumShow", "Landroid/animation/ValueAnimator;", "getMContext", "()Landroid/content/Context;", "mFlexBox", "Lcom/google/android/flexbox/FlexboxLayout;", "mItemClick", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/live/business/schulte/view/BoxView;", "", "attach", "flexBox", "level", "", "convert", "box", "num", "createView", "getItemView", "Landroid/view/View;", "pos", "notifyDataChange", "notifyItem", "node", "playShake", "setOnItemChildClickListener", "click", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableAdapter.kt */
public final class SchulteTableAdapter {
    private final ValueAnimator mAnimatNumShow;
    private final Context mContext;
    private final List<String> mData;
    private FlexboxLayout mFlexBox;
    private Function2<? super String, ? super BoxView, Unit> mItemClick;

    public final void notifyItem(int i, int i2) {
    }

    public SchulteTableAdapter(Context context, List<String> list) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(list, "mData");
        this.mContext = context;
        this.mData = list;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f, 1.0f}).setDuration(400);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(0f, 0f, 1f).setDuration(400)");
        this.mAnimatNumShow = duration;
        duration.addUpdateListener(new SchulteTableAdapter$$ExternalSyntheticLambda0(this));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m424_init_$lambda1(SchulteTableAdapter schulteTableAdapter, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(schulteTableAdapter, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup viewGroup = schulteTableAdapter.mFlexBox;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup;
            int childCount = viewGroup2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup2.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                ((BoxView) childAt).setNumAlpha(floatValue);
            }
        }
    }

    private final BoxView createView(String str, int i) {
        BoxView boxView = new BoxView(this.mContext, i);
        convert(boxView, str);
        return boxView;
    }

    private final void convert(BoxView boxView, String str) {
        boxView.setText(str);
        boxView.playAnimation();
    }

    public final void attach(FlexboxLayout flexboxLayout, int i) {
        Intrinsics.checkNotNullParameter(flexboxLayout, "flexBox");
        this.mFlexBox = flexboxLayout;
        int dp2px = SizeUtils.dp2px(238.0f - ((float) (i * 8))) / i;
        int i2 = 0;
        for (Object next : this.mData) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BoxView createView = createView((String) next, i);
            ViewGroup.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(dp2px, dp2px);
            if (i2 % i == 0) {
                layoutParams.setWrapBefore(true);
            }
            createView.setOnClickListener(new SchulteTableAdapter$$ExternalSyntheticLambda1(this, createView));
            flexboxLayout.addView(createView, layoutParams);
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: attach$lambda-3$lambda-2  reason: not valid java name */
    public static final void m425attach$lambda3$lambda2(SchulteTableAdapter schulteTableAdapter, BoxView boxView, View view) {
        Intrinsics.checkNotNullParameter(schulteTableAdapter, "this$0");
        Intrinsics.checkNotNullParameter(boxView, "$itemView");
        Function2<? super String, ? super BoxView, Unit> function2 = schulteTableAdapter.mItemClick;
        if (function2 != null) {
            function2.invoke(boxView.getText(), boxView);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void notifyDataChange() {
        ViewGroup viewGroup = this.mFlexBox;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup;
            int childCount = viewGroup2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup2.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                convert((BoxView) childAt, this.mData.get(i));
            }
        }
        this.mAnimatNumShow.start();
    }

    public final void setOnItemChildClickListener(Function2<? super String, ? super BoxView, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "click");
        this.mItemClick = function2;
    }

    public final View getItemView(int i) {
        FlexboxLayout flexboxLayout = this.mFlexBox;
        if (flexboxLayout == null) {
            return null;
        }
        return flexboxLayout.getReorderedChildAt(i);
    }

    public final void playShake() {
        ViewGroup viewGroup = this.mFlexBox;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup;
            int childCount = viewGroup2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup2.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                ((BoxView) childAt).shake();
            }
        }
    }
}
