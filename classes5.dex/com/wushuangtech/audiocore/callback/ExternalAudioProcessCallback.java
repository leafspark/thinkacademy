package com.wushuangtech.audiocore.callback;

public interface ExternalAudioProcessCallback {
    byte[] OnRemoteAndLocalMixPCMData(byte[] bArr, int i, int i2, int i3, boolean z);

    byte[] onPlaybackPCMData(byte[] bArr, int i, int i2, int i3, boolean z);

    byte[] onRecordPCMData(byte[] bArr, int i, int i2, int i3, boolean z);
}
