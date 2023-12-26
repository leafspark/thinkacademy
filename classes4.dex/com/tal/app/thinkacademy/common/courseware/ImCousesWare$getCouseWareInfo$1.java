package com.tal.app.thinkacademy.common.courseware;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.util.JsonUtil;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/courseware/ImCousesWare$getCouseWareInfo$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo;", "onSuccess", "", "response", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImCousesWare.kt */
public final class ImCousesWare$getCouseWareInfo$1 extends OmyCallback<HiResponse<CouseWareInfo>> {
    final /* synthetic */ boolean $isCurrentLesson;
    final /* synthetic */ int $planId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImCousesWare$getCouseWareInfo$1(int i, boolean z, ImCousesWare$getCouseWareInfo$2 imCousesWare$getCouseWareInfo$2) {
        super(imCousesWare$getCouseWareInfo$2);
        this.$planId = i;
        this.$isCurrentLesson = z;
    }

    public void onSuccess(HiResponse<CouseWareInfo> hiResponse) {
        CouseWareInfo.CourseInfoList.CourseInfoContent courseInfoContent;
        CouseWareInfo.CourseInfoList courseInfoList;
        CouseWareInfo.CourseInfoList courseInfoList2;
        Integer id;
        ImCousesWare.CourseWareCallBack access$getMCourseWareListeners$p;
        HiResponse<CouseWareInfo> hiResponse2 = hiResponse;
        Intrinsics.checkNotNullParameter(hiResponse2, "response");
        XesLog.it("GetCourseWareContentLog", "课件详情页接口请求成功>>>planId=" + this.$planId + ",isCurrentLesson=" + this.$isCurrentLesson + ",response=" + GsonUtil.getInstance().objToJson(hiResponse2));
        if (hiResponse.getData() != null) {
            CouseWareInfo data = hiResponse.getData();
            Intrinsics.checkNotNull(data);
            if (data.getList() != null) {
                CouseWareInfo data2 = hiResponse.getData();
                Intrinsics.checkNotNull(data2);
                CouseWareInfo.CourseInfoList[] list = data2.getList();
                Intrinsics.checkNotNull(list);
                if (list.length == 0) {
                    if (!(ImCousesWare.mCourseWareListeners == null || (access$getMCourseWareListeners$p = ImCousesWare.mCourseWareListeners) == null)) {
                        access$getMCourseWareListeners$p.onCourseWareSuccess(new CouseWareInfo.CourseInfoList.CourseInfoContent((String) null, (String) null, (String) null, (String) null, (String) null, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, false, 1023, (DefaultConstructorMarker) null), this.$planId);
                    }
                    XesLog.dt("GetCourseWareContentLog", "list is isEmpty");
                    return;
                }
                CouseWareInfo data3 = hiResponse.getData();
                Intrinsics.checkNotNull(data3);
                CouseWareInfo.CourseInfoList[] list2 = data3.getList();
                Intrinsics.checkNotNull(list2);
                int length = list2.length;
                int i = 0;
                while (true) {
                    courseInfoContent = null;
                    if (i >= length) {
                        break;
                    }
                    int i2 = i + 1;
                    CouseWareInfo data4 = hiResponse.getData();
                    Intrinsics.checkNotNull(data4);
                    CouseWareInfo.CourseInfoList[] list3 = data4.getList();
                    if ((list3 == null || (courseInfoList2 = list3[i]) == null || (id = courseInfoList2.getId()) == null || id.intValue() != 16) ? false : true) {
                        CouseWareInfo data5 = hiResponse.getData();
                        Intrinsics.checkNotNull(data5);
                        CouseWareInfo.CourseInfoList[] list4 = data5.getList();
                        if (list4 != null && (courseInfoList = list4[i]) != null) {
                            courseInfoContent = courseInfoList.getDetail();
                        }
                    } else {
                        i = i2;
                    }
                }
                if (courseInfoContent != null) {
                    courseInfoContent.setBindCourseware(true);
                    XesLog.dt("GetCourseWareContentLog", JsonUtil.toJson(courseInfoContent));
                    ImCousesWare imCousesWare = ImCousesWare.INSTANCE;
                    ImCousesWare.courseWareInfo = courseInfoContent;
                    ShareDataManager.getInstance().saveCacheGsonEntity(new CouseWareInfoRecover(courseInfoContent.getId(), courseInfoContent.getCatalog(), courseInfoContent.getCompressIndexUrl(), courseInfoContent.getCompressIndexUrlSpareList(), courseInfoContent.getBaseZipUrl(), courseInfoContent.getBaseZipUrlSpareList(), courseInfoContent.getBaseZipMd5(), courseInfoContent.isBindCourseware(), courseInfoContent.getBaseZipSize()), String.valueOf(this.$planId), ShareDataManager.SHAREDATA_USER);
                    ImCoursesWareUtils.isUpdateCourse$default(ImCoursesWareUtils.INSTANCE, String.valueOf(this.$planId), this.$isCurrentLesson, (Boolean) null, 4, (Object) null);
                    if (this.$isCurrentLesson && ImCousesWare.mCourseWareListeners != null) {
                        ImCousesWare.CourseWareCallBack access$getMCourseWareListeners$p2 = ImCousesWare.mCourseWareListeners;
                        Intrinsics.checkNotNull(access$getMCourseWareListeners$p2);
                        CouseWareInfo.CourseInfoList.CourseInfoContent access$getCourseWareInfo$p = ImCousesWare.courseWareInfo;
                        Intrinsics.checkNotNull(access$getCourseWareInfo$p);
                        access$getMCourseWareListeners$p2.onCourseWareSuccess(access$getCourseWareInfo$p, this.$planId);
                        return;
                    }
                    return;
                }
                XesLog.dt("GetCourseWareContentLog", "course id is not 16");
                if (ImCousesWare.mCourseWareListeners != null) {
                    ImCousesWare.CourseWareCallBack access$getMCourseWareListeners$p3 = ImCousesWare.mCourseWareListeners;
                    Intrinsics.checkNotNull(access$getMCourseWareListeners$p3);
                    access$getMCourseWareListeners$p3.onCourseWareError(0, "course id is not 16", this.$planId);
                    return;
                }
                return;
            }
        }
        XesLog.dt("GetCourseWareContentLog", "data is null");
        if (this.$isCurrentLesson && ImCousesWare.mCourseWareListeners != null) {
            ImCousesWare.CourseWareCallBack access$getMCourseWareListeners$p4 = ImCousesWare.mCourseWareListeners;
            Intrinsics.checkNotNull(access$getMCourseWareListeners$p4);
            access$getMCourseWareListeners$p4.onCourseWareError(0, "data is null", this.$planId);
        }
    }
}
