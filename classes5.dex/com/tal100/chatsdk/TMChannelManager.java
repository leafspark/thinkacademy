package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;

public class TMChannelManager implements ITMChannelManager {
    private static volatile TMChannelManager mInstance;

    /* access modifiers changed from: package-private */
    public native PMDefs.ChannelResult nativeCreateChannel(String str, String str2, String str3, ITMChannelListener iTMChannelListener);

    /* access modifiers changed from: package-private */
    public native void nativeDestroyChannel(ITMChannel iTMChannel);

    static {
        System.loadLibrary("chat-native-lib");
    }

    public static TMChannelManager getInstance() {
        if (mInstance == null) {
            synchronized (ChatClient.class) {
                if (mInstance == null) {
                    mInstance = new TMChannelManager();
                }
            }
        }
        return mInstance;
    }

    private TMChannelManager() {
    }

    public PMDefs.ChannelResult createChannel(String str, String str2, String str3, ITMChannelListener iTMChannelListener) {
        if (str2 == null || iTMChannelListener == null || str == null || str.length() == 0 || str3 == null) {
            return new PMDefs.ChannelResult(1, (TMChannel) null);
        }
        return nativeCreateChannel(str, str2, str3, iTMChannelListener);
    }

    public void destroyChannel(ITMChannel iTMChannel) {
        if (iTMChannel != null) {
            nativeDestroyChannel(iTMChannel);
        }
    }
}
