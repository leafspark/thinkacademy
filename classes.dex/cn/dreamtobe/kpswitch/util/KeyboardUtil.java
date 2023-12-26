package cn.dreamtobe.kpswitch.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import cn.dreamtobe.kpswitch.IPanelHeightTarget;
import cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.TableUtils;
import java.util.ArrayList;

public class KeyboardUtil {
    private static int LAST_SAVE_KEYBOARD_HEIGHT = 0;
    private static int LAST_SAVE_KEYBOARD_HEIGHT_PORT = 0;
    private static int MAX_PANEL_HEIGHT = 0;
    private static int MAX_PANEL_HEIGHT_PORT = 0;
    private static int MIN_KEYBOARD_HEIGHT = 0;
    private static int MIN_PANEL_HEIGHT = 0;
    private static int MIN_PANEL_HEIGHT_PORT = 0;
    /* access modifiers changed from: private */
    public static ArrayList<OnKeyboardShowingListener> onKeyboardShowingListeners = new ArrayList<>();

    public interface OnKeyboardShowingListener {
        void onKeyboardShowing(boolean z);
    }

    public static void registKeyboardShowingListener(OnKeyboardShowingListener onKeyboardShowingListener) {
        onKeyboardShowingListeners.add(onKeyboardShowingListener);
    }

    public static void unRegistKeyboardShowingListener(OnKeyboardShowingListener onKeyboardShowingListener) {
        onKeyboardShowingListeners.remove(onKeyboardShowingListener);
    }

