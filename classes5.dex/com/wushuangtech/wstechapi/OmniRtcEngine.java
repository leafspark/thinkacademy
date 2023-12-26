package com.wushuangtech.wstechapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.OmniVideoFrame;
import com.wushuangtech.expansion.bean.ScreenRecordConfig;
import com.wushuangtech.expansion.bean.VideoCompositingLayout;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.myvideoimprove.view.OmniSurfaceView;
import com.wushuangtech.myvideoimprove.view.OmniTextureView;
import com.wushuangtech.wstechapi.bean.ChannelMediaOptions;
import com.wushuangtech.wstechapi.bean.OmniVideoMixerCanvas;
import com.wushuangtech.wstechapi.bean.PublisherConfiguration;
import com.wushuangtech.wstechapi.bean.VideoCanvas;
import com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration;
import com.wushuangtech.wstechapi.bean.VideoRotate;
import com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl;

public abstract class OmniRtcEngine {
    private static volatile OmniRtcEngineImpl mInstance;

    public static String getSdkVersion() {
        return GlobalConfig.SDK_VERSION_NAME;
    }

    public abstract void addHandler(OmniRtcEngineEventHandler omniRtcEngineEventHandler);

    public abstract int addPublishStreamUrl(String str, boolean z);

    public abstract int adjustAudioMixingPlayoutVolume(int i);

    public abstract int adjustAudioMixingPublishVolume(int i);

    public abstract int adjustAudioMixingVolume(int i);

    public abstract int adjustPlaybackSignalVolume(String str, int i);

    public abstract int adjustRecordingSignalVolume(int i);

    public abstract int adjustUserPlaybackSignalVolume(long j, int i);

    public abstract int configPublisher(PublisherConfiguration publisherConfiguration);

    public abstract int contentInspectExtra(String str, int[] iArr);

    public abstract int createDataStream(boolean z, boolean z2);

    public abstract OmniRtcChannel createRtcChannel(String str);

    public abstract int disableAudio();

    public abstract int disableLastmileTest();

    public abstract int disableVideo();

    public abstract int enableAudio();

    public abstract void enableAudioDataReport(boolean z, boolean z2);

    public abstract int enableAudioEarBack(boolean z);

    public abstract int enableAudioEffect(boolean z, int i);

    public abstract int enableAudioVolumeIndication(int i, int i2);

    public abstract int enableContentInspect(boolean z, int i);

    public abstract void enableCrossRoom(boolean z);

    public abstract int enableCustomVideoBackgroundImage(boolean z);

    public abstract int enableDualStreamMode(boolean z);

    public abstract int enableLastmileTest();

    public abstract int enableLocalAudio(boolean z);

    public abstract int enableLocalVideo(boolean z);

    public abstract void enableMixAudioDataReport(boolean z);

    public abstract int enableVideo();

    public abstract int enableVideoImproveModule(boolean z);

    public abstract int enableVideoMixer(boolean z);

    public abstract int getAkamai(String str, String str2);

    public abstract IAudioEffectManager getAudioEffectManager();

    public abstract int getAudioMixingCurrentPosition();

    public abstract int getAudioMixingDuration();

    public abstract int getCameraFace();

    public abstract int getCameraMaxZoomFactor();

    public abstract String getChannelSessionId();

    public abstract int getConnectionState();

    public abstract OmniRtcEngineExtend getOmniRtcEngineExtend();

    public abstract int insertH264SeiContent(String str);

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraExposurePositionSupported();

    public abstract boolean isCameraFocusSupported();

    public abstract boolean isCameraTorchSupported();

    public abstract boolean isCameraZoomSupported();

    public abstract boolean isScreenRecording();

    public abstract boolean isSpeakerphoneEnabled();

    public abstract boolean isTextureEncodeSupported();

    public abstract int joinChannel(String str, String str2, long j);

    public abstract boolean kickChannelUser(long j);

    public abstract int leaveChannel();

    public abstract int lowBitRateStreamParameter(int i, int i2, int i3, int i4);

    public abstract int muteAllRemoteAudioStreams(boolean z);

    public abstract int muteAllRemoteVideoStreams(boolean z);

    public abstract int muteLocalAudioStream(boolean z);

    public abstract int muteLocalVideoStream(boolean z);

    public abstract int muteRemoteAudioStream(long j, boolean z);

    public abstract int muteRemoteSpeaking(long j, boolean z);

    public abstract int muteRemoteVideoStream(long j, int i, boolean z);

    public abstract int muteRemoteVideoStream(long j, String str, boolean z);

    public abstract int muteRemoteVideoStream(long j, boolean z);

    public abstract int pauseAudioMixing();

    public abstract int pauseRtmpPublish();

    public abstract int pushExternalAudioFrame(byte[] bArr, long j);

