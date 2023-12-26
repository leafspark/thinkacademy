package com.tal.app.thinkacademy.live.core.live;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.google.gson.JsonObject;
import com.gyf.immersionbar.ImmersionBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.entity.ScreenInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.logan.LoganFileParser;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.oom.OomTaskUtil;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.impl.BigClassLiveAreaStrategy;
import com.tal.app.thinkacademy.live.core.layout.impl.PhoneSmallLiveAreaStrategy;
import com.tal.app.thinkacademy.live.core.layout.impl.SmallLivePadAreaStrategy;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.core.utils.CourseLoadStep;
import com.tal.app.thinkacademy.live.core.utils.IrcDomain;
import com.tal.app.thinkacademy.live.core.utils.LivePluginLevelUtil;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@NotPadAutoScreen
public abstract class BaseLiveActivity<VM extends BaseViewModel, VB extends ViewBinding> extends BaseVmActivity<VM, VB> implements ILiveActivityProvider {
    private static final String TAG = "BaseLiveActivity";
    private long lastTimeStamp;
    protected BaseLiveController mLiveController;
    protected LiveRoomData mLiveRoomData;
    private BaseDialog mQuitOutDialog;
    /* access modifiers changed from: private */
    public ViewGroup mRootView;
    private TextView tvCancel;
    private TextView tvExit;
    private TextView tvMsgTip;

