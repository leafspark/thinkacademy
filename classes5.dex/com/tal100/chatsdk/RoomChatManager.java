package com.tal100.chatsdk;

import android.text.TextUtils;
import com.tal100.chatsdk.PMDefs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoomChatManager implements IRoomChatManager {
    private static volatile RoomChatManager mInstance;
    private List<IRoomChatListener> mListeners = Collections.synchronizedList(new ArrayList());

    /* access modifiers changed from: package-private */
    public native int nativeGetAllRoomData(String str, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeGetLiveStatistic(String str, String[] strArr, String[] strArr2, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomBatchHistoryBinaryMessages(String[] strArr, long[] jArr, int[] iArr, boolean[] zArr, PMDefs.HistoryMsgOption[] historyMsgOptionArr);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomData(String str, String[] strArr, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomHistoryBinaryMessages(String str, long j, boolean z, int i, PMDefs.HistoryMsgOption historyMsgOption);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomHistoryMessages(String str, long j, PMDefs.HistoryMsgOption historyMsgOption);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomUserList(String[] strArr, int i, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeGetRoomsMuteStatus(String[] strArr);

    /* access modifiers changed from: package-private */
    public native int nativeJoinChatRooms(String[] strArr, int i);

    /* access modifiers changed from: package-private */
    public native int nativeJoinChatRoomsWithRoomDataOption(String[] strArr, PMDefs.MsgSubOption[] msgSubOptionArr, PMDefs.RoomDataSubOption[] roomDataSubOptionArr, int i);

    /* access modifiers changed from: package-private */
    public native int nativeJoinChatRoomsWithSubOption(String[] strArr, PMDefs.MsgSubOption[] msgSubOptionArr, int i);

    /* access modifiers changed from: package-private */
    public native int nativeLeaveChatRooms(String[] strArr);

    /* access modifiers changed from: package-private */
    public native int nativeMuteRooms(String[] strArr, int i);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomBinaryMessage(String str, long j, byte[] bArr, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomBinaryMessageWithOption(String[] strArr, String str, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomMessage(String[] strArr, String str, int i);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomMessageWithMsgId(String[] strArr, String str, int i, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomMessageWithOption(String[] strArr, String str, int i, PMDefs.MsgOption msgOption, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendRoomsBinaryMessage(String[] strArr, String str, long j, byte[] bArr, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSetRoomData(String str, String[] strArr, String[] strArr2, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSetRoomDataSubOption(String[] strArr, PMDefs.RoomDataSubOption[] roomDataSubOptionArr);

    /* access modifiers changed from: package-private */
    public native int nativeSetRoomsData(String[] strArr, String[] strArr2, String[] strArr3, boolean[] zArr, boolean[] zArr2, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSetRoomsSubOption(String[] strArr, PMDefs.MsgSubOption[] msgSubOptionArr);

    static {
        System.loadLibrary("chat-native-lib");
    }

    protected static RoomChatManager getInstance() {
        if (mInstance == null) {
            synchronized (RoomChatManager.class) {
                if (mInstance == null) {
                    mInstance = new RoomChatManager();
                }
            }
        }
        return mInstance;
    }

    private RoomChatManager() {
    }

    public void addListener(IRoomChatListener iRoomChatListener) {
        synchronized (this.mListeners) {
            if (!this.mListeners.contains(iRoomChatListener)) {
                this.mListeners.add(iRoomChatListener);
            }
        }
    }

    public void removeListener(IRoomChatListener iRoomChatListener) {
        this.mListeners.remove(iRoomChatListener);
    }

    public int joinChatRooms(List<String> list, List<PMDefs.MsgSubOption> list2, int i) {
        if (list == null) {
            return 1;
        }
        if (i < 0 || i > 2) {
            i = 0;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        PMDefs.MsgSubOption[] msgSubOptionArr = null;
        if (list2 != null) {
            msgSubOptionArr = new PMDefs.MsgSubOption[list2.size()];
            list2.toArray(msgSubOptionArr);
        }
        return nativeJoinChatRoomsWithSubOption(strArr, msgSubOptionArr, i);
    }

    public int joinChatRooms(List<String> list, List<PMDefs.MsgSubOption> list2, List<PMDefs.RoomDataSubOption> list3, int i) {
        PMDefs.MsgSubOption[] msgSubOptionArr;
        if (list == null) {
            return 1;
        }
        if (i < 0 || i > 2) {
            i = 0;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        PMDefs.RoomDataSubOption[] roomDataSubOptionArr = null;
        if (list2 != null) {
            msgSubOptionArr = new PMDefs.MsgSubOption[list2.size()];
            list2.toArray(msgSubOptionArr);
        } else {
            msgSubOptionArr = null;
        }
        if (list3 != null) {
            roomDataSubOptionArr = new PMDefs.RoomDataSubOption[list3.size()];
            list3.toArray(roomDataSubOptionArr);
        }
        return nativeJoinChatRoomsWithRoomDataOption(strArr, msgSubOptionArr, roomDataSubOptionArr, i);
    }

    public int joinChatRooms(List<String> list, int i) {
        if (list == null) {
            return 1;
        }
        if (i < 0 || i > 2) {
            i = 0;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeJoinChatRooms(strArr, i);
    }

    public int joinChatRooms(List<String> list) {
        if (list == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeJoinChatRooms(strArr, 1);
    }

    public int setRoomSubscribeOption(List<String> list, List<PMDefs.MsgSubOption> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        PMDefs.MsgSubOption[] msgSubOptionArr = new PMDefs.MsgSubOption[list2.size()];
        list2.toArray(msgSubOptionArr);
        return nativeSetRoomsSubOption(strArr, msgSubOptionArr);
    }

    public int setRoomDataSubscribeOption(List<String> list, List<PMDefs.RoomDataSubOption> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        PMDefs.RoomDataSubOption[] roomDataSubOptionArr = new PMDefs.RoomDataSubOption[list2.size()];
        list2.toArray(roomDataSubOptionArr);
        return nativeSetRoomDataSubOption(strArr, roomDataSubOptionArr);
    }

    public int leaveChatRooms(List<String> list) {
        if (list == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeLeaveChatRooms(strArr);
    }

    public int sendRoomMessage(List<String> list, String str, int i) {
        if (list == null || str == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSendRoomMessage(strArr, str, i);
    }

    public int sendRoomMessage(List<String> list, String str, int i, long[] jArr) {
        if (list == null || str == null || jArr == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSendRoomMessageWithMsgId(strArr, str, i, jArr);
    }

    public int sendRoomMessage(List<String> list, String str, int i, PMDefs.MsgOption msgOption, long[] jArr) {
        if (list == null || str == null || jArr == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSendRoomMessageWithOption(strArr, str, i, msgOption, jArr);
    }

    public int sendRoomBinaryMessage(String str, long j, byte[] bArr, long[] jArr) {
        if (TextUtils.isEmpty(str) || bArr == null || jArr == null) {
            return 1;
        }
        return nativeSendRoomBinaryMessage(str, j, bArr, jArr);
    }

    public int sendRoomBinaryMessage(List<String> list, String str, long j, byte[] bArr, long[] jArr) {
        if (TextUtils.isEmpty(str) || bArr == null || jArr == null || list == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSendRoomsBinaryMessage(strArr, str, j, bArr, jArr);
    }

    public int sendRoomBinaryMessage(List<String> list, String str, long j, byte[] bArr, PMDefs.MsgOption msgOption, long[] jArr) {
        List<String> list2 = list;
        if (TextUtils.isEmpty(str) || bArr == null || jArr == null || list2 == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeSendRoomBinaryMessageWithOption(strArr, str, j, bArr, msgOption, jArr);
    }

    public int getRoomHistoryMessages(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return 1;
        }
        return nativeGetRoomHistoryMessages(str, j, new PMDefs.HistoryMsgOption());
    }

    public int getRoomHistoryMessages(String str, long j, PMDefs.HistoryMsgOption historyMsgOption) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return 1;
        }
        return nativeGetRoomHistoryMessages(str, j, historyMsgOption);
    }

    public int getRoomHistoryBinaryMessages(String str, long j, boolean z) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return 1;
        }
        return nativeGetRoomHistoryBinaryMessages(str, j, z, 0, new PMDefs.HistoryMsgOption());
    }

    public int getRoomHistoryBinaryMessages(String str, long j, boolean z, int i) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return 1;
        }
        return nativeGetRoomHistoryBinaryMessages(str, j, z, i, new PMDefs.HistoryMsgOption());
    }

    public int getRoomHistoryBinaryMessages(String str, long j, boolean z, int i, PMDefs.HistoryMsgOption historyMsgOption) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return 1;
        }
        return nativeGetRoomHistoryBinaryMessages(str, j, z, i, historyMsgOption);
    }

    public int getRoomBatchHistoryBinaryMessages(List<PMDefs.HistoryBinMsgReqParam> list) {
        if (list == null || list.isEmpty()) {
            return 1;
        }
        int size = list.size();
        String[] strArr = new String[size];
        long[] jArr = new long[size];
        int[] iArr = new int[size];
        boolean[] zArr = new boolean[size];
        PMDefs.HistoryMsgOption[] historyMsgOptionArr = new PMDefs.HistoryMsgOption[size];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i).key;
            jArr[i] = list.get(i).msgId;
            iArr[i] = list.get(i).count;
            zArr[i] = list.get(i).order;
            historyMsgOptionArr[i] = list.get(i).option;
        }
        return nativeGetRoomBatchHistoryBinaryMessages(strArr, jArr, iArr, zArr, historyMsgOptionArr);
    }

    public int muteRooms(List<String> list, int i) {
        if (list == null || (i != 0 && i != 1)) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeMuteRooms(strArr, i);
    }

    public int getRoomMuteStatus(List<String> list) {
        if (list == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeGetRoomsMuteStatus(strArr);
    }

    public int setRoomData(String str, Map<String, String> map, long[] jArr) {
        if (TextUtils.isEmpty(str) || map == null || jArr == null) {
            return 1;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String next : map.keySet()) {
            arrayList.add(next);
            arrayList2.add(map.get(next));
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        arrayList.toArray(strArr);
        arrayList2.toArray(strArr2);
        return nativeSetRoomData(str, strArr, strArr2, jArr);
    }

    public int setRoomsData(List<String> list, Map<String, PMDefs.RoomDataElement> map, long[] jArr) {
        if (list == null || map == null || jArr == null) {
            return 1;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (String next : map.keySet()) {
            arrayList.add(next);
            arrayList2.add(map.get(next).value);
            arrayList3.add(Boolean.valueOf(map.get(next).save));
            arrayList4.add(Boolean.valueOf(map.get(next).persistent));
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        boolean[] zArr = new boolean[size];
        boolean[] zArr2 = new boolean[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
            strArr2[i] = (String) arrayList2.get(i);
            zArr[i] = ((Boolean) arrayList3.get(i)).booleanValue();
            zArr2[i] = ((Boolean) arrayList4.get(i)).booleanValue();
        }
        String[] strArr3 = new String[list.size()];
        list.toArray(strArr3);
        return nativeSetRoomsData(strArr3, strArr, strArr2, zArr, zArr2, jArr);
    }

    public int getRoomData(String str, List<String> list, long[] jArr) {
        if (TextUtils.isEmpty(str) || list == null || jArr == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeGetRoomData(str, strArr, jArr);
    }

    public int getAllRoomData(String str, long[] jArr) {
        if (TextUtils.isEmpty(str) || jArr == null) {
            return 1;
        }
        return nativeGetAllRoomData(str, jArr);
    }

    public int getLiveStatistics(String str, Map<String, String> map, long[] jArr) {
        if (TextUtils.isEmpty(str) || map == null || jArr == null) {
            return 1;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String next : map.keySet()) {
            arrayList.add(next);
            arrayList2.add(map.get(next));
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
            strArr2[i] = (String) arrayList2.get(i);
        }
        return nativeGetLiveStatistic(str, strArr, strArr2, jArr);
    }

    public int getRoomUserList(List<String> list, int i, long[] jArr) {
        if (list == null || jArr == null) {
            return 1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return nativeGetRoomUserList(strArr, i, jArr);
    }

    private static void onJoinRoomResponse(PMDefs.JoinRoomResp joinRoomResp) {
        if (joinRoomResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onJoinRoomResponse : getInstance().mListeners) {
                        onJoinRoomResponse.onJoinRoomResponse(joinRoomResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onJoinRoomNotice(PMDefs.JoinRoomNotice joinRoomNotice) {
        if (joinRoomNotice != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onJoinRoomNotice : getInstance().mListeners) {
                        onJoinRoomNotice.onJoinRoomNotice(joinRoomNotice);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomMetaData(PMDefs.RoomMetaData roomMetaData) {
        if (roomMetaData != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomMetaData : getInstance().mListeners) {
                        onRecvRoomMetaData.onRecvRoomMetaData(roomMetaData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomDataUpdateNotice(PMDefs.RoomData roomData) {
        if (roomData != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomDataUpdateNotice : getInstance().mListeners) {
                        onRecvRoomDataUpdateNotice.onRecvRoomDataUpdateNotice(roomData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomUserList(PMDefs.RoomUserList roomUserList) {
        if (roomUserList != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomUserList : getInstance().mListeners) {
                        onRecvRoomUserList.onRecvRoomUserList(roomUserList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomTopic(PMDefs.RoomTopic roomTopic) {
        if (roomTopic != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomTopic : getInstance().mListeners) {
                        onRecvRoomTopic.onRecvRoomTopic(roomTopic);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onLeaveRoomResponse(PMDefs.LeaveRoomResp leaveRoomResp) {
        if (leaveRoomResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onLeaveRoomResponse : getInstance().mListeners) {
                        onLeaveRoomResponse.onLeaveRoomResponse(leaveRoomResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onLeaveRoomNotice(PMDefs.LeaveRoomNotice leaveRoomNotice) {
        if (leaveRoomNotice != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onLeaveRoomNotice : getInstance().mListeners) {
                        onLeaveRoomNotice.onLeaveRoomNotice(leaveRoomNotice);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomMessage(PMDefs.RoomChatMessage roomChatMessage) {
        if (roomChatMessage != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomMessage : getInstance().mListeners) {
                        onRecvRoomMessage.onRecvRoomMessage(roomChatMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomBinaryMessage(PMDefs.RoomChatBinaryMessage roomChatBinaryMessage) {
        if (roomChatBinaryMessage != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomBinaryMessage : getInstance().mListeners) {
                        onRecvRoomBinaryMessage.onRecvRoomBinaryMessage(roomChatBinaryMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSendRoomMessageResponse(PMDefs.SendRoomMessageResp sendRoomMessageResp) {
        if (sendRoomMessageResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSendRoomMessageResp : getInstance().mListeners) {
                        onSendRoomMessageResp.onSendRoomMessageResp(sendRoomMessageResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSendRoomBinaryMessageResponse(PMDefs.SendRoomBinaryMessageResp sendRoomBinaryMessageResp) {
        if (sendRoomBinaryMessageResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSendRoomBinaryMessageResp : getInstance().mListeners) {
                        onSendRoomBinaryMessageResp.onSendRoomBinaryMessageResp(sendRoomBinaryMessageResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomHistoryMessagesResponse(PMDefs.RoomHistoryMessages roomHistoryMessages) {
        if (roomHistoryMessages != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomHistoryMessagesResponse : getInstance().mListeners) {
                        onGetRoomHistoryMessagesResponse.onGetRoomHistoryMessagesResponse(roomHistoryMessages);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomHistoryBinaryMessagesResponse(PMDefs.RoomHistoryBinaryMessages roomHistoryBinaryMessages) {
        if (roomHistoryBinaryMessages != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomHistoryBinaryMessagesResponse : getInstance().mListeners) {
                        onGetRoomHistoryBinaryMessagesResponse.onGetRoomHistoryBinaryMessagesResponse(roomHistoryBinaryMessages);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomBatchHistoryBinaryMessagesResponse(PMDefs.RoomBatchHistoryBinaryMessages roomBatchHistoryBinaryMessages) {
        if (roomBatchHistoryBinaryMessages != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomBatchHistoryBinaryMessagesResponse : getInstance().mListeners) {
                        onGetRoomBatchHistoryBinaryMessagesResponse.onGetRoomBatchHistoryBinaryMessagesResponse(roomBatchHistoryBinaryMessages);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onMuteRoomResponse(ArrayList<PMDefs.MuteRoomResp> arrayList) {
        if (arrayList != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onMuteRoomResponse : getInstance().mListeners) {
                        onMuteRoomResponse.onMuteRoomResponse(arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onMuteRoomNotice(PMDefs.MuteRoomNotice muteRoomNotice) {
        if (muteRoomNotice != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onMuteRoomNotice : getInstance().mListeners) {
                        onMuteRoomNotice.onMuteRoomNotice(muteRoomNotice);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomMuteStatusResp(ArrayList<PMDefs.GetRoomMuteStatusResp> arrayList) {
        if (arrayList != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomMuteStatusResponse : getInstance().mListeners) {
                        onGetRoomMuteStatusResponse.onGetRoomMuteStatusResponse(arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSetRoomDataResp(PMDefs.SetRoomDataResp setRoomDataResp) {
        if (setRoomDataResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSetRoomDataResponse : getInstance().mListeners) {
                        onSetRoomDataResponse.onSetRoomDataResponse(setRoomDataResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSetRoomsDataResp(PMDefs.SetRoomsDataResp setRoomsDataResp) {
        if (setRoomsDataResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSetRoomsDataResponse : getInstance().mListeners) {
                        onSetRoomsDataResponse.onSetRoomsDataResponse(setRoomsDataResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomDataResp(PMDefs.GetRoomDataResp getRoomDataResp) {
        if (getRoomDataResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomDataResponse : getInstance().mListeners) {
                        onGetRoomDataResponse.onGetRoomDataResponse(getRoomDataResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetLiveStatisticsResp(PMDefs.GetLiveStatisticsResp getLiveStatisticsResp) {
        if (getLiveStatisticsResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetLiveStatisticsResponse : getInstance().mListeners) {
                        onGetLiveStatisticsResponse.onGetLiveStatisticsResponse(getLiveStatisticsResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onGetRoomUserListResp(PMDefs.GetRoomUserListResp getRoomUserListResp) {
        if (getRoomUserListResp != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onGetRoomUserListResponse : getInstance().mListeners) {
                        onGetRoomUserListResponse.onGetRoomUserListResponse(getRoomUserListResp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onRecvRoomUserCountUpdateNotice(PMDefs.RoomUserCountUpdateNotice roomUserCountUpdateNotice) {
        if (roomUserCountUpdateNotice != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onRecvRoomUserCountUpdateNotice : getInstance().mListeners) {
                        onRecvRoomUserCountUpdateNotice.onRecvRoomUserCountUpdateNotice(roomUserCountUpdateNotice);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSetRoomSubOptionResponse(PMDefs.SetRoomSubscribeOptionResponse setRoomSubscribeOptionResponse) {
        if (setRoomSubscribeOptionResponse != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSetRoomSubscribeOptionResponse : getInstance().mListeners) {
                        onSetRoomSubscribeOptionResponse.onSetRoomSubscribeOptionResponse(setRoomSubscribeOptionResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void onSetRoomDataSubOptionResponse(PMDefs.SetRoomSubscribeOptionResponse setRoomSubscribeOptionResponse) {
        if (setRoomSubscribeOptionResponse != null) {
            synchronized (getInstance().mListeners) {
                try {
                    for (IRoomChatListener onSetRoomDataSubscribeOptionResponse : getInstance().mListeners) {
                        onSetRoomDataSubscribeOptionResponse.onSetRoomDataSubscribeOptionResponse(setRoomSubscribeOptionResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
