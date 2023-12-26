package com.amazonaws.mobile.auth.core.signin.ui.buttons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazonaws.mobile.auth.core.R;
import com.amazonaws.mobile.auth.core.signin.ui.DisplayUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;

public class SignInButton extends LinearLayout {
    private static final int BORDER_COLOR = -16777216;
    private static final int IMAGE_LEFT_MARGIN = DisplayUtils.dp(8);
    private static final int IMAGE_RIGHT_MARGIN = DisplayUtils.dp(8);
    private static final float MAX_TEXT_SIZE_PX = ((float) DisplayUtils.dp(50));
    private static final float MIN_TEXT_SIZE_SP = 8.0f;
    private static final int TEXT_LEFT_MARGIN = DisplayUtils.dp(2);
    private static final int TEXT_RIGHT_MARGIN = DisplayUtils.dp(8);
    private final SignInButtonAttributes attributes;
    protected Bitmap bitmap;
    protected ImageView imageView;
    protected boolean isSmallStyle = false;
    protected TextView textView;

    public SignInButton(Context context, AttributeSet attributeSet, int i, SignInButtonAttributes signInButtonAttributes) {
        super(context, attributeSet, i);
        this.attributes = signInButtonAttributes;
        setFocusable(true);
        setClickable(true);
        setOrientation(0);
        setGravity(16);
        setBackgroundDrawable(getBackgroundStatesDrawable());
        this.imageView = new ImageView(context);
        this.bitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), signInButtonAttributes.getImageIconResourceId());
        this.imageView.setImageDrawable(new BitmapDrawable(getResources(), this.bitmap));
        this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imageView.setAdjustViewBounds(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(IMAGE_LEFT_MARGIN, 0, IMAGE_RIGHT_MARGIN, 0);
        layoutParams.weight = 0.0f;
        addView(this.imageView, layoutParams);
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setTextColor(signInButtonAttributes.getTextColor());
        String str = null;
        this.textView.setTypeface((Typeface) null, 1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SignInButton);
            if (obtainStyledAttributes.getInt(R.styleable.SignInButton_button_style, 0) > 0) {
                this.isSmallStyle = true;
            }
            str = obtainStyledAttributes.getString(R.styleable.SignInButton_text);
            obtainStyledAttributes.recycle();
        }
        if (str != null) {
            this.textView.setText(str);
        } else {
            this.textView.setText(signInButtonAttributes.getDefaultTextResourceId());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(DisplayUtils.dp(TEXT_LEFT_MARGIN), 0, DisplayUtils.dp(TEXT_RIGHT_MARGIN), 0);
        layoutParams2.weight = 1.0f;
        addView(this.textView, layoutParams2);
        updateStyle();
        invalidate();
    }

    private Drawable getButtonBackground(int i) {
        int cornerRadius = this.attributes.getCornerRadius();
        ShapeDrawable roundedRectangleBackground = DisplayUtils.getRoundedRectangleBackground(cornerRadius, i);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{this.attributes.getTopShadowColor(), this.attributes.getTopShadowColor()});
        gradientDrawable.setCornerRadius((float) DisplayUtils.dp(cornerRadius));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{this.attributes.getBottomShadowColor(), this.attributes.getBottomShadowColor()});
        gradientDrawable2.setCornerRadius((float) DisplayUtils.dp(cornerRadius));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2, roundedRectangleBackground});
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable2.setLayerInset(1, this.attributes.getTopShadowThickness(), this.attributes.getTopShadowThickness(), 0, 0);
        layerDrawable2.setLayerInset(2, this.attributes.getTopShadowThickness(), this.attributes.getTopShadowThickness(), this.attributes.getBottomShadowThickness(), this.attributes.getBottomShadowThickness());
        return layerDrawable;
    }

    private Drawable getBackgroundStatesDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, getButtonBackground(this.attributes.getBackgroundColorPressed()));
        stateListDrawable.addState(new int[0], getButtonBackground(this.attributes.getBackgroundColor()));
        return stateListDrawable;
    }

    private void updateStyle() {
        if (this.isSmallStyle) {
            this.textView.setVisibility(8);
            setGravity(17);
            return;
        }
        this.textView.setVisibility(0);
        setGravity(16);
    }

    public void setSmallStyle(boolean z) {
        this.isSmallStyle = z;
        updateStyle();
    }

    public void setButtonText(String str) {
        this.textView.setText(str);
        resizeButtonText();
    }

    public void setButtonText(int i) {
        this.textView.setText(i);
        resizeButtonText();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        int measuredHeight = (int) (((double) getMeasuredHeight()) * 0.72d);
        if (measuredHeight > this.bitmap.getHeight()) {
            measuredHeight = this.bitmap.getHeight();
        }
        layoutParams.height = measuredHeight;
        layoutParams.width = measuredHeight;
    }

    private boolean doesTextViewFit(float f, RectF rectF) {
        String str;
        TextPaint textPaint = new TextPaint(this.textView.getPaint());
        textPaint.setTextSize(f);
        TransformationMethod transformationMethod = this.textView.getTransformationMethod();
        if (transformationMethod == null) {
            str = this.textView.getText().toString();
        } else {
            str = transformationMethod.getTransformation(this.textView.getText(), this.textView).toString();
        }
        return rectF.contains(new RectF(0.0f, 0.0f, textPaint.measureText(str), textPaint.getFontSpacing()));
    }

    private float findBestSize(float f, float f2, RectF rectF) {
        float f3 = f2;
        float f4 = f;
        while (f <= f3) {
            float f5 = (f + f3) / 2.0f;
            if (doesTextViewFit(f5, rectF)) {
                f = f5 + 0.5f;
                f4 = f5;
            } else {
                f3 = f5 - 0.5f;
            }
        }
        return f4;
    }

    private void resizeButtonText() {
        if (getMeasuredWidth() != 0 && !this.isSmallStyle) {
            float applyDimension = TypedValue.applyDimension(2, MIN_TEXT_SIZE_SP, getResources().getDisplayMetrics());
            RectF rectF = new RectF();
            rectF.right = (float) ((this.textView.getMeasuredWidth() - this.textView.getCompoundPaddingLeft()) - this.textView.getCompoundPaddingRight());
            rectF.bottom = (float) ((this.textView.getMeasuredHeight() - this.textView.getCompoundPaddingBottom()) - this.textView.getCompoundPaddingTop());
            this.textView.setTextSize(0, findBestSize(applyDimension, MAX_TEXT_SIZE_PX, rectF));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            resizeButtonText();
        }
    }
}