    public abstract int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4);

    public abstract boolean pushExternalVideoFrame(OmniVideoFrame omniVideoFrame);

    public abstract void removeHandler(OmniRtcEngineEventHandler omniRtcEngineEventHandler);

    public abstract int removePublishStreamUrl(String str);

    public abstract int renewToken(String str);

    public abstract int resumeAudioMixing();

    public abstract int resumeRtmpPublish();

    public abstract int sendAudioLyric(String str);

    public abstract int sendStreamMessage(int i, byte[] bArr);

    public abstract int setAVSyncSource(String str, long j);

    public abstract int setAppExtensionInfo(String str);

    public abstract int setAudioApplicationScene(int i);

    public abstract int setAudioEarBackVolume(int i);

    public abstract int setAudioEncoderConfiguration(int i, int i2);

    public abstract int setAudioMixMode(int i, long[] jArr);

    public abstract int setAudioMixerParams(int i, int i2, int i3);

    public abstract int setAudioMixingPosition(long j);

    public abstract int setAudioMode(int i);

    public abstract int setAudioProfile(int i, int i2);

    public abstract int setBeautyFaceStatus(boolean z, float f, float f2);

    public abstract int setBusinessUserRole(int i);

    public abstract int setCameraPreviewResolution(int i, int i2);

    public abstract boolean setCameraTorchOn(boolean z);

    public abstract boolean setCameraZoomFactor(int i);

    public abstract int setChannelProfile(int i);

    public abstract int setClientRole(int i);

    public abstract int setDefaultAudioRouteToSpeakerphone(boolean z);

    public abstract int setDefaultMuteAllRemoteAudioStreams(boolean z);

    public abstract int setDefaultMuteAllRemoteVideoStreams(boolean z);

    public abstract int setEnableSpeakerphone(boolean z);

    public abstract int setExternalAudioSource(boolean z, int i, int i2);

    public abstract int setExternalVideoSource(boolean z, boolean z2, boolean z3);

    public abstract int setImageReportUrl(String str);

    public abstract int setLocalRenderMode(int i, int i2);

    public abstract int setLogFile(String str);

    public abstract int setLogFilter(int i);

    public abstract int setMixedAudioFrameParameters(int i, int i2, int i3);

    public abstract int setParameters(String str);

    public abstract int setParameters(String str, String str2);

    public abstract int setPlaybackAudioFrameParameters(int i, int i2, int i3);

    public abstract int setPreferAudioCodec(int i, int i2, int i3);

    public abstract int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4);

    public abstract int setRemoteDefaultVideoStreamType(int i);

    public abstract int setRemoteRenderMirror(int i);

    public abstract int setRemoteRenderMode(int i);

    public abstract int setRemoteRenderMode(long j, int i, int i2);

    public abstract int setRemoteSubscribeFallbackOption(int i);

    public abstract void setRemoteVideoMirrored(boolean z);

    public abstract int setRemoteVideoStreamType(long j, int i);

    public abstract int setRemoteVolumeAll(int i);

    public abstract void setServerIp(String str, int i);

    public abstract int setServerLogAddress(String str);

    public abstract int setSignalTimeout(int i);

    public abstract int setSlbAddress(String str, String str2);

    public abstract int setVideoBackgroundImage(Bitmap bitmap, int i);

    public abstract int setVideoCompositingLayout(VideoCompositingLayout videoCompositingLayout);

    public abstract int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration);

    public abstract void setVideoMirrored(boolean z, boolean z2);

    public abstract int setVideoMixerBackgroundImgUrl(String str);

    public abstract int setVideoMixerBackgroundImgUrl(String str, String str2);

    @Deprecated
    public abstract int setVideoMixerParams(int i, int i2, int i3, int i4, int i5, int i6);

    @Deprecated
    public abstract int setVideoProfile(int i, int i2, int i3, int i4);

    @Deprecated
    public abstract int setVideoProfile(int i, boolean z);

    public abstract int setupLocalVideo(VideoCanvas videoCanvas);

    public abstract int setupLocalVideo(VideoCanvas videoCanvas, int i);

    public abstract int setupLocalVideo(VideoCanvas videoCanvas, VideoRotate videoRotate);

    public abstract int setupRemoteVideo(VideoCanvas videoCanvas);

    public abstract int setupRemoteVideoMixer(OmniVideoMixerCanvas omniVideoMixerCanvas);

    public abstract int startAudioMixing(String str, boolean z, boolean z2, int i);

    public abstract int startAudioRecording(String str, int i);

    public abstract int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int startIjkPlayer(String str, boolean z);

    public abstract int startPreview();

    public abstract int startRecordScreen(Intent intent, ScreenRecordConfig screenRecordConfig);

    public abstract int startRecordScreenAndSave(Intent intent, ScreenRecordConfig screenRecordConfig);

    public abstract int startRtmpPublish(String str);

    public abstract int stopAudioMixing();

    public abstract int stopAudioPlayAndRecord(boolean z);

    public abstract int stopAudioRecording();

    public abstract int stopChannelMediaRelay();

    public abstract int stopIjkPlayer();

    public abstract int stopPreview();

    public abstract int stopRtmpPublish();

    public abstract int stopScreenCapture();

    public abstract int subscribeOtherChannel(String str);

    public abstract int switchCamera();

    public abstract int switchChannel(String str, String str2);

    public abstract int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions);

    public abstract int takeLocalViewSnapshot();

    public abstract int takePreEncodeSnapshot();

    public abstract int takeRemoteViewSnapshot(long j);

    public abstract int tryRecordScreen(Activity activity);

    public abstract int unSubscribeOtherChannel(String str);

    public abstract int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int updateRtmpUrl(String str);

    public abstract int uploadLocalVideo(boolean z);

    public static synchronized OmniRtcEngine create(Context context, String str, OmniRtcEngineEventHandler omniRtcEngineEventHandler) {
        synchronized (OmniRtcEngine.class) {
            if (context == null) {
                return null;
            }
            if (mInstance == null) {
                mInstance = new OmniRtcEngineImpl(context, str, omniRtcEngineEventHandler);
            } else {
                mInstance.reinitialize(context, str, omniRtcEngineEventHandler);
            }
            OmniRtcEngineImpl omniRtcEngineImpl = mInstance;
            return omniRtcEngineImpl;
        }
    }

    public static OmniRtcEngine getInstance() {
        return mInstance;
    }

    public static synchronized void destroy() {
        synchronized (OmniRtcEngine.class) {
            if (mInstance != null) {
                mInstance.doDestroy();
            }
        }
    }

    public static SurfaceView CreateRendererSurfaceView(Context context) {
        return new OmniSurfaceView(context);
    }

    public static TextureView CreateRendererTextureView(Context context) {
        return new OmniTextureView(context);
    }
}
