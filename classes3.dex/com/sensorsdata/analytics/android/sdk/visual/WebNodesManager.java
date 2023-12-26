package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.util.LruCache;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebNodesManager {
    private static final String CALL_TYPE_PAGE_INFO = "page_info";
    private static final String CALL_TYPE_VISUALIZED_TRACK = "visualized_track";
    private static final int LRU_CACHE_MAX_SIZE = 10;
    private static final String TAG = "SA.Visual.WebNodesManager";
    private static volatile WebNodesManager mSingleton;
    private static LruCache<String, WebNodeInfo> sPageInfoCache;
    private static LruCache<String, WebNodeInfo> sWebNodesCache;
    private boolean mHasH5AlertInfo;
    private boolean mHasWebView;
    private String mLastWebNodeMsg = null;
    private String mWebViewUrl;

    private WebNodesManager() {
    }

    public static WebNodesManager getInstance() {
        if (mSingleton == null) {
            synchronized (WebNodesManager.class) {
                if (mSingleton == null) {
                    mSingleton = new WebNodesManager();
                }
            }
        }
        return mSingleton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064 A[Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088 A[Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handlerMessage(java.lang.String r7) {
        /*
            r6 = this;
            com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher r0 = com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher.getInstance()
            r0.removeCallbacksAndMessages()
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r0 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r0 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6.mLastWebNodeMsg = r0
            r0 = 0
            r6.mHasH5AlertInfo = r0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            java.lang.String r2 = "callType"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r4 = 817885468(0x30bff11c, float:1.3965606E-9)
            r5 = 1
            if (r3 == r4) goto L_0x0056
            r0 = 883555422(0x34a9fc5e, float:3.1662324E-7)
            if (r3 == r0) goto L_0x004c
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "page_info"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r0 == 0) goto L_0x005f
            r0 = r5
            goto L_0x0060
        L_0x0056:
            java.lang.String r3 = "visualized_track"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r1 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            r1 = 10
            if (r0 == 0) goto L_0x0088
            if (r0 == r5) goto L_0x0067
            goto L_0x00bc
        L_0x0067:
            com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r7 = r6.parsePageInfo(r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r7 == 0) goto L_0x00bc
            java.lang.String r0 = r7.getUrl()     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r6.mWebViewUrl = r0     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sPageInfoCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r0 != 0) goto L_0x007e
            android.util.LruCache r0 = new android.util.LruCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            sPageInfoCache = r0     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
        L_0x007e:
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sPageInfoCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            java.lang.String r1 = r7.getUrl()     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            goto L_0x00bc
        L_0x0088:
            java.util.List r7 = r6.parseResult(r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r7 == 0) goto L_0x00bc
            int r0 = r7.size()     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r0 <= 0) goto L_0x00bc
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sWebNodesCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r0 != 0) goto L_0x009f
            android.util.LruCache r0 = new android.util.LruCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            sWebNodesCache = r0     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
        L_0x009f:
            java.lang.String r0 = r6.mWebViewUrl     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            if (r0 != 0) goto L_0x00bc
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sWebNodesCache     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            java.lang.String r1 = r6.mWebViewUrl     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r7 = com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.createWebNodesInfo(r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x00b8, Exception -> 0x00b3 }
            goto L_0x00bc
        L_0x00b3:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
            goto L_0x00bc
        L_0x00b8:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.handlerMessage(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void handlerFailure(String str, String str2) {
        Dispatcher.getInstance().removeCallbacksAndMessages();
        if ((VisualizedAutoTrackService.getInstance().isServiceRunning() || HeatMapService.getInstance().isServiceRunning()) && !TextUtils.isEmpty(str2)) {
            SALog.i(TAG, "handlerFailure url " + str + ",msg: " + str2);
            this.mHasH5AlertInfo = true;
            this.mLastWebNodeMsg = String.valueOf(System.currentTimeMillis());
            List<WebNodeInfo.AlertInfo> parseAlertResult = parseAlertResult(str2);
            if (parseAlertResult != null && parseAlertResult.size() > 0) {
                if (sWebNodesCache == null) {
                    sWebNodesCache = new LruCache<>(10);
                }
                sWebNodesCache.put(str, WebNodeInfo.createWebAlertInfo(parseAlertResult));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[ExcHandler: JSONException (r5v1 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:4:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.WebNode> parseResult(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0008
            r5 = 0
            return r5
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            r2.<init>(r5)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            java.lang.String r5 = "data"
            org.json.JSONArray r5 = r2.optJSONArray(r5)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            java.lang.String r3 = "extra_elements"
            org.json.JSONArray r2 = r2.optJSONArray(r3)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            if (r5 == 0) goto L_0x0028
            r4.findWebNodes(r5, r0, r1)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
        L_0x0028:
            if (r2 == 0) goto L_0x002d
            r4.findWebNodes(r2, r0, r1)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
        L_0x002d:
            boolean r5 = r1.isEmpty()     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            if (r5 != 0) goto L_0x0036
            r4.modifyWebNodes(r0, r1)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
        L_0x0036:
            com.sensorsdata.analytics.android.sdk.visual.WebNodesManager$1 r5 = new com.sensorsdata.analytics.android.sdk.visual.WebNodesManager$1     // Catch:{ Exception -> 0x003f, JSONException -> 0x0049 }
            r5.<init>()     // Catch:{ Exception -> 0x003f, JSONException -> 0x0049 }
            java.util.Collections.sort(r0, r5)     // Catch:{ Exception -> 0x003f, JSONException -> 0x0049 }
            goto L_0x004d
        L_0x003f:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)     // Catch:{ JSONException -> 0x0049, Exception -> 0x0044 }
            goto L_0x004d
        L_0x0044:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
            goto L_0x004d
        L_0x0049:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.parseResult(java.lang.String):java.util.List");
    }

    private WebNodeInfo parsePageInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(DbParams.KEY_DATA);
            return WebNodeInfo.createPageInfo(jSONObject.optString(AopConstants.TITLE), jSONObject.optString("$url"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<WebNodeInfo.AlertInfo> parseAlertResult(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(DbParams.KEY_DATA);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        arrayList2.add(new WebNodeInfo.AlertInfo(jSONObject.optString("title"), jSONObject.optString("message"), jSONObject.optString("link_text"), jSONObject.optString("link_url")));
                    }
                    i++;
                } catch (JSONException e) {
                    e = e;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            e = e3;
            SALog.printStackTrace(e);
            return arrayList;
        } catch (Exception e4) {
            e = e4;
            SALog.printStackTrace(e);
            return arrayList;
        }
    }

    static class WebNodeRect {
        public float left;
        public float top;

        public WebNodeRect(float f, float f2) {
            this.top = f;
            this.left = f2;
        }
    }

    private void modifyWebNodes(List<WebNode> list, Map<String, WebNodeRect> map) {
        if (list != null && list.size() != 0) {
            synchronized (this) {
                for (WebNode next : list) {
                    next.setOriginLeft(next.getLeft());
                    next.setOriginTop(next.getTop());
                    if (!map.containsKey(next.getId())) {
                        next.setRootView(true);
                        next.setTop(next.getTop() + next.getScrollY());
                        next.setLeft(next.getLeft() + next.getScrollX());
                    } else {
                        WebNodeRect webNodeRect = map.get(next.getId());
                        if (webNodeRect != null) {
                            next.setTop(next.getTop() - webNodeRect.top);
                            next.setLeft(next.getLeft() - webNodeRect.left);
                        }
                    }
                }
            }
        }
    }

    private void findWebNodes(JSONArray jSONArray, List<WebNode> list, Map<String, WebNodeRect> map) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        WebNode webNode = new WebNode();
                        webNode.setId(optJSONObject.optString("id"));
                        webNode.set$element_content(optJSONObject.optString(AopConstants.ELEMENT_CONTENT));
                        webNode.set$element_selector(optJSONObject.optString(AopConstants.ELEMENT_SELECTOR));
                        webNode.setTagName(optJSONObject.optString("tagName"));
                        webNode.setTop((float) optJSONObject.optDouble("top"));
                        webNode.setLeft((float) optJSONObject.optDouble("left"));
                        webNode.setScrollX((float) optJSONObject.optDouble("scrollX"));
                        webNode.setScrollY((float) optJSONObject.optDouble("scrollY"));
                        webNode.setWidth((float) optJSONObject.optDouble("width"));
                        webNode.setHeight((float) optJSONObject.optDouble("height"));
                        webNode.setScale((float) optJSONObject.optDouble("scale"));
                        webNode.setVisibility(optJSONObject.optBoolean("visibility"));
                        webNode.set$url(optJSONObject.optString("$url"));
                        webNode.setzIndex(optJSONObject.optInt("zIndex"));
                        webNode.set$title(optJSONObject.optString(AopConstants.TITLE));
                        webNode.setLevel(optJSONObject.optInt("level"));
                        webNode.set$element_path(optJSONObject.optString(AopConstants.ELEMENT_PATH));
                        webNode.set$element_position(optJSONObject.optString(AopConstants.ELEMENT_POSITION));
                        webNode.setList_selector(optJSONObject.optString("list_selector"));
                        webNode.setLib_version(optJSONObject.optString("lib_version"));
                        webNode.setEnable_click(optJSONObject.optBoolean("enable_click", true));
                        webNode.setIs_list_view(optJSONObject.optBoolean("is_list_view"));
                        JSONArray optJSONArray = optJSONObject.optJSONArray("subelements");
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                String optString = optJSONArray.optString(i2);
                                if (!TextUtils.isEmpty(optString)) {
                                    arrayList.add(optString);
                                    if (!map.containsKey(optString)) {
                                        map.put(optString, new WebNodeRect(webNode.getTop(), webNode.getLeft()));
                                    }
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            webNode.setSubelements(arrayList);
                        }
                        list.add(webNode);
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public WebNodeInfo getWebNodes(String str) {
        if (!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sWebNodesCache == null) {
            sWebNodesCache = new LruCache<>(10);
        }
        return sWebNodesCache.get(str);
    }

    /* access modifiers changed from: package-private */
    public WebNodeInfo getWebPageInfo(String str) {
        if (!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sPageInfoCache == null) {
            sPageInfoCache = new LruCache<>(10);
        }
        return sPageInfoCache.get(str);
    }

    /* access modifiers changed from: package-private */
    public String getLastWebNodeMsg() {
        return this.mLastWebNodeMsg;
    }

    /* access modifiers changed from: package-private */
    public boolean hasH5AlertInfo() {
        return this.mHasH5AlertInfo;
    }

    public void clear() {
        this.mLastWebNodeMsg = null;
        this.mHasH5AlertInfo = false;
    }

    /* access modifiers changed from: package-private */
    public void setHasWebView(boolean z) {
        this.mHasWebView = z;
    }

    /* access modifiers changed from: package-private */
    public boolean hasWebView() {
        return this.mHasWebView;
    }
}
