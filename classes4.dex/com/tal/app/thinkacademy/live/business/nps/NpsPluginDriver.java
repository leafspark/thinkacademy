package com.tal.app.thinkacademy.live.business.nps;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.entity.NpsTagConfig;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.nps.NpsBody;
import com.tal.app.thinkacademy.live.business.nps.dialog.NpsDelegate;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/NpsPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "mIsParentAudit", "", "npsTime", "", "observeNpsState", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "planId", "", "Ljava/lang/Integer;", "status", "tagList", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "loadState", "", "onDestroy", "onMessage", "ircTypeKey", "", "message", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "nps功能", launchType = "enter", liveType = 0, moduleId = "-110")
/* compiled from: NpsPluginDriver.kt */
public final class NpsPluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final Tag TAG;
    private CourseInfoProxy mCourseInfo;
    private boolean mIsParentAudit;
    /* access modifiers changed from: private */
    public long npsTime;
    private Observer<PluginEventData> observeNpsState;
    private Integer planId;
    /* access modifiers changed from: private */
    public int status;
    /* access modifiers changed from: private */
    public NpsTagConfig tagList;

    public void onMessage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ircTypeKey");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NpsPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        Tag tag = Tag.NPS;
        this.TAG = tag;
        this.observeNpsState = new NpsPluginDriver$$ExternalSyntheticLambda0(iLiveRoomProvider, this);
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        Intrinsics.checkNotNullExpressionValue(courseInfo, "mLiveRoomProvider.dataStorage.courseInfo");
        this.mCourseInfo = courseInfo;
        this.planId = Integer.valueOf(courseInfo.getPlanId());
        boolean isParentAuditLocal = iLiveRoomProvider.getDataStorage().getCourseInfo().getIsParentAuditLocal();
        this.mIsParentAudit = isParentAuditLocal;
        if (isParentAuditLocal) {
            XesLog.i(tag, "家长旁听不处理nps");
            return;
        }
        loadState();
        PluginEventBus.register((LifecycleOwner) this, DataBusKey.Click_EXit_OR_Not, this.observeNpsState);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNpsState$lambda-0  reason: not valid java name */
    public static final void m341observeNpsState$lambda0(ILiveRoomProvider iLiveRoomProvider, NpsPluginDriver npsPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "$mLiveRoomProvider");
        Intrinsics.checkNotNullParameter(npsPluginDriver, "this$0");
        long serveNowTime = iLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
        if (npsPluginDriver.status == 1) {
            long j = npsPluginDriver.npsTime;
            if (j > 0 && j < serveNowTime) {
                XesLog.i(npsPluginDriver.TAG, "跳转NPS弹窗 state(1 开，2 关):" + npsPluginDriver.status + " 展示NPS时间戳:" + npsPluginDriver.npsTime + " 实时服务器时间:" + serveNowTime);
                new NpsDelegate().delayShowDialog(String.valueOf(npsPluginDriver.planId), npsPluginDriver.tagList);
                return;
            }
        }
        XesLog.i(npsPluginDriver.TAG, "不满足NPS弹窗条件 state(1 开，2 关):" + npsPluginDriver.status + " 展示NPS时间戳:" + npsPluginDriver.npsTime + " 实时服务器时间:" + serveNowTime);
    }

    private final void loadState() {
        int i = 0;
        XesLog.i(this.TAG, "请求nps接口获取弹窗状态");
        NpsApi npsApi = (NpsApi) Api.create(ApiUrl.INSTANCE.getBASE_URL(), NpsApi.class);
        NpsBody.Companion companion = NpsBody.Companion;
        Integer num = this.planId;
        if (num != null) {
            i = num.intValue();
        }
        Call<HiResponse<NpsBean>> npsState = npsApi.getNpsState(companion.createRequest(i));
        Callback npsPluginDriver$loadState$1 = new NpsPluginDriver$loadState$1(this, new NpsPluginDriver$loadState$2(this));
        if (!(npsState instanceof Call)) {
            npsState.enqueue(npsPluginDriver$loadState$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) npsState, npsPluginDriver$loadState$1);
        }
    }

    public void onDestroy() {
        XesLog.i(this.TAG, "npsDriver插件销毁");
        PluginEventBus.unregister(DataBusKey.Click_EXit_OR_Not, this.observeNpsState);
    }
}
