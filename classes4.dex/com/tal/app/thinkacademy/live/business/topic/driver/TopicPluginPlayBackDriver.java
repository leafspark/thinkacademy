package com.tal.app.thinkacademy.live.business.topic.driver;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.topic.IActionListenter;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import java.util.List;

@PluginAnnotation(desc = "互动题插件", liveType = 1, metaDataKey = {"interact"}, moduleId = "214")
@ViewLevels({@ViewLevel(level = 10, name = "interact_back")})
public class TopicPluginPlayBackDriver extends BaseTopicPluginDriver implements IActionListenter {
    private String mInteractType;

    /* access modifiers changed from: protected */
    public IActionListenter initIActionListener() {
        return this;
    }

    public void track_result_interact() {
    }

    public void track_show_interact() {
    }

    public void track_submit_interact() {
    }

    public TopicPluginPlayBackDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "interact"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00d4
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0047 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0047 }
            org.json.JSONObject r7 = r1.optJSONObject(r7)     // Catch:{ Exception -> 0x0047 }
            if (r7 == 0) goto L_0x004b
            com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0047 }
            r8.<init>()     // Catch:{ Exception -> 0x0047 }
            boolean r1 = r7 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x0022
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0047 }
            goto L_0x0028
        L_0x0022:
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ Exception -> 0x0047 }
            java.lang.String r7 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r7)     // Catch:{ Exception -> 0x0047 }
        L_0x0028:
            java.lang.Class<com.tal.app.thinkacademy.live.business.topic.bean.InteractBean> r1 = com.tal.app.thinkacademy.live.business.topic.bean.InteractBean.class
            boolean r2 = r8 instanceof com.google.gson.Gson     // Catch:{ Exception -> 0x0047 }
            if (r2 != 0) goto L_0x0033
            java.lang.Object r7 = r8.fromJson(r7, r1)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0039
        L_0x0033:
            com.google.gson.Gson r8 = (com.google.gson.Gson) r8     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r7 = com.bonree.sdk.agent.engine.external.GsonInstrumentation.fromJson(r8, r7, r1)     // Catch:{ Exception -> 0x0047 }
        L_0x0039:
            com.tal.app.thinkacademy.live.business.topic.bean.InteractBean r7 = (com.tal.app.thinkacademy.live.business.topic.bean.InteractBean) r7     // Catch:{ Exception -> 0x0047 }
            java.lang.String r8 = r7.getInteractId()     // Catch:{ Exception -> 0x0043 }
            r6.interactId = r8     // Catch:{ Exception -> 0x0043 }
            r0 = r7
            goto L_0x004b
        L_0x0043:
            r8 = move-exception
            r0 = r7
            r7 = r8
            goto L_0x0048
        L_0x0047:
            r7 = move-exception
        L_0x0048:
            r7.printStackTrace()
        L_0x004b:
            if (r0 == 0) goto L_0x00d4
            boolean r7 = r0.isPublishTopic()
            r8 = 2
            r1 = 1
            java.lang.String r2 = "回放"
            r3 = 3
            r4 = 0
            if (r7 == 0) goto L_0x00c0
            java.lang.String r7 = r0.getQuestionId()
            r6.questionId = r7
            java.lang.String r7 = r6.questionId
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x006d
            java.lang.String r7 = r0.getQuesId()
            r6.questionId = r7
        L_0x006d:
            java.lang.String r7 = r0.getQuesTypeId()
            r6.questionTypeId = r7
            java.lang.String r7 = r6.questionTypeId
            java.lang.String r5 = "1"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0086
            java.lang.String r7 = "QuestionDanxuan"
            r6.QUESTION_TYPE = r7
            java.lang.String r7 = "单选"
            r6.mInteractType = r7
            goto L_0x00ab
        L_0x0086:
            java.lang.String r7 = r6.questionTypeId
            java.lang.String r5 = "2"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0099
            java.lang.String r7 = "QuestionDuoxuan"
            r6.QUESTION_TYPE = r7
            java.lang.String r7 = "多选"
            r6.mInteractType = r7
            goto L_0x00ab
        L_0x0099:
            java.lang.String r7 = r6.questionTypeId
            java.lang.String r5 = "5"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = "QuestionPanduan"
            r6.QUESTION_TYPE = r7
            java.lang.String r7 = "判断"
            r6.mInteractType = r7
        L_0x00ab:
            com.tal.app.thinkacademy.live.Tag r7 = com.tal.app.thinkacademy.live.Tag.TOPIC
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r2
            java.lang.String r2 = r6.mInteractType
            r3[r1] = r2
            java.lang.String r1 = "开启互动"
            r3[r8] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r3)
            r6.loadPlugin(r0)
            goto L_0x00d4
        L_0x00c0:
            com.tal.app.thinkacademy.live.Tag r7 = com.tal.app.thinkacademy.live.Tag.TOPIC
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r4] = r2
            java.lang.String r2 = r6.mInteractType
            r0[r1] = r2
            java.lang.String r1 = "关闭互动"
            r0[r8] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r0)
            r6.removePlugin(r4)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginPlayBackDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    private void loadPlugin(InteractBean interactBean) {
        if (this.topicPluginView != null) {
            removeView();
        }
        interactBean.setRealCountDownTime(interactBean.getCountDownTime());
        if (this.topicPluginView == null) {
            XesLog.i(Tag.TOPIC, "回放", this.mInteractType, "初始化视图");
            this.topicPluginView = new TopicPluginView(this.mContext);
            this.topicPluginView.setDriver(this);
            this.topicPluginView.setIsPlayback(true);
            this.topicPluginView.setIActionListener(initIActionListener());
            this.topicPluginView.setInteractStateBean(new InteractStateBean());
            this.topicPluginView.setInteractBean(interactBean);
            this.topicPluginView.readyToDraw();
            this.mLiveRoomProvider.addView(this, this.topicPluginView, this.mPluginConfData.getViewLevel("interact_back"), LiveAreaContext.get().getPptLp().newLp());
            LiveAreaContext.get().layoutObserver.observe(this, new TopicPluginPlayBackDriver$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$loadPlugin$0$TopicPluginPlayBackDriver(LiveAreaContext liveAreaContext) {
        if (this.topicPluginView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topicPluginView.getLayoutParams();
            LiveAreaContext.get().getPptLp().mergeLp(layoutParams);
            this.topicPluginView.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.view.View, com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView] */
    private void removeView() {
        this.mLiveRoomProvider.removeView(this.topicPluginView);
        this.topicPluginView = null;
    }

    public void onDestroy() {
        super.onDestroy();
        XesLog.i(Tag.TOPIC, "回放", this.mInteractType, "互动销毁");
    }

    public void submitAnswer(List<List<String>> list, int i, boolean z) {
        this.topicPluginView.showAnswerView(z);
    }
}
