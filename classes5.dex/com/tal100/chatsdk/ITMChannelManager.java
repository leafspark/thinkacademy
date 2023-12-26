package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;

public interface ITMChannelManager {
    PMDefs.ChannelResult createChannel(String str, String str2, String str3, ITMChannelListener iTMChannelListener);

    void destroyChannel(ITMChannel iTMChannel);
}
