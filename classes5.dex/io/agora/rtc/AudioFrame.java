package io.agora.rtc;

import java.nio.ByteBuffer;

public class AudioFrame {
    public int bytesPerSample;
    public int channels;
    public int numOfSamples;
    public ByteBuffer samples;
    public int samplesPerSec;

    public AudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        this.samples = byteBuffer;
        this.numOfSamples = i;
        this.bytesPerSample = i2;
        this.channels = i3;
        this.samplesPerSec = i4;
    }

    public String toString() {
        return "AgoraAudioFrame{samples=" + this.samples + ", numOfSamples=" + this.numOfSamples + ", bytesPerSample=" + this.bytesPerSample + ", channels=" + this.channels + ", samplesPerSec=" + this.samplesPerSec + '}';
    }
}
