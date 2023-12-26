package com.tal.app.thinkacademy.live.core.backplay;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.dialog.CommonDialog;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.backplay.controller.LivePlayBackController;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.databinding.ActivityBasePlaybackBinding;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.impl.PlaybackAreaStrategy;
import com.tal.app.thinkacademy.live.core.live.BaseLiveActivity;
import com.tal.app.thinkacademy.live.core.live.LiveViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class PlayBackActivity extends BaseLiveActivity<LiveViewModel, ActivityBasePlaybackBinding> implements ILiveActivityProvider {
    /* access modifiers changed from: private */
    public EnterEntity mEnterEntity;
    private CommonDialog mErrorDialog;
    /* access modifiers changed from: private */
    public LivePlayBackController mLivePlayBackController;
    /* access modifiers changed from: private */
    public LoadStatusView mLoadingView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PlayBackActivity.super.onCreate(bundle);
        ShareDataManager.getInstance().put(ShareDataKey.PLAYBACK_START_TIME, System.currentTimeMillis(), ShareDataManager.SHAREDATA_USER);
        LeanplumUtil.commonTrack("start_playback", LeanplumUtil.trackMap());
    }

    /* access modifiers changed from: protected */
    public int getInflateView() {
        return R.layout.activity_base_playback;
    }

    /* access modifiers changed from: protected */
    public int getPluginContainerId() {
        return R.id.playback_root_view;
    }

    /* access modifiers changed from: protected */
    public void preInit() {
        PlayBackActivity.super.preInit();
        LiveTrackData.mInLive = true;
        long currentTimeMillis = System.currentTimeMillis();
        LiveTrackData.mEnterTime = currentTimeMillis;
        LiveTrackData.mPlanMode = "回放";
        LiveTrackData.mIrcState = "未加入";
        LiveTrackData.mLocalServerState = "未启动";
        LiveTrackData.newTraceId(currentTimeMillis);
        LiveTrackData.newCourseTraceId(currentTimeMillis);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        LoadStatusView findViewById = findViewById(R.id.playback_loading_view);
        this.mLoadingView = findViewById;
        findViewById.showFullLoadingView();
    }

    /* access modifiers changed from: protected */
    public BaseLiveController initController() {
        this.mLivePlayBackController = new LivePlayBackController(this);
        AbilityPack.get().bind(this, this, this.mLivePlayBackController);
        this.mLivePlayBackController.setClassType(this.mLiveRoomData, false, this.mEnterEntity);
        this.mLivePlayBackController.onPlaybackUrlSuccess(this.mLiveRoomData.getPlaybackUrl());
        this.mLiveController = this.mLivePlayBackController;
        return this.mLivePlayBackController;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        PlayBackActivity.super.initData();
        LiveRoomData liveRoomData = getLiveRoomData();
        LiveTrackData.mLiveRoomData = liveRoomData;
        if (liveRoomData != null) {
            LiveTrack.INSTANCE.enterClassRoom();
            this.mViewModel.requestPlaybackEnter(LiveUrls.PLAY_BACK_ENTER, liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId(), liveRoomData.getUpdateUserInfo(), false);
        }
    }

    /* access modifiers changed from: protected */
    public void initPoint() {
        LiveAreaContext.get().setupStrategy(new PlaybackAreaStrategy(this));
    }

    public void startObserve() {
        PlayBackActivity.super.startObserve();
        this.mViewModel.mEnterLiveData.observe(this, new Observer<StateData<EnterEntity>>() {
            public void onChanged(StateData<EnterEntity> stateData) {
                if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
                    if (stateData.getData() != null) {
                        EnterEntity unused = PlayBackActivity.this.mEnterEntity = stateData.getData();
                        LiveRoomData access$100 = PlayBackActivity.this.getLiveRoomData();
                        if (access$100 != null) {
                            access$100.setCourseId(String.valueOf(PlayBackActivity.this.mEnterEntity.courseInfo.getCourseId()));
                            PlayBackActivity.this.initController();
                            PlayBackActivity.this.onEnterReqSuccess(access$100.getPlanId(), access$100.getCourseId(), access$100.getBizId());
                        }
                    }
                } else if (stateData.getStatus() == StateData.DataStatus.ERROR || stateData.getStatus() == StateData.DataStatus.FAILURE) {
                    PlayBackActivity.this.mLoadingView.showErrorView(new Function0<Unit>() {
                        public Unit invoke() {
                            PlayBackActivity.this.mLoadingView.showFullLoadingView();
                            LiveRoomData access$400 = PlayBackActivity.this.getLiveRoomData();
                            if (access$400 == null) {
                                return null;
                            }
                            PlayBackActivity.this.mViewModel.requestPlaybackEnter(LiveUrls.PLAY_BACK_ENTER, access$400.getPlanId(), access$400.getCourseId(), access$400.getBizId(), access$400.getUpdateUserInfo(), false);
                            return null;
                        }
                    });
                }
            }
        });
        this.mViewModel.mInitModuleLiveData.observe(this, new Observer<StateData<InitModuleEntity>>() {
            public void onChanged(StateData<InitModuleEntity> stateData) {
                InitModuleEntity data = stateData.getData();
                if (data != null) {
                    PlayBackActivity.this.mLivePlayBackController.onInitModuleReqSuccess(data);
                }
            }
        });
        this.mViewModel.mMetaData.observe(this, new PlayBackActivity$$ExternalSyntheticLambda0(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.tal.app.thinkacademy.live.core.backplay.PlayBackActivity] */
    public /* synthetic */ void lambda$startObserve$0$PlayBackActivity(StateData stateData) {
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
            MetaDataEntity metaDataEntity = (MetaDataEntity) stateData.getData();
            if (metaDataEntity == null || metaDataEntity.event == null || metaDataEntity.event.size() <= 0) {
                XesLog.et("回放-课中", "收到mateInfo打点数据,但为空");
                return;
            }
            XesLog.it("回放-课中", "收到mateInfo打点数据, 共" + metaDataEntity.event.size() + "条");
            metaDataEntity.setEvent(getMViewModel().calculationMetadataTime(metaDataEntity));
            this.mLivePlayBackController.onMetaDataSuccess(metaDataEntity);
            return;
        }
        if (this.mErrorDialog == null) {
            final LiveRoomData liveRoomData = getLiveRoomData();
            if (liveRoomData != null) {
                CommonDialog commonDialog = new CommonDialog(this);
                this.mErrorDialog = commonDialog;
                commonDialog.setButtons(true, true).setConfirmClick(R.string.dialog_refresh, new Function0<Unit>() {
                    public Unit invoke() {
                        PlayBackActivity.this.requestMetaData(liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId());
                        return null;
                    }
                }).setCancelClick(R.string.dialog_exit, new Function0<Unit>() {
                    public Unit invoke() {
                        PlayBackActivity.this.finish();
                        return null;
                    }
                }).setTitleText(R.string.dialog_metadata_error_title).setMsgText(R.string.dialog_metadata_error_msg);
                this.mErrorDialog.setCancelable(false);
            } else {
                return;
            }
        }
        CommonDialog commonDialog2 = this.mErrorDialog;
        if (commonDialog2 != null) {
            commonDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    public void onEnterReqSuccess(String str, String str2, int i) {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity != null) {
            this.mLivePlayBackController.onEnterReqSuccess(enterEntity, true);
            HWEventTracking.CourseData courseData = new HWEventTracking.CourseData();
            courseData.setTimeOffset(Long.valueOf((this.mLivePlayBackController.getDataStorage().getRoomData().getServeNowTime() * 1000) - System.currentTimeMillis()));
            HWEventTracking.get().setCourseProperty(courseData);
        }
        this.mViewModel.requestInitModule(str, i, 1, false);
        requestMetaData(str, str2, i);
    }

    /* access modifiers changed from: private */
    public void requestMetaData(String str, String str2, int i) {
        String str3 = ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/playback/metainfo";
        if (!TextUtils.isEmpty(str3)) {
            int i2 = 1;
            if (this.mLivePlayBackController.getDataStorage().getLiveStatus() != null) {
                i2 = this.mLivePlayBackController.getDataStorage().getLiveStatus().getStreamMode();
            }
            this.mViewModel.requestMetaData(str3, str, ParseUtils.tryParseInt(str2, 0), i2, i);
        }
    }

    public void showActivityLoading(boolean z) {
        if (z) {
            this.mLoadingView.showFullLoadingView();
        } else {
            this.mLoadingView.restoreView();
        }
    }

    /* access modifiers changed from: protected */
    public ActivityBasePlaybackBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        return ActivityBasePlaybackBinding.inflate(getLayoutInflater(), viewGroup, z);
    }
}
