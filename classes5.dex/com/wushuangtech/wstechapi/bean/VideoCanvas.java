package com.wushuangtech.wstechapi.bean;

import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;

public class VideoCanvas {
    private String mChannelName;
    private String mDeviceID;
    private int mShowMode;
    private SurfaceView mSurfaceView;
    private TextureView mTextureView;
    private long mUserID;
    private WaterMarkPosition mWaterMarkPosition;

    public VideoCanvas() {
        this((String) null, 0, "", 1, (SurfaceView) null, (TextureView) null, (WaterMarkPosition) null);
    }

    public VideoCanvas(long j, int i, SurfaceView surfaceView) {
        this((String) null, j, "", i, surfaceView, (TextureView) null, (WaterMarkPosition) null);
    }

    public VideoCanvas(long j, int i, TextureView textureView) {
        this((String) null, j, "", i, (SurfaceView) null, textureView, (WaterMarkPosition) null);
    }

    public VideoCanvas(long j, int i, SurfaceView surfaceView, WaterMarkPosition waterMarkPosition) {
        this((String) null, j, "", i, surfaceView, (TextureView) null, waterMarkPosition);
    }

    public VideoCanvas(long j, int i, TextureView textureView, WaterMarkPosition waterMarkPosition) {
        this((String) null, j, "", i, (SurfaceView) null, textureView, waterMarkPosition);
    }

    public VideoCanvas(long j, String str, int i, SurfaceView surfaceView) {
        this((String) null, j, str, i, surfaceView, (TextureView) null, (WaterMarkPosition) null);
    }

    public VideoCanvas(String str, long j, int i, SurfaceView surfaceView) {
        this(str, j, "", i, surfaceView, (TextureView) null, (WaterMarkPosition) null);
    }

    public VideoCanvas(String str, long j, int i, TextureView textureView) {
        this(str, j, "", i, (SurfaceView) null, textureView, (WaterMarkPosition) null);
    }

    public VideoCanvas(String str, long j, String str2, int i, SurfaceView surfaceView, TextureView textureView, WaterMarkPosition waterMarkPosition) {
        this.mChannelName = str;
        this.mUserID = j;
        this.mDeviceID = str2;
        this.mShowMode = i;
        this.mSurfaceView = surfaceView;
        this.mTextureView = textureView;
        this.mWaterMarkPosition = waterMarkPosition;
    }

    public String getChannelId() {
        return this.mChannelName;
    }

    public long getUserID() {
        return this.mUserID;
    }

    public String getDeviceID() {
        return this.mDeviceID;
    }

    public int getShowMode() {
        return this.mShowMode;
    }

    public SurfaceView getSurface() {
        return this.mSurfaceView;
    }

    public WaterMarkPosition getmWaterMarkPosition() {
        return this.mWaterMarkPosition;
    }

    public TextureView getViewRenderView() {
        return this.mTextureView;
    }

    public void setChannelId(String str) {
        this.mChannelName = str;
    }

    public void setUserID(long j) {
        this.mUserID = j;
    }

    public void setDeviceID(String str) {
        this.mDeviceID = str;
    }

    public void setShowMode(int i) {
        this.mShowMode = i;
    }

    public void setSurface(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    public void setWaterMarkPosition(WaterMarkPosition waterMarkPosition) {
        this.mWaterMarkPosition = waterMarkPosition;
    }

    public void setViewRenderView(TextureView textureView) {
        this.mTextureView = textureView;
    }

    public String toString() {
        String str;
        String str2;
        SurfaceView surfaceView = this.mSurfaceView;
        String str3 = "";
        if (surfaceView == null) {
            str = str3;
        } else {
            str = Integer.toHexString(surfaceView.hashCode());
        }
        TextureView textureView = this.mTextureView;
        if (textureView == null) {
            str2 = str3;
        } else {
            str2 = Integer.toHexString(textureView.hashCode());
        }
        WaterMarkPosition waterMarkPosition = this.mWaterMarkPosition;
        if (waterMarkPosition != null) {
            str3 = waterMarkPosition.toString();
        }
        String str4 = !TextUtils.isEmpty(this.mDeviceID) ? this.mDeviceID : "null";
        return this.mChannelName + "," + this.mUserID + "," + str4 + "," + this.mShowMode + "," + str + "," + str2 + "," + str3;
    }
}
