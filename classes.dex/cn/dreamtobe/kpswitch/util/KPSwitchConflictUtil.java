package cn.dreamtobe.kpswitch.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public class KPSwitchConflictUtil {

    public interface SwitchClickListener {
        void onClickSwitch(boolean z);
    }

    public static boolean isHandleByPlaceholder(boolean z, boolean z2, boolean z3) {
        return z || (z2 && !z3);
    }

    public static void attach(View view, View view2, View view3) {
        attach(view, view2, view3, (SwitchClickListener) null);
    }

    public static void attach(final View view, View view2, final View view3, final SwitchClickListener switchClickListener) {
        Activity activity = (Activity) view.getContext();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, KPSwitchConflictUtil.class);
                    boolean switchPanelAndKeyboard = KPSwitchConflictUtil.switchPanelAndKeyboard(view, view3);
                    SwitchClickListener switchClickListener = switchClickListener;
                    if (switchClickListener != null) {
                        switchClickListener.onClickSwitch(switchPanelAndKeyboard);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        if (isHandleByPlaceholder(activity)) {
            view3.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    KPSwitchConflictUtil.showKeyboard(view, view);
                    return false;
                }
            });
        }
    }

    public static void attach(final View view, View view2) {
        if (isHandleByPlaceholder((Activity) view.getContext())) {
            view2.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    KPSwitchConflictUtil.showKeyboard(view, view);
                    return false;
                }
            });
        }
    }

    public static void attach(View view, View view2, SubPanelAndTrigger... subPanelAndTriggerArr) {
        attach(view, view2, (SwitchClickListener) null, subPanelAndTriggerArr);
    }

    public static void attach(final View view, View view2, SwitchClickListener switchClickListener, SubPanelAndTrigger... subPanelAndTriggerArr) {
        Activity activity = (Activity) view.getContext();
        for (SubPanelAndTrigger bindSubPanel : subPanelAndTriggerArr) {
            bindSubPanel(bindSubPanel, subPanelAndTriggerArr, view2, view, switchClickListener);
        }
        if (isHandleByPlaceholder(activity)) {
            view2.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    view.setVisibility(4);
                    return false;
                }
            });
        }
    }

    public static class SubPanelAndTrigger {
        final View subPanelView;
        final View triggerView;

        public SubPanelAndTrigger(View view, View view2) {
            this.subPanelView = view;
            this.triggerView = view2;
        }
    }

    public static void showPanel(View view) {
        Activity activity = (Activity) view.getContext();
        view.setVisibility(0);
        if (activity.getCurrentFocus() != null) {
            KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
        }
    }

    public static void showKeyboard(View view, View view2) {
        KeyboardUtil.showKeyboard(view2);
        if (isHandleByPlaceholder((Activity) view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean switchPanelAndKeyboard(View view, View view2) {
        boolean z = view.getVisibility() != 0;
        if (!z) {
            showKeyboard(view, view2);
        } else {
            showPanel(view);
        }
        return z;
    }

    public static void hidePanelAndKeyboard(View view) {
        Activity activity = (Activity) view.getContext();
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            KeyboardUtil.hideKeyboard(activity.getCurrentFocus());
            currentFocus.clearFocus();
        }
        view.setVisibility(8);
    }

    static boolean isHandleByPlaceholder(Activity activity) {
        return isHandleByPlaceholder(ViewUtil.isFullScreen(activity), ViewUtil.isTranslucentStatus(activity), ViewUtil.isFitsSystemWindows(activity));
    }

    private static void bindSubPanel(SubPanelAndTrigger subPanelAndTrigger, SubPanelAndTrigger[] subPanelAndTriggerArr, View view, View view2, SwitchClickListener switchClickListener) {
        View view3 = subPanelAndTrigger.triggerView;
        final View view4 = subPanelAndTrigger.subPanelView;
        final View view5 = view2;
        final View view6 = view;
        final SubPanelAndTrigger[] subPanelAndTriggerArr2 = subPanelAndTriggerArr;
        final SwitchClickListener switchClickListener2 = switchClickListener;
        view3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Boolean bool;
                MethodInfo.onClickEventEnter(view, KPSwitchConflictUtil.class);
                if (view5.getVisibility() != 0) {
                    KPSwitchConflictUtil.showPanel(view5);
                    bool = true;
                    KPSwitchConflictUtil.showBoundTriggerSubPanel(view4, subPanelAndTriggerArr2);
                } else if (view4.getVisibility() == 0) {
                    KPSwitchConflictUtil.showKeyboard(view5, view6);
                    bool = false;
                } else {
                    KPSwitchConflictUtil.showBoundTriggerSubPanel(view4, subPanelAndTriggerArr2);
                    bool = null;
                }
                SwitchClickListener switchClickListener = switchClickListener2;
                if (!(switchClickListener == null || bool == null)) {
                    switchClickListener.onClickSwitch(bool.booleanValue());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void showBoundTriggerSubPanel(View view, SubPanelAndTrigger[] subPanelAndTriggerArr) {
        for (SubPanelAndTrigger subPanelAndTrigger : subPanelAndTriggerArr) {
            if (subPanelAndTrigger.subPanelView != view) {
                subPanelAndTrigger.subPanelView.setVisibility(8);
            }
        }
        view.setVisibility(0);
    }
}
