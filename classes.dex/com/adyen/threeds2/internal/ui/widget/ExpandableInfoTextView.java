package com.adyen.threeds2.internal.ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final class ExpandableInfoTextView extends LinearLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private final View a;
    private final ImageView b;
    private final TextView c;
    private final TextView d;
    private final DividerView e;
    private float f;
    private int g;
    private b h;

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
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b[] r0 = com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b r1 = com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView.b.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b r1 = com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView.b.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView.a.<clinit>():void");
        }
    }

    public enum b {
        EXPANDED,
        COLLAPSED
    }

    public ExpandableInfoTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setState(b bVar) {
        this.h = bVar;
    }

    public void a(boolean z) {
        if (this.h != b.COLLAPSED) {
            if (z) {
                this.b.animate().rotation(0.0f).start();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.d.getHeight(), 0});
                ofInt.addUpdateListener(this);
                ofInt.addListener(this);
                ofInt.start();
                this.d.animate().alpha(0.0f).start();
                return;
            }
            this.b.setRotation(0.0f);
            this.d.setHeight(0);
            this.d.setAlpha(0.0f);
            setState(b.COLLAPSED);
        }
    }

    public void b(boolean z) {
        if (this.h != b.EXPANDED) {
            if (z) {
                this.b.animate().rotation(180.0f).start();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.g});
                ofInt.addUpdateListener(this);
                ofInt.addListener(this);
                ofInt.start();
                this.d.animate().alpha(this.f).start();
                return;
            }
            this.b.setRotation(180.0f);
            this.d.setHeight(this.g);
            this.d.setAlpha(this.f);
            setState(b.EXPANDED);
        }
    }

    public void c(boolean z) {
        int i = a.a[getState().ordinal()];
        if (i == 1) {
            a(z);
        } else if (i == 2) {
            b(z);
        }
    }

    public b getState() {
        return this.h;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        b bVar = this.h;
        b bVar2 = b.COLLAPSED;
        if (bVar == bVar2) {
            bVar2 = b.EXPANDED;
        }
        setState(bVar2);
        this.a.setClickable(true);
        if (this.h == b.COLLAPSED) {
            this.a.sendAccessibilityEvent(8);
        } else {
            this.d.sendAccessibilityEvent(8);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.setClickable(false);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ExpandableInfoTextView.class);
        c(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void onGlobalLayout() {
        this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f = this.d.getAlpha();
        this.g = this.d.getMeasuredHeight();
        c(false);
    }

    public void setHeaderBackgroundColor(int i) {
        Drawable background = this.a.getBackground();
        if (Build.VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        } else {
            ((RippleDrawable) background).setColor(ColorStateList.valueOf(i));
        }
    }

    public void setHorizontalDividerColor(int i) {
        this.e.setColor(i);
    }

    public void setHorizontalDividerThickness(int i) {
        this.e.setThickness(i);
    }

    public void setInfo(String str) {
        this.d.setText(str);
    }

    public void setInfoFontSize(Integer num) {
        this.d.setTextSize((float) num.intValue());
    }

    public void setInfoTextColor(int i) {
        this.d.setTextColor(i);
    }

    public void setInfoTypeface(Typeface typeface) {
        this.d.setTypeface(typeface);
    }

    public void setStateIndicatorColor(int i) {
        this.b.setColorFilter(i);
    }

    public void setTitle(String str) {
        this.c.setText(str);
    }

    public void setTitleFontSize(Integer num) {
        this.c.setTextSize((float) num.intValue());
    }

    public void setTitleTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.c.setTypeface(typeface);
    }

    public ExpandableInfoTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableInfoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = b.EXPANDED;
        LinearLayout.inflate(context, R.layout.a3ds2_widget_expandable_info_text, this);
        View findViewById = findViewById(R.id.viewGroup_header);
        this.a = findViewById;
        findViewById.setOnClickListener(this);
        this.b = (ImageView) findViewById(R.id.imageView_stateIndicator);
        this.c = (TextView) findViewById(R.id.textView_title);
        TextView textView = (TextView) findViewById(R.id.textView_info);
        this.d = textView;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.e = (DividerView) findViewById(R.id.dividerView_info);
    }
}
