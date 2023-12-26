package com.tal.app.thinkacademy.live.business.common;

import android.view.ViewGroup;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.dialog.CommonDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/common/CommonFunctionViewModel$checkCourseware$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfo;", "onSuccess", "", "resp", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunctionViewModel.kt */
public final class CommonFunctionViewModel$checkCourseware$1 extends OmyCallback<HiResponse<CouseWareInfo>> {
    final /* synthetic */ String $couseWareId;
    final /* synthetic */ CommonFunctionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonFunctionViewModel$checkCourseware$1(String str, CommonFunctionViewModel commonFunctionViewModel, CommonFunctionViewModel$checkCourseware$2 commonFunctionViewModel$checkCourseware$2) {
        super(commonFunctionViewModel$checkCourseware$2);
        this.$couseWareId = str;
        this.this$0 = commonFunctionViewModel;
    }

    public void onSuccess(HiResponse<CouseWareInfo> hiResponse) {
        CouseWareInfo.CourseInfoList[] list;
        CouseWareInfo.CourseInfoList courseInfoList;
        CouseWareInfo.CourseInfoList.CourseInfoContent detail;
        Intrinsics.checkNotNullParameter(hiResponse, "resp");
        CouseWareInfo data = hiResponse.getData();
        Unit unit = null;
        if (!(data == null || (list = data.getList()) == null)) {
            int length = list.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    courseInfoList = null;
                    break;
                }
                courseInfoList = list[i];
                Integer id = courseInfoList.getId();
                if (id != null && id.intValue() == 16) {
                    break;
                }
                i++;
            }
            if (!(courseInfoList == null || (detail = courseInfoList.getDetail()) == null)) {
                if (!(!Intrinsics.areEqual(this.$couseWareId, detail.getId()))) {
                    detail = null;
                }
                if (detail != null) {
                    String str = this.$couseWareId;
                    CommonFunctionViewModel commonFunctionViewModel = this.this$0;
                    XesLog.a(CommonFunctionViewModel.TAG, "课件异常，弹出退出弹窗，接口下发的最新课件id是" + detail.getId() + "，本地课件id=" + str);
                    CommonDialog.setButtons$default(new CommonDialog(commonFunctionViewModel.mContext), false, false, 1, (Object) null).setMsgText(R.string.courseware_error_in_class_agin).setConfirmClick(R.string.tv_confirm, new CommonFunctionViewModel$checkCourseware$1$onSuccess$3$1(commonFunctionViewModel)).layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(343.0f), -2)).gravity(17).canceledOnTouchOutside(false).show();
                    unit = Unit.INSTANCE;
                }
            }
        }
        if (unit == null) {
            CommonFunctionViewModel$checkCourseware$1 commonFunctionViewModel$checkCourseware$1 = this;
            XesLog.a(CommonFunctionViewModel.TAG, "课件正常");
        }
    }
}