    public static void showKeyboard(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void hideKeyboard(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean hideKeyboard(MotionEvent motionEvent, View view) {
        if (view != null) {
            try {
                if (view instanceof EditText) {
                    int[] iArr = {0, 0};
                    view.getLocationInWindow(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = view.getWidth() + i;
                    int height = view.getHeight() + i2;
                    if (motionEvent.getRawX() < ((float) i) || motionEvent.getRawX() > ((float) width) || motionEvent.getY() < ((float) i2) || motionEvent.getRawY() > ((float) height)) {
                        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean saveKeyboardHeight(Context context, int i) {
        if (1 == context.getResources().getConfiguration().orientation) {
            if (LAST_SAVE_KEYBOARD_HEIGHT_PORT == i || i < 0) {
                return false;
            }
            LAST_SAVE_KEYBOARD_HEIGHT_PORT = i;
            XesLog.it("saveKeyboardHeight(port):keyboardHeight=" + i, new Object[0]);
            return KeyBoardSharedPreferences.save(context, i);
        } else if (LAST_SAVE_KEYBOARD_HEIGHT == i || i < 0) {
            return false;
        } else {
            LAST_SAVE_KEYBOARD_HEIGHT = i;
            XesLog.it("saveKeyboardHeight(land):keyboardHeight=" + i, new Object[0]);
            return KeyBoardSharedPreferences.save(context, i);
        }
    }

    public static int getKeyboardHeight(Context context) {
        if (1 == context.getResources().getConfiguration().orientation) {
            if (LAST_SAVE_KEYBOARD_HEIGHT_PORT == 0) {
                LAST_SAVE_KEYBOARD_HEIGHT_PORT = KeyBoardSharedPreferences.get(context, getMinPanelHeight(context.getResources()));
            }
            return LAST_SAVE_KEYBOARD_HEIGHT_PORT;
        }
        if (LAST_SAVE_KEYBOARD_HEIGHT == 0) {
            LAST_SAVE_KEYBOARD_HEIGHT = KeyBoardSharedPreferences.get(context, getMinPanelHeight(context.getResources()));
        }
        return LAST_SAVE_KEYBOARD_HEIGHT;
    }

    public static int getValidPanelHeight(Context context) {
        return Math.min(getMaxPanelHeight(context.getResources()), Math.max(getMinPanelHeight(context.getResources()), getKeyboardHeight(context)));
    }

    public static int getMaxPanelHeight(Resources resources) {
        if (1 == resources.getConfiguration().orientation) {
            if (MAX_PANEL_HEIGHT_PORT == 0) {
                if (TableUtils.isTable()) {
                    MAX_PANEL_HEIGHT_PORT = resources.getDimensionPixelSize(R.dimen.max_panel_height_port_pad);
                } else {
                    MAX_PANEL_HEIGHT_PORT = resources.getDimensionPixelSize(R.dimen.max_panel_height_port);
                }
            }
            return MAX_PANEL_HEIGHT_PORT;
        }
        if (MAX_PANEL_HEIGHT == 0) {
            if (TableUtils.isTable()) {
                MAX_PANEL_HEIGHT = resources.getDimensionPixelSize(R.dimen.max_panel_height_pad);
            } else {
                MAX_PANEL_HEIGHT = resources.getDimensionPixelSize(R.dimen.max_panel_height);
            }
        }
        return MAX_PANEL_HEIGHT;
    }

    public static int getMinPanelHeight(Resources resources) {
        if (1 == resources.getConfiguration().orientation) {
            if (MIN_PANEL_HEIGHT_PORT == 0) {
                MIN_PANEL_HEIGHT_PORT = resources.getDimensionPixelSize(R.dimen.min_panel_height_port);
            }
            return MIN_PANEL_HEIGHT_PORT;
        }
        if (MIN_PANEL_HEIGHT == 0) {
            MIN_PANEL_HEIGHT = resources.getDimensionPixelSize(R.dimen.min_panel_height);
        }
        return MIN_PANEL_HEIGHT;
    }

    public static int getMinKeyboardHeight(Context context) {
        if (MIN_KEYBOARD_HEIGHT == 0) {
            MIN_KEYBOARD_HEIGHT = context.getResources().getDimensionPixelSize(R.dimen.min_keyboard_height);
        }
        return MIN_KEYBOARD_HEIGHT;
    }

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, IPanelHeightTarget iPanelHeightTarget, OnKeyboardShowingListener onKeyboardShowingListener) {
        int i;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean isFullScreen = ViewUtil.isFullScreen(activity);
        boolean isTranslucentStatus = ViewUtil.isTranslucentStatus(activity);
        boolean isFitsSystemWindows = ViewUtil.isFitsSystemWindows(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.y;
        } else {
            i = defaultDisplay.getHeight();
        }
        KeyboardStatusListener keyboardStatusListener = new KeyboardStatusListener(isFullScreen, isTranslucentStatus, isFitsSystemWindows, viewGroup, iPanelHeightTarget, onKeyboardShowingListener, i);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(keyboardStatusListener);
        return keyboardStatusListener;
    }

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, IPanelHeightTarget iPanelHeightTarget) {
        return attach(activity, iPanelHeightTarget, (OnKeyboardShowingListener) null);
    }

    public static void detach(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (Build.VERSION.SDK_INT >= 16) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    private static class KeyboardStatusListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private static final int KEYBOARD_MIN_HEIGHT = SizeUtils.dp2px(100.0f);
        private static final String TAG = "KeyboardStatusListener";
        private final ViewGroup contentView;
        private final boolean isFitSystemWindows;
        private final boolean isFullScreen;
        private boolean isOverlayLayoutDisplayHContainStatusBar = false;
        private final boolean isTranslucentStatus;
        private final OnKeyboardShowingListener keyboardShowingListener;
        private boolean lastKeyboardShowing;
        private int maxOverlayLayoutHeight;
        private final IPanelHeightTarget panelHeightTarget;
        private int previousDisplayHeight = 0;
        private int previousDisplayHeightPort = 0;
        private final int screenHeight;
        private final int statusBarHeight;

        KeyboardStatusListener(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnKeyboardShowingListener onKeyboardShowingListener, int i) {
            this.contentView = viewGroup;
            this.panelHeightTarget = iPanelHeightTarget;
            this.isFullScreen = z;
            this.isTranslucentStatus = z2;
            this.isFitSystemWindows = z3;
            this.statusBarHeight = BarUtils.getStatusBarHeight();
            this.keyboardShowingListener = onKeyboardShowingListener;
            this.screenHeight = i;
        }

        public void onGlobalLayout() {
            int i;
            int i2 = 0;
            View childAt = this.contentView.getChildAt(0);
            if (childAt == null) {
                Context context = this.contentView.getContext();
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    return;
                }
                return;
            }
            View view = (View) this.contentView.getParent();
            Rect rect = new Rect();
            if (this.isTranslucentStatus) {
                view.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
                if (!this.isOverlayLayoutDisplayHContainStatusBar) {
                    this.isOverlayLayoutDisplayHContainStatusBar = i == this.screenHeight;
                }
                if (!this.isOverlayLayoutDisplayHContainStatusBar) {
                    i += this.statusBarHeight;
                }
            } else {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            }
            IPanelHeightTarget iPanelHeightTarget = this.panelHeightTarget;
            if (iPanelHeightTarget != null && (iPanelHeightTarget instanceof KPSwitchFSPanelLinearLayout)) {
                i2 = ((KPSwitchFSPanelLinearLayout) iPanelHeightTarget).getOrientation();
            }
            if (i2 == 0 || i2 == getContext().getResources().getConfiguration().orientation) {
                if (i2 == 0) {
                    i2 = getContext().getResources().getConfiguration().orientation;
                }
                calculateKeyboardHeight(i, i2);
                calculateKeyboardShowing(i);
                if (1 == i2) {
                    this.previousDisplayHeightPort = i;
                } else {
                    this.previousDisplayHeight = i;
                }
            }
        }

        private void calculateKeyboardHeight(int i, int i2) {
            int i3;
            ViewGroup.LayoutParams layoutParams;
            int i4 = 0;
            if (1 == i2) {
                if (this.previousDisplayHeightPort == 0) {
                    this.previousDisplayHeightPort = i;
                    this.panelHeightTarget.refreshHeight(KeyboardUtil.getValidPanelHeight(getContext()));
                    XesLog.it("calculateKeyboardHeight:displayHeight=" + i + ",orientation=port", new Object[0]);
                    return;
                }
            } else if (this.previousDisplayHeight == 0) {
                this.previousDisplayHeight = i;
                this.panelHeightTarget.refreshHeight(KeyboardUtil.getValidPanelHeight(getContext()));
                XesLog.it("calculateKeyboardHeight:displayHeight=" + i + ",orientation=" + i2, new Object[0]);
                return;
            }
            if (KPSwitchConflictUtil.isHandleByPlaceholder(this.isFullScreen, this.isTranslucentStatus, this.isFitSystemWindows)) {
                i3 = ((View) this.contentView.getParent()).getHeight() - i;
                XesLog.it("calculateKeyboardHeight:Height=" + ((View) this.contentView.getParent()).getHeight() + ",displayHeight=" + i, new Object[0]);
            } else if (1 == i2) {
                i3 = Math.abs(i - this.previousDisplayHeightPort);
            } else {
                i3 = Math.abs(i - this.previousDisplayHeight);
            }
            if (i3 > KeyboardUtil.getMinKeyboardHeight(getContext())) {
                if (1 == i2) {
                    XesLog.it("calculateKeyboardHeight:previousDisplayHeightPort=" + this.previousDisplayHeightPort + ",displayHeight=" + i + ",keyboardHeight=" + i3, new Object[0]);
                } else {
                    XesLog.it("calculateKeyboardHeight:previousDisplayHeight=" + this.previousDisplayHeight + ",displayHeight=" + i + ",keyboardHeight=" + i3, new Object[0]);
                }
                if (i3 == this.statusBarHeight) {
                    XesLog.wt("calculateKeyboardHeight:On global layout change get keyboard height just equal statusBar height", new Object[0]);
                    return;
                }
                boolean unused = KeyboardUtil.saveKeyboardHeight(getContext(), i3);
                int validPanelHeight = KeyboardUtil.getValidPanelHeight(getContext());
                IPanelHeightTarget iPanelHeightTarget = this.panelHeightTarget;
                if ((iPanelHeightTarget instanceof ViewGroup) && (layoutParams = ((ViewGroup) iPanelHeightTarget).getLayoutParams()) != null) {
                    i4 = layoutParams.height;
                }
                if (i4 != validPanelHeight) {
                    this.panelHeightTarget.refreshHeight(validPanelHeight);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
            if ((r1 - (com.tal.app.thinkacademy.lib.util.BarUtils.getNavBarHeight() + r6)) > KEYBOARD_MIN_HEIGHT) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
            if ((r1 - r6) > KEYBOARD_MIN_HEIGHT) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
            r0 = r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void calculateKeyboardShowing(int r6) {
            /*
                r5 = this;
                android.view.ViewGroup r0 = r5.contentView
                android.view.ViewParent r0 = r0.getParent()
                android.view.View r0 = (android.view.View) r0
                int r1 = r0.getHeight()
                int r0 = r0.getPaddingTop()
                int r1 = r1 - r0
                boolean r0 = r5.isFullScreen
                boolean r2 = r5.isTranslucentStatus
                boolean r3 = r5.isFitSystemWindows
                boolean r0 = cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil.isHandleByPlaceholder(r0, r2, r3)
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x0087
                boolean r0 = r5.isTranslucentStatus
                if (r0 != 0) goto L_0x002c
                int r0 = r1 - r6
                int r4 = r5.statusBarHeight
                if (r0 != r4) goto L_0x002c
                boolean r0 = r5.lastKeyboardShowing
                goto L_0x0068
            L_0x002c:
                boolean r0 = com.tal.app.thinkacademy.lib.utils.TableUtils.isTable()
                if (r0 == 0) goto L_0x005f
                android.view.ViewGroup r0 = r5.contentView
                android.content.Context r0 = r0.getContext()
                android.app.Activity r0 = com.tal.app.thinkacademy.lib.util.ActivityUtils.getActivityByContext(r0)
                if (r0 == 0) goto L_0x005f
                android.view.ViewGroup r0 = r5.contentView
                android.content.Context r0 = r0.getContext()
                android.app.Activity r0 = com.tal.app.thinkacademy.lib.util.ActivityUtils.getActivityByContext(r0)
                java.util.Objects.requireNonNull(r0)
                android.app.Activity r0 = (android.app.Activity) r0
                boolean r0 = com.tal.app.thinkacademy.lib.util.BarUtils.isNavBarVisible(r0)
                if (r0 == 0) goto L_0x005f
                int r0 = com.tal.app.thinkacademy.lib.util.BarUtils.getNavBarHeight()
                int r0 = r0 + r6
                int r0 = r1 - r0
                int r4 = KEYBOARD_MIN_HEIGHT
                if (r0 <= r4) goto L_0x0066
                goto L_0x0067
            L_0x005f:
                int r0 = r1 - r6
                int r4 = KEYBOARD_MIN_HEIGHT
                if (r0 <= r4) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r2 = r3
            L_0x0067:
                r0 = r2
            L_0x0068:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "calculateKeyboardShowing:actionBarOverlayLayoutHeight="
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = ",displayHeight="
                r2.append(r1)
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                java.lang.Object[] r1 = new java.lang.Object[r3]
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r6, r1)
                goto L_0x00d6
            L_0x0087:
                android.view.ViewGroup r0 = r5.contentView
                android.content.res.Resources r0 = r0.getResources()
                android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
                int r0 = r0.heightPixels
                boolean r4 = r5.isTranslucentStatus
                if (r4 != 0) goto L_0x00b8
                if (r0 != r1) goto L_0x00b8
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = "calculateKeyboardShowing:skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d"
                r6.append(r2)
                r6.append(r0)
                java.lang.String r0 = ""
                r6.append(r0)
                r6.append(r1)
                java.lang.String r6 = r6.toString()
                java.lang.Object[] r0 = new java.lang.Object[r3]
                com.tal.app.thinkacademy.lib.logger.XesLog.wt(r6, r0)
                return
            L_0x00b8:
                int r0 = r5.maxOverlayLayoutHeight
                if (r0 != 0) goto L_0x00c0
                boolean r6 = r5.lastKeyboardShowing
                r0 = r6
                goto L_0x00ce
            L_0x00c0:
                android.content.Context r4 = r5.getContext()
                int r4 = cn.dreamtobe.kpswitch.util.KeyboardUtil.getMinKeyboardHeight(r4)
                int r0 = r0 - r4
                if (r6 >= r0) goto L_0x00cc
                goto L_0x00cd
            L_0x00cc:
                r2 = r3
            L_0x00cd:
                r0 = r2
            L_0x00ce:
                int r6 = r5.maxOverlayLayoutHeight
                int r6 = java.lang.Math.max(r6, r1)
                r5.maxOverlayLayoutHeight = r6
            L_0x00d6:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = "calculateKeyboardShowing:lastKeyboardShowing="
                r6.append(r1)
                boolean r1 = r5.lastKeyboardShowing
                r6.append(r1)
                java.lang.String r1 = ",isKeyboardShowing="
                r6.append(r1)
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                java.lang.Object[] r1 = new java.lang.Object[r3]
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r6, r1)
                boolean r6 = r5.lastKeyboardShowing
                if (r6 == r0) goto L_0x0120
                cn.dreamtobe.kpswitch.IPanelHeightTarget r6 = r5.panelHeightTarget
                r6.onKeyboardShowing(r0)
                cn.dreamtobe.kpswitch.util.KeyboardUtil$OnKeyboardShowingListener r6 = r5.keyboardShowingListener
                if (r6 == 0) goto L_0x0120
                r6.onKeyboardShowing(r0)
            L_0x0106:
                java.util.ArrayList r6 = cn.dreamtobe.kpswitch.util.KeyboardUtil.onKeyboardShowingListeners
                int r6 = r6.size()
                if (r3 >= r6) goto L_0x0120
                java.util.ArrayList r6 = cn.dreamtobe.kpswitch.util.KeyboardUtil.onKeyboardShowingListeners
                java.lang.Object r6 = r6.get(r3)
                cn.dreamtobe.kpswitch.util.KeyboardUtil$OnKeyboardShowingListener r6 = (cn.dreamtobe.kpswitch.util.KeyboardUtil.OnKeyboardShowingListener) r6
                r6.onKeyboardShowing(r0)
                int r3 = r3 + 1
                goto L_0x0106
            L_0x0120:
                r5.lastKeyboardShowing = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.dreamtobe.kpswitch.util.KeyboardUtil.KeyboardStatusListener.calculateKeyboardShowing(int):void");
        }

        private Context getContext() {
            return this.contentView.getContext();
        }
    }
}
