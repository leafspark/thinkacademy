package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;

public final /* synthetic */ class GameActivityPluginDriver$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ GameActivityPluginDriver f$0;

    public /* synthetic */ GameActivityPluginDriver$$ExternalSyntheticLambda0(GameActivityPluginDriver gameActivityPluginDriver) {
        this.f$0 = gameActivityPluginDriver;
    }

    public final void onChanged(Object obj) {
        GameActivityPluginDriver.m283mNotifyUserInfo$lambda0(this.f$0, (AnswerBean) obj);
    }
}
