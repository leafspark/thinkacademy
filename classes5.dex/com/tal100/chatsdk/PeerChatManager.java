package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeerChatManager implements IPeerChatManager {
    private static volatile PeerChatManager mInstance;
    private List<IPeerChatListener> mListeners = Collections.synchronizedList(new ArrayList());

    /* access modifiers changed from: package-private */
    public native int nativeSendPeerBinaryMessage(PMDefs.PsIdEntity[] psIdEntityArr, long j, byte[] bArr, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendPeerBinaryMessageWithOption(PMDefs.PsIdEntity[] psIdEntityArr, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendPeerMessage(PMDefs.PsIdEntity[] psIdEntityArr, String str, int i);

    /* access modifiers changed from: package-private */
    public native int nativeSendPeerMessageWithMsgId(PMDefs.PsIdEntity[] psIdEntityArr, String str, int i, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendPeerMessageWithOption(PMDefs.PsIdEntity[] psIdEntityArr, String str, int i, PMDefs.MsgOption msgOption, long[] jArr);

    static {
        System.loadLibrary("chat-native-lib");
    }

    protected static PeerChatManager getInstance() {
        if (mInstance == null) {
            synchronized (PeerChatManager.class) {
                if (mInstance == null) {
                    mInstance = new PeerChatManager();
                }
            }
        }
        return mInstance;
    }

    private PeerChatManager() {
    }

    public void addListener(IPeerChatListener iPeerChatListener) {
        synchronized (this.mListeners) {
            if (!this.mListeners.contains(iPeerChatListener)) {
                this.mListeners.add(iPeerChatListener);
            }
        }
    }

    public void removeListener(IPeerChatListener iPeerChatListener) {
        this.mListeners.remove(iPeerChatListener);
    }

    public int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i) {
        if (list == null || str == null) {
            return 1;
        }
        PMDefs.PsIdEntity[] psIdEntityArr = new PMDefs.PsIdEntity[list.size()];
        list.toArray(psIdEntityArr);
        return nativeSendPeerMessage(psIdEntityArr, str, i);
    }

    public int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i, long[] jArr) {
        if (list == null || str == null || jArr == null) {
            return 1;
        }
        PMDefs.PsIdEntity[] psIdEntityArr = new PMDefs.PsIdEntity[list.size()];
        list.toArray(psIdEntityArr);
        return nativeSendPeerMessageWithMsgId(psIdEntityArr, str, i, jArr);
    }

    public int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i, PMDefs.MsgOption msgOption, long[] jArr) {
        if (list == null || str == null || jArr == null) {
            return 1;
        }
        PMDefs.PsIdEntity[] psIdEntityArr = new PMDefs.PsIdEntity[list.size()];
        list.toArray(psIdEntityArr);
        return nativeSendPeerMessageWithOption(psIdEntityArr, str, i, msgOption, jArr);
    }

    public int sendPeerBinaryMessage(List<PMDefs.PsIdEntity> list, long j, byte[] bArr, long[] jArr) {
        if (list == null || bArr == null || jArr == null) {
            return 1;
        }
        PMDefs.PsIdEntity[] psIdEntityArr = new PMDefs.PsIdEntity[list.size()];
        list.toArray(psIdEntityArr);
        return nativeSendPeerBinaryMessage(psIdEntityArr, j, bArr, jArr);
    }

    public int sendPeerBinaryMessage(List<PMDefs.PsIdEntity> list, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr) {
        if (list == null || bArr == null || jArr == null) {
            return 1;
        }
        PMDefs.PsIdEntity[] psIdEntityArr = new PMDefs.PsIdEntity[list.size()];
        list.toArray(psIdEntityArr);
        return nativeSendPeerBinaryMessageWithOption(psIdEntityArr, j, bArr, msgOption, jArr);
    }

    private static void onRecvPeerMessage(PMDefs.PeerChatMessage peerChatMessage) {
        if (peerChatMessage != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IPeerChatListener onRecvPeerMessage : getInstance().mListeners) {
                        onRecvPeerMessage.onRecvPeerMessage(peerChatMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSendPeerMessageResponse(PMDefs.SendPeerMessageResp sendPeerMessageResp) {
        if (sendPeerMessageResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IPeerChatListener onSendPeerMessageResponse : getInstance().mListeners) {
                        onSendPeerMessageResponse.onSendPeerMessageResponse(sendPeerMessageResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvPeerBinaryMessage(PMDefs.PeerChatBinaryMessage peerChatBinaryMessage) {
        if (peerChatBinaryMessage != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IPeerChatListener onRecvPeerBinaryMessage : getInstance().mListeners) {
                        onRecvPeerBinaryMessage.onRecvPeerBinaryMessage(peerChatBinaryMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSendPeerBinaryMessageResponse(PMDefs.SendPeerBinaryMessageResp sendPeerBinaryMessageResp) {
        if (sendPeerBinaryMessageResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IPeerChatListener onSendPeerBinaryMessageResponse : getInstance().mListeners) {
                        onSendPeerBinaryMessageResponse.onSendPeerBinaryMessageResponse(sendPeerBinaryMessageResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
