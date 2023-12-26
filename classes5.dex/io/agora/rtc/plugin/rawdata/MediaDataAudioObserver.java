package io.agora.rtc.plugin.rawdata;

public interface MediaDataAudioObserver {
    void onMixedAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6);

    void onPlaybackAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6);

    void onPlaybackAudioFrameBeforeMixing(int i, byte[] bArr, int i2, int i3, int i4, int i5, int i6, long j, int i7);

    void onRecordAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6);
}
