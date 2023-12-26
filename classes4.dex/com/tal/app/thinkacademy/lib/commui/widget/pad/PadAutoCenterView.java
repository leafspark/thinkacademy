package com.tal.app.thinkacademy.lib.commui.widget.pad;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/commui/widget/pad/PadAutoCenterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCenterScale", "", "mDesignHeight", "addView", "", "child", "Landroid/view/View;", "getScaleSize", "height", "onSizeChanged", "w", "h", "oldw", "oldh", "scaleView", "it", "scaleSize", "setCenterScale", "scale", "setDesignHeight", "designHeight", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadAutoCenterView.kt */
public final class PadAutoCenterView extends FrameLayout {
    private float mCenterScale;
    private float mDesignHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PadAutoCenterView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PadAutoCenterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PadAutoCenterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PadAutoCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCenterScale = 0.5f;
    }

    public final void setCenterScale(float f) {
        this.mCenterScale = f;
    }

    public final void setDesignHeight(float f) {
        this.mDesignHeight = f;
    }

    public void addView(View view) {
        if (view != null) {
            Drawable background = view.getBackground();
            if (background instanceof ColorDrawable) {
                setBackground(new ColorDrawable(((ColorDrawable) background).getColor()));
                view.setBackground((Drawable) null);
            } else if (background instanceof GradientDrawable) {
                background.setBounds(0, 0, getWidth(), getHeight());
                setBackground(background);
                view.setBackground((Drawable) null);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = (int) (((float) ScreenUtils.getScreenWidth()) * this.mCenterScale);
            layoutParams2.gravity = 1;
            view.setLayoutParams(layoutParams2);
            if (this.mDesignHeight > 0.0f) {
                int i = getResources().getDisplayMetrics().heightPixels;
                scaleView(view, i, getScaleSize(i));
            }
        }
        super.addView(view);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mDesignHeight > 0.0f) {
            XesLog.it("PadAutoCenterView", Intrinsics.stringPlus("onSizeChanged height = ", Integer.valueOf(i2)));
            float scaleSize = getScaleSize(i2);
            XesLog.it("PadAutoCenterView", Intrinsics.stringPlus("onSizeChanged scaleSize = ", Float.valueOf(scaleSize)));
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                int i6 = i5 + 1;
                View childAt = getChildAt(i5);
                if (!(childAt.getScaleX() == scaleSize)) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "it");
                    scaleView(childAt, i2, scaleSize);
                }
                i5 = i6;
            }
        }
    }

    private final void scaleView(View view, int i, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
        view.setPivotY(0.0f);
        view.setPivotX((((float) ScreenUtils.getScreenWidth()) * this.mCenterScale) / 2.0f);
        view.getLayoutParams().width = (int) ((((float) ScreenUtils.getScreenWidth()) * this.mCenterScale) / f);
        view.getLayoutParams().height = (int) (((float) i) / f);
    }

    private final float getScaleSize(int i) {
        float f = (((float) i) * 1.0f) / getResources().getDisplayMetrics().density;
        XesLog.it("PadAutoCenterView", "currentDpHeight = " + f + ", designHeight = " + this.mDesignHeight);
        float f2 = this.mDesignHeight;
        if (f2 > f) {
            return f / f2;
        }
        return 1.0f;
    }
}
