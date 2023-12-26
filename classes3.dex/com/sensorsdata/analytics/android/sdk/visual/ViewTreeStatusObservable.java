package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ViewTreeStatusObservable implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalFocusChangeListener {
    private static final String TAG = "ViewTreeStatusObservable";
    public static volatile ViewTreeStatusObservable viewTreeStatusObservable;
    private Runnable mTraverseRunnable = new TraverseRunnable();
    private HashMap<String, ViewNode> mViewNodesHashMap = new HashMap<>();
    private SparseArray<ViewNode> mViewNodesWithHashCode = new SparseArray<>();
    private HashMap<String, ViewNode> mWebViewHashMap = new HashMap<>();

    public static ViewTreeStatusObservable getInstance() {
        if (viewTreeStatusObservable == null) {
            synchronized (ViewTreeStatusObservable.class) {
                if (viewTreeStatusObservable == null) {
                    viewTreeStatusObservable = new ViewTreeStatusObservable();
                }
            }
        }
        return viewTreeStatusObservable;
    }

    class TraverseRunnable implements Runnable {
        TraverseRunnable() {
        }

        public void run() {
            SALog.i(ViewTreeStatusObservable.TAG, "start traverse...");
            ViewTreeStatusObservable.this.traverseNode();
            SALog.i(ViewTreeStatusObservable.TAG, "stop traverse...");
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        SALog.i(TAG, "onGlobalFocusChanged");
        traverse();
    }

    public void onGlobalLayout() {
        SALog.i(TAG, "onGlobalLayout");
        traverse();
    }

    public void onScrollChanged() {
        SALog.i(TAG, "onScrollChanged");
        traverse();
    }

    public void traverse() {
        try {
            Dispatcher.getInstance().postDelayed(this.mTraverseRunnable, 100);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public ViewNode getViewNode(View view) {
        ViewNode viewNode = null;
        try {
            ViewNode viewNode2 = this.mViewNodesWithHashCode.get(view.hashCode());
            if (viewNode2 != null) {
                return viewNode2;
            }
            try {
                viewNode = ViewUtil.getViewPathAndPosition(view);
                if (viewNode != null) {
                    this.mViewNodesWithHashCode.put(view.hashCode(), viewNode);
                }
            } catch (Exception e) {
                e = e;
                viewNode = viewNode2;
                SALog.printStackTrace(e);
                return viewNode;
            }
            return viewNode;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewNode(java.lang.ref.WeakReference<android.view.View> r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r1 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x005c }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r1     // Catch:{ Exception -> 0x005c }
            if (r1 != 0) goto L_0x0061
            if (r4 == 0) goto L_0x0025
            java.lang.Object r2 = r4.get()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0022 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getRootView()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            r0 = r1
            goto L_0x005d
        L_0x0025:
            if (r0 != 0) goto L_0x0049
            com.sensorsdata.analytics.android.sdk.AppStateManager r4 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ Exception -> 0x0022 }
            android.app.Activity r4 = r4.getForegroundActivity()     // Catch:{ Exception -> 0x0022 }
            if (r4 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            boolean r2 = r2.isActive()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r4 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getDecorView()     // Catch:{ Exception -> 0x0022 }
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r3.traverseNode(r0)     // Catch:{ Exception -> 0x0022 }
        L_0x004e:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r4 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x0022 }
            java.lang.String r5 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0022 }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r4 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r4     // Catch:{ Exception -> 0x0022 }
            r1 = r4
            goto L_0x0061
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
            r1 = r0
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getViewNode(java.lang.ref.WeakReference, java.lang.String, java.lang.String, java.lang.String):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewNode(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r1 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x004f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x004f }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r1     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x001b
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x001b
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x004c }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x004c }
            if (r2 != 0) goto L_0x0054
        L_0x001b:
            com.sensorsdata.analytics.android.sdk.AppStateManager r2 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ Exception -> 0x004c }
            android.app.Activity r2 = r2.getForegroundActivity()     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x003d
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x003d
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            boolean r3 = r3.isActive()     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x003d
            android.view.Window r0 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x004c }
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r4.traverseNode(r0)     // Catch:{ Exception -> 0x004c }
        L_0x0042:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r0 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x004c }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x004c }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r5 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r5     // Catch:{ Exception -> 0x004c }
            r1 = r5
            goto L_0x0054
        L_0x004c:
            r5 = move-exception
            r0 = r1
            goto L_0x0050
        L_0x004f:
            r5 = move-exception
        L_0x0050:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
            r1 = r0
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getViewNode(java.lang.String):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    public void clearWebViewCache() {
        try {
            HashMap<String, ViewNode> hashMap = this.mWebViewHashMap;
            if (hashMap != null) {
                hashMap.clear();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    public void traverseNode() {
        traverseNode((View) null);
    }

    private void traverseNode(View view) {
        try {
            SparseArray<ViewNode> sparseArray = new SparseArray<>();
            HashMap<String, ViewNode> hashMap = new HashMap<>();
            HashMap<String, ViewNode> hashMap2 = new HashMap<>();
            if (view != null) {
                traverseNode(view, sparseArray, hashMap, hashMap2);
            } else {
                for (View traverseNode : WindowHelper.getSortedWindowViews()) {
                    traverseNode(traverseNode, sparseArray, hashMap, hashMap2);
                }
            }
            this.mViewNodesHashMap.clear();
            this.mViewNodesWithHashCode.clear();
            this.mWebViewHashMap.clear();
            this.mViewNodesHashMap = hashMap;
            this.mViewNodesWithHashCode = sparseArray;
            this.mWebViewHashMap = hashMap2;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public List<View> getCurrentWebView() {
        try {
            if (this.mWebViewHashMap.size() == 0) {
                traverseNode();
            }
            if (this.mWebViewHashMap.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (ViewNode view : this.mWebViewHashMap.values()) {
                WeakReference<View> view2 = view.getView();
                if (!(view2 == null || view2.get() == null)) {
                    arrayList.add(view2.get());
                }
            }
            return arrayList;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    private String generateKey(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return sb.toString();
    }

    private void traverseNode(View view, SparseArray<ViewNode> sparseArray, HashMap<String, ViewNode> hashMap, HashMap<String, ViewNode> hashMap2) {
        JSONObject screenNameAndTitle;
        try {
            ViewNode viewPathAndPosition = ViewUtil.getViewPathAndPosition(view, true);
            if (viewPathAndPosition != null) {
                sparseArray.put(view.hashCode(), viewPathAndPosition);
                if (!TextUtils.isEmpty(viewPathAndPosition.getViewPath()) && (screenNameAndTitle = VisualUtil.getScreenNameAndTitle(view, (SnapInfo) null)) != null) {
                    String optString = screenNameAndTitle.optString(AopConstants.SCREEN_NAME);
                    if (!TextUtils.isEmpty(optString)) {
                        if (!TextUtils.isEmpty(viewPathAndPosition.getViewContent())) {
                            hashMap.put(generateKey(viewPathAndPosition.getViewPath(), viewPathAndPosition.getViewPosition(), optString), viewPathAndPosition);
                        }
                        if (ViewUtil.instanceOfWebView(view)) {
                            hashMap2.put(viewPathAndPosition.getViewPath() + optString, viewPathAndPosition);
                        }
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        traverseNode(childAt, sparseArray, hashMap, hashMap2);
                    }
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
