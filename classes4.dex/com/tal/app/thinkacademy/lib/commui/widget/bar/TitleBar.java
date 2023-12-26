package com.tal.app.thinkacademy.lib.commui.widget.bar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.BaseTitleBarStyle;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.TitleBarLightStyle;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.TitleBarNightStyle;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.TitleBarRippleStyle;
import com.tal.app.thinkacademy.lib.commui.widget.bar.style.TitleBarTransparentStyle;

public class TitleBar extends FrameLayout implements View.OnClickListener, Runnable {
    private static ITitleBarStyle sDefaultStyle;
    private ITitleBarStyle mCurrentStyle;
    private boolean mInitialize;
    private TextView mLeftView;
    private View mLineView;
    private OnTitleBarListener mListener;
    private LinearLayout mMainLayout;
    private TextView mRightView;
    private TextView mTitleView;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public TitleBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CharSequence title;
        this.mMainLayout = ViewCore.newMainLayout(context);
        this.mLineView = ViewCore.newLineView(context);
        this.mLeftView = ViewCore.newLeftView(context);
        this.mTitleView = ViewCore.newTitleView(context);
        this.mRightView = ViewCore.newRightView(context);
        this.mLeftView.setEnabled(false);
        this.mTitleView.setEnabled(false);
        this.mRightView.setEnabled(false);
        if (sDefaultStyle == null) {
            sDefaultStyle = new TitleBarLightStyle(getContext().getApplicationContext());
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TitleBar);
        int i2 = obtainStyledAttributes.getInt(R.styleable.TitleBar_barStyle, 0);
        if (i2 == 16) {
            this.mCurrentStyle = new TitleBarLightStyle(getContext());
        } else if (i2 == 32) {
            this.mCurrentStyle = new TitleBarNightStyle(getContext());
        } else if (i2 == 48) {
            this.mCurrentStyle = new TitleBarTransparentStyle(getContext());
        } else if (i2 != 64) {
            this.mCurrentStyle = sDefaultStyle;
        } else {
            this.mCurrentStyle = new TitleBarRippleStyle(getContext());
        }
        setChildPadding(sDefaultStyle.getChildPadding());
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_leftTitle)) {
            setLeftTitle((CharSequence) obtainStyledAttributes.getString(R.styleable.TitleBar_leftTitle));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_title)) {
            setTitle((CharSequence) obtainStyledAttributes.getString(R.styleable.TitleBar_title));
        } else if ((getContext() instanceof Activity) && (title = ((Activity) getContext()).getTitle()) != null && !"".equals(title.toString())) {
            try {
                PackageManager packageManager = getContext().getPackageManager();
                if (!title.toString().equals(packageManager.getPackageInfo(getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString())) {
                    setTitle(title);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_rightTitle)) {
            setRightTitle((CharSequence) obtainStyledAttributes.getString(R.styleable.TitleBar_rightTitle));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_leftIcon)) {
            setLeftIcon(ViewCore.getDrawable(getContext(), obtainStyledAttributes.getResourceId(R.styleable.TitleBar_leftIcon, 0)));
        } else {
            if (obtainStyledAttributes.getBoolean(R.styleable.TitleBar_backButton, this.mCurrentStyle.getBackIcon() != null)) {
                setLeftIcon(this.mCurrentStyle.getBackIcon());
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_rightIcon)) {
            setRightIcon(ViewCore.getDrawable(getContext(), obtainStyledAttributes.getResourceId(R.styleable.TitleBar_rightIcon, 0)));
        }
        setLeftColor(obtainStyledAttributes.getColor(R.styleable.TitleBar_leftColor, this.mCurrentStyle.getLeftColor()));
        setTitleColor(obtainStyledAttributes.getColor(R.styleable.TitleBar_titleColor, this.mCurrentStyle.getTitleColor()));
        setRightColor(obtainStyledAttributes.getColor(R.styleable.TitleBar_rightColor, this.mCurrentStyle.getRightColor()));
        setLeftSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TitleBar_leftSize, (int) this.mCurrentStyle.getLeftSize()));
        setTitleSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TitleBar_titleSize, (int) this.mCurrentStyle.getTitleSize()));
        setRightSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TitleBar_rightSize, (int) this.mCurrentStyle.getRightSize()));
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_leftBackground)) {
            setLeftBackground(obtainStyledAttributes.getDrawable(R.styleable.TitleBar_leftBackground));
        } else {
            setLeftBackground(this.mCurrentStyle.getLeftBackground());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_rightBackground)) {
            setRightBackground(obtainStyledAttributes.getDrawable(R.styleable.TitleBar_rightBackground));
        } else {
            setRightBackground(this.mCurrentStyle.getRightBackground());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TitleBar_lineColor)) {
            setLineDrawable(obtainStyledAttributes.getDrawable(R.styleable.TitleBar_lineColor));
        } else {
            setLineDrawable(this.mCurrentStyle.getLineDrawable());
        }
        setTitleGravity(obtainStyledAttributes.getInt(R.styleable.TitleBar_titleGravity, this.mCurrentStyle.getTitleGravity()));
        setLineVisible(obtainStyledAttributes.getBoolean(R.styleable.TitleBar_lineVisible, this.mCurrentStyle.isLineVisible()));
        setLineSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TitleBar_lineSize, this.mCurrentStyle.getLineSize()));
        setDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TitleBar_android_drawablePadding, this.mCurrentStyle.getDrawablePadding()));
        obtainStyledAttributes.recycle();
        if (getBackground() == null) {
            ViewCore.setBackground(this, this.mCurrentStyle.getBackground());
        }
        this.mMainLayout.addView(this.mLeftView);
        this.mMainLayout.addView(this.mTitleView);
        this.mMainLayout.addView(this.mRightView);
        addView(this.mMainLayout, 0);
        addView(this.mLineView, 1);
        this.mInitialize = true;
        post(this);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams.width == -2) {
            layoutParams.width = -1;
        }
        if (layoutParams.height == -2) {
            this.mMainLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mCurrentStyle.getTitleBarHeight()));
        }
        super.setLayoutParams(layoutParams);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new FrameLayout.LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new FrameLayout.LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof FrameLayout.LayoutParams;
    }

    public void run() {
        int width;
        int width2;
        if (this.mInitialize) {
            if (!((this.mTitleView.getGravity() & 1) == 0 || (width = this.mLeftView.getWidth()) == (width2 = this.mRightView.getWidth()))) {
                if (width > width2) {
                    this.mTitleView.setPadding(0, 0, width - width2, 0);
                } else {
                    this.mTitleView.setPadding(width2 - width, 0, 0, 0);
                }
            }
            TextView textView = this.mLeftView;
            textView.setEnabled(ViewCore.hasTextViewContent(textView));
            TextView textView2 = this.mTitleView;
            textView2.setEnabled(ViewCore.hasTextViewContent(textView2));
            TextView textView3 = this.mRightView;
            textView3.setEnabled(ViewCore.hasTextViewContent(textView3));
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, TitleBar.class);
        OnTitleBarListener onTitleBarListener = this.mListener;
        if (onTitleBarListener == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
            return;
        }
        if (view == this.mLeftView) {
            onTitleBarListener.onLeftClick(view);
        } else if (view == this.mRightView) {
            onTitleBarListener.onRightClick(view);
        } else if (view == this.mTitleView) {
            onTitleBarListener.onTitleClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public TitleBar setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        this.mListener = onTitleBarListener;
        this.mTitleView.setOnClickListener(this);
        this.mLeftView.setOnClickListener(this);
        this.mRightView.setOnClickListener(this);
        return this;
    }

    public TitleBar setTitle(int i) {
        return setTitle((CharSequence) getResources().getString(i));
    }

    public TitleBar setTitle(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
        post(this);
        return this;
    }

    public CharSequence getTitle() {
        return this.mTitleView.getText();
    }

    public TitleBar setLeftTitle(int i) {
        return setLeftTitle((CharSequence) getResources().getString(i));
    }

    public TitleBar setLeftTitle(CharSequence charSequence) {
        this.mLeftView.setText(charSequence);
        post(this);
        return this;
    }

    public CharSequence getLeftTitle() {
        return this.mLeftView.getText();
    }

    public TitleBar setRightTitle(int i) {
        return setRightTitle((CharSequence) getResources().getString(i));
    }

    public TitleBar setRightTitle(CharSequence charSequence) {
        this.mRightView.setText(charSequence);
        post(this);
        return this;
    }

    public CharSequence getRightTitle() {
        return this.mRightView.getText();
    }

    public TitleBar setLeftIcon(int i) {
        return setLeftIcon(ViewCore.getDrawable(getContext(), i));
    }

    public TitleBar setLeftIcon(Drawable drawable) {
        this.mLeftView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        post(this);
        return this;
    }

    public Drawable getLeftIcon() {
        return this.mLeftView.getCompoundDrawables()[0];
    }

    public TitleBar setRightIcon(int i) {
        return setRightIcon(ViewCore.getDrawable(getContext(), i));
    }

    public TitleBar setRightIcon(Drawable drawable) {
        this.mRightView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        post(this);
        return this;
    }

    public Drawable getRightIcon() {
        return this.mRightView.getCompoundDrawables()[2];
    }

    public TitleBar setLeftColor(int i) {
        this.mLeftView.setTextColor(i);
        return this;
    }

    public TitleBar setTitleColor(int i) {
        this.mTitleView.setTextColor(i);
        return this;
    }

    public TitleBar setRightColor(int i) {
        this.mRightView.setTextColor(i);
        return this;
    }

    public TitleBar setLeftBackground(int i) {
        return setLeftBackground(ViewCore.getDrawable(getContext(), i));
    }

    public TitleBar setLeftBackground(Drawable drawable) {
        ViewCore.setBackground(this.mLeftView, drawable);
        post(this);
        return this;
    }

    public TitleBar setRightBackground(int i) {
        return setRightBackground(ViewCore.getDrawable(getContext(), i));
    }

    public TitleBar setRightBackground(Drawable drawable) {
        ViewCore.setBackground(this.mRightView, drawable);
        post(this);
        return this;
    }

    public TitleBar setLeftSize(int i, float f) {
        this.mLeftView.setTextSize(i, f);
        post(this);
        return this;
    }

    public TitleBar setTitleSize(int i, float f) {
        this.mTitleView.setTextSize(i, f);
        post(this);
        return this;
    }

    public TitleBar setRightSize(int i, float f) {
        this.mRightView.setTextSize(i, f);
        post(this);
        return this;
    }

    public TitleBar setLineVisible(boolean z) {
        this.mLineView.setVisibility(z ? 0 : 8);
        return this;
    }

    public TitleBar setLineColor(int i) {
        return setLineDrawable(new ColorDrawable(i));
    }

    public TitleBar setLineDrawable(Drawable drawable) {
        ViewCore.setBackground(this.mLineView, drawable);
        return this;
    }

    public TitleBar setLineSize(int i) {
        ViewGroup.LayoutParams layoutParams = this.mLineView.getLayoutParams();
        layoutParams.height = i;
        this.mLineView.setLayoutParams(layoutParams);
        return this;
    }

    public TitleBar setTitleGravity(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            i = Gravity.getAbsoluteGravity(i, getResources().getConfiguration().getLayoutDirection());
        }
        this.mTitleView.setGravity(i);
        return this;
    }

    public TitleBar setDrawablePadding(int i) {
        this.mLeftView.setCompoundDrawablePadding(i);
        this.mTitleView.setCompoundDrawablePadding(i);
        this.mRightView.setCompoundDrawablePadding(i);
        post(this);
        return this;
    }

    public TitleBar setChildPadding(int i) {
        this.mLeftView.setPadding(i, 0, i, 0);
        this.mTitleView.setPadding(i, 0, i, 0);
        this.mRightView.setPadding(i, 0, i, 0);
        post(this);
        return this;
    }

    public LinearLayout getMainLayout() {
        return this.mMainLayout;
    }

    public TextView getLeftView() {
        return this.mLeftView;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getRightView() {
        return this.mRightView;
    }

    public View getLineView() {
        return this.mLineView;
    }

    public static void initStyle(ITitleBarStyle iTitleBarStyle) {
        sDefaultStyle = iTitleBarStyle;
        if ((iTitleBarStyle instanceof BaseTitleBarStyle) && !(((BaseTitleBarStyle) iTitleBarStyle).getContext() instanceof Application)) {
            throw new IllegalArgumentException("The view must be initialized using the context of the application");
        }
    }

    public ITitleBarStyle getCurrentStyle() {
        return this.mCurrentStyle;
    }
}
