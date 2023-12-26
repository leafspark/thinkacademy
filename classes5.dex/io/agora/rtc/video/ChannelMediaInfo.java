package io.agora.rtc.video;

public class ChannelMediaInfo {
    public String channelName = null;
    public String token = null;
    public int uid = 0;

    public ChannelMediaInfo(String str, String str2, int i) {
        this.channelName = str;
        this.token = str2;
        this.uid = i;
    }
}
