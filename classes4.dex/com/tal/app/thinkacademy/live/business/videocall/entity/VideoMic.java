package com.tal.app.thinkacademy.live.business.videocall.entity;

public class VideoMic {
    public long sendTime;
    public LinkMic video_mic;

    public class LinkMic {
        public String interactId;
        public int status;

        public LinkMic() {
        }
    }
}
