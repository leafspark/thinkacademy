package com.sensorsdata.analytics.android.sdk.visual;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.DeviceUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds;
import com.sensorsdata.analytics.android.sdk.visual.snap.SoftWareCanvas;
import com.sensorsdata.analytics.android.sdk.visual.snap.UIThreadSet;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public class ViewSnapshot {
    private static final int JS_NOT_INTEGRATED_ALERT_TIME_OUT = 5000;
    private static final int MAX_CLASS_NAME_CACHE_SIZE = 255;
    private static final String TAG = "SA.Snapshot";
    private AlertRunnable mAlertRunnable;
    private final ClassNameCache mClassnameCache;
    private final Handler mMainThreadHandler;
    private final List<PropertyDescription> mProperties;
    private final ResourceIds mResourceIds;
    private final RootViewFinder mRootViewFinder;
    /* access modifiers changed from: private */
    public SnapInfo mSnapInfo = new SnapInfo();

    public ViewSnapshot(List<PropertyDescription> list, ResourceIds resourceIds) {
        this.mProperties = list;
        this.mResourceIds = resourceIds;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mRootViewFinder = new RootViewFinder();
        this.mClassnameCache = new ClassNameCache(255);
    }

    public synchronized SnapInfo snapshots(UIThreadSet<Activity> uIThreadSet, OutputStream outputStream, StringBuilder sb) throws IOException {
        FutureTask futureTask = new FutureTask(this.mRootViewFinder);
        this.mMainThreadHandler.post(futureTask);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List emptyList = Collections.emptyList();
        outputStreamWriter.write("[");
        try {
            emptyList = (List) futureTask.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            SALog.i(TAG, "Screenshot interrupted, no screenshot will be sent.", e);
        } catch (TimeoutException e2) {
            SALog.i(TAG, "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", e2);
        } catch (ExecutionException e3) {
            SALog.i(TAG, "Exception thrown during screenshot attempt", e3);
        }
        int size = emptyList.size();
        String str = null;
        String str2 = null;
        for (int i = 0; i < size; i++) {
            RootViewInfo rootViewInfo = (RootViewInfo) emptyList.get(i);
            if (i > 0) {
                outputStreamWriter.write(",");
            }
            if (rootViewInfo == null || rootViewInfo.screenshot == null || (!isSnapShotUpdated(rootViewInfo.screenshot.getImageHash(), sb) && i <= 0)) {
                outputStreamWriter.write("{}");
            } else {
                outputStreamWriter.write("{");
                outputStreamWriter.write("\"activity\":");
                str = rootViewInfo.screenName;
                str2 = rootViewInfo.activityTitle;
                outputStreamWriter.write(JSONObject.quote(rootViewInfo.screenName));
                outputStreamWriter.write(",");
                outputStreamWriter.write("\"scale\":");
                outputStreamWriter.write(String.format("%s", new Object[]{Float.valueOf(rootViewInfo.scale)}));
                outputStreamWriter.write(",");
                outputStreamWriter.write("\"serialized_objects\":");
                JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
                jsonWriter.beginObject();
                jsonWriter.name("rootObject").value((long) rootViewInfo.rootView.hashCode());
                jsonWriter.name("objects");
                snapshotViewHierarchy(jsonWriter, rootViewInfo.rootView);
                jsonWriter.endObject();
                jsonWriter.flush();
                outputStreamWriter.write(",");
                outputStreamWriter.write("\"image_hash\":");
                outputStreamWriter.write(JSONObject.quote(rootViewInfo.screenshot.getImageHash()));
                outputStreamWriter.write(",");
                outputStreamWriter.write("\"screenshot\":");
                outputStreamWriter.flush();
                rootViewInfo.screenshot.writeBitmapJSON(Bitmap.CompressFormat.PNG, 70, outputStream);
                outputStreamWriter.write("}");
            }
        }
        outputStreamWriter.write("]");
        outputStreamWriter.flush();
        this.mSnapInfo.screenName = str;
        this.mSnapInfo.activityTitle = str2;
        return this.mSnapInfo;
    }

    private void getVisibleRect(View view, Rect rect, boolean z) {
        if (z) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocalVisibleRect(rect);
        rect.offset(iArr[0], iArr[1]);
    }

    private void snapshotViewHierarchy(JsonWriter jsonWriter, View view) throws IOException {
        reset();
        jsonWriter.beginArray();
        snapshotView(jsonWriter, view, 0);
        jsonWriter.endArray();
        WebNodesManager.getInstance().setHasWebView(this.mSnapInfo.isWebView);
    }

    private void reset() {
        this.mSnapInfo = new SnapInfo();
        ViewUtil.clear();
    }

    public static class AlertRunnable implements Runnable {
        private String url;

        AlertRunnable(String str) {
            this.url = str;
        }

        public void run() {
            if (WebNodesManager.getInstance().getWebNodes(this.url) == null) {
                SALog.i(ViewSnapshot.TAG, "H5 页面未集成 Web JS SDK");
                WebNodesManager.getInstance().handlerFailure(this.url, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"当前页面无法进行可视化全埋点\",\"message\":\"此页面未集成 Web JS SDK 或者 Web JS SDK 版本过低，请集成最新版 Web JS SDK\",\"link_text\":\"配置文档\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/tech_sdk_client_web_use-7545346.html\"}]}");
            }
        }
    }

    private void snapshotView(JsonWriter jsonWriter, final View view, int i) throws IOException {
        float f;
        if (ViewUtil.isViewSelfVisible(view)) {
            ArrayList<String> arrayList = null;
            int i2 = this.mSnapInfo.elementLevel;
            if (ViewUtil.instanceOfWebView(view)) {
                this.mSnapInfo.isWebView = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    view.post(new Runnable() {
                        public void run() {
                            String str = (String) ReflectUtil.callMethod(view, "getUrl", new Object[0]);
                            if (!TextUtils.isEmpty(str)) {
                                ViewSnapshot.this.mSnapInfo.webViewUrl = str;
                                Float f = (Float) ReflectUtil.callMethod(view, "getScale", new Object[0]);
                                if (f != null) {
                                    ViewSnapshot.this.mSnapInfo.webViewScale = f.floatValue();
                                }
                                countDownLatch.countDown();
                                SensorsDataAutoTrackHelper.loadUrl(view, "javascript:window.sensorsdata_app_call_js('visualized')");
                                return;
                            }
                            countDownLatch.countDown();
                        }
                    });
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
                try {
                    countDownLatch.await(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    SALog.printStackTrace(e2);
                }
                SALog.i(TAG, "WebView url: " + this.mSnapInfo.webViewUrl);
                if (!TextUtils.isEmpty(this.mSnapInfo.webViewUrl)) {
                    WebNodeInfo webNodes = WebNodesManager.getInstance().getWebNodes(this.mSnapInfo.webViewUrl);
                    if (webNodes == null) {
                        if (this.mAlertRunnable == null) {
                            this.mAlertRunnable = new AlertRunnable(this.mSnapInfo.webViewUrl);
                        }
                        Dispatcher.getInstance().postDelayed(this.mAlertRunnable, 5000);
                    } else if (webNodes.getStatus() == WebNodeInfo.Status.SUCCESS) {
                        List<WebNode> webNodes2 = webNodes.getWebNodes();
                        if (webNodes2 != null && webNodes2.size() > 0) {
                            arrayList = new ArrayList<>();
                            for (WebNode next : webNodes2) {
                                mergeWebViewNodes(jsonWriter, next, view, this.mSnapInfo.webViewScale);
                                if (next.isRootView()) {
                                    arrayList.add(next.getId() + view.hashCode());
                                }
                            }
                        }
                    } else if (webNodes.getStatus() == WebNodeInfo.Status.FAILURE) {
                        this.mSnapInfo.alertInfos = webNodes.getAlertInfos();
                    }
                }
            }
            jsonWriter.beginObject();
            jsonWriter.name("hashCode").value((long) view.hashCode());
            jsonWriter.name("id").value((long) view.getId());
            jsonWriter.name("index").value((long) VisualUtil.getChildIndex(view.getParent(), view));
            if (ViewUtil.instanceOfWebView(view)) {
                jsonWriter.name("element_level").value((long) i2);
            } else {
                JsonWriter name = jsonWriter.name("element_level");
                SnapInfo snapInfo = this.mSnapInfo;
                int i3 = snapInfo.elementLevel + 1;
                snapInfo.elementLevel = i3;
                name.value((long) i3);
            }
            jsonWriter.name("element_selector").value(ViewUtil.getElementSelector(view));
            JSONObject screenNameAndTitle = VisualUtil.getScreenNameAndTitle(view, this.mSnapInfo);
            if (screenNameAndTitle != null) {
                String optString = screenNameAndTitle.optString(AopConstants.SCREEN_NAME);
                String optString2 = screenNameAndTitle.optString(AopConstants.TITLE);
                if (!TextUtils.isEmpty(optString)) {
                    jsonWriter.name("screen_name").value(optString);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    jsonWriter.name("title").value(optString2);
                }
            }
            ViewNode viewNode = ViewUtil.getViewNode(view, i, true);
            if (viewNode != null) {
                if (!TextUtils.isEmpty(viewNode.getViewPath())) {
                    jsonWriter.name("element_path").value(viewNode.getViewPath());
                }
                if (!TextUtils.isEmpty(viewNode.getViewPosition())) {
                    jsonWriter.name("element_position").value(viewNode.getViewPosition());
                }
                if (!TextUtils.isEmpty(viewNode.getViewContent()) && VisualUtil.isSupportElementContent(view)) {
                    jsonWriter.name("element_content").value(viewNode.getViewContent());
                }
                jsonWriter.name("is_list_view").value(viewNode.isListView());
            }
            jsonWriter.name("sa_id_name").value(getResName(view));
            try {
                String str = (String) view.getTag(R.id.sensors_analytics_tag_view_id);
                if (!TextUtils.isEmpty(str)) {
                    jsonWriter.name("sa_id_name").value(str);
                }
            } catch (Exception e3) {
                SALog.printStackTrace(e3);
            }
            if (WindowHelper.isMainWindow(view.getRootView())) {
                jsonWriter.name("top").value((long) view.getTop());
                jsonWriter.name("left").value((long) view.getLeft());
                jsonWriter.name("width").value((long) view.getWidth());
                jsonWriter.name("height").value((long) view.getHeight());
            } else if (WindowHelper.isDecorView(view.getClass())) {
                DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                jsonWriter.name("top").value((long) view.getTop());
                jsonWriter.name("left").value((long) view.getLeft());
                jsonWriter.name("width").value((long) i4);
                jsonWriter.name("height").value((long) i5);
            } else {
                ViewParent parent = view.getParent();
                if (parent == null || !WindowHelper.isDecorView(parent.getClass())) {
                    jsonWriter.name("top").value((long) view.getTop());
                    jsonWriter.name("left").value((long) view.getLeft());
                    jsonWriter.name("width").value((long) view.getWidth());
                    jsonWriter.name("height").value((long) view.getHeight());
                } else {
                    Rect rect = new Rect();
                    getVisibleRect(view, rect, false);
                    jsonWriter.name("top").value((long) rect.top);
                    jsonWriter.name("left").value((long) rect.left);
                    jsonWriter.name("width").value((long) rect.width());
                    jsonWriter.name("height").value((long) rect.height());
                }
            }
            int scrollX = view.getScrollX();
            if ((view instanceof TextView) && ((TextView) view).getMaxLines() == 1) {
                scrollX = 0;
            }
            if (ViewUtil.instanceOfX5WebView(view)) {
                try {
                    jsonWriter.name("scrollX").value((Integer) ReflectUtil.callMethod(view, "getWebScrollX", new Object[0]));
                    jsonWriter.name("scrollY").value((Integer) ReflectUtil.callMethod(view, "getWebScrollY", new Object[0]));
                } catch (IOException e4) {
                    SALog.printStackTrace(e4);
                }
            } else {
                jsonWriter.name("scrollX").value((long) scrollX);
                jsonWriter.name("scrollY").value((long) view.getScrollY());
            }
            jsonWriter.name("visibility").value((long) VisualUtil.getVisibility(view));
            float f2 = 0.0f;
            if (Build.VERSION.SDK_INT >= 11) {
                f2 = view.getTranslationX();
                f = view.getTranslationY();
            } else {
                f = 0.0f;
            }
            jsonWriter.name("translationX").value((double) f2);
            jsonWriter.name("translationY").value((double) f);
            jsonWriter.name("classes");
            jsonWriter.beginArray();
            Class cls = view.getClass();
            do {
                jsonWriter.value((String) this.mClassnameCache.get(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jsonWriter.endArray();
            addProperties(jsonWriter, view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                jsonWriter.name("layoutRules");
                jsonWriter.beginArray();
                for (int i6 : rules) {
                    jsonWriter.value((long) i6);
                }
                jsonWriter.endArray();
            }
            jsonWriter.name("subviews");
            jsonWriter.beginArray();
            if (arrayList != null && arrayList.size() > 0) {
                for (String value : arrayList) {
                    jsonWriter.value(value);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    if (childAt != null) {
                        jsonWriter.value((long) childAt.hashCode());
                    }
                }
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = viewGroup2.getChildAt(i8);
                if (childAt2 != null) {
                    snapshotView(jsonWriter, childAt2, i8);
                }
            }
        }
    }

    private void addProperties(JsonWriter jsonWriter, View view) throws IOException {
        Object applyMethod;
        Class<?> cls = view.getClass();
        for (PropertyDescription next : this.mProperties) {
            if (!(!next.targetClass.isAssignableFrom(cls) || next.accessor == null || (applyMethod = next.accessor.applyMethod(view)) == null)) {
                if (applyMethod instanceof Number) {
                    jsonWriter.name(next.name).value((Number) applyMethod);
                } else if (applyMethod instanceof Boolean) {
                    boolean booleanValue = ((Boolean) applyMethod).booleanValue();
                    if (TextUtils.equals("clickable", next.name)) {
                        if (VisualUtil.isSupportClick(view)) {
                            booleanValue = true;
                        } else if (VisualUtil.isForbiddenClick(view)) {
                            booleanValue = false;
                        }
                    }
                    jsonWriter.name(next.name).value(booleanValue);
                } else if (applyMethod instanceof ColorStateList) {
                    jsonWriter.name(next.name).value(Integer.valueOf(((ColorStateList) applyMethod).getDefaultColor()));
                } else if (applyMethod instanceof Drawable) {
                    Drawable drawable = (Drawable) applyMethod;
                    Rect bounds = drawable.getBounds();
                    jsonWriter.name(next.name);
                    jsonWriter.beginObject();
                    jsonWriter.name("classes");
                    jsonWriter.beginArray();
                    for (Class cls2 = drawable.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                        jsonWriter.value(cls2.getCanonicalName());
                    }
                    jsonWriter.endArray();
                    jsonWriter.name("dimensions");
                    jsonWriter.beginObject();
                    jsonWriter.name("left").value((long) bounds.left);
                    jsonWriter.name("right").value((long) bounds.right);
                    jsonWriter.name("top").value((long) bounds.top);
                    jsonWriter.name("bottom").value((long) bounds.bottom);
                    jsonWriter.endObject();
                    if (drawable instanceof ColorDrawable) {
                        jsonWriter.name("color").value((long) ((ColorDrawable) drawable).getColor());
                    }
                    jsonWriter.endObject();
                } else {
                    jsonWriter.name(next.name).value(applyMethod.toString());
                }
            }
        }
    }

    private boolean isSnapShotUpdated(String str, StringBuilder sb) {
        boolean z = !TextUtils.equals(str, sb) || WebNodesManager.getInstance().hasH5AlertInfo();
        if (sb != null) {
            sb.delete(0, sb.length()).append(str);
        }
        return z;
    }

    private String getResName(View view) {
        int id = view.getId();
        if (-1 == id) {
            return null;
        }
        return this.mResourceIds.nameForId(id);
    }

    private static class ClassNameCache extends LruCache<Class<?>, String> {
        public ClassNameCache(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    private static class RootViewFinder implements Callable<List<RootViewInfo>> {
        private final CachedBitmap mCachedBitmap = new CachedBitmap();
        private final int mClientDensity = 160;
        private final List<RootViewInfo> mRootViews = new ArrayList();

        public List<RootViewInfo> call() throws Exception {
            this.mRootViews.clear();
            Activity foregroundActivity = AppStateManager.getInstance().getForegroundActivity();
            if (foregroundActivity != null) {
                JSONObject buildTitleAndScreenName = AopUtil.buildTitleAndScreenName(foregroundActivity);
                VisualUtil.mergeRnScreenNameAndTitle(buildTitleAndScreenName);
                String optString = buildTitleAndScreenName.optString(AopConstants.SCREEN_NAME);
                String optString2 = buildTitleAndScreenName.optString(AopConstants.TITLE);
                Window window = foregroundActivity.getWindow();
                Bitmap bitmap = null;
                View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
                if (rootView == null) {
                    return this.mRootViews;
                }
                RootViewInfo rootViewInfo = new RootViewInfo(optString, optString2, rootView);
                View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
                if (sortedWindowViews != null && sortedWindowViews.length > 0) {
                    bitmap = mergeViewLayers(sortedWindowViews, rootViewInfo);
                    for (View view : sortedWindowViews) {
                        if (view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && !TextUtils.equals(WindowHelper.getWindowPrefix(view), WindowHelper.getMainWindowPrefix())) {
                            RootViewInfo rootViewInfo2 = new RootViewInfo(optString, optString2, view.getRootView());
                            scaleBitmap(rootViewInfo2, bitmap);
                            this.mRootViews.add(rootViewInfo2);
                        }
                    }
                }
                if (this.mRootViews.size() == 0) {
                    scaleBitmap(rootViewInfo, bitmap);
                    this.mRootViews.add(rootViewInfo);
                }
            }
            return this.mRootViews;
        }

        /* access modifiers changed from: package-private */
        public Bitmap mergeViewLayers(View[] viewArr, RootViewInfo rootViewInfo) {
            View[] viewArr2 = viewArr;
            RootViewInfo rootViewInfo2 = rootViewInfo;
            int width = rootViewInfo2.rootView.getWidth();
            int height = rootViewInfo2.rootView.getHeight();
            if (width == 0 || height == 0) {
                int[] deviceSize = DeviceUtils.getDeviceSize(SensorsDataAPI.sharedInstance().getContext());
                width = deviceSize[0];
                height = deviceSize[1];
                if (width == 0 || height == 0) {
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            SoftWareCanvas softWareCanvas = new SoftWareCanvas(createBitmap);
            int[] iArr = new int[2];
            boolean z = ViewUtil.getMainWindowCount(viewArr) > 1;
            WindowHelper.init();
            ViewUtil.invalidateLayerTypeView(viewArr);
            boolean z2 = false;
            for (View view : viewArr2) {
                if (view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && ViewUtil.isWindowNeedTraverse(view, WindowHelper.getWindowPrefix(view), z)) {
                    softWareCanvas.save();
                    if (!WindowHelper.isMainWindow(view)) {
                        view.getLocationOnScreen(iArr);
                        softWareCanvas.translate((float) iArr[0], (float) iArr[1]);
                        if (WindowHelper.isDialogOrPopupWindow(view) && !z2) {
                            Paint paint = new Paint();
                            paint.setColor(-1610612736);
                            softWareCanvas.drawRect(-((float) iArr[0]), -((float) iArr[1]), (float) softWareCanvas.getWidth(), (float) softWareCanvas.getHeight(), paint);
                            z2 = true;
                        }
                    }
                    view.draw(softWareCanvas);
                    softWareCanvas.restore();
                    softWareCanvas.destroy();
                }
            }
            return createBitmap;
        }

        private void scaleBitmap(RootViewInfo rootViewInfo, Bitmap bitmap) {
            float f = 1.0f;
            if (bitmap != null) {
                int density = bitmap.getDensity();
                if (density != 0) {
                    f = 160.0f / ((float) density);
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (int) (((double) (((float) bitmap.getWidth()) * f)) + 0.5d);
                int height2 = (int) (((double) (((float) bitmap.getHeight()) * f)) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.mCachedBitmap.recreate(width2, height2, 160, bitmap);
                }
            }
            rootViewInfo.scale = f;
            rootViewInfo.screenshot = this.mCachedBitmap;
        }
    }

    private static class CachedBitmap {
        private Bitmap mCached = null;
        private String mImageHash = "";
        private final Paint mPaint = new Paint(2);

        public synchronized void recreate(int i, int i2, int i3, Bitmap bitmap) {
            byte[] bytes;
            byte[] bytes2;
            Bitmap bitmap2 = this.mCached;
            if (!(bitmap2 != null && bitmap2.getWidth() == i && this.mCached.getHeight() == i2)) {
                try {
                    this.mCached = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError unused) {
                    this.mCached = null;
                }
                Bitmap bitmap3 = this.mCached;
                if (bitmap3 != null) {
                    bitmap3.setDensity(i3);
                }
            }
            if (this.mCached != null) {
                new Canvas(this.mCached).drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.mCached.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String lastWebNodeMsg = WebNodesManager.getInstance().getLastWebNodeMsg();
                    if (!TextUtils.isEmpty(lastWebNodeMsg) && (bytes2 = lastWebNodeMsg.getBytes()) != null && bytes2.length > 0) {
                        byteArray = concat(byteArray, bytes2);
                    }
                    String lastDebugInfo = VisualizedAutoTrackService.getInstance().getLastDebugInfo();
                    if (!TextUtils.isEmpty(lastDebugInfo) && (bytes = lastDebugInfo.getBytes()) != null && bytes.length > 0) {
                        byteArray = concat(byteArray, bytes);
                    }
                    this.mImageHash = toHex(MessageDigest.getInstance("MD5").digest(byteArray));
                } catch (Exception e) {
                    SALog.i(ViewSnapshot.TAG, "CachedBitmap.recreate;Create image_hash error=" + e);
                }
            }
            return;
        }

        private static byte[] concat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public synchronized void writeBitmapJSON(Bitmap.CompressFormat compressFormat, int i, OutputStream outputStream) throws IOException {
            Bitmap bitmap = this.mCached;
            if (!(bitmap == null || bitmap.getWidth() == 0)) {
                if (this.mCached.getHeight() != 0) {
                    outputStream.write(34);
                    Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                    this.mCached.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                    base64OutputStream.flush();
                    outputStream.write(34);
                }
            }
            outputStream.write("null".getBytes());
        }

        /* access modifiers changed from: private */
        public String getImageHash() {
            return this.mImageHash;
        }

        private String toHex(byte[] bArr) {
            String str = "";
            for (int i = 0; i < bArr.length; i++) {
                str = (str + "0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i] & 15);
            }
            return str;
        }
    }

    private static class RootViewInfo {
        final String activityTitle;
        final View rootView;
        float scale = 1.0f;
        final String screenName;
        CachedBitmap screenshot = null;

        RootViewInfo(String str, String str2, View view) {
            this.screenName = str;
            this.activityTitle = str2;
            this.rootView = view;
        }
    }

    private void mergeWebViewNodes(JsonWriter jsonWriter, WebNode webNode, View view, float f) {
        try {
            jsonWriter.beginObject();
            JsonWriter name = jsonWriter.name("hashCode");
            name.value(webNode.getId() + view.hashCode());
            long j = 0;
            jsonWriter.name("index").value(0);
            if (!TextUtils.isEmpty(webNode.get$element_selector())) {
                jsonWriter.name("element_selector").value(webNode.get$element_selector());
            }
            if (!TextUtils.isEmpty(webNode.get$element_content())) {
                jsonWriter.name("element_content").value(webNode.get$element_content());
            }
            JsonWriter name2 = jsonWriter.name("element_level");
            SnapInfo snapInfo = this.mSnapInfo;
            int i = snapInfo.elementLevel + 1;
            snapInfo.elementLevel = i;
            name2.value((long) i);
            jsonWriter.name("h5_title").value(webNode.get$title());
            if (f == 0.0f) {
                f = webNode.getScale();
            }
            jsonWriter.name("left").value((double) (webNode.getLeft() * f));
            jsonWriter.name("top").value((double) (webNode.getTop() * f));
            jsonWriter.name("width").value((long) ((int) (webNode.getWidth() * f)));
            jsonWriter.name("height").value((long) ((int) (webNode.getHeight() * f)));
            jsonWriter.name("scrollX").value(0);
            jsonWriter.name("scrollY").value(0);
            boolean z = webNode.getOriginTop() * f <= ((float) view.getHeight()) && webNode.getOriginLeft() * f <= ((float) view.getWidth());
            JsonWriter name3 = jsonWriter.name("visibility");
            if (!webNode.isVisibility() || !z) {
                j = 8;
            }
            name3.value(j);
            jsonWriter.name("url").value(webNode.get$url());
            jsonWriter.name("clickable").value(webNode.isEnable_click());
            jsonWriter.name("importantForAccessibility").value(true);
            jsonWriter.name("is_h5").value(true);
            jsonWriter.name("is_list_view").value(webNode.isIs_list_view());
            jsonWriter.name("element_path").value(webNode.get$element_path());
            jsonWriter.name("tag_name").value(webNode.getTagName());
            if (!TextUtils.isEmpty(webNode.get$element_position())) {
                jsonWriter.name("element_position").value(webNode.get$element_position());
            }
            this.mSnapInfo.webLibVersion = webNode.getLib_version();
            jsonWriter.name("list_selector").value(webNode.getList_selector());
            jsonWriter.name("classes");
            jsonWriter.beginArray();
            jsonWriter.value(webNode.getTagName());
            Class cls = view.getClass();
            do {
                jsonWriter.value(cls.getCanonicalName());
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jsonWriter.endArray();
            List<String> subelements = webNode.getSubelements();
            if (subelements != null && subelements.size() > 0) {
                jsonWriter.name("subviews");
                jsonWriter.beginArray();
                for (String str : subelements) {
                    jsonWriter.value(str + view.hashCode());
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
