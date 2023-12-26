package com.tal.app.thinkacademy.live.business.parentaudit;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class ParentAuditDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ ParentAuditDriver f$0;

    public /* synthetic */ ParentAuditDriver$$ExternalSyntheticLambda1(ParentAuditDriver parentAuditDriver) {
        this.f$0 = parentAuditDriver;
    }

    public final void onChanged(Object obj) {
        ParentAuditDriver.m352observerOtherUserLevel$lambda1(this.f$0, (PluginEventData) obj);
    }
}
