package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TabHost;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WindowHelper {
    private static boolean sArrayListWindowViews = false;
    private static final String sCustomWindowPrefix = "/CustomWindow";
    private static final String sDialogWindowPrefix = "/DialogWindow";
    private static boolean sIsInitialized = false;
    private static Method sItemViewGetDataMethod = null;
    private static Class<?> sListMenuItemViewClazz = null;
    private static final String sMainWindowPrefix = "/MainWindow";
    private static Class sPhoneWindowClazz = null;
    private static Class sPopupWindowClazz = null;
    private static final String sPopupWindowPrefix = "/PopupWindow";
    private static boolean sViewArrayWindowViews = false;
    private static Comparator<View> sViewSizeComparator = new Comparator<View>() {
        public int compare(View view, View view2) {
            int hashCode = view.hashCode();
            int hashCode2 = view2.hashCode();
            int currentRootWindowsHashCode = AppStateManager.getInstance().getCurrentRootWindowsHashCode();
            if (hashCode == currentRootWindowsHashCode) {
                return -1;
            }
            if (hashCode2 == currentRootWindowsHashCode) {
                return 1;
            }
            return (view2.getWidth() * view2.getHeight()) - (view.getWidth() * view.getHeight());
        }
    };
    private static Object sWindowManger;
    private static Field viewsField;

    public static String getMainWindowPrefix() {
        return sMainWindowPrefix;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:2|(1:4)(1:5)|6|(6:7|8|(1:10)(2:11|(1:13)(1:14))|15|(1:17)(2:18|(1:20))|21)|22|24|25|26|28|29|(3:31|32|33)(1:38)|39|40|(1:42)(1:43)|44|46) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097 A[Catch:{ ClassNotFoundException -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0 A[Catch:{ ClassNotFoundException -> 0x00a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init() {
        /*
            boolean r0 = sIsInitialized
            if (r0 != 0) goto L_0x00aa
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 < r1) goto L_0x000d
            java.lang.String r0 = "android.view.WindowManagerGlobal"
            goto L_0x000f
        L_0x000d:
            java.lang.String r0 = "android.view.WindowManagerImpl"
        L_0x000f:
            r2 = 1
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            if (r3 < r1) goto L_0x001b
            java.lang.String r1 = "sDefaultWindowManager"
            goto L_0x0026
        L_0x001b:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            r3 = 13
            if (r1 < r3) goto L_0x0024
            java.lang.String r1 = "sWindowManager"
            goto L_0x0026
        L_0x0024:
            java.lang.String r1 = "mWindowManager"
        L_0x0026:
            java.lang.String r3 = "mViews"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            viewsField = r3     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            r1.setAccessible(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.Class r1 = r1.getType()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.Class<java.util.ArrayList> r3 = java.util.ArrayList.class
            if (r1 != r3) goto L_0x0044
            sArrayListWindowViews = r2     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            goto L_0x0050
        L_0x0044:
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.Class r1 = r1.getType()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            java.lang.Class<android.view.View[]> r3 = android.view.View[].class
            if (r1 != r3) goto L_0x0050
            sViewArrayWindowViews = r2     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
        L_0x0050:
            r0.setAccessible(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
            sWindowManger = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x005a }
        L_0x005a:
            java.lang.String r0 = "com.android.internal.view.menu.ListMenuItemView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
            sListMenuItemViewClazz = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
            java.lang.String r0 = "com.android.internal.view.menu.MenuView$ItemView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
            java.lang.String r1 = "getItemData"
            r3 = 0
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
            sItemViewGetDataMethod = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0073 }
        L_0x0073:
            r0 = 23
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x0093 }
            if (r1 < r0) goto L_0x008b
            java.lang.String r1 = "com.android.internal.policy.PhoneWindow$DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0082 }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x0082 }
            goto L_0x0093
        L_0x0082:
            java.lang.String r1 = "com.android.internal.policy.DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0093 }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x0093 }
            goto L_0x0093
        L_0x008b:
            java.lang.String r1 = "com.android.internal.policy.impl.PhoneWindow$DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0093 }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x0093 }
        L_0x0093:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x00a8 }
            if (r1 < r0) goto L_0x00a0
            java.lang.String r0 = "android.widget.PopupWindow$PopupDecorView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a8 }
            sPopupWindowClazz = r0     // Catch:{ ClassNotFoundException -> 0x00a8 }
            goto L_0x00a8
        L_0x00a0:
            java.lang.String r0 = "android.widget.PopupWindow$PopupViewContainer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a8 }
            sPopupWindowClazz = r0     // Catch:{ ClassNotFoundException -> 0x00a8 }
        L_0x00a8:
            sIsInitialized = r2
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.WindowHelper.init():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.View[]} */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View[] getWindowViews() {
        /*
            r0 = 0
            android.view.View[] r1 = new android.view.View[r0]
            java.lang.Object r2 = sWindowManger
            r3 = 0
            if (r2 != 0) goto L_0x0028
            com.sensorsdata.analytics.android.sdk.AppStateManager r2 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()
            android.app.Activity r2 = r2.getForegroundActivity()
            if (r2 == 0) goto L_0x0020
            android.view.Window r4 = r2.getWindow()
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x0020
            android.view.View r3 = r4.getDecorView()
        L_0x0020:
            if (r2 == 0) goto L_0x0027
            r1 = 1
            android.view.View[] r1 = new android.view.View[r1]
            r1[r0] = r3
        L_0x0027:
            return r1
        L_0x0028:
            boolean r0 = sArrayListWindowViews     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x003e
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0050 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x0050 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ Exception -> 0x0050 }
            android.view.View[] r0 = (android.view.View[]) r0     // Catch:{ Exception -> 0x0050 }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x0050 }
            goto L_0x004d
        L_0x003e:
            boolean r0 = sViewArrayWindowViews     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x004d
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0050 }
            android.view.View[] r0 = (android.view.View[]) r0     // Catch:{ Exception -> 0x0050 }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x0050 }
        L_0x004d:
            if (r3 == 0) goto L_0x0050
            r1 = r3
        L_0x0050:
            android.view.View[] r0 = filterNullAndDismissToastView(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowViews():android.view.View[]");
    }

    public static View[] getSortedWindowViews() {
        View[] windowViews = getWindowViews();
        if (windowViews.length <= 1) {
            return windowViews;
        }
        View[] viewArr = (View[]) Arrays.copyOf(windowViews, windowViews.length);
        Arrays.sort(viewArr, sViewSizeComparator);
        return viewArr;
    }

    private static View[] filterNullAndDismissToastView(View[] viewArr) {
        ArrayList arrayList = new ArrayList(viewArr.length);
        System.currentTimeMillis();
        for (View view : viewArr) {
            if (view != null) {
                arrayList.add(view);
            }
        }
        View[] viewArr2 = new View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    public static boolean isDecorView(Class cls) {
        if (!sIsInitialized) {
            init();
        }
        return cls == sPhoneWindowClazz || cls == sPopupWindowClazz;
    }

    private static Object getMenuItemData(View view) throws InvocationTargetException, IllegalAccessException {
        if (view.getClass() == sListMenuItemViewClazz) {
            return sItemViewGetDataMethod.invoke(view, new Object[0]);
        }
        if (ViewUtil.instanceOfAndroidXListMenuItemView(view) || ViewUtil.instanceOfSupportListMenuItemView(view) || ViewUtil.instanceOfBottomNavigationItemView(view)) {
            return ViewUtil.getItemData(view);
        }
        return null;
    }

    private static View findMenuItemView(View view, MenuItem menuItem) throws InvocationTargetException, IllegalAccessException {
        View view2;
        if ((ViewUtil.instanceOfActionMenuItem(menuItem) && menuItem.getItemId() == 16908332 && ViewUtil.instanceOfToolbar(view.getParent()) && (view instanceof ImageButton) && (view2 = (View) ReflectUtil.findField(new String[]{"androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar"}, (Object) view.getParent(), "mNavButtonView")) != null && view2 == view) || getMenuItemData(view) == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            View findMenuItemView = findMenuItemView(viewGroup.getChildAt(i), menuItem);
            if (findMenuItemView != null) {
                return findMenuItemView;
            }
            i++;
        }
    }

    public static View getClickView(MenuItem menuItem) {
        View findMenuItemView;
        View findMenuItemView2;
        if (menuItem == null) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        try {
            for (View view : windowViews) {
                if (view.getClass() == sPopupWindowClazz && (findMenuItemView2 = findMenuItemView(view, menuItem)) != null) {
                    return findMenuItemView2;
                }
            }
            for (View view2 : windowViews) {
                if (view2.getClass() != sPopupWindowClazz && (findMenuItemView = findMenuItemView(view2, menuItem)) != null) {
                    return findMenuItemView;
                }
            }
        } catch (Exception | IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    public static View getClickView(String str) {
        View findTabView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        int i = 0;
        while (i < windowViews.length) {
            try {
                View view = windowViews[i];
                if (view.getClass() != sPopupWindowClazz && (findTabView = findTabView(view, str)) != null) {
                    return findTabView;
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static View findTabView(View view, String str) {
        int i = 0;
        if (TextUtils.equals(str, getTabHostTag(view))) {
            return (View) ReflectUtil.callMethod(view, "getCurrentTabView", new Object[0]);
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            View findTabView = findTabView(viewGroup.getChildAt(i), str);
            if (findTabView != null) {
                return findTabView;
            }
            i++;
        }
    }

    private static String getTabHostTag(View view) {
        if (view instanceof TabHost) {
            return (String) ReflectUtil.callMethod(view, "getCurrentTabTag", new Object[0]);
        }
        return null;
    }

    public static String getWindowPrefix(View view) {
        if (view.hashCode() == AppStateManager.getInstance().getCurrentRootWindowsHashCode()) {
            return getMainWindowPrefix();
        }
        return getSubWindowPrefix(view);
    }

    private static String getSubWindowPrefix(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof WindowManager.LayoutParams)) {
            int i = ((WindowManager.LayoutParams) layoutParams).type;
            if (i == 1) {
                return sMainWindowPrefix;
            }
            if (i < 99 && view.getClass() == sPhoneWindowClazz) {
                return sDialogWindowPrefix;
            }
            if (i < 1999 && view.getClass() == sPopupWindowClazz) {
                return sPopupWindowPrefix;
            }
            if (i < 2999) {
                return sCustomWindowPrefix;
            }
        }
        Class<?> cls = view.getClass();
        if (cls == sPhoneWindowClazz) {
            return sDialogWindowPrefix;
        }
        return cls == sPopupWindowClazz ? sPopupWindowPrefix : sCustomWindowPrefix;
    }

    public static boolean isMainWindow(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 1) {
            return false;
        }
        return true;
    }

    public static boolean isDialogOrPopupWindow(View view) {
        String subWindowPrefix = getSubWindowPrefix(view);
        return TextUtils.equals(sDialogWindowPrefix, subWindowPrefix) || TextUtils.equals(sPopupWindowPrefix, subWindowPrefix);
    }
}
