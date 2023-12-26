package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public class LinePagerIndicator extends View implements IPagerIndicator {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> mColors;
    private Interpolator mEndInterpolator = new LinearInterpolator();
    private float mLineHeight;
    private RectF mLineRect = new RectF();
    private float mLineWidth;
    private int mMode;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;
    private float mRoundRadius;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private float mXOffset;
    private float mYOffset;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    public LinePagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = (float) UIUtil.dip2px(context, 3.0d);
        this.mLineWidth = (float) UIUtil.dip2px(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    public void onPageScrolled(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        List<PositionData> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.mColors;
            if (list2 != null && list2.size() > 0) {
                this.mPaint.setColor(ArgbEvaluatorHolder.eval(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
            }
            PositionData imitativePositionData = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i);
            PositionData imitativePositionData2 = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i + 1);
            int i3 = this.mMode;
            if (i3 == 0) {
                f5 = ((float) imitativePositionData.mLeft) + this.mXOffset;
                f4 = ((float) imitativePositionData2.mLeft) + this.mXOffset;
                f2 = ((float) imitativePositionData.mRight) - this.mXOffset;
                f6 = (float) imitativePositionData2.mRight;
                f7 = this.mXOffset;
            } else if (i3 == 1) {
                f5 = ((float) imitativePositionData.mContentLeft) + this.mXOffset;
                f4 = ((float) imitativePositionData2.mContentLeft) + this.mXOffset;
                f2 = ((float) imitativePositionData.mContentRight) - this.mXOffset;
                f6 = (float) imitativePositionData2.mContentRight;
                f7 = this.mXOffset;
            } else {
                f5 = ((float) imitativePositionData.mLeft) + ((((float) imitativePositionData.width()) - this.mLineWidth) / 2.0f);
                f4 = ((float) imitativePositionData2.mLeft) + ((((float) imitativePositionData2.width()) - this.mLineWidth) / 2.0f);
                f2 = ((((float) imitativePositionData.width()) + this.mLineWidth) / 2.0f) + ((float) imitativePositionData.mLeft);
                f3 = ((((float) imitativePositionData2.width()) + this.mLineWidth) / 2.0f) + ((float) imitativePositionData2.mLeft);
                this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
                this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
                this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
                this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
                invalidate();
            }
            f3 = f6 - f7;
            this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
            this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
            this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
            this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
            invalidate();
        }
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public void setXOffset(float f) {
        this.mXOffset = f;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public float getRoundRadius() {
        return this.mRoundRadius;
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public void setColors(Integer... numArr) {
        this.mColors = Arrays.asList(numArr);
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
