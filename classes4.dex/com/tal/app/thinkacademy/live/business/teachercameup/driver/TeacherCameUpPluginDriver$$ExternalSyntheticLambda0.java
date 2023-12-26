package com.tal.app.thinkacademy.live.business.teachercameup.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class TeacherCameUpPluginDriver$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ TeacherCameUpPluginDriver f$0;

    public /* synthetic */ TeacherCameUpPluginDriver$$ExternalSyntheticLambda0(TeacherCameUpPluginDriver teacherCameUpPluginDriver) {
        this.f$0 = teacherCameUpPluginDriver;
    }

    public final void onChanged(Object obj) {
        TeacherCameUpPluginDriver.m445observerTeacherInfo$lambda1(this.f$0, (PluginEventData) obj);
    }
}
