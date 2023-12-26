package com.tal.app.thinkacademy.live.business.speedyhand.driver;

import android.os.Handler;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.SpeedyHandApiResult;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.StudentInfo;
import com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/speedyhand/driver/SpeedyHandPluginDriver$answerRob$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandApiResult;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandPluginDriver.kt */
public final class SpeedyHandPluginDriver$answerRob$1 extends OmyCallback<HiResponse<SpeedyHandApiResult>> {
    final /* synthetic */ SpeedyHandPluginDriver this$0;

    SpeedyHandPluginDriver$answerRob$1(SpeedyHandPluginDriver speedyHandPluginDriver) {
        this.this$0 = speedyHandPluginDriver;
    }

    public void onSuccess(HiResponse<SpeedyHandApiResult> hiResponse) {
        boolean z;
        String l;
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        SpeedyHandApiResult data = hiResponse.getData();
        Long l2 = null;
        StudentInfo studentInfo = data == null ? null : data.getStudentInfo();
        if (studentInfo != null) {
            SpeedyHandPluginDriver speedyHandPluginDriver = this.this$0;
            Long userId = studentInfo.getUserId();
            if ((userId == null ? -1 : userId.longValue()) >= 0 && !Intrinsics.areEqual(speedyHandPluginDriver.mShowResultInteractId, speedyHandPluginDriver.mInteractId)) {
                speedyHandPluginDriver.mShowResultInteractId = speedyHandPluginDriver.mInteractId;
                Long userId2 = studentInfo.getUserId();
                String str = "";
                if (!(userId2 == null || (l = userId2.toString()) == null)) {
                    str = l;
                }
                speedyHandPluginDriver.mShowResultUserId = str;
                SpeedyHandView access$getMSpeedyHandView$p = speedyHandPluginDriver.mSpeedyHandView;
                if (access$getMSpeedyHandView$p != null) {
                    access$getMSpeedyHandView$p.showSpeedyHandResult(new StudentInfo(studentInfo.getUserId(), studentInfo.getNickName(), studentInfo.getAvatar()));
                }
                Handler access$getMHandler$p = speedyHandPluginDriver.mHandler;
                if (access$getMHandler$p != null) {
                    access$getMHandler$p.sendEmptyMessageDelayed(speedyHandPluginDriver.KShowResult, 200);
                }
                ArrayList<VideoCallBean> access$getVideoCallList$p = speedyHandPluginDriver.videoCallList;
                if (access$getVideoCallList$p == null) {
                    z = false;
                } else {
                    z = false;
                    for (VideoCallBean userId3 : access$getVideoCallList$p) {
                        String userId4 = userId3.getUserId();
                        Long userId5 = studentInfo.getUserId();
                        if (Intrinsics.areEqual(userId4, userId5 == null ? null : userId5.toString())) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    speedyHandPluginDriver.removeView(3500);
                } else {
                    speedyHandPluginDriver.removeView(LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
                }
            }
        }
        XesLogTag access$getTAG$p = this.this$0.TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("用户抢答收到结果--userid=");
        if (studentInfo != null) {
            l2 = studentInfo.getUserId();
        }
        sb.append(l2);
        sb.append(",muserid=");
        sb.append(this.this$0.mUserId);
        objArr[0] = sb.toString();
        XesLog.i(access$getTAG$p, objArr);
    }
}
