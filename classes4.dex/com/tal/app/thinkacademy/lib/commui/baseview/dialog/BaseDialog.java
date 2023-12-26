package com.tal.app.thinkacademy.lib.commui.baseview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.utils.TableUtils;

public class BaseDialog extends Dialog {
    private OnDismissListener mOnDismissListener;
    private final boolean mOpenPadAuto;

    public interface OnDismissListener {
        void dismiss();
    }

    public boolean isUseImmersive() {
        return false;
    }

    public BaseDialog(Context context) {
        this(context, false);
    }

    public BaseDialog(Context context, boolean z) {
        this(context, 0, z);
    }

    public BaseDialog(Context context, int i, boolean z) {
        super(context, i);
        this.mOpenPadAuto = z;
        LanguageUtil.setChosenLanguage(context);
        requestWindowFeature(1);
        if (isUseImmersive()) {
            getWindow().getDecorView().setSystemUiVisibility(2564);
            getWindow().setFlags(1024, 1024);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        getWindow().setBackgroundDrawable(gradientDrawable);
        dimAmount(0.2f);
    }

    public BaseDialog contentView(int i) {
        LayoutInflater from = LayoutInflater.from(getContext());
        contentView(!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null));
        return this;
    }

    public BaseDialog contentView(View view) {
        if (isPad() && isOpenPadAuto()) {
            PadAutoUtil.setupDialogAutoViewCenter(view);
        }
        getWindow().setContentView(view);
        return this;
    }

    public BaseDialog contentView(View view, ViewGroup.LayoutParams layoutParams) {
        getWindow().setContentView(view, layoutParams);
        return this;
    }

    public BaseDialog layoutParams(ViewGroup.LayoutParams layoutParams) {
        if (isPad() && isOpenPadAuto()) {
            PadAutoUtil.setupDialogAutoLayoutParamsCenter(layoutParams, this);
        }
        getWindow().setLayout(layoutParams.width, layoutParams.height);
        return this;
    }

    public BaseDialog canceledOnTouchOutside(boolean z) {
        setCanceledOnTouchOutside(z);
        return this;
    }

    public BaseDialog gravity(int i) {
        if (!isPad() || !isOpenPadAuto()) {
            getWindow().setGravity(i);
        } else {
            getWindow().setGravity(PadAutoUtil.setupDialogAutoLayoutGravity(i));
        }
        return this;
    }

    public BaseDialog offset(int i, int i2) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = i;
        attributes.y = i2;
        return this;
    }

    public BaseDialog dimAmount(float f) {
        getWindow().getAttributes().dimAmount = f;
        return this;
    }

    public BaseDialog dismissListener(OnDismissListener onDismissListener) {
        setDismissListener(onDismissListener);
        return this;
    }

    public void setDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void dismiss() {
        super.dismiss();
        OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.dismiss();
        }
    }

    public BaseDialog animType(AnimInType animInType) {
        int intType = animInType.getIntType();
        if (intType == 0) {
            getWindow().setWindowAnimations(R.style.dialog_zoom);
        } else if (intType == 1) {
            getWindow().setWindowAnimations(R.style.dialog_anim_left);
        } else if (intType == 2) {
            getWindow().setWindowAnimations(R.style.dialog_anim_top);
        } else if (intType == 3) {
            getWindow().setWindowAnimations(R.style.dialog_anim_right);
        } else if (intType == 4) {
            getWindow().setWindowAnimations(R.style.dialog_anim_bottom);
        }
        return this;
    }

    public final boolean isOpenPadAuto() {
        return this.mOpenPadAuto;
    }

    public final boolean isPad() {
        return TableUtils.isTable();
    }

    public enum AnimInType {
        CENTER(0),
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        final int intType;

        private AnimInType(int i) {
            this.intType = i;
        }

        public int getIntType() {
            return this.intType;
        }
    }
}
