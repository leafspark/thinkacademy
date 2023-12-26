package com.tal.app.thinkacademy.live.business.speedyhand.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import com.tal.app.thinkacademy.live.business.speedyhand.api.SpeedyHandApi;
import com.tal.app.thinkacademy.live.business.speedyhand.api.SpeedyHandBody;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandApiResult;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandData;
import com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@PluginAnnotation(desc = "抢答", ircType = {"speedyHand", "mult_video_mic"}, launchType = "delay", moduleId = "3012")
@ViewLevels({@ViewLevel(level = 41, name = "SpeedyHand")})
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0016J\u001c\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/driver/SpeedyHandPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "KCloseView", "", "KShowResult", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "mClassId", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "mInteractId", "", "mPlanId", "mShowResultInteractId", "mShowResultUserId", "mSpeedyHandData", "Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandData;", "mSpeedyHandView", "Lcom/tal/app/thinkacademy/live/business/speedyhand/view/SpeedyHandView;", "mUserId", "videoCallList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "Lkotlin/collections/ArrayList;", "answerRob", "", "loadView", "onDestroy", "onMessage", "ircTypeKey", "message", "removeView", "delayMillis", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandPluginDriver.kt */
public final class SpeedyHandPluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final int KCloseView;
    /* access modifiers changed from: private */
    public final int KShowResult = 1;
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.SpeedyHandPluginDriver;
    private boolean isOnDestroy;
    private int mClassId = -1;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new SpeedyHandPluginDriver$mHandler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public String mInteractId = "";
    private int mPlanId = -1;
    /* access modifiers changed from: private */
    public String mShowResultInteractId = "";
    /* access modifiers changed from: private */
    public String mShowResultUserId = "";
    private SpeedyHandData mSpeedyHandData;
    /* access modifiers changed from: private */
    public SpeedyHandView mSpeedyHandView;
    /* access modifiers changed from: private */
    public String mUserId = "";
    /* access modifiers changed from: private */
    public ArrayList<VideoCallBean> videoCallList = new ArrayList<>();

    public SpeedyHandPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
            this.mUserId = iLiveRoomProvider.getDataStorage().getUserInfo().getId().toString();
            this.mPlanId = iLiveRoomProvider.getDataStorage().getCourseInfo().getPlanId();
            this.mClassId = iLiveRoomProvider.getDataStorage().getCourseInfo().getClassId();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x024f A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0106 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012f A[Catch:{ Exception -> 0x01d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            boolean r0 = r9.isOnDestroy
            if (r0 != 0) goto L_0x0284
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0014
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            if (r0 != 0) goto L_0x0284
            com.tal.app.thinkacademy.live.Tag r0 = r9.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "ircTypeKey --> "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r11)
            r3[r1] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r3)
            java.lang.String r0 = "speedyHand"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            if (r0 == 0) goto L_0x01e9
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d1 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ Exception -> 0x01d1 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x01d1 }
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x01d1 }
            if (r10 != 0) goto L_0x0040
            goto L_0x0284
        L_0x0040:
            boolean r11 = r10 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x0049
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01d1 }
            goto L_0x004f
        L_0x0049:
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r10 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r10)     // Catch:{ Exception -> 0x01d1 }
        L_0x004f:
            java.lang.Class<com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandData> r11 = com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandData.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r10, r11)     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandData r10 = (com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandData) r10     // Catch:{ Exception -> 0x01d1 }
            r9.mSpeedyHandData = r10     // Catch:{ Exception -> 0x01d1 }
            if (r10 != 0) goto L_0x005d
            goto L_0x0284
        L_0x005d:
            java.lang.Boolean r11 = r10.getPub()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x01d1 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0081
            java.lang.String r10 = r10.getInteractId()     // Catch:{ Exception -> 0x01d1 }
            if (r10 != 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r0 = r10
        L_0x0075:
            r9.mInteractId = r0     // Catch:{ Exception -> 0x01d1 }
            r9.loadView()     // Catch:{ Exception -> 0x01d1 }
            r10 = 20000(0x4e20, double:9.8813E-320)
            r9.removeView(r10)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0284
        L_0x0081:
            java.lang.Integer r11 = r10.getStatus()     // Catch:{ Exception -> 0x01d1 }
            r3 = 3500(0xdac, double:1.729E-320)
            if (r11 != 0) goto L_0x008b
            goto L_0x017b
        L_0x008b:
            int r5 = r11.intValue()     // Catch:{ Exception -> 0x01d1 }
            if (r5 != r2) goto L_0x017b
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r11 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x01d1 }
            if (r11 == 0) goto L_0x0284
            java.lang.String r11 = r9.mShowResultInteractId     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r5 = r9.mInteractId     // Catch:{ Exception -> 0x01d1 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r5)     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x0284
            java.lang.String r11 = r9.mInteractId     // Catch:{ Exception -> 0x01d1 }
            r9.mShowResultInteractId = r11     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandResult r11 = r10.getData()     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x00aa
            goto L_0x00b9
        L_0x00aa:
            java.lang.Long r11 = r11.getStudentId()     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x00b1
            goto L_0x00b9
        L_0x00b1:
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r0 = r11
        L_0x00b9:
            r9.mShowResultUserId = r0     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r11 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x01d1 }
            r0 = 0
            if (r11 != 0) goto L_0x00c1
            goto L_0x00ed
        L_0x00c1:
            com.tal.app.thinkacademy.live.business.speedyhand.bean.StudentInfo r5 = new com.tal.app.thinkacademy.live.business.speedyhand.bean.StudentInfo     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandResult r6 = r10.getData()     // Catch:{ Exception -> 0x01d1 }
            if (r6 != 0) goto L_0x00cb
            r6 = r0
            goto L_0x00cf
        L_0x00cb:
            java.lang.Long r6 = r6.getStudentId()     // Catch:{ Exception -> 0x01d1 }
        L_0x00cf:
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandResult r7 = r10.getData()     // Catch:{ Exception -> 0x01d1 }
            if (r7 != 0) goto L_0x00d7
            r7 = r0
            goto L_0x00db
        L_0x00d7:
            java.lang.String r7 = r7.getNickName()     // Catch:{ Exception -> 0x01d1 }
        L_0x00db:
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandResult r8 = r10.getData()     // Catch:{ Exception -> 0x01d1 }
            if (r8 != 0) goto L_0x00e3
            r8 = r0
            goto L_0x00e7
        L_0x00e3:
            java.lang.String r8 = r8.getAvatar()     // Catch:{ Exception -> 0x01d1 }
        L_0x00e7:
            r5.<init>(r6, r7, r8)     // Catch:{ Exception -> 0x01d1 }
            r11.showSpeedyHandResult(r5)     // Catch:{ Exception -> 0x01d1 }
        L_0x00ed:
            android.os.Handler r11 = r9.mHandler     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x00f2
            goto L_0x00f9
        L_0x00f2:
            int r5 = r9.KShowResult     // Catch:{ Exception -> 0x01d1 }
            r6 = 200(0xc8, double:9.9E-322)
            r11.sendEmptyMessageDelayed(r5, r6)     // Catch:{ Exception -> 0x01d1 }
        L_0x00f9:
            java.util.ArrayList<com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r11 = r9.videoCallList     // Catch:{ Exception -> 0x01d1 }
            if (r11 != 0) goto L_0x00ff
            r5 = r1
            goto L_0x0131
        L_0x00ff:
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch:{ Exception -> 0x01d1 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x01d1 }
            r5 = r1
        L_0x0106:
            boolean r6 = r11.hasNext()     // Catch:{ Exception -> 0x01d1 }
            if (r6 == 0) goto L_0x0131
            java.lang.Object r6 = r11.next()     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r6 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r6     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r6 = r6.getUserId()     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandResult r7 = r10.getData()     // Catch:{ Exception -> 0x01d1 }
            if (r7 != 0) goto L_0x011e
        L_0x011c:
            r7 = r0
            goto L_0x0129
        L_0x011e:
            java.lang.Long r7 = r7.getStudentId()     // Catch:{ Exception -> 0x01d1 }
            if (r7 != 0) goto L_0x0125
            goto L_0x011c
        L_0x0125:
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01d1 }
        L_0x0129:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)     // Catch:{ Exception -> 0x01d1 }
            if (r6 == 0) goto L_0x0106
            r5 = r2
            goto L_0x0106
        L_0x0131:
            com.tal.app.thinkacademy.live.Tag r10 = r9.TAG     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = "isVideoCall ---> "
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r6)     // Catch:{ Exception -> 0x01d1 }
            r11[r1] = r0     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r11)     // Catch:{ Exception -> 0x01d1 }
            if (r5 == 0) goto L_0x014c
            r9.removeView(r3)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0151
        L_0x014c:
            r10 = 10000(0x2710, double:4.9407E-320)
            r9.removeView(r10)     // Catch:{ Exception -> 0x01d1 }
        L_0x0151:
            com.tal.app.thinkacademy.live.Tag r10 = r9.TAG     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01d1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d1 }
            r0.<init>()     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r3 = "抢答有人抢--userid="
            r0.append(r3)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r3 = r9.mShowResultUserId     // Catch:{ Exception -> 0x01d1 }
            r0.append(r3)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r3 = ",muserid="
            r0.append(r3)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r3 = r9.mUserId     // Catch:{ Exception -> 0x01d1 }
            r0.append(r3)     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01d1 }
            r11[r1] = r0     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r11)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0284
        L_0x017b:
            r10 = 2
            if (r11 != 0) goto L_0x017f
            goto L_0x01a3
        L_0x017f:
            int r0 = r11.intValue()     // Catch:{ Exception -> 0x01d1 }
            if (r0 != r10) goto L_0x01a3
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r10 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x01d1 }
            if (r10 == 0) goto L_0x0284
            com.tal.app.thinkacademy.live.Tag r10 = r9.TAG     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = "抢答无人抢"
            r11[r1] = r0     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r11)     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r10 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x01d1 }
            if (r10 != 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            r10.noBodySpeedyHand()     // Catch:{ Exception -> 0x01d1 }
        L_0x019e:
            r9.removeView(r3)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0284
        L_0x01a3:
            r10 = 3
            if (r11 != 0) goto L_0x01a8
            goto L_0x0284
        L_0x01a8:
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x01d1 }
            if (r11 != r10) goto L_0x0284
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r10 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x01d1 }
            if (r10 == 0) goto L_0x0284
            com.tal.app.thinkacademy.live.Tag r10 = r9.TAG     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r0 = "抢答中途关闭"
            r11[r1] = r0     // Catch:{ Exception -> 0x01d1 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r11)     // Catch:{ Exception -> 0x01d1 }
            android.content.Context r10 = r9.mContext     // Catch:{ Exception -> 0x01d1 }
            int r11 = com.tal.app.thinkacademy.live.business.R.string.teacher_just_ended_the_game     // Catch:{ Exception -> 0x01d1 }
            android.widget.Toast r10 = android.widget.Toast.makeText(r10, r11, r1)     // Catch:{ Exception -> 0x01d1 }
            r10.show()     // Catch:{ Exception -> 0x01d1 }
            r10 = 0
            r9.removeView(r10)     // Catch:{ Exception -> 0x01d1 }
            goto L_0x0284
        L_0x01d1:
            r10 = move-exception
            com.tal.app.thinkacademy.live.Tag r11 = r9.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r10 = r10.getMessage()
            java.lang.String r2 = "抢答上台Exception-->"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r10)
            r0[r1] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r11, r0)
            goto L_0x0284
        L_0x01e9:
            java.lang.String r0 = "mult_video_mic"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            if (r0 == 0) goto L_0x0284
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r0 = r9.mSpeedyHandView
            if (r0 == 0) goto L_0x0284
            com.tal.app.thinkacademy.live.Tag r0 = r9.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "抢答上台"
            r3[r1] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r3)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0284 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ Exception -> 0x0284 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0284 }
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x0284 }
            if (r10 != 0) goto L_0x0212
            goto L_0x0284
        L_0x0212:
            boolean r11 = r10 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0284 }
            if (r11 != 0) goto L_0x021b
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0284 }
            goto L_0x0221
        L_0x021b:
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ Exception -> 0x0284 }
            java.lang.String r10 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r10)     // Catch:{ Exception -> 0x0284 }
        L_0x0221:
            java.lang.Class<com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean> r11 = com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r10, r11)     // Catch:{ Exception -> 0x0284 }
            com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean r10 = (com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean) r10     // Catch:{ Exception -> 0x0284 }
            if (r10 != 0) goto L_0x022c
            goto L_0x0284
        L_0x022c:
            java.lang.Boolean r11 = r10.getPub()     // Catch:{ Exception -> 0x0284 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0284 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)     // Catch:{ Exception -> 0x0284 }
            if (r11 == 0) goto L_0x0284
            java.util.ArrayList r10 = r10.getData()     // Catch:{ Exception -> 0x0284 }
            r9.videoCallList = r10     // Catch:{ Exception -> 0x0284 }
            if (r10 != 0) goto L_0x0243
            goto L_0x0284
        L_0x0243:
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ Exception -> 0x0284 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0284 }
        L_0x0249:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x0284 }
            if (r11 == 0) goto L_0x0284
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x0284 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r11 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r11     // Catch:{ Exception -> 0x0284 }
            java.lang.String r0 = r11.getUserId()     // Catch:{ Exception -> 0x0284 }
            java.lang.String r1 = r9.mShowResultUserId     // Catch:{ Exception -> 0x0284 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch:{ Exception -> 0x0284 }
            if (r0 != 0) goto L_0x026d
            java.lang.String r11 = r11.getUserId()     // Catch:{ Exception -> 0x0284 }
            java.lang.String r0 = r9.mUserId     // Catch:{ Exception -> 0x0284 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)     // Catch:{ Exception -> 0x0284 }
            if (r11 == 0) goto L_0x0249
        L_0x026d:
            android.os.Handler r10 = r9.mHandler     // Catch:{ Exception -> 0x0284 }
            if (r10 != 0) goto L_0x0272
            goto L_0x0277
        L_0x0272:
            int r11 = r9.KShowResult     // Catch:{ Exception -> 0x0284 }
            r10.removeMessages(r11)     // Catch:{ Exception -> 0x0284 }
        L_0x0277:
            com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView r10 = r9.mSpeedyHandView     // Catch:{ Exception -> 0x0284 }
            if (r10 != 0) goto L_0x027c
            goto L_0x027f
        L_0x027c:
            r10.goneSpeedyHand()     // Catch:{ Exception -> 0x0284 }
        L_0x027f:
            r10 = 120(0x78, double:5.93E-322)
            r9.removeView(r10)     // Catch:{ Exception -> 0x0284 }
        L_0x0284:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    private final void loadView() {
        Context context = this.mContext;
        if (context != null) {
            if (this.mSpeedyHandView == null) {
                SpeedyHandView speedyHandView = new SpeedyHandView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                this.mSpeedyHandView = speedyHandView;
                speedyHandView.setDriver(this);
                this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mSpeedyHandView, this.mPluginConfData.getViewLevel("SpeedyHand"), LiveAreaContext.get().getPptLp().newLp());
                LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new SpeedyHandPluginDriver$$ExternalSyntheticLambda0(this));
            }
            SpeedyHandView speedyHandView2 = this.mSpeedyHandView;
            if (speedyHandView2 != null) {
                speedyHandView2.openSpeedyHand();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadView$lambda-10$lambda-9  reason: not valid java name */
    public static final void m436loadView$lambda10$lambda9(SpeedyHandPluginDriver speedyHandPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(speedyHandPluginDriver, "this$0");
        SpeedyHandView speedyHandView = speedyHandPluginDriver.mSpeedyHandView;
        if (speedyHandView != null) {
            ViewGroup.LayoutParams layoutParams = speedyHandView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            speedyHandView.setLayoutParams(liveAreaContext.getPptLp().mergeLp((FrameLayout.LayoutParams) layoutParams));
        }
    }

    /* access modifiers changed from: private */
    public final void removeView(long j) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(this.KCloseView);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(this.KCloseView, j);
        }
    }

    public final void answerRob() {
        XesLog.i(this.TAG, "用户点击了抢答按钮");
        Call<HiResponse<SpeedyHandApiResult>> answerRob = ((SpeedyHandApi) Api.create(SpeedyHandApi.class)).answerRob(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/api/linkmic/v1/student/answerRob"), new SpeedyHandBody(Integer.valueOf(this.mPlanId), Integer.valueOf(this.mClassId), this.mInteractId));
        Callback speedyHandPluginDriver$answerRob$1 = new SpeedyHandPluginDriver$answerRob$1(this);
        if (!(answerRob instanceof Call)) {
            answerRob.enqueue(speedyHandPluginDriver$answerRob$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) answerRob, speedyHandPluginDriver$answerRob$1);
        }
    }

    public void onDestroy() {
        this.isOnDestroy = true;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
        SpeedyHandView speedyHandView = this.mSpeedyHandView;
        if (speedyHandView != null) {
            speedyHandView.onDestroy();
        }
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mSpeedyHandView);
        }
        this.mSpeedyHandView = null;
        this.mSpeedyHandData = null;
        this.mContext = null;
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        if (iLiveRoomProvider2 != null) {
            iLiveRoomProvider2.destroyPlugin((BaseLivePluginDriver) this);
        }
    }
}
