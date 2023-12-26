package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00029:B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0012\u0010'\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0003J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010-\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0017J\u0010\u00102\u001a\u00020\u001b2\b\b\u0001\u00103\u001a\u00020\nJ\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\rH\u0002J\u0010\u00106\u001a\u00020\u001b2\b\b\u0001\u00103\u001a\u00020\nJ\u0010\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasFocus", "", "mClearDrawableResId", "mClearDrawableSize", "", "mClearEnable", "mCustomTextWatcher", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "mLeftDrawable", "Landroid/graphics/drawable/Drawable;", "mLeftDrawableResId", "mLeftDrawableSize", "mOnFocusListener", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "addCustomTextWatcher", "", "watcher", "afterTextChanged", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "dp2px", "dpValue", "init", "initClearIcon", "initLeftIcon", "onFocusChange", "v", "Landroid/view/View;", "onTextChanged", "before", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setClearDrawable", "resId", "setClearIconVisible", "visible", "setLeftIconResource", "setOnFocusListener", "listener", "CustomTextWatcher", "OnFocusListener", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearEditText.kt */
public final class ClearEditText extends AppCompatEditText implements View.OnFocusChangeListener, TextWatcher {
    private boolean hasFocus;
    private int mClearDrawableResId = R.drawable.icon_edit_clear;
    private float mClearDrawableSize;
    private boolean mClearEnable;
    private CustomTextWatcher mCustomTextWatcher;
    private Drawable mLeftDrawable;
    private int mLeftDrawableResId;
    private float mLeftDrawableSize;
    private OnFocusListener mOnFocusListener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearEditText.kt */
    public interface CustomTextWatcher {
        void afterTextChanged(Editable editable);

        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "", "onFocusChange", "", "v", "Landroid/view/View;", "hasFocus", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearEditText.kt */
    public interface OnFocusListener {
        void onFocusChange(View view, boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        init(attributeSet);
    }

    private final void init(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            this.mClearDrawableSize = dp2px(20.0f);
            this.mLeftDrawableSize = dp2px(20.0f);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ClearEditText);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….styleable.ClearEditText)");
                this.mClearDrawableResId = obtainStyledAttributes.getResourceId(R.styleable.ClearEditText_clear_drawable, this.mClearDrawableResId);
                this.mClearDrawableSize = obtainStyledAttributes.getDimension(R.styleable.ClearEditText_clear_size, dp2px(20.0f));
                this.mLeftDrawableResId = obtainStyledAttributes.getResourceId(R.styleable.ClearEditText_left_drawable, -1);
                this.mLeftDrawableSize = obtainStyledAttributes.getDimension(R.styleable.ClearEditText_left_size, dp2px(20.0f));
                obtainStyledAttributes.recycle();
            }
            initClearIcon();
            initLeftIcon();
            setOnFocusChangeListener(this);
            addTextChangedListener(this);
            setCompoundDrawablePadding(8);
        }
    }

    private final float dp2px(float f) {
        return (float) SizeUtils.dp2px(f);
    }

    public final void setClearDrawable(int i) {
        this.mClearDrawableResId = i;
        invalidate();
    }

    public final void setOnFocusListener(OnFocusListener onFocusListener) {
        this.mOnFocusListener = onFocusListener;
    }

    public final void addCustomTextWatcher(CustomTextWatcher customTextWatcher) {
        this.mCustomTextWatcher = customTextWatcher;
    }

    private final void initClearIcon() {
        Drawable drawable = getCompoundDrawables()[2];
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(getContext(), this.mClearDrawableResId);
        }
        Intrinsics.checkNotNull(drawable);
        float f = this.mClearDrawableSize;
        drawable.setBounds(0, 0, (int) f, (int) f);
        if (!this.mClearEnable) {
            drawable = null;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
    }

    private final void initLeftIcon() {
        if (this.mLeftDrawableResId > 0) {
            Drawable drawable = getCompoundDrawables()[0];
            this.mLeftDrawable = drawable;
            if (drawable == null) {
                this.mLeftDrawable = ContextCompat.getDrawable(getContext(), this.mLeftDrawableResId);
            }
            Drawable drawable2 = this.mLeftDrawable;
            Intrinsics.checkNotNull(drawable2);
            float f = this.mLeftDrawableSize;
            drawable2.setBounds(0, 0, (int) f, (int) f);
        }
        Drawable drawable3 = this.mLeftDrawable;
        if (drawable3 == null) {
            drawable3 = null;
        }
        setCompoundDrawables(drawable3, getCompoundDrawables()[1], getCompoundDrawables()[2], getCompoundDrawables()[3]);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        boolean z = true;
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
            if (motionEvent.getX() <= ((float) (getWidth() - getTotalPaddingRight())) || motionEvent.getX() >= ((float) (getWidth() - getPaddingRight()))) {
                z = false;
            }
            if (z) {
                setText("");
            }
        }
        return ClearEditText.super.onTouchEvent(motionEvent);
    }

    public void onFocusChange(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.hasFocus = z;
        OnFocusListener onFocusListener = this.mOnFocusListener;
        if (onFocusListener != null) {
            Intrinsics.checkNotNull(onFocusListener);
            onFocusListener.onFocusChange(view, z);
        }
        boolean z2 = false;
        if (z) {
            Editable text = getText();
            Intrinsics.checkNotNull(text);
            Intrinsics.checkNotNullExpressionValue(text, "text!!");
            if (text.length() > 0) {
                z2 = true;
            }
            setClearIconVisible(z2);
            return;
        }
        setClearIconVisible(false);
    }

    public final void setLeftIconResource(int i) {
        this.mLeftDrawableResId = i;
        initLeftIcon();
    }

    private final void setClearIconVisible(boolean z) {
        this.mClearEnable = z;
        initClearIcon();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        CustomTextWatcher customTextWatcher = this.mCustomTextWatcher;
        if (customTextWatcher != null) {
            Intrinsics.checkNotNull(customTextWatcher);
            customTextWatcher.beforeTextChanged(charSequence, i, i2, i2);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        CustomTextWatcher customTextWatcher = this.mCustomTextWatcher;
        if (customTextWatcher != null) {
            Intrinsics.checkNotNull(customTextWatcher);
            customTextWatcher.onTextChanged(charSequence, i, i2, i3);
        }
        if (this.hasFocus) {
            setClearIconVisible(charSequence.length() > 0);
        }
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        CustomTextWatcher customTextWatcher = this.mCustomTextWatcher;
        if (customTextWatcher != null) {
            Intrinsics.checkNotNull(customTextWatcher);
            customTextWatcher.afterTextChanged(editable);
        }
    }
}
