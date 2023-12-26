package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public class WrapPagerIndicator extends View implements IPagerIndicator {
    private Interpolator mEndInterpolator = new LinearInterpolator();
    private int mFillColor;
    private int mHorizontalPadding;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;
    private RectF mRect = new RectF();
    private float mRoundRadius;
    private boolean mRoundRadiusSet;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mVerticalPadding;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    public WrapPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mVerticalPadding = UIUtil.dip2px(context, 6.0d);
        this.mHorizontalPadding = UIUtil.dip2px(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mFillColor);
        RectF rectF = this.mRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    public void onPageScrolled(int i, float f, int i2) {
        List<PositionData> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            PositionData imitativePositionData = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i);
            PositionData imitativePositionData2 = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i + 1);
            this.mRect.left = ((float) (imitativePositionData.mContentLeft - this.mHorizontalPadding)) + (((float) (imitativePositionData2.mContentLeft - imitativePositionData.mContentLeft)) * this.mEndInterpolator.getInterpolation(f));
            this.mRect.top = (float) (imitativePositionData.mContentTop - this.mVerticalPadding);
            this.mRect.right = ((float) (imitativePositionData.mContentRight + this.mHorizontalPadding)) + (((float) (imitativePositionData2.mContentRight - imitativePositionData.mContentRight)) * this.mStartInterpolator.getInterpolation(f));
            this.mRect.bottom = (float) (imitativePositionData.mContentBottom + this.mVerticalPadding);
            if (!this.mRoundRadiusSet) {
                this.mRoundRadius = this.mRect.height() / 2.0f;
            }
            invalidate();
        }
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public int getVerticalPadding() {
        return this.mVerticalPadding;
    }

    public void setVerticalPadding(int i) {
        this.mVerticalPadding = i;
    }

    public int getHorizontalPadding() {
        return this.mHorizontalPadding;
    }

    public void setHorizontalPadding(int i) {
        this.mHorizontalPadding = i;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
    }

    public float getRoundRadius() {
        return this.mRoundRadius;
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
        this.mRoundRadiusSet = true;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }
}
