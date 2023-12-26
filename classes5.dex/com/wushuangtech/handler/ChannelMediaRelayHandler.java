package com.wushuangtech.handler;

import com.wushuangtech.api.RtcRelayRtcChannel;
import com.wushuangtech.bean.ChannelMediaRelayBean;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.expansion.bean.ChannelMediaInfo;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.bean.MediaRelayInfo;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelMediaRelayHandler {
    private static final int RELAY_TYPE_CLIENT = 0;
    private static final int RELAY_TYPE_SERVER = 1;
    private static final String TAG = "ChannelMediaRelayHandler";
    private Map<String, ChannelMediaRelayBean> mCaches;
    private final String mChannelName;
    private int mMediaRelayType = 0;
    private boolean mRelayPushEnabled;
    private final long mUid;

    public ChannelMediaRelayHandler(String str, long j) {
        this.mChannelName = str;
        this.mUid = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int startChannelMediaRelay(com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration r8) {
        /*
            r7 = this;
            int r0 = com.wushuangtech.library.GlobalConfig.mRelayMode
            r7.mMediaRelayType = r0
            if (r8 != 0) goto L_0x0008
            r8 = -5
            return r8
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "startChannelMediaRelay -> configuration = "
            r0.append(r1)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r1 = ", relayType = "
            r0.append(r1)
            int r1 = r7.mMediaRelayType
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RELAY_WATCH"
            java.lang.String r2 = "ChannelMediaRelayHandler"
            com.wushuangtech.utils.OmniLog.i(r1, r2, r0)
            int r0 = r7.mMediaRelayType
            r1 = 1
            if (r0 != r1) goto L_0x0063
            com.wushuangtech.jni.bean.MediaRelayInfo r0 = r7.buildSrcMediaRelayInfo(r8)
            if (r0 != 0) goto L_0x003b
            r8 = -3
            return r8
        L_0x003b:
            com.wushuangtech.jni.bean.MediaRelayInfo[] r8 = r7.buildDestMediaRelayInfoArray(r8)
            com.wushuangtech.jni.RoomJni r2 = com.wushuangtech.jni.RoomJni.getInstance()
            java.lang.String r3 = ""
            r2.StartMediaRelay(r3, r0, r8)
            com.wushuangtech.library.GlobalHolder r2 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r3 = r7.mChannelName
            com.wushuangtech.bean.LogEvent r4 = com.wushuangtech.bean.LogEvent.CHANNEL_MEDIA_RELAY2
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r0
            r5[r1] = r8
            r8 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r5[r8] = r0
            r2.handleRtcEventReport((java.lang.String) r3, (com.wushuangtech.bean.LogEvent) r4, (java.lang.Object[]) r5)
            return r6
        L_0x0063:
            r7.mRelayPushEnabled = r1
            int r8 = r7.updateChannelMediaRelay(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.ChannelMediaRelayHandler.startChannelMediaRelay(com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration):int");
    }

    public void stopChannelMediaRelay() {
        OmniLog.i(OmniLog.RELAY_WATCH, TAG, "stopChannelMediaRelay -> relayType = " + this.mMediaRelayType);
        if (this.mMediaRelayType == 1) {
            RoomJni.getInstance().StopMediaRelay("");
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.CHANNEL_MEDIA_RELAY2, 2);
            return;
        }
        this.mRelayPushEnabled = false;
        if (this.mCaches != null) {
            closeAllRelayChannel();
            this.mCaches.clear();
            this.mCaches = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateChannelMediaRelay(com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0004
            r11 = -5
            return r11
        L_0x0004:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "updateChannelMediaRelay -> configuration = "
            r0.append(r1)
            java.lang.String r1 = r11.toString()
            r0.append(r1)
            java.lang.String r1 = ", relayType = "
            r0.append(r1)
            int r1 = r10.mMediaRelayType
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RELAY_WATCH"
            java.lang.String r2 = "ChannelMediaRelayHandler"
            com.wushuangtech.utils.OmniLog.i(r1, r2, r0)
            int r0 = r10.mMediaRelayType
            r3 = 1
            r4 = -3
            r5 = 0
            if (r0 != r3) goto L_0x0060
            com.wushuangtech.jni.bean.MediaRelayInfo r0 = r10.buildSrcMediaRelayInfo(r11)
            if (r0 != 0) goto L_0x0038
            return r4
        L_0x0038:
            com.wushuangtech.jni.bean.MediaRelayInfo[] r11 = r10.buildDestMediaRelayInfoArray(r11)
            com.wushuangtech.jni.RoomJni r1 = com.wushuangtech.jni.RoomJni.getInstance()
            java.lang.String r2 = ""
            r1.UpdateMediaRelay(r2, r0, r11)
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r2 = r10.mChannelName
            com.wushuangtech.bean.LogEvent r4 = com.wushuangtech.bean.LogEvent.CHANNEL_MEDIA_RELAY2
            r6 = 3
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r5] = r0
            r7[r3] = r11
            r11 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r7[r11] = r0
            r1.handleRtcEventReport((java.lang.String) r2, (com.wushuangtech.bean.LogEvent) r4, (java.lang.Object[]) r7)
            goto L_0x0146
        L_0x0060:
            boolean r0 = r10.mRelayPushEnabled
            if (r0 != 0) goto L_0x0065
            return r4
        L_0x0065:
            java.util.Map r0 = r11.getDestChannelMediaInfos()
            if (r0 == 0) goto L_0x0147
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0073
            goto L_0x0147
        L_0x0073:
            java.util.Map<java.lang.String, com.wushuangtech.bean.ChannelMediaRelayBean> r3 = r10.mCaches
            if (r3 != 0) goto L_0x00a7
            java.util.Map r11 = r10.covertChannelMediaInfos(r0)
            r10.mCaches = r11
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0084
            return r5
        L_0x0084:
            java.util.Map<java.lang.String, com.wushuangtech.bean.ChannelMediaRelayBean> r11 = r10.mCaches
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x008e:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0146
            java.lang.Object r0 = r11.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            com.wushuangtech.bean.ChannelMediaRelayBean r0 = (com.wushuangtech.bean.ChannelMediaRelayBean) r0
            if (r0 != 0) goto L_0x00a3
            goto L_0x008e
        L_0x00a3:
            r10.handleJoinRelayChannel(r0)
            goto L_0x008e
        L_0x00a7:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r11 = r10.parseChannelMediaRelayConfiguration(r11, r0, r3)
            if (r11 == 0) goto L_0x00b8
            return r4
        L_0x00b8:
            java.util.Iterator r11 = r3.iterator()
        L_0x00bc:
            boolean r3 = r11.hasNext()
            java.lang.String r4 = " uid = "
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r3 = r11.next()
            com.wushuangtech.bean.ChannelMediaRelayBean r3 = (com.wushuangtech.bean.ChannelMediaRelayBean) r3
            com.wushuangtech.api.RtcRelayRtcChannel r3 = r3.mRtcRelayRtcChannel
            if (r3 != 0) goto L_0x00cf
            goto L_0x00bc
        L_0x00cf:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Update relay channel, leave channel success! channel = "
            r6.append(r7)
            java.lang.String r7 = r3.channelName()
            r6.append(r7)
            r6.append(r4)
            long r7 = r3.getUserId()
            r6.append(r7)
            java.lang.String r4 = r6.toString()
            com.wushuangtech.utils.OmniLog.i(r1, r2, r4)
            r3.leaveChannel()
            goto L_0x00bc
        L_0x00f5:
            java.util.Iterator r11 = r0.iterator()
        L_0x00f9:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0146
            java.lang.Object r0 = r11.next()
            com.wushuangtech.expansion.bean.ChannelMediaInfo r0 = (com.wushuangtech.expansion.bean.ChannelMediaInfo) r0
            if (r0 != 0) goto L_0x0108
            goto L_0x00f9
        L_0x0108:
            com.wushuangtech.api.RtcRelayRtcChannel r3 = new com.wushuangtech.api.RtcRelayRtcChannel
            java.lang.String r6 = r10.mChannelName
            java.lang.String r7 = r0.mChannelId
            r3.<init>(r6, r7)
            com.wushuangtech.bean.ChannelMediaRelayBean r6 = new com.wushuangtech.bean.ChannelMediaRelayBean
            r6.<init>(r0, r3)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Update relay channel, start join channel! channel = "
            r7.append(r8)
            java.lang.String r8 = r3.channelName()
            r7.append(r8)
            r7.append(r4)
            long r8 = r3.getUserId()
            r7.append(r8)
            java.lang.String r3 = r7.toString()
            com.wushuangtech.utils.OmniLog.i(r1, r2, r3)
            boolean r3 = r10.handleJoinRelayChannel(r6)
            if (r3 == 0) goto L_0x00f9
            java.util.Map<java.lang.String, com.wushuangtech.bean.ChannelMediaRelayBean> r3 = r10.mCaches
            java.lang.String r0 = r0.mChannelId
            r3.put(r0, r6)
            goto L_0x00f9
        L_0x0146:
            return r5
        L_0x0147:
            java.util.Map<java.lang.String, com.wushuangtech.bean.ChannelMediaRelayBean> r11 = r10.mCaches
            if (r11 == 0) goto L_0x0159
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0159
            r10.closeAllRelayChannel()
            java.util.Map<java.lang.String, com.wushuangtech.bean.ChannelMediaRelayBean> r11 = r10.mCaches
            r11.clear()
        L_0x0159:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.ChannelMediaRelayHandler.updateChannelMediaRelay(com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration):int");
    }

    private Map<String, ChannelMediaRelayBean> covertChannelMediaInfos(Map<String, ChannelMediaInfo> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            ChannelMediaInfo channelMediaInfo = (ChannelMediaInfo) next.getValue();
            if (str == null) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mChannelName, 10);
            } else if (channelMediaInfo != null) {
                if (channelMediaInfo.mChannelId == null) {
                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mChannelName, 10);
                } else {
                    hashMap.put(str, new ChannelMediaRelayBean(channelMediaInfo, new RtcRelayRtcChannel(this.mChannelName, str)));
                }
            }
        }
        return hashMap;
    }

    private boolean handleJoinRelayChannel(ChannelMediaRelayBean channelMediaRelayBean) {
        ChannelMediaRelayBean channelMediaRelayBean2 = channelMediaRelayBean;
        ChannelMediaInfo channelMediaInfo = channelMediaRelayBean2.mChannelMediaInfo;
        long j = this.mUid;
        if (channelMediaInfo.mUid != 0) {
            j = channelMediaInfo.mUid;
        }
        RtcRelayRtcChannel rtcRelayRtcChannel = channelMediaRelayBean2.mRtcRelayRtcChannel;
        if (rtcRelayRtcChannel == null) {
            OmniLog.e(OmniLog.RELAY_WATCH, TAG, "Handle relay channel failed! TALRelayRtcChannel is null! " + this.mChannelName + " - " + this.mUid);
            return false;
        }
        String channelName = rtcRelayRtcChannel.channelName();
        GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.MEDIA_RELAY_JOIN, this.mChannelName, channelName, 1, 0);
        int joinChannel = rtcRelayRtcChannel.joinChannel(channelMediaInfo.mToken, j);
        if (joinChannel != 0) {
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.MEDIA_RELAY_JOIN, this.mChannelName, channelName, 1, 1);
            OmniLog.e(OmniLog.RELAY_WATCH, TAG, "Handle relay channel, join channel failed! " + joinChannel);
        } else {
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.MEDIA_RELAY_JOIN, this.mChannelName, channelName, 1, 1);
            OmniLog.i(OmniLog.RELAY_WATCH, TAG, "Handle relay channel, join channel success! channel = " + channelName + " uid = " + j);
        }
        if (joinChannel == 0) {
            return true;
        }
        return false;
    }

    private int parseChannelMediaRelayConfiguration(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, List<ChannelMediaInfo> list, List<ChannelMediaRelayBean> list2) {
        ChannelMediaRelayBean channelMediaRelayBean;
        if (channelMediaRelayConfiguration == null) {
            return 0;
        }
        ChannelMediaInfo srcChannelMediaInfo = channelMediaRelayConfiguration.getSrcChannelMediaInfo();
        if (srcChannelMediaInfo != null && srcChannelMediaInfo.mChannelId != null && !srcChannelMediaInfo.mChannelId.equals(this.mChannelName)) {
            return -3;
        }
        Map<String, ChannelMediaInfo> destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
        for (Map.Entry next : destChannelMediaInfos.entrySet()) {
            String str = (String) next.getKey();
            ChannelMediaInfo channelMediaInfo = (ChannelMediaInfo) next.getValue();
            if (str == null) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mChannelName, 10);
            } else if (!this.mCaches.containsKey(str) && channelMediaInfo != null) {
                if (channelMediaInfo.mChannelId == null) {
                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mChannelName, 10);
                } else {
                    list.add(destChannelMediaInfos.get(str));
                }
            }
        }
        for (Map.Entry next2 : this.mCaches.entrySet()) {
            String str2 = (String) next2.getKey();
            if (!(str2 == null || (channelMediaRelayBean = (ChannelMediaRelayBean) next2.getValue()) == null || destChannelMediaInfos.containsKey(str2))) {
                list2.add(channelMediaRelayBean);
            }
        }
        for (ChannelMediaRelayBean next3 : list2) {
            if (next3.mChannelMediaInfo != null) {
                this.mCaches.remove(next3.mChannelMediaInfo.mChannelId);
            }
        }
        return 0;
    }

    private MediaRelayInfo buildSrcMediaRelayInfo(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        String str;
        String str2 = this.mChannelName;
        long j = this.mUid;
        ChannelMediaInfo srcChannelMediaInfo = channelMediaRelayConfiguration.getSrcChannelMediaInfo();
        if (srcChannelMediaInfo != null) {
            String str3 = srcChannelMediaInfo.mToken;
            String str4 = srcChannelMediaInfo.mChannelId;
            str = str3;
            str2 = str4;
            j = srcChannelMediaInfo.mUid;
        } else {
            str = "";
        }
        if (!str2.equals(this.mChannelName)) {
            OmniLog.e(OmniLog.RELAY_WATCH, TAG, "ARGS ERROR! The current channelId is not equal to received src channelId. receive = " + channelMediaRelayConfiguration.getSrcChannelMediaInfo().toString());
            return null;
        }
        MediaRelayInfo mediaRelayInfo = new MediaRelayInfo();
        mediaRelayInfo.mToken = str;
        mediaRelayInfo.mChannelId = str2;
        mediaRelayInfo.mUid = j;
        return mediaRelayInfo;
    }

    private MediaRelayInfo[] buildDestMediaRelayInfoArray(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        Map<String, ChannelMediaInfo> destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
        int i = 0;
        if (destChannelMediaInfos == null || destChannelMediaInfos.size() <= 0) {
            return new MediaRelayInfo[0];
        }
        MediaRelayInfo[] mediaRelayInfoArr = new MediaRelayInfo[destChannelMediaInfos.size()];
        for (Map.Entry<String, ChannelMediaInfo> value : destChannelMediaInfos.entrySet()) {
            ChannelMediaInfo channelMediaInfo = (ChannelMediaInfo) value.getValue();
            if (channelMediaInfo != null) {
                MediaRelayInfo mediaRelayInfo = new MediaRelayInfo();
                mediaRelayInfo.mToken = channelMediaInfo.mToken;
                mediaRelayInfo.mChannelId = channelMediaInfo.mChannelId;
                mediaRelayInfo.mUid = channelMediaInfo.mUid;
                mediaRelayInfoArr[i] = mediaRelayInfo;
                i++;
            }
        }
        return mediaRelayInfoArr;
    }

    private void closeAllRelayChannel() {
        RtcRelayRtcChannel rtcRelayRtcChannel;
        for (Map.Entry<String, ChannelMediaRelayBean> value : this.mCaches.entrySet()) {
            ChannelMediaRelayBean channelMediaRelayBean = (ChannelMediaRelayBean) value.getValue();
            if (!(channelMediaRelayBean == null || (rtcRelayRtcChannel = channelMediaRelayBean.mRtcRelayRtcChannel) == null)) {
                OmniLog.i(OmniLog.RELAY_WATCH, TAG, "Handle relay channel, leave channel success! channel = " + rtcRelayRtcChannel.channelName() + " uid = " + rtcRelayRtcChannel.getUserId());
                GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.MEDIA_RELAY_JOIN, this.mChannelName, rtcRelayRtcChannel.channelName(), 2, -1);
                rtcRelayRtcChannel.leaveChannel();
            }
        }
    }
}
