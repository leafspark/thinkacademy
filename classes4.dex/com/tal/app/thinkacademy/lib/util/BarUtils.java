package com.tal.app.thinkacademy.lib.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.drawerlayout.widget.DrawerLayout;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;

public final class BarUtils {
    private static final int KEY_OFFSET = -123;
    private static final String TAG_OFFSET = "TAG_OFFSET";
    private static final String TAG_STATUS_BAR = "TAG_STATUS_BAR";

    private BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void setStatusBarVisibility(Activity activity, boolean z) {
        setStatusBarVisibility(activity.getWindow(), z);
    }

    public static void setStatusBarVisibility(Window window, boolean z) {
        if (z) {
            window.clearFlags(1024);
            showStatusBarView(window);
            addMarginTopEqualStatusBarHeight(window);
            return;
        }
        window.addFlags(1024);
        hideStatusBarView(window);
        subtractMarginTopEqualStatusBarHeight(window);
    }

    public static boolean isStatusBarVisible(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }

    public static void setStatusBarLightMode(Activity activity, boolean z) {
        setStatusBarLightMode(activity.getWindow(), z);
    }

    public static void setStatusBarLightMode(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    public static boolean isStatusBarLightMode(Activity activity) {
        return isStatusBarLightMode(activity.getWindow());
    }

    public static boolean isStatusBarLightMode(Window window) {
        if (Build.VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static void addMarginTopEqualStatusBarHeight(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setTag(TAG_OFFSET);
            Object tag = view.getTag(KEY_OFFSET);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(KEY_OFFSET, true);
            }
        }
    }

    public static void subtractMarginTopEqualStatusBarHeight(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 19 && (tag = view.getTag(KEY_OFFSET)) != null && ((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(KEY_OFFSET, false);
        }
    }

    private static void addMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            addMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }

    private static void subtractMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            subtractMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }

    public static View setStatusBarColor(Activity activity, int i) {
        return setStatusBarColor(activity, i, false);
    }

    public static View setStatusBarColor(Activity activity, int i, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(activity);
        return applyStatusBarColor(activity, i, z);
    }

    public static View setStatusBarColor(Window window, int i) {
        return setStatusBarColor(window, i, false);
    }

    public static View setStatusBarColor(Window window, int i, boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(window);
        return applyStatusBarColor(window, i, z);
    }

    public static void setStatusBarColor(View view, int i) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
            view.setBackgroundColor(i);
        }
    }

    public static void setStatusBarCustom(View view) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
                return;
            }
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
        }
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i) {
        setStatusBarColor4Drawer(drawerLayout, view, i, false);
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i, boolean z) {
        Activity activityByContext;
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            drawerLayout.setFitsSystemWindows(false);
            setStatusBarColor(view, i);
            int childCount = drawerLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                drawerLayout.getChildAt(i2).setFitsSystemWindows(false);
            }
            if (z) {
                hideStatusBarView(activityByContext);
            } else {
                setStatusBarColor(activityByContext, i, false);
            }
        }
    }

    private static View applyStatusBarColor(Activity activity, int i, boolean z) {
        return applyStatusBarColor(activity.getWindow(), i, z);
    }

    private static View applyStatusBarColor(Window window, int i, boolean z) {
        ViewGroup viewGroup;
        if (z) {
            viewGroup = (ViewGroup) window.getDecorView();
        } else {
            viewGroup = (ViewGroup) window.findViewById(16908290);
        }
        View findViewWithTag = viewGroup.findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            if (findViewWithTag.getVisibility() == 8) {
                findViewWithTag.setVisibility(0);
            }
            findViewWithTag.setBackgroundColor(i);
            return findViewWithTag;
        }
        View createStatusBarView = createStatusBarView(window.getContext(), i);
        viewGroup.addView(createStatusBarView);
        return createStatusBarView;
    }

    private static void hideStatusBarView(Activity activity) {
        hideStatusBarView(activity.getWindow());
    }

    private static void hideStatusBarView(Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
    }

    private static void showStatusBarView(Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(0);
        }
    }

    private static View createStatusBarView(Context context, int i) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
        view.setBackgroundColor(i);
        view.setTag(TAG_STATUS_BAR);
        return view;
    }

    public static void transparentStatusBar(Activity activity) {
        transparentStatusBar(activity.getWindow());
    }

    public static void transparentStatusBar(Window window) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | AppConfig.SCREEN_RESOLUTION_LANDSCAPE_PAD);
                window.setStatusBarColor(0);
                return;
            }
            window.addFlags(67108864);
        }
    }

    public static int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (Utils.getApp().getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, Resources.getSystem().getDisplayMetrics());
        }
        return 0;
    }

    public static void setNotificationBarVisibility(boolean z) {
        String str;
        if (z) {
            str = Build.VERSION.SDK_INT <= 16 ? "expand" : "expandNotificationsPanel";
        } else {
            str = Build.VERSION.SDK_INT <= 16 ? "collapse" : "collapsePanels";
        }
        invokePanels(str);
    }

    private static void invokePanels(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.getApp().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getNavBarHeight() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void setNavBarVisibility(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            setNavBarVisibility(activity.getWindow(), z);
        }
    }

    public static void setNavBarVisibility(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                int id = childAt.getId();
                if (id != -1 && "navigationBarBackground".equals(getResNameById(id))) {
                    childAt.setVisibility(z ? 0 : 4);
                }
            }
            if (z) {
                viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & -4611);
            } else {
                viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
            }
        }
    }

    public static boolean isNavBarVisible(Activity activity) {
        return isNavBarVisible(activity.getWindow());
    }

    public static boolean isNavBarVisible(Window window) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(getResNameById(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return z;
        }
        if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
            z2 = true;
        }
        return z2;
    }

    private static String getResNameById(int i) {
        try {
            return Utils.getApp().getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void setNavBarColor(Activity activity, int i) {
        setNavBarColor(activity.getWindow(), i);
    }

    public static void setNavBarColor(Window window, int i) {
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i);
    }

    public static int getNavBarColor(Activity activity) {
        return getNavBarColor(activity.getWindow());
    }

    public static int getNavBarColor(Window window) {
        return window.getNavigationBarColor();
    }

    public static boolean isSupportNavBar() {
        if (Build.VERSION.SDK_INT >= 17) {
            WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y == point.y && point2.x == point.x) {
                return false;
            }
            return true;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(Utils.getApp()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return false;
        }
        return true;
    }

    public static void setNavBarLightMode(Activity activity, boolean z) {
        setNavBarLightMode(activity.getWindow(), z);
    }

    public static void setNavBarLightMode(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & -17);
        }
    }

    public static boolean isNavBarLightMode(Activity activity) {
        return isNavBarLightMode(activity.getWindow());
    }

    public static boolean isNavBarLightMode(Window window) {
        if (Build.VERSION.SDK_INT < 26 || (window.getDecorView().getSystemUiVisibility() & 16) == 0) {
            return false;
        }
        return true;
    }
}
