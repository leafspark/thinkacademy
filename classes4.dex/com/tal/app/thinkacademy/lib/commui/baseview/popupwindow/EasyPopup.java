package com.tal.app.thinkacademy.lib.commui.baseview.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;

public class EasyPopup implements PopupWindow.OnDismissListener {
    private static final float DEFAULT_DIM = 0.7f;
    private static final String TAG = "EasyPopup";
    protected boolean isBackgroundDim;
    /* access modifiers changed from: private */
    public boolean isOnlyGetWH = true;
    /* access modifiers changed from: private */
    public View mAnchorView;
    protected int mAnimationStyle;
    protected View mContentView;
    private Context mContext;
    protected int mDimColor = -16777216;
    protected float mDimValue = 0.7f;
    protected ViewGroup mDimView;
    protected Transition mEnterTransition;
    protected Transition mExitTransition;
    private boolean mFocusAndOutsideEnable;
    protected boolean mFocusable = true;
    protected int mHeight;
    /* access modifiers changed from: private */
    public int mHorizontalGravity = 1;
    private boolean mKeyCodeBack = true;
    protected int mLayoutId;
    /* access modifiers changed from: private */
    public int mOffsetX;
    /* access modifiers changed from: private */
    public int mOffsetY;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            EasyPopup easyPopup = EasyPopup.this;
            easyPopup.mWidth = easyPopup.getContentView().getWidth();
            EasyPopup easyPopup2 = EasyPopup.this;
            easyPopup2.mHeight = easyPopup2.getContentView().getHeight();
            if (EasyPopup.this.isOnlyGetWH) {
                EasyPopup.this.removeGlobalLayoutListener();
            } else if (EasyPopup.this.mPopupWindow != null) {
                EasyPopup easyPopup3 = EasyPopup.this;
                easyPopup3.updateLocation(easyPopup3.mWidth, EasyPopup.this.mHeight, EasyPopup.this.mAnchorView, EasyPopup.this.mVerticalGravity, EasyPopup.this.mHorizontalGravity, EasyPopup.this.mOffsetX, EasyPopup.this.mOffsetY);
                EasyPopup.this.removeGlobalLayoutListener();
            }
        }
    };
    protected boolean mOutsideTouchable = true;
    public PopupWindow mPopupWindow;
    /* access modifiers changed from: private */
    public int mVerticalGravity = 2;
    protected int mWidth;

    /* access modifiers changed from: protected */
    public void onPopupWindowCreated() {
    }

    /* access modifiers changed from: protected */
    public void onPopupWindowDismiss() {
    }

    /* access modifiers changed from: protected */
    public void onPopupWindowViewCreated(View view) {
    }

    public EasyPopup(Context context) {
        this.mContext = context;
        LanguageUtil.setChosenLanguage(context);
    }

    public <T extends EasyPopup> T createPopup() {
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        onPopupWindowCreated();
        if (this.mContentView == null) {
            if (this.mLayoutId != 0) {
                LayoutInflater from = LayoutInflater.from(this.mContext);
                int i = this.mLayoutId;
                this.mContentView = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
            } else {
                throw new IllegalArgumentException("The content view is null");
            }
        }
        this.mPopupWindow.setContentView(this.mContentView);
        int i2 = this.mWidth;
        if (i2 != 0) {
            this.mPopupWindow.setWidth(i2);
        } else {
            this.mPopupWindow.setWidth(-2);
        }
        int i3 = this.mHeight;
        if (i3 != 0) {
            this.mPopupWindow.setHeight(i3);
        } else {
            this.mPopupWindow.setHeight(-2);
        }
        onPopupWindowViewCreated(this.mContentView);
        int i4 = this.mAnimationStyle;
        if (i4 != 0) {
            this.mPopupWindow.setAnimationStyle(i4);
        }
        if (!this.mFocusAndOutsideEnable) {
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable((Drawable) null);
            this.mPopupWindow.getContentView().setFocusable(true);
            this.mPopupWindow.getContentView().setFocusableInTouchMode(true);
            this.mPopupWindow.getContentView().setOnKeyListener(new EasyPopup$$ExternalSyntheticLambda0(this));
            this.mPopupWindow.setTouchInterceptor(new EasyPopup$$ExternalSyntheticLambda1(this));
        } else {
            this.mPopupWindow.setFocusable(this.mFocusable);
            this.mPopupWindow.setOutsideTouchable(this.mOutsideTouchable);
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.mPopupWindow.setOnDismissListener(this);
        if (Build.VERSION.SDK_INT >= 23) {
            Transition transition = this.mEnterTransition;
            if (transition != null) {
                this.mPopupWindow.setEnterTransition(transition);
            }
            Transition transition2 = this.mExitTransition;
            if (transition2 != null) {
                this.mPopupWindow.setExitTransition(transition2);
            }
        }
        return this;
    }

    public /* synthetic */ boolean lambda$createPopup$0$EasyPopup(View view, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (!this.mKeyCodeBack) {
            return true;
        }
        dismiss();
        return true;
    }

    public /* synthetic */ boolean lambda$createPopup$1$EasyPopup(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if ((motionEvent.getAction() != 0 || (x >= 0 && x < this.mWidth && y >= 0 && y < this.mHeight)) && motionEvent.getAction() != 4) {
            return false;
        }
        return true;
    }

    public <T extends EasyPopup> T setContentView(View view) {
        this.mContentView = view;
        this.mLayoutId = 0;
        return this;
    }

    public <T extends EasyPopup> T setContentView(int i) {
        this.mContentView = null;
        this.mLayoutId = i;
        return this;
    }

    public <T extends EasyPopup> T setContentView(View view, int i, int i2) {
        this.mContentView = view;
        this.mLayoutId = 0;
        this.mWidth = i;
        this.mHeight = i2;
        return this;
    }

    public <T extends EasyPopup> T setContentView(int i, int i2, int i3) {
        this.mContentView = null;
        this.mLayoutId = i;
        this.mWidth = i2;
        this.mHeight = i3;
        return this;
    }

    public <T extends EasyPopup> T setWidth(int i) {
        this.mWidth = i;
        return this;
    }

    public <T extends EasyPopup> T setHeight(int i) {
        this.mHeight = i;
        return this;
    }

    public <T extends EasyPopup> T setAnchorView(View view) {
        this.mAnchorView = view;
        return this;
    }

    public <T extends EasyPopup> T setVerticalGravity(int i) {
        this.mVerticalGravity = i;
        return this;
    }

    public <T extends EasyPopup> T setHorizontalGravity(int i) {
        this.mHorizontalGravity = i;
        return this;
    }

    public <T extends EasyPopup> T setOffsetX(int i) {
        this.mOffsetX = i;
        return this;
    }

    public <T extends EasyPopup> T setOffsetY(int i) {
        this.mOffsetY = i;
        return this;
    }

    public <T extends EasyPopup> T setAnimationStyle(int i) {
        this.mAnimationStyle = i;
        return this;
    }

    public <T extends EasyPopup> T setFocusable(boolean z) {
        this.mFocusable = z;
        return this;
    }

    public <T extends EasyPopup> T setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
        return this;
    }

    public <T extends EasyPopup> T setFocusAndOutsideEnable(boolean z) {
        this.mFocusAndOutsideEnable = z;
        return this;
    }

    public <T extends EasyPopup> T setKeyCodeBack(boolean z) {
        this.mKeyCodeBack = z;
        return this;
    }

    public <T extends EasyPopup> T setBackgroundDimEnable(boolean z) {
        this.isBackgroundDim = z;
        return this;
    }

    public <T extends EasyPopup> T setDimValue(float f) {
        this.mDimValue = f;
        return this;
    }

    public <T extends EasyPopup> T setDimColor(int i) {
        this.mDimColor = i;
        return this;
    }

    public <T extends EasyPopup> T setDimView(ViewGroup viewGroup) {
        this.mDimView = viewGroup;
        return this;
    }

    public <T extends EasyPopup> T setEnterTransition(Transition transition) {
        this.mEnterTransition = transition;
        return this;
    }

    public <T extends EasyPopup> T setExitTransition(Transition transition) {
        this.mExitTransition = transition;
        return this;
    }

    public void showAsDropDown() {
        View view = this.mAnchorView;
        if (view != null) {
            showAsDropDown(view, this.mOffsetX, this.mOffsetY);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (this.mPopupWindow != null) {
            this.isOnlyGetWH = true;
            handleBackgroundDim();
            this.mAnchorView = view;
            this.mOffsetX = i;
            this.mOffsetY = i2;
            addGlobalLayoutListener(this.mPopupWindow.getContentView());
            this.mPopupWindow.showAsDropDown(view, i, i2);
        }
    }

    public void showAsDropDown(final View view) {
        if (this.mPopupWindow != null) {
            handleBackgroundDim();
            this.mAnchorView = view;
            this.isOnlyGetWH = true;
            addGlobalLayoutListener(this.mPopupWindow.getContentView());
            if (Build.VERSION.SDK_INT == 24) {
                final Rect rect = new Rect();
                view.postDelayed(new Runnable() {
                    public void run() {
                        view.getGlobalVisibleRect(rect);
                        int i = view.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                        if (i != 0) {
                            EasyPopup.this.mPopupWindow.setHeight(i);
                        }
                    }
                }, 500);
            }
            this.mPopupWindow.showAsDropDown(view);
        }
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (this.mPopupWindow != null) {
            handleBackgroundDim();
            this.mAnchorView = view;
            this.mOffsetX = i;
            this.mOffsetY = i2;
            this.isOnlyGetWH = true;
            addGlobalLayoutListener(this.mPopupWindow.getContentView());
            PopupWindowCompat.showAsDropDown(this.mPopupWindow, view, i, i2, i3);
        }
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        if (this.mPopupWindow != null) {
            handleBackgroundDim();
            this.mAnchorView = view;
            this.mOffsetX = i2;
            this.mOffsetY = i3;
            this.isOnlyGetWH = true;
            addGlobalLayoutListener(this.mPopupWindow.getContentView());
            this.mPopupWindow.showAtLocation(view, i, i2, i3);
        }
    }

    public void showAtAnchorView() {
        View view = this.mAnchorView;
        if (view != null) {
            showAtAnchorView(view, this.mVerticalGravity, this.mHorizontalGravity);
        }
    }

    public void showAtAnchorView(View view, int i, int i2) {
        showAtAnchorView(view, i, i2, 0, 0);
    }

    public void showAtAnchorView(View view, int i, int i2, int i3, int i4) {
        if (this.mPopupWindow != null) {
            this.mAnchorView = view;
            this.mOffsetX = i3;
            this.mOffsetY = i4;
            this.mVerticalGravity = i;
            this.mHorizontalGravity = i2;
            this.isOnlyGetWH = false;
            handleBackgroundDim();
            PopupWindowCompat.showAsDropDown(this.mPopupWindow, view, i3, i4, 0);
        }
    }

    private int calculateY(View view, int i, int i2, int i3) {
        int i4;
        if (i != 0) {
            if (i == 1) {
                i2 += view.getHeight();
            } else if (i == 3) {
                i4 = view.getHeight();
            } else if (i != 4) {
                return i3;
            }
            return i3 - i2;
        }
        i4 = (view.getHeight() / 2) + (i2 / 2);
        return i3 - i4;
    }

    private int calculateX(View view, int i, int i2, int i3) {
        int i4;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    i4 = view.getWidth();
                } else if (i != 4) {
                    return i3;
                } else {
                    i2 -= view.getWidth();
                }
            }
            return i3 - i2;
        }
        i4 = (view.getWidth() / 2) - (i2 / 2);
        return i3 + i4;
    }

    /* access modifiers changed from: private */
    public void updateLocation(int i, int i2, View view, int i3, int i4, int i5, int i6) {
        this.mPopupWindow.update(view, calculateX(view, i4, i, i5), calculateY(view, i3, i2, i6), i, i2);
    }

    public <T extends EasyPopup> T setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    private void handleBackgroundDim() {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 18 && this.isBackgroundDim) {
            ViewGroup viewGroup = this.mDimView;
            if (viewGroup != null) {
                applyDim(viewGroup);
            } else if (getContentView() != null && (activity = (Activity) getContentView().getContext()) != null) {
                applyDim(activity);
            }
        }
    }

    private void applyDim(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private void applyDim(ViewGroup viewGroup) {
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private void clearBackgroundDim() {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 18 && this.isBackgroundDim) {
            ViewGroup viewGroup = this.mDimView;
            if (viewGroup != null) {
                clearDim(viewGroup);
            } else if (getContentView() != null && (activity = (Activity) getContentView().getContext()) != null) {
                clearDim(activity);
            }
        }
    }

    private void clearDim(Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView().getRootView()).getOverlay().clear();
    }

    private void clearDim(ViewGroup viewGroup) {
        viewGroup.getOverlay().clear();
    }

    public View getContentView() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.getContentView();
        }
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public <T extends View> T getView(int i) {
        if (getContentView() != null) {
            return getContentView().findViewById(i);
        }
        return null;
    }

    public void dismiss() {
        try {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void onDismiss() {
        handleDismiss();
    }

    private void handleDismiss() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        removeGlobalLayoutListener();
        clearBackgroundDim();
        dismiss();
        onPopupWindowDismiss();
    }

    private void addGlobalLayoutListener(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    /* access modifiers changed from: private */
    public void removeGlobalLayoutListener() {
        if (getContentView() != null) {
            getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }
}
