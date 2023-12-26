package com.tal.app.thinkacademy.live.business.studentvideo;

import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentVideoPluginViewPadSmallClassView.kt */
final class StudentVideoPluginViewPadSmallClassView$initViews$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StudentVideoPluginViewPadSmallClassView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentVideoPluginViewPadSmallClassView$initViews$3(StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView) {
        super(0);
        this.this$0 = studentVideoPluginViewPadSmallClassView;
    }

    public final void invoke() {
        StudentVideoBean.ListBean access$getBean1$p = this.this$0.bean1;
        if (access$getBean1$p != null) {
            StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView = this.this$0;
            long userId = access$getBean1$p.getUserId();
            Long l = studentVideoPluginViewPadSmallClassView.mUid;
            if (l != null && userId == l.longValue()) {
                boolean z = false;
                if (studentVideoPluginViewPadSmallClassView.isEnableSwitch) {
                    StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                    if (studentVideoPluginDriver != null && studentVideoPluginDriver.isHasPermission()) {
                        z = true;
                    }
                    if (!z) {
                        StudentVideoPluginDriver studentVideoPluginDriver2 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                        if (studentVideoPluginDriver2 != null) {
                            studentVideoPluginDriver2.addPermissonWindow();
                            return;
                        }
                        return;
                    }
                    access$getBean1$p.setMyselfShowHeadBg(!access$getBean1$p.isMyselfShowHeadBg());
                    access$getBean1$p.setMySelfOff(!access$getBean1$p.isMySelfOff());
                    StudentVideoPluginDriver studentVideoPluginDriver3 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                    if (studentVideoPluginDriver3 != null) {
                        studentVideoPluginDriver3.setMuteStudentVideo(access$getBean1$p.isMyselfShowHeadBg());
                    }
                    StudentVideoPluginDriver studentVideoPluginDriver4 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                    if (studentVideoPluginDriver4 != null) {
                        studentVideoPluginDriver4.enableLocalVideo(!access$getBean1$p.isMyselfShowHeadBg());
                    }
                } else if (studentVideoPluginViewPadSmallClassView.state == EnableState.TEACHER_LINK || studentVideoPluginViewPadSmallClassView.state == EnableState.TUTOR_LINK || studentVideoPluginViewPadSmallClassView.state == EnableState.RANGE_LINK) {
                    ToastUtils.showShort("Please try again after the Video Link.", new Object[0]);
                    return;
                } else if (studentVideoPluginViewPadSmallClassView.state == EnableState.CAMERA) {
                    ToastUtils.showShort("Please try again after the Photopost.", new Object[0]);
                    return;
                } else {
                    return;
                }
            } else {
                access$getBean1$p.setOtherShowHeadBg(!access$getBean1$p.isOtherShowHeadBg());
                access$getBean1$p.setHerselfOff(!access$getBean1$p.isHerselfOff());
            }
            StudentVideoPluginDriver studentVideoPluginDriver5 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
            if (studentVideoPluginDriver5 != null) {
                studentVideoPluginDriver5.updateSmallClassStudent(access$getBean1$p);
            }
        }
    }
}
