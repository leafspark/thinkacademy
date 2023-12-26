package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.app.Activity;
import android.content.Context;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.entity.NpsTagConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.nps.NpsApi;
import com.tal.app.thinkacademy.live.business.nps.bean.NpsSaveRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ6\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/dialog/NpsDelegate;", "", "()V", "delayShowDialog", "", "planId", "", "tagList", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "saveNps", "context", "Landroid/content/Context;", "list", "", "", "score", "remark", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsDelegate.kt */
public final class NpsDelegate {
    public final void delayShowDialog(String str, NpsTagConfig npsTagConfig) {
        Intrinsics.checkNotNullParameter(str, "planId");
        ThreadUtils.runOnUiThreadDelayed(new NpsDelegate$$ExternalSyntheticLambda0(str, npsTagConfig, this), 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: delayShowDialog$lambda-0  reason: not valid java name */
    public static final void m344delayShowDialog$lambda0(String str, NpsTagConfig npsTagConfig, NpsDelegate npsDelegate) {
        Intrinsics.checkNotNullParameter(str, "$planId");
        Intrinsics.checkNotNullParameter(npsDelegate, "this$0");
        Activity topActivity = XesActivityManager.Companion.getInstance().getTopActivity(true);
        if (topActivity == null) {
            XesLog.e(Tag.NPS, "当前Activity获取失败，不展示NPS弹窗");
            return;
        }
        XesLog.s(Tag.NPS, Intrinsics.stringPlus("Nps展示弹窗 当前页面: ", topActivity.getClass().getSimpleName()));
        HWEventTracking.Companion.get().ostaNpsExposed(str);
        new NpsDialog(topActivity, npsTagConfig, new NpsDelegate$delayShowDialog$1$1(str, npsDelegate, topActivity)).show();
    }

    /* access modifiers changed from: private */
    public final void saveNps(Context context, String str, List<Integer> list, int i, String str2) {
        XesLog.i(Tag.NPS, "nps提交用户反馈信息：planId:" + str + ", stars:" + i + ", tags:" + list + ", reason:" + str2);
        Call<HiResponse<Object>> saveNps = ((NpsApi) Api.create(ApiUrl.INSTANCE.getBASE_URL(), NpsApi.class)).saveNps(new NpsSaveRequest(str, list, i, str2));
        Callback npsDelegate$saveNps$1 = new NpsDelegate$saveNps$1(context, new NpsDelegate$saveNps$2());
        if (!(saveNps instanceof Call)) {
            saveNps.enqueue(npsDelegate$saveNps$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) saveNps, npsDelegate$saveNps$1);
        }
    }
}
