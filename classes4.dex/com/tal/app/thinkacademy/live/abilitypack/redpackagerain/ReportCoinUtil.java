package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.redpackagerain.api.RedPackageRainApi;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainReportCoinBody;
import java.util.List;
import retrofit2.Call;

public class ReportCoinUtil {
    private static final int RE_TRY_COUNT = 10;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.RED_PACKAGE_RAIN;

    public static void reportRedPackageRainCoin(Integer num, Integer num2, String str, Integer num3, List<Integer> list, List<Integer> list2, int i) {
        final int i2 = i;
        if (i2 <= 10) {
            Call<HiResponse<Object>> reportRedPackageRainCoin = ((RedPackageRainApi) Api.create(RedPackageRainApi.class)).reportRedPackageRainCoin(ImConfig.INSTANCE.getOverseaApi() + "/api/redbagrain/student/reportStudentGetCoin", new RedPackageRainReportCoinBody(num2, str, num, num3, list, list2));
            final int i3 = i;
            final Integer num4 = num;
            final Integer num5 = num2;
            final String str2 = str;
            final Integer num6 = num3;
            final List<Integer> list3 = list;
            final List<Integer> list4 = list2;
            AnonymousClass2 r10 = new OmyCallback<HiResponse<Object>>(new IError() {
                public void onFail(int i, String str) {
                    Tag access$000 = ReportCoinUtil.TAG;
                    XesLog.i(access$000, "上报红包雨金币Fail，错误码=" + i + "，错误描述=" + str + ",number=" + i3);
                    ReportCoinUtil.reportRedPackageRainCoin(num4, num5, str2, num6, list3, list4, i3 + 1);
                }

                public void onError(int i, String str) {
                    Tag access$000 = ReportCoinUtil.TAG;
                    XesLog.i(access$000, "上报红包雨金币Error，错误码=" + i + "，错误描述=" + str + ",number=" + i3);
                    ReportCoinUtil.reportRedPackageRainCoin(num4, num5, str2, num6, list3, list4, i3 + 1);
                }
            }) {
                public void onSuccess(HiResponse<Object> hiResponse) {
                    Tag access$000 = ReportCoinUtil.TAG;
                    XesLog.i(access$000, "上报红包雨金币成功，number=" + i2 + ",返回结果=" + GsonUtil.getInstance().objToJson(hiResponse));
                }
            };
            if (!(reportRedPackageRainCoin instanceof Call)) {
                reportRedPackageRainCoin.enqueue(r10);
            } else {
                Retrofit2Instrumentation.enqueue((Call) reportRedPackageRainCoin, r10);
            }
        }
    }
}
