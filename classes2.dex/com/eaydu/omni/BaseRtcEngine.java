package com.eaydu.omni;

import android.view.TextureView;
import android.view.View;
import com.eaydu.omni.RTCEngine;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseRtcEngine {
    protected final ArrayList<IActivityStateCallback> activityStateCallbacks = new ArrayList<>();

    protected interface IActivityStateCallback {
        void onState(int i);
    }

    public int addPublishStreamUrl(String str, boolean z) {
        return -2;
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        return -2;
    }

    public int checkFeatureSupport(RTCEngine.RTCFeature rTCFeature) {
        return -2;
    }

    public int contentInspectExtra(String str, RTCEngine.InspectMode[] inspectModeArr) {
        return -2;
    }

    public abstract BaseRTCChannel createChannel(String str);

    public abstract View createRendererView();

    public TextureView createTextureView() {
        return null;
    }

    public abstract void destory();

    public abstract void disableLastmileProbeTest();

    public abstract int disableVideo();

    public int enableContentInspect(boolean z, int i) {
        return -2;
    }

    public abstract void enableExternalAudio(boolean z, int i, int i2);

    public abstract void enableExternalVideo(boolean z);

    public abstract void enableLastmileProbeTest();

    public abstract void enableLocalAudio(boolean z);

    public abstract void enableLocalVideo(boolean z);

    public abstract void enableVideo();

    public int getAudioMusicCurrentPosition() {
        return -2;
    }

    public int getAudioMusicDuration() {
        return -2;
    }

    public int getCameraPosition() {
        return -2;
    }

    public String getChannelCallId() {
        return "";
    }

    public int getConnectionState() {
        return -2;
    }

    public int getEngineType() {
        return -2;
    }

    public abstract String getSdkVersion();

    public long getTimestamp(int i) {
        return -2;
    }

    public int initWithToken(String str) {
        return 0;
    }

    public abstract int joinRoom();

    public abstract void leaveRoom();

    public abstract void muteAllRemoteAudio(boolean z);

    public abstract void muteAllRemoteVideo(boolean z);

    public abstract void muteAudio(boolean z);

    public abstract int muteLocalAudio(boolean z);

    public abstract int muteLocalVideo(boolean z);

    public abstract void muteRemoteAudio(long j, boolean z);

    public abstract void muteRemoteVideo(long j, boolean z);

    public abstract void muteVideo(boolean z);

    public int pauseAudioMusic() {
        return -2;
    }

    public int playMusicVolume(int i) {
        return -2;
    }

    public int publish() {
        return -2;
    }

    public int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        return -2;
    }

    public int removePublishStreamUrl(String str) {
        return -2;
    }

    public int resumeAudioMusic() {
        return -2;
    }

    public abstract void sendCustomPCMData(byte[] bArr);

    public abstract boolean sendCustomVideoData(byte[] bArr, int i, int i2, int i3, int i4);

    public int sendStreamMessage(long j, byte[] bArr) {
        return -2;
    }

    public int setAVSyncSource(long j) {
        return -2;
    }

    public int setAVSyncSource(long j, long j2) {
        return -2;
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        return -2;
    }

    public int setAudioMode(RTCEngine.RTCAudioMode rTCAudioMode) {
        return -2;
    }

    public int setAudioMusicPosition(int i) {
        return -2;
    }

    public int setAudioProfile(int i, int i2) {
        return -2;
    }

    public int setBusinessUserRole(RTCEngine.RTCUserBusinessType rTCUserBusinessType) {
        return -2;
    }

    public int setCameraPosition(int i) {
        return -2;
    }

    public void setContentInspectListener(RTCEngine.ContentInspectListener contentInspectListener) {
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        return -2;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        return -2;
    }

    public int setExternalAudioSourceVolume(int i, int i2) {
        return -2;
    }

    public int setHowlingMode(int i) {
        return -2;
    }

    public int setLiveMode(int i) {
        return -2;
    }

    public abstract void setLocalRenderMode(RTCEngine.RTCVideoRenderMode rTCVideoRenderMode);

    public abstract void setMediaAudioProcessListener(RTCEngine.IRTCMediaAudioProcess iRTCMediaAudioProcess);

    public abstract void setMediaVideoProcessListener(RTCEngine.IRTCMediaVideoProcess iRTCMediaVideoProcess);

    public int setMediaVideoProcessOptions(boolean z, boolean z2) {
        return -2;
    }

    public abstract void setMirror(boolean z);

    public void setObserver(RTCEngine.RtcEngineEventObserver rtcEngineEventObserver) {
    }

    public int setParams(String str) {
        return -2;
    }

    public void setPlayBackAudioObserver(RTCEngine.IRTCAudioObserver iRTCAudioObserver) {
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, RTCEngine.RawAudioFrameOpMode rawAudioFrameOpMode, int i3) {
        return -2;
    }

    public int setPreviewResolution(int i, int i2) {
        return -2;
    }

    public abstract int setRecordingAudioParameters(int i, int i2);

    public abstract void setRemoteMirror(boolean z);

    public int setRemoteMixedVolume(int i) {
        return -2;
    }

    public abstract void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode);

    public abstract void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode, int i);

    public int setRemoteSubscribeFallbackOption(int i) {
        return -2;
    }

    public int setRemoteVideoStreamType(long j, int i) {
        return -2;
    }

    public int setRole(RTCEngine.RTCRole rTCRole) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public void setRoomId(String str) {
    }

    public abstract int setRtcEngineLog(String str, RTCEngine.RTCEngineLogLevel rTCEngineLogLevel);

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        return -2;
    }

    public int setServerAddress(String str, int i) {
        return -2;
    }

    public int setTimestamp(long j) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public void setToken(String str) {
    }

    public abstract void setVideoEncoderConfiguration(int i, int i2, int i3, int i4, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode);

    public abstract void setVideoEncoderConfiguration(int i, int i2, RTCEngine.RTCEngineVideoBitrate rTCEngineVideoBitrate, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode);

    public abstract void setVolume(long j, int i);

    public abstract void setVolume(long j, int i, String str);

    public int setupLocalVideo(TextureView textureView) {
        return -2;
    }

    public abstract int setupLocalVideo(View view);

    public int setupRemoteVideo(long j, TextureView textureView) {
        return -2;
    }

    public abstract void setupRemoteVideo(View view, long j);

    public abstract void setupRemoteVideo(View view, long j, String str);

    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        return -2;
    }

    public int startPlayMusic(String str) {
        return -2;
    }

    public int startPlayMusic(String str, boolean z, boolean z2, int i) {
        return -2;
    }

    public abstract void startPreview();

    public int stopChannelMediaRelay() {
        return -2;
    }

    public int stopPlayMusic() {
        return -2;
    }

    public abstract void stopPreview();

    public abstract void switchCamera();

    public int switchChannel(String str, String str2) {
        return -2;
    }

    public int switchRoomWithToken(String str) {
        return -2;
    }

    public int takeLocalViewSnapshot() {
        return -2;
    }

    public int takePreEncodeSnapshot() {
        return -2;
    }

    public int takeRemoteViewSnapshot(long j) {
        return -2;
    }

    public int unPublish() {
        return -2;
    }

    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        return -2;
    }

    public int enableContentInspect(boolean z) {
        return enableContentInspect(z);
    }

    public int setActivityState(int i) {
        try {
            Iterator<IActivityStateCallback> it = this.activityStateCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onState(i);
            }
            return -2;
        } catch (Exception unused) {
            return -2;
        }
    }

    /* access modifiers changed from: protected */
    public void addActivityStateCallback(IActivityStateCallback iActivityStateCallback) {
        if (!this.activityStateCallbacks.contains(iActivityStateCallback)) {
            this.activityStateCallbacks.add(iActivityStateCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void removeActivityStateCallback(IActivityStateCallback iActivityStateCallback) {
        this.activityStateCallbacks.remove(iActivityStateCallback);
    }
}
