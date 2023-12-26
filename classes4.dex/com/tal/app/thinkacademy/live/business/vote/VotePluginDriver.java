package com.tal.app.thinkacademy.live.business.vote;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.understand.UnderstandPluginDriver;
import com.tal.app.thinkacademy.live.business.vote.api.VoteApi;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteArray;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteGetInfo;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteInitMode;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteStatusBean;
import com.tal.app.thinkacademy.live.business.vote.entity.body.InteractVoteStatusBody;
import com.tal.app.thinkacademy.live.business.vote.view.VotePluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

@PluginAnnotation(desc = "投票", ircType = {"vote", "vote_f", "vote_praise", "vote_praise_f", "vote_data", "vote_data_f", "mode"}, moduleId = "5", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "VoteView")})
public class VotePluginDriver extends BaseLivePluginDriver implements VotePluginBack {
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.VOTE;
    private Bundle bundle;
    private String currentMode = "";
    private Handler handler;
    private boolean isLightVote = false;
    private JsonObject jsonObject = null;
    private WeakReference<Context> mContext;
    /* access modifiers changed from: private */
    public CourseInfoProxy mCourseInfoProxy;
    private EnterConfigProxy mEnterConfigProxy;
    /* access modifiers changed from: private */
    public String mInteractId;
    /* access modifiers changed from: private */
    public PlanInfoProxy mPlanInfoProxy;
    private RoomData mRoomData;
    private UserInfoProxy mUserInfoProxy;
    private VoteGetInfo mVoteInfo = new VoteGetInfo();
    /* access modifiers changed from: private */
    public VotePluginView mVotePluginView;
    private boolean pub;
    private Runnable runnable;
    private UnderstandPluginDriver understandDriver;

    public void onDestroy() {
    }

