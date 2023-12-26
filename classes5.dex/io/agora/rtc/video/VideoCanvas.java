package io.agora.rtc.video;

import android.view.View;

public class VideoCanvas {
    @Deprecated
    public static final int RENDER_MODE_ADAPTIVE = 3;
    public static final int RENDER_MODE_FILL = 4;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public String channelId;
    public int mirrorMode;
    public int renderMode;
    public int uid;
    public View view;

    public VideoCanvas(View view2) {
        this.view = view2;
        this.renderMode = 1;
        this.mirrorMode = 0;
        this.uid = 0;
    }

    public VideoCanvas(View view2, int i, int i2) {
        this.view = view2;
        this.renderMode = i;
        this.uid = i2;
        this.mirrorMode = 0;
    }

    public VideoCanvas(View view2, int i, String str, int i2) {
        this.view = view2;
        this.renderMode = i;
        this.channelId = str;
        this.uid = i2;
        this.mirrorMode = 0;
    }

    public VideoCanvas(View view2, int i, int i2, int i3) {
        this.view = view2;
        this.renderMode = i;
        this.uid = i2;
        this.mirrorMode = i3;
    }

    public VideoCanvas(View view2, int i, String str, int i2, int i3) {
        this.view = view2;
        this.renderMode = i;
        this.mirrorMode = i3;
        this.channelId = str;
        this.uid = i2;
    }
}
