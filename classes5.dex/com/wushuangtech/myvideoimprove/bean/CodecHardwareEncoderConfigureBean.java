package com.wushuangtech.myvideoimprove.bean;

import android.media.MediaCodec;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoderMediaCallBack;

public class CodecHardwareEncoderConfigureBean extends CodecBaseEncoderConfigureBean {
    public HardwareEncoderMediaCallBack hardwareEncoderMediaCallBack;
    public MediaCodecSurface mSurface;
    public MediaCodec mediaCodec;
    public boolean notifySurfaceReleased;
    public boolean resetMode;
    public boolean surfaceEnabled;

    public String toString() {
        return "HardwareEncoderConfigureBean{mediaCodec=" + this.mediaCodec + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", gop=" + this.gop + ", surfaceEnabled=" + this.surfaceEnabled + ", surface=" + this.mSurface + '}';
    }
}
