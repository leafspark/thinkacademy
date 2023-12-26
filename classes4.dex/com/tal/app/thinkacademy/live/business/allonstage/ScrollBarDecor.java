package com.tal.app.thinkacademy.live.business.allonstage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010!\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/ScrollBarDecor;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "mPadding", "", "mThumbColor", "Ljava/lang/Integer;", "mThumbLength", "mThumbPaint", "Landroid/graphics/Paint;", "mThumbRoundRectF", "Landroid/graphics/RectF;", "mThumbSize", "mTrackColor", "mTrackLength", "mTrackPaint", "mTrackRoundRectF", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setPadding", "padding", "setThumbColor", "color", "setThumbLength", "thumbLength", "setThumbSize", "thumbSize", "setTrackColor", "setTrackLength", "trackLength", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScrollBarDecor.kt */
public final class ScrollBarDecor extends RecyclerView.ItemDecoration {
    private int mPadding = SizeUtils.dp2px(4.0f);
    private Integer mThumbColor;
    private int mThumbLength = SizeUtils.dp2px(20.0f);
    private Paint mThumbPaint;
    private final RectF mThumbRoundRectF = new RectF();
    private int mThumbSize = SizeUtils.dp2px(4.0f);
    private Integer mTrackColor;
    private int mTrackLength = SizeUtils.dp2px(50.0f);
    private Paint mTrackPaint;
    private final RectF mTrackRoundRectF = new RectF();

    public final void setThumbSize(int i) {
        this.mThumbSize = i;
    }

    public final void setThumbLength(int i) {
        this.mThumbLength = i;
    }

    public final void setTrackLength(int i) {
        this.mTrackLength = i;
    }

    public final void setThumbColor(int i) {
        this.mThumbColor = Integer.valueOf(i);
    }

    public final void setTrackColor(int i) {
        this.mTrackColor = Integer.valueOf(i);
    }

    public final void setPadding(int i) {
        this.mPadding = i;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        ScrollBarDecor.super.onDrawOver(canvas, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            boolean z = true;
            if (this.mThumbPaint == null) {
                Paint paint = new Paint();
                this.mThumbPaint = paint;
                paint.setAntiAlias(true);
                Paint paint2 = this.mThumbPaint;
                if (paint2 != null) {
                    paint2.setColor(Color.parseColor("#FFEAF1FE"));
                }
                Paint paint3 = this.mThumbPaint;
                if (paint3 != null) {
                    paint3.setStrokeCap(Paint.Cap.ROUND);
                }
                Paint paint4 = this.mThumbPaint;
                if (paint4 != null) {
                    paint4.setStrokeWidth((float) this.mThumbSize);
                }
            }
            if (this.mTrackPaint == null) {
                Paint paint5 = new Paint();
                this.mTrackPaint = paint5;
                paint5.setAntiAlias(true);
                Paint paint6 = this.mTrackPaint;
                if (paint6 != null) {
                    paint6.setColor(Color.parseColor("#ffff850a"));
                }
                Paint paint7 = this.mTrackPaint;
                if (paint7 != null) {
                    paint7.setStrokeCap(Paint.Cap.ROUND);
                }
                Paint paint8 = this.mTrackPaint;
                if (paint8 != null) {
                    paint8.setStrokeWidth((float) this.mThumbSize);
                }
            }
            if (layoutManager.canScrollVertically()) {
                this.mThumbRoundRectF.set((float) ((layoutManager.getWidth() - this.mThumbSize) - this.mPadding), (float) ((layoutManager.getHeight() / 2) - (this.mTrackLength / 2)), (float) (layoutManager.getWidth() - this.mPadding), (float) ((layoutManager.getHeight() / 2) + (this.mTrackLength / 2)));
                float computeVerticalScrollRange = (float) (recyclerView.computeVerticalScrollRange() - recyclerView.computeVerticalScrollExtent());
                float computeVerticalScrollOffset = ((float) (this.mTrackLength - this.mThumbLength)) * (((float) recyclerView.computeVerticalScrollOffset()) / computeVerticalScrollRange);
                if (computeVerticalScrollRange <= 0.0f) {
                    z = false;
                }
                this.mTrackRoundRectF.set((float) ((layoutManager.getWidth() - this.mThumbSize) - this.mPadding), ((float) ((layoutManager.getHeight() / 2) - (this.mTrackLength / 2))) + computeVerticalScrollOffset, (float) (layoutManager.getWidth() - this.mPadding), ((float) ((layoutManager.getHeight() / 2) - (this.mTrackLength / 2))) + computeVerticalScrollOffset + ((float) this.mThumbLength));
            } else {
                this.mThumbRoundRectF.set((float) ((layoutManager.getWidth() / 2) - (this.mTrackLength / 2)), (float) ((layoutManager.getHeight() - this.mThumbSize) - this.mPadding), (float) ((layoutManager.getWidth() / 2) + (this.mTrackLength / 2)), (float) (layoutManager.getHeight() - this.mPadding));
                float computeHorizontalScrollRange = (float) (recyclerView.computeHorizontalScrollRange() - recyclerView.computeHorizontalScrollExtent());
                float computeHorizontalScrollOffset = ((float) (this.mTrackLength - this.mThumbLength)) * (((float) recyclerView.computeHorizontalScrollOffset()) / computeHorizontalScrollRange);
                if (computeHorizontalScrollRange <= 0.0f) {
                    z = false;
                }
                int i = this.mTrackLength;
                this.mThumbRoundRectF.set(((float) ((layoutManager.getWidth() / 2) - (this.mTrackLength / 2))) + computeHorizontalScrollOffset, (float) ((layoutManager.getHeight() - this.mThumbSize) - this.mPadding), ((float) ((layoutManager.getWidth() / 2) - (i / 2))) + computeHorizontalScrollOffset + ((float) i), (float) (layoutManager.getHeight() - this.mPadding));
            }
            if (z) {
                RectF rectF = this.mThumbRoundRectF;
                int i2 = this.mThumbSize;
                Paint paint9 = this.mThumbPaint;
                Intrinsics.checkNotNull(paint9);
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint9);
                RectF rectF2 = this.mTrackRoundRectF;
                int i3 = this.mThumbSize;
                Paint paint10 = this.mTrackPaint;
                Intrinsics.checkNotNull(paint10);
                canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint10);
            }
        }
    }
}
