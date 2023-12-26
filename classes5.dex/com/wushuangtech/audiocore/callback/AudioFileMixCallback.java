package com.wushuangtech.audiocore.callback;

public interface AudioFileMixCallback {

    public enum AudioFileMixStatus {
        AudioFileMixStatus_eof
    }

    void OnAudioDecoderStatus(AudioFileMixStatus audioFileMixStatus);

    void OnBufferingBegin();

    void OnBufferingEnd();

    void OnReportFileDuration(int i);

    void OnReportPlayoutError();

    void OnReportPlayoutSeconds(int i);
}