    /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context, com.tal.app.thinkacademy.live.core.live.BaseLiveActivity] */
    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract int getInflateView();

    /* access modifiers changed from: protected */
    public abstract int getPluginContainerId();

    /* access modifiers changed from: protected */
    public abstract BaseLiveController initController();

    /* access modifiers changed from: protected */
    public void initViews() {
    }

    /* access modifiers changed from: protected */
    public void onFinish() {
    }

    /* access modifiers changed from: protected */
    public void setFullScreen() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.tal.app.thinkacademy.live.core.live.BaseLiveActivity, android.app.Activity, com.tal.app.thinkacademy.common.base.BaseVmActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().getDecorView().setSystemUiVisibility(2052);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        ImmersionBar.with(this).keyboardEnable(false).init();
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            getWindow().setAttributes(attributes);
        }
        BaseLiveActivity.super.onCreate(bundle);
        HwWebViewCacheManager.Companion.getInstance().clearWebView();
        this.mRootView = (ViewGroup) findViewById(getPluginContainerId());
        preInit();
        setupLog();
        initPoint();
        initViews();
        initData();
        initLocalServer();
        OomTaskUtil.INSTANCE.start();
    }

    /* access modifiers changed from: protected */
    public LiveRoomData getLiveRoomData() {
        return this.mLiveRoomData;
    }

    private void initLocalServer() {
        ServerManager.getInstance().startService(getApplicationContext());
        LiveTrack.courseLoadStep(CourseLoadStep.StartServer);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r4.mLiveController;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getKeyCode()
            r1 = 1
            r2 = 0
            r3 = 4
            if (r0 != r3) goto L_0x0018
            int r0 = r5.getAction()
            if (r0 == r1) goto L_0x0018
            com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController r0 = r4.mLiveController
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.dispatchKeyEvent(r5)
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            if (r0 != 0) goto L_0x0023
            boolean r5 = com.tal.app.thinkacademy.live.core.live.BaseLiveActivity.super.dispatchKeyEvent(r5)
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.live.BaseLiveActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseLiveController baseLiveController = this.mLiveController;
        if ((baseLiveController != null ? baseLiveController.dispatchTouchEvent(motionEvent) : false) || BaseLiveActivity.super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void preInit() {
        try {
            String string = getIntent().getExtras().getString("liveParams", "");
            XesLog.it(TAG, new Object[]{"进入课中传递参数：" + string});
            if (!StringUtils.isEmpty(string)) {
                this.mLiveRoomData = (LiveRoomData) GsonUtils.fromJson(string, LiveRoomData.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLog() {
        uploadLog(true);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        LiveTrackData.mLiveRoomData = this.mLiveRoomData;
        if (this.mLiveRoomData != null) {
            LiveTrack.INSTANCE.enterClassRoom();
            HWEventTracking.CourseData courseData = new HWEventTracking.CourseData();
            courseData.setClassId(this.mLiveRoomData.getCourseId());
            courseData.setPlanId(this.mLiveRoomData.getPlanId());
            if ("2".equals(this.mLiveRoomData.getSubPlatformType())) {
                courseData.setClassType("small");
            } else {
                courseData.setClassType("dual");
            }
            HWEventTracking.get().setCourseProperty(courseData);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.tal.app.thinkacademy.live.core.live.BaseLiveActivity, androidx.fragment.app.FragmentActivity] */
    /* access modifiers changed from: protected */
    public void initPoint() {
        LiveRoomData liveRoomData = this.mLiveRoomData;
        if (liveRoomData == null || !"2".equals(liveRoomData.getSubPlatformType())) {
            LiveAreaContext.get().setupStrategy(new BigClassLiveAreaStrategy(this));
        } else if (PadUtils.isPad(this)) {
            LiveAreaContext.get().setupStrategy(new SmallLivePadAreaStrategy(this));
        } else {
            LiveAreaContext.get().setupStrategy(new PhoneSmallLiveAreaStrategy(this));
        }
        try {
            ScreenInfo screenInch = PadUtils.getScreenInch(this);
            boolean isPad = PadUtils.isPad(this);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("screen_inch", screenInch.getInch());
            jSONObject.put("screen_width", screenInch.getWidth());
            jSONObject.put("screen_height", screenInch.getHeight());
            jSONObject.put("screen_xdpi", (double) screenInch.getXdpi());
            jSONObject.put("screen_ydpi", (double) screenInch.getYdpi());
            jSONObject.put("orientation", screenInch.getOrientation());
            jSONObject.put("is_pad", isPad);
            jSONObject.put("from", "Course");
            HwTrackUtil.INSTANCE.track("hw_screen_data", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addView(BaseLivePluginView baseLivePluginView, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup = (ViewGroup) baseLivePluginView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(baseLivePluginView);
        }
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 != null) {
            viewGroup2.addView(baseLivePluginView, LivePluginLevelUtil.getLevel(viewGroup2, i, baseLivePluginView), layoutParams);
        }
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        getLifecycle().addObserver(lifecycleObserver);
    }

    public Lifecycle getLifecycleOwner() {
        return getLifecycle();
    }

    public void removeView(final View view) {
        if (view != null && view.getParent() != null && view.getParent().equals(this.mRootView)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.mRootView.removeView(view);
                return;
            }
            Handler mainHandler = ThreadUtils.getMainHandler();
            AnonymousClass1 r1 = new Runnable() {
                public void run() {
                    BaseLiveActivity.this.mRootView.removeView(view);
                }
            };
            if (!(mainHandler instanceof Handler)) {
                mainHandler.post(r1);
            } else {
                AsynchronousInstrumentation.handlerPost(mainHandler, r1);
            }
        }
    }

    public void setRequestedOrientation(int i) {
        BaseLiveActivity.super.setRequestedOrientation(i);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.tal.app.thinkacademy.live.core.live.BaseLiveActivity] */
    public void finishActivity() {
        if (this.mQuitOutDialog == null) {
            BaseDialog baseDialog = new BaseDialog(this);
            this.mQuitOutDialog = baseDialog;
            baseDialog.contentView(R.layout.dialog_quit).layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(343.0f), -2)).gravity(17).canceledOnTouchOutside(true);
            this.tvMsgTip = (TextView) this.mQuitOutDialog.findViewById(R.id.tv_dialog_title);
            this.tvCancel = (TextView) this.mQuitOutDialog.findViewById(R.id.tv_cancel);
            this.tvExit = (TextView) this.mQuitOutDialog.findViewById(R.id.tv_confirm);
            this.tvMsgTip.setText(R.string.leave_classroom);
            this.tvExit.setText(R.string.tv_exit);
            this.tvExit.setOnClickListener(new BaseLiveActivity$$ExternalSyntheticLambda0(this));
            this.tvCancel.setOnClickListener(new BaseLiveActivity$$ExternalSyntheticLambda1(this));
        }
        this.mQuitOutDialog.show();
    }

    public /* synthetic */ void lambda$finishActivity$0$BaseLiveActivity(View view) {
        PluginEventBus.onEvent("click_exit_or_not", new PluginEventData(BaseLiveActivity.class, "click_exit_or_not", "yes"));
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "主动");
        LiveTrack.courseLoadStep(CourseLoadStep.ExitCourse, hashMap);
        outActivity();
        this.mQuitOutDialog.dismiss();
        XesLog.ut("student.Quit", new JsonObject());
        LeanplumUtil.commonTrack("click_exit_classroom", LeanplumUtil.trackMap());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$finishActivity$1$BaseLiveActivity(View view) {
        this.mQuitOutDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void otherReasonActivity(ExitLiveRoom exitLiveRoom) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", exitLiveRoom.getValue());
        LiveTrack.courseLoadStep(CourseLoadStep.ExitCourse, hashMap);
        if (exitLiveRoom == ExitLiveRoom.KICK_OUT) {
            LiveTrack.courseLoadError(IrcDomain.IrcOut);
        }
        outActivity();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BaseLiveActivity.super.onDestroy();
        AbilityPack.get().unBind();
        getViewModelStore().clear();
        ServerManager.getInstance().stopService(getApplicationContext());
        LiveAreaContext.get().destroy();
        SoundPoolUtils.release();
        OomTaskUtil.INSTANCE.stop();
    }

    /* access modifiers changed from: protected */
    public void outActivity() {
        LiveAreaContext.get().destroy();
        ServerManager.getInstance().stopService(getApplicationContext());
        ImConfig.INSTANCE.getConfigInfo();
        ImConfig.INSTANCE.getHostUrlsConfig();
        uploadLog(false);
        LiveTrackData.destroy();
        HWEventTracking.get().clearCourse();
        AppVersionBll.Companion.getInstance().restartUpdate(getApplicationContext());
        finish();
        onFinish();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.tal.app.thinkacademy.live.core.live.BaseLiveActivity] */
    /* access modifiers changed from: protected */
    public void uploadLog(boolean z) {
        if (z) {
            LiveRoomData liveRoomData = this.mLiveRoomData;
            if (liveRoomData != null) {
                String str = null;
                String subPlatformType = liveRoomData.getSubPlatformType();
                subPlatformType.hashCode();
                char c = 65535;
                switch (subPlatformType.hashCode()) {
                    case 48:
                        if (subPlatformType.equals("0")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (subPlatformType.equals(DbParams.GZIP_DATA_EVENT)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (subPlatformType.equals("2")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = "大班";
                        break;
                    case 1:
                        str = "伪小班";
                        break;
                    case 2:
                        str = "小班";
                        break;
                }
                LoganHelper.newFileWithUpload(this, LoganFileParser.generateExtra(this.mLiveRoomData.getPlanId(), LiveTrackData.mPlanMode, str));
                return;
            }
            LoganHelper.newFileWithUpload(this, LoganFileParser.generateExtra("0", LiveTrackData.mPlanMode, "未知"));
            return;
        }
        LoganHelper.newFileWithUpload(this);
    }
}
