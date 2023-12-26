package com.tal.app.thinkacademy.lib.commui.baseview.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public class PopupWindowUtils {
    private View mContentView;
    private Context mContext;
    private PopupWindow mPopupWindow;

    public PopupWindowUtils(Builder builder) {
        this.mContext = builder.context;
        if (builder.contentViewId > 0) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int access$100 = builder.contentViewId;
            this.mContentView = !(from instanceof LayoutInflater) ? from.inflate(access$100, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, access$100, (ViewGroup) null);
        }
        if (builder.contentView != null) {
            this.mContentView = builder.contentView;
        }
        PopupWindow popupWindow = new PopupWindow(this.mContentView, builder.width, builder.height, builder.focus);
        this.mPopupWindow = popupWindow;
        popupWindow.setOutsideTouchable(builder.outsideCancel);
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopupWindow.setAnimationStyle(builder.animStyle);
        this.mPopupWindow.setOnDismissListener(builder.dismissListener);
        this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public View getItemView(int i) {
        if (this.mPopupWindow != null) {
            return this.mContentView.findViewById(i);
        }
        return null;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public PopupWindowUtils showAtLocation(int i, int i2, int i3, int i4) {
        if (this.mPopupWindow != null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            this.mPopupWindow.showAtLocation(!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null), i2, i3, i4);
        }
        return this;
    }

    public PopupWindowUtils showAsLocation(int i, int i2, int i3, int i4) {
        if (this.mPopupWindow != null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            this.mPopupWindow.showAsDropDown(!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null), i2, i3, i4);
        }
        return this;
    }

    public PopupWindowUtils showAsLocation(View view, int i, int i2, int i3) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
        return this;
    }

    public void setOnFocusListener(int i, View.OnFocusChangeListener onFocusChangeListener) {
        getItemView(i).setOnFocusChangeListener(onFocusChangeListener);
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int animStyle;
        /* access modifiers changed from: private */
        public View contentView;
        /* access modifiers changed from: private */
        public int contentViewId;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public PopupWindow.OnDismissListener dismissListener;
        /* access modifiers changed from: private */
        public boolean focus;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public boolean outsideCancel;
        /* access modifiers changed from: private */
        public int width;

        public Builder setContext(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder setContentView(int i) {
            this.contentViewId = i;
            return this;
        }

        public Builder setContentView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setFocus(boolean z) {
            this.focus = z;
            return this;
        }

        public Builder setOutSideCancel(boolean z) {
            this.outsideCancel = z;
            return this;
        }

        public Builder setAnimationStyle(int i) {
            this.animStyle = i;
            return this;
        }

        public Builder setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public PopupWindowUtils builder() {
            return new PopupWindowUtils(this);
        }
    }
}
