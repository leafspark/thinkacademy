package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.tal.app.thinkacademy.lib.commui.R;

public class StrokeTextView extends AppCompatTextView {
    private int mStrokeColor;
    private float mStrokeWidth;
    private TextView outlineTextView;

    public StrokeTextView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrokeColor = -1;
        this.outlineTextView = new TextView(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StrokeTextView);
            this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.StrokeTextView_strokeColor, -1);
            this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.StrokeTextView_strokeWidth, 0.0f);
            obtainStyledAttributes.recycle();
        }
        TextPaint paint = this.outlineTextView.getPaint();
        paint.setStrokeWidth(this.mStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        this.outlineTextView.setTextColor(this.mStrokeColor);
        this.outlineTextView.setGravity(getGravity());
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        StrokeTextView.super.setLayoutParams(layoutParams);
        this.outlineTextView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        StrokeTextView.super.onMeasure(i, i2);
        CharSequence text = this.outlineTextView.getText();
        if (text == null || !text.equals(getText())) {
            this.outlineTextView.setText(getText());
            postInvalidate();
        }
        this.outlineTextView.measure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        StrokeTextView.super.onLayout(z, i, i2, i3, i4);
        this.outlineTextView.layout(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.outlineTextView.draw(canvas);
        StrokeTextView.super.onDraw(canvas);
    }
}
