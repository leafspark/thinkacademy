package com.wushuangtech.wstechapi.bean;

import android.view.SurfaceView;

public class OmniVideoMixerCanvas {
    private String devId;
    private int mShowMode;
    private SurfaceView mSurface;
    private boolean openMixVideo;

    public OmniVideoMixerCanvas(int i, SurfaceView surfaceView) {
        this.mShowMode = i;
        this.mSurface = surfaceView;
    }

    public OmniVideoMixerCanvas(int i, SurfaceView surfaceView, String str, boolean z) {
        this.mShowMode = i;
        this.mSurface = surfaceView;
        this.devId = str;
        this.openMixVideo = z;
    }

    public int getShowMode() {
        return this.mShowMode;
    }

    public SurfaceView getSurface() {
        return this.mSurface;
    }

    public String getDevId() {
        return this.devId;
    }

    public boolean isOpenMixVideo() {
        return this.openMixVideo;
    }

    public void setShowMode(int i) {
        this.mShowMode = i;
    }

    public void setSurface(SurfaceView surfaceView) {
        this.mSurface = surfaceView;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setOpenMixVideo(boolean z) {
        this.openMixVideo = z;
    }

    public String toString() {
        String str;
        SurfaceView surfaceView = this.mSurface;
        if (surfaceView == null) {
            str = "";
        } else {
            str = Integer.toHexString(surfaceView.hashCode());
        }
        return this.mShowMode + "," + str + "," + this.devId + "," + this.openMixVideo;
    }
}
