package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.common.entity.VodPlayerReportBody;
import com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl;
import com.tal.app.thinkacademy.common.network.CommonApi;
import com.tal.app.thinkacademy.lib.network.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder;", "", "()V", "mVodPlayerData", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "clearData", "", "getVodPlayerData", "reportVideoData", "data", "Lcom/tal/app/thinkacademy/common/entity/VodPlayerReportBody;", "setVodPlayerData", "Companion", "InstanceHelper", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VodPlayerDataHolder.kt */
public final class VodPlayerDataHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VodPlayerDataHolder";
    private RecordedCalendarListEntity mVodPlayerData;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VodPlayerDataHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VodPlayerDataHolder getInstance() {
            return InstanceHelper.INSTANCE.getSSingle();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder$InstanceHelper;", "", "()V", "sSingle", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder;", "getSSingle", "()Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VodPlayerDataHolder;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VodPlayerDataHolder.kt */
    public static final class InstanceHelper {
        public static final InstanceHelper INSTANCE = new InstanceHelper();
        private static final VodPlayerDataHolder sSingle = new VodPlayerDataHolder();

        private InstanceHelper() {
        }

        public final VodPlayerDataHolder getSSingle() {
            return sSingle;
        }
    }

    public final void setVodPlayerData(RecordedCalendarListEntity recordedCalendarListEntity) {
        this.mVodPlayerData = recordedCalendarListEntity;
    }

    public final RecordedCalendarListEntity getVodPlayerData() {
        return this.mVodPlayerData;
    }

    public final void clearData() {
        this.mVodPlayerData = null;
    }

    public final void reportVideoData(VodPlayerReportBody vodPlayerReportBody) {
        Intrinsics.checkNotNullParameter(vodPlayerReportBody, DbParams.KEY_DATA);
        Call reportVodPlayerData = ((CommonApi) Api.create(ServerConfigUrl.INSTANCE.getBASE_URL(), CommonApi.class)).reportVodPlayerData(vodPlayerReportBody);
        Callback vodPlayerDataHolder$reportVideoData$1 = new VodPlayerDataHolder$reportVideoData$1(new VodPlayerDataHolder$reportVideoData$2());
        if (!(reportVodPlayerData instanceof Call)) {
            reportVodPlayerData.enqueue(vodPlayerDataHolder$reportVideoData$1);
        } else {
            Retrofit2Instrumentation.enqueue(reportVodPlayerData, vodPlayerDataHolder$reportVideoData$1);
        }
    }
}
