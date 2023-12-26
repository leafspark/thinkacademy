package com.tal.app.thinkacademy.live.business.drawing;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent;
import com.tal.app.thinkacademy.live.business.photosonthewall.dialog.SubmitDialog;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002JA\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u00010.2\u0006\u00105\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u00106J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010.H\u0002J\b\u00109\u001a\u00020,H\u0002J\u0006\u0010:\u001a\u00020,J\b\u0010;\u001a\u00020,H\u0002J\b\u0010<\u001a\u00020,H\u0002J\u0011\u0010=\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020,H\u0002J\b\u0010A\u001a\u00020,H\u0002J\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\b\u0010D\u001a\u00020,H\u0002J#\u0010E\u001a\u00020,2\u0016\u0010F\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010H0G\"\u0004\u0018\u00010H¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020,H\u0016J\u001c\u0010K\u001a\u00020,2\b\u0010L\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010M\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020,H\u0002J\b\u0010O\u001a\u00020,H\u0002J\u000e\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020RJ\b\u0010S\u001a\u00020,H\u0002J\b\u0010T\u001a\u00020,H\u0002J\u0006\u0010U\u001a\u00020,J\u0018\u0010V\u001a\u00020,2\u0006\u0010W\u001a\u0002012\u0006\u0010X\u001a\u000201H\u0002J\u0018\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "context", "Landroid/content/Context;", "courseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "graffitiBean", "Lcom/tal/app/thinkacademy/live/business/drawing/GraffitiBean;", "graffitiView", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginView;", "isHandUp", "", "isRevise", "isSubmit", "isSubmitting", "isSync", "mCoursewareRatio", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "mGraffitiDrawAgent", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiDrawAgent;", "getMLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setMLiveRoomProvider", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mSubmitDialog", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitDialog;", "mWatchJSONObject", "Lorg/json/JSONObject;", "planInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/PlanInfoProxy;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools;", "teacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "analyzingMessage", "", "message", "", "aswSuccess", "planId", "", "classId", "tutorId", "interactId", "photoPath", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awsOnError", "msg", "closeStatus", "destroyPlugin", "destroyPluginGraffitiView", "destroyPluginView", "encodedViewCache", "Ljava/io/File;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRealCountDownTime", "handsup", "hideSubmitDialog", "initEngine", "initPluginView", "log", "contents", "", "", "([Ljava/lang/Object;)V", "onDestroy", "onMessage", "ircTypeKey", "pubPlugin", "realSubmit", "requestOpenStatus", "setDrawTools", "tools", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "setTeacherLook", "showSubmitDialog", "submit", "updateProgress", "bytesCurrent", "bytesTotal", "updateUserCoins", "userCoins", "", "addCoins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "涂鸦小黑板", ircType = {"graffiti_board", "mode", "graffiti_board_watching"}, moduleId = "337", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "DrawPluginDriver"), @ViewLevel(level = 41, name = "DrawPluginDriverTools")})
/* compiled from: DrawPluginDriver.kt */
public final class DrawPluginDriver extends BaseLivePluginDriver {
    private Bundle bundle;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public CourseInfoProxy courseInfo = this.mLiveRoomProvider.getDataStorage().getCourseInfo();
    /* access modifiers changed from: private */
    public GraffitiBean graffitiBean;
    private DrawPluginView graffitiView;
    /* access modifiers changed from: private */
    public boolean isHandUp;
    private boolean isRevise;
    /* access modifiers changed from: private */
    public boolean isSubmit;
    /* access modifiers changed from: private */
    public boolean isSubmitting;
    private boolean isSync;
    private final LiveAreaCompat.CourseRate mCoursewareRatio;
    /* access modifiers changed from: private */
    public GraffitiDrawAgent mGraffitiDrawAgent;
    private ILiveRoomProvider mLiveRoomProvider;
    private SubmitDialog mSubmitDialog;
    private JSONObject mWatchJSONObject;
    private PlanInfoProxy planInfo = this.mLiveRoomProvider.getDataStorage().getPlanInfo();
    /* access modifiers changed from: private */
    public DrawPluginViewTools pluginView;
    private TeacherInfo teacherInfo = this.mLiveRoomProvider.getDataStorage().getTeacherInfo();

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final ILiveRoomProvider getMLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    public final void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public final void setMLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle2) {
        super(iLiveRoomProvider, bundle2);
        RoomData roomData;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.bundle = bundle2;
        this.context = (Context) iLiveRoomProvider.getWeakRefContext().get();
        DataStorage dataStorage = this.mLiveRoomProvider.getDataStorage();
        LiveAreaCompat.CourseRate courseRate = null;
        if (!(dataStorage == null || (roomData = dataStorage.getRoomData()) == null)) {
            courseRate = roomData.getCourseRate();
        }
        this.mCoursewareRatio = courseRate == null ? LiveAreaCompat.CourseRate.RATE_4_3 : courseRate;
        XesDataBus.with(DataBusKey.TAKE_DRAW_STATE).observe((LifecycleOwner) this, new DrawPluginDriver$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m208_init_$lambda0(DrawPluginDriver drawPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(drawPluginDriver, "this$0");
        drawPluginDriver.destroyPlugin();
    }

    public void onMessage(String str, String str2) {
        if (Intrinsics.areEqual("graffiti_board", str)) {
            if (str2 != null) {
                log(Intrinsics.stringPlus("小黑板信令 => ", str2));
                analyzingMessage(str2);
                GraffitiBean graffitiBean2 = this.graffitiBean;
                if (graffitiBean2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean2 = null;
                }
                Boolean pub = graffitiBean2.getPub();
                if (pub != null) {
                    boolean booleanValue = pub.booleanValue();
                    if (booleanValue && !this.isRevise) {
                        requestOpenStatus();
                    } else if (!booleanValue || !this.isRevise) {
                        closeStatus();
                    } else {
                        pubPlugin();
                    }
                }
            }
        } else if (Intrinsics.areEqual("graffiti_board_watching", str) && str2 != null) {
            log(Intrinsics.stringPlus("收到老师浏览信令 => ", str2));
            this.mWatchJSONObject = new JSONObject(str2).optJSONObject("graffiti_board_watching");
            setTeacherLook();
        }
    }

    private final void setTeacherLook() {
        boolean z;
        if (this.mGraffitiDrawAgent != null) {
            JSONObject jSONObject = this.mWatchJSONObject;
            String str = null;
            String optString = jSONObject == null ? null : jSONObject.optString("studentId");
            JSONObject jSONObject2 = this.mWatchJSONObject;
            String optString2 = jSONObject2 == null ? null : jSONObject2.optString("interactionId");
            GraffitiBean graffitiBean2 = this.graffitiBean;
            if (graffitiBean2 != null) {
                if (graffitiBean2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean2 = null;
                }
                z = Intrinsics.areEqual(optString2, graffitiBean2.getInteractId());
            } else {
                z = false;
            }
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            if (userInfoEntity != null) {
                str = userInfoEntity.getUid();
            }
            boolean z2 = Intrinsics.areEqual(optString, str) && z;
            Object[] objArr = new Object[1];
            objArr[0] = z2 ? "老师正在看我" : "老师不看我了";
            log(objArr);
            GraffitiDrawAgent graffitiDrawAgent = this.mGraffitiDrawAgent;
            if (graffitiDrawAgent != null) {
                graffitiDrawAgent.setLook(z2);
            }
            DrawPluginView drawPluginView = this.graffitiView;
            if (drawPluginView != null) {
                drawPluginView.setTeacherLook(z2);
            }
        }
    }

    private final void requestOpenStatus() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new DrawPluginDriver$requestOpenStatus$1()), (CoroutineStart) null, new DrawPluginDriver$requestOpenStatus$2(this, (Continuation<? super DrawPluginDriver$requestOpenStatus$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void pubPlugin() {
        initEngine();
        initPluginView();
        GraffitiBean graffitiBean2 = this.graffitiBean;
        GraffitiBean graffitiBean3 = null;
        if (graffitiBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean2 = null;
        }
        InteractReportKt.XesLogReport$default("start", "draw", graffitiBean2.getInteractId(), (Integer) null, (String) null, 24, (Object) null);
        GraffitiBean graffitiBean4 = this.graffitiBean;
        if (graffitiBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
        } else {
            graffitiBean3 = graffitiBean4;
        }
        String interactId = graffitiBean3.getInteractId();
        CourseInfoProxy courseInfoProxy = this.courseInfo;
        int i = 0;
        int planId = courseInfoProxy == null ? 0 : courseInfoProxy.getPlanId();
        CourseInfoProxy courseInfoProxy2 = this.courseInfo;
        if (courseInfoProxy2 != null) {
            i = courseInfoProxy2.getClassId();
        }
        InteractLogReport.uploadLog(interactId, planId, i);
    }

    private final void closeStatus() {
        GraffitiBean graffitiBean2 = this.graffitiBean;
        GraffitiBean graffitiBean3 = null;
        if (graffitiBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean2 = null;
        }
        if (graffitiBean2.isEnd()) {
            destroyPlugin();
            return;
        }
        if (this.isSync) {
            GraffitiDrawAgent graffitiDrawAgent = this.mGraffitiDrawAgent;
            if (graffitiDrawAgent != null) {
                graffitiDrawAgent.setTouchAble(false);
            }
            realSubmit();
        } else {
            if (!this.isSubmit) {
                GraffitiBean graffitiBean4 = this.graffitiBean;
                if (graffitiBean4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean4 = null;
                }
                if (!graffitiBean4.isRevise()) {
                    GraffitiDrawAgent graffitiDrawAgent2 = this.mGraffitiDrawAgent;
                    if (graffitiDrawAgent2 != null) {
                        graffitiDrawAgent2.setTouchAble(false);
                    }
                    DrawPluginViewTools drawPluginViewTools = this.pluginView;
                    if (drawPluginViewTools != null) {
                        drawPluginViewTools.showFailed();
                    }
                }
            }
            if (!this.isRevise) {
                GraffitiDrawAgent graffitiDrawAgent3 = this.mGraffitiDrawAgent;
                if (graffitiDrawAgent3 != null) {
                    graffitiDrawAgent3.setTouchAble(false);
                }
                destroyPlugin();
            }
        }
        ShareDataManager.getInstance().put(ShareDataKey.IS_TAKE_DRAW, false, ShareDataManager.SHAREDATA_CAN_CLEAR);
        GraffitiBean graffitiBean5 = this.graffitiBean;
        if (graffitiBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
        } else {
            graffitiBean3 = graffitiBean5;
        }
        InteractReportKt.XesLogReport$default("end", "draw", graffitiBean3.getInteractId(), (Integer) null, (String) null, 24, (Object) null);
    }

    private final void initEngine() {
        Context context2 = this.context;
        if (context2 != null) {
            ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
            Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider, "mLiveRoomProvider");
            GraffitiDrawAgent graffitiDrawAgent = new GraffitiDrawAgent(context2, (BaseLivePluginDriver) this, iLiveRoomProvider);
            this.mGraffitiDrawAgent = graffitiDrawAgent;
            StringBuilder sb = new StringBuilder();
            CourseInfoProxy courseInfoProxy = this.courseInfo;
            String str = null;
            sb.append(courseInfoProxy == null ? null : Integer.valueOf(courseInfoProxy.getBizId()));
            sb.append('_');
            PlanInfoProxy planInfoProxy = this.planInfo;
            sb.append(planInfoProxy == null ? null : planInfoProxy.getId());
            sb.append('_');
            TeacherInfo teacherInfo2 = this.teacherInfo;
            if (teacherInfo2 != null) {
                str = teacherInfo2.getId();
            }
            sb.append(str);
            graffitiDrawAgent.initGraffiti(sb.toString(), this.isSync);
        }
    }

    private final void initPluginView() {
        Context context2 = this.context;
        if (context2 != null) {
            if (this.graffitiView != null) {
                destroyPluginGraffitiView();
            }
            BaseLivePluginView drawPluginView = new DrawPluginView(context2);
            this.graffitiView = drawPluginView;
            drawPluginView.setCanvasView(this.mGraffitiDrawAgent);
            GraffitiDrawAgent graffitiDrawAgent = this.mGraffitiDrawAgent;
            if (graffitiDrawAgent != null) {
                GraffitiBean graffitiBean2 = this.graffitiBean;
                if (graffitiBean2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean2 = null;
                }
                graffitiDrawAgent.setBackground(graffitiBean2.getImageUrl());
            }
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, drawPluginView, this.mPluginConfData.getViewLevel("DrawPluginDriver"), LiveAreaCompat.pptCenterLp(this.mCoursewareRatio, false).newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new DrawPluginDriver$$ExternalSyntheticLambda1(drawPluginView, this));
            if (this.pluginView != null) {
                destroyPluginView();
            }
            BaseLivePluginView drawPluginViewTools = new DrawPluginViewTools(context2);
            this.pluginView = drawPluginViewTools;
            drawPluginViewTools.setDriver(this);
            GraffitiBean graffitiBean3 = this.graffitiBean;
            if (graffitiBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                graffitiBean3 = null;
            }
            drawPluginViewTools.setBean(graffitiBean3);
            drawPluginViewTools.initDefaultTools();
            GraffitiDrawAgent graffitiDrawAgent2 = this.mGraffitiDrawAgent;
            if (graffitiDrawAgent2 != null) {
                GraffitiBean graffitiBean4 = this.graffitiBean;
                if (graffitiBean4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean4 = null;
                }
                graffitiDrawAgent2.setBackground(graffitiBean4.getImageUrl());
            }
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, drawPluginViewTools, this.mPluginConfData.getViewLevel("DrawPluginDriverTools"), LiveAreaCompat.pptCenterLp(this.mCoursewareRatio).newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new DrawPluginDriver$$ExternalSyntheticLambda2(drawPluginViewTools, this));
            if (this.isSync) {
                GraffitiBean graffitiBean5 = this.graffitiBean;
                if (graffitiBean5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    graffitiBean5 = null;
                }
                if (!(graffitiBean5.getDbkey().length() == 0)) {
                    if (this.isHandUp) {
                        drawPluginViewTools.showHandsUpView(0, 0);
                    }
                    GraffitiDrawAgent graffitiDrawAgent3 = this.mGraffitiDrawAgent;
                    if (graffitiDrawAgent3 != null) {
                        StringBuilder sb = new StringBuilder();
                        GraffitiBean graffitiBean6 = this.graffitiBean;
                        if (graffitiBean6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                            graffitiBean6 = null;
                        }
                        sb.append(graffitiBean6.getDbkey());
                        sb.append('#');
                        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                        sb.append(userInfoEntity == null ? null : userInfoEntity.getUid());
                        graffitiDrawAgent3.turnPageTo(sb.toString(), 1);
                    }
                    GraffitiBean graffitiBean7 = this.graffitiBean;
                    if (graffitiBean7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                        graffitiBean7 = null;
                    }
                    List split$default = StringsKt.split$default(graffitiBean7.getDbkey(), new String[]{"_"}, false, 0, 6, (Object) null);
                    if (split$default.size() > 1) {
                        GraffitiDrawAgent graffitiDrawAgent4 = this.mGraffitiDrawAgent;
                        if (graffitiDrawAgent4 != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((String) split$default.get(split$default.size() - 1));
                            sb2.append('#');
                            UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                            sb2.append(userInfoEntity2 == null ? null : userInfoEntity2.getUid());
                            graffitiDrawAgent4.setPageId(sb2.toString());
                        }
                        GraffitiDrawAgent graffitiDrawAgent5 = this.mGraffitiDrawAgent;
                        if (graffitiDrawAgent5 != null) {
                            graffitiDrawAgent5.setCourseId((String) split$default.get(split$default.size() - 2));
                        }
                    }
                    GraffitiBean graffitiBean8 = this.graffitiBean;
                    if (graffitiBean8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                        graffitiBean8 = null;
                    }
                    StringsKt.substringAfterLast$default(graffitiBean8.getDbkey(), "_", (String) null, 2, (Object) null);
                    setTeacherLook();
                    return;
                }
            }
            GraffitiDrawAgent graffitiDrawAgent6 = this.mGraffitiDrawAgent;
            if (graffitiDrawAgent6 != null) {
                graffitiDrawAgent6.setTouchAble(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPluginView$lambda-14$lambda-9$lambda-8  reason: not valid java name */
    public static final void m210initPluginView$lambda14$lambda9$lambda8(DrawPluginView drawPluginView, DrawPluginDriver drawPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(drawPluginView, "$pluginView");
        Intrinsics.checkNotNullParameter(drawPluginDriver, "this$0");
        ViewGroup.LayoutParams layoutParams = drawPluginView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            LiveAreaCompat.pptCenterLp(drawPluginDriver.mCoursewareRatio).mergeLp(layoutParams2);
            drawPluginView.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPluginView$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m209initPluginView$lambda14$lambda13$lambda12(DrawPluginViewTools drawPluginViewTools, DrawPluginDriver drawPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "$pluginView");
        Intrinsics.checkNotNullParameter(drawPluginDriver, "this$0");
        ViewGroup.LayoutParams layoutParams = drawPluginViewTools.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            LiveAreaCompat.pptCenterLp(drawPluginDriver.mCoursewareRatio).mergeLp(layoutParams2);
            drawPluginViewTools.setLayoutParams(layoutParams2);
        }
    }

    private final void analyzingMessage(String str) {
        JSONObject jSONObject = new JSONObject(str).getJSONObject("graffiti_board");
        String optString = jSONObject.optString("interactId");
        boolean optBoolean = jSONObject.optBoolean("pub");
        int optInt = jSONObject.optInt("totalTime");
        long optLong = jSONObject.optLong("beginTime");
        String optString2 = jSONObject.optString("imageUrl");
        long optLong2 = jSONObject.optLong("planId");
        String optString3 = jSONObject.optString("extra", "");
        String optString4 = jSONObject.optString("dbkey", "");
        boolean optBoolean2 = jSONObject.optBoolean("isEnd", false);
        if (!this.isRevise && !TextUtils.isEmpty(optString3)) {
            this.isRevise = true;
        }
        if (!this.isSync) {
            Intrinsics.checkNotNullExpressionValue(optString4, "dbkey");
            this.isSync = !StringsKt.isBlank(optString4);
        }
        Boolean valueOf = Boolean.valueOf(optBoolean);
        Integer valueOf2 = Integer.valueOf(optInt);
        Long valueOf3 = Long.valueOf(optLong);
        Long valueOf4 = Long.valueOf(optLong2);
        boolean z = this.isRevise;
        Intrinsics.checkNotNullExpressionValue(optString4, "dbkey");
        this.graffitiBean = new GraffitiBean(optString, valueOf, valueOf2, valueOf3, optString2, valueOf4, 0, z, optString4, optBoolean2);
        ShareDataManager.getInstance().put(ShareDataKey.CURRENT_INTERACT_ID, optString, ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().put(ShareDataKey.CURRENT_INTERACT_BG, optString2, ShareDataManager.SHAREDATA_NOT_CLEAR);
        getRealCountDownTime();
    }

    private final void getRealCountDownTime() {
        GraffitiBean graffitiBean2 = this.graffitiBean;
        GraffitiBean graffitiBean3 = null;
        if (graffitiBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean2 = null;
        }
        Integer totalTime = graffitiBean2.getTotalTime();
        if (totalTime != null && totalTime.intValue() == -1) {
            GraffitiBean graffitiBean4 = this.graffitiBean;
            if (graffitiBean4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            } else {
                graffitiBean3 = graffitiBean4;
            }
            graffitiBean3.setRealCountDownTime(0);
            return;
        }
        GraffitiBean graffitiBean5 = this.graffitiBean;
        if (graffitiBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean5 = null;
        }
        Integer totalTime2 = graffitiBean5.getTotalTime();
        GraffitiBean graffitiBean6 = this.graffitiBean;
        if (graffitiBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean6 = null;
        }
        Long beginTime = graffitiBean6.getBeginTime();
        long serveNowTime = this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
        if (beginTime != null) {
            long longValue = serveNowTime - (beginTime.longValue() / ((long) 1000));
            if (totalTime2 != null) {
                long intValue = (long) totalTime2.intValue();
                int min = (int) Math.min(intValue - longValue, intValue);
                if (min > 1) {
                    GraffitiBean graffitiBean7 = this.graffitiBean;
                    if (graffitiBean7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                    } else {
                        graffitiBean3 = graffitiBean7;
                    }
                    graffitiBean3.setRealCountDownTime(min);
                    return;
                }
                GraffitiBean graffitiBean8 = this.graffitiBean;
                if (graffitiBean8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                } else {
                    graffitiBean3 = graffitiBean8;
                }
                graffitiBean3.setRealCountDownTime(0);
            }
        }
    }

    public final void setDrawTools(DrawTools drawTools) {
        Intrinsics.checkNotNullParameter(drawTools, "tools");
        GraffitiDrawAgent graffitiDrawAgent = this.mGraffitiDrawAgent;
        if (graffitiDrawAgent != null) {
            graffitiDrawAgent.setDrawTools(drawTools);
        }
    }

    public final void submit() {
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        GraffitiBean graffitiBean2 = this.graffitiBean;
        if (graffitiBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            graffitiBean2 = null;
        }
        String interactId = graffitiBean2.getInteractId();
        if (interactId == null) {
            interactId = "";
        }
        hWEventTracking.ostaIaGraffitiboardSubmit(interactId);
        if (this.isSync) {
            handsup();
        } else {
            realSubmit();
        }
    }

    private final void realSubmit() {
        if (this.pluginView != null && !this.isSubmitting) {
            this.isSubmitting = true;
            CourseInfoProxy courseInfoProxy = this.courseInfo;
            Long valueOf = courseInfoProxy == null ? null : Long.valueOf((long) courseInfoProxy.getPlanId());
            CourseInfoProxy courseInfoProxy2 = this.courseInfo;
            Long valueOf2 = courseInfoProxy2 == null ? null : Long.valueOf((long) courseInfoProxy2.getClassId());
            CourseInfoProxy courseInfoProxy3 = this.courseInfo;
            Long valueOf3 = courseInfoProxy3 == null ? null : Long.valueOf((long) courseInfoProxy3.getTutorId());
            GraffitiBean graffitiBean2 = this.graffitiBean;
            if (graffitiBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
                graffitiBean2 = null;
            }
            String interactId = graffitiBean2.getInteractId();
            if (this.mSubmitDialog == null) {
                this.mSubmitDialog = new SubmitDialog(this.context, (Function0) null, 2, (DefaultConstructorMarker) null);
            }
            showSubmitDialog();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new DrawPluginDriver$realSubmit$1(this)), (CoroutineStart) null, new DrawPluginDriver$realSubmit$2(this, valueOf, valueOf2, valueOf3, interactId, (Continuation<? super DrawPluginDriver$realSubmit$2>) null), 2, (Object) null);
        }
    }

    private final void handsup() {
        log("举手");
        CourseInfoProxy courseInfoProxy = this.courseInfo;
        GraffitiBean graffitiBean2 = null;
        Long valueOf = courseInfoProxy == null ? null : Long.valueOf((long) courseInfoProxy.getPlanId());
        CourseInfoProxy courseInfoProxy2 = this.courseInfo;
        Long valueOf2 = courseInfoProxy2 == null ? null : Long.valueOf((long) courseInfoProxy2.getClassId());
        CourseInfoProxy courseInfoProxy3 = this.courseInfo;
        Long valueOf3 = courseInfoProxy3 == null ? null : Long.valueOf((long) courseInfoProxy3.getTutorId());
        GraffitiBean graffitiBean3 = this.graffitiBean;
        if (graffitiBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
        } else {
            graffitiBean2 = graffitiBean3;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new DrawPluginDriver$handsup$1(this)), (CoroutineStart) null, new DrawPluginDriver$handsup$2(valueOf, valueOf2, valueOf3, graffitiBean2.getInteractId(), this, (Continuation<? super DrawPluginDriver$handsup$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object aswSuccess(java.lang.Long r23, java.lang.Long r24, java.lang.Long r25, java.lang.String r26, java.lang.String r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            r22 = this;
            r0 = r22
            r1 = r28
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$aswSuccess$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$aswSuccess$1 r2 = (com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$aswSuccess$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$aswSuccess$1 r2 = new com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$aswSuccess$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 2
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x004d
            if (r4 == r8) goto L_0x0040
            if (r4 != r6) goto L_0x0038
            java.lang.Object r2 = r2.L$0
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r2 = (com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00e4
        L_0x0038:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0040:
            java.lang.Object r4 = r2.L$1
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            java.lang.Object r9 = r2.L$0
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r9 = (com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver) r9
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00d4
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r4 = "aswSuccess"
            r1[r5] = r4
            java.lang.String r4 = "photoPath--> "
            r14 = r27
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r14)
            r1[r8] = r4
            r0.log(r1)
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r1 = r0.graffitiBean
            if (r1 != 0) goto L_0x006d
            java.lang.String r1 = "graffitiBean"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r7
        L_0x006d:
            java.lang.String r17 = r1.getInteractId()
            java.lang.Integer r18 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r19 = 0
            r20 = 16
            r21 = 0
            java.lang.String r15 = "uploadImage"
            java.lang.String r16 = "Photopost"
            com.tal.app.thinkacademy.live.util.InteractReportKt.XesLogReport$default(r15, r16, r17, r18, r19, r20, r21)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r1 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r1 = r1.getOverseaApi()
            java.lang.String r4 = "/classroom-hub/wall/student/submit"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r4)
            com.tal.app.thinkacademy.live.business.drawing.ParamsBean r4 = new com.tal.app.thinkacademy.live.business.drawing.ParamsBean
            boolean r9 = r0.isSync
            if (r9 == 0) goto L_0x0098
            r9 = 722(0x2d2, float:1.012E-42)
            r15 = r9
            goto L_0x0099
        L_0x0098:
            r15 = r5
        L_0x0099:
            com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo r9 = r0.teacherInfo
            if (r9 != 0) goto L_0x00a0
        L_0x009d:
            r16 = r7
            goto L_0x00ad
        L_0x00a0:
            java.lang.String r9 = r9.getId()
            if (r9 != 0) goto L_0x00a7
            goto L_0x009d
        L_0x00a7:
            java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r9)
            r16 = r9
        L_0x00ad:
            r9 = r4
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.drawing.DrawApi> r10 = com.tal.app.thinkacademy.live.business.drawing.DrawApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10)
            com.tal.app.thinkacademy.live.business.drawing.DrawApi r10 = (com.tal.app.thinkacademy.live.business.drawing.DrawApi) r10
            r2.L$0 = r0
            r2.L$1 = r9
            r2.label = r8
            java.lang.Object r1 = r10.drawSubmit(r1, r4, r2)
            if (r1 != r3) goto L_0x00d2
            return r3
        L_0x00d2:
            r4 = r9
            r9 = r0
        L_0x00d4:
            com.tal.app.thinkacademy.lib.restful.HiResponse r1 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r1
            r2.L$0 = r9
            r2.L$1 = r7
            r2.label = r6
            java.lang.Object r1 = r4.transform(r1, r2)
            if (r1 != r3) goto L_0x00e3
            return r3
        L_0x00e3:
            r2 = r9
        L_0x00e4:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult r1 = (com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult) r1
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.String r4 = "submit接口请求success; data = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r1)
            r3[r5] = r4
            r2.log(r3)
            r2.hideSubmitDialog()
            r2.isSubmit = r8
            boolean r3 = r2.isRevise
            if (r3 != 0) goto L_0x0120
            boolean r3 = r2.isSync
            if (r3 != 0) goto L_0x0120
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginViewTools r2 = r2.pluginView
            if (r2 != 0) goto L_0x0105
            goto L_0x0123
        L_0x0105:
            if (r1 != 0) goto L_0x0109
            r3 = r7
            goto L_0x0111
        L_0x0109:
            int r3 = r1.getUserLatestCoin()
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
        L_0x0111:
            if (r1 != 0) goto L_0x0114
            goto L_0x011c
        L_0x0114:
            int r1 = r1.getRightCoin()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
        L_0x011c:
            r2.showResult(r3, r7)
            goto L_0x0123
        L_0x0120:
            r2.destroyPlugin()
        L_0x0123:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver.aswSuccess(java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateProgress(long j, long j2) {
        SubmitDialog submitDialog = this.mSubmitDialog;
        if (submitDialog != null) {
            submitDialog.updateProgress(((int) (j / j2)) * 100);
        }
    }

    /* access modifiers changed from: private */
    public final Object encodedViewCache(Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DrawPluginDriver$encodedViewCache$2(this, (Continuation<? super DrawPluginDriver$encodedViewCache$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final void awsOnError(String str) {
        this.isSubmitting = false;
        ToastUtils.showShort(str, new Object[0]);
        hideSubmitDialog();
    }

    private final void showSubmitDialog() {
        SubmitDialog submitDialog = this.mSubmitDialog;
        if (submitDialog != null && !submitDialog.isShowing()) {
            submitDialog.updateProgress(0);
            submitDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void hideSubmitDialog() {
        SubmitDialog submitDialog = this.mSubmitDialog;
        if (submitDialog != null && submitDialog.isShowing()) {
            submitDialog.dismiss();
        }
    }

    private final void updateUserCoins(int i, int i2) {
        DataStorage dataStorage;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        UserInfoProxy userInfoProxy = null;
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null)) {
            userInfoProxy = dataStorage.getUserInfo();
        }
        if (userInfoProxy != null) {
            userInfoProxy.setGoldNum(i);
        }
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(DrawPluginDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(i), new CoinEventData(GoldSource.DRAW_GOLD, i2, false, false, 12, (DefaultConstructorMarker) null)));
    }

    private final void destroyPluginView() {
        DrawPluginViewTools drawPluginViewTools = this.pluginView;
        if (drawPluginViewTools != null) {
            drawPluginViewTools.destroy();
            this.mLiveRoomProvider.removeView((View) drawPluginViewTools);
        }
        this.pluginView = null;
    }

    private final void destroyPluginGraffitiView() {
        DrawPluginView drawPluginView = this.graffitiView;
        if (drawPluginView != null) {
            drawPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) drawPluginView);
        }
        this.graffitiView = null;
    }

    public final void destroyPlugin() {
        this.isSubmitting = false;
        destroyPluginView();
        destroyPluginGraffitiView();
        destroy();
    }

    public void onDestroy() {
        this.isHandUp = false;
        this.isSubmit = false;
        this.isRevise = false;
        this.isSubmitting = false;
        destroyPluginView();
        destroyPluginGraffitiView();
        GraffitiDrawAgent graffitiDrawAgent = this.mGraffitiDrawAgent;
        if (graffitiDrawAgent != null) {
            graffitiDrawAgent.destroy();
        }
        this.mGraffitiDrawAgent = null;
    }

    public final void log(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "contents");
        XesLog.i(Tag.GRAFFITI_DRAW_BOARD, Arrays.copyOf(objArr, objArr.length));
    }
}
