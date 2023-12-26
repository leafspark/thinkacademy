package com.tal.app.thinkacademy.live.util;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.business.liveplay.bean.RtcStatusRequest;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.RtcReportApi;
import com.tal.app.thinkacademy.live.business.topic.api.TopicApi;
import com.tal.app.thinkacademy.live.business.topic.bean.request.UploadLogRequest;
import retrofit2.Call;

public class InteractLogReport {
    public static void uploadLog(String str, int i, int i2) {
        Call uploadLog = ((TopicApi) Api.create(TopicApi.class)).uploadLog(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/interact/partakereport", new UploadLogRequest(str, i, i2));
        AnonymousClass2 r4 = new OmyCallback<HiResponse<EmptyBean>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<EmptyBean> hiResponse) {
            }
        };
        if (!(uploadLog instanceof Call)) {
            uploadLog.enqueue(r4);
        } else {
            Retrofit2Instrumentation.enqueue(uploadLog, r4);
        }
    }

    public static void uploadRtcStatusLog(int i, int i2, int i3, int i4) {
        int i5 = PermissionUtils.isGranted(new String[]{"android.permission.RECORD_AUDIO"}) ? 1 : 2;
        int i6 = PermissionUtils.isGranted(new String[]{"android.permission.CAMERA"}) ? 1 : 2;
        Call rtcStatus = ((RtcReportApi) Api.create(RtcReportApi.class)).rtcStatus(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/setRtcStatus", new RtcStatusRequest(i, i2, 0, i5, i6, i3, i4));
        AnonymousClass4 r12 = new OmyCallback<HiResponse<EmptyBean>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<EmptyBean> hiResponse) {
            }
        };
        if (!(rtcStatus instanceof Call)) {
            rtcStatus.enqueue(r12);
        } else {
            Retrofit2Instrumentation.enqueue(rtcStatus, r12);
        }
    }
}
