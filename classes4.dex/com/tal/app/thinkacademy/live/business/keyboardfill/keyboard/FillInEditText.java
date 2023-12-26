package com.tal.app.thinkacademy.live.business.keyboardfill.keyboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bH\u0004R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/FillInEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/view/View$OnFocusChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "falg", "", "mClearDrawable", "Landroid/graphics/drawable/Drawable;", "onFocusChange", "", "v", "Landroid/view/View;", "hasFocus", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setClearIconVisible", "visible", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FillInEditText.kt */
public final class FillInEditText extends AppCompatEditText implements View.OnFocusChangeListener {
    private boolean falg;
    private final Drawable mClearDrawable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FillInEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FillInEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FillInEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842862 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FillInEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setClearIconVisible(true);
        setOnFocusChangeListener(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null && motionEvent.getX() > ((float) (getWidth() - getTotalPaddingRight())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()))) {
            setText("");
        }
        return FillInEditText.super.onTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if ((r3 == null || r3.length() == 0) == false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFocusChange(android.view.View r2, boolean r3) {
        /*
            r1 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.falg = r3
            r2 = 1
            r0 = 0
            if (r3 == 0) goto L_0x0020
            android.text.Editable r3 = r1.getText()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x001c
            int r3 = r3.length()
            if (r3 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r2
        L_0x001d:
            if (r3 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r2 = r0
        L_0x0021:
            r1.setClearIconVisible(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText.onFocusChange(android.view.View, boolean):void");
    }

    /* access modifiers changed from: protected */
    public final void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.mClearDrawable : null, getCompoundDrawables()[3]);
    }
}
