package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class SettingsActivity$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ SettingsActivity f$0;

    public /* synthetic */ SettingsActivity$$ExternalSyntheticLambda2(SettingsActivity settingsActivity) {
        this.f$0 = settingsActivity;
    }

    public final void onChanged(Object obj) {
        SettingsActivity.m125startObserve$lambda3(this.f$0, (StateData) obj);
    }
}
