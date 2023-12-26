package com.wushuangtech.api;

public interface AudioSender {
    void SetAudioFractionLoss(int i);

    void pushEncodedAudioData(byte[] bArr);

    void sendNACKData(byte[] bArr, int i, long j);

    void sendRTCPData(byte[] bArr, int i, long j);
}
