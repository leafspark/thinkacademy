package com.wushuangtech.audiocore;

import com.wushuangtech.audiocore.callback.ExternalAudioProcessCallback;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.library.GlobalHolder;

public class MyExternalAudioProcessCallbackImpl implements ExternalAudioProcessCallback {
    public byte[] onRecordPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        GlobalHolder instance = GlobalHolder.getInstance();
        Object[] objArr = new Object[4];
        objArr[0] = bArr;
        Integer valueOf = Integer.valueOf(i2);
        int i4 = 1;
        objArr[1] = valueOf;
        objArr[2] = Integer.valueOf(i3);
        if (z) {
            i4 = 2;
        }
        objArr[3] = Integer.valueOf(i4);
        Object sendSyncRtcEngineEvent = instance.sendSyncRtcEngineEvent(RtcEngineEvent.AudioEvent.EVENT_AUDIO_LOCAL_DATA, objArr);
        if (sendSyncRtcEngineEvent != null) {
            return (byte[]) sendSyncRtcEngineEvent;
        }
        return null;
    }

    public byte[] onPlaybackPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        GlobalHolder instance = GlobalHolder.getInstance();
        Object[] objArr = new Object[4];
        objArr[0] = bArr;
        Integer valueOf = Integer.valueOf(i2);
        int i4 = 1;
        objArr[1] = valueOf;
        objArr[2] = Integer.valueOf(i3);
        if (z) {
            i4 = 2;
        }
        objArr[3] = Integer.valueOf(i4);
        Object sendSyncRtcEngineEvent = instance.sendSyncRtcEngineEvent(RtcEngineEvent.AudioEvent.EVENT_AUDIO_REMOTE_DATA, objArr);
        if (sendSyncRtcEngineEvent != null) {
            return (byte[]) sendSyncRtcEngineEvent;
        }
        return null;
    }

    public byte[] OnRemoteAndLocalMixPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        GlobalHolder instance = GlobalHolder.getInstance();
        Object[] objArr = new Object[4];
        objArr[0] = bArr;
        Integer valueOf = Integer.valueOf(i2);
        int i4 = 1;
        objArr[1] = valueOf;
        objArr[2] = Integer.valueOf(i3);
        if (z) {
            i4 = 2;
        }
        objArr[3] = Integer.valueOf(i4);
        Object sendSyncRtcEngineEvent = instance.sendSyncRtcEngineEvent(RtcEngineEvent.AudioEvent.EVENT_AUDIO_MIX_DATA, objArr);
        if (sendSyncRtcEngineEvent != null) {
            return (byte[]) sendSyncRtcEngineEvent;
        }
        return null;
    }
}
