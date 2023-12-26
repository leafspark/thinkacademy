package com.tal.app.thinkacademy.lib.commui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int bottom;
    private int dividerHeight;
    private Paint dividerPaint;
    private int left;
    private int right;
    private int top;

    public SpaceItemDecoration(int i, int i2, int i3, int i4, int i5, int i6) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        if (i5 > 0) {
            this.dividerHeight = i5;
            Paint paint = new Paint();
            this.dividerPaint = paint;
            paint.setColor(i6);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        SpaceItemDecoration.super.getItemOffsets(rect, view, recyclerView, state);
        int i = this.bottom;
        if (i > 0) {
            rect.bottom = i;
        }
        int i2 = this.top;
        if (i2 > 0) {
            rect.top = i2;
        }
        int i3 = this.right;
        if (i3 > 0) {
            rect.right = i3;
        }
        int i4 = this.left;
        if (i4 > 0) {
            rect.left = i4;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.dividerHeight > 0) {
            int childCount = recyclerView.getChildCount();
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) paddingLeft, (float) childAt.getBottom(), (float) width, (float) (childAt.getBottom() + this.dividerHeight), this.dividerPaint);
            }
        }
    }
}
