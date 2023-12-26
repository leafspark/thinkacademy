package com.tal.app.thinkacademy.live.abilitypack.schulte;

import android.content.Context;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody;
import com.tal.app.thinkacademy.live.business.schulte.api.SchulteTableApi;
import com.tal.app.thinkacademy.live.business.schulte.bean.CheckSchulteTableUserDataBody;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableEndBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableIrcType;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableShowRankListBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SubmitSchulteTableUserDataBody;
import com.tal.app.thinkacademy.live.business.schulte.listener.CheckSchulteTableUserDataListener;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0014J)\u0010\u001d\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mListenerBody", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/listenbody/SchulteTableListenerBody;", "getMListenerBody", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mPlanId", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "checkSchulteTableUserData", "", "planId", "interactId", "", "listener", "Lcom/tal/app/thinkacademy/live/business/schulte/listener/CheckSchulteTableUserDataListener;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/schulte/listener/CheckSchulteTableUserDataListener;)V", "onReceiveMessage", "message", "onVmDestroy", "submitSchulteTableUserData", "duration", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;)V", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableViewModel.kt */
public final class SchulteTableViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.SCHULTE_TABLE;
    private Integer mClassId;
    private Context mContext;
    private final ListenerData<SchulteTableListenerBody> mListenerBody = new ListenerData<>();
    private Integer mPlanId;
    private final ILiveRoomProvider provider;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTableViewModel(ILiveRoomProvider iLiveRoomProvider) {
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
            num = Integer.valueOf(courseInfo.getClassId());
        }
        this.mClassId = num;
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final ListenerData<SchulteTableListenerBody> getMListenerBody() {
        return this.mListenerBody;
    }

    public final void onReceiveMessage(String str) {
        String str2;
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                String str3 = null;
                if (optJSONObject == null) {
                    str2 = null;
                } else {
                    str2 = optJSONObject.optString("actionType");
                }
                if (Intrinsics.areEqual(SchulteTableIrcType.START.getValue(), str2)) {
                    XesLog.i(TAG, Intrinsics.stringPlus("收到开始游戏信令=", str));
                    SchulteTableStartBean schulteTableStartBean = (SchulteTableStartBean) GsonUtil.getInstance().fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), SchulteTableStartBean.class);
                    getMListenerBody().setStickyData(new SchulteTableListenerBody.Load(schulteTableStartBean));
                    Integer num = this.mPlanId;
                    if (schulteTableStartBean != null) {
                        str3 = schulteTableStartBean.getInteractId();
                    }
                    checkSchulteTableUserData(num, str3, new SchulteTableViewModel$onReceiveMessage$1$1(this, schulteTableStartBean));
                } else if (Intrinsics.areEqual(SchulteTableIrcType.SHOW_RANK_LIST.getValue(), str2)) {
                    XesLog.i(TAG, Intrinsics.stringPlus("收到发布排行榜信令=", str));
                    getMListenerBody().setStickyData(new SchulteTableListenerBody.Load((SchulteTableStartBean) null));
                    SchulteTableShowRankListBean schulteTableShowRankListBean = (SchulteTableShowRankListBean) GsonUtil.getInstance().fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), SchulteTableShowRankListBean.class);
                    ListenerData<SchulteTableListenerBody> mListenerBody2 = getMListenerBody();
                    Intrinsics.checkNotNullExpressionValue(schulteTableShowRankListBean, "rankBean");
                    mListenerBody2.setStickyData(new SchulteTableListenerBody.RankList(schulteTableShowRankListBean));
                } else if (Intrinsics.areEqual(SchulteTableIrcType.END.getValue(), str2)) {
                    XesLog.i(TAG, Intrinsics.stringPlus("收到互动结束信令=", str));
                    SchulteTableEndBean schulteTableEndBean = (SchulteTableEndBean) GsonUtil.getInstance().fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), SchulteTableEndBean.class);
                    ListenerData<SchulteTableListenerBody> mListenerBody3 = getMListenerBody();
                    Intrinsics.checkNotNullExpressionValue(schulteTableEndBean, "endBean");
                    mListenerBody3.setStickyData(new SchulteTableListenerBody.UnLoad(schulteTableEndBean));
                }
            } catch (Throwable th) {
                XesLog.e(TAG, Intrinsics.stringPlus("解析信令异常=", Log.getStackTraceString(th)));
            }
        }
    }

    private final void checkSchulteTableUserData(Integer num, String str, CheckSchulteTableUserDataListener checkSchulteTableUserDataListener) {
        Call<HiResponse<SchulteTableUserDataBean>> checkSchulteTableUserData = ((SchulteTableApi) Api.create(SchulteTableApi.class)).checkSchulteTableUserData(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/api/schultegrid/v1/student/check"), new CheckSchulteTableUserDataBody(num, str));
        Callback schulteTableViewModel$checkSchulteTableUserData$1 = new SchulteTableViewModel$checkSchulteTableUserData$1(checkSchulteTableUserDataListener, new SchulteTableViewModel$checkSchulteTableUserData$2(checkSchulteTableUserDataListener));
        if (!(checkSchulteTableUserData instanceof Call)) {
            checkSchulteTableUserData.enqueue(schulteTableViewModel$checkSchulteTableUserData$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) checkSchulteTableUserData, schulteTableViewModel$checkSchulteTableUserData$1);
        }
    }

    public final void submitSchulteTableUserData(Integer num, String str, Float f) {
        if (num == null || str == null || f == null) {
            XesLog.i(TAG, "提交数据，缺失参数：planId=" + num + "，interactId=" + str + "，duration=" + f);
            return;
        }
        Call<HiResponse<SchulteTableUserDataBean>> submitSchulteTableUserData = ((SchulteTableApi) Api.create(SchulteTableApi.class)).submitSchulteTableUserData(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/api/schultegrid/v1/student/commit"), new SubmitSchulteTableUserDataBody(num, str, f));
        Callback schulteTableViewModel$submitSchulteTableUserData$1 = new SchulteTableViewModel$submitSchulteTableUserData$1(f, this, str, new SchulteTableViewModel$submitSchulteTableUserData$2(this, str, f));
        if (!(submitSchulteTableUserData instanceof Call)) {
            submitSchulteTableUserData.enqueue(schulteTableViewModel$submitSchulteTableUserData$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) submitSchulteTableUserData, schulteTableViewModel$submitSchulteTableUserData$1);
        }
    }
}
