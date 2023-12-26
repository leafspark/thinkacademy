package com.tal.app.thinkacademy.business.home.main.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.youth.banner.indicator.BaseIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/MyIndicator;", "Lcom/youth/banner/indicator/BaseIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNormalRadius", "mRectF", "Landroid/graphics/RectF;", "mSelectedRadius", "maxRadius", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MyIndicator.kt */
public final class MyIndicator extends BaseIndicator {
    private int mNormalRadius;
    private final RectF mRectF;
    private int mSelectedRadius;
    private int maxRadius;

    public MyIndicator() {
        this((Context) null, (AttributeSet) null, 0, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public MyIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRectF = new RectF();
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MyIndicator.super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            this.mNormalRadius = this.config.getNormalWidth() / 2;
            int selectedWidth = this.config.getSelectedWidth() / 2;
            this.mSelectedRadius = selectedWidth;
            this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
            int i3 = indicatorSize - 1;
            setMeasuredDimension((this.config.getIndicatorSpace() * i3) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i3), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        MyIndicator.super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i = 0;
            float f2 = 0.0f;
            while (i < indicatorSize) {
                int i2 = i + 1;
                this.mPaint.setColor(this.config.getCurrentPosition() == i ? this.config.getSelectedColor() : this.config.getNormalColor());
                if (this.config.getCurrentPosition() == i) {
                    int dp2px = SizeUtils.dp2px(7.0f);
                    int dp2px2 = SizeUtils.dp2px(7.0f) / 2;
                    this.mRectF.top = 0.0f;
                    this.mRectF.left = f2;
                    this.mRectF.right = ((float) (dp2px2 * 2)) + f2;
                    this.mRectF.bottom = (float) (this.maxRadius + this.mNormalRadius);
                    float f3 = (float) dp2px2;
                    canvas.drawRoundRect(this.mRectF, f3, f3, this.mPaint);
                    f = (float) (dp2px + this.config.getIndicatorSpace());
                } else {
                    int normalWidth = this.config.getNormalWidth();
                    float f4 = (float) this.mNormalRadius;
                    canvas.drawCircle(f2 + f4, (float) this.maxRadius, f4, this.mPaint);
                    f = (float) (normalWidth + this.config.getIndicatorSpace());
                }
                f2 += f;
                i = i2;
            }
        }
    }
}
