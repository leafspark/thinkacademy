package com.tal100.chatsdk;

import android.content.Context;
import com.tal100.chatsdk.PMDefs;

public interface IChatClient {
    void addListener(IChatClientListener iChatClientListener);

    int init(Context context);

    int init(Context context, int i);

    int login(String str, String str2);

    int login(String str, String str2, boolean z);

    int login(String str, String str2, boolean z, int i);

    int logout(String str);

    void removeListener(IChatClientListener iChatClientListener);

    int setLiveInfo(PMDefs.LiveInfo liveInfo);

    int unInit();
}
