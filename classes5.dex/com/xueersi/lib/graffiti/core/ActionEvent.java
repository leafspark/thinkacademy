package com.xueersi.lib.graffiti.core;

import com.xueersi.lib.graffiti.WXWBAction;

public class ActionEvent {
    private Action action;
    private Notification notification;
    private WXWBAction signalData;
    private boolean syncRender = false;

    public enum Action {
        SIGNAL,
        TOUCH,
        NOTIFICATION
    }

    public enum Notification {
        TURN_PAGE,
        SYNC_RENDER
    }

    public boolean isSyncRender() {
        return this.syncRender;
    }

    public Action getAction() {
        return this.action;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public WXWBAction getSignalData() {
        return this.signalData;
    }

    public static ActionEvent newSignalEvent(WXWBAction wXWBAction, boolean z) {
        ActionEvent actionEvent = new ActionEvent();
        actionEvent.action = Action.SIGNAL;
        actionEvent.syncRender = z;
        actionEvent.signalData = wXWBAction;
        return actionEvent;
    }

    public static ActionEvent newNotificationEvent(Notification notification2) {
        ActionEvent actionEvent = new ActionEvent();
        actionEvent.action = Action.NOTIFICATION;
        actionEvent.notification = notification2;
        return actionEvent;
    }
}
