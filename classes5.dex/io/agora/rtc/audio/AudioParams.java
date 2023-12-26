package io.agora.rtc.audio;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.wushuangtech.library.GlobalAudioConfig;

public class AudioParams {
    public int channel = 1;
    public int mode = 0;
    public int sampleRate = GlobalAudioConfig.AUDIO_RECORD_DEFAULT_SAMPLERATE;
    public int samplesPerCall = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;

    public AudioParams(int i, int i2, int i3, int i4) {
        this.sampleRate = i;
        this.channel = i2;
        this.mode = i3;
        this.samplesPerCall = i4;
    }

    public String toString() {
        return "AudioParams{sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", mode=" + this.mode + ", samplesPerCall=" + this.samplesPerCall + '}';
    }
}
