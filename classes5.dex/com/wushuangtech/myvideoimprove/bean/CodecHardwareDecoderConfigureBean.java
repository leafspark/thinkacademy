package com.wushuangtech.myvideoimprove.bean;

import android.media.MediaCodec;
import android.view.Surface;

public class CodecHardwareDecoderConfigureBean extends CodecConfigureBean {
    public MediaCodec mediaCodec;
    public boolean resetMode;
    public Surface surface;
    public boolean surfaceEnabled;
}
