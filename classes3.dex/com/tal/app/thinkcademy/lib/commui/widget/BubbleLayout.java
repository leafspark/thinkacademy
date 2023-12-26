package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u0007J\u0006\u0010=\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020\u0007J\b\u0010?\u001a\u0004\u0018\u00010%J\u0006\u0010@\u001a\u00020\u0007J\u0006\u0010A\u001a\u00020\u0007J\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020\u0011J\u0006\u0010D\u001a\u00020+J\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010F\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020\u0007J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020\u0007J\u0006\u0010J\u001a\u00020\u0007J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020LH\u0002J\b\u0010P\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020LH\u0016J\u0010\u0010R\u001a\u00020L2\u0006\u0010S\u001a\u00020TH\u0014J\u0012\u0010U\u001a\u00020L2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\n\u0010X\u001a\u0004\u0018\u00010WH\u0014J(\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u0007H\u0014J\u0010\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0016J\b\u0010b\u001a\u00020LH\u0016J\u000e\u0010c\u001a\u00020L2\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010d\u001a\u00020L2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020L2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010f\u001a\u00020L2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010g\u001a\u00020L2\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020\u0007J\u000e\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020\u0007J\u0010\u0010m\u001a\u00020L2\b\u0010n\u001a\u0004\u0018\u00010\u0015J\u000e\u0010o\u001a\u00020L2\u0006\u0010p\u001a\u00020\u0007J\u000e\u0010q\u001a\u00020L2\u0006\u0010r\u001a\u00020\u0007J\u000e\u0010s\u001a\u00020L2\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020L2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010u\u001a\u00020L2\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010v\u001a\u00020L2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010w\u001a\u00020L2\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010x\u001a\u00020L2\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020L2\u0006\u0010(\u001a\u00020\u0007J\u0010\u0010z\u001a\u00020L2\b\u0010{\u001a\u0004\u0018\u00010#J\u000e\u0010|\u001a\u00020L2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010}\u001a\u00020L2\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010~\u001a\u00020L2\u0006\u00101\u001a\u00020\u0007J\u000e\u0010\u001a\u00020L2\u0006\u00102\u001a\u00020\u0007J\u000f\u0010\u0001\u001a\u00020L2\u0006\u00103\u001a\u00020\u0007J\u000f\u0010\u0001\u001a\u00020L2\u0006\u00104\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mArrowDownLeftRadius", "mArrowDownRightRadius", "mArrowTopLeftRadius", "mArrowTopRightRadius", "mBottom", "mBubbleBgRes", "mBubbleBorderColor", "mBubbleBorderPaint", "Landroid/graphics/Paint;", "mBubbleBorderSize", "mBubbleColor", "mBubbleImageBg", "Landroid/graphics/Bitmap;", "mBubbleImageBgBeforePaint", "mBubbleImageBgDstRectF", "Landroid/graphics/RectF;", "mBubbleImageBgPaint", "mBubbleImageBgSrcRect", "Landroid/graphics/Rect;", "mBubblePadding", "mBubbleRadius", "mHeight", "mLDR", "mLTR", "mLeft", "mListener", "Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$OnClickEdgeListener;", "mLook", "Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$Look;", "mLookLength", "mLookPosition", "mLookWidth", "mPaint", "mPath", "Landroid/graphics/Path;", "mRDR", "mRTR", "mRegion", "Landroid/graphics/Region;", "mRight", "mShadowColor", "mShadowRadius", "mShadowX", "mShadowY", "mTop", "mWidth", "getArrowDownLeftRadius", "getArrowDownRightRadius", "getArrowTopLeftRadius", "getArrowTopRightRadius", "getBubbleColor", "getBubbleRadius", "getLDR", "getLTR", "getLook", "getLookLength", "getLookPosition", "getLookWidth", "getPaint", "getPath", "getRDR", "getRTR", "getShadowColor", "getShadowRadius", "getShadowX", "getShadowY", "initAttr", "", "a", "Landroid/content/res/TypedArray;", "initData", "initPadding", "invalidate", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "postInvalidate", "setArrowDownLeftRadius", "setArrowDownRightRadius", "setArrowTopLeftRadius", "setArrowTopRightRadius", "setBubbleBorderColor", "bubbleBorderColor", "setBubbleBorderSize", "bubbleBorderSize", "setBubbleColor", "bubbleColor", "setBubbleImageBg", "bitmap", "setBubbleImageBgRes", "res", "setBubblePadding", "bubblePadding", "setBubbleRadius", "setLDR", "setLTR", "setLook", "setLookLength", "setLookPosition", "setLookWidth", "setOnClickEdgeListener", "l", "setRDR", "setRTR", "setShadowColor", "setShadowRadius", "setShadowX", "setShadowY", "Look", "OnClickEdgeListener", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleLayout.kt */
public final class BubbleLayout extends FrameLayout {
    private int mArrowDownLeftRadius;
    private int mArrowDownRightRadius;
    private int mArrowTopLeftRadius;
    private int mArrowTopRightRadius;
    private int mBottom;
    private int mBubbleBgRes;
    private int mBubbleBorderColor;
    private final Paint mBubbleBorderPaint;
    private int mBubbleBorderSize;
    private int mBubbleColor;
    private Bitmap mBubbleImageBg;
    private final Paint mBubbleImageBgBeforePaint;
    private final RectF mBubbleImageBgDstRectF;
    private final Paint mBubbleImageBgPaint;
    private final Rect mBubbleImageBgSrcRect;
    private int mBubblePadding;
    private int mBubbleRadius;
    private int mHeight;
    private int mLDR;
    private int mLTR;
    private int mLeft;
    private OnClickEdgeListener mListener;
    private Look mLook;
    private int mLookLength;
    private int mLookPosition;
    private int mLookWidth;
    private Paint mPaint;
    private Path mPath;
    private int mRDR;
    private int mRTR;
    private final Region mRegion;
    private int mRight;
    private int mShadowColor;
    private int mShadowRadius;
    private int mShadowX;
    private int mShadowY;
    private int mTop;
    private int mWidth;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$OnClickEdgeListener;", "", "edge", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BubbleLayout.kt */
    public interface OnClickEdgeListener {
        void edge();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BubbleLayout.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Look.values().length];
            iArr[Look.BOTTOM.ordinal()] = 1;
            iArr[Look.TOP.ordinal()] = 2;
            iArr[Look.LEFT.ordinal()] = 3;
            iArr[Look.RIGHT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BubbleLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRegion = new Region();
        this.mBubbleBgRes = -1;
        this.mBubbleImageBgDstRectF = new RectF();
        this.mBubbleImageBgSrcRect = new Rect();
        Paint paint = new Paint(5);
        this.mBubbleImageBgPaint = paint;
        this.mBubbleImageBgBeforePaint = new Paint(5);
        this.mBubbleBorderColor = -16777216;
        this.mBubbleBorderPaint = new Paint(5);
        setLayerType(1, (Paint) null);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eLayout, defStyleAttr, 0)");
        initAttr(obtainStyledAttributes);
        Paint paint2 = new Paint(5);
        this.mPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        initPadding();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$Look;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "Companion", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BubbleLayout.kt */
    public enum Look {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        public static final Companion Companion = null;
        private int value;

        private Look(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int i) {
            this.value = i;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$Look$Companion;", "", "()V", "getType", "Lcom/tal/app/thinkcademy/lib/commui/widget/BubbleLayout$Look;", "value", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BubbleLayout.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Look getType(int i) {
                Look look = Look.BOTTOM;
                if (i == 1) {
                    return Look.LEFT;
                }
                if (i == 2) {
                    return Look.TOP;
                }
                if (i == 3) {
                    return Look.RIGHT;
                }
                if (i != 4) {
                    return look;
                }
                return Look.BOTTOM;
            }
        }
    }

    private final void initPadding() {
        int i = this.mBubblePadding + this.mShadowRadius;
        Look look = this.mLook;
        int i2 = look == null ? -1 : WhenMappings.$EnumSwitchMapping$0[look.ordinal()];
        if (i2 == 1) {
            setPadding(i, i, this.mShadowX + i, this.mLookLength + i + this.mShadowY);
        } else if (i2 == 2) {
            setPadding(i, this.mLookLength + i, this.mShadowX + i, this.mShadowY + i);
        } else if (i2 == 3) {
            setPadding(this.mLookLength + i, i, this.mShadowX + i, this.mShadowY + i);
        } else if (i2 == 4) {
            setPadding(i, i, this.mLookLength + i + this.mShadowX, this.mShadowY + i);
        }
    }

    private final void initAttr(TypedArray typedArray) {
        this.mLook = Look.Companion.getType(typedArray.getInt(R.styleable.BubbleLayout_lookAt, Look.BOTTOM.getValue()));
        this.mLookPosition = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_lookPosition, 0);
        this.mLookWidth = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_lookWidth, SizeUtils.dp2px(13.0f));
        this.mLookLength = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_lookLength, SizeUtils.dp2px(12.0f));
        this.mShadowRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_shadowRadius, SizeUtils.dp2px(3.3f));
        this.mShadowX = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_shadowX, SizeUtils.dp2px(1.0f));
        this.mShadowY = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_shadowY, SizeUtils.dp2px(1.0f));
        this.mBubbleRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleRadius, SizeUtils.dp2px(8.0f));
        this.mLTR = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleLeftTopRadius, -1);
        this.mRTR = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleRightTopRadius, -1);
        this.mRDR = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleRightDownRadius, -1);
        this.mLDR = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleLeftDownRadius, -1);
        this.mArrowTopLeftRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleArrowTopLeftRadius, SizeUtils.dp2px(3.0f));
        this.mArrowTopRightRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleArrowTopRightRadius, SizeUtils.dp2px(3.0f));
        this.mArrowDownLeftRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleArrowDownLeftRadius, SizeUtils.dp2px(6.0f));
        this.mArrowDownRightRadius = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleArrowDownRightRadius, SizeUtils.dp2px(6.0f));
        this.mBubblePadding = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubblePadding, SizeUtils.dp2px(8.0f));
        this.mShadowColor = typedArray.getColor(R.styleable.BubbleLayout_shadowColor, -7829368);
        this.mBubbleColor = typedArray.getColor(R.styleable.BubbleLayout_bubbleColor, -1);
        int resourceId = typedArray.getResourceId(R.styleable.BubbleLayout_bubbleBgRes, -1);
        this.mBubbleBgRes = resourceId;
        if (resourceId != -1) {
            this.mBubbleImageBg = BitmapFactoryInstrumentation.decodeResource(getResources(), this.mBubbleBgRes);
        }
        this.mBubbleBorderColor = typedArray.getColor(R.styleable.BubbleLayout_bubbleBorderColor, -16777216);
        this.mBubbleBorderSize = typedArray.getDimensionPixelOffset(R.styleable.BubbleLayout_bubbleBorderSize, 0);
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        initData();
    }

    public void invalidate() {
        initData();
        super.invalidate();
    }

    public void postInvalidate() {
        initData();
        super.postInvalidate();
    }

    private final void initData() {
        this.mPaint.setShadowLayer((float) this.mShadowRadius, (float) this.mShadowX, (float) this.mShadowY, this.mShadowColor);
        this.mBubbleBorderPaint.setColor(this.mBubbleBorderColor);
        this.mBubbleBorderPaint.setStrokeWidth((float) this.mBubbleBorderSize);
        this.mBubbleBorderPaint.setStyle(Paint.Style.STROKE);
        int i = this.mShadowRadius;
        int i2 = this.mShadowX;
        int i3 = 0;
        this.mLeft = i + (i2 < 0 ? -i2 : 0) + (this.mLook == Look.LEFT ? this.mLookLength : 0);
        int i4 = this.mShadowRadius;
        int i5 = this.mShadowY;
        this.mTop = i4 + (i5 < 0 ? -i5 : 0) + (this.mLook == Look.TOP ? this.mLookLength : 0);
        int i6 = this.mWidth - this.mShadowRadius;
        int i7 = this.mShadowX;
        this.mRight = (i6 + (i7 > 0 ? -i7 : 0)) - (this.mLook == Look.RIGHT ? this.mLookLength : 0);
        int i8 = this.mHeight - this.mShadowRadius;
        int i9 = this.mShadowY;
        int i10 = i8 + (i9 > 0 ? -i9 : 0);
        if (this.mLook == Look.BOTTOM) {
            i3 = this.mLookLength;
        }
        this.mBottom = i10 - i3;
        this.mPaint.setColor(this.mBubbleColor);
        this.mPath.reset();
        int i11 = this.mLookPosition;
        int i12 = this.mLookLength + i11;
        int i13 = this.mBottom;
        if (i12 > i13) {
            i11 = i13 - this.mLookWidth;
        }
        int max = Math.max(i11, this.mShadowRadius);
        int i14 = this.mLookPosition;
        int i15 = this.mLookLength + i14;
        int i16 = this.mRight;
        if (i15 > i16) {
            i14 = i16 - this.mLookWidth;
        }
        int max2 = Math.max(i14, this.mShadowRadius);
        Look look = this.mLook;
        int i17 = look == null ? -1 : WhenMappings.$EnumSwitchMapping$0[look.ordinal()];
        if (i17 == 1) {
            int ldr = getLDR();
            int i18 = this.mArrowDownRightRadius;
            if (max2 >= ldr + i18) {
                this.mPath.moveTo((float) (max2 - i18), (float) this.mBottom);
                Path path = this.mPath;
                int i19 = this.mArrowDownRightRadius;
                int i20 = this.mLookWidth;
                float f = ((float) i19) + ((((float) i20) / 2.0f) - ((float) this.mArrowTopRightRadius));
                int i21 = this.mLookLength;
                path.rCubicTo((float) i19, 0.0f, f, (float) i21, (((float) i20) / 2.0f) + ((float) i19), (float) i21);
            } else {
                this.mPath.moveTo(((float) max2) + (((float) this.mLookWidth) / 2.0f), (float) (this.mBottom + this.mLookLength));
            }
            int i22 = this.mLookWidth + max2;
            int rdr = this.mRight - getRDR();
            int i23 = this.mArrowDownLeftRadius;
            if (i22 < rdr - i23) {
                Path path2 = this.mPath;
                float f2 = (float) this.mArrowTopLeftRadius;
                int i24 = this.mLookWidth;
                int i25 = this.mLookLength;
                path2.rCubicTo(f2, 0.0f, ((float) i24) / 2.0f, -((float) i25), (((float) i24) / 2.0f) + ((float) i23), -((float) i25));
                this.mPath.lineTo((float) (this.mRight - getRDR()), (float) this.mBottom);
            }
            Path path3 = this.mPath;
            int i26 = this.mRight;
            int i27 = this.mBottom;
            path3.quadTo((float) i26, (float) i27, (float) i26, (float) (i27 - getRDR()));
            this.mPath.lineTo((float) this.mRight, (float) (this.mTop + getRTR()));
            Path path4 = this.mPath;
            int i28 = this.mRight;
            path4.quadTo((float) i28, (float) this.mTop, (float) (i28 - getRTR()), (float) this.mTop);
            this.mPath.lineTo((float) (this.mLeft + getLTR()), (float) this.mTop);
            Path path5 = this.mPath;
            int i29 = this.mLeft;
            int i30 = this.mTop;
            path5.quadTo((float) i29, (float) i30, (float) i29, (float) (i30 + getLTR()));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mBottom - getLDR()));
            if (max2 >= getLDR() + this.mArrowDownRightRadius) {
                Path path6 = this.mPath;
                int i31 = this.mLeft;
                path6.quadTo((float) i31, (float) this.mBottom, (float) (i31 + getLDR()), (float) this.mBottom);
            } else {
                int i32 = this.mBottom;
                this.mPath.quadTo((float) this.mLeft, (float) i32, ((float) max2) + (((float) this.mLookWidth) / 2.0f), (float) (i32 + this.mLookLength));
            }
        } else if (i17 == 2) {
            int ltr = getLTR();
            int i33 = this.mArrowDownLeftRadius;
            if (max2 >= ltr + i33) {
                this.mPath.moveTo((float) (max2 - i33), (float) this.mTop);
                Path path7 = this.mPath;
                int i34 = this.mArrowDownLeftRadius;
                int i35 = this.mLookWidth;
                float f3 = ((float) i34) + ((((float) i35) / 2.0f) - ((float) this.mArrowTopLeftRadius));
                int i36 = this.mLookLength;
                path7.rCubicTo((float) i34, 0.0f, f3, -((float) i36), (((float) i35) / 2.0f) + ((float) i34), -((float) i36));
            } else {
                this.mPath.moveTo(((float) max2) + (((float) this.mLookWidth) / 2.0f), (float) (this.mTop - this.mLookLength));
            }
            int i37 = this.mLookWidth + max2;
            int rtr = this.mRight - getRTR();
            int i38 = this.mArrowDownRightRadius;
            if (i37 < rtr - i38) {
                Path path8 = this.mPath;
                float f4 = (float) this.mArrowTopRightRadius;
                int i39 = this.mLookWidth;
                int i40 = this.mLookLength;
                path8.rCubicTo(f4, 0.0f, ((float) i39) / 2.0f, (float) i40, (((float) i39) / 2.0f) + ((float) i38), (float) i40);
                this.mPath.lineTo((float) (this.mRight - getRTR()), (float) this.mTop);
            }
            Path path9 = this.mPath;
            int i41 = this.mRight;
            int i42 = this.mTop;
            path9.quadTo((float) i41, (float) i42, (float) i41, (float) (i42 + getRTR()));
            this.mPath.lineTo((float) this.mRight, (float) (this.mBottom - getRDR()));
            Path path10 = this.mPath;
            int i43 = this.mRight;
            path10.quadTo((float) i43, (float) this.mBottom, (float) (i43 - getRDR()), (float) this.mBottom);
            this.mPath.lineTo((float) (this.mLeft + getLDR()), (float) this.mBottom);
            Path path11 = this.mPath;
            int i44 = this.mLeft;
            int i45 = this.mBottom;
            path11.quadTo((float) i44, (float) i45, (float) i44, (float) (i45 - getLDR()));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mTop + getLTR()));
            if (max2 >= getLTR() + this.mArrowDownLeftRadius) {
                Path path12 = this.mPath;
                int i46 = this.mLeft;
                path12.quadTo((float) i46, (float) this.mTop, (float) (i46 + getLTR()), (float) this.mTop);
            } else {
                int i47 = this.mTop;
                this.mPath.quadTo((float) this.mLeft, (float) i47, ((float) max2) + (((float) this.mLookWidth) / 2.0f), (float) (i47 - this.mLookLength));
            }
        } else if (i17 == 3) {
            int ltr2 = getLTR();
            int i48 = this.mArrowDownRightRadius;
            if (max >= ltr2 + i48) {
                this.mPath.moveTo((float) this.mLeft, (float) (max - i48));
                Path path13 = this.mPath;
                int i49 = this.mArrowDownRightRadius;
                int i50 = this.mLookLength;
                int i51 = this.mLookWidth;
                path13.rCubicTo(0.0f, (float) i49, -((float) i50), ((((float) i51) / 2.0f) - ((float) this.mArrowTopRightRadius)) + ((float) i49), -((float) i50), (((float) i51) / 2.0f) + ((float) i49));
            } else {
                this.mPath.moveTo((float) (this.mLeft - this.mLookLength), ((float) max) + (((float) this.mLookWidth) / 2.0f));
            }
            int i52 = this.mLookWidth + max;
            int ldr2 = this.mBottom - getLDR();
            int i53 = this.mArrowDownLeftRadius;
            if (i52 < ldr2 - i53) {
                Path path14 = this.mPath;
                float f5 = (float) this.mArrowTopLeftRadius;
                int i54 = this.mLookLength;
                int i55 = this.mLookWidth;
                path14.rCubicTo(0.0f, f5, (float) i54, ((float) i55) / 2.0f, (float) i54, (((float) i55) / 2.0f) + ((float) i53));
                this.mPath.lineTo((float) this.mLeft, (float) (this.mBottom - getLDR()));
            }
            Path path15 = this.mPath;
            int i56 = this.mLeft;
            path15.quadTo((float) i56, (float) this.mBottom, (float) (i56 + getLDR()), (float) this.mBottom);
            this.mPath.lineTo((float) (this.mRight - getRDR()), (float) this.mBottom);
            Path path16 = this.mPath;
            int i57 = this.mRight;
            int i58 = this.mBottom;
            path16.quadTo((float) i57, (float) i58, (float) i57, (float) (i58 - getRDR()));
            this.mPath.lineTo((float) this.mRight, (float) (this.mTop + getRTR()));
            Path path17 = this.mPath;
            int i59 = this.mRight;
            path17.quadTo((float) i59, (float) this.mTop, (float) (i59 - getRTR()), (float) this.mTop);
            this.mPath.lineTo((float) (this.mLeft + getLTR()), (float) this.mTop);
            if (max >= getLTR() + this.mArrowDownRightRadius) {
                Path path18 = this.mPath;
                int i60 = this.mLeft;
                int i61 = this.mTop;
                path18.quadTo((float) i60, (float) i61, (float) i60, (float) (i61 + getLTR()));
            } else {
                Path path19 = this.mPath;
                int i62 = this.mLeft;
                path19.quadTo((float) i62, (float) this.mTop, (float) (i62 - this.mLookLength), ((float) max) + (((float) this.mLookWidth) / 2.0f));
            }
        } else if (i17 == 4) {
            int rtr2 = getRTR();
            int i63 = this.mArrowDownLeftRadius;
            if (max >= rtr2 + i63) {
                this.mPath.moveTo((float) this.mRight, (float) (max - i63));
                Path path20 = this.mPath;
                int i64 = this.mArrowDownLeftRadius;
                int i65 = this.mLookLength;
                int i66 = this.mLookWidth;
                path20.rCubicTo(0.0f, (float) i64, (float) i65, ((((float) i66) / 2.0f) - ((float) this.mArrowTopLeftRadius)) + ((float) i64), (float) i65, (((float) i66) / 2.0f) + ((float) i64));
            } else {
                this.mPath.moveTo((float) (this.mRight + this.mLookLength), ((float) max) + (((float) this.mLookWidth) / 2.0f));
            }
            int i67 = this.mLookWidth + max;
            int rdr2 = this.mBottom - getRDR();
            int i68 = this.mArrowDownRightRadius;
            if (i67 < rdr2 - i68) {
                Path path21 = this.mPath;
                float f6 = (float) this.mArrowTopRightRadius;
                int i69 = this.mLookLength;
                int i70 = this.mLookWidth;
                path21.rCubicTo(0.0f, f6, -((float) i69), ((float) i70) / 2.0f, -((float) i69), (((float) i70) / 2.0f) + ((float) i68));
                this.mPath.lineTo((float) this.mRight, (float) (this.mBottom - getRDR()));
            }
            Path path22 = this.mPath;
            int i71 = this.mRight;
            path22.quadTo((float) i71, (float) this.mBottom, (float) (i71 - getRDR()), (float) this.mBottom);
            this.mPath.lineTo((float) (this.mLeft + getLDR()), (float) this.mBottom);
            Path path23 = this.mPath;
            int i72 = this.mLeft;
            int i73 = this.mBottom;
            path23.quadTo((float) i72, (float) i73, (float) i72, (float) (i73 - getLDR()));
            this.mPath.lineTo((float) this.mLeft, (float) (this.mTop + getLTR()));
            Path path24 = this.mPath;
            int i74 = this.mLeft;
            path24.quadTo((float) i74, (float) this.mTop, (float) (i74 + getLTR()), (float) this.mTop);
            this.mPath.lineTo((float) (this.mRight - getRTR()), (float) this.mTop);
            if (max >= getRTR() + this.mArrowDownLeftRadius) {
                Path path25 = this.mPath;
                int i75 = this.mRight;
                int i76 = this.mTop;
                path25.quadTo((float) i75, (float) i76, (float) i75, (float) (i76 + getRTR()));
            } else {
                Path path26 = this.mPath;
                int i77 = this.mRight;
                path26.quadTo((float) i77, (float) this.mTop, (float) (i77 + this.mLookLength), ((float) max) + (((float) this.mLookWidth) / 2.0f));
            }
        }
        this.mPath.close();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
        Bitmap bitmap = this.mBubbleImageBg;
        if (bitmap != null && bitmap.getHeight() > 0) {
            this.mPath.computeBounds(this.mBubbleImageBgDstRectF, true);
            int saveLayer = canvas.saveLayer(this.mBubbleImageBgDstRectF, (Paint) null, 31);
            canvas.drawPath(this.mPath, this.mBubbleImageBgBeforePaint);
            float width = this.mBubbleImageBgDstRectF.width() / this.mBubbleImageBgDstRectF.height();
            if (width > (((float) bitmap.getWidth()) * 1.0f) / ((float) bitmap.getHeight())) {
                int height = (int) ((((float) bitmap.getHeight()) - (((float) bitmap.getWidth()) / width)) / ((float) 2));
                this.mBubbleImageBgSrcRect.set(0, height, bitmap.getWidth(), ((int) (((float) bitmap.getWidth()) / width)) + height);
            } else {
                int width2 = (int) ((((float) bitmap.getWidth()) - (((float) bitmap.getHeight()) * width)) / ((float) 2));
                this.mBubbleImageBgSrcRect.set(width2, 0, ((int) (((float) bitmap.getHeight()) * width)) + width2, bitmap.getHeight());
            }
            canvas.drawBitmap(bitmap, this.mBubbleImageBgSrcRect, this.mBubbleImageBgDstRectF, this.mBubbleImageBgPaint);
            canvas.restoreToCount(saveLayer);
        }
        if (this.mBubbleBorderSize != 0) {
            canvas.drawPath(this.mPath, this.mBubbleBorderPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnClickEdgeListener onClickEdgeListener;
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            this.mPath.computeBounds(rectF, true);
            this.mRegion.setPath(this.mPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (!(this.mRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY()) || (onClickEdgeListener = this.mListener) == null || onClickEdgeListener == null)) {
                onClickEdgeListener.edge();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public final Path getPath() {
        return this.mPath;
    }

    public final Look getLook() {
        return this.mLook;
    }

    public final int getLookPosition() {
        return this.mLookPosition;
    }

    public final int getLookWidth() {
        return this.mLookWidth;
    }

    public final int getLookLength() {
        return this.mLookLength;
    }

    public final int getShadowColor() {
        return this.mShadowColor;
    }

    public final int getShadowRadius() {
        return this.mShadowRadius;
    }

    public final int getShadowX() {
        return this.mShadowX;
    }

    public final int getShadowY() {
        return this.mShadowY;
    }

    public final int getBubbleRadius() {
        return this.mBubbleRadius;
    }

    public final int getBubbleColor() {
        return this.mBubbleColor;
    }

    public final void setBubbleColor(int i) {
        this.mBubbleColor = i;
    }

    public final void setLook(Look look) {
        this.mLook = look;
        initPadding();
    }

    public final void setLookPosition(int i) {
        this.mLookPosition = i;
    }

    public final void setLookWidth(int i) {
        this.mLookWidth = i;
    }

    public final void setLookLength(int i) {
        this.mLookLength = i;
        initPadding();
    }

    public final void setShadowColor(int i) {
        this.mShadowColor = i;
    }

    public final void setShadowRadius(int i) {
        this.mShadowRadius = i;
    }

    public final void setShadowX(int i) {
        this.mShadowX = i;
    }

    public final void setShadowY(int i) {
        this.mShadowY = i;
    }

    public final void setBubbleRadius(int i) {
        this.mBubbleRadius = i;
    }

    public final int getLTR() {
        int i = this.mLTR;
        return i == -1 ? this.mBubbleRadius : i;
    }

    public final void setLTR(int i) {
        this.mLTR = i;
    }

    public final int getRTR() {
        int i = this.mRTR;
        return i == -1 ? this.mBubbleRadius : i;
    }

    public final void setRTR(int i) {
        this.mRTR = i;
    }

    public final int getRDR() {
        int i = this.mRDR;
        return i == -1 ? this.mBubbleRadius : i;
    }

    public final void setRDR(int i) {
        this.mRDR = i;
    }

    public final int getLDR() {
        int i = this.mLDR;
        return i == -1 ? this.mBubbleRadius : i;
    }

    public final void setLDR(int i) {
        this.mLDR = i;
    }

    public final int getArrowTopLeftRadius() {
        return this.mArrowTopLeftRadius;
    }

    public final void setArrowTopLeftRadius(int i) {
        this.mArrowTopLeftRadius = i;
    }

    public final int getArrowTopRightRadius() {
        return this.mArrowTopRightRadius;
    }

    public final void setArrowTopRightRadius(int i) {
        this.mArrowTopRightRadius = i;
    }

    public final int getArrowDownLeftRadius() {
        return this.mArrowDownLeftRadius;
    }

    public final void setArrowDownLeftRadius(int i) {
        this.mArrowDownLeftRadius = i;
    }

    public final int getArrowDownRightRadius() {
        return this.mArrowDownRightRadius;
    }

    public final void setArrowDownRightRadius(int i) {
        this.mArrowDownRightRadius = i;
    }

    public final void setBubblePadding(int i) {
        this.mBubblePadding = i;
    }

    public final void setBubbleImageBg(Bitmap bitmap) {
        this.mBubbleImageBg = bitmap;
    }

    public final void setBubbleImageBgRes(int i) {
        this.mBubbleImageBg = BitmapFactoryInstrumentation.decodeResource(getResources(), i);
    }

    public final void setBubbleBorderSize(int i) {
        this.mBubbleBorderSize = i;
    }

    public final void setBubbleBorderColor(int i) {
        this.mBubbleBorderColor = i;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.mLookPosition);
        bundle.putInt("mLookWidth", this.mLookWidth);
        bundle.putInt("mLookLength", this.mLookLength);
        bundle.putInt("mShadowColor", this.mShadowColor);
        bundle.putInt("mShadowRadius", this.mShadowRadius);
        bundle.putInt("mShadowX", this.mShadowX);
        bundle.putInt("mShadowY", this.mShadowY);
        bundle.putInt("mBubbleRadius", this.mBubbleRadius);
        bundle.putInt("mLTR", this.mLTR);
        bundle.putInt("mRTR", this.mRTR);
        bundle.putInt("mRDR", this.mRDR);
        bundle.putInt("mLDR", this.mLDR);
        bundle.putInt("mBubblePadding", this.mBubblePadding);
        bundle.putInt("mArrowTopLeftRadius", this.mArrowTopLeftRadius);
        bundle.putInt("mArrowTopRightRadius", this.mArrowTopRightRadius);
        bundle.putInt("mArrowDownLeftRadius", this.mArrowDownLeftRadius);
        bundle.putInt("mArrowDownRightRadius", this.mArrowDownRightRadius);
        bundle.putInt("mWidth", this.mWidth);
        bundle.putInt("mHeight", this.mHeight);
        bundle.putInt("mLeft", this.mLeft);
        bundle.putInt("mTop", this.mTop);
        bundle.putInt("mRight", this.mRight);
        bundle.putInt("mBottom", this.mBottom);
        bundle.putInt("mBubbleBgRes", this.mBubbleBgRes);
        bundle.putInt("mBubbleBorderColor", this.mBubbleBorderColor);
        bundle.putInt("mBubbleBorderSize", this.mBubbleBorderSize);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mLookPosition = bundle.getInt("mLookPosition");
            this.mLookWidth = bundle.getInt("mLookWidth");
            this.mLookLength = bundle.getInt("mLookLength");
            this.mShadowColor = bundle.getInt("mShadowColor");
            this.mShadowRadius = bundle.getInt("mShadowRadius");
            this.mShadowX = bundle.getInt("mShadowX");
            this.mShadowY = bundle.getInt("mShadowY");
            this.mBubbleRadius = bundle.getInt("mBubbleRadius");
            this.mLTR = bundle.getInt("mLTR");
            this.mRTR = bundle.getInt("mRTR");
            this.mRDR = bundle.getInt("mRDR");
            this.mLDR = bundle.getInt("mLDR");
            this.mBubblePadding = bundle.getInt("mBubblePadding");
            this.mArrowTopLeftRadius = bundle.getInt("mArrowTopLeftRadius");
            this.mArrowTopRightRadius = bundle.getInt("mArrowTopRightRadius");
            this.mArrowDownLeftRadius = bundle.getInt("mArrowDownLeftRadius");
            this.mArrowDownRightRadius = bundle.getInt("mArrowDownRightRadius");
            this.mWidth = bundle.getInt("mWidth");
            this.mHeight = bundle.getInt("mHeight");
            this.mLeft = bundle.getInt("mLeft");
            this.mTop = bundle.getInt("mTop");
            this.mRight = bundle.getInt("mRight");
            this.mBottom = bundle.getInt("mBottom");
            int i = bundle.getInt("mBubbleBgRes");
            this.mBubbleBgRes = i;
            if (i != -1) {
                this.mBubbleImageBg = BitmapFactoryInstrumentation.decodeResource(getResources(), this.mBubbleBgRes);
            }
            this.mBubbleBorderSize = bundle.getInt("mBubbleBorderSize");
            this.mBubbleBorderColor = bundle.getInt("mBubbleBorderColor");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final void setOnClickEdgeListener(OnClickEdgeListener onClickEdgeListener) {
        this.mListener = onClickEdgeListener;
    }
}
