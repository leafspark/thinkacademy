package com.tal.app.thinkacademy.live.core.live.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.callback.FrameworkRequestCallback;
import com.tal.app.thinkacademy.live.core.callback.LiveActivityCallback;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.IBaseLiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.ModuleConfig;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiViewEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.LivePluginManager;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseLiveController implements LifecycleObserver, IBaseLiveControllerProvider {
    private static final String TAG = "BaseLiveController";
    protected boolean isBindCourseware = true;
    protected Map<String, BaseLivePluginDriver> mActivePluginMap = new ConcurrentHashMap();
    protected List<LiveActivityCallback> mActivityCallbacks;
    protected Map<String, String> mAuditEnterModuleMap;
    protected String mClassType = "0";
    private LiveAreaCompat.CourseRate mCourseRate = LiveAreaCompat.CourseRate.RATE_4_3;
    protected DataStorage mDataStorage;
    protected List<FrameworkRequestCallback> mFrameworkRequestCallbacks;
    private boolean mGraffitiUseCourseRate = false;
    protected boolean mHasMetadataRequestSuccess = false;
    protected Map<String, String> mInitModuleMap;
    protected ILiveActivityProvider mLiveActivityProvider;
    protected LivePluginManager mLivePluginManager;
    private List<PluginConfData> mPluginConfData;
    protected Map<String, PluginConfData> mPluginConfMap;

    /* access modifiers changed from: protected */
    public abstract List<PluginConfData> initPluginConfig(Context context);

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifecycleStart(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifecycleStop(LifecycleOwner lifecycleOwner) {
    }

    public BaseLiveController(ILiveActivityProvider iLiveActivityProvider) {
        this.mLiveActivityProvider = iLiveActivityProvider;
        iLiveActivityProvider.addObserver(this);
        this.mLivePluginManager = new LivePluginManager(this);
        this.mDataStorage = new DataStorage();
        buildAuditEnterModuleMap();
    }

    public void setClassType(LiveRoomData liveRoomData, boolean z, EnterEntity enterEntity) {
        this.mClassType = liveRoomData.getSubPlatformType();
        this.isBindCourseware = liveRoomData.isBindCourseware();
        this.mPluginConfData = initPluginConfig(this.mLiveActivityProvider.getContext());
        this.mCourseRate = liveRoomData.getRate() == 2 ? LiveAreaCompat.CourseRate.RATE_16_9 : LiveAreaCompat.CourseRate.RATE_4_3;
        boolean z2 = true;
        if (liveRoomData.getFollowCoursewareRatio() != 1) {
            z2 = false;
        }
        this.mGraffitiUseCourseRate = z2;
        buildPluginDataMap(this.mPluginConfData);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("subPlatfromType", this.mClassType);
        jsonObject.addProperty(LearnMaterialsListActivityKt.PLANID, liveRoomData.getPlanId());
        jsonObject.addProperty("courseId", liveRoomData.getCourseId());
        jsonObject.addProperty("isLive", Boolean.valueOf(z));
        jsonObject.addProperty("isBindCourseware", Boolean.valueOf(this.isBindCourseware));
        if (enterEntity != null) {
            if (enterEntity.getCourseInfo() != null) {
                jsonObject.addProperty(LearnMaterialsListActivityKt.CLASSID, Integer.valueOf(enterEntity.getCourseInfo().getClassId()));
                LiveTrackData.mClassId = Integer.valueOf(enterEntity.getCourseInfo().getClassId());
            }
            if (enterEntity.getPlanInfo() != null) {
                LiveTrackData.mGradeName = enterEntity.getPlanInfo().getGradeName();
            }
            if (enterEntity.getStuInfo() != null) {
                jsonObject.addProperty("userId", enterEntity.getStuInfo().getId());
            }
        }
        XesLog.ut(TAG, jsonObject);
    }

    /* access modifiers changed from: protected */
    public void buildPluginDataMap(List<PluginConfData> list) {
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (PluginConfData next : list) {
                hashMap.put(next.getClassName(), next);
            }
            this.mPluginConfMap = hashMap;
        }
    }

    private void buildInitModuleMap(List<ModuleConfig> list) {
        if (list != null) {
            this.mInitModuleMap = new HashMap();
            for (ModuleConfig next : list) {
                this.mInitModuleMap.put(String.valueOf(next.getModuleId()), next.getProperties().toString());
            }
        }
    }

    private void buildAuditEnterModuleMap() {
        if (this.mAuditEnterModuleMap == null) {
            HashMap hashMap = new HashMap();
            this.mAuditEnterModuleMap = hashMap;
            hashMap.put("-100", "截屏");
            this.mAuditEnterModuleMap.put("-101", "直播播放");
            this.mAuditEnterModuleMap.put("-102", "聊天消息插件");
            this.mAuditEnterModuleMap.put("-103", "导航栏，媒体控制器 + 手势控制");
            this.mAuditEnterModuleMap.put("-104", "回放播放");
            this.mAuditEnterModuleMap.put("-105", "课程基础状态存储，更新");
            this.mAuditEnterModuleMap.put("-110", "nps");
            this.mAuditEnterModuleMap.put("349", "声音管理");
        }
    }

    public void addDefaultEmoji() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmojiViewEntity("[smile]", "0", "", "", Integer.valueOf(R.drawable.e_smile), 1));
        arrayList.add(new EmojiViewEntity("[XD]", DbParams.GZIP_DATA_EVENT, "", "", Integer.valueOf(R.drawable.e_xd), 1));
        arrayList.add(new EmojiViewEntity("[LOL]", "2", "", "", Integer.valueOf(R.drawable.e_lol), 1));
        arrayList.add(new EmojiViewEntity("[party]", "3", "", "", Integer.valueOf(R.drawable.e_party), 1));
        arrayList.add(new EmojiViewEntity("[the_rock]", "4", "", "", Integer.valueOf(R.drawable.e_the_rock), 1));
        arrayList.add(new EmojiViewEntity("[thinking]", "5", "", "", Integer.valueOf(R.drawable.e_thinking), 1));
        arrayList.add(new EmojiViewEntity("[quiet]", "6", "", "", Integer.valueOf(R.drawable.e_quiet), 1));
        arrayList.add(new EmojiViewEntity("[pleading]", "7", "", "", Integer.valueOf(R.drawable.e_pleading), 1));
        arrayList.add(new EmojiViewEntity("[sad]", "8", "", "", Integer.valueOf(R.drawable.e_sad), 1));
        arrayList.add(new EmojiViewEntity("[shame]", DbParams.GZIP_DATA_ENCRYPT, "", "", Integer.valueOf(R.drawable.e_shame), 1));
        arrayList.add(new EmojiViewEntity("[scream]", "10", "", "", Integer.valueOf(R.drawable.e_scream), 1));
        arrayList.add(new EmojiViewEntity("[cry]", "11", "", "", Integer.valueOf(R.drawable.e_cry), 1));
        arrayList.add(new EmojiViewEntity("[yeah]", "12", "", "", Integer.valueOf(R.drawable.e_yeah), 1));
        arrayList.add(new EmojiViewEntity("[like]", "13", "", "", Integer.valueOf(R.drawable.e_like), 1));
        arrayList.add(new EmojiViewEntity("[hands_up]", "14", "", "", Integer.valueOf(R.drawable.e_hands_up), 1));
        arrayList.add(new EmojiViewEntity("[clap]", "15", "", "", Integer.valueOf(R.drawable.e_clap), 1));
        arrayList.add(new EmojiViewEntity("[A]", "16", "", "", Integer.valueOf(R.drawable.e_a), 1));
        arrayList.add(new EmojiViewEntity("[B]", "17", "", "", Integer.valueOf(R.drawable.e_b), 1));
        arrayList.add(new EmojiViewEntity("[true]", "18", "", "", Integer.valueOf(R.drawable.e_true), 1));
        arrayList.add(new EmojiViewEntity("[false]", "19", "", "", Integer.valueOf(R.drawable.e_false), 1));
        arrayList.add(new EmojiViewEntity("[surprise]", "20", "", "", Integer.valueOf(R.drawable.e_surprise), 1));
        arrayList.add(new EmojiViewEntity("[heart]", "21", "", "", Integer.valueOf(R.drawable.e_heart), 1));
        arrayList.add(new EmojiViewEntity("[unicorn]", "22", "", "", Integer.valueOf(R.drawable.e_unicorn), 1));
        arrayList.add(new EmojiViewEntity("[ghost]", "23", "", "", Integer.valueOf(R.drawable.e_ghost), 1));
        EmojiDetailPackage emojiDetailPackage = new EmojiDetailPackage("默认", "0", "", (Boolean) null, (Boolean) null, "", (Boolean) null, arrayList, (Boolean) null, 3, true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0, emojiDetailPackage);
        this.mDataStorage.setEmojiDetailEntity(new EmojiDetailEntity(arrayList2, true, false));
    }

    public void onEmojiDetailSuccess(EmojiDetailEntity emojiDetailEntity) {
        if (emojiDetailEntity != null && emojiDetailEntity.getList() != null && emojiDetailEntity.getList().size() > 0) {
            this.mDataStorage.getEmojiDetailEntity().setUpdate(true);
            this.mDataStorage.getEmojiDetailEntity().setReportedOverdue(false);
            ArrayList<EmojiDetailPackage> list = emojiDetailEntity.getList();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<EmojiViewEntity> content = list.get(i).getContent();
                    if (content != null && content.size() > 0) {
                        for (int i2 = 0; i2 < content.size(); i2++) {
                            EmojiViewEntity emojiViewEntity = content.get(i2);
                            String lottieUrl = emojiViewEntity.getLottieUrl();
                            if (!TextUtils.isEmpty(lottieUrl)) {
                                String trim = lottieUrl.trim();
                                if (trim.endsWith(".json")) {
                                    emojiViewEntity.setType(2);
                                } else if (trim.endsWith(".png") || trim.endsWith(".jpg") || trim.endsWith(".jpeg") || trim.endsWith(".webp")) {
                                    emojiViewEntity.setType(3);
                                }
                            }
                        }
                    }
                }
                this.mDataStorage.getEmojiDetailEntity().getList().addAll(emojiDetailEntity.getList());
            }
        }
    }

    public void onEnterReqSuccess(EnterEntity enterEntity, boolean z) {
        if (enterEntity != null) {
            this.mDataStorage.setEnterResp(enterEntity, z);
            this.mDataStorage.getRoomData().setCourseRate(this.mCourseRate);
            this.mDataStorage.getRoomData().setGraffitiUseCourseRate(this.mGraffitiUseCourseRate);
            LeanplumUtil.initTrackMap(enterEntity.getCourseInfo().getClassId() + "", enterEntity.getCourseInfo().getPlanId() + "");
            loadPluginWitchEnterReqSuccess(z);
        }
    }

    public void onInitModuleReqSuccess(InitModuleEntity initModuleEntity) {
        if (initModuleEntity != null) {
            buildInitModuleMap(initModuleEntity.plugins);
            loadPluginWitchInitModuleReqSuccess();
        }
    }

    /* access modifiers changed from: protected */
    public void loadPluginWitchEnterReqSuccess(boolean z) {
        this.mLivePluginManager.loadEnterReqSuccessPlugin(z);
    }

    /* access modifiers changed from: protected */
    public void loadPluginWitchInitModuleReqSuccess() {
        this.mLivePluginManager.loadInitModuleReqSuccessPlugin();
    }

    public void addView(BaseLivePluginDriver baseLivePluginDriver, BaseLivePluginView baseLivePluginView, String str, ViewGroup.LayoutParams layoutParams) {
        List<PluginConfData.ViewLevelBean> viewLevel;
        String name = baseLivePluginDriver.getClass().getName();
        Map<String, PluginConfData> map = this.mPluginConfMap;
        if (map != null && map.get(name) != null && (viewLevel = this.mPluginConfMap.get(name).getViewLevel()) != null) {
            for (PluginConfData.ViewLevelBean next : viewLevel) {
                if (TextUtils.equals(str, next.getKey())) {
                    this.mLiveActivityProvider.addView(baseLivePluginView, next.getValue(), layoutParams);
                }
            }
        }
    }

    public void removeView(View view) {
        this.mLiveActivityProvider.removeView(view);
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        this.mLiveActivityProvider.addObserver(lifecycleObserver);
    }

    public Lifecycle getLifecycleOwner() {
        return this.mLiveActivityProvider.getLifecycleOwner();
    }

    public DataStorage getDataStorage() {
        return this.mDataStorage;
    }

    public WeakReference<Context> getWeakRefContext() {
        return new WeakReference<>(this.mLiveActivityProvider.getContext());
    }

    public void destroyPlugin(BaseLivePluginDriver baseLivePluginDriver) {
        this.mLivePluginManager.destroyPlugin(baseLivePluginDriver);
    }

    public BaseLivePluginDriver loadPlugin(String str) {
        return this.mLivePluginManager.loadPlugin(str);
    }

    public Map<String, BaseLivePluginDriver> getActivePluginMap() {
        return this.mActivePluginMap;
    }

    public Map<String, String> getInitModuleMap() {
        return this.mInitModuleMap;
    }

    public Map<String, PluginConfData> getPluginConfDataMap() {
        return this.mPluginConfMap;
    }

    public Map<String, String> getAuditEnterModuleMap() {
        return this.mAuditEnterModuleMap;
    }

    public String getClassType() {
        return this.mClassType;
    }

    public boolean isSmallClass() {
        return DbParams.GZIP_DATA_EVENT.equals(this.mClassType) || "2".equals(this.mClassType);
    }

    public boolean isBindCourseware() {
        return this.isBindCourseware;
    }

    public void backLiveRoom(ExitLiveRoom exitLiveRoom) {
        if (exitLiveRoom == ExitLiveRoom.NORMAL_EXIT) {
            this.mLiveActivityProvider.finishActivity();
        } else {
            this.mLiveActivityProvider.otherReasonActivity(exitLiveRoom);
        }
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onLifecycleCreate(LifecycleOwner lifecycleOwner) {
        XesLog.dt(TAG, new Object[]{"onLifecycleCreate"});
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        List<LiveActivityCallback> list = this.mActivityCallbacks;
        boolean z = false;
        if (list != null) {
            for (LiveActivityCallback onActivityDispatchKeyEvent : list) {
                if (onActivityDispatchKeyEvent.onActivityDispatchKeyEvent(keyEvent)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        List<LiveActivityCallback> list = this.mActivityCallbacks;
        boolean z = false;
        if (list != null) {
            for (LiveActivityCallback onActivityDispatchTouchEvent : list) {
                if (onActivityDispatchTouchEvent.onActivityDispatchTouchEvent(motionEvent)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void addActivityCallback(LiveActivityCallback liveActivityCallback) {
        if (this.mActivityCallbacks == null) {
            this.mActivityCallbacks = new ArrayList();
        }
        this.mActivityCallbacks.add(liveActivityCallback);
    }

    public void showActivityLoading(boolean z) {
        ILiveActivityProvider iLiveActivityProvider = this.mLiveActivityProvider;
        if (iLiveActivityProvider != null) {
            iLiveActivityProvider.showActivityLoading(z);
        }
    }

    public void addFrameworkRequestCallBack(FrameworkRequestCallback frameworkRequestCallback) {
        if (this.mFrameworkRequestCallbacks == null) {
            this.mFrameworkRequestCallbacks = new ArrayList();
        }
        this.mFrameworkRequestCallbacks.add(frameworkRequestCallback);
        if (this.mHasMetadataRequestSuccess) {
            frameworkRequestCallback.onMetaDataRequestSuccess();
        }
    }

    public void onMetadataRequestSuccess() {
        this.mHasMetadataRequestSuccess = true;
        List<FrameworkRequestCallback> list = this.mFrameworkRequestCallbacks;
        if (list != null) {
            for (FrameworkRequestCallback onMetaDataRequestSuccess : list) {
                onMetaDataRequestSuccess.onMetaDataRequestSuccess();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        Map<String, PluginConfData> map = this.mPluginConfMap;
        if (map != null) {
            map.clear();
            this.mPluginConfMap = null;
        }
        Map<String, String> map2 = this.mInitModuleMap;
        if (map2 != null) {
            map2.clear();
            this.mInitModuleMap = null;
        }
        List<LiveActivityCallback> list = this.mActivityCallbacks;
        if (list != null) {
            list.clear();
            this.mActivityCallbacks = null;
        }
        List<FrameworkRequestCallback> list2 = this.mFrameworkRequestCallbacks;
        if (list2 != null) {
            list2.clear();
            this.mFrameworkRequestCallbacks = null;
        }
        List<PluginConfData> list3 = this.mPluginConfData;
        if (list3 != null) {
            list3.clear();
            this.mPluginConfData = null;
        }
        DataStorage dataStorage = this.mDataStorage;
        if (dataStorage != null) {
            dataStorage.clean();
        }
        Map<String, BaseLivePluginDriver> map3 = this.mActivePluginMap;
        if (map3 != null) {
            map3.clear();
            this.mActivePluginMap = null;
        }
    }
}
