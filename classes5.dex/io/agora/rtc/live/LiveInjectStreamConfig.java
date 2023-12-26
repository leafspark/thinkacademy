package io.agora.rtc.live;

public class LiveInjectStreamConfig {
    public int audioBitrate = 48;
    public int audioChannels = 1;
    public AudioSampleRateType audioSampleRate = AudioSampleRateType.TYPE_44100;
    public int height = 0;
    public int videoBitrate = 400;
    public int videoFramerate = 15;
    public int videoGop = 30;
    public int width = 0;

    public enum AudioSampleRateType {
        TYPE_32000(32000),
        TYPE_44100(44100),
        TYPE_48000(48000);
        
        private int value;

        private AudioSampleRateType(int i) {
            this.value = i;
        }

        public static int getValue(AudioSampleRateType audioSampleRateType) {
            return audioSampleRateType.value;
        }
    }
}
