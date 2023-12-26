package com.tal.app.thinkacademy.lib.download.listener;

import com.tal.app.thinkacademy.lib.download.model.FilePoint;

public abstract class SimpleDownloadListener implements DownloadListener {
    public void onDownloadOver(FilePoint filePoint) {
    }

    public void onMergeResult(FilePoint filePoint, int i) {
    }

    public void onNetSpeed(String str, double d, long j) {
    }

    public void onStorageSpaceNotEnough(FilePoint filePoint) {
    }

    public void onTerminalFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
    }

    public void onUnZipResult(FilePoint filePoint, int i) {
    }

    public void onVerifyResult(FilePoint filePoint, int i) {
    }
}
