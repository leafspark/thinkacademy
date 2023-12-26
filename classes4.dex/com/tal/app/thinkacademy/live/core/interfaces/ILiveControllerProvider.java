package com.tal.app.thinkacademy.live.core.interfaces;

import com.tal.app.thinkacademy.live.core.callback.BinaryMessageCallback;
import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ILiveControllerProvider extends IBaseLiveControllerProvider {
    @Deprecated
    void dispatchBatchBinaryMessage(BatchBinaryMessage batchBinaryMessage);

    @Deprecated
    void dispatchBinaryMessage(BinaryMessage binaryMessage);

    void dispatchBinaryMessage(BinaryMessageInfo binaryMessageInfo);

    void dispatchIrcMessage(String str, String str2);

    void dispatchIrcMessage(Map<String, String> map);

    Set<BinaryMessageCallback> getBinaryCallbackList();

    Map<String, List<String>> getIrcTypeMap();

    void requestAllRoomData();
}
