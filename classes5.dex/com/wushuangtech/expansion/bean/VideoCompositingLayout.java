package com.wushuangtech.expansion.bean;

import java.util.Arrays;

public class VideoCompositingLayout {
    public int[] backgroundColor = {0, 0, 0};
    public int mCanvasHeight;
    public int mCanvasWidth;
    public String mExtInfos;
    public String mStreamUrl;
    public Region[] regions = null;

    public String toString() {
        return "VideoCompositingLayout{backgroundColor=" + Arrays.toString(this.backgroundColor) + ", regions=" + Arrays.toString(this.regions) + ", mCanvasWidth=" + this.mCanvasWidth + ", mCanvasHeight=" + this.mCanvasHeight + '}';
    }

    public static class Region {
        public double height;
        public boolean isVideo;
        public String mDeviceID;
        public long mUserID;
        public int slotIndex;
        public double width;
        public double x;
        public double y;
        public int zOrder;

        public String toString() {
            return "Region{mUserID=" + this.mUserID + ", mDeviceID='" + this.mDeviceID + '\'' + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", zOrder=" + this.zOrder + '}';
        }
    }
}
