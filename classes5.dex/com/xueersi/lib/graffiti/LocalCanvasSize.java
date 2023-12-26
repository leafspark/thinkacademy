package com.xueersi.lib.graffiti;

import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashMap;
import java.util.Map;

public class LocalCanvasSize {
    private static LocalCanvasSize INNER = new LocalCanvasSize();
    private String curTag;
    private Map<String, _Local> localMap = new HashMap();

    public static LocalCanvasSize sdkInner() {
        return INNER;
    }

    public void setLocalCanvasSize(String str, int i, int i2) {
        XesLog.d("setLocalCanvasSize:tag=" + str + ",width=" + i + ",height=" + i2);
        this.curTag = str;
        this.localMap.put(str, new _Local(i, i2));
    }

    public float getValue(float f) {
        _Local _local = this.localMap.get(this.curTag);
        return _local != null ? f * ((float) _local.mLocalCanvasWidth) : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public float getX(float f) {
        _Local _local = this.localMap.get(this.curTag);
        return _local != null ? f * ((float) _local.mLocalCanvasWidth) : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public float getY(float f) {
        _Local _local = this.localMap.get(this.curTag);
        return _local != null ? f * ((float) _local.mLocalCanvasHeight) : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public int getHeight() {
        _Local _local = this.localMap.get(this.curTag);
        if (_local != null) {
            return _local.mLocalCanvasHeight;
        }
        return 0;
    }

    public int getWidth() {
        _Local _local = this.localMap.get(this.curTag);
        if (_local != null) {
            return _local.mLocalCanvasWidth;
        }
        return 0;
    }

    public void setCurTag(String str) {
        this.curTag = str;
    }

    static class _Local {
        public int mLocalCanvasHeight;
        public int mLocalCanvasWidth;

        public _Local(int i, int i2) {
            this.mLocalCanvasWidth = i;
            this.mLocalCanvasHeight = i2;
        }
    }
}
