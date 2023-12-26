package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;
import java.util.List;

public interface IPeerChatManager {
    void addListener(IPeerChatListener iPeerChatListener);

    void removeListener(IPeerChatListener iPeerChatListener);

    int sendPeerBinaryMessage(List<PMDefs.PsIdEntity> list, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr);

    int sendPeerBinaryMessage(List<PMDefs.PsIdEntity> list, long j, byte[] bArr, long[] jArr);

    int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i);

    int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i, PMDefs.MsgOption msgOption, long[] jArr);

    int sendPeerMessage(List<PMDefs.PsIdEntity> list, String str, int i, long[] jArr);
}
