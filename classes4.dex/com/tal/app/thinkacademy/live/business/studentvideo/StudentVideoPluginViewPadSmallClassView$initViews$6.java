package com.tal.app.thinkacademy.live.business.studentvideo;

import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentVideoPluginViewPadSmallClassView.kt */
final class StudentVideoPluginViewPadSmallClassView$initViews$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StudentVideoPluginViewPadSmallClassView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentVideoPluginViewPadSmallClassView$initViews$6(StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView) {
        super(0);
        this.this$0 = studentVideoPluginViewPadSmallClassView;
    }

    public final void invoke() {
        StudentVideoBean.ListBean access$getBean4$p = this.this$0.bean4;
        if (access$getBean4$p != null) {
            StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView = this.this$0;
            access$getBean4$p.setOtherShowHeadBg(!access$getBean4$p.isOtherShowHeadBg());
            access$getBean4$p.setHerselfOff(!access$getBean4$p.isHerselfOff());
            StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
            if (studentVideoPluginDriver != null) {
                studentVideoPluginDriver.updateSmallClassStudent(access$getBean4$p);
            }
        }
    }
}
