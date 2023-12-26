package com.tal.app.thinkacademy.live.business.topic.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.topic.IActionListenter;
import com.tal.app.thinkacademy.live.business.topic.api.TopicApi;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.business.topic.bean.request.InteractStatusRequest;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;

public abstract class BaseTopicPluginDriver extends BaseLivePluginDriver implements IActionListenter {
    protected String QUESTION_TYPE;
    protected String QUESTION_TYPE_TRACK;
    protected int classId;
    protected int courseId;
    private final Handler handler = new Handler(Looper.getMainLooper());
    protected String interactId;
    protected boolean isSubmitting;
    protected Context mContext;
    protected CourseInfoProxy mCourseInfo;
    private final Map<String, Boolean> mOverMap = new HashMap();
    protected TeacherInfo mTeacherInfo;
    protected int planId;
    protected String questionId;
    protected String questionTypeId;
    private int realCountDownTime;
    protected String schoolCode;
    protected String teacherId;
    protected TopicPluginView topicPluginView;
    protected int tutorId;
    protected UserInfoProxy userInfoProxy;

    /* access modifiers changed from: protected */
    public abstract IActionListenter initIActionListener();

    public void onDestroy() {
    }

    public BaseTopicPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mTeacherInfo = iLiveRoomProvider.getDataStorage().getTeacherInfo();
        this.mCourseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.userInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.teacherId = this.mTeacherInfo.getId();
        this.tutorId = this.mCourseInfo.getTutorId();
        this.planId = this.mCourseInfo.getPlanId();
        this.classId = this.mCourseInfo.getClassId();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            com.tal.app.thinkacademy.live.Tag r0 = com.tal.app.thinkacademy.live.Tag.TOPIC
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onMessage "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            java.lang.String r0 = "interact"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x010e
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0080 }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0080 }
            org.json.JSONObject r2 = r2.optJSONObject(r8)     // Catch:{ Exception -> 0x0080 }
            if (r2 == 0) goto L_0x0084
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0080 }
            r3.<init>()     // Catch:{ Exception -> 0x0080 }
            boolean r5 = r2 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0080 }
            if (r5 != 0) goto L_0x003e
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0044
        L_0x003e:
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ Exception -> 0x0080 }
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r2)     // Catch:{ Exception -> 0x0080 }
        L_0x0044:
            java.lang.Class<com.tal.app.thinkacademy.live.business.topic.bean.InteractBean> r5 = com.tal.app.thinkacademy.live.business.topic.bean.InteractBean.class
            boolean r6 = r3 instanceof com.google.gson.Gson     // Catch:{ Exception -> 0x0080 }
            if (r6 != 0) goto L_0x004f
            java.lang.Object r2 = r3.fromJson(r2, r5)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0055
        L_0x004f:
            com.google.gson.Gson r3 = (com.google.gson.Gson) r3     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r2 = com.bonree.sdk.agent.engine.external.GsonInstrumentation.fromJson(r3, r2, r5)     // Catch:{ Exception -> 0x0080 }
        L_0x0055:
            com.tal.app.thinkacademy.live.business.topic.bean.InteractBean r2 = (com.tal.app.thinkacademy.live.business.topic.bean.InteractBean) r2     // Catch:{ Exception -> 0x0080 }
            java.lang.String r0 = r2.getInteractId()     // Catch:{ Exception -> 0x007d }
            r7.interactId = r0     // Catch:{ Exception -> 0x007d }
            r7.track_start_interact()     // Catch:{ Exception -> 0x007d }
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x007d }
            r0.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "irtTypeKey"
            r0.addProperty(r3, r8)     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = "互动题"
            r0.addProperty(r8, r9)     // Catch:{ Exception -> 0x007d }
            java.lang.String r8 = "interactId"
            java.lang.String r9 = r7.interactId     // Catch:{ Exception -> 0x007d }
            r0.addProperty(r8, r9)     // Catch:{ Exception -> 0x007d }
            com.tal.app.thinkacademy.live.Tag r8 = com.tal.app.thinkacademy.live.Tag.TOPIC     // Catch:{ Exception -> 0x007d }
            com.tal.app.thinkacademy.lib.logger.XesLog.ut((com.tal.app.thinkacademy.lib.logger.XesLogTag) r8, (com.google.gson.JsonObject) r0)     // Catch:{ Exception -> 0x007d }
            r0 = r2
            goto L_0x0084
        L_0x007d:
            r8 = move-exception
            r0 = r2
            goto L_0x0081
        L_0x0080:
            r8 = move-exception
        L_0x0081:
            r8.printStackTrace()
        L_0x0084:
            if (r0 == 0) goto L_0x010e
            java.util.Map<java.lang.String, java.lang.Boolean> r8 = r7.mOverMap
            java.lang.String r9 = r0.getInteractId()
            boolean r2 = r0.isPublishTopic()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r8.put(r9, r2)
            boolean r8 = r0.isPublishTopic()
            if (r8 == 0) goto L_0x00ef
            java.lang.String r8 = r0.getQuestionId()
            r7.questionId = r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x00af
            java.lang.String r8 = r0.getQuesId()
            r7.questionId = r8
        L_0x00af:
            java.lang.String r8 = r0.getQuesTypeId()
            r7.questionTypeId = r8
            java.lang.String r9 = "1"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00c6
            java.lang.String r8 = "QuestionDanxuan"
            r7.QUESTION_TYPE = r8
            java.lang.String r8 = "single_choice"
            r7.QUESTION_TYPE_TRACK = r8
            goto L_0x00eb
        L_0x00c6:
            java.lang.String r8 = r7.questionTypeId
            java.lang.String r9 = "2"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00d9
            java.lang.String r8 = "QuestionDuoxuan"
            r7.QUESTION_TYPE = r8
            java.lang.String r8 = "multiple_choice"
            r7.QUESTION_TYPE_TRACK = r8
            goto L_0x00eb
        L_0x00d9:
            java.lang.String r8 = r7.questionTypeId
            java.lang.String r9 = "5"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00eb
            java.lang.String r8 = "QuestionPanduan"
            r7.QUESTION_TYPE = r8
            java.lang.String r8 = "true_false"
            r7.QUESTION_TYPE_TRACK = r8
        L_0x00eb:
            r7.requestTopicStatus(r0)
            goto L_0x010e
        L_0x00ef:
            com.tal.app.thinkacademy.live.Tag r8 = com.tal.app.thinkacademy.live.Tag.TOPIC
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "收到互动题已结束 "
            r0.append(r1)
            java.lang.String r1 = r7.interactId
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9[r4] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r8, r9)
            r7.advanceFinish()
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.topic.driver.BaseTopicPluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    public void requestTopicStatus(final InteractBean interactBean) {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "请求接口，查询提交状态 " + interactBean.getInteractId());
        Call<HiResponse<InteractStateBean>> interactStatus = ((TopicApi) Api.create(TopicApi.class)).interactStatus(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/question/student/status", new InteractStatusRequest(this.planId, this.classId, this.interactId));
        AnonymousClass2 r1 = new OmyCallback<HiResponse<InteractStateBean>>(new IError() {
            public void onFail(int i, String str) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "查询提交状态接口返回，faIl" + interactBean.getInteractId());
                LiveStabilityUtils.live_stability_track(BaseTopicPluginDriver.this.QUESTION_TYPE, BaseTopicPluginDriver.this.interactId, "start", 0, str);
            }

            public void onError(int i, String str) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "查询提交状态接口返回，error" + interactBean.getInteractId());
                LiveStabilityUtils.live_stability_track(BaseTopicPluginDriver.this.QUESTION_TYPE, BaseTopicPluginDriver.this.interactId, "start", 0, str);
            }
        }) {
            public void onSuccess(HiResponse<InteractStateBean> hiResponse) {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "查询提交状态接口返回，成功" + interactBean.getInteractId());
                InteractStateBean data = hiResponse.getData();
                if (data != null && data.getInteractStatus() == 1) {
                    if (data.getUserAnswer() != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(GoldSource.TOPIC_GOLD, "已经作答 无需恢复");
                        jsonObject.addProperty("interactId", BaseTopicPluginDriver.this.interactId);
                        XesLog.ut((XesLogTag) Tag.TOPIC, jsonObject);
                        BaseTopicPluginDriver.this.removePlugin(0);
                        return;
                    }
                    BaseTopicPluginDriver.this.loadPlugin(interactBean, data);
                    LiveStabilityUtils.live_stability_track(BaseTopicPluginDriver.this.QUESTION_TYPE, BaseTopicPluginDriver.this.interactId, "start", 1, "");
                }
            }
        };
        if (!(interactStatus instanceof Call)) {
            interactStatus.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) interactStatus, r1);
        }
    }

    private void getRealCountDownTime(InteractBean interactBean) {
        int countDownTime = interactBean.getCountDownTime();
        long j = (long) (countDownTime * 1000);
        int min = ((int) Math.min(j - ((this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime() * 1000) - interactBean.getCurrentTime()), j)) / 1000;
        this.realCountDownTime = min;
        interactBean.setRealCountDownTime(min);
    }

    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.View, com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView] */
    /* access modifiers changed from: private */
    public void loadPlugin(InteractBean interactBean, InteractStateBean interactStateBean) {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "互动题开始作答 " + interactBean.getInteractId() + " driver " + this);
        if (!Boolean.TRUE.equals(this.mOverMap.get(interactBean.getInteractId()))) {
            Tag tag2 = Tag.TOPIC;
            XesLog.i(tag2, "互动题开始作答,但已收到老师结束信令，不加载答题面板 " + interactBean.getInteractId());
            return;
        }
        this.isSubmitting = false;
        if (this.topicPluginView != null) {
            Tag tag3 = Tag.TOPIC;
            XesLog.i(tag3, "移除view和消息队列 " + interactBean.getInteractId());
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            this.mLiveRoomProvider.removeView(this.topicPluginView);
            this.topicPluginView = null;
        }
        getRealCountDownTime(interactBean);
        if (this.realCountDownTime > 1 && this.topicPluginView == null) {
            TopicPluginView topicPluginView2 = new TopicPluginView(this.mContext);
            this.topicPluginView = topicPluginView2;
            topicPluginView2.setDriver(this);
            this.topicPluginView.setIActionListener(initIActionListener());
            this.topicPluginView.setInteractStateBean(interactStateBean);
            this.topicPluginView.setInteractBean(interactBean);
            this.topicPluginView.readyToDraw();
            this.mLiveRoomProvider.addView(this, this.topicPluginView, this.mPluginConfData.getViewLevel(TopicConfig.INTERACT), LiveAreaContext.get().getPptLp().newLp());
            Tag tag4 = Tag.TOPIC;
            XesLog.i(tag4, "addView interactId = " + interactBean.getInteractId());
            LiveAreaContext.get().layoutObserver.observe(this, new BaseTopicPluginDriver$$ExternalSyntheticLambda0(this));
            InteractLogReport.uploadLog(this.interactId, this.planId, this.classId);
        }
    }

    public /* synthetic */ void lambda$loadPlugin$0$BaseTopicPluginDriver(LiveAreaContext liveAreaContext) {
        TopicPluginView topicPluginView2 = this.topicPluginView;
        if (topicPluginView2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) topicPluginView2.getLayoutParams();
            LiveAreaContext.get().getPptLp().mergeLp(layoutParams);
            this.topicPluginView.setLayoutParams(layoutParams);
        }
    }

    private void advanceFinish() {
        TopicPluginView topicPluginView2 = this.topicPluginView;
        if (topicPluginView2 != null) {
            topicPluginView2.autoCommit(true);
            return;
        }
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "advanceFinish view为空 interactId = " + this.interactId);
    }

    public void removePlugin(final int i) {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "插件延迟移除view interactId = " + this.interactId + "，delayMillis  = " + i);
        this.handler.postDelayed(new Runnable() {
            /* JADX WARNING: type inference failed for: r2v2, types: [android.view.View, com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView] */
            public void run() {
                Tag tag = Tag.TOPIC;
                XesLog.i(tag, "插件移除view delayMillis  " + i);
                BaseTopicPluginDriver.this.isSubmitting = false;
                BaseTopicPluginDriver.this.mLiveRoomProvider.removeView(BaseTopicPluginDriver.this.topicPluginView);
                BaseTopicPluginDriver.this.topicPluginView = null;
                LiveStabilityUtils.live_stability_track(BaseTopicPluginDriver.this.QUESTION_TYPE, BaseTopicPluginDriver.this.interactId, "end", 1, "");
            }
        }, (long) i);
    }

    public void track_start_interact() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.start_interact, trackMap);
    }

    public void track_show_interact() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.show_interact, trackMap);
    }

    public void track_submit_interact() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.submit_interact, trackMap);
    }

    public void track_result_interact() {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", this.interactId);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(LeanplumUtil.result_interact, trackMap);
    }
}
