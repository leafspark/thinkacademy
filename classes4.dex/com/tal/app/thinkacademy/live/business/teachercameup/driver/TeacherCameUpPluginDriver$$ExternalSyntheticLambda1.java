package com.tal.app.thinkacademy.live.business.teachercameup.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.business.teachercameup.bean.TeacherCameUpBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class TeacherCameUpPluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ TeacherCameUpPluginDriver f$0;
    public final /* synthetic */ TeacherCameUpBean f$1;

    public /* synthetic */ TeacherCameUpPluginDriver$$ExternalSyntheticLambda1(TeacherCameUpPluginDriver teacherCameUpPluginDriver, TeacherCameUpBean teacherCameUpBean) {
        this.f$0 = teacherCameUpPluginDriver;
        this.f$1 = teacherCameUpBean;
    }

    public final void onChanged(Object obj) {
        TeacherCameUpPluginDriver.m446stageOperation$lambda14$lambda12$lambda11(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
