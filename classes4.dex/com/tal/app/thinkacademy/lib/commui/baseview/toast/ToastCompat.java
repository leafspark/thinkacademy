package com.tal.app.thinkacademy.lib.commui.baseview.toast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

public final class ToastCompat extends Toast {
    private final Toast toast;

    private ToastCompat(Context context, Toast toast2) {
        super(context);
        this.toast = toast2;
    }

    public static ToastCompat makeText(Context context, CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(context, charSequence, i);
        setContextCompat(makeText.getView(), new SafeToastContext(context, makeText));
        return new ToastCompat(context, makeText);
    }

    public static Toast makeText(Context context, int i, int i2) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public ToastCompat setBadTokenListener(BadTokenListener badTokenListener) {
        Context context = getView().getContext();
        if (context instanceof SafeToastContext) {
            ((SafeToastContext) context).setBadTokenListener(badTokenListener);
        }
        return this;
    }

    public void show() {
        this.toast.show();
    }

    public void setDuration(int i) {
        this.toast.setDuration(i);
    }

    public void setGravity(int i, int i2, int i3) {
        this.toast.setGravity(i, i2, i3);
    }

    public void setMargin(float f, float f2) {
        this.toast.setMargin(f, f2);
    }

    public void setText(int i) {
        this.toast.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.toast.setText(charSequence);
    }

    public void setView(View view) {
        this.toast.setView(view);
        setContextCompat(view, new SafeToastContext(view.getContext(), this));
    }

    public float getHorizontalMargin() {
        return this.toast.getHorizontalMargin();
    }

    public float getVerticalMargin() {
        return this.toast.getVerticalMargin();
    }

    public int getDuration() {
        return this.toast.getDuration();
    }

    public int getGravity() {
        return this.toast.getGravity();
    }

    public int getXOffset() {
        return this.toast.getXOffset();
    }

    public int getYOffset() {
        return this.toast.getYOffset();
    }

    public View getView() {
        return this.toast.getView();
    }

    public Toast getBaseToast() {
        return this.toast;
    }

    private static void setContextCompat(View view, Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
