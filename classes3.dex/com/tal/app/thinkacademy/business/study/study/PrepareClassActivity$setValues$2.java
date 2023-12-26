package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/tal/app/thinkacademy/business/study/study/PrepareClassActivity$setValues$2", "Lcom/tal/app/thinkacademy/common/courseware/ImCousesWare$CourseWareCallBack;", "onCourseWareError", "", "errorCode", "", "errorMsg", "", "planId", "onCourseWareFailed", "onCourseWareSuccess", "response", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
public final class PrepareClassActivity$setValues$2 implements ImCousesWare.CourseWareCallBack {
    final /* synthetic */ PrepareClassActivity this$0;

    PrepareClassActivity$setValues$2(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public void onCourseWareError(int i, String str, int i2) {
        this.this$0.mHasDownFinished = true;
    }

    public void onCourseWareFailed(int i, String str, int i2) {
        this.this$0.getBinding().prepareClassCourseDownLayout.setVisibility(8);
        this.this$0.getBinding().tvJoinClass.setEnabled(false);
        this.this$0.mHasDownFinished = true;
    }

    public void onCourseWareSuccess(CouseWareInfo.CourseInfoList.CourseInfoContent courseInfoContent, int i) {
        String str;
        Intrinsics.checkNotNullParameter(courseInfoContent, "response");
        if (!this.this$0.mDestroy) {
            PrepareClassActivity prepareClassActivity = this.this$0;
            Boolean isBindCourseware = courseInfoContent.isBindCourseware();
            prepareClassActivity.isBindCourseware = isBindCourseware == null ? true : isBindCourseware.booleanValue();
            if (!this.this$0.isBindCourseware) {
                this.this$0.getBinding().tvJoinClass.setEnabled(true);
                this.this$0.getBinding().prepareClassCourseDownLayout.setVisibility(0);
                this.this$0.showDownFinishView();
            } else if (courseInfoContent.getBaseZipUrl() != null) {
                PrepareClassActivity prepareClassActivity2 = this.this$0;
                String baseZipUrl = courseInfoContent.getBaseZipUrl();
                if (baseZipUrl == null) {
                    str = null;
                } else {
                    String baseZipUrl2 = courseInfoContent.getBaseZipUrl();
                    Intrinsics.checkNotNull(baseZipUrl2);
                    str = baseZipUrl.substring(StringsKt.lastIndexOf$default(baseZipUrl2, "/", 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                prepareClassActivity2.realName = str;
                this.this$0.mZipUrl = courseInfoContent.getBaseZipUrl();
                this.this$0.mZipSize = courseInfoContent.getBaseZipSize();
                this.this$0.mZipStartDownloadSize = ShareDataManager.getInstance().getLong(Intrinsics.stringPlus("courseware_download_size_", this.this$0.realName), 0, ShareDataManager.SHAREDATA_CAN_CLEAR);
                this.this$0.getBinding().tvJoinClass.setEnabled(true);
                this.this$0.getBinding().prepareClassCourseDownLayout.setVisibility(0);
                this.this$0.updateDownloadView();
                ImCoursesWareUtils.INSTANCE.addCourseWareEventListener(this.this$0.realName, String.valueOf(this.this$0.mPlanId), new PrepareClassActivity$setValues$2$onCourseWareSuccess$1(this.this$0));
            }
        }
    }
}
