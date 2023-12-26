package io.agora.rtc.audio;

public class AgoraAudioFrame {
    public int channels = 2;
    public int frequency = 44100;
    public byte[] pcm;
    public int type = 0;
}
