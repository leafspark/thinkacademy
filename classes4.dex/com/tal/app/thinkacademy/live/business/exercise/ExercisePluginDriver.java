package com.tal.app.thinkacademy.live.business.exercise;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.topic.api.TopicApi;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.business.topic.bean.request.InteractStatusRequest;
import com.tal.app.thinkacademy.live.business.topic.bean.request.SubmitAnswerRequest;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@PluginAnnotation(desc = "填空题", ircType = {"fill_blank", "mode"}, moduleId = "224", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "ExercisePluginView")})
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u0014J\b\u0010%\u001a\u00020\u001dH\u0016J\u001c\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u00142\b\u0010(\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010)\u001a\u00020\u001dJ\b\u0010*\u001a\u00020\u001dH\u0002J(\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0014H\u0002J\u0018\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u0014J\u0016\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\fJ\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/ExercisePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isSubmit", "", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mCountDownTime", "mExercisePluginView", "Lcom/tal/app/thinkacademy/live/business/exercise/ExercisePluginView;", "mInteractId", "", "mPlanId", "mQuestionId", "mSendTime", "", "Ljava/lang/Long;", "mStuId", "mUserName", "checkReset", "", "getRealCountDownTime", "getResultCoins", "userAnswerResult", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "result", "loadPluginView", "js", "onDestroy", "onMessage", "ircTypeKey", "message", "removeView", "requestInteractiveStatus", "trackInteractiveLog", "interactionType", "interactionStage", "status", "failureReason", "track_exercise", "key", "interactId", "updateUserCoins", "userCoins", "addCoins", "updateUserLevel", "level", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExercisePluginDriver.kt */
public final class ExercisePluginDriver extends ExerciseBasePluginDriver {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.EXERCISE;
    /* access modifiers changed from: private */
    public boolean isSubmit;
    /* access modifiers changed from: private */
    public Integer mClassId;
    private Context mContext;
    private Integer mCountDownTime;
    /* access modifiers changed from: private */
    public ExercisePluginView mExercisePluginView;
    /* access modifiers changed from: private */
    public String mInteractId;
    /* access modifiers changed from: private */
    public Integer mPlanId;
    /* access modifiers changed from: private */
    public String mQuestionId;
    private Long mSendTime;
    /* access modifiers changed from: private */
    public String mStuId;
    private String mUserName;

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r0 = (r0 = r2.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExercisePluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2, android.os.Bundle r3) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            com.tal.app.thinkacademy.live.Tag r3 = com.tal.app.thinkacademy.live.Tag.EXERCISE
            r1.TAG = r3
            r3 = 0
            if (r2 != 0) goto L_0x000c
        L_0x000a:
            r0 = r3
            goto L_0x0022
        L_0x000c:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x001a
            goto L_0x000a
        L_0x001a:
            int r0 = r0.getPlanId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0022:
            r1.mPlanId = r0
            if (r2 != 0) goto L_0x0028
        L_0x0026:
            r0 = r3
            goto L_0x003e
        L_0x0028:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x0036
            goto L_0x0026
        L_0x0036:
            int r0 = r0.getClassId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x003e:
            r1.mClassId = r0
            if (r2 != 0) goto L_0x0044
        L_0x0042:
            r0 = r3
            goto L_0x0056
        L_0x0044:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r0.getUserInfo()
            if (r0 != 0) goto L_0x0052
            goto L_0x0042
        L_0x0052:
            java.lang.String r0 = r0.getNickName()
        L_0x0056:
            r1.mUserName = r0
            if (r2 != 0) goto L_0x005b
            goto L_0x006d
        L_0x005b:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x0062
            goto L_0x006d
        L_0x0062:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r2 = r2.getUserInfo()
            if (r2 != 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            java.lang.String r3 = r2.getId()
        L_0x006d:
            r1.mStuId = r3
            java.lang.String r2 = "exercise_view_coins"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r2 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r2)
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver$special$$inlined$observe$1 r3 = new com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver$special$$inlined$observe$1
            r3.<init>(r1)
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            r0 = r1
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            r2.observe(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0004
            goto L_0x00d4
        L_0x0004:
            java.lang.String r0 = "fill_blank"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)
            if (r0 == 0) goto L_0x00d4
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00d4 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001c
            int r0 = r0.length()     // Catch:{ Exception -> 0x00d4 }
            if (r0 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = r1
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            if (r0 != 0) goto L_0x00d4
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d4 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00d4 }
            org.json.JSONObject r11 = r0.optJSONObject(r11)     // Catch:{ Exception -> 0x00d4 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d4 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r12 = "sendTime"
            long r3 = r0.optLong(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Long r12 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00d4 }
            r10.mSendTime = r12     // Catch:{ Exception -> 0x00d4 }
            if (r11 != 0) goto L_0x003d
            goto L_0x00d4
        L_0x003d:
            java.lang.String r12 = "pub"
            boolean r12 = r11.optBoolean(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "FillBlank"
            if (r12 == 0) goto L_0x007a
            java.lang.String r12 = "interactId"
            java.lang.String r12 = r11.optString(r12)     // Catch:{ Exception -> 0x00d4 }
            r10.mInteractId = r12     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r12 = "countDownTime"
            int r11 = r11.optInt(r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x00d4 }
            r10.mCountDownTime = r11     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = "show_fill_blank"
            java.lang.String r12 = r10.mInteractId     // Catch:{ Exception -> 0x00d4 }
            r10.track_exercise(r11, r12)     // Catch:{ Exception -> 0x00d4 }
            r10.requestInteractiveStatus()     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.live.Tag r11 = r10.TAG     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11     // Catch:{ Exception -> 0x00d4 }
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "interact+exercise---> 老师发布并收到互动"
            r12[r1] = r3     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = "start"
            java.lang.String r12 = "pub:true"
            r10.trackInteractiveLog(r0, r11, r2, r12)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d4
        L_0x007a:
            java.lang.String r11 = r10.mInteractId     // Catch:{ Exception -> 0x00d4 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x00d4 }
            if (r11 == 0) goto L_0x0089
            int r11 = r11.length()     // Catch:{ Exception -> 0x00d4 }
            if (r11 != 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r11 = r1
            goto L_0x008a
        L_0x0089:
            r11 = r2
        L_0x008a:
            if (r11 == 0) goto L_0x009d
            com.tal.app.thinkacademy.live.Tag r11 = r10.TAG     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11     // Catch:{ Exception -> 0x00d4 }
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "interact+exercise---> 互动已结束，退出重进没有互动id，无需提交空作答"
            r12[r1] = r0     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r12)     // Catch:{ Exception -> 0x00d4 }
            r10.destroy()     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x009d:
            boolean r11 = r10.isSubmit     // Catch:{ Exception -> 0x00d4 }
            if (r11 != 0) goto L_0x00c0
            com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData r11 = new com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData     // Catch:{ Exception -> 0x00d4 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 15
            r9 = 0
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00d4 }
            r12 = 3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x00d4 }
            r11.setRight(r3)     // Catch:{ Exception -> 0x00d4 }
            r3 = 0
            r11.setUserAnswer(r3)     // Catch:{ Exception -> 0x00d4 }
            r11.setUserAnswerResult(r3)     // Catch:{ Exception -> 0x00d4 }
            r10.getResultCoins(r11, r12)     // Catch:{ Exception -> 0x00d4 }
        L_0x00c0:
            com.tal.app.thinkacademy.live.Tag r11 = r10.TAG     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11     // Catch:{ Exception -> 0x00d4 }
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "interact+exercise---> 老师关闭互动"
            r12[r1] = r3     // Catch:{ Exception -> 0x00d4 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r12)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = "end"
            java.lang.String r12 = "pub:false"
            r10.trackInteractiveLog(r0, r11, r2, r12)     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    public final void loadPluginView(String str) {
        Context context;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null && (context = (Context) iLiveRoomProvider.getWeakRefContext().get()) != null) {
            BaseLivePluginView exercisePluginView = new ExercisePluginView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            checkReset();
            exercisePluginView.initLoadUrl(str);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, exercisePluginView, "ExercisePluginView", LiveAreaContext.get().getPptLp().newLp());
            this.mExercisePluginView = exercisePluginView;
            exercisePluginView.setDriver(this);
            XesLog.i(this.TAG, "interact+exercise---> 开始加载填空互动页面");
        }
    }

    private final void checkReset() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        removeView();
        this.isSubmit = false;
    }

    private final void requestInteractiveStatus() {
        if (this.mPlanId != null && this.mClassId != null) {
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/status");
            Integer num = this.mPlanId;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.mClassId;
            Intrinsics.checkNotNull(num2);
            Call<HiResponse<InteractStateBean>> interactStatus = ((TopicApi) Api.create(TopicApi.class)).interactStatus(stringPlus, new InteractStatusRequest(intValue, num2.intValue(), this.mInteractId));
            Callback exercisePluginDriver$requestInteractiveStatus$1 = new ExercisePluginDriver$requestInteractiveStatus$1(this, new ExercisePluginDriver$requestInteractiveStatus$2(this));
            if (!(interactStatus instanceof Call)) {
                interactStatus.enqueue(exercisePluginDriver$requestInteractiveStatus$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) interactStatus, exercisePluginDriver$requestInteractiveStatus$1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final long getRealCountDownTime() {
        Integer num = this.mCountDownTime;
        Long l = this.mSendTime;
        long serveNowTime = this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
        if (num == null) {
            return 0;
        }
        if ((l != null && l.longValue() == 0) || l == null) {
            return ((long) num.intValue()) * 1000;
        }
        return Math.min(((long) (num.intValue() * 1000)) - ((serveNowTime * ((long) 1000)) - l.longValue()), ((long) num.intValue()) * 1000);
    }

    public void onDestroy() {
        super.onDestroy();
        removeView();
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_COINS).removeObservers((LifecycleOwner) this);
        this.mLiveRoomProvider.destroyPlugin((BaseLivePluginDriver) this);
        XesLog.i(this.TAG, "interact+exercise---> destroyPlugin");
    }

    public final void removeView() {
        ExercisePluginView exercisePluginView = this.mExercisePluginView;
        if (exercisePluginView != null) {
            exercisePluginView.onDestroy();
        }
        this.mLiveRoomProvider.removeView((View) this.mExercisePluginView);
        this.mExercisePluginView = null;
    }

    /* access modifiers changed from: private */
    public final void getResultCoins(GameJsSubmitData gameJsSubmitData, int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String str = this.mInteractId;
        if (str == null) {
            str = "";
        }
        hWEventTracking.ostaIaBaseInteractionSubmit(str, "fill_blank", z);
        if (this.mPlanId != null && this.mClassId != null) {
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/submit");
            Integer num = this.mPlanId;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.mClassId;
            Intrinsics.checkNotNull(num2);
            Call<HiResponse<AnswerBean>> submitAnswer = ((TopicApi) Api.create(TopicApi.class)).submitAnswer(stringPlus, new SubmitAnswerRequest(intValue, num2.intValue(), this.mInteractId, this.mQuestionId, (List<String>) null, 0, this.mUserName, gameJsSubmitData));
            Callback exercisePluginDriver$getResultCoins$1 = new ExercisePluginDriver$getResultCoins$1(i, this, new ExercisePluginDriver$getResultCoins$2(this));
            if (!(submitAnswer instanceof Call)) {
                submitAnswer.enqueue(exercisePluginDriver$getResultCoins$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitAnswer, exercisePluginDriver$getResultCoins$1);
            }
        }
    }

    public final void updateUserCoins(int i, int i2) {
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.USERCOINS_KEY, i + "", new CoinEventData(GoldSource.EXERCISE_GOLD, i2, false, false, 12, (DefaultConstructorMarker) null)));
        this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(i);
    }

    public final void updateUserLevel(int i) {
        PluginEventBus.onEvent(DataBusKey.LEVEL_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.LEVEL_KEY, String.valueOf(i)));
    }

    public final void track_exercise(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("interactId", str2);
        map.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, hashMap);
    }

    /* access modifiers changed from: private */
    public final void trackInteractiveLog(String str, String str2, int i, String str3) {
        InteractReportKt.XesLogReport(str2, str, this.mInteractId, Integer.valueOf(i), str3);
    }
}
