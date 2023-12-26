package com.tal.app.thinkacademy.common.courseware;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.courseware.CourseWareApi;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.courseware.CouseWarePreList;
import com.tal.app.thinkacademy.common.courseware.body.PlanIdBody;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl;
import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0013\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/ImCousesWare;", "", "()V", "courseWareInfo", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "courseWareInfoPreList", "", "Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "[Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "mCourseWareListeners", "Lcom/tal/app/thinkacademy/common/courseware/ImCousesWare$CourseWareCallBack;", "addCourseWareEventListener", "", "listener", "getCourseWareInfo", "getCourseWareInfoPreList", "()[Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList$CourseInfoPreList;", "getCourseWarePreList", "getCouseWareInfo", "planId", "", "isCurrentLesson", "", "CourseWareCallBack", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImCousesWare.kt */
public final class ImCousesWare {
    public static final ImCousesWare INSTANCE = new ImCousesWare();
    /* access modifiers changed from: private */
    public static CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo;
    /* access modifiers changed from: private */
    public static CouseWarePreList.CourseInfoPreList[] courseWareInfoPreList;
    /* access modifiers changed from: private */
    public static CourseWareCallBack mCourseWareListeners;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/ImCousesWare$CourseWareCallBack;", "", "onCourseWareError", "", "errorCode", "", "errorMsg", "", "planId", "onCourseWareFailed", "onCourseWareSuccess", "response", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo$CourseInfoList$CourseInfoContent;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImCousesWare.kt */
    public interface CourseWareCallBack {
        void onCourseWareError(int i, String str, int i2);

        void onCourseWareFailed(int i, String str, int i2);

        void onCourseWareSuccess(CouseWareInfo.CourseInfoList.CourseInfoContent courseInfoContent, int i);
    }

    private ImCousesWare() {
    }

    public final void getCouseWareInfo(int i, boolean z) {
        XesLog.it("GetCourseWareContentLog", "请求课件详情页接口>>>planId=" + i + ",isCurrentLesson=" + z);
        Call<HiResponse<CouseWareInfo>> courseWareContent = ((CourseWareApi) Api.create(CourseWareApi.class)).getCourseWareContent(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/classroom/courseware"), new PlanIdBody(Integer.valueOf(i)));
        Callback imCousesWare$getCouseWareInfo$1 = new ImCousesWare$getCouseWareInfo$1(i, z, new ImCousesWare$getCouseWareInfo$2(z, i));
        if (!(courseWareContent instanceof Call)) {
            courseWareContent.enqueue(imCousesWare$getCouseWareInfo$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) courseWareContent, imCousesWare$getCouseWareInfo$1);
        }
    }

    public final CouseWareInfo.CourseInfoList.CourseInfoContent getCourseWareInfo() {
        return courseWareInfo;
    }

    public final void getCourseWarePreList() {
        Call courseWarePreList$default = CourseWareApi.DefaultImpls.getCourseWarePreList$default((CourseWareApi) Api.create(CourseWareApi.class), Intrinsics.stringPlus(ServerConfigUrl.INSTANCE.getBASE_URL(), "classroom-hub/timetable/student/prestrainList"), (EmptyPostBean) null, 2, (Object) null);
        Callback imCousesWare$getCourseWarePreList$1 = new ImCousesWare$getCourseWarePreList$1(new ImCousesWare$getCourseWarePreList$2());
        if (!(courseWarePreList$default instanceof Call)) {
            courseWarePreList$default.enqueue(imCousesWare$getCourseWarePreList$1);
        } else {
            Retrofit2Instrumentation.enqueue(courseWarePreList$default, imCousesWare$getCourseWarePreList$1);
        }
    }

    public final CouseWarePreList.CourseInfoPreList[] getCourseWareInfoPreList() {
        return courseWareInfoPreList;
    }

    public final void addCourseWareEventListener(CourseWareCallBack courseWareCallBack) {
        mCourseWareListeners = courseWareCallBack;
    }
}
