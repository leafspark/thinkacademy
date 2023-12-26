package com.tal.app.thinkacademy.business.study.study;

import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0012"}, d2 = {"com/tal/app/thinkacademy/business/study/study/PrepareClassActivity$setValues$2$onCourseWareSuccess$1", "Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils$DownLoadCallBack;", "onFailed", "", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onProgress", "soFarBytes", "", "totalBytes", "onStart", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
public final class PrepareClassActivity$setValues$2$onCourseWareSuccess$1 implements ImCoursesWareUtils.DownLoadCallBack {
    final /* synthetic */ PrepareClassActivity this$0;

    PrepareClassActivity$setValues$2$onCourseWareSuccess$1(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public void onStart(FilePoint filePoint) {
        if (!this.this$0.mDestroy) {
            this.this$0.downloadStart = System.currentTimeMillis();
        }
    }

    public void onFinished(FilePoint filePoint) {
        String str;
        if (!this.this$0.mDestroy) {
            this.this$0.mEndDownloadTime = System.currentTimeMillis();
            long currentTimeMillis = System.currentTimeMillis() - this.this$0.downloadStart;
            XesLog.dt("PrepareClassActivity", new Object[]{Intrinsics.stringPlus("onFinished==", filePoint)});
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("startDownloadTimestamp", Long.valueOf(this.this$0.downloadStart));
            if (filePoint == null) {
                str = null;
            } else {
                str = filePoint.getRealUrl();
            }
            jsonObject.addProperty("realUrl", str);
            jsonObject.addProperty("downloadTime", Long.valueOf(currentTimeMillis / ((long) 1000)));
            jsonObject.addProperty("failureReason", "");
            jsonObject.addProperty("status", (Number) 1);
            XesLog.ut("student.CoursewareDownload", jsonObject);
            this.this$0.showDownFinishView();
        }
    }

    public void onProgress(long j, long j2, FilePoint filePoint) {
        if (!this.this$0.mDestroy) {
            this.this$0.getBinding().btCourseDownload.setVisibility(8);
            this.this$0.getBinding().tvDownStatusFailed.setVisibility(8);
            this.this$0.getBinding().prepareDownloadTitle.setVisibility(0);
            this.this$0.getBinding().prepareDownloadExplanation.setVisibility(0);
            this.this$0.getBinding().prepareClassProgress.setVisibility(0);
            this.this$0.getBinding().prepareClassProgressContent.setVisibility(0);
            int i = (int) (((((float) j) * 1.0f) * ((float) 100)) / ((float) j2));
            if (i >= this.this$0.getBinding().prepareClassProgress.getProgress()) {
                this.this$0.getBinding().prepareClassProgress.setProgress(i);
                this.this$0.mProcess = i;
                double d = (double) 1048576;
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                String format = decimalFormat.format(((double) j) / d);
                Intrinsics.checkNotNullExpressionValue(format, "df.format(downNum)");
                String format2 = decimalFormat.format(((double) j2) / d);
                Intrinsics.checkNotNullExpressionValue(format2, "df.format(totalNum)");
                this.this$0.getBinding().prepareClassProgressContent.setText(this.this$0.getString(R.string.prepare_download_process, new Object[]{format, format2}));
                XesLog.dt("PrepareClassActivity", new Object[]{"onProgress==" + j + "----" + j2});
            }
        }
    }

    public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
        String str4;
        if (!this.this$0.mDestroy) {
            this.this$0.mEndDownloadTime = System.currentTimeMillis();
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
}
