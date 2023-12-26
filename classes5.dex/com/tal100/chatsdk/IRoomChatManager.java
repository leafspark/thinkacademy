package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;
import java.util.List;
import java.util.Map;

public interface IRoomChatManager {
    void addListener(IRoomChatListener iRoomChatListener);

    int getAllRoomData(String str, long[] jArr);

    int getLiveStatistics(String str, Map<String, String> map, long[] jArr);

    int getRoomBatchHistoryBinaryMessages(List<PMDefs.HistoryBinMsgReqParam> list);

    int getRoomData(String str, List<String> list, long[] jArr);

    int getRoomHistoryBinaryMessages(String str, long j, boolean z);

    int getRoomHistoryBinaryMessages(String str, long j, boolean z, int i);

    int getRoomHistoryBinaryMessages(String str, long j, boolean z, int i, PMDefs.HistoryMsgOption historyMsgOption);

    int getRoomHistoryMessages(String str, long j);

    int getRoomHistoryMessages(String str, long j, PMDefs.HistoryMsgOption historyMsgOption);

    int getRoomMuteStatus(List<String> list);

    int getRoomUserList(List<String> list, int i, long[] jArr);

    int joinChatRooms(List<String> list);

    int joinChatRooms(List<String> list, int i);

    int joinChatRooms(List<String> list, List<PMDefs.MsgSubOption> list2, int i);

    int joinChatRooms(List<String> list, List<PMDefs.MsgSubOption> list2, List<PMDefs.RoomDataSubOption> list3, int i);

    int leaveChatRooms(List<String> list);

    int muteRooms(List<String> list, int i);

    void removeListener(IRoomChatListener iRoomChatListener);

    int sendRoomBinaryMessage(String str, long j, byte[] bArr, long[] jArr);

    int sendRoomBinaryMessage(List<String> list, String str, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr);

    int sendRoomBinaryMessage(List<String> list, String str, long j, byte[] bArr, long[] jArr);

    int sendRoomMessage(List<String> list, String str, int i);

    int sendRoomMessage(List<String> list, String str, int i, PMDefs.MsgOption msgOption, long[] jArr);

    int sendRoomMessage(List<String> list, String str, int i, long[] jArr);

    int setRoomData(String str, Map<String, String> map, long[] jArr);

    int setRoomDataSubscribeOption(List<String> list, List<PMDefs.RoomDataSubOption> list2);

    int setRoomSubscribeOption(List<String> list, List<PMDefs.MsgSubOption> list2);

    int setRoomsData(List<String> list, Map<String, PMDefs.RoomDataElement> map, long[] jArr);
}
