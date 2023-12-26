package com.tal.app.thinkacademy.live.core.callback;

import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;

public interface BinaryMessageCallback {
    @Deprecated
    void onBatchHistoryBinaryMessage(BatchBinaryMessage batchBinaryMessage);

    @Deprecated
    void onBinaryMessage(BinaryMessage binaryMessage);

    void onBinaryMessage(BinaryMessageInfo binaryMessageInfo);

    void onSendRoomBinaryMessageFailed(int i, String str, long j);
}
