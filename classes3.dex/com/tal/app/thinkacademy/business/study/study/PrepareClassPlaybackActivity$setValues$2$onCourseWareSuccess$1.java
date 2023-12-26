package com.tal.app.thinkacademy.business.study.study;

import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0012"}, d2 = {"com/tal/app/thinkacademy/business/study/study/PrepareClassPlaybackActivity$setValues$2$onCourseWareSuccess$1", "Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils$DownLoadCallBack;", "onFailed", "", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onProgress", "soFarBytes", "", "totalBytes", "onStart", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassPlaybackActivity.kt */
public final class PrepareClassPlaybackActivity$setValues$2$onCourseWareSuccess$1 implements ImCoursesWareUtils.DownLoadCallBack {
    final /* synthetic */ PrepareClassPlaybackActivity this$0;

    PrepareClassPlaybackActivity$setValues$2$onCourseWareSuccess$1(PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        this.this$0 = prepareClassPlaybackActivity;
    }

    public void onStart(FilePoint filePoint) {
        this.this$0.downloadStart = System.currentTimeMillis();
        XesLog.dt(this.this$0.TAG, new Object[]{Intrinsics.stringPlus("onStart==", filePoint)});
        this.this$0.getBinding().prepareClassCourseDownLayout.setVisibility(0);
    }

    public void onFinished(FilePoint filePoint) {
        XesLog.dt(this.this$0.TAG, new Object[]{Intrinsics.stringPlus("onFinished==", filePoint)});
        this.this$0.coursewareReady();
    }

    public void onProgress(long j, long j2, FilePoint filePoint) {
        this.this$0.showProgressView(j, j2);
    }

    public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
        String str4;
        XesLog.dt(this.this$0.TAG, new Object[]{Intrinsics.stringPlus("onFailed==", filePoint)});
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("startDownloadTimestamp", Long.valueOf(this.this$0.downloadStart));
        if (filePoint == null) {
            str4 = null;
        } else {
            str4 = filePoint.getRealUrl();
        }
        jsonObject.addProperty("realUrl", str4);
        jsonObject.addProperty("downloadTime", "");
        jsonObject.addProperty("failureReason", "message:" + str + ";errorInfo:" + str3);
        jsonObject.addProperty("status", (Number) 0);
        XesLog.ut("student.CoursewareDownload", jsonObject);
        this.this$0.showDownFailedView();
    }
}
