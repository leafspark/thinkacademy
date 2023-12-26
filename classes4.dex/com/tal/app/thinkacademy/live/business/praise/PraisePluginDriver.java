package com.tal.app.thinkacademy.live.business.praise;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.praise.api.PraiseApi;
import com.tal.app.thinkacademy.live.business.praise.bean.ClassroomPraiseEntity;
import com.tal.app.thinkacademy.live.business.praise.bean.CoinEntity;
import com.tal.app.thinkacademy.live.business.praise.bean.RewardBody;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import java.util.HashMap;
import retrofit2.Call;

@PluginAnnotation(desc = "课堂表扬", ircType = {"classroom_praise"}, moduleId = "221")
@ViewLevels({@ViewLevel(level = 10, name = "classroom_praise")})
public class PraisePluginDriver extends BaseLivePluginDriver {
    private static final String SUBMIT_PRAISE = "/classroom-hub/praise/student/submit";
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.FINISH_PRAISE_BOX;
    private int classId;
    private final String keyClassroomPraise = "classroom_praise";
    protected Context mContext;
    /* access modifiers changed from: private */
    public ClassroomPraiseEntity.ClassroomPraise mPraise;
    /* access modifiers changed from: private */
    public PraisePluginView mPraiseView;
    private int planId;

    public PraisePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.planId = courseInfo.getPlanId();
        this.classId = courseInfo.getClassId();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.praise.PraisePluginView, android.view.View] */
    public void onDestroy() {
        if (this.mPraiseView != null) {
            this.mLiveRoomProvider.removeView(this.mPraiseView);
            this.mPraiseView = null;
        }
    }

    public void onMessage(String str, String str2) {
        ClassroomPraiseEntity.ClassroomPraise classroom_praise = ((ClassroomPraiseEntity) GsonUtils.fromJson(str2, ClassroomPraiseEntity.class)).getClassroom_praise();
        this.mPraise = classroom_praise;
        if (classroom_praise.getPub().booleanValue() && !TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.PRAISE_INTERACTID, "", ShareDataManager.SHAREDATA_USER), this.mPraise.getInteractId())) {
            Tag tag = this.TAG;
            XesLog.i(tag, "收到未领取的完课宝箱数据：" + str2);
            InteractLogReport.uploadLog(this.mPraise.getInteractId(), this.planId, this.classId);
            showPraiseView();
            track(LeanplumUtil.show_praise);
        }
    }

    private void showPraiseView() {
        if (this.mPraiseView == null) {
            this.mPraiseView = new PraisePluginView(this.mContext, this);
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            this.mPraiseView.refreshLayout();
            this.mLiveRoomProvider.addView(this, this.mPraiseView, this.mPluginConfData.getViewLevel("classroom_praise"), newLp);
        }
        XesLog.i(this.TAG, "展示完课宝箱");
        this.mPraiseView.showBox();
    }

    private void hidePraiseView() {
        PraisePluginView praisePluginView = this.mPraiseView;
        if (praisePluginView != null) {
            praisePluginView.removeZoom();
            this.mPraiseView.removeDisappear();
            this.mPraiseView.setVisibility(8);
        }
    }

    private void track(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.mPraise.getInteractId());
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        trackMap.put(LeanplumUtil.classId, this.mLiveRoomProvider.getDataStorage().getCourseInfo().getClassId() + "");
        trackMap.put(LeanplumUtil.lessonId, this.mLiveRoomProvider.getDataStorage().getCourseInfo().getPlanId() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void submitPraise(int i) {
        track(LeanplumUtil.click_praise);
        DriverTrack.INSTANCE.classroomInteractTreasureClick(this.mPraise.getInteractId(), i);
        Call<HiResponse<CoinEntity>> submitPraise = ((PraiseApi) Api.create(PraiseApi.class)).submitPraise(ImConfig.INSTANCE.getOverseaApi() + SUBMIT_PRAISE, new RewardBody(this.mPraise.getPlanId().intValue(), this.mPraise.getInteractId(), this.classId));
        AnonymousClass2 r0 = new OmyCallback<HiResponse<CoinEntity>>(new IError() {
            public void onFail(int i, String str) {
                ToastUtils.showShort((CharSequence) str);
                Tag access$000 = PraisePluginDriver.this.TAG;
                XesLog.e(access$000, "领取奖励接口失败，code:" + i + ",msg:" + str);
            }

            public void onError(int i, String str) {
                ToastUtils.showShort((CharSequence) str);
                Tag access$000 = PraisePluginDriver.this.TAG;
                XesLog.e(access$000, "领取奖励接口异常，code:" + i + ",msg:" + str);
            }
        }) {
            public void onSuccess(HiResponse<CoinEntity> hiResponse) {
                ShareDataManager.getInstance().put(ShareDataKey.PRAISE_INTERACTID, PraisePluginDriver.this.mPraise.getInteractId(), ShareDataManager.SHAREDATA_USER);
                CoinEntity data = hiResponse.getData();
                HWEventTracking.get().ostaIaPraise(PraisePluginDriver.this.mPraise.getInteractId(), Integer.valueOf(data.getRewardCoin()));
                Tag access$000 = PraisePluginDriver.this.TAG;
                XesLog.s(access$000, "领取奖励成功，展示获得金币视图", "获得金币：" + data.getRewardCoin());
                PraisePluginDriver.this.mPraiseView.showCoins(data);
            }
        };
        if (!(submitPraise instanceof Call)) {
            submitPraise.enqueue(r0);
        } else {
            Retrofit2Instrumentation.enqueue((Call) submitPraise, r0);
        }
    }

    public void updateUserCoins(int i, int i2) {
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.USERCOINS_KEY, i + "", new CoinEventData(GoldSource.PRAISE_GOLD, i2, true, true)));
    }
}
