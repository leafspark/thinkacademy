package com.tal.app.thinkacademy.live.business.studentvideo;

import android.widget.ImageView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentVideoPluginViewPadSmallClassView.kt */
final class StudentVideoPluginViewPadSmallClassView$initViews$9 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StudentVideoPluginViewPadSmallClassView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentVideoPluginViewPadSmallClassView$initViews$9(StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView) {
        super(0);
        this.this$0 = studentVideoPluginViewPadSmallClassView;
    }

    public final void invoke() {
        StudentVideoBean.ListBean access$getBean1$p = this.this$0.bean1;
        if (access$getBean1$p != null) {
            StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView = this.this$0;
            StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
            boolean z = false;
            if (studentVideoPluginDriver != null && studentVideoPluginDriver.isHasMicPermission()) {
                z = true;
            }
            if (z) {
                access$getBean1$p.setOpenMic(!access$getBean1$p.isOpenMic());
                if (access$getBean1$p.isOpenMic()) {
                    ImageView access$getIv_live_business_mic_1$p = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
                    if (access$getIv_live_business_mic_1$p != null) {
                        access$getIv_live_business_mic_1$p.setImageResource(R.drawable.live_business_icon_mic_turnon);
                    }
                } else {
                    ImageView access$getIv_live_business_mic_1$p2 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
                    if (access$getIv_live_business_mic_1$p2 != null) {
                        access$getIv_live_business_mic_1$p2.setImageResource(R.drawable.live_business_icon_mic_turnoff);
                    }
                }
                StudentVideoPluginDriver studentVideoPluginDriver2 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                if (studentVideoPluginDriver2 != null) {
                    studentVideoPluginDriver2.updateMySelfMic(access$getBean1$p);
                    return;
                }
                return;
            }
            StudentVideoPluginDriver studentVideoPluginDriver3 = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
            if (studentVideoPluginDriver3 != null) {
                studentVideoPluginDriver3.applyMicPermission();
            }
            ImageView access$getIv_live_business_mic_1$p3 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
            if (access$getIv_live_business_mic_1$p3 != null) {
                access$getIv_live_business_mic_1$p3.setImageResource(R.drawable.live_business_icon_mic_turnoff);
            }
        }
    }
}
