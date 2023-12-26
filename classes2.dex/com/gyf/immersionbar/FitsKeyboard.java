package com.gyf.immersionbar;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

class FitsKeyboard implements ViewTreeObserver.OnGlobalLayoutListener {
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private ImmersionBar mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mTempKeyboardHeight;
    private Window mWindow;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FitsKeyboard(com.gyf.immersionbar.ImmersionBar r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.mPaddingLeft = r0
            r3.mPaddingTop = r0
            r3.mPaddingRight = r0
            r3.mPaddingBottom = r0
            r3.mImmersionBar = r4
            android.view.Window r1 = r4.getWindow()
            r3.mWindow = r1
            android.view.View r1 = r1.getDecorView()
            r3.mDecorView = r1
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r2 = r4.isDialogFragment()
            if (r2 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r0 = r4.getSupportFragment()
            if (r0 == 0) goto L_0x0036
            android.view.View r4 = r0.getView()
            r3.mChildView = r4
            goto L_0x0057
        L_0x0036:
            android.app.Fragment r4 = r4.getFragment()
            if (r4 == 0) goto L_0x0057
            android.view.View r4 = r4.getView()
            r3.mChildView = r4
            goto L_0x0057
        L_0x0043:
            android.view.View r4 = r1.getChildAt(r0)
            r3.mChildView = r4
            if (r4 == 0) goto L_0x0057
            boolean r2 = r4 instanceof androidx.drawerlayout.widget.DrawerLayout
            if (r2 == 0) goto L_0x0057
            androidx.drawerlayout.widget.DrawerLayout r4 = (androidx.drawerlayout.widget.DrawerLayout) r4
            android.view.View r4 = r4.getChildAt(r0)
            r3.mChildView = r4
        L_0x0057:
            android.view.View r4 = r3.mChildView
            if (r4 == 0) goto L_0x0079
            int r4 = r4.getPaddingLeft()
            r3.mPaddingLeft = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingTop()
            r3.mPaddingTop = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingRight()
            r3.mPaddingRight = r4
            android.view.View r4 = r3.mChildView
            int r4 = r4.getPaddingBottom()
            r3.mPaddingBottom = r4
        L_0x0079:
            android.view.View r4 = r3.mChildView
            if (r4 == 0) goto L_0x007e
            r1 = r4
        L_0x007e:
            r3.mContentView = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.FitsKeyboard.<init>(com.gyf.immersionbar.ImmersionBar):void");
    }

    /* access modifiers changed from: package-private */
    public void enable(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mWindow.setSoftInputMode(i);
            if (!this.mIsAddListener) {
                this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
                this.mIsAddListener = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void disable() {
        if (Build.VERSION.SDK_INT >= 19 && this.mIsAddListener) {
            if (this.mChildView != null) {
                this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
            } else {
                this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        if (Build.VERSION.SDK_INT >= 19 && this.mIsAddListener) {
            this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.mIsAddListener = false;
        }
    }

    public void onGlobalLayout() {
        int i;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.getBarParams() != null && this.mImmersionBar.getBarParams().keyboardEnable) {
            BarConfig barConfig = this.mImmersionBar.getBarConfig();
            int navigationBarHeight = barConfig.isNavigationAtBottom() ? barConfig.getNavigationBarHeight() : barConfig.getNavigationBarWidth();
            Rect rect = new Rect();
            this.mDecorView.getWindowVisibleDisplayFrame(rect);
            int height = this.mContentView.getHeight() - rect.bottom;
            if (height != this.mTempKeyboardHeight) {
                this.mTempKeyboardHeight = height;
                boolean z = true;
                int i2 = 0;
                if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(16908290))) {
                    height -= navigationBarHeight;
                    if (height <= navigationBarHeight) {
                        z = false;
                    }
                } else if (this.mChildView != null) {
                    if (this.mImmersionBar.getBarParams().isSupportActionBar) {
                        height += this.mImmersionBar.getActionBarHeight() + barConfig.getStatusBarHeight();
                    }
                    if (this.mImmersionBar.getBarParams().fits) {
                        height += barConfig.getStatusBarHeight();
                    }
                    if (height > navigationBarHeight) {
                        i = this.mPaddingBottom + height;
                    } else {
                        i = 0;
                        z = false;
                    }
                    this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, i);
                } else {
                    int paddingBottom = this.mImmersionBar.getPaddingBottom();
                    height -= navigationBarHeight;
                    if (height > navigationBarHeight) {
                        paddingBottom = height + navigationBarHeight;
                    } else {
                        z = false;
                    }
                    this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), paddingBottom);
                }
                if (height >= 0) {
                    i2 = height;
                }
                if (this.mImmersionBar.getBarParams().onKeyboardListener != null) {
                    this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(z, i2);
                }
                if (!z && this.mImmersionBar.getBarParams().barHide != BarHide.FLAG_SHOW_BAR) {
                    this.mImmersionBar.setBar();
                }
            }
        }
    }
}
