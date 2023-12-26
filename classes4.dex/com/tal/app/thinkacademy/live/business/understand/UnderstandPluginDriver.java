package com.tal.app.thinkacademy.live.business.understand;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.Gson;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.vote.VotePluginDriver;
import com.tal.app.thinkacademy.live.business.vote.api.VoteApi;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteArray;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteBean;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteGetInfo;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

public class UnderstandPluginDriver extends VotePluginDriver {
    private Context mContext;
    /* access modifiers changed from: private */
    public UnderstandView understandView;
    private VoteArray voteEntity;
    private VoteGetInfo voteGetInfo;

    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    public UnderstandPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
    }

    public void setVoteArray(VoteArray voteArray) {
        this.voteEntity = voteArray;
    }

    public void setVoteGetInfo(VoteGetInfo voteGetInfo2) {
        this.voteGetInfo = voteGetInfo2;
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [com.tal.app.thinkacademy.live.business.understand.UnderstandView, android.view.View] */
    public void addView(BaseLivePluginDriver baseLivePluginDriver) {
        UnderstandView understandView2 = new UnderstandView(this.mContext);
        this.understandView = understandView2;
        understandView2.setVoteArray(this.voteEntity);
        this.understandView.setDriver(this);
        if (LiveAreaCompat.isSmallPad()) {
            final LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
            int dp2px = SizeUtils.dp2px(154.0f);
            FrameLayout.LayoutParams newLp = LiveAreaCompat.pptCenterLp().newLp();
            newLp.height = dp2px;
            newLp.topMargin = (pptLp.top + pptLp.height) - dp2px;
            ViewScaleUtil.scaleKeepWidth(this.understandView, newLp, 0.8f, newLp.leftMargin, newLp.topMargin + newLp.height);
            this.mLiveRoomProvider.addView(baseLivePluginDriver, this.understandView, "VoteView", newLp);
            LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
                /* JADX WARNING: type inference failed for: r0v4, types: [com.tal.app.thinkacademy.live.business.understand.UnderstandView, android.view.View] */
                public void onChanged(LiveAreaContext liveAreaContext) {
                    FrameLayout.LayoutParams layoutParams;
                    if (UnderstandPluginDriver.this.understandView != null && (layoutParams = (FrameLayout.LayoutParams) UnderstandPluginDriver.this.understandView.getLayoutParams()) != null) {
                        LiveAreaCompat.pptCenterLp().mergeLp(layoutParams);
                        int dp2px = SizeUtils.dp2px(154.0f);
                        layoutParams.height = dp2px;
                        layoutParams.topMargin = (pptLp.top + pptLp.height) - dp2px;
                        ViewScaleUtil.scaleKeepWidth(UnderstandPluginDriver.this.understandView, layoutParams, 0.8f, layoutParams.leftMargin, layoutParams.topMargin + layoutParams.height);
                        UnderstandPluginDriver.this.understandView.setLayoutParams(layoutParams);
                    }
                }
            });
            return;
        }
        LiveAreaLayoutParams pptLp2 = LiveAreaContext.get().getPptLp();
        if (PadUtils.isPad(this.mContext)) {
            final int dp2px2 = (pptLp2.width - SizeUtils.dp2px(500.0f)) / 2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(SizeUtils.dp2px(500.0f), SizeUtils.dp2px(154.0f));
            layoutParams.gravity = 80;
            layoutParams.setMarginStart(pptLp2.left + dp2px2);
            layoutParams.setMarginEnd(dp2px2);
            layoutParams.setMargins(0, 0, 0, SizeUtils.dp2px(84.0f));
            this.mLiveRoomProvider.addView(baseLivePluginDriver, this.understandView, "VoteView", layoutParams);
            LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
                public void onChanged(LiveAreaContext liveAreaContext) {
                    FrameLayout.LayoutParams layoutParams;
                    if (UnderstandPluginDriver.this.understandView != null && (layoutParams = (FrameLayout.LayoutParams) UnderstandPluginDriver.this.understandView.getLayoutParams()) != null) {
                        layoutParams.gravity = 80;
                        layoutParams.setMarginStart(liveAreaContext.getPptLp().left);
                        int i = dp2px2;
                        layoutParams.setMargins(i, 0, i, SizeUtils.dp2px(84.0f));
                        UnderstandPluginDriver.this.understandView.setLayoutParams(layoutParams);
                    }
                }
            });
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(pptLp2.width, SizeUtils.dp2px(154.0f));
        layoutParams2.gravity = 80;
        layoutParams2.setMarginStart(pptLp2.left);
        this.mLiveRoomProvider.addView(baseLivePluginDriver, this.understandView, "VoteView", layoutParams2);
        LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
            public void onChanged(LiveAreaContext liveAreaContext) {
                FrameLayout.LayoutParams layoutParams;
                if (UnderstandPluginDriver.this.understandView != null && (layoutParams = (FrameLayout.LayoutParams) UnderstandPluginDriver.this.understandView.getLayoutParams()) != null) {
                    LiveAreaLayoutParams pptLp = liveAreaContext.getPptLp();
                    layoutParams.width = pptLp.width;
                    layoutParams.height = SizeUtils.dp2px(154.0f);
                    layoutParams.setMarginStart(pptLp.left);
                    UnderstandPluginDriver.this.understandView.setLayoutParams(layoutParams);
                }
            }
        });
    }

    public void submitCommit(final String str) {
        String interactId = this.voteEntity.getInteractId();
        HWEventTracking.get().ostaIaVoteSubmit(interactId, "understand", str, (Boolean) null);
        String str2 = ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/vote/student/commit";
        HashMap hashMap = new HashMap();
        hashMap.put("planId", Integer.valueOf(this.voteGetInfo.getId()));
        hashMap.put("interactionId", interactId);
        hashMap.put("classId", Integer.valueOf(this.voteGetInfo.getClassId()));
        hashMap.put("option", str);
        MediaType parse = MediaType.parse("application/json;charset=UTF-8");
        Gson gson = new Gson();
        Call<HiResponse<VoteBean>> submitVote = ((VoteApi) Api.create(VoteApi.class)).submitVote(str2, RequestBody.create(parse, !(gson instanceof Gson) ? gson.toJson(hashMap) : GsonInstrumentation.toJson(gson, hashMap)));
        AnonymousClass5 r1 = new OmyCallback<HiResponse<VoteBean>>(new IError() {
            public void onFail(int i, String str) {
            }

            public void onError(int i, String str) {
                UnderstandPluginDriver.this.track_failed_submit("click_no", str);
            }
        }) {
            public void onSuccess(HiResponse<VoteBean> hiResponse) {
                UnderstandPluginDriver.this.track_success_submit("click_no", str);
            }
        };
        if (!(submitVote instanceof Call)) {
            submitVote.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) submitVote, r1);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.understand.UnderstandView, android.view.View] */
    public void removeView() {
        UnderstandView understandView2 = this.understandView;
        if (understandView2 != null) {
            understandView2.removeView();
            this.mLiveRoomProvider.removeView(this.understandView);
            this.understandView = null;
        }
    }

    public void track_click_yes(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.voteEntity.getInteractId());
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void track_click_no(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.voteEntity.getInteractId());
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void track_success_submit(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.voteEntity.getInteractId());
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        trackMap.put("options", str2);
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void track_failed_submit(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.voteEntity.getInteractId());
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        trackMap.put("options", str2);
        LeanplumUtil.commonTrack(str, trackMap);
    }
}
