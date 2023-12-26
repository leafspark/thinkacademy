package com.tal100.chatsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tal100.chatsdk.PMDefs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatClient implements IChatClient {
    private static final String TAG = "ChatClient";
    private static volatile ChatClient mInstance;
    private List<IChatClientListener> mListeners = Collections.synchronizedList(new ArrayList());
    private PeerChatManager mPeerManager = PeerChatManager.getInstance();
    private RoomChatManager mRoomManager = RoomChatManager.getInstance();

    /* access modifiers changed from: package-private */
    public native int nativeInit();

    /* access modifiers changed from: package-private */
    public native int nativeInitWithRole(int i);

    /* access modifiers changed from: package-private */
    public native int nativeLogin(String str, String str2);

    /* access modifiers changed from: package-private */
    public native int nativeLoginWithKickout(String str, String str2, boolean z);

    /* access modifiers changed from: package-private */
    public native int nativeLoginWithKickoutAndMode(String str, String str2, boolean z, int i);

    /* access modifiers changed from: package-private */
    public native int nativeLogout(String str);

    /* access modifiers changed from: package-private */
    public native int nativeSetLiveInfo(PMDefs.LiveInfo liveInfo, String[] strArr);

    /* access modifiers changed from: package-private */
    public native int nativeUnInit();

    public List<IChatClientListener> getListeners() {
        return this.mListeners;
    }

    static {
        System.loadLibrary("chat-native-lib");
    }

    public static ChatClient getInstance() {
        if (mInstance == null) {
            synchronized (ChatClient.class) {
                if (mInstance == null) {
                    mInstance = new ChatClient();
                }
            }
        }
        return mInstance;
    }

    private ChatClient() {
    }

    public void addListener(IChatClientListener iChatClientListener) {
        synchronized (this.mListeners) {
            if (!this.mListeners.contains(iChatClientListener)) {
                this.mListeners.add(iChatClientListener);
            }
        }
    }

    public void removeListener(IChatClientListener iChatClientListener) {
        synchronized (this.mListeners) {
            this.mListeners.remove(iChatClientListener);
        }
    }

    public RoomChatManager getRoomManager() {
        return this.mRoomManager;
    }

    public PeerChatManager getPeerManager() {
        return this.mPeerManager;
    }

    public int init(Context context) {
        if (context == null) {
            return 1;
        }
        return nativeInit();
    }

    public int init(Context context, int i) {
        if (context == null) {
            return 1;
        }
        return nativeInitWithRole(i);
    }

    public int unInit() {
        return nativeUnInit();
    }

    public int setLiveInfo(PMDefs.LiveInfo liveInfo) {
        if (liveInfo == null || TextUtils.isEmpty(liveInfo.nickname) || TextUtils.isEmpty(liveInfo.liveId) || TextUtils.isEmpty(liveInfo.businessId)) {
            return 1;
        }
        List<String> list = liveInfo.roomIds;
        if (list == null || list.size() <= 0) {
            return nativeSetLiveInfo(liveInfo, (String[]) null);
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSetLiveInfo(liveInfo, strArr);
    }

    public int login(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        return nativeLogin(str, str2);
    }

    public int login(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        return nativeLoginWithKickout(str, str2, z);
    }

    public int login(String str, String str2, boolean z, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        return nativeLoginWithKickoutAndMode(str, str2, z, i);
    }

    public int logout(String str) {
        if (str == null) {
            str = "";
        }
        return nativeLogout(str);
    }

    public static void onLoginResponse(PMDefs.LoginResp loginResp) {
        synchronized (getInstance().mListeners) {
            try {
                for (IChatClientListener onLoginResponse : getInstance().mListeners) {
                    onLoginResponse.onLoginResponse(loginResp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void onLogoutNotice(PMDefs.LogoutNotice logoutNotice) {
        synchronized (getInstance().mListeners) {
            try {
                for (IChatClientListener onLogoutNotice : getInstance().mListeners) {
                    onLogoutNotice.onLogoutNotice(logoutNotice);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void onKickoutNotice(PMDefs.KickoutNotice kickoutNotice) {
        synchronized (getInstance().mListeners) {
            try {
                for (IChatClientListener onKickoutNotice : getInstance().mListeners) {
                    onKickoutNotice.onKickoutNotice(kickoutNotice);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void onNetStatusChanged(PMDefs.NetStatusResp netStatusResp) {
        synchronized (getInstance().mListeners) {
            try {
                for (IChatClientListener onNetStatusChanged : getInstance().mListeners) {
                    onNetStatusChanged.onNetStatusChanged(netStatusResp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void onSdkPrivisionStatusNotice(PMDefs.SdkPrivisionStatusNotice sdkPrivisionStatusNotice) {
        synchronized (getInstance().mListeners) {
            try {
                for (IChatClientListener onSdkPrivisionStatusNotice : getInstance().mListeners) {
                    onSdkPrivisionStatusNotice.onSdkPrivisionStatusNotice(sdkPrivisionStatusNotice);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
