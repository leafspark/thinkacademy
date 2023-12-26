package com.dianping.logan;

class LoganModel {
    Action action;
    OpenAction openAction;
    SendAction sendAction;
    WriteAction writeAction;

    enum Action {
        OPEN,
        WRITE,
        SEND,
        FLUSH
    }

    LoganModel() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        WriteAction writeAction2;
        SendAction sendAction2;
        Action action2 = this.action;
        if (action2 != null) {
            if (action2 == Action.SEND && (sendAction2 = this.sendAction) != null && sendAction2.isValid()) {
                return true;
            }
            if ((this.action == Action.WRITE && (writeAction2 = this.writeAction) != null && writeAction2.isValid()) || this.action == Action.FLUSH) {
                return true;
            }
            if (this.action != Action.OPEN || this.openAction == null) {
                return false;
            }
            return true;
        }
        return false;
    }
}
