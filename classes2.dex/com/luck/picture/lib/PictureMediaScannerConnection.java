package com.luck.picture.lib;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

public class PictureMediaScannerConnection implements MediaScannerConnection.MediaScannerConnectionClient {
    private ScanListener mListener;
    private final MediaScannerConnection mMs;
    private final String mPath;

    public interface ScanListener {
        void onScanFinish();
    }

    public PictureMediaScannerConnection(Context context, String str, ScanListener scanListener) {
        this.mListener = scanListener;
        this.mPath = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    public PictureMediaScannerConnection(Context context, String str) {
        this.mPath = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath)) {
            this.mMs.scanFile(this.mPath, (String) null);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        this.mMs.disconnect();
        ScanListener scanListener = this.mListener;
        if (scanListener != null) {
            scanListener.onScanFinish();
        }
    }
}
