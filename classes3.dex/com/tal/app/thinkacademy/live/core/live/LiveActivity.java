package com.tal.app.thinkacademy.live.core.live;

import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.widget.DeviceTesting;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.databinding.ActivityBaseLiveBinding;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.live.bean.ReportDeviceBody;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController;
import com.tal.app.thinkacademy.live.core.live.controller.LiveController;
import com.tal.app.thinkacademy.live.core.live.http.bean.ModuleConfig;
import com.tal.app.thinkacademy.live.core.live.http.response.ClassroomDataEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.KeyEntity;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import com.tbruyelle.rxpermissions3.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class LiveActivity extends BaseLiveActivity<LiveViewModel, ActivityBaseLiveBinding> implements ILiveActivityProvider {
    /* access modifiers changed from: private */
    public static final String TAG = "LiveActivity";
    private AudioManager mAudioManager;
    private final XesActivityManager.FrontBackCallback mFrontBackCallback = LiveActivity$$ExternalSyntheticLambda2.INSTANCE;
    /* access modifiers changed from: private */
    public InitModuleEntity mInitModuleEntity;
    /* access modifiers changed from: private */
    public LoadStatusView mLoadingView;
    private int mMaxMusicVolume;
    private final Observer<PluginEventData> mSettingObserver = new LiveActivity$$ExternalSyntheticLambda1(this);
    private String[] mSettingPermission = null;

    public /* synthetic */ void lambda$new$0$LiveActivity(PluginEventData pluginEventData) {
        if (pluginEventData != null) {
            String operation = pluginEventData.getOperation();
            if (TextUtils.isEmpty(operation)) {
                this.mSettingPermission = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
                return;
            }
            this.mSettingPermission = new String[]{operation};
        }
    }

    static /* synthetic */ void lambda$new$1(boolean z) {
        HWEventTracking.get().ostaAppBackground(z ? "foreground" : "background");
        String str = TAG;
        Object[] objArr = new Object[1];
        objArr[0] = z ? "App进入前台" : "App进入后台";
        XesLog.it(str, objArr);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XesLog.it(TAG, new Object[]{"开始进入直播课堂"});
        setFullScreen();
        initMediaVolume();
        requestPermission();
        track_click_classroom();
        PluginEventBus.register(this, "setting_permission", this.mSettingObserver);
        DeviceTesting.INSTANCE.setTestFinished();
    }

    /* access modifiers changed from: protected */
    public int getInflateView() {
        return R.layout.activity_base_live;
    }

    /* access modifiers changed from: protected */
    public int getPluginContainerId() {
        return R.id.live_root_view;
    }

    /* access modifiers changed from: protected */
    public void preInit() {
        super.preInit();
        LiveTrackData.mInLive = true;
        long currentTimeMillis = System.currentTimeMillis();
        LiveTrackData.mEnterTime = currentTimeMillis;
        LiveTrackData.mPlanMode = "直播";
        LiveTrackData.mIrcState = "未加入";
        LiveTrackData.mLocalServerState = "未启动";
        LiveTrackData.newTraceId(currentTimeMillis);
        LiveTrackData.newCourseTraceId(currentTimeMillis);
    }

    public void initViews() {
        LoadStatusView loadStatusView = (LoadStatusView) findViewById(R.id.live_loading_view);
        this.mLoadingView = loadStatusView;
        loadStatusView.showFullLoadingView();
    }

    public void initData() {
        super.initData();
        LiveRoomData liveRoomData = getLiveRoomData();
        LiveTrackData.mLiveRoomData = liveRoomData;
        if (liveRoomData != null) {
            LiveTrack.INSTANCE.enterClassRoom();
            this.mViewModel.requestEnter(LiveUrls.LIVE_ENTER, liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId(), liveRoomData.getUpdateUserInfo(), liveRoomData.isParentAudit());
        }
        XesActivityManager.getInstance().addFrontBackCallback(this.mFrontBackCallback);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setFullScreen();
    }

    private void requestPermission() {
        request(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, LiveActivity$$ExternalSyntheticLambda3.INSTANCE);
    }

    static /* synthetic */ Unit lambda$requestPermission$2(Permission permission) {
        String str = permission.name;
        str.hashCode();
        if (str.equals("android.permission.CAMERA")) {
            XesDataBus.with("camera_permission").postStickyData(Boolean.valueOf(permission.granted));
        } else if (str.equals("android.permission.RECORD_AUDIO")) {
            XesDataBus.with("audio_permission").postStickyData(Boolean.valueOf(permission.granted));
        }
        return Unit.INSTANCE;
    }

    public void track_click_classroom() {
        HashMap trackMap = LeanplumUtil.trackMap();
        boolean isGranted = PermissionUtils.isGranted(new String[]{"android.permission.RECORD_AUDIO"});
        String str = DbParams.GZIP_DATA_EVENT;
        trackMap.put("microphone_isopen", isGranted ? str : "0");
        if (!PermissionUtils.isGranted(new String[]{"android.permission.CAMERA"})) {
            str = "0";
        }
        trackMap.put("camera_isopen", str);
        LeanplumUtil.commonTrack("show_classroom", trackMap);
    }

    public void startObserve() {
        super.startObserve();
        this.mViewModel.mEnterLiveData.observe(this, new Observer<StateData<EnterEntity>>() {
            public void onChanged(StateData<EnterEntity> stateData) {
                if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
                    if (stateData.getData() != null) {
                        LiveRoomData liveRoomData = LiveActivity.this.getLiveRoomData();
                        if (liveRoomData != null) {
                            liveRoomData.setCourseId(String.valueOf(((EnterEntity) stateData.getData()).courseInfo.getCourseId()));
                            if (liveRoomData.isParentAudit()) {
                                ((EnterEntity) stateData.getData()).courseInfo.setIsAudition(1);
                                ((EnterEntity) stateData.getData()).courseInfo.setParentAuditionLocal(true);
                            }
                        }
                        LiveActivity.this.initIrcConfig((EnterEntity) stateData.getData());
                        if (liveRoomData != null) {
                            LiveActivity.this.onEnterReqSuccess(liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId(), liveRoomData.isParentAudit());
                            LiveActivity.this.mLiveController.addDefaultEmoji();
                            LiveActivity.this.mViewModel.getEmojiDetail();
                        }
                    }
                } else if (stateData.getStatus() == StateData.DataStatus.ERROR || stateData.getStatus() == StateData.DataStatus.FAILURE) {
                    LiveActivity.this.mLoadingView.showErrorView(new Function0<Unit>() {
                        public Unit invoke() {
                            LiveActivity.this.mLoadingView.showFullLoadingView();
                            LiveRoomData liveRoomData = LiveActivity.this.getLiveRoomData();
                            if (liveRoomData == null) {
                                return null;
                            }
                            LiveActivity.this.mViewModel.requestEnter(LiveUrls.LIVE_ENTER, liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId(), liveRoomData.getUpdateUserInfo(), liveRoomData.isParentAudit());
                            return null;
                        }
                    });
                }
            }
        });
        this.mViewModel.mInitModuleLiveData.observe(this, new Observer<StateData<InitModuleEntity>>() {
            public void onChanged(StateData<InitModuleEntity> stateData) {
                boolean z;
                boolean z2;
                InitModuleEntity unused = LiveActivity.this.mInitModuleEntity = (InitModuleEntity) stateData.getData();
                if (LiveActivity.this.mInitModuleEntity != null) {
                    int i = 0;
                    z2 = false;
                    z = false;
                    for (ModuleConfig next : LiveActivity.this.mInitModuleEntity.plugins) {
                        if (next.getModuleId() == 311) {
                            i++;
                            z2 = true;
                        } else if (next.getModuleId() == 3008) {
                            i++;
                            z = true;
                        }
                        if (i >= 2) {
                            break;
                        }
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                if (!(LiveActivity.this.mLiveController == null || LiveActivity.this.mLiveController.getDataStorage() == null || LiveActivity.this.mLiveController.getDataStorage().getRoomData() == null)) {
                    LiveActivity.this.mLiveController.getDataStorage().getRoomData().setHasChatBox(z);
                }
                if (!z) {
                    LiveActivity.this.sendHideChatBoxEvent();
                }
                XesLog.it(LiveActivity.TAG, new Object[]{"是否有全员上台插件：" + z2 + "，是否有ChatBox插件：" + z});
                if (z2) {
                    XesLog.it(LiveActivity.TAG, new Object[]{"InitModel接口请求成功，获取全员上台开关"});
                    LiveRoomData liveRoomData = LiveActivity.this.getLiveRoomData();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(String.format("%s-allOnStageClosed", new Object[]{liveRoomData.getPlanId()}));
                    LiveActivity.this.mViewModel.requestClassroomData(new KeyEntity(arrayList));
                    return;
                }
                XesLog.it(LiveActivity.TAG, new Object[]{"InitModel接口请求成功，无全员上台，直接加载插件"});
                LiveActivity.this.mLiveController.onInitModuleReqSuccess(LiveActivity.this.mInitModuleEntity);
                LiveActivity.this.showActivityLoading(false);
            }
        });
        this.mViewModel.mRoomDataLiveData.observe(this, new Observer<StateData<ClassroomDataEntity>>() {
            public void onChanged(StateData<ClassroomDataEntity> stateData) {
                ClassroomDataEntity classroomDataEntity = (ClassroomDataEntity) stateData.getData();
                if (classroomDataEntity != null) {
                    try {
                        LiveActivity.this.mLiveController.getDataStorage().getRoomData().setIsOnStage(!"true".equals(classroomDataEntity.getKeyValPair().get(String.format("%s-allOnStageClosed", new Object[]{LiveActivity.this.getLiveRoomData().getPlanId()}))));
                        XesLog.it(LiveActivity.TAG, new Object[]{"全员上台开关请求成功，保持状态"});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                LiveActivity.this.mLiveController.onInitModuleReqSuccess(LiveActivity.this.mInitModuleEntity);
                LiveActivity.this.showActivityLoading(false);
            }
        });
        this.mViewModel.mEmojiDetailData.observe(this, new LiveActivity$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$startObserve$3$LiveActivity(StateData stateData) {
        this.mLiveController.onEmojiDetailSuccess((EmojiDetailEntity) stateData.getData());
    }

    /* access modifiers changed from: private */
    public void initIrcConfig(EnterEntity enterEntity) {
        ShareDataManager.getInstance().saveCacheGsonEntity(enterEntity.getConfigs().getIrcServer(), "irc_server", ShareDataManager.SHAREDATA_NOT_CLEAR);
        this.mLiveController = initController();
        AbilityPack.get().bind(this, this, this.mLiveController);
        this.mLiveController.setClassType(this.mLiveRoomData, true, enterEntity);
        this.mLiveController.onEnterReqSuccess(enterEntity, false);
        HWEventTracking.CourseData courseData = new HWEventTracking.CourseData();
        courseData.setTimeOffset(Long.valueOf((this.mLiveController.getDataStorage().getRoomData().getServeNowTime() * 1000) - System.currentTimeMillis()));
        HWEventTracking.get().setCourseProperty(courseData);
        reportDeviceInfo("enterroom");
    }

    /* access modifiers changed from: protected */
    public BaseLiveController initController() {
        return new LiveController(this);
    }

    /* access modifiers changed from: private */
    public void onEnterReqSuccess(String str, String str2, int i, boolean z) {
        try {
            List<String> ircRooms = this.mLiveController.getDataStorage().getEnterConfig().getIrcRooms();
            if (ircRooms != null && ircRooms.size() > 0) {
                LiveTrackData.mRoomId = ircRooms.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mViewModel.requestInitModule(str, i, 0, z);
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        getLifecycle().addObserver(lifecycleObserver);
    }

    public void showActivityLoading(boolean z) {
        if (z) {
            this.mLoadingView.showFullLoadingView();
        } else {
            this.mLoadingView.restoreView();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        String[] strArr = this.mSettingPermission;
        if (strArr != null) {
            for (String str : strArr) {
                str.hashCode();
                if (!str.equals("android.permission.CAMERA")) {
                    if (str.equals("android.permission.RECORD_AUDIO") && isGranted("android.permission.RECORD_AUDIO")) {
                        XesDataBus.with("audio_permission").postStickyData(true);
                    }
                } else if (isGranted("android.permission.CAMERA")) {
                    XesDataBus.with("camera_permission").postStickyData(true);
                }
            }
            this.mSettingPermission = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            changeMediaVolume(true);
        } else if (i == 25) {
            changeMediaVolume(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void changeMediaVolume(boolean z) {
        if (this.mAudioManager != null && this.mMaxMusicVolume > 0) {
            int mediaVolume = getMediaVolume();
            int i = 0;
            XesLog.dt(TAG, new Object[]{"changeMediaVolume current= " + mediaVolume});
            int i2 = z ? mediaVolume + 1 : mediaVolume - 1;
            int i3 = this.mMaxMusicVolume;
            if (i2 > i3) {
                i = i3;
            } else if (i2 >= 0) {
                i = i2;
            }
            setMediaVolume(i);
        }
    }

    private int getMediaVolume() {
        try {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
        } catch (Exception e) {
            String str = TAG;
            XesLog.dt(str, new Object[]{"getMediaVolume出错=" + e});
        }
        return 0;
    }

    private void setMediaVolume(int i) {
        try {
            String str = TAG;
            XesLog.dt(str, new Object[]{"setMediaVolume,设置音量为" + i});
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i, 0);
            }
        } catch (Exception e) {
            String str2 = TAG;
            XesLog.dt(str2, new Object[]{"setMediaVolume出错=" + e});
        }
    }

    private void initMediaVolume() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.mAudioManager = audioManager;
        if (audioManager != null) {
            try {
                this.mMaxMusicVolume = audioManager.getStreamMaxVolume(3);
            } catch (Exception e) {
                String str = TAG;
                XesLog.dt(str, new Object[]{"initMediaVolume,获取最大媒体音量出错=" + e});
                return;
            }
        }
        String str2 = TAG;
        XesLog.dt(str2, new Object[]{"initMediaVolume,获取最大媒体音量" + this.mMaxMusicVolume});
    }

    /* access modifiers changed from: protected */
    public void outActivity() {
        HWEventTracking.get().ostaExitClassroom(Long.valueOf(this.mLiveController.getDataStorage().getRoomData().getServeNowTime() - this.mLiveController.getDataStorage().getPlanInfo().getEndStampTime()));
        super.outActivity();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        XesLog.it(TAG, new Object[]{"结束直播课堂"});
        PluginEventBus.unregister("setting_permission", this.mSettingObserver);
        XesActivityManager.getInstance().removeFrontBackCallback(this.mFrontBackCallback);
    }

    /* access modifiers changed from: protected */
    public void onFinish() {
        super.onFinish();
        reportDeviceInfo("quitroom");
    }

    private void reportDeviceInfo(String str) {
        try {
            this.mViewModel.reportDeviceInfo(new ReportDeviceBody(this.mLiveRoomData.getPlanId(), this.mLiveController.getDataStorage().getEnterConfig().getStuIrcId(), this.mLiveController.getDataStorage().getEnterConfig().getIrcServer().getIrcLocation(), str, ""));
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = TAG;
            XesLog.et(str2, new Object[]{"上报设备信息失败:" + e.getMessage()});
        }
    }

    /* access modifiers changed from: private */
    public void sendHideChatBoxEvent() {
        XesLog.it(TAG, new Object[]{"发送隐藏功能区ChatBox事件"});
        PluginEventBus.onEvent("chat_box_function_key", new PluginEventData(LiveActivity.class, "chat_box_function_key", "13"));
    }

    /* access modifiers changed from: protected */
    public ActivityBaseLiveBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        return ActivityBaseLiveBinding.inflate(getLayoutInflater(), viewGroup, z);
    }
}
