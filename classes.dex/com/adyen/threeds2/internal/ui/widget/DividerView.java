package com.adyen.threeds2.internal.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.adyen.threeds2.R;

public final class DividerView extends View {
    private static final b d = b.HORIZONTAL;
    private b a;
    private int b;
    private int c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.internal.ui.widget.DividerView$b[] r0 = com.adyen.threeds2.internal.ui.widget.DividerView.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.ui.widget.DividerView.b.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.ui.widget.DividerView.b.VERTICAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.ui.widget.DividerView.a.<clinit>():void");
        }
    }

    public enum b {
        HORIZONTAL,
        VERTICAL
    }

    public DividerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(TypedArray typedArray) {
        setColor(typedArray.getColor(R.styleable.DividerView_dividerColor, getDefaultColor()));
        setThickness((int) typedArray.getDimension(R.styleable.DividerView_dividerThickness, (float) getDefaultThickness()));
        setOrientation(b.values()[typedArray.getInteger(R.styleable.DividerView_dividerOrientation, d.ordinal())]);
    }

    private int getDefaultColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16842808, typedValue, true);
        return typedValue.data;
    }

    private int getDefaultThickness() {
        return (int) getContext().getResources().getDimension(R.dimen.a3ds2_divider_thickness);
    }

    public int getColor() {
        return this.c;
    }

    public b getOrientation() {
        return this.a;
    }

    public int getThickness() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        if (this.b > 0) {
            int i3 = a.a[this.a.ordinal()];
            if (i3 == 1) {
                defaultSize2 = this.b;
            } else if (i3 == 2) {
                defaultSize = this.b;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setColor(int i) {
        this.c = i;
        setBackgroundColor(i);
    }

    public void setOrientation(b bVar) {
        this.a = bVar;
    }

    public void setThickness(int i) {
        this.b = i;
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, i, 0);
        try {
            a(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public DividerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DividerView, i, i2);
        try {
            a(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
