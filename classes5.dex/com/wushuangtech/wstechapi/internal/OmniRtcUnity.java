package com.wushuangtech.wstechapi.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.OmniRtcEngineEventHandler;
import com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig;
import com.wushuangtech.wstechapi.bean.VideoCanvas;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public final class OmniRtcUnity {
    private static final String TAG = "wzg";
    private static OmniRtcUnity mInstance;
    /* access modifiers changed from: private */
    public boolean isJoined = false;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mLocalHeight;
    /* access modifiers changed from: private */
    public long mLocalId;
    /* access modifiers changed from: private */
    public int mLocalWidth;
    /* access modifiers changed from: private */
    public LinkedList<String> mMessage = new LinkedList<>();
    /* access modifiers changed from: private */
    public OmniRtcEngine mOmniRtcEngine;
    private int mRoomMode = 2;
    private boolean mSwapWidthAndHeight = false;
    private int mVideoProfile = 160223;

    public void cancleRecordChatAudio() {
    }

    public void enableChat() {
    }

    public boolean isChatAudioPlaying() {
        return false;
    }

    public void playChatAudio(String str) {
    }

    public void sendChatMessage(long j, int i, String str, String str2) {
    }

    public void sendSignal(long j, String str, String str2) {
    }

    public void speechRecognition(String str) {
    }

    public void startRecordChatAudio() {
    }

    public void stopChatAudio() {
    }

    public int stopRecordAndSendChatAudio(long j, String str) {
        return 0;
    }

    private OmniRtcUnity(Context context, String str) {
        OmniLog.d(TAG, "OmniRtcUnity create invoked! mAppID : " + str);
        this.mContext = context;
        EngineHandler engineHandler = new EngineHandler();
        OmniRtcEngine create = OmniRtcEngine.create(this.mContext, str, engineHandler);
        this.mOmniRtcEngine = create;
        create.addHandler(engineHandler);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.wstechapi.internal.OmniRtcUnity create(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.wushuangtech.wstechapi.internal.OmniRtcUnity> r0 = com.wushuangtech.wstechapi.internal.OmniRtcUnity.class
            monitor-enter(r0)
            com.wushuangtech.wstechapi.internal.OmniRtcUnity r1 = mInstance     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x001f
            monitor-enter(r0)     // Catch:{ all -> 0x0023 }
            com.wushuangtech.wstechapi.internal.OmniRtcUnity r1 = mInstance     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x001a
            java.lang.String r1 = "wzg"
            java.lang.String r2 = "TTTRtcUnity create ...."
            com.wushuangtech.utils.OmniLog.d(r1, r2)     // Catch:{ all -> 0x001c }
            com.wushuangtech.wstechapi.internal.OmniRtcUnity r1 = new com.wushuangtech.wstechapi.internal.OmniRtcUnity     // Catch:{ all -> 0x001c }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x001c }
            mInstance = r1     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            goto L_0x001f
        L_0x001c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x001f:
            com.wushuangtech.wstechapi.internal.OmniRtcUnity r3 = mInstance     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return r3
        L_0x0023:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniRtcUnity.create(android.content.Context, java.lang.String):com.wushuangtech.wstechapi.internal.OmniRtcUnity");
    }

    public synchronized void destroy() {
        OmniLog.d(TAG, "TTTRtcUnity destroy invoked!");
    }

    public String getVersion() {
        OmniLog.d(TAG, "TTTRtcUnity getVersion invoked!");
        return OmniRtcEngine.getSdkVersion();
    }

    public int setClientRole(int i) {
        OmniLog.d(TAG, "TTTRtcUnity setClientRole invoked!");
        return this.mOmniRtcEngine.setClientRole(3);
    }

    public synchronized int joinChannel(String str, int i) {
        OmniLog.d(TAG, "TTTRtcUnity joinChannel invoked! channelName : " + str + " | optionalUid : " + i);
        return this.mOmniRtcEngine.joinChannel("", str, (long) i);
    }

    public synchronized int joinChannel(String str, String str2, int i) {
        long j;
        OmniLog.d(TAG, "TTTRtcUnity joinChannel invoked! channelKey : " + str + " | channelName : " + str2 + " | optionalUid : " + i);
        this.mOmniRtcEngine.setChannelProfile(this.mRoomMode);
        enableChat();
        j = (long) i;
        this.mLocalId = j;
        return this.mOmniRtcEngine.joinChannel(str, str2, j);
    }

    public synchronized int leaveChannel() {
        OmniLog.d(TAG, "TTTRtcUnity leaveChannel invoked!");
        return this.mOmniRtcEngine.leaveChannel();
    }

    public int enableVideo() {
        OmniLog.d(TAG, "TTTRtcUnity enableVideo invoked!");
        this.mOmniRtcEngine.setVideoProfile(this.mVideoProfile, this.mSwapWidthAndHeight);
        this.mOmniRtcEngine.enableVideo();
        return 0;
    }

    public int disableVideo() {
        OmniLog.d(TAG, "TTTRtcUnity disableVideo invoked!");
        return this.mOmniRtcEngine.disableVideo();
    }

    public int enableLocalVideo(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity enableLocalVideo invoked! enabled : " + z);
        return this.mOmniRtcEngine.enableLocalVideo(z);
    }

    public int startPreview() {
        OmniLog.d(TAG, "TTTRtcUnity startPreview invoked!");
        return this.mOmniRtcEngine.startPreview();
    }

    public int stopPreview() {
        OmniLog.d(TAG, "TTTRtcUnity stopPreview invoked!");
        return this.mOmniRtcEngine.stopPreview();
    }

    public int setEnableSpeakerphone(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity setEnableSpeakerphone invoked! enabled : " + z);
        return this.mOmniRtcEngine.setEnableSpeakerphone(z);
    }

    public boolean isSpeakerphoneEnabled() {
        OmniLog.d(TAG, "TTTRtcUnity isSpeakerphoneEnabled invoked!");
        return this.mOmniRtcEngine.isSpeakerphoneEnabled();
    }

    public int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity setDefaultAudioRoutetoSpeakerphone invoked! defaultToSpeaker : " + z);
        return this.mOmniRtcEngine.setDefaultAudioRouteToSpeakerphone(z);
    }

    public int enableAudioVolumeIndication(int i, int i2) {
        OmniLog.d(TAG, "TTTRtcUnity enableAudioVolumeIndication invoked! interval : " + i);
        return this.mOmniRtcEngine.enableAudioVolumeIndication(i, i2);
    }

    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        OmniLog.d(TAG, "TTTRtcUnity startAudioMixing invoked! filePath : " + str);
        return this.mOmniRtcEngine.startAudioMixing(str, z, z2, i);
    }

    public int stopAudioMixing() {
        OmniLog.d(TAG, "TTTRtcUnity stopAudioMixing invoked!");
        return this.mOmniRtcEngine.stopAudioMixing();
    }

    public int pauseAudioMixing() {
        OmniLog.d(TAG, "TTTRtcUnity pauseAudioMixing invoked!");
        return this.mOmniRtcEngine.pauseAudioMixing();
    }

    public int resumeAudioMixing() {
        OmniLog.d(TAG, "TTTRtcUnity resumeAudioMixing invoked!");
        return this.mOmniRtcEngine.resumeAudioMixing();
    }

    public int adjustAudioMixingVolume(int i) {
        OmniLog.d(TAG, "TTTRtcUnity adjustAudioMixingVolume invoked! volume : " + i);
        return this.mOmniRtcEngine.adjustAudioMixingVolume(i);
    }

    public int getAudioMixingDuration() {
        OmniLog.d(TAG, "TTTRtcUnity getAudioMixingDuration invoked!");
        return this.mOmniRtcEngine.getAudioMixingDuration();
    }

    public int getAudioMixingCurrentPosition() {
        OmniLog.d(TAG, "TTTRtcUnity getAudioMixingCurrentPosition invoked!");
        return this.mOmniRtcEngine.getAudioMixingCurrentPosition();
    }

    public int muteLocalAudioStream(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity muteLocalAudioStream invoked! mute : " + z);
        return this.mOmniRtcEngine.muteLocalAudioStream(z);
    }

    public int muteAllRemoteAudioStreams(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity muteAllRemoteAudioStreams invoked! mute : " + z);
        return this.mOmniRtcEngine.muteAllRemoteAudioStreams(z);
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity muteRemoteAudioStream invoked! mute : " + z);
        return this.mOmniRtcEngine.muteRemoteAudioStream(j, z);
    }

    public int switchCamera() {
        OmniLog.d(TAG, "TTTRtcUnity switchCamera invoked!");
        return this.mOmniRtcEngine.switchCamera();
    }

    public int setVideoProfile(int i, boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity setVideoProfile invoked! profile : " + i);
        if (i == 0) {
            this.mVideoProfile = 110;
        } else if (i == 10) {
            this.mVideoProfile = 111;
        } else if (i == 20) {
            this.mVideoProfile = 112;
        } else if (i == 30) {
            this.mVideoProfile = 113;
        } else if (i == 40) {
            this.mVideoProfile = 114;
        } else if (i == 50) {
            this.mVideoProfile = 115;
        } else if (i == 60) {
            this.mVideoProfile = 116;
        }
        this.mSwapWidthAndHeight = !z;
        return 0;
    }

    public int muteAllRemoteVideoStreams(boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity muteAllRemoteVideoStreams invoked!");
        return this.mOmniRtcEngine.muteAllRemoteVideoStreams(z);
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        OmniLog.d(TAG, "TTTRtcUnity muteRemoteVideoStream invoked! uid : " + j + " | muted : " + z);
        return this.mOmniRtcEngine.muteRemoteVideoStream(j, z);
    }

    public int setChannelProfile(int i) {
        OmniLog.d(TAG, "TTTRtcUnity setChannelProfile invoked! profile : " + i);
        this.mRoomMode = i;
        return 0;
    }

    public int setLogFile(String str) {
        OmniLog.d(TAG, "TTTRtcUnity setLogFile invoked! filePath : " + str);
        return this.mOmniRtcEngine.setLogFile(str);
    }

    public int setLogFilter(int i) {
        OmniLog.d(TAG, "TTTRtcUnity setLogFilter invoked! filter : " + i);
        return this.mOmniRtcEngine.setLogFilter(i);
    }

    public int getMessageCount() {
        OmniLog.d(TAG, "TTTRtcUnity getMessageCount invoked! message size : " + this.mMessage.size());
        return this.mMessage.size();
    }

    public String getMessage() {
        OmniLog.d(TAG, "TTTRtcUnity getMessage invoked! message size : " + this.mMessage.size());
        return this.mMessage.poll();
    }

    private class EngineHandler extends OmniRtcEngineEventHandler {
        public void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
        }

        public void onLocalVideoStats(LocalVideoStats localVideoStats) {
        }

        public void onRemoteVideoStats(RemoteVideoStats remoteVideoStats) {
        }

        private EngineHandler() {
        }

        public void onError(int i) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onError invoked! err : " + i);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onError\t" + i);
        }

        public void onUserKicked(long j, int i, int i2) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onUserKicked invoked! uid : " + j + " | reason : " + i);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onUserKicked\t" + j + "\t" + i);
        }

        public void onReconnectServerFailed() {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onReconnectServerFailed invoked!");
            OmniRtcUnity.this.mMessage.add("onConnectionLost");
        }

        public void onJoinChannelSuccess(String str, long j, int i) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onJoinChannelSuccess invoked! channel : " + str + " | uid : " + j);
            boolean unused = OmniRtcUnity.this.isJoined = true;
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onJoinChannelSuccess\t" + str + "\t" + j + "\t0");
            OmniRtcUnity.this.mOmniRtcEngine.setupLocalVideo(new VideoCanvas(j, 1, OmniRtcEngine.CreateRendererSurfaceView(OmniRtcUnity.this.mContext)), 1);
            if (OmniRtcUnity.this.mLocalWidth != 0 && OmniRtcUnity.this.mLocalHeight != 0) {
                LinkedList access$1002 = OmniRtcUnity.this.mMessage;
                access$1002.add("onFirstLocalVideoFrame\t" + OmniRtcUnity.this.mLocalId + "\t" + OmniRtcUnity.this.mLocalWidth + "\t" + OmniRtcUnity.this.mLocalHeight + "\t" + 0);
            }
        }

        public void onUserJoined(long j, int i, int i2) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onUserJoined invoked! nUserId : " + j);
            OmniRtcUnity.this.mOmniRtcEngine.setupRemoteVideo(new VideoCanvas(j, 1, OmniRtcEngine.CreateRendererSurfaceView(OmniRtcUnity.this.mContext)));
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onUserJoined\t" + j + "\t" + i);
        }

        public void onFirstLocalVideoFrame(int i, int i2, int i3) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onFirstLocalVideoFrame invoked! width : " + i + " | height : " + i2);
            int unused = OmniRtcUnity.this.mLocalWidth = i;
            int unused2 = OmniRtcUnity.this.mLocalHeight = i2;
            if (OmniRtcUnity.this.isJoined) {
                LinkedList access$100 = OmniRtcUnity.this.mMessage;
                access$100.add("onFirstLocalVideoFrame\t" + OmniRtcUnity.this.mLocalId + "\t" + i + "\t" + i2 + "\t" + 0);
            }
        }

        public void onFirstRemoteVideoFrame(long j, int i, int i2, int i3) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onFirstRemoteVideoFrame invoked! uid : " + j + " | width : " + i + " | height : " + i2);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onFirstRemoteVideoFrameDecoded\t" + j + "\t" + i + "\t" + i2 + "\t" + 0);
        }

        public void onUserOffline(long j, int i) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onUserOffline invoked! nUserId : " + j + " | reason : " + i);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onUserOffline\t" + j + "\t" + i);
        }

        public void onCameraReady() {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onCameraReady invoked!");
            OmniRtcUnity.this.mMessage.add("onCameraReady");
        }

        public void onLeaveChannel(RtcStats rtcStats) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onLeaveChannel invoked!");
            boolean unused = OmniRtcUnity.this.isJoined = false;
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onLeaveChannel\t" + rtcStats.totalDuration + "\t" + rtcStats.txAudioKBitRate + "\t" + rtcStats.rxAudioKBitRate + "\t" + GlobalConfig.mLocalUserID);
        }

        public void onUserMuteAudio(long j, boolean z) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onUserMuteAudio invoked! uid : " + j + " | muted : " + z);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onAudioMutedByPeer\t" + j + "\t" + z);
        }

        public void onAudioRouteChanged(int i) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onAudioRouteChanged invoked! routing : " + i);
            LinkedList access$100 = OmniRtcUnity.this.mMessage;
            access$100.add("onAudioRouteChanged\t" + i);
        }

        public void onRtcStats(RtcStats rtcStats) {
            OmniLog.d(OmniRtcUnity.TAG, "TTTRtcUnity onRtcStats invoked! stats : " + rtcStats.toString());
            OmniRtcUnity.this.mMessage.add("onRtcStats");
        }
    }

    private byte[] getRemoteBuffer(String str) {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(41, new Object[]{str}));
        if (handleVideoModule != null) {
            return (byte[]) handleVideoModule;
        }
        return null;
    }

    private byte[] getLocalBuffer() {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(46, new Object[0]));
        if (handleVideoModule != null) {
            return (byte[]) handleVideoModule;
        }
        return null;
    }

    private int getRemoteWidth(String str) {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(42, new Object[]{str}));
        if (handleVideoModule != null) {
            return ((Integer) handleVideoModule).intValue();
        }
        return 0;
    }

    private int getRemoteHeight(String str) {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(43, new Object[]{str}));
        if (handleVideoModule != null) {
            return ((Integer) handleVideoModule).intValue();
        }
        return 0;
    }

    private int getLocalWidth() {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(44, new Object[0]));
        if (handleVideoModule != null) {
            return ((Integer) handleVideoModule).intValue();
        }
        return 0;
    }

    private int getLocalHeight() {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(45, new Object[0]));
        if (handleVideoModule != null) {
            return ((Integer) handleVideoModule).intValue();
        }
        return 0;
    }

    public byte[] getDeviceBuffer(int i) {
        long j = (long) i;
        UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(j);
        if (userDefaultDevice == null) {
            OmniLog.uty_e("TTTRtcUnity getDeviceBuffer", "device is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return null;
        }
        String deviceId = userDefaultDevice.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            OmniLog.uty_e("TTTRtcUnity getDeviceBuffer", "device id is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return null;
        }
        OmniLog.uty_d("TTTRtcUnity getDeviceBuffer", "mLocalId - uid - deviceID | " + this.mLocalId + " - " + i + " - " + deviceId);
        return j == this.mLocalId ? getLocalBuffer() : getRemoteBuffer(deviceId);
    }

    public int getDeviceWidth(int i) {
        long j = (long) i;
        UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(j);
        if (userDefaultDevice == null) {
            OmniLog.uty_e("TTTRtcUnity getDeviceWidth", "device is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return 0;
        }
        String deviceId = userDefaultDevice.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            OmniLog.uty_e("TTTRtcUnity getDeviceWidth", "device id is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return 0;
        }
        OmniLog.uty_d("TTTRtcUnity getDeviceWidth", "mLocalId - uid - deviceID | " + this.mLocalId + " - " + i + " - " + deviceId);
        return j == this.mLocalId ? getLocalWidth() : getRemoteWidth(deviceId);
    }

    public int getDeviceHeight(int i) {
        long j = (long) i;
        UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(j);
        if (userDefaultDevice == null) {
            OmniLog.uty_e("TTTRtcUnity getDeviceHeight", "device is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return 0;
        }
        String deviceId = userDefaultDevice.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            OmniLog.uty_e("TTTRtcUnity getDeviceHeight", "device id is null! mLocalId - uid | " + this.mLocalId + " - " + i);
            return 0;
        }
        OmniLog.uty_d("TTTRtcUnity getDeviceHeight", "mLocalId - uid - deviceID | " + this.mLocalId + " - " + i + " - " + deviceId);
        return j == this.mLocalId ? getLocalHeight() : getRemoteHeight(deviceId);
    }

    private Bitmap convertToBitmap(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        OmniLog.d("zhx", "convertToBitmap: local width:" + getLocalWidth() + " height:" + getLocalHeight());
        int localWidth = getLocalWidth();
        int localHeight = getLocalHeight();
        byte[] bArr2 = new byte[(localWidth * localHeight * 4)];
        for (int i = 0; i < localHeight; i++) {
            System.arraycopy(bArr, i * localWidth * 4, bArr2, ((localHeight - i) - 1) * localWidth * 4, localWidth * 4);
        }
        Bitmap createBitmap = Bitmap.createBitmap(localWidth, localHeight, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        File file = new File("/sdcard/PNG/unity.png");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (createBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createBitmap;
    }

    public Object handleVideoModule(OmniLocalModuleConfig omniLocalModuleConfig) {
        return OmniVideoModule.getInstance().receiveVideoModuleEvent(omniLocalModuleConfig);
    }

    public Object handleVideoModule(int i) {
        return OmniVideoModule.getInstance().receiveVideoModuleEvent(i);
    }
}
