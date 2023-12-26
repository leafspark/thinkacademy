package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.lib.utils.HWCoroutineScopeKt;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository;
import com.tal.app.thinkacademy.live.business.drawing.DrawUtils;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.tborad.extensions.rule.CompassesExtension;
import com.xueersi.tborad.extensions.rule.ProtractorRulerExtension;
import com.xueersi.tborad.extensions.rule.RulerExtension;
import com.xueersi.tborad.extensions.rule.TriangularRulerExtension;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J&\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010J\u001a\u00020@2\b\b\u0002\u0010K\u001a\u00020\nJ\b\u0010L\u001a\u00020@H\u0016J\b\u0010M\u001a\u0004\u0018\u00010NJ\b\u0010O\u001a\u0004\u0018\u00010\u0016J\u0014\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\nH&J\b\u0010R\u001a\u00020@H\u0004J\u0010\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\nH\u0016J'\u0010U\u001a\b\u0012\u0004\u0012\u00020W0V2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010X\u001a\u00020(H¦@ø\u0001\u0000¢\u0006\u0002\u0010YJ/\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0V2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020]H@ø\u0001\u0000¢\u0006\u0002\u0010^J#\u0010_\u001a\u00020@2\u0016\u0010`\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010a\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010bJ\u0012\u0010c\u001a\u00020@2\b\u0010d\u001a\u0004\u0018\u00010\nH&J\u001a\u0010e\u001a\u00020@2\u0006\u0010d\u001a\u00020\n2\b\b\u0001\u0010f\u001a\u00020]H&J\u0010\u0010g\u001a\u00020@2\b\u0010h\u001a\u0004\u0018\u00010WJ$\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020\n2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(0lH\u0004J\u0010\u0010m\u001a\u00020@2\b\u0010n\u001a\u0004\u0018\u00010\nJE\u0010o\u001a\u00020@2=\u0010p\u001a9\u0012\u0013\u0012\u00110\n¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(j\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0004\u0012\u00020W\u0018\u00010V\u0018\u00010t\u0012\u0004\u0012\u00020@0qJ\u0010\u0010u\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010\nJ\u0010\u0010w\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010\nJ)\u0010x\u001a\u00020@2!\u0010y\u001a\u001d\u0012\u0013\u0012\u00110W¢\u0006\f\br\u0012\b\bs\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020@0zJ\u000e\u0010{\u001a\u00020@2\u0006\u0010|\u001a\u00020\"J\u0012\u0010}\u001a\u00020@2\b\u0010h\u001a\u0004\u0018\u00010WH\u0004J\u001a\u0010~\u001a\u00020@2\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010VH\u0004J&\u0010\u0001\u001a\u00020@2\u0006\u0010n\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\nH\u0002J\u0019\u0010\u0001\u001a\u00020@2\u0006\u0010d\u001a\u00020\n2\b\b\u0001\u0010f\u001a\u00020]J;\u0010\u0001\u001a\u00020@2\u0006\u0010d\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\nH\u0002J7\u0010\u0001\u001a\u00020@2\u0006\u0010d\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020]2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(0lH\u0002R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u00106R\u0016\u00107\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\fR\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\fR\u0016\u0010=\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent;", "", "mContext", "Landroid/content/Context;", "mDriver", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canvasRepository", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/http/CanvasRepository;", "graffitiCallback", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiCallback;", "getGraffitiCallback", "()Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiCallback;", "setGraffitiCallback", "(Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiCallback;)V", "mCanvasView", "Landroid/view/View;", "getMContext", "()Landroid/content/Context;", "getMDriver", "()Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mGraffitiEngine", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngineImpl;", "getMGraffitiEngine", "()Lcom/xueersi/lib/graffiti/WXTGraffitiEngineImpl;", "setMGraffitiEngine", "(Lcom/xueersi/lib/graffiti/WXTGraffitiEngineImpl;)V", "mIsOffline", "", "getMIsOffline", "()Z", "setMIsOffline", "(Z)V", "mLastSendMsgId", "", "getMLastSendMsgId", "()J", "setMLastSendMsgId", "(J)V", "getMLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "mLogTag", "Lcom/tal/app/thinkacademy/live/Tag;", "mMode", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/Mode;", "mPageKey", "getMPageKey", "setMPageKey", "(Ljava/lang/String;)V", "mPlanId", "getMPlanId", "mScopeHistory", "Lkotlinx/coroutines/CoroutineScope;", "mTeacherUid", "getMTeacherUid", "mUid", "getMUid", "bindCanvasView", "", "view", "Landroid/view/ViewGroup;", "bindPluginView", "pluginView", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "rateType", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "withCourse", "levelKey", "cancel", "info", "destroy", "getCanvasBitmap", "Landroid/graphics/Bitmap;", "getCanvasView", "getPageKeyByDBKey", "dbkey", "initExtent", "initGraffiti", "specifKey", "loadHistoryMsg", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "lastMsgId", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHistoryMsgFromNet", "startMsgId", "pageNum", "", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "contents", "", "([Ljava/lang/Object;)V", "onHistoryLoaded", "pageKey", "onTurnPage", "style", "printAction", "action", "requestHistoryMsg", "pageId", "params", "", "setBackground", "url", "setBaseListener", "callbackDB", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "setCourseId", "id", "setPageId", "setSendListener", "callback", "Lkotlin/Function1;", "setTouchAble", "touchAble", "syncAddAction", "syncAddActionList", "actionList", "throwHistoryLoadException", "body", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;", "msg", "turnPageTo", "upLoadHistoryException", "upLoadHistoryTime", "time", "size", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public abstract class GraffitiAgent {
    private final String TAG = "涂鸦";
    private final CanvasRepository canvasRepository;
    private GraffitiCallback graffitiCallback;
    private View mCanvasView;
    private final Context mContext;
    private final BaseLivePluginDriver mDriver;
    private WXTGraffitiEngineImpl mGraffitiEngine;
    private boolean mIsOffline;
    private volatile long mLastSendMsgId;
    private final ILiveRoomProvider mLiveRoomProvider;
    private Tag mLogTag;
    /* access modifiers changed from: private */
    public Mode mMode;
    private String mPageKey;
    private final String mPlanId;
    private CoroutineScope mScopeHistory;
    private final String mTeacherUid;
    private final String mUid;

    public abstract String getPageKeyByDBKey(String str);

    public abstract Object loadHistoryMsg(String str, long j, Continuation<? super List<? extends WXWBAction>> continuation);

    public abstract void onHistoryLoaded(String str);

    public abstract void onTurnPage(String str, @WXTGraffitiEngine.TurnPageStyle int i);

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0025, code lost:
        r2 = r2.getTeacherInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GraffitiAgent(android.content.Context r2, com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r3, com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4) {
        /*
            r1 = this;
            java.lang.String r0 = "mContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mDriver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "mLiveRoomProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r1.<init>()
            r1.mContext = r2
            r1.mDriver = r3
            r1.mLiveRoomProvider = r4
            java.lang.String r2 = "涂鸦"
            r1.TAG = r2
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r4.getDataStorage()
            r3 = 0
            if (r2 != 0) goto L_0x0025
        L_0x0023:
            r2 = r3
            goto L_0x0030
        L_0x0025:
            com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo r2 = r2.getTeacherInfo()
            if (r2 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            java.lang.String r2 = r2.getId()
        L_0x0030:
            r1.mTeacherUid = r2
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r2 = r2.getUserInfoEntity()
            if (r2 != 0) goto L_0x0040
            r2 = r3
            goto L_0x0044
        L_0x0040:
            java.lang.String r2 = r2.getUid()
        L_0x0044:
            r1.mUid = r2
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r4.getDataStorage()
            if (r2 != 0) goto L_0x004d
            goto L_0x0058
        L_0x004d:
            com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r2 = r2.getPlanInfo()
            if (r2 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            java.lang.String r3 = r2.getId()
        L_0x0058:
            r1.mPlanId = r3
            com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository r2 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository
            r2.<init>()
            r1.canvasRepository = r2
            com.tal.app.thinkacademy.live.Tag r2 = com.tal.app.thinkacademy.live.Tag.GRAFFITI
            r1.mLogTag = r2
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.Mode r2 = com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.Mode.LIVE
            r1.mMode = r2
            r2 = -1
            r1.mLastSendMsgId = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent.<init>(android.content.Context, com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver, com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider):void");
    }

    /* access modifiers changed from: protected */
    public final Context getMContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public final BaseLivePluginDriver getMDriver() {
        return this.mDriver;
    }

    /* access modifiers changed from: protected */
    public final ILiveRoomProvider getMLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    /* access modifiers changed from: protected */
    public final WXTGraffitiEngineImpl getMGraffitiEngine() {
        return this.mGraffitiEngine;
    }

    /* access modifiers changed from: protected */
    public final void setMGraffitiEngine(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
        this.mGraffitiEngine = wXTGraffitiEngineImpl;
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.TAG;
    }

    public final GraffitiCallback getGraffitiCallback() {
        return this.graffitiCallback;
    }

    public final void setGraffitiCallback(GraffitiCallback graffitiCallback2) {
        this.graffitiCallback = graffitiCallback2;
    }

    /* access modifiers changed from: protected */
    public final String getMTeacherUid() {
        return this.mTeacherUid;
    }

    /* access modifiers changed from: protected */
    public final String getMUid() {
        return this.mUid;
    }

    /* access modifiers changed from: protected */
    public final String getMPageKey() {
        return this.mPageKey;
    }

    /* access modifiers changed from: protected */
    public final void setMPageKey(String str) {
        this.mPageKey = str;
    }

    /* access modifiers changed from: protected */
    public final String getMPlanId() {
        return this.mPlanId;
    }

    /* access modifiers changed from: protected */
    public boolean getMIsOffline() {
        return this.mIsOffline;
    }

    /* access modifiers changed from: protected */
    public void setMIsOffline(boolean z) {
        this.mIsOffline = z;
    }

    /* access modifiers changed from: protected */
    public final long getMLastSendMsgId() {
        return this.mLastSendMsgId;
    }

    /* access modifiers changed from: protected */
    public final void setMLastSendMsgId(long j) {
        this.mLastSendMsgId = j;
    }

    public void initGraffiti(String str) {
        Mode mode;
        Tag tag;
        Intrinsics.checkNotNullParameter(str, "specifKey");
        log(Intrinsics.stringPlus("涂鸦初始化 specifKey = ", str));
        XesLog.setLogProvider(new GraffitiLogImpl());
        if (this instanceof GraffitiBackAgent) {
            mode = Mode.PLAYBACK;
        } else if (this instanceof GraffitiDrawAgent) {
            mode = Mode.BLACK_BOARD;
        } else {
            mode = Mode.LIVE;
        }
        this.mMode = mode;
        if (mode == Mode.BLACK_BOARD) {
            tag = Tag.GRAFFITI_DRAW_BOARD;
        } else {
            tag = Tag.GRAFFITI;
        }
        this.mLogTag = tag;
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = new WXTGraffitiEngineImpl(this.mContext.getApplicationContext());
        this.mGraffitiEngine = wXTGraffitiEngineImpl;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        View view = null;
        wXTGraffitiEngineImpl.initWithUid(2, userInfoEntity == null ? null : userInfoEntity.getUid(), str);
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl2 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl2 != null) {
            wXTGraffitiEngineImpl2.setTeacherId(this.mTeacherUid);
        }
        initExtent();
        int max = Math.max((int) (((float) LiveAreaContext.get().getPptLp().width) * 0.06f), 50);
        log(Intrinsics.stringPlus("光标的宽高是:", Integer.valueOf(max)));
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl3 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl3 != null) {
            wXTGraffitiEngineImpl3.debugMode(AppConfig.DEBUG);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl4 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI = wXTGraffitiEngineImpl4 == null ? null : wXTGraffitiEngineImpl4.getCustomUI();
        if (customUI != null) {
            customUI.setHideLaserTail(true);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl5 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI2 = wXTGraffitiEngineImpl5 == null ? null : wXTGraffitiEngineImpl5.getCustomUI();
        if (customUI2 != null) {
            customUI2.setLaserPointerColor(Color.parseColor("#FF503F"));
        }
        Drawable drawable = AppCompatResources.getDrawable(this.mContext, R.drawable.icon_graffiti_chose);
        if (drawable != null) {
            drawable.setBounds(0, 0, max, max);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl6 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI3 = wXTGraffitiEngineImpl6 == null ? null : wXTGraffitiEngineImpl6.getCustomUI();
        if (customUI3 != null) {
            customUI3.setPointDrawable(new WXTGraffitiEngine.CustomUI.DrawableDesc(drawable));
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.mContext, R.drawable.icon_graffiti_draw);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, max, max);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl7 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI4 = wXTGraffitiEngineImpl7 == null ? null : wXTGraffitiEngineImpl7.getCustomUI();
        if (customUI4 != null) {
            customUI4.setPenPointDrawable(new WXTGraffitiEngine.CustomUI.DrawableDesc(drawable2));
        }
        Drawable drawable3 = AppCompatResources.getDrawable(this.mContext, R.drawable.icon_graffiti_erase);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, max, max);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl8 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI5 = wXTGraffitiEngineImpl8 == null ? null : wXTGraffitiEngineImpl8.getCustomUI();
        if (customUI5 != null) {
            customUI5.setErasePointDrawable(new WXTGraffitiEngine.CustomUI.DrawableDesc(drawable3));
        }
        Drawable drawable4 = AppCompatResources.getDrawable(this.mContext, R.drawable.icon_graffiti_shape);
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, max, max);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl9 = this.mGraffitiEngine;
        WXTGraffitiEngine.CustomUI customUI6 = wXTGraffitiEngineImpl9 == null ? null : wXTGraffitiEngineImpl9.getCustomUI();
        if (customUI6 != null) {
            customUI6.setShapeCursorDrawable(new WXTGraffitiEngine.CustomUI.DrawableDesc(drawable4));
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl10 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl10 != null) {
            UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            wXTGraffitiEngineImpl10.setUserInfo(new WXWBAction.UserInfo(userInfoEntity2 == null ? null : userInfoEntity2.getNickName()));
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl11 = this.mGraffitiEngine;
        WXTGraffitiEngine.Setting setting = wXTGraffitiEngineImpl11 == null ? null : wXTGraffitiEngineImpl11.getSetting();
        if (setting != null) {
            setting.setSendDuration(100);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl12 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl12 != null) {
            wXTGraffitiEngineImpl12.setImageLoader(new GraffitiAgent$initGraffiti$1(this));
        }
        String str2 = this.mMode == Mode.BLACK_BOARD ? "blackboard" : "courseware";
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl13 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl13 != null) {
            view = wXTGraffitiEngineImpl13.createCanvasView(this.mContext, str2);
        }
        this.mCanvasView = view;
    }

    public final void bindPluginView(BaseLivePluginView baseLivePluginView, LiveAreaCompat.CourseRate courseRate, boolean z, String str) {
        Intrinsics.checkNotNullParameter(baseLivePluginView, "pluginView");
        Intrinsics.checkNotNullParameter(courseRate, "rateType");
        Intrinsics.checkNotNullParameter(str, "levelKey");
        log(Intrinsics.stringPlus("bindPluginView levelKey = ", str));
        LiveAreaLayoutParams pptCenterLp = LiveAreaCompat.pptCenterLp(courseRate);
        FrameLayout.LayoutParams newLp = pptCenterLp.newLp();
        this.mLiveRoomProvider.addView(this.mDriver, baseLivePluginView, str, newLp);
        StringBuilder sb = new StringBuilder();
        sb.append("bindPluginView graffiti [");
        Intrinsics.checkNotNullExpressionValue(newLp, "graffitiParams");
        sb.append(CommonKtxKt.format(newLp));
        sb.append(']');
        log(sb.toString());
        LiveAreaContext.get().layoutObserver.observe(this.mDriver, new GraffitiAgent$$ExternalSyntheticLambda0(this, courseRate, baseLivePluginView, z));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        if (LiveAreaCompat.isSmallPad()) {
            if (!z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
                log("bindPluginView graffiti Canvas 小班Pad 16:9不跟随处理");
                int i = (int) ((((float) pptCenterLp.width) / 4.0f) * ((float) 3));
                marginLayoutParams.topMargin = (pptCenterLp.height - i) / 2;
                marginLayoutParams.height = i;
            }
        } else if ((this.mMode == Mode.PLAYBACK || LiveAreaCompat.isSmallPhone()) && z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
            log("bindPluginView graffiti Canvas 回放、小班手机 16:9跟随处理");
            int i2 = (int) ((((float) pptCenterLp.width) / 16.0f) * ((float) 9));
            marginLayoutParams.topMargin = (pptCenterLp.height - i2) / 2;
            marginLayoutParams.height = i2;
        }
        log("bindPluginView graffiti Canvas [" + CommonKtxKt.format(marginLayoutParams) + ']');
        baseLivePluginView.addView(this.mCanvasView, marginLayoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindPluginView$lambda-2  reason: not valid java name */
    public static final void m184bindPluginView$lambda2(GraffitiAgent graffitiAgent, LiveAreaCompat.CourseRate courseRate, BaseLivePluginView baseLivePluginView, boolean z, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(graffitiAgent, "this$0");
        Intrinsics.checkNotNullParameter(courseRate, "$rateType");
        Intrinsics.checkNotNullParameter(baseLivePluginView, "$pluginView");
        graffitiAgent.log("bindPluginView 布局变化监听 graffiti Canvas");
        LiveAreaLayoutParams pptCenterLp = LiveAreaCompat.pptCenterLp(courseRate);
        ViewGroup.LayoutParams layoutParams = baseLivePluginView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = null;
        FrameLayout.LayoutParams layoutParams3 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams3 != null) {
            pptCenterLp.mergeLp(layoutParams3);
            baseLivePluginView.setLayoutParams(layoutParams3);
            graffitiAgent.log("bindPluginView 布局变化监听 graffiti [" + CommonKtxKt.format(layoutParams3) + ']');
        }
        View view = graffitiAgent.mCanvasView;
        ViewGroup.LayoutParams layoutParams4 = view == null ? null : view.getLayoutParams();
        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
            layoutParams2 = (FrameLayout.LayoutParams) layoutParams4;
        }
        if (layoutParams2 != null) {
            if (LiveAreaCompat.isSmallPad()) {
                if (!z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
                    graffitiAgent.log("bindPluginView 布局变化监听 graffiti Canvas 小班Pad 16:9不跟随处理");
                    int i = (int) ((((float) pptCenterLp.width) / 4.0f) * ((float) 3));
                    layoutParams2.topMargin = (pptCenterLp.height - i) / 2;
                    layoutParams2.height = i;
                }
            } else if ((graffitiAgent.mMode == Mode.PLAYBACK || LiveAreaCompat.isSmallPhone()) && z && courseRate == LiveAreaCompat.CourseRate.RATE_16_9) {
                graffitiAgent.log("bindPluginView 布局变化监听 graffiti Canvas 回放、小班手机 16:9跟随处理");
                int i2 = (int) ((((float) pptCenterLp.width) / 16.0f) * ((float) 9));
                layoutParams2.topMargin = (pptCenterLp.height - i2) / 2;
                layoutParams2.height = i2;
            }
            graffitiAgent.log("bindPluginView 布局变化监听 graffiti [" + CommonKtxKt.format(layoutParams2) + ']');
            View view2 = graffitiAgent.mCanvasView;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams2);
            }
        }
    }

    public void bindCanvasView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        viewGroup.addView(this.mCanvasView);
    }

    public final void setBaseListener(Function2<? super String, ? super Map<String, ? extends List<? extends WXWBAction>>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callbackDB");
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.setListener(new GraffitiAgent$setBaseListener$1(this, function2));
        }
    }

    public final void setSendListener(Function1<? super WXWBAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.setSenderListener(new GraffitiAgent$setSendListener$1(this, function1));
        }
    }

    /* access modifiers changed from: protected */
    public final void requestHistoryMsg(String str, Map<String, Long> map) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        Intrinsics.checkNotNullParameter(map, "params");
        if (this.mScopeHistory == null) {
            this.mScopeHistory = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        }
        CoroutineScope coroutineScope = this.mScopeHistory;
        if (coroutineScope != null) {
            HWCoroutineScopeKt.launchWithException(coroutineScope, new GraffitiAgent$requestHistoryMsg$1(this, str), new GraffitiAgent$requestHistoryMsg$2(this, str, map, (Continuation<? super GraffitiAgent$requestHistoryMsg$2>) null));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c4, code lost:
        r0 = r0.getEnterConfig();
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0298  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadHistoryMsgFromNet(java.lang.String r22, long r23, int r25, kotlin.coroutines.Continuation<? super java.util.List<? extends com.xueersi.lib.graffiti.WXWBAction>> r26) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            r5 = r25
            r0 = r26
            boolean r6 = r0 instanceof com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$loadHistoryMsgFromNet$1
            if (r6 == 0) goto L_0x001e
            r6 = r0
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$loadHistoryMsgFromNet$1 r6 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$loadHistoryMsgFromNet$1) r6
            int r7 = r6.label
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x001e
            int r0 = r6.label
            int r0 = r0 - r8
            r6.label = r0
            goto L_0x0023
        L_0x001e:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$loadHistoryMsgFromNet$1 r6 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$loadHistoryMsgFromNet$1
            r6.<init>(r1, r0)
        L_0x0023:
            r12 = r6
            java.lang.Object r0 = r12.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r7 = r12.label
            java.lang.String r13 = "，msg = "
            r8 = 2
            r9 = 0
            r10 = 1
            if (r7 == 0) goto L_0x0085
            if (r7 == r10) goto L_0x005e
            if (r7 != r8) goto L_0x0056
            java.lang.Object r2 = r12.L$5
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r12.L$4
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp r3 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp) r3
            java.lang.Object r4 = r12.L$3
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest r4 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest) r4
            java.lang.Object r5 = r12.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r12.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r12.L$0
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r7 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent) r7
            kotlin.ResultKt.throwOnFailure(r0)
            r18 = r13
            goto L_0x039f
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x005e:
            int r2 = r12.I$0
            long r3 = r12.J$0
            java.lang.Object r5 = r12.L$4
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest r5 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest) r5
            java.lang.Object r7 = r12.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r14 = r12.L$2
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r12.L$1
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r11 = r12.L$0
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r11 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x007d }
            r18 = r13
            goto L_0x0267
        L_0x007d:
            r0 = move-exception
            r8 = r5
            r18 = r13
        L_0x0081:
            r5 = r2
            r2 = r15
            goto L_0x0276
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.Object[] r0 = new java.lang.Object[r10]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "发起请求,第"
            r7.append(r11)
            r7.append(r5)
            java.lang.String r11 = "页，查询历史数据 "
            r7.append(r11)
            r7.append(r2)
            java.lang.String r11 = ",startMsgId = "
            r7.append(r11)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r0[r9] = r7
            r1.log(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r14 = r0
            java.util.List r14 = (java.util.List) r14
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r21.getMLiveRoomProvider()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            if (r0 != 0) goto L_0x00c4
        L_0x00c2:
            r0 = 0
            goto L_0x00cf
        L_0x00c4:
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r0 = r0.getEnterConfig()
            if (r0 != 0) goto L_0x00cb
            goto L_0x00c2
        L_0x00cb:
            java.lang.String r0 = r0.getIrcAK()
        L_0x00cf:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r7 = r21.getMLiveRoomProvider()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r7 = r7.getDataStorage()
            if (r7 != 0) goto L_0x00db
        L_0x00d9:
            r7 = 0
            goto L_0x00e6
        L_0x00db:
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r7 = r7.getEnterConfig()
            if (r7 != 0) goto L_0x00e2
            goto L_0x00d9
        L_0x00e2:
            java.lang.String r7 = r7.getIrcSK()
        L_0x00e6:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r11 = r21.getMLiveRoomProvider()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r11 = r11.getDataStorage()
            if (r11 != 0) goto L_0x00f2
        L_0x00f0:
            r11 = 0
            goto L_0x00fd
        L_0x00f2:
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r11 = r11.getEnterConfig()
            if (r11 != 0) goto L_0x00f9
            goto L_0x00f0
        L_0x00f9:
            java.lang.String r11 = r11.getIrcApiHost()
        L_0x00fd:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r15 = r21.getMLiveRoomProvider()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r15 = r15.getDataStorage()
            java.lang.String r16 = "3"
            if (r15 != 0) goto L_0x010c
        L_0x0109:
            r15 = r16
            goto L_0x011a
        L_0x010c:
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r15 = r15.getEnterConfig()
            if (r15 != 0) goto L_0x0113
            goto L_0x0109
        L_0x0113:
            java.lang.String r15 = r15.getBusinessId()
            if (r15 != 0) goto L_0x011a
            goto L_0x0109
        L_0x011a:
            r16 = r11
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            if (r16 == 0) goto L_0x012a
            boolean r16 = kotlin.text.StringsKt.isBlank(r16)
            if (r16 == 0) goto L_0x0127
            goto L_0x012a
        L_0x0127:
            r16 = r9
            goto L_0x012c
        L_0x012a:
            r16 = r10
        L_0x012c:
            r17 = r0
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            if (r17 == 0) goto L_0x013c
            boolean r17 = kotlin.text.StringsKt.isBlank(r17)
            if (r17 == 0) goto L_0x0139
            goto L_0x013c
        L_0x0139:
            r17 = r9
            goto L_0x013e
        L_0x013c:
            r17 = r10
        L_0x013e:
            r16 = r16 | r17
            r17 = r7
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            if (r17 == 0) goto L_0x0150
            boolean r17 = kotlin.text.StringsKt.isBlank(r17)
            if (r17 == 0) goto L_0x014d
            goto L_0x0150
        L_0x014d:
            r17 = r9
            goto L_0x0152
        L_0x0150:
            r17 = r10
        L_0x0152:
            r16 = r16 | r17
            if (r16 == 0) goto L_0x017f
            java.lang.Object[] r2 = new java.lang.Object[r10]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ircApiHost或appId或sk为空，无法拉取历史消息 ircApiHost = "
            r3.append(r4)
            r3.append(r11)
            java.lang.String r4 = " appId = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ",ircSK = "
            r3.append(r0)
            r3.append(r7)
            java.lang.String r0 = r3.toString()
            r2[r9] = r0
            r1.log(r2)
            return r14
        L_0x017f:
            kotlin.ranges.IntRange r8 = new kotlin.ranges.IntRange
            r9 = 99999(0x1869f, float:1.40128E-40)
            r8.<init>(r10, r9)
            kotlin.random.Random$Default r9 = kotlin.random.Random.Default
            kotlin.random.Random r9 = (kotlin.random.Random) r9
            int r8 = kotlin.ranges.RangesKt.random(r8, r9)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r9 = r21.getMLiveRoomProvider()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r9 = r9.getDataStorage()
            if (r9 != 0) goto L_0x019b
        L_0x0199:
            r9 = 0
            goto L_0x01aa
        L_0x019b:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r9 = r9.getRoomData()
            if (r9 != 0) goto L_0x01a2
            goto L_0x0199
        L_0x01a2:
            long r18 = r9.getServeNowTime()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r18)
        L_0x01aa:
            if (r9 != 0) goto L_0x01b8
            long r18 = java.lang.System.currentTimeMillis()
            r9 = 1000(0x3e8, float:1.401E-42)
            r20 = r11
            long r10 = (long) r9
            long r18 = r18 / r10
            goto L_0x01be
        L_0x01b8:
            r20 = r11
            long r18 = r9.longValue()
        L_0x01be:
            r9 = r18
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r18 = r13
            r13 = 10
            r11.append(r13)
            r11.append(r9)
            r11.append(r13)
            r11.append(r8)
            r11.append(r13)
            r11.append(r7)
            r11.append(r13)
            java.lang.String r7 = r11.toString()
            java.lang.String r7 = com.tal.app.thinkacademy.lib.util.EncryptUtils.encryptMD5ToString((java.lang.String) r7)
            java.lang.String r11 = "encryptMD5ToString(source)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r11)
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r13 = "ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.String r7 = r7.toLowerCase(r11)
            java.lang.String r11 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r13 = r20
            r11.append(r13)
            java.lang.String r13 = "/chat/v4/getHistoryBinaryMessages2?appId="
            r11.append(r13)
            r11.append(r0)
            java.lang.String r0 = "&businessId="
            r11.append(r0)
            r11.append(r15)
            java.lang.String r0 = "&liveId="
            r11.append(r0)
            java.lang.String r0 = r21.getMPlanId()
            r11.append(r0)
            java.lang.String r0 = "&timestamp="
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "&signature="
            r11.append(r0)
            r11.append(r7)
            java.lang.String r0 = "&nonce="
            r11.append(r0)
            r11.append(r8)
            java.lang.String r7 = r11.toString()
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest r8 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.HistoryBinaryMsgRequest
            java.lang.String r0 = java.lang.String.valueOf(r23)
            r8.<init>(r2, r0, r5)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository r0 = r1.canvasRepository     // Catch:{ Exception -> 0x0274 }
            r12.L$0 = r1     // Catch:{ Exception -> 0x0274 }
            r12.L$1 = r2     // Catch:{ Exception -> 0x0274 }
            r12.L$2 = r14     // Catch:{ Exception -> 0x0274 }
            r12.L$3 = r7     // Catch:{ Exception -> 0x0274 }
            r12.L$4 = r8     // Catch:{ Exception -> 0x0274 }
            r12.J$0 = r3     // Catch:{ Exception -> 0x0274 }
            r12.I$0 = r5     // Catch:{ Exception -> 0x0274 }
            r9 = 1
            r12.label = r9     // Catch:{ Exception -> 0x0274 }
            java.lang.Object r0 = r0.historyBinaryMsg(r7, r8, r12)     // Catch:{ Exception -> 0x0274 }
            if (r0 != r6) goto L_0x0263
            return r6
        L_0x0263:
            r11 = r1
            r15 = r2
            r2 = r5
            r5 = r8
        L_0x0267:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp r0 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp) r0     // Catch:{ Exception -> 0x0270 }
            r9 = r3
            r4 = r5
            r13 = r7
            r8 = r15
            r3 = r0
            r5 = r2
            goto L_0x0282
        L_0x0270:
            r0 = move-exception
            r8 = r5
            goto L_0x0081
        L_0x0274:
            r0 = move-exception
            r11 = r1
        L_0x0276:
            java.lang.String r0 = r0.getMessage()
            r11.throwHistoryLoadException(r7, r8, r0)
            r9 = r3
            r13 = r7
            r4 = r8
            r3 = 0
            r8 = r2
        L_0x0282:
            r2 = r14
            r14 = r11
            if (r3 != 0) goto L_0x0288
        L_0x0286:
            r0 = 0
            goto L_0x0296
        L_0x0288:
            java.lang.Integer r0 = r3.getCode()
            if (r0 != 0) goto L_0x028f
            goto L_0x0286
        L_0x028f:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x0286
            r0 = 1
        L_0x0296:
            if (r0 == 0) goto L_0x047d
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp$CanvasBinaryBean r7 = r3.getContent()
            if (r7 != 0) goto L_0x02a1
            r11 = 0
            goto L_0x0454
        L_0x02a1:
            java.util.List r0 = r7.getMsgs()
            if (r0 != 0) goto L_0x02a9
            r0 = 0
            goto L_0x02ad
        L_0x02a9:
            int r0 = r0.size()
        L_0x02ad:
            java.lang.String r11 = "收到历史涂鸦回调,共"
            if (r0 <= 0) goto L_0x041d
            r15 = 1
            java.lang.Object[] r0 = new java.lang.Object[r15]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r11)
            java.util.List r11 = r7.getMsgs()
            if (r11 != 0) goto L_0x02c4
            r11 = 0
            goto L_0x02cc
        L_0x02c4:
            int r11 = r11.size()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
        L_0x02cc:
            r15.append(r11)
            java.lang.String r11 = "条,第"
            r15.append(r11)
            java.lang.Integer r11 = r7.getPage()
            r15.append(r11)
            java.lang.String r11 = "页,"
            r15.append(r11)
            java.lang.String r11 = r7.getKey()
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            r15 = 0
            r0[r15] = r11
            r14.log(r0)
            java.lang.String r0 = r7.getKey()
            java.lang.String r11 = r14.getPageKeyByDBKey(r0)
            if (r11 == 0) goto L_0x03ec
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r15 = r14.getMGraffitiEngine()
            if (r15 != 0) goto L_0x0306
            r15 = 0
            goto L_0x030a
        L_0x0306:
            java.lang.String r15 = r15.getPageKey()
        L_0x030a:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r0 = android.text.TextUtils.equals(r0, r15)
            if (r0 == 0) goto L_0x03ec
            java.util.List r0 = r7.getMsgs()
            if (r0 != 0) goto L_0x0319
            goto L_0x034a
        L_0x0319:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r15 = r0.iterator()
        L_0x031f:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0348
            java.lang.Object r0 = r15.next()
            com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp$CanvasBinaryEntity r0 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.CanvasBinaryResp.CanvasBinaryEntity) r0
            java.lang.String r0 = r0.getContent()
            r1 = 0
            byte[] r0 = android.util.Base64.decode(r0, r1)
            com.xueersi.lib.graffiti.WXWBAction r0 = com.xueersi.lib.graffiti.WXWBAction.Factory.actionForData(r0, r11)     // Catch:{ Exception -> 0x0341 }
            java.lang.String r1 = "packageData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0341 }
            r2.add(r0)     // Catch:{ Exception -> 0x0341 }
            goto L_0x0345
        L_0x0341:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0345:
            r1 = r21
            goto L_0x031f
        L_0x0348:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x034a:
            boolean r0 = r7.hasNextPage()
            java.lang.String r1 = "页，共"
            if (r0 == 0) goto L_0x03af
            r11 = 1
            java.lang.Object[] r0 = new java.lang.Object[r11]
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r15 = "当前dbkey还有下一页，当前是第"
            r11.append(r15)
            java.lang.Integer r15 = r7.getPage()
            r11.append(r15)
            r11.append(r1)
            java.lang.Integer r1 = r7.getPages()
            r11.append(r1)
            java.lang.String r1 = "页 "
            r11.append(r1)
            r11.append(r8)
            java.lang.String r1 = r11.toString()
            r7 = 0
            r0[r7] = r1
            r14.log(r0)
            r1 = 1
            int r11 = r5 + 1
            r12.L$0 = r14
            r12.L$1 = r2
            r12.L$2 = r13
            r12.L$3 = r4
            r12.L$4 = r3
            r12.L$5 = r2
            r1 = 2
            r12.label = r1
            r7 = r14
            java.lang.Object r0 = r7.loadHistoryMsgFromNet(r8, r9, r11, r12)
            if (r0 != r6) goto L_0x039c
            return r6
        L_0x039c:
            r6 = r2
            r5 = r13
            r7 = r14
        L_0x039f:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r2.addAll(r0)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r11 = r0
            r13 = r5
            r2 = r6
            r14 = r7
            goto L_0x0454
        L_0x03af:
            r5 = 1
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "当前dbkey数据已获取完,当前是第"
            r5.append(r6)
            java.lang.Integer r6 = r7.getPage()
            r5.append(r6)
            r5.append(r1)
            java.lang.Integer r6 = r7.getPages()
            r5.append(r6)
            r5.append(r1)
            int r1 = r2.size()
            r5.append(r1)
            r1 = 32
            r5.append(r1)
            r5.append(r8)
            java.lang.String r1 = r5.toString()
            r5 = 0
            r0[r5] = r1
            r14.log(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0453
        L_0x03ec:
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "历史数据回调，非本页数据 pageKey="
            r1.append(r5)
            r1.append(r11)
            java.lang.String r5 = "，Engine pageKey = "
            r1.append(r5)
            com.xueersi.lib.graffiti.WXTGraffitiEngineImpl r5 = r14.getMGraffitiEngine()
            if (r5 != 0) goto L_0x0409
            r11 = 0
            goto L_0x040d
        L_0x0409:
            java.lang.String r11 = r5.getPageKey()
        L_0x040d:
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r5 = 0
            r0[r5] = r1
            r14.log(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0453
        L_0x041d:
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.util.List r5 = r7.getMsgs()
            if (r5 != 0) goto L_0x0430
            r11 = 0
            goto L_0x0438
        L_0x0430:
            int r5 = r5.size()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
        L_0x0438:
            r1.append(r11)
            java.lang.String r5 = "条,当前dbkey没有新增数据 "
            r1.append(r5)
            java.lang.String r5 = r7.getKey()
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r5 = 0
            r0[r5] = r1
            r14.log(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0453:
            r11 = r0
        L_0x0454:
            if (r11 != 0) goto L_0x04a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "历史数据回调，下发数据异常,content为空：code = "
            r0.append(r1)
            java.lang.Integer r1 = r3.getCode()
            r0.append(r1)
            r1 = r18
            r0.append(r1)
            java.lang.String r1 = r3.getMsg()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.throwHistoryLoadException(r13, r4, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x04a9
        L_0x047d:
            r1 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "历史数据回调，下发数据异常：code = "
            r0.append(r5)
            if (r3 != 0) goto L_0x048d
            r5 = 0
            goto L_0x0491
        L_0x048d:
            java.lang.Integer r5 = r3.getCode()
        L_0x0491:
            r0.append(r5)
            r0.append(r1)
            if (r3 != 0) goto L_0x049b
            r11 = 0
            goto L_0x049f
        L_0x049b:
            java.lang.String r11 = r3.getMsg()
        L_0x049f:
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r14.throwHistoryLoadException(r13, r4, r0)
        L_0x04a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent.loadHistoryMsgFromNet(java.lang.String, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setCourseId(String str) {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl;
        boolean z = true;
        log(Intrinsics.stringPlus("设置courseId = ", str));
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z && (wXTGraffitiEngineImpl = this.mGraffitiEngine) != null) {
            wXTGraffitiEngineImpl.setCourseId(str);
        }
    }

    public final void setPageId(String str) {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl;
        boolean z = true;
        log(Intrinsics.stringPlus("设置pageId = ", str));
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z && (wXTGraffitiEngineImpl = this.mGraffitiEngine) != null) {
            wXTGraffitiEngineImpl.setPageId(str);
        }
    }

    public final void turnPageTo(String str, @WXTGraffitiEngine.TurnPageStyle int i) {
        Intrinsics.checkNotNullParameter(str, "pageKey");
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (!Intrinsics.areEqual(str, wXTGraffitiEngineImpl == null ? null : wXTGraffitiEngineImpl.getPageKey())) {
            log(Intrinsics.stringPlus("主动翻页 >> ", str));
            onTurnPage(str, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void syncAddActionList(List<? extends WXWBAction> list) {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.addActionList(list, 4);
        }
    }

    /* access modifiers changed from: protected */
    public final void syncAddAction(WXWBAction wXWBAction) {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.addAction(wXWBAction, 3);
        }
    }

    public final void setTouchAble(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? "允许涂鸦" : "禁用涂鸦";
        log(objArr);
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        WXTGraffitiEngine.Setting setting = wXTGraffitiEngineImpl == null ? null : wXTGraffitiEngineImpl.getSetting();
        if (setting != null) {
            setting.setTouchable(z);
        }
    }

    public final void setBackground(String str) {
        if (str != null) {
            ImageLoaderJ.getDrawable(getMContext(), str, this.mCanvasView);
        }
    }

    public final Bitmap getCanvasBitmap() {
        return DrawUtils.getBitmapFromView(this.mCanvasView);
    }

    public final View getCanvasView() {
        return this.mCanvasView;
    }

    public static /* synthetic */ void cancel$default(GraffitiAgent graffitiAgent, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "翻页，主动取消";
            }
            graffitiAgent.cancel(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
    }

    public final void cancel(String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        Object[] objArr = new Object[1];
        CoroutineScope coroutineScope = this.mScopeHistory;
        objArr[0] = Intrinsics.stringPlus("主动取消，协程状态：", coroutineScope == null ? null : Boolean.valueOf(CoroutineScopeKt.isActive(coroutineScope)));
        log(objArr);
        CoroutineScope coroutineScope2 = this.mScopeHistory;
        if (coroutineScope2 != null) {
            CoroutineScopeKt.cancel(coroutineScope2, new CancellationException(str));
        }
        this.mScopeHistory = null;
    }

    public void destroy() {
        log("销毁");
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.destroy();
        }
        this.mGraffitiEngine = null;
        cancel("销毁，主动取消");
    }

    public final void log(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "contents");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(getTAG());
        spreadBuilder.addSpread(objArr);
        com.tal.app.thinkacademy.lib.logger.XesLog.i(this.mLogTag, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }

    /* access modifiers changed from: private */
    public final void upLoadHistoryTime(String str, long j, int i, Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("graffiti_mode", this.mMode.name());
        jSONObject.put("graffiti_elapsed_time", j);
        jSONObject.put("graffiti_plan_id", this.mPlanId);
        jSONObject.put("graffiti_page_key", str);
        jSONObject.put("graffiti_msg_size", i);
        jSONObject.put("graffiti_dbkey_size", map.size());
        jSONObject.put("graffiti_params", map.toString());
        jSONObject.put("graffiti_data_source", getMIsOffline() ? "离线zip" : "在线接口");
        HwTrackUtil.INSTANCE.track("hw_graffiti_history_load_time", jSONObject);
        Object[] objArr = new Object[1];
        objArr[0] = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        log(objArr);
    }

    static /* synthetic */ void upLoadHistoryException$default(GraffitiAgent graffitiAgent, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if (obj == null) {
            graffitiAgent.upLoadHistoryException(str, str2, str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upLoadHistoryException");
    }

    /* access modifiers changed from: private */
    public final void upLoadHistoryException(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("graffiti_mode", this.mMode.name());
        jSONObject.put("graffiti_plan_id", this.mPlanId);
        jSONObject.put("graffiti_page_key", str);
        jSONObject.put("graffiti_dbkey", str2);
        if (str4 == null) {
            str4 = "";
        }
        jSONObject.put("graffiti_url", str4);
        if (str5 == null) {
            str5 = "";
        }
        jSONObject.put("graffiti_params", str5);
        if (str3 == null) {
            str3 = "未知";
        }
        jSONObject.put("graffiti_error_info", str3);
        jSONObject.put("graffiti_data_source", getMIsOffline() ? "离线zip" : "在线接口");
        HwTrackUtil.INSTANCE.track("hw_graffiti_history_load_error", jSONObject);
        Object[] objArr = new Object[1];
        objArr[0] = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        log(objArr);
    }

    /* access modifiers changed from: protected */
    public final void initExtent() {
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl != null) {
            wXTGraffitiEngineImpl.registerExtensionFactory(RulerExtension.FACTORY);
        }
        RulerExtension.BG_HEIGHT = 0.11f;
        RulerExtension.BG_FILL_COLOR = Color.parseColor("#E6ffffff");
        RulerExtension.RULER_COLOR = Color.parseColor("#7f000000");
        RulerExtension.BG_RULER_MARK_COLOR = Color.parseColor("#10000000");
        RulerExtension.RULER_MARK_COLOR_OVERLAY = true;
        RulerExtension.RULER_STORE_WIDTH = 0.0025f;
        RulerExtension.RULER_PADDING_LEFT = 0.02f;
        RulerExtension.RULER_BASE_HEIGHT = 0.15f;
        RulerExtension.RULER_INTERVAL = 0.0025f;
        RulerExtension.RULER_LINE_WIDTH = 0.0015f;
        RulerExtension.RULER_TEXT_SIZE = 0.01f;
        RulerExtension.FILL_TEXT_SIZE = 0.02f;
        RulerExtension.FILL_TEXT_PADDING_BOTTOM = 0.02f;
        float f = (float) 3;
        float f2 = (float) 2;
        RulerExtension.RULER_HEIGHT_LIST = new float[]{f * 0.0085f, 0.0085f, 0.0085f, 0.0085f, 0.0085f, f2 * 0.0085f, 0.0085f, 0.0085f, 0.0085f, 0.0085f};
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl2 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl2 != null) {
            wXTGraffitiEngineImpl2.registerExtensionFactory(TriangularRulerExtension.FACTORY12);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl3 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl3 != null) {
            wXTGraffitiEngineImpl3.registerExtensionFactory(TriangularRulerExtension.FACTORY14);
        }
        TriangularRulerExtension.RULER_BASE_HEIGHT = 0.2f;
        TriangularRulerExtension.CENTER_COLOR_OVERLAY = false;
        TriangularRulerExtension.BG_FILL_COLOR = Color.parseColor("#E6F2F2F2");
        TriangularRulerExtension.CENTER_COLOR = Color.parseColor("#E6ffffff");
        TriangularRulerExtension.SIDES_WIDTH = 0.02f;
        TriangularRulerExtension.RULER_INTERVAL = 0.0039f;
        TriangularRulerExtension.RULER_BASE_HEIGHT = 0.05f;
        TriangularRulerExtension.RULER_PADDING_LEFT = 0.01f;
        TriangularRulerExtension.TEXT_SIZE = 0.02f;
        TriangularRulerExtension.TEXT_MARGIN_LEFT = 0.01f;
        TriangularRulerExtension.TEXT_MARGIN_BOTTOM = 0.01f;
        TriangularRulerExtension.RULER_TEXT_COLOR = Color.parseColor("#7f000000");
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl4 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl4 != null) {
            wXTGraffitiEngineImpl4.registerExtensionFactory(ProtractorRulerExtension.FACTORY15);
        }
        WXTGraffitiEngineImpl wXTGraffitiEngineImpl5 = this.mGraffitiEngine;
        if (wXTGraffitiEngineImpl5 != null) {
            wXTGraffitiEngineImpl5.registerExtensionFactory(CompassesExtension.FACTORY13);
        }
        TriangularRulerExtension.RULER_HEIGHT_LIST = new float[]{f * 0.004f, 0.004f, 0.004f, 0.004f, 0.004f, f2 * 0.004f, 0.004f, 0.004f, 0.004f, 0.004f};
    }

    public final void printAction(WXWBAction wXWBAction) {
        if (wXWBAction != null) {
            log("涂鸦消息详情数据", "messageType = " + wXWBAction.getMessageType() + ",pointType = " + wXWBAction.getPointType() + ",lineType = " + wXWBAction.getLineType() + ",businessType = " + wXWBAction.getBusinessType() + ",canvasInfo = " + wXWBAction.getCanvasInfo() + ",uid = " + wXWBAction.getUid() + ",cursorPosition = " + wXWBAction.getCursorPosition() + ",fillColor = " + wXWBAction.getFillColor() + ",lineIndex = " + wXWBAction.getLineIndex() + ",lineWidth = " + wXWBAction.getLineWidth() + ",pointList = " + wXWBAction.getPointList() + ",refConfig = " + wXWBAction.getRefConfig() + ",rotation = " + wXWBAction.getRotation() + ",refConfig = " + wXWBAction.getRefConfig() + ",strokeColor = " + wXWBAction.getStrokeColor() + ",selectAreaConfig = " + wXWBAction.getSelectAreaConfig() + ",userInfo = " + wXWBAction.getUserInfo() + ",msgId = " + wXWBAction.getMsgId() + ",canvasId = " + wXWBAction.getCanvasId() + ",courseId = " + wXWBAction.getCourseId() + ",pageKey = " + wXWBAction.getPageKey() + ',');
        }
    }

    private final void throwHistoryLoadException(String str, HistoryBinaryMsgRequest historyBinaryMsgRequest, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", str);
        jSONObject.put("params", historyBinaryMsgRequest);
        if (str2 != null) {
            jSONObject.put("info", str2);
        }
        throw new HistoryLoadException(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
    }
}
