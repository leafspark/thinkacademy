package com.wushuangtech.jni.callback;

import android.os.Message;
import com.wushuangtech.bean.DelayMessageBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.log.ReportLoggerImpl;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RtcEngineSignalDispatcher {
    private static final String TAG = "RtcEngineSignalDispatcher";
    private boolean mIsInRoom;
    private int mLastCameraConnectError;
    private int mLastLocalAudioState;
    private int mLastLocalAudioStateReason;
    private int mLastLocalVideoState;
    private int mLastLocalVideoStateReason;

    public void receiveCallBackEvent(CopyOnWriteArrayList<WeakReference<OmniRtcEngineEventInter>> copyOnWriteArrayList, List<DelayMessageBean> list, Message message) {
        OmniRtcEngineEventInter omniRtcEngineEventInter;
        OmniRtcEngineEventInter omniRtcEngineEventInter2;
        if ((message.what == 7 || message.what == 8 || message.what == 9 || message.what == 15 || message.what == 20 || message.what == 23 || message.what == 60 || message.what == 61 || message.what == 54) && !this.mIsInRoom) {
            list.add(new DelayMessageBean(message.what, (Object[]) message.obj));
            OmniLog.i(OmniLog.ROOM_WATCH, TAG, "Add a new cache signal mesaage : " + message.what + " | size : " + list.size());
        } else if (message.what == 5) {
            Object[] objArr = (Object[]) message.obj;
            Iterator<WeakReference<OmniRtcEngineEventInter>> it = copyOnWriteArrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (!(next == null || (omniRtcEngineEventInter2 = (OmniRtcEngineEventInter) next.get()) == null)) {
                    boolean z = i == 0;
                    if (z) {
                        buildReportLogAndSend(true, "onJoinChannelSuccess", objArr);
                    }
                    omniRtcEngineEventInter2.onJoinChannelSuccess((String) objArr[0], ((Long) objArr[1]).longValue(), calcElapsedTime());
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        DelayMessageBean delayMessageBean = list.get(i2);
                        OmniLog.i(TAG, "Handle cache signal msg, what : " + delayMessageBean.messageType);
                        onReportEvent(omniRtcEngineEventInter2, delayMessageBean.messageType, delayMessageBean.objs, z);
                    }
                    i++;
                }
            }
            if (list.size() > 0) {
                OmniLog.i(TAG, "Handle cache signal msg over!");
                list.clear();
            }
            this.mIsInRoom = true;
        } else {
            Iterator<WeakReference<OmniRtcEngineEventInter>> it2 = copyOnWriteArrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                WeakReference next2 = it2.next();
                if (!(next2 == null || (omniRtcEngineEventInter = (OmniRtcEngineEventInter) next2.get()) == null)) {
                    onReportEvent(omniRtcEngineEventInter, message.what, (Object[]) message.obj, i3 == 0);
                    i3++;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x04a5, code lost:
        r13.onSetSEI((java.lang.String) r8[0]);
        r4 = "onSetSEI";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x04f7, code lost:
        r4 = "onUserEnableVideo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0510, code lost:
        r4 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReportEvent(com.wushuangtech.expansion.inter.OmniRtcEngineEventInter r13, int r14, java.lang.Object[] r15, boolean r16) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r2 = r14
            r8 = r15
            r3 = 30
            java.lang.String r4 = "onUserKicked"
            java.lang.String r7 = "onUserEnableVideo"
            r5 = 1
            r6 = 0
            if (r2 == r3) goto L_0x0609
            r3 = 32
            if (r2 == r3) goto L_0x05f3
            r3 = 46
            if (r2 == r3) goto L_0x05dd
            r3 = 34
            if (r2 == r3) goto L_0x05cb
            r3 = 35
            if (r2 == r3) goto L_0x05bd
            r3 = 63
            if (r2 == r3) goto L_0x05ab
            r3 = 64
            if (r2 == r3) goto L_0x05a4
            r3 = 3
            r9 = 2
            switch(r2) {
                case 6: goto L_0x0595;
                case 7: goto L_0x057a;
                case 8: goto L_0x0563;
                case 9: goto L_0x0539;
                case 10: goto L_0x051a;
                case 11: goto L_0x0513;
                case 12: goto L_0x0509;
                case 13: goto L_0x0501;
                case 14: goto L_0x04fa;
                case 15: goto L_0x04e4;
                case 16: goto L_0x04d7;
                case 17: goto L_0x04c7;
                case 18: goto L_0x04bf;
                case 19: goto L_0x04b0;
                case 20: goto L_0x04a5;
                case 21: goto L_0x049d;
                case 22: goto L_0x0494;
                case 23: goto L_0x046a;
                case 24: goto L_0x0463;
                default: goto L_0x002b;
            }
        L_0x002b:
            switch(r2) {
                case 40: goto L_0x0454;
                case 41: goto L_0x04a5;
                case 42: goto L_0x044d;
                default: goto L_0x002e;
            }
        L_0x002e:
            switch(r2) {
                case 50: goto L_0x0440;
                case 51: goto L_0x0439;
                case 52: goto L_0x042a;
                case 53: goto L_0x0423;
                case 54: goto L_0x0414;
                case 55: goto L_0x03f7;
                case 56: goto L_0x03e0;
                case 57: goto L_0x03cd;
                case 58: goto L_0x03be;
                case 59: goto L_0x03a5;
                case 60: goto L_0x037b;
                case 61: goto L_0x0351;
                default: goto L_0x0031;
            }
        L_0x0031:
            switch(r2) {
                case 68: goto L_0x033e;
                case 69: goto L_0x031a;
                case 70: goto L_0x02fc;
                case 71: goto L_0x02e8;
                case 72: goto L_0x02dd;
                case 73: goto L_0x02d2;
                case 74: goto L_0x02bb;
                case 75: goto L_0x02a2;
                case 76: goto L_0x0281;
                case 77: goto L_0x026a;
                case 78: goto L_0x0246;
                case 79: goto L_0x0222;
                default: goto L_0x0034;
            }
        L_0x0034:
            switch(r2) {
                case 90: goto L_0x021b;
                case 91: goto L_0x0200;
                case 92: goto L_0x01e2;
                case 93: goto L_0x01ae;
                case 94: goto L_0x017a;
                case 95: goto L_0x015c;
                case 96: goto L_0x0157;
                case 97: goto L_0x0140;
                case 98: goto L_0x0131;
                case 99: goto L_0x011a;
                case 100: goto L_0x00fb;
                case 101: goto L_0x00e8;
                case 102: goto L_0x00c9;
                case 103: goto L_0x00aa;
                case 104: goto L_0x0080;
                case 105: goto L_0x0056;
                case 106: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x0510
        L_0x0039:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r13.onNetworkQuality(r2, r4, r5)
            goto L_0x0510
        L_0x0056:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            r1 = r13
            r2 = r6
            r6 = r9
            r1.onAudioSubscribeStateChanged(r2, r4, r5, r6)
            java.lang.String r4 = "onAudioSubscribeStateChanged"
            goto L_0x061e
        L_0x0080:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            r1 = r13
            r2 = r6
            r6 = r9
            r1.onVideoSubscribeStateChanged(r2, r4, r5, r6)
            java.lang.String r4 = "onVideoSubscribeStateChanged"
            goto L_0x061e
        L_0x00aa:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r8[r9]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onAudioPublishStateChanged(r2, r3, r4)
            java.lang.String r4 = "onAudioPublishStateChanged"
            goto L_0x061e
        L_0x00c9:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r8[r9]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onVideoPublishStateChanged(r2, r3, r4)
            java.lang.String r4 = "onVideoPublishStateChanged"
            goto L_0x061e
        L_0x00e8:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
            r13.onTakeRemoteViewSnapshot(r2, r4)
            java.lang.String r4 = "onTakeRemoteViewSnapshot"
            goto L_0x061e
        L_0x00fb:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r13.onRemoteStreamSubscribeAdvice(r2, r4, r5)
            java.lang.String r4 = "onRemoteStreamSubscribeAdvice"
            goto L_0x061e
        L_0x011a:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onCaptureVideoSize(r2, r3)
            java.lang.String r4 = "onCaptureVideoSize"
            goto L_0x061e
        L_0x0131:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onChannelMediaRelayEvent(r2)
            java.lang.String r4 = "onChannelMediaRelayEvent"
            goto L_0x061e
        L_0x0140:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onChannelMediaRelayStateChanged(r2, r3)
            java.lang.String r4 = "onChannelMediaRelayStateChanged"
            goto L_0x061e
        L_0x0157:
            r12.reportVideoRemoteDecodedData(r13, r15)
            goto L_0x0510
        L_0x015c:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            r1 = r13
            r1.onAudioBufferingStateChanged(r2, r4, r5)
            goto L_0x0510
        L_0x017a:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r4 = r0.mLastLocalVideoState
            if (r2 != r4) goto L_0x0193
            int r4 = r0.mLastLocalVideoStateReason
            if (r3 != r4) goto L_0x0193
            return
        L_0x0193:
            r0.mLastLocalVideoState = r2
            r0.mLastLocalVideoStateReason = r3
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onLocalVideoStateChanged(r2, r3)
            java.lang.String r4 = "onLocalVideoStateChanged"
            goto L_0x061e
        L_0x01ae:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r4 = r0.mLastLocalAudioState
            if (r2 != r4) goto L_0x01c7
            int r4 = r0.mLastLocalAudioStateReason
            if (r3 != r4) goto L_0x01c7
            return
        L_0x01c7:
            r0.mLastLocalAudioState = r2
            r0.mLastLocalAudioStateReason = r3
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onLocalAudioStateChanged(r2, r3)
            java.lang.String r4 = "onLocalAudioStateChanged"
            goto L_0x061e
        L_0x01e2:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            r1 = r13
            r1.onVideoBufferingStateChanged(r2, r4, r5)
            goto L_0x0510
        L_0x0200:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = r8[r5]
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r5 = r8[r9]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r13.onRejoinChannelSuccess(r2, r3, r5)
            java.lang.String r4 = "onRejoinChannelSuccess"
            goto L_0x061e
        L_0x021b:
            r13.onRequestToken()
            java.lang.String r4 = "onRequestToken"
            goto L_0x061e
        L_0x0222:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r6 = r12.calcElapsedTime()
            r1 = r13
            r1.onRemoteAudioStateChanged(r2, r4, r5, r6)
            java.lang.String r4 = "onRemoteAudioStateChanged"
            goto L_0x061e
        L_0x0246:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r6 = r12.calcElapsedTime()
            r1 = r13
            r1.onRemoteVideoStateChanged(r2, r4, r5, r6)
            java.lang.String r4 = "onRemoteVideoStateChanged"
            goto L_0x061e
        L_0x026a:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onFirstRemoteAudioFrame(r2, r4)
            java.lang.String r4 = "onFirstRemoteAudioFrame"
            goto L_0x061e
        L_0x0281:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.wushuangtech.library.GlobalConfig.mConnectState = r2
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onConnectionStateChanged(r2, r3)
            java.lang.String r4 = "onConnectionStateChanged"
            goto L_0x061e
        L_0x02a2:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = r8[r9]
            byte[] r5 = (byte[]) r5
            r13.onStreamMessage(r2, r4, r5)
            goto L_0x0510
        L_0x02bb:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r13.onUserMuteVideo(r2, r4)
            java.lang.String r4 = "onUserMuteVideo"
            goto L_0x061e
        L_0x02d2:
            int r2 = r12.calcElapsedTime()
            r13.onFirstLocalVideoFramePublished(r2)
            java.lang.String r4 = "onFirstLocalVideoFramePublished"
            goto L_0x061e
        L_0x02dd:
            int r2 = r12.calcElapsedTime()
            r13.onFirstLocalAudioFrame(r2)
            java.lang.String r4 = "onFirstLocalAudioFrame"
            goto L_0x061e
        L_0x02e8:
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r3 = 150(0x96, float:2.1E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r2[r6] = r5
            long r5 = com.wushuangtech.library.GlobalConfig.mLocalUserID
            r7 = 100
            r13.onUserKicked(r5, r3, r7)
            r8 = r2
            goto L_0x061e
        L_0x02fc:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r0.mLastCameraConnectError
            if (r3 != r2) goto L_0x0309
            return
        L_0x0309:
            r0.mLastCameraConnectError = r2
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onCameraConnectError(r2)
            java.lang.String r4 = "onCameraConnectError"
            goto L_0x061e
        L_0x031a:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r10 = r2.longValue()
            r2 = r8[r5]
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r6 = r2.booleanValue()
            r1 = r13
            r2 = r10
            r1.onUserEnableVideo(r2, r4, r5, r6)
            goto L_0x04f7
        L_0x033e:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.String r4 = (java.lang.String) r4
            r13.onReceiveAudioLyric(r2, r4)
            java.lang.String r4 = "onReceiveAudioLyric"
            goto L_0x061e
        L_0x0351:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            int r10 = r12.calcElapsedTime()
            r1 = r13
            r2 = r6
            r6 = r9
            r7 = r10
            r1.onFirstRemoteVideoFrame(r2, r4, r5, r6, r7)
            goto L_0x0510
        L_0x037b:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            int r10 = r12.calcElapsedTime()
            r1 = r13
            r2 = r6
            r6 = r9
            r7 = r10
            r1.onFirstRemoteVideoDecoded(r2, r4, r5, r6, r7)
            goto L_0x0510
        L_0x03a5:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.String r4 = (java.lang.String) r4
            r5 = r8[r9]
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r13.onUserEnableVideo(r2, r4, r5)
            goto L_0x0510
        L_0x03be:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onAudioEffectFinished(r2)
            java.lang.String r4 = "onAudioEffectFinished"
            goto L_0x061e
        L_0x03cd:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r4 = r12.calcElapsedTime()
            r13.onFirstRemoteAudioDecoded(r2, r4)
            java.lang.String r4 = "onFirstRemoteAudioDecoded"
            goto L_0x061e
        L_0x03e0:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r13.onDualSteamModeEnabled(r2, r4)
            java.lang.String r4 = "onDualSteamModeEnabled"
            goto L_0x061e
        L_0x03f7:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r5 = r8[r5]
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6 = r8[r9]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r13.onUserKicked(r2, r5, r6)
            goto L_0x061e
        L_0x0414:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = r8[r5]
            java.lang.String r3 = (java.lang.String) r3
            r13.onVideoMixerCreated(r2, r3)
            java.lang.String r4 = "onVideoMixerCreated"
            goto L_0x061e
        L_0x0423:
            r13.onReconnectServerSucceed()
            java.lang.String r4 = "onReconnectServerSucceed"
            goto L_0x061e
        L_0x042a:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = r8[r5]
            java.lang.String r3 = (java.lang.String) r3
            r13.onAkamaiServerID(r2, r3)
            java.lang.String r4 = "onAkamaiServerID"
            goto L_0x061e
        L_0x0439:
            r13.onAudioMixingPlayFinish()
            java.lang.String r4 = "onAudioMixingPlayFinish"
            goto L_0x061e
        L_0x0440:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onLastmileQuality(r2)
            goto L_0x0510
        L_0x044d:
            r13.onReconnectServerFailed()
            java.lang.String r4 = "onReconnectServerFailed"
            goto L_0x061e
        L_0x0454:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = -1
            int r5 = r12.calcElapsedTime()
            r13.onJoinChannelSuccess(r2, r3, r5)
            goto L_0x0510
        L_0x0463:
            r13.onTokenPrivilegeWillExpire()
            java.lang.String r4 = "onTokenPrivilegeWillExpire"
            goto L_0x061e
        L_0x046a:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            r1 = r13
            r2 = r6
            r6 = r9
            r1.onFirstRemoteVideoDecoded(r2, r4, r5, r6)
            java.lang.String r4 = "onFirstRemoteVideoDecoded"
            goto L_0x061e
        L_0x0494:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.RemoteAudioStats r2 = (com.wushuangtech.expansion.bean.RemoteAudioStats) r2
            r13.onRemoteAudioStats(r2)
            goto L_0x0510
        L_0x049d:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.LocalAudioStats r2 = (com.wushuangtech.expansion.bean.LocalAudioStats) r2
            r13.onLocalAudioStats(r2)
            goto L_0x0510
        L_0x04a5:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r13.onSetSEI(r2)
            java.lang.String r4 = "onSetSEI"
            goto L_0x061e
        L_0x04b0:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onAudioRouteChanged(r2)
            java.lang.String r4 = "onAudioRouteChanged"
            goto L_0x061e
        L_0x04bf:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.RtcStats r2 = (com.wushuangtech.expansion.bean.RtcStats) r2
            r13.onRtcStats(r2)
            goto L_0x0510
        L_0x04c7:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.AudioVolumeInfo[] r2 = (com.wushuangtech.expansion.bean.AudioVolumeInfo[]) r2
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r13.onAudioVolumeIndication(r2, r3)
            goto L_0x0510
        L_0x04d7:
            r0.mIsInRoom = r6
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.RtcStats r2 = (com.wushuangtech.expansion.bean.RtcStats) r2
            r13.onLeaveChannel(r2)
            java.lang.String r4 = "onLeaveChannel"
            goto L_0x061e
        L_0x04e4:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r13.onUserEnableVideo(r2, r4)
        L_0x04f7:
            r4 = r7
            goto L_0x061e
        L_0x04fa:
            r13.onCameraReady()
            java.lang.String r4 = "onCameraReady"
            goto L_0x061e
        L_0x0501:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.RemoteVideoStats r2 = (com.wushuangtech.expansion.bean.RemoteVideoStats) r2
            r13.onRemoteVideoStats(r2)
            goto L_0x0510
        L_0x0509:
            r2 = r8[r6]
            com.wushuangtech.expansion.bean.LocalVideoStats r2 = (com.wushuangtech.expansion.bean.LocalVideoStats) r2
            r13.onLocalVideoStats(r2)
        L_0x0510:
            r4 = 0
            goto L_0x061e
        L_0x0513:
            r13.onConnectionLost()
            java.lang.String r4 = "onConnectionLost"
            goto L_0x061e
        L_0x051a:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = r8[r5]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r8[r9]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onFirstLocalVideoFrame(r2, r3, r4)
            java.lang.String r4 = "onFirstLocalVideoFrame"
            goto L_0x061e
        L_0x0539:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r6 = r2.longValue()
            r2 = r8[r5]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            r2 = r8[r9]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r5 = r2.intValue()
            r2 = r8[r3]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r9 = r2.intValue()
            r1 = r13
            r2 = r6
            r6 = r9
            r1.onFirstRemoteVideoFrame(r2, r4, r5, r6)
            java.lang.String r4 = "onFirstRemoteVideoFrame"
            goto L_0x061e
        L_0x0563:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onUserOffline(r2, r4)
            java.lang.String r4 = "onUserOffline"
            goto L_0x061e
        L_0x057a:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r5 = r12.calcElapsedTime()
            r13.onUserJoined(r2, r4, r5)
            java.lang.String r4 = "onUserJoined"
            goto L_0x061e
        L_0x0595:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onError(r2)
            java.lang.String r4 = "onError"
            goto L_0x061e
        L_0x05a4:
            r13.onAudioRecordFinish()
            java.lang.String r4 = "onAudioRecordFinish"
            goto L_0x061e
        L_0x05ab:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = r8[r5]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r13.onRtcPushStatus(r2, r3)
            java.lang.String r4 = "onRtcPushStatus"
            goto L_0x061e
        L_0x05bd:
            r2 = r8[r6]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r13.onStatusOfRtmpPublish(r2)
            java.lang.String r4 = "onStatusOfRtmpPublish"
            goto L_0x061e
        L_0x05cb:
            r2 = r8[r6]
            java.lang.String r2 = (java.lang.String) r2
            r3 = r8[r5]
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r13.reportH264SeiContent(r2, r3)
            java.lang.String r4 = "reportH264SeiContent"
            goto L_0x061e
        L_0x05dd:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r13.onSpeakingMuted(r2, r4)
            java.lang.String r4 = "onSpeakingMuted"
            goto L_0x061e
        L_0x05f3:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r13.onUserMuteAudio(r2, r4)
            java.lang.String r4 = "onUserMuteAudio"
            goto L_0x061e
        L_0x0609:
            r2 = r8[r6]
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r4 = r8[r5]
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r13.onClientRoleChanged(r2, r4)
            java.lang.String r4 = "onClientRoleChanged"
        L_0x061e:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x0629
            r1 = r16
            r12.buildReportLogAndSend(r1, r4, r8)
        L_0x0629:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.callback.RtcEngineSignalDispatcher.onReportEvent(com.wushuangtech.expansion.inter.OmniRtcEngineEventInter, int, java.lang.Object[], boolean):void");
    }

    private void reportVideoRemoteDecodedData(OmniRtcEngineEventInter omniRtcEngineEventInter, Object[] objArr) {
        String str = objArr[0];
        long longValue = objArr[1].longValue();
        int intValue = objArr[3].intValue();
        int intValue2 = objArr[4].intValue();
        int intValue3 = objArr[5].intValue();
        int intValue4 = objArr[6].intValue();
        int intValue5 = objArr[7].intValue();
        OmniRtcEngineEventInter omniRtcEngineEventInter2 = omniRtcEngineEventInter;
        long j = longValue;
        long j2 = longValue;
        omniRtcEngineEventInter2.onRenderVideoFrame(j, objArr[2], 0, intValue, intValue2, (intValue3 + intValue4 + intValue5) * intValue2, intValue3, intValue4, intValue5, 0, objArr[8].longValue());
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoRemoteRawDataReport(j2);
        }
    }

    private int calcElapsedTime() {
        long j = GlobalConfig.mEnterRoomTime;
        if (j == 0) {
            return 0;
        }
        return (int) (System.currentTimeMillis() - j);
    }

    private void buildReportLogAndSend(boolean z, String str, Object... objArr) {
        if (!OmniLog.isFastCallBackMessage(str) && z) {
            OmniLog.omniCall(str, Arrays.toString(objArr));
            ReportLoggerImpl.EventBean eventBean = new ReportLoggerImpl.EventBean();
            eventBean.timestamp = System.currentTimeMillis();
            eventBean.funName = str;
            eventBean.objs = objArr;
            GlobalHolder.getInstance().handleUserActionReport(LocalSDKConstants.USER_ACTION_PREFIX_ENGINE, GlobalConfig.mLocalRoomName, 6, eventBean);
        }
    }
}
