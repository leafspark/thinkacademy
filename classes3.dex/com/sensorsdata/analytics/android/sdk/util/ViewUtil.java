package com.sensorsdata.analytics.android.sdk.util;

import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ToggleButton;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ViewUtil {
    private static LruCache<Class, String> sClassNameCache = null;
    private static boolean sHaveCustomRecyclerView = false;
    private static boolean sHaveRecyclerView = haveRecyclerView();
    private static Class sRecyclerViewClass;
    private static Method sRecyclerViewGetChildAdapterPositionMethod;
    private static SparseArray sViewCache;

    private static boolean instanceOfSupportSwipeRefreshLayout(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout", "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    }

    static boolean instanceOfSupportListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    static boolean instanceOfAndroidXListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    static boolean instanceOfBottomNavigationItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.bottomnavigation.BottomNavigationItemView", "com.google.android.material.internal.NavigationMenuItemView");
    }

    static boolean instanceOfActionMenuItem(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ActionMenuItem");
    }

    static boolean instanceOfToolbar(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar");
    }

    private static boolean instanceOfNavigationView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView");
    }

    private static boolean instanceOfSupportViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    private static boolean instanceOfAndroidXViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    public static boolean instanceOfWebView(Object obj) {
        return (obj instanceof WebView) || instanceOfX5WebView(obj) || instanceOfUCWebView(obj);
    }

    public static boolean instanceOfX5WebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.tencent.smtt.sdk.WebView");
    }

    private static boolean instanceOfUCWebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.alipay.mobile.nebulauc.impl.UCWebView$WebViewEx");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = sRecyclerViewClass;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean instanceOfRecyclerView(java.lang.Object r1) {
        /*
            java.lang.String r0 = "androidx.recyclerview.widget.RecyclerView"
            java.lang.String[] r0 = new java.lang.String[]{r0, r0}
            boolean r0 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(r1, r0)
            if (r0 != 0) goto L_0x0024
            boolean r0 = sHaveCustomRecyclerView
            if (r0 == 0) goto L_0x0022
            if (r1 == 0) goto L_0x0022
            java.lang.Class r0 = sRecyclerViewClass
            if (r0 == 0) goto L_0x0022
            java.lang.Class r1 = r1.getClass()
            boolean r1 = r0.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            r0 = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.instanceOfRecyclerView(java.lang.Object):boolean");
    }

    private static Object instanceOfTabView(View view) {
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView"});
            if (currentClass == null || !currentClass.isAssignableFrom(view.getClass())) {
                return null;
            }
            return ReflectUtil.findField(currentClass, (Object) view, "mTab", "tab");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getCanonicalName(Class cls) {
        String str;
        if (Build.VERSION.SDK_INT >= 12) {
            if (sClassNameCache == null) {
                sClassNameCache = new LruCache<>(100);
            }
            str = sClassNameCache.get(cls);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            String canonicalName = cls.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName)) {
                canonicalName = "Anonymous";
            }
            if (Build.VERSION.SDK_INT >= 12) {
                synchronized (ViewUtil.class) {
                    sClassNameCache.put(cls, str);
                }
            }
            checkCustomRecyclerView(cls, str);
        }
        return str;
    }

    private static Object instanceOfFragmentRootView(View view, View view2) {
        Object fragmentFromView = AopUtil.getFragmentFromView(view);
        Object fragmentFromView2 = AopUtil.getFragmentFromView(view2);
        if (fragmentFromView != null || fragmentFromView2 == null) {
            return null;
        }
        return fragmentFromView2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|(2:3|4)|5|(2:8|9)|10|11|(1:24)(2:15|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return -1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getChildAdapterPositionInRecyclerView(android.view.View r6, android.view.ViewGroup r7) {
        /*
            boolean r0 = instanceOfRecyclerView(r7)
            if (r0 == 0) goto L_0x0045
            r0 = 0
            r1 = 1
            java.lang.Class r2 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.String r3 = "getChildAdapterPosition"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.Class<android.view.View> r5 = android.view.View.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x001a }
            sRecyclerViewGetChildAdapterPositionMethod = r2     // Catch:{ NoSuchMethodException -> 0x001a }
        L_0x001a:
            java.lang.reflect.Method r2 = sRecyclerViewGetChildAdapterPositionMethod
            if (r2 != 0) goto L_0x0030
            java.lang.Class r2 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.String r3 = "getChildPosition"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.Class<android.view.View> r5 = android.view.View.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0030 }
            sRecyclerViewGetChildAdapterPositionMethod = r2     // Catch:{ NoSuchMethodException -> 0x0030 }
        L_0x0030:
            java.lang.reflect.Method r2 = sRecyclerViewGetChildAdapterPositionMethod     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            if (r2 == 0) goto L_0x004e
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            r1[r0] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            java.lang.Object r6 = r2.invoke(r7, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            if (r6 == 0) goto L_0x004e
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            int r6 = r6.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            return r6
        L_0x0045:
            boolean r0 = sHaveCustomRecyclerView
            if (r0 == 0) goto L_0x004e
            int r6 = invokeCRVGetChildAdapterPositionMethod(r7, r6)
            return r6
        L_0x004e:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getChildAdapterPositionInRecyclerView(android.view.View, android.view.ViewGroup):int");
    }

    private static int getCurrentItem(View view) {
        try {
            Object invoke = view.getClass().getMethod("getCurrentItem", new Class[0]).invoke(view, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            return -1;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return -1;
        }
    }

    static Object getItemData(View view) {
        try {
            return view.getClass().getMethod("getItemData", new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        java.lang.Class.forName("androidx.recyclerview.widget.RecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean haveRecyclerView() {
        /*
            java.lang.String r0 = "androidx.recyclerview.widget.RecyclerView"
            r1 = 1
            java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0007 }
            return r1
        L_0x0007:
            java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x000b }
            return r1
        L_0x000b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.haveRecyclerView():boolean");
    }

    private static void checkCustomRecyclerView(Class<?> cls, String str) {
        if (!sHaveRecyclerView && !sHaveCustomRecyclerView && str != null && str.contains("RecyclerView")) {
            try {
                if (findRecyclerInSuper(cls) != null && sRecyclerViewGetChildAdapterPositionMethod != null) {
                    sRecyclerViewClass = cls;
                    sHaveCustomRecyclerView = true;
                }
            } catch (Exception unused) {
            }
        }
    }

    private static Class<?> findRecyclerInSuper(Class<?> cls) {
        Class<? super Object> cls2;
        while (cls2 != null && !cls2.equals(ViewGroup.class)) {
            try {
                sRecyclerViewGetChildAdapterPositionMethod = cls2.getDeclaredMethod("getChildAdapterPosition", new Class[]{View.class});
            } catch (NoSuchMethodException unused) {
            }
            if (sRecyclerViewGetChildAdapterPositionMethod == null) {
                try {
                    sRecyclerViewGetChildAdapterPositionMethod = cls2.getDeclaredMethod("getChildPosition", new Class[]{View.class});
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (sRecyclerViewGetChildAdapterPositionMethod != null) {
                return cls2;
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }

    private static int invokeCRVGetChildAdapterPositionMethod(View view, View view2) {
        try {
            if (view.getClass() != sRecyclerViewClass) {
                return -1;
            }
            return ((Integer) sRecyclerViewGetChildAdapterPositionMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return -1;
        }
    }

    private static boolean isListView(View view) {
        return (view instanceof AdapterView) || instanceOfRecyclerView(view) || instanceOfAndroidXViewPager(view) || instanceOfSupportViewPager(view);
    }

    public static boolean isViewSelfVisible(View view) {
        if (!(view == null || view.getWindowVisibility() == 8)) {
            if (WindowHelper.isDecorView(view.getClass())) {
                return true;
            }
            if (view.getWidth() > 0 && view.getHeight() > 0 && view.getAlpha() > 0.0f && view.getLocalVisibleRect(new Rect())) {
                if ((view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) && view.getVisibility() != 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean viewVisibilityInParents(android.view.View r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = isViewSelfVisible(r2)
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            android.view.ViewParent r2 = r2.getParent()
        L_0x000f:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L_0x0024
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            boolean r1 = isViewSelfVisible(r1)
            if (r1 != 0) goto L_0x001d
            return r0
        L_0x001d:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x0024:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.viewVisibilityInParents(android.view.View):boolean");
    }

    public static void invalidateLayerTypeView(View[] viewArr) {
        for (ViewGroup viewGroup : viewArr) {
            if (viewVisibilityInParents(viewGroup) && viewGroup.isHardwareAccelerated()) {
                checkAndInvalidate(viewGroup);
                if (viewGroup instanceof ViewGroup) {
                    invalidateViewGroup(viewGroup);
                }
            }
        }
    }

    private static void checkAndInvalidate(View view) {
        if (view.getLayerType() != 0) {
            view.invalidate();
        }
    }

    private static void invalidateViewGroup(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (isViewSelfVisible(childAt)) {
                checkAndInvalidate(childAt);
                if (childAt instanceof ViewGroup) {
                    invalidateViewGroup((ViewGroup) childAt);
                }
            }
        }
    }

    public static int getMainWindowCount(View[] viewArr) {
        WindowHelper.init();
        int i = 0;
        for (View view : viewArr) {
            if (view != null) {
                i += WindowHelper.getWindowPrefix(view).equals(WindowHelper.getMainWindowPrefix()) ? 1 : 0;
            }
        }
        return i;
    }

    public static boolean isWindowNeedTraverse(View view, String str, boolean z) {
        if (view.hashCode() == AppStateManager.getInstance().getCurrentRootWindowsHashCode()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        if (!z) {
            return true;
        }
        if (view.getWindowVisibility() == 8 || view.getVisibility() != 0 || TextUtils.equals(str, WindowHelper.getMainWindowPrefix()) || view.getWidth() == 0 || view.getHeight() == 0) {
            return false;
        }
        return true;
    }

    public static ViewNode getViewPathAndPosition(View view) {
        return getViewPathAndPosition(view, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewPathAndPosition(android.view.View r13, boolean r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 8
            r0.<init>(r1)
            r0.add(r13)
            android.view.ViewParent r1 = r13.getParent()
        L_0x000e:
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x001d
            r2 = r1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.add(r2)
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x000e
        L_0x001d:
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r2 = r0.get(r1)
            android.view.View r2 = (android.view.View) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            boolean r5 = r2 instanceof android.view.ViewGroup
            r6 = 0
            if (r5 == 0) goto L_0x00b0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -1
            r5 = r6
        L_0x003d:
            if (r1 < 0) goto L_0x009e
            java.lang.Object r7 = r0.get(r1)
            android.view.View r7 = (android.view.View) r7
            int r2 = r2.indexOfChild(r7)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = getViewNode(r7, r2, r14)
            if (r2 == 0) goto L_0x0093
            java.lang.String r5 = r2.getViewPath()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x007b
            java.lang.String r5 = r2.getViewPath()
            java.lang.String r8 = "-"
            boolean r5 = r5.contains(r8)
            if (r5 == 0) goto L_0x007b
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x007b
            int r5 = r4.indexOf(r8)
            r8 = -1
            if (r5 == r8) goto L_0x007b
            int r8 = r5 + 1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.replace(r5, r8, r6)
        L_0x007b:
            java.lang.String r5 = r2.getViewOriginalPath()
            r3.append(r5)
            java.lang.String r5 = r2.getViewPath()
            r4.append(r5)
            java.lang.String r5 = r2.getViewPosition()
            java.lang.String r2 = r2.getViewContent()
            r6 = r5
            r5 = r2
        L_0x0093:
            boolean r2 = r7 instanceof android.view.ViewGroup
            if (r2 != 0) goto L_0x0098
            goto L_0x009e
        L_0x0098:
            r2 = r7
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -1
            goto L_0x003d
        L_0x009e:
            r12 = r5
            r9 = r6
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r14 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r10 = r3.toString()
            java.lang.String r11 = r4.toString()
            r7 = r14
            r8 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            return r14
        L_0x00b0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewPathAndPosition(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    public static String getElementSelector(View view) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        do {
            ViewParent parent = view.getParent();
            arrayList.add(view.getClass().getCanonicalName() + "[" + VisualUtil.getChildIndex(parent, view) + "]");
            z = parent instanceof ViewGroup;
            if (z) {
                view = (ViewGroup) parent;
                continue;
            }
        } while (z);
        Collections.reverse(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arrayList.size(); i++) {
            sb.append((String) arrayList.get(i));
            if (i != arrayList.size() - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    private static int getViewPosition(View view, int i) {
        int childAdapterPositionInRecyclerView;
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return i;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (instanceOfAndroidXViewPager(viewGroup) || instanceOfSupportViewPager(viewGroup)) {
            return getCurrentItem(viewGroup);
        }
        if (viewGroup instanceof AdapterView) {
            return i + ((AdapterView) viewGroup).getFirstVisiblePosition();
        }
        if (!instanceOfRecyclerView(viewGroup) || (childAdapterPositionInRecyclerView = getChildAdapterPositionInRecyclerView(view, viewGroup)) < 0) {
            return i;
        }
        return childAdapterPositionInRecyclerView;
    }

    public static ViewNode getViewNode(View view, int i, boolean z) {
        String str;
        boolean z2;
        String str2;
        boolean z3;
        View view2 = view;
        int viewPosition = getViewPosition(view, i);
        ViewParent parent = view.getParent();
        String str3 = null;
        if (parent == null) {
            return null;
        }
        if ((WindowHelper.isDecorView(view.getClass()) && !(parent instanceof View)) || !(parent instanceof View)) {
            return null;
        }
        View view3 = (View) parent;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String canonicalName = getCanonicalName(view.getClass());
        ViewParent parent2 = view3.getParent();
        if (parent2 instanceof View) {
            View view4 = (View) parent2;
            if (sViewCache == null) {
                sViewCache = new SparseArray();
            }
            String str4 = (String) sViewCache.get(view4.hashCode());
            if (!TextUtils.isEmpty(str4)) {
                str3 = str4;
            }
        }
        if (view3 instanceof ExpandableListView) {
            ExpandableListView expandableListView = (ExpandableListView) view3;
            long expandableListPosition = expandableListView.getExpandableListPosition(viewPosition);
            if (ExpandableListView.getPackedPositionType(expandableListPosition) != 2) {
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionChild != -1) {
                    str = String.format(Locale.CHINA, "%d:%d", new Object[]{Integer.valueOf(packedPositionGroup), Integer.valueOf(packedPositionChild)});
                    sb2.append(sb);
                    sb2.append("/ELVG[");
                    sb2.append(packedPositionGroup);
                    sb2.append("]/ELVC[-]/");
                    sb2.append(canonicalName);
                    sb2.append("[0]");
                    sb.append("/ELVG[");
                    sb.append(packedPositionGroup);
                    sb.append("]/ELVC[");
                    sb.append(packedPositionChild);
                    sb.append("]/");
                    sb.append(canonicalName);
                    sb.append("[0]");
                } else {
                    String format = String.format(Locale.CHINA, "%d", new Object[]{Integer.valueOf(packedPositionGroup)});
                    sb2.append(sb);
                    sb2.append("/ELVG[-]/");
                    sb2.append(canonicalName);
                    sb2.append("[0]");
                    sb.append("/ELVG[");
                    sb.append(packedPositionGroup);
                    sb.append("]/");
                    sb.append(canonicalName);
                    sb.append("[0]");
                    str = format;
                }
                z3 = true;
            } else {
                if (viewPosition < expandableListView.getHeaderViewsCount()) {
                    sb.append("/ELH[");
                    sb.append(viewPosition);
                    sb.append("]/");
                    sb.append(canonicalName);
                    sb.append("[0]");
                    sb2.append("/ELH[");
                    sb2.append(viewPosition);
                    sb2.append("]/");
                    sb2.append(canonicalName);
                    sb2.append("[0]");
                } else {
                    int count = viewPosition - (expandableListView.getCount() - expandableListView.getFooterViewsCount());
                    sb.append("/ELF[");
                    sb.append(count);
                    sb.append("]/");
                    sb.append(canonicalName);
                    sb.append("[0]");
                    sb2.append("/ELF[");
                    sb2.append(count);
                    sb2.append("]/");
                    sb2.append(canonicalName);
                    sb2.append("[0]");
                }
                z3 = false;
            }
            str2 = str;
            z2 = z3;
        } else if (isListView(view3)) {
            String format2 = String.format(Locale.CHINA, "%d", new Object[]{Integer.valueOf(viewPosition)});
            sb2.append(sb);
            sb2.append("/");
            sb2.append(canonicalName);
            sb2.append("[-]");
            sb.append("/");
            sb.append(canonicalName);
            sb.append("[");
            sb.append(format2);
            sb.append("]");
            str2 = format2;
            z2 = true;
        } else {
            if (instanceOfSupportSwipeRefreshLayout(view3)) {
                sb.append("/");
                sb.append(canonicalName);
                sb.append("[0]");
                sb2.append("/");
                sb2.append(canonicalName);
                sb2.append("[0]");
            } else {
                Object instanceOfFragmentRootView = instanceOfFragmentRootView(view3, view2);
                if (instanceOfFragmentRootView != null) {
                    String canonicalName2 = getCanonicalName(instanceOfFragmentRootView.getClass());
                    sb.append("/");
                    sb.append(canonicalName2);
                    sb.append("[0]");
                    sb2.append("/");
                    sb2.append(canonicalName2);
                    sb2.append("[0]");
                } else {
                    int childIndex = VisualUtil.getChildIndex(parent, view2);
                    sb.append("/");
                    sb.append(canonicalName);
                    sb.append("[");
                    sb.append(childIndex);
                    sb.append("]");
                    sb2.append("/");
                    sb2.append(canonicalName);
                    sb2.append("[");
                    sb2.append(childIndex);
                    sb2.append("]");
                }
            }
            str2 = str;
            z2 = false;
        }
        if (WindowHelper.isDecorView(view3.getClass())) {
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(0);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sViewCache == null) {
                sViewCache = new SparseArray();
            }
            sViewCache.put(view3.hashCode(), str2);
        }
        ViewNode viewContentAndType = getViewContentAndType(view2, z);
        return new ViewNode(view, str2, sb.toString(), sb2.toString(), viewContentAndType.getViewContent(), viewContentAndType.getViewType(), z2);
    }

    public static void clear() {
        SparseArray sparseArray = sViewCache;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    static boolean isTrackEvent(View view, boolean z) {
        if (view instanceof CheckBox) {
            if (!z) {
                return false;
            }
        } else if (view instanceof RadioButton) {
            if (!z) {
                return false;
            }
        } else if (view instanceof ToggleButton) {
            if (!z) {
                return false;
            }
        } else if ((view instanceof CompoundButton) && !z) {
            return false;
        }
        if (!(view instanceof RatingBar) || z) {
            return true;
        }
        return false;
    }

    public static ViewNode getViewContentAndType(View view) {
        return getViewContentAndType(view, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0143, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewContentAndType(android.view.View r5, boolean r6) {
        /*
            java.lang.Class r0 = r5.getClass()
            java.lang.String r0 = r0.getCanonicalName()
            boolean r1 = r5 instanceof android.widget.CheckBox
            r2 = 0
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = "CheckBox"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            java.lang.CharSequence r2 = r1.getText()
            goto L_0x0193
        L_0x001c:
            boolean r1 = r5 instanceof android.widget.RadioButton
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = "RadioButton"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.RadioButton r1 = (android.widget.RadioButton) r1
            java.lang.CharSequence r2 = r1.getText()
            goto L_0x0193
        L_0x002f:
            boolean r1 = r5 instanceof android.widget.ToggleButton
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "ToggleButton"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getCompoundButtonText(r5)
            goto L_0x0193
        L_0x003f:
            boolean r1 = r5 instanceof android.widget.CompoundButton
            if (r1 == 0) goto L_0x004d
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewTypeByReflect(r5)
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getCompoundButtonText(r5)
            goto L_0x0193
        L_0x004d:
            boolean r1 = r5 instanceof android.widget.Button
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "Button"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.Button r1 = (android.widget.Button) r1
            java.lang.CharSequence r2 = r1.getText()
            goto L_0x0193
        L_0x0060:
            boolean r1 = r5 instanceof android.widget.CheckedTextView
            if (r1 == 0) goto L_0x0073
            java.lang.String r1 = "CheckedTextView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.CheckedTextView r1 = (android.widget.CheckedTextView) r1
            java.lang.CharSequence r2 = r1.getText()
            goto L_0x0193
        L_0x0073:
            boolean r1 = r5 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0086
            java.lang.String r1 = "TextView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r2 = r1.getText()
            goto L_0x0193
        L_0x0086:
            boolean r1 = r5 instanceof android.widget.ImageView
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "ImageView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.CharSequence r3 = r1.getContentDescription()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0193
            java.lang.CharSequence r1 = r1.getContentDescription()
            java.lang.String r2 = r1.toString()
            goto L_0x0193
        L_0x00a7:
            boolean r1 = r5 instanceof android.widget.RatingBar
            if (r1 == 0) goto L_0x00be
            java.lang.String r1 = "RatingBar"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.RatingBar r1 = (android.widget.RatingBar) r1
            float r1 = r1.getRating()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            goto L_0x0193
        L_0x00be:
            boolean r1 = r5 instanceof android.widget.SeekBar
            if (r1 == 0) goto L_0x00d5
            java.lang.String r1 = "SeekBar"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r5
            android.widget.SeekBar r1 = (android.widget.SeekBar) r1
            int r1 = r1.getProgress()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            goto L_0x0193
        L_0x00d5:
            boolean r1 = r5 instanceof android.widget.Spinner
            r3 = 0
            if (r1 == 0) goto L_0x0109
            java.lang.String r1 = "Spinner"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r1.<init>()     // Catch:{ Exception -> 0x0103 }
            r4 = r5
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Exception -> 0x0103 }
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.traverseView(r1, r4)     // Catch:{ Exception -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0103 }
            if (r1 != 0) goto L_0x0193
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0103 }
            int r4 = r2.length()     // Catch:{ Exception -> 0x0103 }
            int r4 = r4 + -1
            java.lang.String r1 = r1.substring(r3, r4)     // Catch:{ Exception -> 0x0103 }
        L_0x0100:
            r2 = r1
            goto L_0x0193
        L_0x0103:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            goto L_0x0193
        L_0x0109:
            java.lang.Object r1 = instanceOfTabView(r5)
            if (r1 == 0) goto L_0x011b
            java.lang.String r2 = getTabLayoutContent(r1)
            java.lang.String r1 = "TabLayout"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            goto L_0x0193
        L_0x011b:
            boolean r1 = instanceOfBottomNavigationItemView(r5)
            if (r1 == 0) goto L_0x0146
            java.lang.Object r1 = getItemData(r5)
            if (r1 == 0) goto L_0x0193
            java.lang.String r3 = "androidx.appcompat.view.menu.MenuItemImpl"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x0193 }
            java.lang.Class r3 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(r3)     // Catch:{ Exception -> 0x0193 }
            if (r3 == 0) goto L_0x0193
            java.lang.String r4 = "mTitle"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0193 }
            java.lang.Object r1 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) r3, (java.lang.Object) r1, (java.lang.String[]) r4)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0193 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0193 }
            if (r3 != 0) goto L_0x0193
            goto L_0x0100
        L_0x0146:
            boolean r1 = instanceOfNavigationView(r5)
            if (r1 == 0) goto L_0x015f
            boolean r1 = isViewSelfVisible(r5)
            if (r1 == 0) goto L_0x0155
            java.lang.String r1 = "Open"
            goto L_0x0157
        L_0x0155:
            java.lang.String r1 = "Close"
        L_0x0157:
            r2 = r1
            java.lang.String r1 = "NavigationView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            goto L_0x0193
        L_0x015f:
            boolean r1 = r5 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0193
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewGroupTypeByReflect(r5)
            java.lang.CharSequence r2 = r5.getContentDescription()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0193
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r1.<init>()     // Catch:{ Exception -> 0x0193 }
            r4 = r5
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Exception -> 0x0193 }
            java.lang.String r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.traverseView(r1, r4)     // Catch:{ Exception -> 0x0193 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0100 }
            if (r2 != 0) goto L_0x0100
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x0100 }
            int r4 = r1.length()     // Catch:{ Exception -> 0x0100 }
            int r4 = r4 + -1
            java.lang.String r1 = r2.substring(r3, r4)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0100
        L_0x0193:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x01a4
            boolean r1 = r5 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x01a4
            r1 = r5
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r2 = r1.getHint()
        L_0x01a4:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x01ae
            java.lang.CharSequence r2 = r5.getContentDescription()
        L_0x01ae:
            boolean r1 = r5 instanceof android.widget.EditText
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x01be
            if (r6 == 0) goto L_0x01bd
            android.widget.EditText r5 = (android.widget.EditText) r5
            android.text.Editable r2 = r5.getText()
            goto L_0x01be
        L_0x01bd:
            r2 = r3
        L_0x01be:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x01c5
            goto L_0x01c6
        L_0x01c5:
            r3 = r2
        L_0x01c6:
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r5 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r6 = r3.toString()
            r5.<init>(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewContentAndType(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    private static String getTabLayoutContent(Object obj) {
        String str = null;
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$Tab", "com.google.android.material.tabs.TabLayout$Tab"});
            if (currentClass == null) {
                return null;
            }
            Object callMethod = ReflectUtil.callMethod(obj, "getText", new Object[0]);
            if (callMethod != null) {
                str = callMethod.toString();
            }
            View view = (View) ReflectUtil.findField(currentClass, obj, "mCustomView", "customView");
            if (view == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            if (!(view instanceof ViewGroup)) {
                return AopUtil.getViewText(view);
            }
            String traverseView = AopUtil.traverseView(sb, (ViewGroup) view);
            if (!TextUtils.isEmpty(traverseView)) {
                return traverseView.toString().substring(0, traverseView.length() - 1);
            }
            return traverseView;
        } catch (Exception unused) {
            return null;
        }
    }
}
