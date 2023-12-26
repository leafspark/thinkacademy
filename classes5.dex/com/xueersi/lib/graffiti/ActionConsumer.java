package com.xueersi.lib.graffiti;

import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.db.DBOperator;
import com.xueersi.lib.graffiti.process.ActionProcessCenter;

public class ActionConsumer extends ActionDispatcher {
    private ActionProcessCenter actionProcessCenter;
    private WXTGraffitiEngineImpl engine;

    public ActionConsumer(WXTGraffitiEngineImpl wXTGraffitiEngineImpl, WorkExecutor workExecutor, DBOperator dBOperator) {
        super(workExecutor, dBOperator);
        this.engine = wXTGraffitiEngineImpl;
        ActionProcessCenter actionProcessCenter2 = new ActionProcessCenter(wXTGraffitiEngineImpl);
        this.actionProcessCenter = actionProcessCenter2;
        setCallBack(actionProcessCenter2);
    }

    public void addActionData(WXWBAction wXWBAction, int i) {
        if (wXWBAction instanceof WXWBAction.SendImpl) {
            addActionByDraw((WXWBAction.SendImpl) wXWBAction);
        } else {
            super.addActionData(wXWBAction, i);
        }
    }

    public void addActionByDraw(WXWBAction.SendImpl sendImpl) {
        if (sendImpl != null) {
            int i = sendImpl.messageType;
            if (i != 5) {
                if (i == 1) {
                    long lestAddLineIndex = this.actionProcessCenter.getLestAddLineIndex(0);
                    if (lestAddLineIndex > 0) {
                        sendImpl.lineIndex = lestAddLineIndex;
                    }
                } else if (i == 0) {
                    long lestCancelLineIndex = this.actionProcessCenter.getLestCancelLineIndex(0);
                    if (lestCancelLineIndex >= 0) {
                        sendImpl.lineIndex = lestCancelLineIndex;
                    }
                }
                sendImpl = null;
            } else if (this.engine.getSetting().isRejectRecoverClean()) {
                sendImpl.lineIndex = this.engine.getSetting().getBizTimeStampMillis();
            } else {
                sendImpl.lineIndex = 0;
            }
            if (sendImpl != null) {
                super.addActionData(sendImpl, 1);
                WXTGraffitiEngineImpl wXTGraffitiEngineImpl = this.engine;
                if (wXTGraffitiEngineImpl != null && wXTGraffitiEngineImpl.getSenderListener() != null) {
                    this.engine.getSenderListener().onSendActionData(sendImpl);
                }
            }
        }
    }

    public void clear() {
        super.clear();
        this.actionProcessCenter.clear();
    }
}
