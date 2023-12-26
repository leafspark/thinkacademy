package com.dianping.logan;

class SendAction {
    long fileSize;
    String name;
    SendLogRunnable sendLogRunnable;
    String uploadPath;

    SendAction() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        if (this.sendLogRunnable == null && this.fileSize <= 0) {
            return false;
        }
        return true;
    }
}
