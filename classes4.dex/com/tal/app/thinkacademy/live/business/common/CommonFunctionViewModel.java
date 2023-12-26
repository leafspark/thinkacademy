package com.tal.app.thinkacademy.live.business.common;

import android.content.Context;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.CourseWareApi;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover;
import com.tal.app.thinkacademy.common.courseware.body.PlanIdBody;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/common/CommonFunctionViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mContext", "Landroid/content/Context;", "mCourseId", "", "Ljava/lang/Integer;", "mPlanId", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "checkCourseware", "", "onReceiveMessage", "message", "", "onVmDestroy", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunctionViewModel.kt */
public final class CommonFunctionViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.VERIFY_COURSE_WARE;
    /* access modifiers changed from: private */
    public Context mContext;
    private Integer mCourseId;
    private Integer mPlanId;
    private final ILiveRoomProvider provider;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/common/CommonFunctionViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommonFunctionViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonFunctionViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        CourseInfoProxy courseInfo;
        CourseInfoProxy courseInfo2;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        Integer num = null;
        this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        this.mPlanId = (dataStorage == null || (courseInfo2 = dataStorage.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo2.getPlanId());
        DataStorage dataStorage2 = iLiveRoomProvider.getDataStorage();
        if (!(dataStorage2 == null || (courseInfo = dataStorage2.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getCourseId());
        }
        this.mCourseId = num;
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final void onReceiveMessage(String str) {
        String str2;
        XesLog.a(TAG, Intrinsics.stringPlus("收到信令= ", str));
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("classmode");
                if (optJSONObject == null) {
                    str2 = null;
                } else {
                    str2 = optJSONObject.optString("action");
                }
                if (str2 == null) {
                    CommonFunctionViewModel commonFunctionViewModel = this;
                    str2 = jSONObject.optString("classmode");
                }
                if (Intrinsics.areEqual("onclass", str2)) {
                    checkCourseware();
                }
            } catch (Throwable th) {
                XesLog.e(TAG, Intrinsics.stringPlus("解析信令异常= ", Log.getStackTraceString(th)));
            }
        }
    }

    private final void checkCourseware() {
        ShareDataManager instance = ShareDataManager.getInstance();
        Class cls = CouseWareInfoRecover.class;
        Integer num = this.mPlanId;
        String str = null;
        CouseWareInfoRecover couseWareInfoRecover = (CouseWareInfoRecover) instance.getCacheEntity(cls, num == null ? null : num.toString(), ShareDataManager.SHAREDATA_USER);
        if (couseWareInfoRecover != null) {
            str = couseWareInfoRecover.getId();
        }
        XesLog.i(TAG, "请求课件接口，课次id=" + this.mPlanId + "，本地课件id=" + str);
        Call<HiResponse<CouseWareInfo>> courseWareContent = ((CourseWareApi) Api.create(CourseWareApi.class)).getCourseWareContent(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/classroom/courseware"), new PlanIdBody(this.mPlanId));
        Callback commonFunctionViewModel$checkCourseware$1 = new CommonFunctionViewModel$checkCourseware$1(str, this, new CommonFunctionViewModel$checkCourseware$2());
        if (!(courseWareContent instanceof Call)) {
            courseWareContent.enqueue(commonFunctionViewModel$checkCourseware$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) courseWareContent, commonFunctionViewModel$checkCourseware$1);
        }
    }
}
