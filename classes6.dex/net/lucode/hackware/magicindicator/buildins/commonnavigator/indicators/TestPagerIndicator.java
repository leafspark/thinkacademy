package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public class TestPagerIndicator extends View implements IPagerIndicator {
    private RectF mInnerRect = new RectF();
    private int mInnerRectColor;
    private RectF mOutRect = new RectF();
    private int mOutRectColor;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    public TestPagerIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mOutRectColor = -65536;
        this.mInnerRectColor = -16711936;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mOutRectColor);
        canvas.drawRect(this.mOutRect, this.mPaint);
        this.mPaint.setColor(this.mInnerRectColor);
        canvas.drawRect(this.mInnerRect, this.mPaint);
    }

    public void onPageScrolled(int i, float f, int i2) {
        List<PositionData> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            PositionData imitativePositionData = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i);
            PositionData imitativePositionData2 = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i + 1);
            this.mOutRect.left = ((float) imitativePositionData.mLeft) + (((float) (imitativePositionData2.mLeft - imitativePositionData.mLeft)) * f);
            this.mOutRect.top = ((float) imitativePositionData.mTop) + (((float) (imitativePositionData2.mTop - imitativePositionData.mTop)) * f);
            this.mOutRect.right = ((float) imitativePositionData.mRight) + (((float) (imitativePositionData2.mRight - imitativePositionData.mRight)) * f);
            this.mOutRect.bottom = ((float) imitativePositionData.mBottom) + (((float) (imitativePositionData2.mBottom - imitativePositionData.mBottom)) * f);
            this.mInnerRect.left = ((float) imitativePositionData.mContentLeft) + (((float) (imitativePositionData2.mContentLeft - imitativePositionData.mContentLeft)) * f);
            this.mInnerRect.top = ((float) imitativePositionData.mContentTop) + (((float) (imitativePositionData2.mContentTop - imitativePositionData.mContentTop)) * f);
            this.mInnerRect.right = ((float) imitativePositionData.mContentRight) + (((float) (imitativePositionData2.mContentRight - imitativePositionData.mContentRight)) * f);
            this.mInnerRect.bottom = ((float) imitativePositionData.mContentBottom) + (((float) (imitativePositionData2.mContentBottom - imitativePositionData.mContentBottom)) * f);
            invalidate();
        }
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public int getOutRectColor() {
        return this.mOutRectColor;
    }

    public void setOutRectColor(int i) {
        this.mOutRectColor = i;
    }

    public int getInnerRectColor() {
        return this.mInnerRectColor;
    }

    public void setInnerRectColor(int i) {
        this.mInnerRectColor = i;
    }
}
