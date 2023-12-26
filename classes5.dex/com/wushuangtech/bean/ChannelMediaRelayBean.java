package com.wushuangtech.bean;

import com.wushuangtech.api.RtcRelayRtcChannel;
import com.wushuangtech.expansion.bean.ChannelMediaInfo;

public class ChannelMediaRelayBean {
    public ChannelMediaInfo mChannelMediaInfo;
    public RtcRelayRtcChannel mRtcRelayRtcChannel;

    public ChannelMediaRelayBean(ChannelMediaInfo channelMediaInfo, RtcRelayRtcChannel rtcRelayRtcChannel) {
        this.mChannelMediaInfo = channelMediaInfo;
        this.mRtcRelayRtcChannel = rtcRelayRtcChannel;
    }
}
