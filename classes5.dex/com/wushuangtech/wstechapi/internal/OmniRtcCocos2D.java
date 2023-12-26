package com.wushuangtech.wstechapi.internal;

import android.text.TextUtils;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcEngineEventHandler;
import com.wushuangtech.wstechapi.OmniRtcEngineForGamming;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OmniRtcCocos2D extends OmniRtcEngineEventHandler {
    private Lock mLock = new ReentrantLock();
    private ConcurrentLinkedQueue<String> mReceiveMeesage = new ConcurrentLinkedQueue<>();

    public void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    public OmniRtcCocos2D() {
        OmniLog.i("wzg TTTRtcCocos2D build... ");
        OmniRtcEngineForGamming.getInstance().setTTTRtcEngineForGammingEventHandler(this);
    }

    public void onJoinChannelSuccess(String str, long j, int i) {
        buildAndSaveMeesage("onJoinChannelSuccess", str, Long.valueOf(j), 0);
    }

    public void onError(int i) {
        buildAndSaveMeesage("onError", Integer.valueOf(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 8 ? 9005 : 9002 : 9004 : 9003 : 9001 : 9000));
    }

    public void onReconnectServerFailed() {
        buildAndSaveMeesage("onConnectionLost");
    }

    public void onLeaveChannel(RtcStats rtcStats) {
        buildAndSaveMeesage("onLeaveChannel", Integer.valueOf(rtcStats.totalDuration), Integer.valueOf(rtcStats.txBytes), Integer.valueOf(rtcStats.rxBytes), Integer.valueOf(rtcStats.txAudioKBitRate), Integer.valueOf(rtcStats.rxAudioKBitRate), 0);
    }

    public void onUserJoined(long j, int i, int i2) {
        buildAndSaveMeesage("onUserJoined", Long.valueOf(j), 0);
    }

    public void onUserOffline(long j, int i) {
        int i2;
        switch (i) {
            case 201:
                i2 = 1;
                break;
            case 202:
                i2 = 2;
                break;
            default:
                i2 = 0;
                break;
        }
        buildAndSaveMeesage("onUserOffline", Long.valueOf(j), Integer.valueOf(i2));
    }

    public void onAudioRouteChanged(int i) {
        buildAndSaveMeesage("onAudioRouteChanged", Integer.valueOf(i != 0 ? (i == 1 || i != 2) ? 1 : 2 : 0));
    }

    private void buildAndSaveMeesage(Object... objArr) {
        this.mLock.lock();
        try {
            StringBuilder sb = new StringBuilder();
            for (Object append : objArr) {
                sb.append(append);
                sb.append("\t");
            }
            this.mReceiveMeesage.add(sb.toString());
        } finally {
            this.mLock.unlock();
        }
    }

    private String getJavaMessage() {
        this.mLock.lock();
        try {
            String poll = this.mReceiveMeesage.poll();
            if (TextUtils.isEmpty(poll)) {
                poll = null;
            }
            return poll;
        } finally {
            this.mLock.unlock();
        }
    }
}
