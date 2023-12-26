package io.agora.rtc.audio;

public class AudioRecordingConfiguration {
    public String filePath;
    public int recordingPosition;
    public int recordingQuality;
    public int recordingSampleRate;

    public AudioRecordingConfiguration() {
        this.recordingQuality = 1;
        this.recordingPosition = 0;
        this.recordingSampleRate = 32000;
    }

    public AudioRecordingConfiguration(String str, int i, int i2, int i3) {
        this.filePath = str;
        this.recordingQuality = i;
        this.recordingPosition = i2;
        this.recordingSampleRate = i3;
    }
}
