package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.server.OnServerConnectionListener;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.business.browser.view.IWebDelegate;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.common.entity.CourseLoadResult;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.EncodeUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PhoneUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.lib.utils.HeartBeatUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.util.IgnoreUtil;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.CourseLoadStep;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.tal.app.thinkacademy.live.core.utils.ServerDomain;
import com.tal.app.thinkacademy.live.core.utils.WebDomain;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class CourseWareView extends FrameLayout {
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.COURSE_WARE;
    private static final String URL_TAG = "layoutChangeLoad";
    private volatile List<CourseWareBean> courseMap;
    /* access modifiers changed from: private */
    public CourseWareBean currentCourseWareBean;
    private boolean enableAlignTimeStamp;
    boolean hasFail;
    /* access modifiers changed from: private */
    public ImageView[] imageViews;
    private boolean isBindCourseware;
    private String isDownLoaded;
    /* access modifiers changed from: private */
    public volatile boolean isLoadCourse;
    private long loadStartTime;
    private final Context mContext;
    private ILiveRoomProvider mLiveRoomProvider;
    private int mPicUrlNum;
    /* access modifiers changed from: private */
    public BaseDialog mQuitOutDialog;
    private String mRootUrl;
    private WebAgent mWebAgent;
    /* access modifiers changed from: private */
    public OnSwitchStatusListener onSwitchStatusListener;
    String realUrl;
    private TextView reload;
    private ScreenShareView screenView;
    /* access modifiers changed from: private */
    public CourseWareBean showCourseWareBean;
    private long timeStamp;

    interface OnSwitchStatusListener {
        void onBegin(CourseWareBean courseWareBean);

        void onResult(boolean z, CourseWareBean courseWareBean);
    }

    public CourseWareView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CourseWareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseWareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imageViews = new ImageView[2];
        this.isBindCourseware = true;
        this.courseMap = new ArrayList();
        this.hasFail = false;
        this.isLoadCourse = false;
        this.mContext = context;
        initListener();
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        this.mWebAgent = new WebAgent(fragmentActivity).applyLifeHandler(getErrorHandlers());
        this.imageViews[0] = new CustomImageView(context);
        this.imageViews[0].setVisibility(4);
        this.imageViews[1] = new CustomImageView(context);
        for (ImageView imageView : this.imageViews) {
            imageView.setAdjustViewBounds(true);
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        XesDataBus.with(DataBusKey.JS_COURSE_WARE_STATUS).observe(fragmentActivity, new CourseWareView$$ExternalSyntheticLambda1(this));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        if (r2.equals("loaded") == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$new$0$CourseWareView(java.lang.Object r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0078
            r0 = 0
            r1 = 1
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = TAG     // Catch:{ all -> 0x0023 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0023 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r4.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.String r5 = "CourseWareView hashCode:"
            r4.append(r5)     // Catch:{ all -> 0x0023 }
            int r5 = r6.hashCode()     // Catch:{ all -> 0x0023 }
            r4.append(r5)     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0023 }
            r3[r0] = r4     // Catch:{ all -> 0x0023 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r3)     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0027:
            com.tal.app.thinkacademy.common.entity.CourseLoadResult r7 = (com.tal.app.thinkacademy.common.entity.CourseLoadResult) r7
            java.lang.String r2 = r7.getState()
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1097519099: goto L_0x0050;
                case 96784904: goto L_0x0045;
                case 336650556: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r0 = r3
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "loading"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0038
        L_0x0043:
            r0 = 2
            goto L_0x0059
        L_0x0045:
            java.lang.String r0 = "error"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x0038
        L_0x004e:
            r0 = r1
            goto L_0x0059
        L_0x0050:
            java.lang.String r1 = "loaded"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0059
            goto L_0x0038
        L_0x0059:
            switch(r0) {
                case 0: goto L_0x0075;
                case 1: goto L_0x0071;
                case 2: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x0078
        L_0x005d:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r7 = r7.getMsg()
            java.lang.String r1 = "progress"
            r0.put(r1, r7)
            com.tal.app.thinkacademy.live.core.utils.CourseLoadStep r7 = com.tal.app.thinkacademy.live.core.utils.CourseLoadStep.LoadJsStep
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.courseLoadStep(r7, r0)
            goto L_0x0078
        L_0x0071:
            r6.courseWareLoadFail(r7)
            goto L_0x0078
        L_0x0075:
            r6.courseWareLoadSuccess(r7)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView.lambda$new$0$CourseWareView(java.lang.Object):void");
    }

    private void courseWareLoadSuccess(CourseLoadResult courseLoadResult) {
        CourseWareBean courseWareBean;
        int i = 1;
        XesLog.s(TAG, "课件加载成功 isLocal:" + courseLoadResult.isLocal() + ", url:" + courseLoadResult.getUrl());
        this.isLoadCourse = false;
        WebAgent webAgent = this.mWebAgent;
        if (!(webAgent == null || (courseWareBean = this.currentCourseWareBean) == null)) {
            webAgent.jsCallBack("window.handleItsMessage", courseWareBean.jsString);
        }
        String str = "";
        if (!this.enableAlignTimeStamp) {
            HashMap<String, String> trackMap = LeanplumUtil.trackMap();
            if (courseLoadResult.isLocal()) {
                trackMap.put("courseware_isdownload", "1");
            } else {
                trackMap.put("courseware_isdownload", EnterRoomMuteData.STATUS_UN_MUTE);
            }
            trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + str);
            LeanplumUtil.commonTrack(LeanplumUtil.show_courseware, trackMap);
        } else {
            LeanplumUtil.commonTrack(LeanplumUtil.palyback_show_courseware, LeanplumUtil.trackMap());
        }
        long currentTimeMillis = (System.currentTimeMillis() - this.loadStartTime) / 1000;
        JsonObject jsonObject = new JsonObject();
        CourseWareBean courseWareBean2 = this.currentCourseWareBean;
        if (courseWareBean2 != null) {
            str = courseWareBean2.courseWareId;
        }
        jsonObject.addProperty("courseWareId", str);
        jsonObject.addProperty("url", this.realUrl);
        jsonObject.addProperty("isOnlineUrl", Integer.valueOf(courseLoadResult.isLocal() ^ true ? 1 : 0));
        jsonObject.addProperty("loadTime", Long.valueOf(currentTimeMillis));
        jsonObject.addProperty("isSuccess", 1);
        jsonObject.addProperty("isPlayback", Integer.valueOf(this.enableAlignTimeStamp ? 1 : 0));
        XesLog.ut("coursewareLoad", jsonObject);
        if (courseLoadResult.isLocal()) {
            HeartBeatUtil.setKejianStatus(1);
        } else {
            HeartBeatUtil.setKejianStatus(2);
        }
        String url = courseLoadResult.getUrl();
        if (url == null || !url.contains(URL_TAG)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("load_duration", currentTimeMillis);
                HwTrackUtil.INSTANCE.track("hw_test_course_ware_view", jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            double d = 0.0d;
            if (this.loadStartTime > 0) {
                try {
                    BigDecimal divide = BigDecimal.valueOf(System.currentTimeMillis() - this.loadStartTime).divide(BigDecimal.valueOf(1000), 3, 4);
                    if (divide.doubleValue() <= 0.0d) {
                        divide = BigDecimal.ZERO;
                    }
                    d = divide.doubleValue();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", "success");
                    if (courseLoadResult != null) {
                        jSONObject2.put("is_local_course", courseLoadResult.isLocal() ? 1 : 2);
                    }
                    jSONObject2.put("url", this.realUrl);
                    jSONObject2.put("courseware_load_duration", d);
                    if (this.enableAlignTimeStamp) {
                        i = 2;
                    }
                    jSONObject2.put("is_play_back", i);
                    HwTrackUtil.INSTANCE.track("hw_courseware_load", jSONObject2);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("url", courseLoadResult.getUrl());
                hashMap.put("load_duration", Double.valueOf(d * 1000.0d));
                hashMap.put("is_local", Boolean.valueOf(courseLoadResult.isLocal()));
                LiveTrack.courseLoadStep(CourseLoadStep.LoadSuccess, hashMap);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    private void courseWareLoadFail(CourseLoadResult courseLoadResult) {
        XesLogTag xesLogTag = TAG;
        int i = 1;
        XesLog.e(xesLogTag, "课件加载失败 isLocal:" + courseLoadResult.isLocal() + ", url:" + courseLoadResult.getUrl() + ", msg:" + courseLoadResult.getMsg());
        showDialog();
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        this.hasFail = true;
        if (this.enableAlignTimeStamp) {
            LeanplumUtil.commonTrack(LeanplumUtil.playback_error_courseware, LeanplumUtil.trackMap());
        } else if (courseLoadResult.isLocal()) {
            track_click_classroom_load_course(LeanplumUtil.error_courseware, "1");
            XesLog.i(xesLogTag, "jsCourseWareFail=== platform: android ; deviceName: " + DeviceUtils.getModel() + "; appVersion:" + AppUtils.getAppVersionName() + "; schoolCode:" + string + " ;  goClassTime:" + TimeUtils.getNowString() + "h5桥接资源加载本地课件资源失败");
        } else {
            track_click_classroom_load_course(LeanplumUtil.error_courseware, EnterRoomMuteData.STATUS_UN_MUTE);
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("jsCourseWareFail=== platform: android ; deviceName: ");
            sb.append(DeviceUtils.getModel());
            sb.append("; appVersion:");
            sb.append(AppUtils.getAppVersionName());
            sb.append("; schoolCode:");
            sb.append(string);
            sb.append(" ; planId:");
            CourseWareBean courseWareBean = this.currentCourseWareBean;
            String str = "";
            sb.append(courseWareBean == null ? str : Integer.valueOf(courseWareBean.planId));
            sb.append(" ; courseWareId");
            CourseWareBean courseWareBean2 = this.currentCourseWareBean;
            if (courseWareBean2 != null) {
                str = courseWareBean2.courseWareId;
            }
            sb.append(str);
            sb.append(" ; isDownLoaded:0 ; goClassTime:");
            sb.append(TimeUtils.getNowString());
            objArr[0] = sb.toString();
            XesLog.i(xesLogTag, objArr);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("url", this.realUrl);
        jsonObject.addProperty("isOnlineUrl", Integer.valueOf(courseLoadResult.isLocal() ^ true ? 1 : 0));
        jsonObject.addProperty("loadTime", Long.valueOf((System.currentTimeMillis() - this.loadStartTime) / 1000));
        jsonObject.addProperty("isSuccess", 0);
        jsonObject.addProperty("isPlayback", Integer.valueOf(this.enableAlignTimeStamp ? 1 : 0));
        XesLog.ut("coursewareLoad", jsonObject);
        if (!courseLoadResult.isLocal()) {
            HeartBeatUtil.setKejianStatus(3);
        }
        String url = courseLoadResult.getUrl();
        if (url == null || !url.contains(URL_TAG)) {
            double d = 0.0d;
            if (this.loadStartTime > 0) {
                try {
                    BigDecimal divide = BigDecimal.valueOf(System.currentTimeMillis() - this.loadStartTime).divide(BigDecimal.valueOf(1000), 3, 4);
                    if (divide.doubleValue() <= 0.0d) {
                        divide = BigDecimal.ZERO;
                    }
                    d = divide.doubleValue();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", "fail");
                    if (courseLoadResult != null) {
                        jSONObject.put("is_local_course", courseLoadResult.isLocal() ? 1 : 2);
                    }
                    jSONObject.put("url", this.realUrl);
                    jSONObject.put("courseware_load_duration", d);
                    if (this.enableAlignTimeStamp) {
                        i = 2;
                    }
                    jSONObject.put("is_play_back", i);
                    HwTrackUtil.INSTANCE.track("hw_courseware_load", jSONObject);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("msg", courseLoadResult.getMsg());
                hashMap.put("url", courseLoadResult.getUrl());
                hashMap.put("load_duration", Double.valueOf(d * 1000.0d));
                hashMap.put("is_local", Boolean.valueOf(courseLoadResult.isLocal()));
                LiveTrack.courseLoadStep(CourseLoadStep.LoadFail, hashMap);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    private void showDialog() {
        if (this.mQuitOutDialog == null && this.mContext != null) {
            BaseDialog baseDialog = new BaseDialog(this.mContext);
            this.mQuitOutDialog = baseDialog;
            baseDialog.contentView(R.layout.courseware_dialog_reload).gravity(17).canceledOnTouchOutside(true);
            TextView textView = (TextView) this.mQuitOutDialog.findViewById(R.id.tv_reload);
            this.reload = textView;
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, CourseWareView.class);
                    PluginEventBus.onEvent(DataBusKey.CLASS_REFRESH_KEY, new PluginEventData(getClass(), DataBusKey.CLASS_REFRESH_KEY, "refresh"));
                    CourseWareView.this.mQuitOutDialog.dismiss();
                    CourseWareView.this.refresh();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        this.mQuitOutDialog.show();
    }

    public void setLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    public void switchCourseWare(CourseWareBean courseWareBean, boolean z) {
        if (this.enableAlignTimeStamp) {
            if (z) {
                this.isLoadCourse = true;
            }
            this.courseMap.add(courseWareBean);
            CourseWareBean courseWareBean2 = this.currentCourseWareBean;
            if (courseWareBean2 == null || !courseWareBean2.equal(this.courseMap.get(0))) {
                this.currentCourseWareBean = this.courseMap.get(0);
                syncCourseShow(z);
            }
        } else {
            this.currentCourseWareBean = courseWareBean;
            syncCourseShow(z);
        }
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "playAnimate -> 传给内容云前=========" + this.currentCourseWareBean.jsString);
    }

    public void switchCourseWare(CourseWareBean courseWareBean) {
        switchCourseWare(courseWareBean, false);
    }

    public void alignTimeStamp(long j) {
        this.timeStamp = j;
        if (this.courseMap.size() > 0) {
            this.currentCourseWareBean = this.courseMap.get(0);
        }
        syncCourseShow(false);
    }

    public void enableAlignTimeStamp(boolean z) {
        this.enableAlignTimeStamp = z;
    }

    public void track_click_classroom_load_course(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("courseware_isdownload", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    private void syncCourseShow(boolean z) {
        CourseWareBean courseWareBean;
        if (z) {
            LiveTrack.courseLoadStep(CourseLoadStep.PrepareLoad);
        }
        if (!this.enableAlignTimeStamp || z || (courseWareBean = this.showCourseWareBean) == null || !courseWareBean.equal(this.currentCourseWareBean)) {
            CourseWareBean courseWareBean2 = this.currentCourseWareBean;
            if (courseWareBean2 == null) {
                return;
            }
            if (courseWareBean2.timestamp <= this.timeStamp || z || !this.enableAlignTimeStamp) {
                XesLogTag xesLogTag = TAG;
                XesLog.i(xesLogTag, "playAnimate -> 传给内容云中" + this.currentCourseWareBean.jsString);
                OnSwitchStatusListener onSwitchStatusListener2 = this.onSwitchStatusListener;
                if (onSwitchStatusListener2 != null) {
                    onSwitchStatusListener2.onBegin(this.currentCourseWareBean);
                }
                ThreadUtils.runOnUiThread(new CourseWareView$$ExternalSyntheticLambda2(this, z));
            }
        } else if (!this.courseMap.isEmpty() && !this.isLoadCourse) {
            this.courseMap.remove(0);
        }
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r10v2, types: [int, boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$syncCourseShow$1$CourseWareView(boolean r18) {
        /*
            r17 = this;
            r0 = r17
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r1 = r0.currentCourseWareBean
            java.lang.String r2 = r1.imgUrl
            java.util.List<java.lang.String> r3 = r1.photoWallImageArray
            android.widget.ImageView[] r4 = r0.imageViews
            r5 = 0
            r4 = r4[r5]
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder r6 = new com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder
            r6.<init>()
            int r7 = r1.blackBoardType
            r8 = 3
            r9 = 2
            r10 = 1
            if (r7 != r10) goto L_0x0033
            android.widget.ImageView[] r2 = r0.imageViews
            int r3 = r2.length
            r11 = r5
        L_0x001d:
            if (r11 >= r3) goto L_0x002a
            r12 = r2[r11]
            r12.setAdjustViewBounds(r10)
            r0.removeView(r12)
            int r11 = r11 + 1
            goto L_0x001d
        L_0x002a:
            java.lang.String r2 = r1.imgUrl
            java.lang.String r3 = r1.imgUrl
            r6.url(r3)
            goto L_0x02e3
        L_0x0033:
            r11 = -1
            if (r7 != r9) goto L_0x0054
            int r2 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_course_ware_white
            r6.drawableId(r2)
            android.widget.ImageView[] r2 = r0.imageViews
            int r3 = r2.length
            r12 = r5
        L_0x003f:
            if (r12 >= r3) goto L_0x02e2
            r13 = r2[r12]
            r13.setAdjustViewBounds(r10)
            r0.removeView(r13)
            android.view.ViewGroup$LayoutParams r14 = new android.view.ViewGroup$LayoutParams
            r14.<init>(r11, r11)
            r0.addView(r13, r14)
            int r12 = r12 + 1
            goto L_0x003f
        L_0x0054:
            if (r7 != r8) goto L_0x008c
            if (r3 == 0) goto L_0x0080
            int r2 = r3.size()
            if (r2 <= 0) goto L_0x0080
            int r2 = r0.mPicUrlNum
            int r11 = r3.size()
            if (r2 >= r11) goto L_0x0072
            int r2 = r0.mPicUrlNum
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r6.url(r2)
            goto L_0x0080
        L_0x0072:
            int r2 = r3.size()
            int r2 = r2 - r10
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r6.url(r2)
        L_0x0080:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "show_photo"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.commonTrack(r3, r2)
            goto L_0x02e2
        L_0x008c:
            r3 = 9
            if (r7 != r3) goto L_0x00f7
            android.widget.ImageView[] r2 = r0.imageViews
            if (r2 == 0) goto L_0x00a3
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00a3
            int r3 = r2.length
            r12 = r5
        L_0x0099:
            if (r12 >= r3) goto L_0x00a3
            r13 = r2[r12]
            r0.removeView(r13)
            int r12 = r12 + 1
            goto L_0x0099
        L_0x00a3:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.ScreenShareView r2 = r0.screenView
            if (r2 != 0) goto L_0x00e1
            com.tal.app.thinkacademy.live.business.canvastriplescreen.ScreenShareView r2 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.ScreenShareView
            android.content.Context r3 = r0.mContext
            boolean r12 = r0.enableAlignTimeStamp
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r13 = r0.mLiveRoomProvider
            r2.<init>(r3, r12, r1, r13)
            r0.screenView = r2
            int r2 = r17.getWidth()
            int r3 = r17.getHeight()
            if (r2 <= 0) goto L_0x00d2
            if (r3 <= 0) goto L_0x00d2
            com.tal.app.thinkacademy.live.business.canvastriplescreen.ScreenShareView r2 = r0.screenView
            com.tal.app.thinkacademy.live.business.canvastriplescreen.BaseScreenShareView r2 = r2.getLayout()
            int r3 = r17.getWidth()
            int r11 = r17.getHeight()
            r0.addView(r2, r3, r11)
            goto L_0x00e4
        L_0x00d2:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.ScreenShareView r2 = r0.screenView
            com.tal.app.thinkacademy.live.business.canvastriplescreen.BaseScreenShareView r2 = r2.getLayout()
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r3.<init>(r11, r11)
            r0.addView(r2, r3)
            goto L_0x00e4
        L_0x00e1:
            r2.notifyDataChange(r1)
        L_0x00e4:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$OnSwitchStatusListener r2 = r0.onSwitchStatusListener
            if (r2 == 0) goto L_0x00ed
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r3 = r0.currentCourseWareBean
            r2.onResult(r10, r3)
        L_0x00ed:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r2 = r0.currentCourseWareBean
            r0.showCourseWareBean = r2
            r0.hasFail = r5
            r0.isLoadCourse = r5
            goto L_0x02e2
        L_0x00f7:
            r3 = -10086(0xffffffffffffd89a, float:NaN)
            if (r7 != r3) goto L_0x0110
            r17.releaseScreenView()
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$OnSwitchStatusListener r1 = r0.onSwitchStatusListener
            if (r1 == 0) goto L_0x0107
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r2 = r0.currentCourseWareBean
            r1.onResult(r10, r2)
        L_0x0107:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r1 = r0.currentCourseWareBean
            r0.showCourseWareBean = r1
            r0.hasFail = r5
            r0.isLoadCourse = r5
            return
        L_0x0110:
            if (r7 != 0) goto L_0x02e2
            int r3 = r1.courseType
            if (r3 != 0) goto L_0x011b
            r6.url(r2)
            goto L_0x02e2
        L_0x011b:
            r17.releaseScreenView()
            boolean r2 = r0.isBindCourseware
            if (r2 != 0) goto L_0x0146
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$OnSwitchStatusListener r1 = r0.onSwitchStatusListener
            if (r1 == 0) goto L_0x012b
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r2 = r0.currentCourseWareBean
            r1.onResult(r10, r2)
        L_0x012b:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r1 = r0.currentCourseWareBean
            r0.showCourseWareBean = r1
            r0.hasFail = r5
            r0.isLoadCourse = r5
            android.widget.ImageView[] r1 = r0.imageViews
            if (r1 == 0) goto L_0x0145
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0145
            int r2 = r1.length
        L_0x013b:
            if (r5 >= r2) goto L_0x0145
            r3 = r1[r5]
            r0.removeView(r3)
            int r5 = r5 + 1
            goto L_0x013b
        L_0x0145:
            return
        L_0x0146:
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r2 = r0.mWebAgent
            if (r2 != 0) goto L_0x015d
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r2 = new com.tal.app.thinkacademy.common.business.browser.agent.WebAgent
            android.content.Context r3 = r0.mContext
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3
            r2.<init>(r3)
            java.util.List r3 = r17.getErrorHandlers()
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r2 = r2.applyLifeHandler(r3)
            r0.mWebAgent = r2
        L_0x015d:
            java.lang.String r2 = "https://sszt-mgr.oss-cn-beijing.aliyuncs.com/courseware/"
            java.lang.String r3 = "http://localhost:8080/"
            java.lang.String r11 = ""
            if (r18 != 0) goto L_0x01fc
            android.widget.ImageView[] r12 = r0.imageViews
            if (r12 == 0) goto L_0x01fc
            int r13 = r12.length
            if (r13 <= 0) goto L_0x01fc
            int r13 = r12.length
            r14 = r5
        L_0x016e:
            if (r14 >= r13) goto L_0x01fc
            r15 = r12[r14]
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r8 = r0.mWebAgent
            com.tal.app.thinkacademy.common.business.browser.view.IWebDelegate r8 = r8.getWebDelegate()
            if (r8 == 0) goto L_0x018a
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r8 = r0.mWebAgent
            com.tal.app.thinkacademy.common.business.browser.view.IWebDelegate r8 = r8.getWebDelegate()
            com.tal.app.thinkacademy.common.business.browser.view.XesWebView r8 = r8.getWebView()
            android.view.ViewParent r8 = r8.getParent()
            if (r8 != 0) goto L_0x01f1
        L_0x018a:
            com.tal.app.thinkacademy.common.business.browser.server.ServerManager r8 = com.tal.app.thinkacademy.common.business.browser.server.ServerManager.getInstance()
            boolean r8 = r8.isServerRunning()
            if (r8 == 0) goto L_0x01ab
            com.tal.app.thinkacademy.common.imconfig.ImConfig r8 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            boolean r8 = r8.isUpDataCommonPackage()
            if (r8 != 0) goto L_0x01ab
            com.tal.app.thinkacademy.lib.logger.XesLogTag r8 = TAG
            java.lang.Object[] r9 = new java.lang.Object[r10]
            java.lang.String r16 = "首次进入是黑板然后切课件时调用的：服务器启动正常并且基础包加载正常"
            r9[r5] = r16
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r8, r9)
            r0.loadView(r3, r10)
            goto L_0x01f1
        L_0x01ab:
            com.tal.app.thinkacademy.lib.logger.XesLogTag r8 = TAG
            java.lang.Object[] r9 = new java.lang.Object[r10]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r5 = "首次进入是黑板然后切课件时调用的==服务器未启动，onLocalSHost: 拿远端地址"
            r10.append(r5)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r5 = r5.getCommonDistInfo()
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            if (r5 != 0) goto L_0x01ca
            r5 = r11
            goto L_0x01d4
        L_0x01ca:
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r5 = r5.getCommonDistInfo()
            java.lang.String r5 = r5.getOnlineUrl()
        L_0x01d4:
            r10 = 0
            r9[r10] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r8, r9)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r5 = r5.getCommonDistInfo()
            if (r5 != 0) goto L_0x01e4
            r5 = r2
            goto L_0x01ee
        L_0x01e4:
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r5 = r5.getCommonDistInfo()
            java.lang.String r5 = r5.getOnlineUrl()
        L_0x01ee:
            r0.loadView(r5, r10)
        L_0x01f1:
            r0.removeView(r15)
            int r14 = r14 + 1
            r5 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            goto L_0x016e
        L_0x01fc:
            if (r18 == 0) goto L_0x026d
            com.tal.app.thinkacademy.common.business.browser.server.ServerManager r5 = com.tal.app.thinkacademy.common.business.browser.server.ServerManager.getInstance()
            boolean r5 = r5.isServerRunning()
            if (r5 == 0) goto L_0x0227
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            boolean r5 = r5.isUpDataCommonPackage()
            if (r5 != 0) goto L_0x0227
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = TAG
            r5 = 1
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r9 = "正常的逻辑首次进入课堂==服务器启动正常并且基础包加载正常"
            r10 = 0
            r8[r10] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r8)
            com.tal.app.thinkacademy.live.core.utils.CourseLoadStep r2 = com.tal.app.thinkacademy.live.core.utils.CourseLoadStep.CheckCommon
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.courseLoadStep(r2)
            r0.loadView(r3, r5)
            goto L_0x02e2
        L_0x0227:
            r5 = 1
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = TAG
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "正常的逻辑首次进入课堂==服务器未启动，onLocalSHost: 拿远端地址"
            r5.append(r9)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r9 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r9 = r9.getCommonDistInfo()
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x0246
            goto L_0x0250
        L_0x0246:
            com.tal.app.thinkacademy.common.imconfig.ImConfig r5 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r5 = r5.getCommonDistInfo()
            java.lang.String r11 = r5.getOnlineUrl()
        L_0x0250:
            r5 = 0
            r8[r5] = r11
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r3, r8)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r3 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r3 = r3.getCommonDistInfo()
            if (r3 != 0) goto L_0x025f
            goto L_0x0269
        L_0x025f:
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ConfigInfo$CourseWares r2 = r2.getCommonDistInfo()
            java.lang.String r2 = r2.getOnlineUrl()
        L_0x0269:
            r0.loadView(r2, r5)
            goto L_0x02e2
        L_0x026d:
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r2 = r0.mWebAgent
            if (r2 == 0) goto L_0x0296
            java.lang.String r3 = r1.jsString
            java.lang.String r5 = "window.handleItsMessage"
            r2.jsCallBack(r5, r3)
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = TAG
            r3 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "传给内容云后========="
            r3.append(r8)
            java.lang.String r8 = r1.jsString
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r8 = 0
            r5[r8] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r5)
        L_0x0296:
            if (r1 == 0) goto L_0x02dd
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r2 = r0.showCourseWareBean
            if (r2 == 0) goto L_0x02dd
            java.lang.String r2 = r1.pageId
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareBean r3 = r0.showCourseWareBean
            java.lang.String r3 = r3.pageId
            boolean r3 = android.text.TextUtils.equals(r2, r3)
            if (r3 != 0) goto L_0x02dd
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r5 = "pageId"
            r3.put(r5, r2)
            com.tal.app.thinkacademy.live.core.utils.CourseLoadStep r2 = com.tal.app.thinkacademy.live.core.utils.CourseLoadStep.TurnPage
            com.tal.app.thinkacademy.live.core.utils.LiveTrack.courseLoadStep(r2, r3)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$OnSwitchStatusListener r2 = r0.onSwitchStatusListener
            if (r2 == 0) goto L_0x02dd
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = TAG
            r3 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "=====翻页是否成功的回调succeed： "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r9 = 0
            r5[r9] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r2, r5)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$OnSwitchStatusListener r2 = r0.onSwitchStatusListener
            r2.onResult(r3, r1)
            goto L_0x02de
        L_0x02dd:
            r9 = 0
        L_0x02de:
            r0.showCourseWareBean = r1
            r0.hasFail = r9
        L_0x02e2:
            r2 = 0
        L_0x02e3:
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = TAG
            r5 = 1
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "预下载的图片地址是(CourseWareView 加载的 url 是：newPicUrl="
            r5.append(r9)
            r5.append(r2)
            java.lang.String r2 = ", blackBoardType[1: 黑板，2：白板]="
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = r5.toString()
            r5 = 0
            r8[r5] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r3, r8)
            int r2 = r1.courseType
            if (r2 == 0) goto L_0x0314
            r2 = 1
            if (r7 == r2) goto L_0x0314
            r2 = 2
            if (r7 == r2) goto L_0x0314
            r2 = 3
            if (r7 != r2) goto L_0x0345
        L_0x0314:
            r17.releaseScreenView()
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder r2 = r6.imageView(r4)
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Companion r3 = com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl.Companion
            int r3 = r3.getDISKCACHESTRATEGY_RESOURCE()
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder r2 = r2.cacheStrategy(r3)
            r3 = 1
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder r2 = r2.isCenterInside(r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl$Builder r2 = r2.resize(r3, r3)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$2 r3 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView$2
            r3.<init>(r1)
            r2.requestListener(r3)
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r1 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            android.content.Context r2 = r17.getContext()
            com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl r3 = r6.build()
            r1.loadImage(r2, r3)
        L_0x0345:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseWareView.lambda$syncCourseShow$1$CourseWareView(boolean):void");
    }

    public void setOnSwitchStatusListener(OnSwitchStatusListener onSwitchStatusListener2) {
        this.onSwitchStatusListener = onSwitchStatusListener2;
    }

    public void failRetry() {
        if (this.hasFail) {
            this.mPicUrlNum++;
            LiveTrackData.newCourseTraceId(System.currentTimeMillis());
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "失败重试");
            LiveTrack.courseLoadStep(CourseLoadStep.RefreshCourse, hashMap);
            syncCourseShow(true);
        }
    }

    public void refresh() {
        this.isLoadCourse = true;
        LiveTrackData.newCourseTraceId(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "主动刷新");
        LiveTrack.courseLoadStep(CourseLoadStep.RefreshCourse, hashMap);
        syncCourseShow(true);
        LeanplumUtil.commonTrack(LeanplumUtil.click_refresh, LeanplumUtil.trackMap());
    }

    public void setBindCourseware(boolean z) {
        this.isBindCourseware = z;
    }

    private void initListener() {
        ServerManager.getInstance().setOnServerConnectionListener(new OnServerConnectionListener() {
            public void onServerStart(String str) {
                LiveTrackData.mLocalServerState = "成功";
                CourseWareView.this.onLocalServerStart(ServerManager.getInstance().getServerUrl());
            }

            public void onServerError(String str) {
                LiveTrackData.mLocalServerState = "失败";
                CourseWareView.this.onLocalServerError(str);
            }

            public void onServerStop() {
                LiveTrackData.mLocalServerState = "停止";
                CourseWareView.this.onLocalServerStop();
            }

            public void onServerRequestError(int i, String str) {
                ServerDomain find = ServerDomain.find(i, str);
                if (new IgnoreUtil().ignore(str)) {
                    XesLogTag access$400 = CourseWareView.TAG;
                    XesLog.i(access$400, "忽略 LocalServer 加载资源异常 : " + find.toString());
                    return;
                }
                LiveTrack.courseLoadError(find);
                XesLogTag access$4002 = CourseWareView.TAG;
                XesLog.e(access$4002, "LocalServer 加载资源异常 : " + find.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public void onLocalServerStart(String str) {
        this.mRootUrl = str;
        LiveTrack.courseLoadStep(CourseLoadStep.ServerCallback);
    }

    private void loadView(String str, boolean z) {
        CouseWareInfoRecover couseWareInfoRecover;
        boolean z2;
        if (this.currentCourseWareBean != null && this.mWebAgent != null && (couseWareInfoRecover = (CouseWareInfoRecover) ShareDataManager.getInstance().getCacheEntity(CouseWareInfoRecover.class, String.valueOf(this.currentCourseWareBean.planId), ShareDataManager.SHAREDATA_USER)) != null) {
            if (z) {
                LiveTrack.courseLoadStep(CourseLoadStep.CheckResource);
                if (!ImCoursesWareUtils.INSTANCE.isCourseFinished(this.currentCourseWareBean.planId + "")) {
                    this.realUrl = str + "dist/index.html?localUrl=&role=student&optimizationPageLoad=true&itsId=" + couseWareInfoRecover.getId() + "&remoteUrl=" + getmRootUrl(couseWareInfoRecover);
                    XesLogTag xesLogTag = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("进入课堂：课件加载线上资源地址: ");
                    sb.append(this.realUrl);
                    XesLog.i(xesLogTag, sb.toString());
                    this.isDownLoaded = EnterRoomMuteData.STATUS_UN_MUTE;
                    track_click_classroom_load_course(LeanplumUtil.start_load_courseware, EnterRoomMuteData.STATUS_UN_MUTE);
                    z2 = false;
                } else {
                    this.isDownLoaded = "1";
                    this.realUrl = str + "dist/index.html?localUrl=" + str + couseWareInfoRecover.getCatalog() + "/index.html?firstLoad=true&line=off&role=student&optimizationPageLoad=true&itsId=" + couseWareInfoRecover.getId() + "&remoteUrl=" + getmRootUrl(couseWareInfoRecover);
                    XesLogTag xesLogTag2 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("进入课堂：课件加载线下本地资源: ");
                    sb2.append(this.realUrl);
                    XesLog.i(xesLogTag2, sb2.toString());
                    track_click_classroom_load_course(LeanplumUtil.start_load_courseware, "1");
                    z2 = true;
                }
                XesLogTag xesLogTag3 = TAG;
                XesLog.i(xesLogTag3, "onLocalServerStart: " + this.realUrl);
                Object[] objArr = new Object[1];
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onLocalServerStart: ");
                sb3.append(couseWareInfoRecover);
                objArr[0] = sb3.toString() == null ? "我是空" : couseWareInfoRecover.getCompressIndexUrl();
                XesLog.i(xesLogTag3, objArr);
            } else {
                this.isDownLoaded = EnterRoomMuteData.STATUS_UN_MUTE;
                this.realUrl = str + "dist/index.html?localUrl=&role=student&optimizationPageLoad=true&itsId=" + couseWareInfoRecover.getId() + "&remoteUrl=" + getmRootUrl(couseWareInfoRecover) + "&timeStamp=" + System.currentTimeMillis();
                XesLogTag xesLogTag4 = TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("进入课堂：课件加载dist远端线上资源地址: ");
                sb4.append(this.realUrl);
                XesLog.i(xesLogTag4, sb4.toString());
                track_click_classroom_load_course(LeanplumUtil.start_load_courseware, EnterRoomMuteData.STATUS_UN_MUTE);
                z2 = false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.realUrl);
            hashMap.put("is_local", Boolean.valueOf(z2));
            LiveTrack.courseLoadStep(CourseLoadStep.StartLoadUrl, hashMap);
            this.realUrl += "&schoolCode=" + ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
            XesLogTag xesLogTag5 = TAG;
            XesLog.i(xesLogTag5, "进入课堂，课件加载地址：" + this.realUrl);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.loadStartTime = System.currentTimeMillis();
            this.mWebAgent.applyConfig(new AgentConfig.Builder().setShowProgressBar(false).setShowTitle(false).build()).setWebAgentParent(this, layoutParams).loadUrl(this.realUrl);
            LiveAreaContext.get().layoutObserver.observe(this.mContext, new CourseWareView$$ExternalSyntheticLambda0(this));
            OnSwitchStatusListener onSwitchStatusListener2 = this.onSwitchStatusListener;
            if (onSwitchStatusListener2 != null) {
                onSwitchStatusListener2.onResult(true, this.currentCourseWareBean);
            }
            this.showCourseWareBean = this.currentCourseWareBean;
            this.hasFail = false;
            XesLog.i(xesLogTag5, "CPU当前频率: " + PhoneUtils.getCurCpuFreq());
            XesLog.i(xesLogTag5, "CPU最小频率: " + PhoneUtils.getMinCpuFreq());
            XesLog.i(xesLogTag5, "CPU最大频率: " + PhoneUtils.getMaxCpuFreq());
            XesLog.i(xesLogTag5, "最大运行时内存(RAM内存): " + PhoneUtils.getRamMaxMemory());
            XesLog.i(xesLogTag5, "当前可用运行时内存大小(RAM内存): " + PhoneUtils.getRamRemainingMemory());
            XesLog.i(xesLogTag5, "手机最大内存大小(ROM内存): " + PhoneUtils.getRomMaxMemory());
            XesLog.i(xesLogTag5, "手机当前可用内存大小(ROM内存): " + PhoneUtils.getRomRemainingMemory());
        }
    }

    public /* synthetic */ void lambda$loadView$2$CourseWareView(LiveAreaContext liveAreaContext) {
        IWebDelegate webDelegate = this.mWebAgent.getWebDelegate();
        if (webDelegate != null && (webDelegate instanceof View) && ((View) webDelegate).getLayoutParams() != null) {
            this.loadStartTime = System.currentTimeMillis();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            String replaceAll = this.realUrl.replaceAll("firstLoad", URL_TAG);
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "课件尺寸变化 重新loadUrl: " + replaceAll);
            this.mWebAgent.applyConfig(new AgentConfig.Builder().setShowProgressBar(false).setShowTitle(false).build()).setWebAgentParent(this, layoutParams).loadUrl(replaceAll);
        }
    }

    /* access modifiers changed from: private */
    public void onLocalServerError(String str) {
        XesLogTag xesLogTag = TAG;
        XesLog.e(xesLogTag, "课件问题-本地服务 -> onLocalServerError: " + str + this.mRootUrl);
        this.mRootUrl = null;
        OnSwitchStatusListener onSwitchStatusListener2 = this.onSwitchStatusListener;
        if (onSwitchStatusListener2 != null) {
            onSwitchStatusListener2.onResult(false, this.currentCourseWareBean);
        }
        this.hasFail = true;
        HashMap hashMap = new HashMap();
        hashMap.put("msg", str);
        LiveTrack.courseLoadStep(CourseLoadStep.ServerCallback, hashMap);
    }

    /* access modifiers changed from: private */
    public void onLocalServerStop() {
        XesLogTag xesLogTag = TAG;
        XesLog.e(xesLogTag, "课件问题-本地服务 -> onLocalServerStop: " + this.mRootUrl);
        this.mRootUrl = null;
        OnSwitchStatusListener onSwitchStatusListener2 = this.onSwitchStatusListener;
        if (onSwitchStatusListener2 != null) {
            onSwitchStatusListener2.onResult(false, this.currentCourseWareBean);
        }
        this.hasFail = true;
        LiveTrack.courseLoadStep(CourseLoadStep.ServerCallback);
    }

    private String getmRootUrl(CouseWareInfoRecover couseWareInfoRecover) {
        ArrayList arrayList = new ArrayList();
        if (couseWareInfoRecover != null) {
            String compressIndexUrl = couseWareInfoRecover.getCompressIndexUrl();
            if (compressIndexUrl != null) {
                if (compressIndexUrl.contains("?")) {
                    compressIndexUrl = compressIndexUrl + "&firstLoad=true";
                } else {
                    compressIndexUrl = compressIndexUrl + "?firstLoad=true";
                }
            }
            arrayList.add(compressIndexUrl);
            if (couseWareInfoRecover.getCompressIndexUrlSpareList() != null) {
                for (String str : couseWareInfoRecover.getCompressIndexUrlSpareList()) {
                    if (str != null) {
                        if (str.contains("?")) {
                            str = str + "&firstLoad=true";
                        } else {
                            str = str + "?firstLoad=true";
                        }
                    }
                    arrayList.add(str);
                }
            }
        }
        return EncodeUtils.urlEncode(GsonUtils.toJson(arrayList));
    }

    private void releaseScreenView() {
        ScreenShareView screenShareView = this.screenView;
        if (screenShareView != null) {
            removeView(screenShareView.getLayout());
            this.screenView.release();
            this.screenView = null;
        }
    }

    public void onDestroy() {
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
            this.mWebAgent = null;
        }
        releaseScreenView();
    }

    private List<WebViewLifeHandler> getErrorHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WebViewLifeHandler() {
            public void onReceivedError(String str, WebResourceError webResourceError) {
                super.onReceivedError(str, webResourceError);
                LiveTrack.courseLoadError(new WebDomain(webResourceError.getErrorCode(), "url: " + str + "，desc: " + webResourceError.getDescription().toString()));
            }
        });
        return arrayList;
    }
}
