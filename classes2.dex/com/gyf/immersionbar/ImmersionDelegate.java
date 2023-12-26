package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

class ImmersionDelegate implements Runnable {
    private BarProperties mBarProperties;
    private ImmersionBar mImmersionBar;
    private int mNotchHeight;
    private OnBarListener mOnBarListener;

    ImmersionDelegate(Object obj) {
        if (obj instanceof Activity) {
            if (this.mImmersionBar == null) {
                this.mImmersionBar = new ImmersionBar((Activity) obj);
            }
        } else if (obj instanceof Fragment) {
            if (this.mImmersionBar != null) {
                return;
            }
            if (obj instanceof DialogFragment) {
                this.mImmersionBar = new ImmersionBar((DialogFragment) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((Fragment) obj);
            }
        } else if ((obj instanceof android.app.Fragment) && this.mImmersionBar == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.mImmersionBar = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    ImmersionDelegate(Activity activity, Dialog dialog) {
        if (this.mImmersionBar == null) {
            this.mImmersionBar = new ImmersionBar(activity, dialog);
        }
    }

    public ImmersionBar get() {
        return this.mImmersionBar;
    }

    /* access modifiers changed from: package-private */
    public void onActivityCreated(Configuration configuration) {
        barChanged(configuration);
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onResume();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.mBarProperties = null;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onDestroy();
            this.mImmersionBar = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onConfigurationChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onConfigurationChanged(configuration);
            barChanged(configuration);
        }
    }

    private void barChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.initialized() && Build.VERSION.SDK_INT >= 19) {
            OnBarListener onBarListener = this.mImmersionBar.getBarParams().onBarListener;
            this.mOnBarListener = onBarListener;
            if (onBarListener != null) {
                Activity activity = this.mImmersionBar.getActivity();
                if (this.mBarProperties == null) {
                    this.mBarProperties = new BarProperties();
                }
                this.mBarProperties.setPortrait(configuration.orientation == 1);
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 1) {
                    this.mBarProperties.setLandscapeLeft(true);
                    this.mBarProperties.setLandscapeRight(false);
                } else if (rotation == 3) {
                    this.mBarProperties.setLandscapeLeft(false);
                    this.mBarProperties.setLandscapeRight(true);
                } else {
                    this.mBarProperties.setLandscapeLeft(false);
                    this.mBarProperties.setLandscapeRight(false);
                }
                activity.getWindow().getDecorView().post(this);
            }
        }
    }

    public void run() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.getActivity() != null) {
            Activity activity = this.mImmersionBar.getActivity();
            BarConfig barConfig = new BarConfig(activity);
            this.mBarProperties.setStatusBarHeight(barConfig.getStatusBarHeight());
            this.mBarProperties.setNavigationBar(barConfig.hasNavigationBar());
            this.mBarProperties.setNavigationBarHeight(barConfig.getNavigationBarHeight());
            this.mBarProperties.setNavigationBarWidth(barConfig.getNavigationBarWidth());
            this.mBarProperties.setActionBarHeight(barConfig.getActionBarHeight());
            boolean hasNotchScreen = NotchUtils.hasNotchScreen(activity);
            this.mBarProperties.setNotchScreen(hasNotchScreen);
            if (hasNotchScreen && this.mNotchHeight == 0) {
                int notchHeight = NotchUtils.getNotchHeight(activity);
                this.mNotchHeight = notchHeight;
                this.mBarProperties.setNotchHeight(notchHeight);
            }
            this.mOnBarListener.onBarChange(this.mBarProperties);
        }
    }
}
