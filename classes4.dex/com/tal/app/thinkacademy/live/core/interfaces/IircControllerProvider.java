package com.tal.app.thinkacademy.live.core.interfaces;

import com.tal.app.thinkacademy.live.core.callback.BinaryMessageCallback;
import com.tal.app.thinkacademy.live.core.irc.IrcChatListener;
import com.tal.app.thinkacademy.live.core.irc.entity.HistoryBinMsgReqParam;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.irc.listener.IIrcListener;
import java.util.List;

public interface IircControllerProvider {
    void addBinaryMessageCallback(BinaryMessageCallback binaryMessageCallback);

    @Deprecated
    void addIrcChatListener(IrcChatListener ircChatListener);

    void addIrcListener(IIrcListener iIrcListener);

    void removeBinaryMessageCallback(BinaryMessageCallback binaryMessageCallback);

    @Deprecated
    void removeIrcChatListener(IrcChatListener ircChatListener);

    void removeIrcListener(IIrcListener iIrcListener);

    void requestAllRoomData(String str);

    @Deprecated
    void requestBatchHistoryBinaryMessage(List<HistoryBinMsgReqParam> list);

    @Deprecated
    void requestHistoryBinaryMessage(String str, long j, boolean z);

    void requestHistoryBinaryMessage(String str, long j, boolean z, int i);

    void requestRoomHistoryMessages(String str, long j);

    @Deprecated
    boolean sendMessage(String str, String str2);

    @Deprecated
    boolean sendMessage(String str, String str2, long[] jArr);

    boolean sendNormalMessage(MsgBean msgBean);

    boolean sendNormalMessage(MsgBean msgBean, long[] jArr);

    boolean sendNoticeMessage(MsgBean msgBean);

    @Deprecated
    boolean sendPeerMessage(String str, String str2, int i);

    @Deprecated
    boolean sendPeerMessage(String str, String str2, int i, long[] jArr);

    boolean sendPeerNormalMessage(String str, MsgBean msgBean);

    boolean sendPeerNoticeMessage(String str, MsgBean msgBean);

    @Deprecated
    boolean sendPeerNoticeMessage(String str, String str2);

    boolean sendRoomBinaryMessage(String str, long j, byte[] bArr);

    boolean sendRoomBinaryMessage(String str, long j, byte[] bArr, long[] jArr);
}
