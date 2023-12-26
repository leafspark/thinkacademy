package com.wushuangtech.myvideoimprove.codec;

import android.media.MediaCodec;
import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;

public class VideoBaseDecoder implements BaseCodec, MediaCodec.OnFrameRenderedListener {
    public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
    }

    public boolean open(CodecConfigureBean codecConfigureBean) {
        return true;
    }

    public boolean pause() {
        return false;
    }

    public boolean release() {
        return true;
    }

    public int restart(CodecConfigureBean codecConfigureBean) {
        return 0;
    }

    public boolean resume() {
        return false;
    }
}
