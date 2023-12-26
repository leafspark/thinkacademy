package cn.dreamtobe.kpswitch.handler;

import android.view.View;
import android.view.Window;
import cn.dreamtobe.kpswitch.IFSPanelConflictLayout;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;

public class KPSwitchFSPanelLayoutHandler implements IFSPanelConflictLayout {
    private boolean isKeyboardShowing;
    private final View panelLayout;
    private View recordedFocusView;

    public KPSwitchFSPanelLayoutHandler(View view) {
        this.panelLayout = view;
    }

    public void onKeyboardShowing(boolean z) {
        this.isKeyboardShowing = z;
        if (!z && this.panelLayout.getVisibility() == 4) {
            this.panelLayout.setVisibility(8);
        }
        if (!z && this.recordedFocusView != null) {
            restoreFocusView();
            this.recordedFocusView = null;
        }
    }

    public void recordKeyboardStatus(Window window) {
        View currentFocus = window.getCurrentFocus();
        if (currentFocus != null) {
            if (this.isKeyboardShowing) {
                saveFocusView(currentFocus);
            } else {
                currentFocus.clearFocus();
            }
        }
    }

    private void saveFocusView(View view) {
        this.recordedFocusView = view;
        view.clearFocus();
        this.panelLayout.setVisibility(8);
    }

    private void restoreFocusView() {
        this.panelLayout.setVisibility(4);
        KeyboardUtil.showKeyboard(this.recordedFocusView);
    }
}
