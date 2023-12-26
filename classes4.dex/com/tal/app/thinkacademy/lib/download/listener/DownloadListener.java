package com.tal.app.thinkacademy.lib.download.listener;

import com.tal.app.thinkacademy.lib.download.model.FilePoint;

public interface DownloadListener {
    void onBlockComplete(FilePoint filePoint);

    void onCancel(FilePoint filePoint);

    void onFailed(FilePoint filePoint, int i, String str, String str2, String str3);

    void onFinished(FilePoint filePoint);

    void onPause(FilePoint filePoint);

    void onProgress(long j, long j2, FilePoint filePoint);

    void onStart(FilePoint filePoint);
}
