package cn.dreamtobe.kpswitch.handler;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import cn.dreamtobe.kpswitch.IPanelConflictLayout;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.util.ViewUtil;
import com.tal.app.thinkacademy.lib.util.BarUtils;

public class KPSwitchRootLayoutHandler {
    private final boolean mIsTranslucentStatus;
    private int mOldHeight = -1;
    private IPanelConflictLayout mPanelLayout;
    private final int mStatusBarHeight;
    private final View mTargetRootView;

    public KPSwitchRootLayoutHandler(View view) {
        this.mTargetRootView = view;
        this.mStatusBarHeight = BarUtils.getStatusBarHeight();
        this.mIsTranslucentStatus = ViewUtil.isTranslucentStatus((Activity) view.getContext());
    }

    public void handleBeforeMeasure(int i, int i2) {
        if (this.mIsTranslucentStatus && Build.VERSION.SDK_INT >= 16 && this.mTargetRootView.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.mTargetRootView.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            int i3 = this.mOldHeight;
            if (i3 < 0) {
                this.mOldHeight = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 != 0 && Math.abs(i4) != this.mStatusBarHeight) {
                this.mOldHeight = i2;
                IPanelConflictLayout panelLayout = getPanelLayout(this.mTargetRootView);
                if (panelLayout == null || Math.abs(i4) < KeyboardUtil.getMinKeyboardHeight(this.mTargetRootView.getContext())) {
                    return;
                }
                if (i4 > 0) {
                    panelLayout.handleHide();
                } else if (panelLayout.isKeyboardShowing() && panelLayout.isVisible()) {
                    panelLayout.handleShow();
                }
            }
        }
    }

    private IPanelConflictLayout getPanelLayout(View view) {
        IPanelConflictLayout iPanelConflictLayout = this.mPanelLayout;
        if (iPanelConflictLayout != null) {
            return iPanelConflictLayout;
        }
        if (view instanceof IPanelConflictLayout) {
            IPanelConflictLayout iPanelConflictLayout2 = (IPanelConflictLayout) view;
            this.mPanelLayout = iPanelConflictLayout2;
            return iPanelConflictLayout2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return null;
                }
                IPanelConflictLayout panelLayout = getPanelLayout(viewGroup.getChildAt(i));
                if (panelLayout != null) {
                    this.mPanelLayout = panelLayout;
                    return panelLayout;
                }
                i++;
            }
        }
    }
}
