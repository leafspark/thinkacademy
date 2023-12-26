package com.tal.app.thinkacademy.live.business.videocall.bll;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.videocall.config.VideoCallConfig;
import com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver;
import com.tal.app.thinkacademy.live.business.videocall.entity.LinkMicResponseBean;
import com.tal.app.thinkacademy.live.business.videocall.entity.body.LinkMicBody;
import com.tal.app.thinkacademy.live.business.videocall.http.VideoCallApi;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import retrofit2.Call;

public class VideoCallHelper {
    private CourseInfoProxy mCourseInfoProxy;
    private EnterConfigProxy mEnterConfigProxy;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private PlanInfoProxy mPlanInfoProxy;
    private TeacherInfo mTeacherInfo;
    private UserInfoProxy mUserInfoProxy;
    /* access modifiers changed from: private */
    public VideoCallDriver mVideoCallDriver;
    private int rtcRecordRequestRetryTime;
    private String teacherRoomId;
    private String tutorRoomId;

    public interface Callback<T> {
        void onFail(int i);

        void onSuccess(T t);
    }

    public VideoCallHelper(ILiveRoomProvider iLiveRoomProvider, VideoCallDriver videoCallDriver) {
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.mTeacherInfo = iLiveRoomProvider.getDataStorage().getTeacherInfo();
        this.mPlanInfoProxy = iLiveRoomProvider.getDataStorage().getPlanInfo();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        EnterConfigProxy enterConfig = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.mEnterConfigProxy = enterConfig;
        if (!(enterConfig == null || enterConfig.getRtcConfig() == null)) {
            this.teacherRoomId = this.mEnterConfigProxy.getRtcConfig().getTeacherRoomId();
            this.tutorRoomId = this.mEnterConfigProxy.getRtcConfig().getTutorRoomId();
        }
        this.mVideoCallDriver = videoCallDriver;
    }

    public void linkMicRequest(String str, String str2, int i, int i2, int i3, int i4, Callback<String> callback) {
        this.rtcRecordRequestRetryTime = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("linkMicRequest start : interactId:");
        final String str3 = str;
        sb.append(str3);
        sb.append("from");
        final String str4 = str2;
        sb.append(str4);
        final int i5 = i3;
        sb.append(i5);
        sb.append("cameraAvailable:");
        XesLog.dt(sb.toString(), new Object[0]);
        Call<HiResponse<LinkMicResponseBean>> linkMicRequest = ((VideoCallApi) Api.create(VideoCallApi.class)).linkMicRequest(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/linkmic/student/handsup", new LinkMicBody(safeParseInt(this.mTeacherInfo.getId()), this.mCourseInfoProxy.getTutorId(), safeParseInt(this.mPlanInfoProxy.getId()), this.mCourseInfoProxy.getCourseId(), this.mCourseInfoProxy.getClassId(), str, i3, i4));
        final Callback<String> callback2 = callback;
        final int i6 = i;
        final int i7 = i4;
        AnonymousClass2 r0 = new OmyCallback<HiResponse<LinkMicResponseBean>>(new IError() {
            public void onFail(int i, String str) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("linkMicRequest连麦请求onFailed", "error=" + i + ", msg=" + str);
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
                XesLog.et("linkMicRequest连麦请求失败： error=" + i + ", msg=" + str, new Object[0]);
                Callback callback = callback2;
                if (callback != null) {
                    callback.onFail(i);
                }
            }

            public void onError(int i, String str) {
                XesLog.et(str + i, new Object[0]);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("linkMicRequest onError", "error=" + i + ", msg=" + str);
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
                StringBuilder sb = new StringBuilder();
                sb.append("linkMicRequest onPmFailure：");
                sb.append(str);
                XesLog.dt(sb.toString(), new Object[0]);
                Callback callback = callback2;
                if (callback != null) {
                    callback.onFail(i);
                }
            }
        }) {
            public void onSuccess(HiResponse<LinkMicResponseBean> hiResponse) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("linkMicRequest连麦请求成功", hiResponse.toString());
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
                XesLog.dt("linkMicRequest连麦请求成功：" + hiResponse.toString(), new Object[0]);
                if (hiResponse.getStat() == 1 && hiResponse.getData() != null) {
                    VideoCallHelper.this.mVideoCallDriver.requestMicro(i6, str4, hiResponse.getData().className, str3, String.valueOf(i5), String.valueOf(i7));
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onSuccess(hiResponse.getData().className);
                    }
                }
            }
        };
        if (!(linkMicRequest instanceof Call)) {
            linkMicRequest.enqueue(r0);
        } else {
            Retrofit2Instrumentation.enqueue((Call) linkMicRequest, r0);
        }
    }

    public long safeParseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private long getRoomId() {
        String str;
        if (!this.mVideoCallDriver.isInTraningMode()) {
            str = this.teacherRoomId;
        } else {
            str = this.tutorRoomId;
        }
        return safeParseLong(str);
    }

    public int safeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public class ServerErrorException extends Exception {
        public int mCode;
        public String mMessage;

        public ServerErrorException(int i, String str) {
            this.mCode = i;
            this.mMessage = str;
        }
    }
}
