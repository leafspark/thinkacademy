package com.tal.app.thinkacademy.live.business.exercise;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@PluginAnnotation(desc = "填空题", liveType = 1, metaDataKey = {"fill_blank"}, moduleId = "224")
@ViewLevels({@ViewLevel(level = 10, name = "ExerciseBackPluginDriver")})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u001d\u001a\u00020\u0017R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBackPluginDriver;", "Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mClassId", "", "Ljava/lang/Integer;", "mCountDownTime", "mDestroyed", "", "mExercisePluginView", "Lcom/tal/app/thinkacademy/live/business/exercise/ExercisePluginView;", "mInteractId", "", "mPlanId", "mStuId", "mUserName", "getRealCountDownTime", "", "loadPluginView", "", "js", "onDestroy", "onMessage", "ircTypeKey", "message", "removeView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExerciseBackPluginDriver.kt */
public final class ExerciseBackPluginDriver extends ExerciseBasePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.EXERCISE;
    private Integer mClassId;
    private Integer mCountDownTime;
    private boolean mDestroyed;
    /* access modifiers changed from: private */
    public ExercisePluginView mExercisePluginView;
    private String mInteractId;
    private Integer mPlanId;
    private String mStuId;
    private String mUserName;

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r0 = (r0 = r2.getDataStorage()).getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExerciseBackPluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2, android.os.Bundle r3) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r3 = 0
            if (r2 != 0) goto L_0x0008
        L_0x0006:
            r0 = r3
            goto L_0x001e
        L_0x0008:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x000f
            goto L_0x0006
        L_0x000f:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x0016
            goto L_0x0006
        L_0x0016:
            int r0 = r0.getPlanId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x001e:
            r1.mPlanId = r0
            if (r2 != 0) goto L_0x0024
        L_0x0022:
            r0 = r3
            goto L_0x003a
        L_0x0024:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x0032
            goto L_0x0022
        L_0x0032:
            int r0 = r0.getClassId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x003a:
            r1.mClassId = r0
            if (r2 != 0) goto L_0x0040
        L_0x003e:
            r0 = r3
            goto L_0x0052
        L_0x0040:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x0047
            goto L_0x003e
        L_0x0047:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r0.getUserInfo()
            if (r0 != 0) goto L_0x004e
            goto L_0x003e
        L_0x004e:
            java.lang.String r0 = r0.getNickName()
        L_0x0052:
            r1.mUserName = r0
            if (r2 != 0) goto L_0x0057
            goto L_0x0069
        L_0x0057:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x005e
            goto L_0x0069
        L_0x005e:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r2 = r2.getUserInfo()
            if (r2 != 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            java.lang.String r3 = r2.getId()
        L_0x0069:
            r1.mStuId = r3
            java.lang.String r2 = "exercise_view_coins"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r2 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r2)
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver$special$$inlined$observe$1 r3 = new com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver$special$$inlined$observe$1
            r3.<init>(r1)
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            r0 = r1
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            r2.observe(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBackPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExerciseBackPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "回放"
            if (r10 != 0) goto L_0x0006
            goto L_0x00af
        L_0x0006:
            java.lang.String r1 = "fill_blank"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
            if (r1 == 0) goto L_0x00af
            r1 = 2
            r2 = 1
            r3 = 0
            r4 = r11
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0097 }
            if (r4 == 0) goto L_0x001f
            int r4 = r4.length()     // Catch:{ Exception -> 0x0097 }
            if (r4 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r4 = r3
            goto L_0x0020
        L_0x001f:
            r4 = r2
        L_0x0020:
            if (r4 != 0) goto L_0x00af
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0097 }
            r4.<init>(r11)     // Catch:{ Exception -> 0x0097 }
            org.json.JSONObject r10 = r4.optJSONObject(r10)     // Catch:{ Exception -> 0x0097 }
            if (r10 != 0) goto L_0x002f
            goto L_0x00af
        L_0x002f:
            java.lang.String r11 = "pub"
            boolean r11 = r10.optBoolean(r11)     // Catch:{ Exception -> 0x0097 }
            if (r11 == 0) goto L_0x0082
            com.tal.app.thinkacademy.live.Tag r11 = TAG     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11     // Catch:{ Exception -> 0x0097 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0097 }
            r4[r3] = r0     // Catch:{ Exception -> 0x0097 }
            java.lang.String r5 = "信令开启填空题"
            r4[r2] = r5     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r4)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r11 = "interactId"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0097 }
            r9.mInteractId = r11     // Catch:{ Exception -> 0x0097 }
            java.lang.String r11 = "countDownTime"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0097 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0097 }
            r9.mCountDownTime = r11     // Catch:{ Exception -> 0x0097 }
            java.lang.String r11 = "quesContent"
            java.lang.String r10 = r10.optString(r11)     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.live.business.exercise.InteractionJsBean r11 = new com.tal.app.thinkacademy.live.business.exercise.InteractionJsBean     // Catch:{ Exception -> 0x0097 }
            java.lang.String r4 = "interactionData"
            com.tal.app.thinkacademy.live.business.exercise.InteractionData r5 = new com.tal.app.thinkacademy.live.business.exercise.InteractionData     // Catch:{ Exception -> 0x0097 }
            long r6 = r9.getRealCountDownTime()     // Catch:{ Exception -> 0x0097 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r7 = r9.mStuId     // Catch:{ Exception -> 0x0097 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0097 }
            r5.<init>(r6, r10, r7, r8)     // Catch:{ Exception -> 0x0097 }
            r11.<init>(r4, r5)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r10 = com.tal.app.thinkacademy.lib.util.GsonUtils.toJson(r11)     // Catch:{ Exception -> 0x0097 }
            r9.loadPluginView(r10)     // Catch:{ Exception -> 0x0097 }
            goto L_0x00af
        L_0x0082:
            com.tal.app.thinkacademy.live.Tag r10 = TAG     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10     // Catch:{ Exception -> 0x0097 }
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0097 }
            r11[r3] = r0     // Catch:{ Exception -> 0x0097 }
            java.lang.String r4 = "信令关闭填空题"
            r11[r2] = r4     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r11)     // Catch:{ Exception -> 0x0097 }
            r10 = 0
            r9.removePlugin(r10)     // Catch:{ Exception -> 0x0097 }
            goto L_0x00af
        L_0x0097:
            r10 = move-exception
            com.tal.app.thinkacademy.live.Tag r11 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r0
            java.lang.String r10 = r10.getMessage()
            java.lang.String r0 = "信令处理异常:"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r10)
            r1[r2] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r11, r1)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    private final void loadPluginView(String str) {
        Context context;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null && (context = (Context) iLiveRoomProvider.getWeakRefContext().get()) != null) {
            BaseLivePluginView exercisePluginView = new ExercisePluginView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            removeView();
            exercisePluginView.setLiveType("回放");
            exercisePluginView.initLoadUrl(str);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, exercisePluginView, "ExerciseBackPluginDriver", LiveAreaContext.get().getPptLp().newLp());
            this.mExercisePluginView = exercisePluginView;
            exercisePluginView.setDriver(this);
            XesLog.i(TAG, "回放", "开始加载填空互动页面");
        }
    }

    private final long getRealCountDownTime() {
        Integer num = this.mCountDownTime;
        return ((long) (num == null ? 0 : num.intValue())) * 1000;
    }

    public final void removeView() {
        ExercisePluginView exercisePluginView = this.mExercisePluginView;
        if (exercisePluginView != null) {
            XesLog.i(TAG, "回放", "视图销毁");
            exercisePluginView.onDestroy();
            this.mLiveRoomProvider.removeView((View) exercisePluginView);
        }
        this.mExercisePluginView = null;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDestroyed = true;
        removeView();
    }
}
