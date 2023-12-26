package com.tal.app.thinkacademy.live.business.ranking;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/RankingPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "closeClickListener", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "mClassId", "", "Ljava/lang/Integer;", "mInteractiveId", "", "mPlanId", "mPub", "", "Ljava/lang/Boolean;", "mRankingList", "", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "mRankingPluginView", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingPluginView;", "addPluginView", "", "mRankingBean", "getRankingListBean", "onDestroy", "onMessage", "ircTypeKey", "message", "trackInteractiveLog", "interactionType", "interactionStage", "status", "failureReason", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "排行榜", ircType = {"student_rank", "mode"}, moduleId = "335", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "RankingPluginView")})
/* compiled from: RankingPluginDriver.kt */
public final class RankingPluginDriver extends BaseLivePluginDriver {
    private View.OnClickListener closeClickListener;
    private Context context;
    /* access modifiers changed from: private */
    public Integer mClassId;
    private String mInteractiveId;
    /* access modifiers changed from: private */
    public Integer mPlanId;
    private Boolean mPub;
    /* access modifiers changed from: private */
    public List<RankingBean> mRankingList;
    private RankingPluginView mRankingPluginView;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.getWeakRefContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RankingPluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2, android.os.Bundle r3) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r3 = 0
            if (r2 != 0) goto L_0x0008
        L_0x0006:
            r0 = r3
            goto L_0x0015
        L_0x0008:
            java.lang.ref.WeakReference r0 = r2.getWeakRefContext()
            if (r0 != 0) goto L_0x000f
            goto L_0x0006
        L_0x000f:
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
        L_0x0015:
            r1.context = r0
            if (r2 != 0) goto L_0x001b
        L_0x0019:
            r0 = r3
            goto L_0x0031
        L_0x001b:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r2.getDataStorage()
            if (r0 != 0) goto L_0x0022
            goto L_0x0019
        L_0x0022:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x0029
            goto L_0x0019
        L_0x0029:
            int r0 = r0.getPlanId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0031:
            r1.mPlanId = r0
            if (r2 != 0) goto L_0x0036
            goto L_0x004c
        L_0x0036:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x003d
            goto L_0x004c
        L_0x003d:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x0044
            goto L_0x004c
        L_0x0044:
            int r2 = r2.getClassId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
        L_0x004c:
            r1.mClassId = r3
            com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver$$ExternalSyntheticLambda0 r2 = new com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver$$ExternalSyntheticLambda0
            r2.<init>(r1)
            r1.closeClickListener = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    public void onMessage(String str, String str2) {
        JSONObject optJSONObject;
        if (Intrinsics.areEqual(RankingPluginDriverKt.STUDENT_RANK, str) && str2 != null && (optJSONObject = new JSONObject(str2).optJSONObject(RankingPluginDriverKt.STUDENT_RANK)) != null) {
            this.mInteractiveId = optJSONObject.optString("interactId", "");
            Boolean valueOf = Boolean.valueOf(optJSONObject.optBoolean("pub"));
            this.mPub = valueOf;
            Objects.requireNonNull(valueOf, "null cannot be cast to non-null type kotlin.Boolean");
            if (valueOf.booleanValue()) {
                getRankingListBean();
                trackInteractiveLog("Rank", "start", 1, "pub:true");
                return;
            }
            trackInteractiveLog("Rank", "end", 1, "pub:false");
            onDestroy();
        }
    }

    private final void getRankingListBean() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new RankingPluginDriver$getRankingListBean$1(this)), (CoroutineStart) null, new RankingPluginDriver$getRankingListBean$2(this, (Continuation<? super RankingPluginDriver$getRankingListBean$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void addPluginView(List<RankingBean> list) {
        Context context2 = this.context;
        if (context2 != null) {
            this.mRankingPluginView = new RankingPluginView(context2);
            SoundPoolUtils.play(context2, R.raw.live_business_interact_show, 0);
            RankingPluginView rankingPluginView = this.mRankingPluginView;
            if (rankingPluginView != null) {
                rankingPluginView.setRankingListData(this.mRankingList);
                rankingPluginView.setCloseClickListener(this.closeClickListener);
                this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mRankingPluginView, "RankingPluginView", LiveAreaContext.get().getPptLp().newLp());
                Integer num = this.mPlanId;
                if (num != null) {
                    int intValue = num.intValue();
                    Integer num2 = this.mClassId;
                    if (num2 != null) {
                        int intValue2 = num2.intValue();
                        String str = this.mInteractiveId;
                        if (str != null) {
                            InteractLogReport.uploadLog(str, intValue, intValue2);
                        }
                    }
                }
                trackInteractiveLog("Rank", "showBoard", 1, "接口数据请求成功并添加了排行榜view");
            }
        }
    }

    public void onDestroy() {
        this.mLiveRoomProvider.removeView((View) this.mRankingPluginView);
        this.mRankingPluginView = null;
        this.mLiveRoomProvider.destroyPlugin((BaseLivePluginDriver) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: closeClickListener$lambda-7  reason: not valid java name */
    public static final void m402closeClickListener$lambda7(RankingPluginDriver rankingPluginDriver, View view) {
        Intrinsics.checkNotNullParameter(rankingPluginDriver, "this$0");
        if (view.getId() == R.id.iv_ranking_list_close) {
            rankingPluginDriver.onDestroy();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void trackInteractiveLog(String str, String str2, int i, String str3) {
        InteractReportKt.XesLogReport(str2, str, this.mInteractiveId, Integer.valueOf(i), str3);
    }
}
