package com.wushuangtech.wstechapi.bean;

public class PublisherConfiguration {
    private boolean mPureAudio;
    private String mPushUrl = "";
    private VideoMixerParams videoMixerParams;

    public String getPushUrl() {
        return this.mPushUrl;
    }

    public void setPushUrl(String str) {
        this.mPushUrl = str;
    }

    public boolean ismPureAudio() {
        return this.mPureAudio;
    }

    public void setmPureAudio(boolean z) {
        this.mPureAudio = z;
    }

    public boolean setVideoMixerParams(VideoMixerParams videoMixerParams2) {
        if (videoMixerParams2.mVideoMixerWidth <= 0 || videoMixerParams2.mVideoMixerHeight <= 0 || videoMixerParams2.mVideoMixerBitrate <= 0 || videoMixerParams2.mVideoMixerFps <= 0) {
            return false;
        }
        if (videoMixerParams2.mVideoMixerHighQualityMode != 160601 && videoMixerParams2.mVideoMixerHighQualityMode != 160602) {
            return false;
        }
        this.videoMixerParams = videoMixerParams2;
        return true;
    }

    public VideoMixerParams getVideoMixerParams() {
        return this.videoMixerParams;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublisherConfiguration{mPushUrl='");
        sb.append(this.mPushUrl);
        sb.append('\'');
        sb.append(", mPureAudio=");
        sb.append(this.mPureAudio);
        sb.append(", videoMixerParams=");
        VideoMixerParams videoMixerParams2 = this.videoMixerParams;
        sb.append(videoMixerParams2 == null ? "null" : videoMixerParams2.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class VideoMixerParams {
        public int mVideoMixerBitrate;
        public int mVideoMixerFps;
        public int mVideoMixerGop;
        public int mVideoMixerHeight;
        public int mVideoMixerHighQualityMode;
        public int mVideoMixerWidth;

        public String toString() {
            return "VideoMixerParams{mVideoMixerWidth=" + this.mVideoMixerWidth + ", mVideoMixerHeight=" + this.mVideoMixerHeight + ", mVideoMixerFps=" + this.mVideoMixerFps + ", mVideoMixerBitrate=" + this.mVideoMixerBitrate + ", mVideoMixerHighQualityMode=" + this.mVideoMixerHighQualityMode + ", mVideoMixerGop=" + this.mVideoMixerGop + '}';
        }
    }
}