    public VotePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle2) {
        super(iLiveRoomProvider, bundle2);
        this.bundle = bundle2;
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.mPlanInfoProxy = iLiveRoomProvider.getDataStorage().getPlanInfo();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mEnterConfigProxy = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.mContext = iLiveRoomProvider.getWeakRefContext();
        this.mRoomData = iLiveRoomProvider.getDataStorage().getRoomData();
        initData();
    }

    private void initData() {
        this.mVoteInfo.setUrl(((VoteInitMode) GsonUtils.fromJson(this.mInitModuleJsonStr, VoteInitMode.class)).getCommitVote());
        this.mVoteInfo.setId(Integer.parseInt(this.mPlanInfoProxy.getId()));
        this.mVoteInfo.setClassId(this.mCourseInfoProxy.getClassId());
        this.mVoteInfo.setBizId(this.mCourseInfoProxy.getBizId());
        this.mVoteInfo.setIrcNick(this.mUserInfoProxy.getNickName());
        this.mVoteInfo.setStuIRCId(this.mEnterConfigProxy.getStuIrcId());
        this.currentMode = this.mRoomData.getMode();
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void onMessage(String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -810660783:
                if (str.equals(VoteNoticeCode.LIVE_BUSINESS_VOTE_F)) {
                    c = 0;
                    break;
                }
                break;
            case 3357091:
                if (str.equals("mode")) {
                    c = 1;
                    break;
                }
                break;
            case 3625706:
                if (str.equals(VoteNoticeCode.LIVE_BUSINESS_VOTE)) {
                    c = 2;
                    break;
                }
                break;
            case 163391494:
                if (str.equals(VoteNoticeCode.LIVE_BUSINESS_VOTE_light_info_F)) {
                    c = 3;
                    break;
                }
                break;
            case 205756383:
                if (str.equals(VoteNoticeCode.LIVE_BUSINESS_VOTE_light_info)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (isInTraningMode()) {
                    showVote(str, str2);
                    this.jsonObject.addProperty("irtTypeKey", str);
                    this.jsonObject.addProperty("投票互动", str2);
                    XesLog.ut(TAG.get(), this.jsonObject);
                    return;
                }
                return;
            case 1:
                if (isModeChange()) {
                    XesLog.i(TAG, str2);
                    this.mInteractId = null;
                    closeVote();
                    return;
                }
                return;
            case 2:
                if (!isInTraningMode()) {
                    showVote(str, str2);
                    JsonObject jsonObject2 = new JsonObject();
                    this.jsonObject = jsonObject2;
                    jsonObject2.addProperty("irtTypeKey", str);
                    this.jsonObject.addProperty("投票互动", str2);
                    XesLog.ut(TAG.get(), this.jsonObject);
                    return;
                }
                return;
            case 3:
                if (isInTraningMode()) {
                    XesLog.i(TAG, str2);
                    updateNoAnswerNum(str, str2);
                    return;
                }
                return;
            case 4:
                if (!isInTraningMode()) {
                    XesLog.i(TAG, str2);
                    updateNoAnswerNum(str, str2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void closeVote() {
        if (this.mVotePluginView != null) {
            LiveMainHandler.post(new Runnable() {
                public void run() {
                    if (VotePluginDriver.this.mVotePluginView != null) {
                        XesLog.i(VotePluginDriver.TAG, "投票关闭 closeVote() ");
                        VotePluginDriver.this.mVotePluginView.onDestroy();
                    }
                }
            });
        }
    }

    private void updateNoAnswerNum(String str, String str2) {
        if (this.isLightVote && this.mVotePluginView != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                if (optJSONObject != null && this.pub) {
                    this.mVotePluginView.updateVotePeopleNum(optJSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showVote(String str, String str2) {
        try {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "投票信令>>>irckey：" + str + "，message：" + str2);
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
            if (optJSONObject != null) {
                Gson gson = new Gson();
                String jSONObject = !(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject);
                Class<VoteArray> cls = VoteArray.class;
                VoteArray voteArray = (VoteArray) (!(gson instanceof Gson) ? gson.fromJson(jSONObject, cls) : GsonInstrumentation.fromJson(gson, jSONObject, cls));
                if (voteArray != null) {
                    this.pub = voteArray.isPub();
                    this.mInteractId = voteArray.getInteractId();
                    requestVoteStatus(voteArray, ParseUtils.tryParseInt(this.mPlanInfoProxy.getId(), 0), voteArray.getInteractId());
                    LiveStabilityUtils.live_stability_track("Vote", this.mInteractId, "start", 1, "");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void requestVoteStatus(final VoteArray voteArray, int i, String str) {
        Call<HiResponse<VoteStatusBean>> interactVoteStatus = ((VoteApi) Api.create(VoteApi.class)).interactVoteStatus(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/vote/student/status", new InteractVoteStatusBody(i, str));
        AnonymousClass3 r6 = new OmyCallback<HiResponse<VoteStatusBean>>(new IError() {
            public void onFail(int i, String str) {
                VotePluginDriver.this.recycleSelf();
                LiveStabilityUtils.live_stability_track("Vote", VotePluginDriver.this.mInteractId, "submit", 0, str);
            }

            public void onError(int i, String str) {
                VotePluginDriver.this.recycleSelf();
                LiveStabilityUtils.live_stability_track("Vote", VotePluginDriver.this.mInteractId, "submit", 0, str);
            }
        }) {
            public void onSuccess(HiResponse<VoteStatusBean> hiResponse) {
                VoteStatusBean data = hiResponse.getData();
                if (data != null) {
                    XesLogTag access$100 = VotePluginDriver.TAG;
                    XesLog.i(access$100, "投票状态请求 requestVoteStatus() onSuccess" + data.toString());
                    if (!data.voteState && !data.interactState) {
                        VotePluginDriver.this.showChoice(voteArray);
                        InteractLogReport.uploadLog(voteArray.getInteractId(), ParseUtils.tryParseInt(VotePluginDriver.this.mPlanInfoProxy.getId(), 0), VotePluginDriver.this.mCourseInfoProxy.getClassId());
                    } else if (!data.voteState) {
                        VotePluginDriver.this.noAnswerCommit();
                        VotePluginDriver.this.closeChoice();
                        VotePluginDriver.this.recycleSelf();
                    } else {
                        VotePluginDriver.this.closeChoice();
                        VotePluginDriver.this.recycleSelf();
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("interactId", VotePluginDriver.this.mInteractId);
                    jsonObject.addProperty("voteState", Boolean.valueOf(data.voteState));
                    jsonObject.addProperty("interactState", Boolean.valueOf(data.interactState));
                    XesLog.ut(VotePluginDriver.TAG.get(), jsonObject);
                }
            }
        };
        if (!(interactVoteStatus instanceof Call)) {
            interactVoteStatus.enqueue(r6);
        } else {
            Retrofit2Instrumentation.enqueue((Call) interactVoteStatus, r6);
        }
    }

    public void noAnswerCommit() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("planId", Integer.valueOf(this.mVoteInfo.getId()));
        hashMap.put("interactionId", this.mInteractId);
        MediaType parse = MediaType.parse("application/json;charset=UTF-8");
        Gson gson = new Gson();
        RequestBody create = RequestBody.create(parse, !(gson instanceof Gson) ? gson.toJson(hashMap) : GsonInstrumentation.toJson(gson, hashMap));
        Call<HiResponse<Object>> noAnswerCommit = ((VoteApi) Api.create(VoteApi.class)).noAnswerCommit(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/vote/student/noAnswerCommit", create);
        AnonymousClass5 r1 = new OmyCallback<HiResponse<Object>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<Object> hiResponse) {
            }
        };
        if (!(noAnswerCommit instanceof Call)) {
            noAnswerCommit.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) noAnswerCommit, r1);
        }
    }

    /* access modifiers changed from: private */
    public void closeChoice() {
        this.pub = false;
        VotePluginView votePluginView = this.mVotePluginView;
        if (votePluginView != null) {
            votePluginView.submitVote(true);
        }
    }

    private boolean isModeChange() {
        if (StringUtils.isEmpty(this.currentMode)) {
            this.currentMode = this.mRoomData.getMode();
            return false;
        } else if (this.mRoomData.getMode().equals(this.currentMode)) {
            return false;
        } else {
            this.currentMode = this.mRoomData.getMode();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isInTraningMode() {
        return "in-training".equals(this.mRoomData.getMode());
    }

    /* access modifiers changed from: private */
    public void recycleSelf() {
        UnderstandPluginDriver understandPluginDriver = this.understandDriver;
        if (understandPluginDriver != null) {
            understandPluginDriver.removeView();
            this.understandDriver.onDestroy();
        }
    }

    /* access modifiers changed from: private */
    public void showChoice(VoteArray voteArray) {
        track_click_Vote(LeanplumUtil.show_vote, this.mInteractId);
        if (voteArray.isHascorrect()) {
            this.isLightVote = false;
        } else {
            this.isLightVote = true;
        }
        VotePluginView votePluginView = this.mVotePluginView;
        if (votePluginView != null) {
            votePluginView.clearData();
            this.mVotePluginView.onDestroy();
            this.mVotePluginView = null;
        }
        VotePluginView votePluginView2 = new VotePluginView((Context) this.mContext.get());
        this.mVotePluginView = votePluginView2;
        votePluginView2.setLight(this.isLightVote);
        this.mVotePluginView.setVotePluginBack(this);
        this.mVotePluginView.setData(this.mVoteInfo);
        this.mVotePluginView.showChoices(voteArray);
        track_click_Vote(LeanplumUtil.start_vote, voteArray.getInteractId());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("显示投票", voteArray.toString());
        XesLog.ut(TAG.get(), jsonObject2);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.tal.app.thinkacademy.live.business.vote.view.VotePluginView, android.view.View] */
    public void closeChoicesListener(boolean z) {
        if (this.mVotePluginView != null) {
            this.mLiveRoomProvider.removeView(this.mVotePluginView);
            this.mVotePluginView = null;
            LiveStabilityUtils.live_stability_track("Vote", this.mInteractId, "end", 1, "");
        }
    }

    public void openChoicesListener(boolean z) {
        this.mLiveRoomProvider.addView(this, this.mVotePluginView, "VoteView", LiveAreaContext.get().getPptLp().newLp());
        LiveAreaContext.get().layoutObserver.observe(this, new VotePluginDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$openChoicesListener$0$VotePluginDriver(LiveAreaContext liveAreaContext) {
        VotePluginView votePluginView = this.mVotePluginView;
        if (votePluginView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) votePluginView.getLayoutParams();
            LiveAreaCompat.pptCenterLp().mergeLp(layoutParams);
            this.mVotePluginView.setLayoutParams(layoutParams);
        }
    }

    public void updateCoinsListener(int i, int i2) {
        try {
            this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(VotePluginDriver.class, DataBusKey.USERCOINS_KEY, i + "", new CoinEventData(GoldSource.VOTE_GOLD, i2, true, true)));
    }

    public void track_click_Vote(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void track_show_yesorno(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }
}
