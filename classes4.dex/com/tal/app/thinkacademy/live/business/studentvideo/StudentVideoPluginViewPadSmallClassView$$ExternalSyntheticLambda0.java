package com.tal.app.thinkacademy.live.business.studentvideo;

import android.view.SurfaceView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;

public final /* synthetic */ class StudentVideoPluginViewPadSmallClassView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StudentVideoPluginViewPadSmallClassView f$1;
    public final /* synthetic */ StudentVideoBean.ListBean f$2;
    public final /* synthetic */ SurfaceView f$3;

    public /* synthetic */ StudentVideoPluginViewPadSmallClassView$$ExternalSyntheticLambda0(int i, StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView, StudentVideoBean.ListBean listBean, SurfaceView surfaceView) {
        this.f$0 = i;
        this.f$1 = studentVideoPluginViewPadSmallClassView;
        this.f$2 = listBean;
        this.f$3 = surfaceView;
    }

    public final void run() {
        StudentVideoPluginViewPadSmallClassView.m441addRenderView$lambda7(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
