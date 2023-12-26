package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;
import java.util.List;

public abstract class IRoomChatListener {
    public void onGetLiveStatisticsResponse(PMDefs.GetLiveStatisticsResp getLiveStatisticsResp) {
    }

    public void onGetRoomBatchHistoryBinaryMessagesResponse(PMDefs.RoomBatchHistoryBinaryMessages roomBatchHistoryBinaryMessages) {
    }

    public void onGetRoomDataResponse(PMDefs.GetRoomDataResp getRoomDataResp) {
    }

    public void onGetRoomHistoryBinaryMessagesResponse(PMDefs.RoomHistoryBinaryMessages roomHistoryBinaryMessages) {
    }

    public void onGetRoomHistoryMessagesResponse(PMDefs.RoomHistoryMessages roomHistoryMessages) {
    }

    public void onGetRoomMuteStatusResponse(List<PMDefs.GetRoomMuteStatusResp> list) {
    }

    public void onGetRoomUserListResponse(PMDefs.GetRoomUserListResp getRoomUserListResp) {
    }

    public void onJoinRoomNotice(PMDefs.JoinRoomNotice joinRoomNotice) {
    }

    public void onJoinRoomResponse(PMDefs.JoinRoomResp joinRoomResp) {
    }

    public void onLeaveRoomNotice(PMDefs.LeaveRoomNotice leaveRoomNotice) {
    }

    public void onLeaveRoomResponse(PMDefs.LeaveRoomResp leaveRoomResp) {
    }

    public void onMuteRoomNotice(PMDefs.MuteRoomNotice muteRoomNotice) {
    }

    public void onMuteRoomResponse(List<PMDefs.MuteRoomResp> list) {
    }

    public void onRecvRoomBinaryMessage(PMDefs.RoomChatBinaryMessage roomChatBinaryMessage) {
    }

    public void onRecvRoomDataUpdateNotice(PMDefs.RoomData roomData) {
    }

    public void onRecvRoomMessage(PMDefs.RoomChatMessage roomChatMessage) {
    }

    public void onRecvRoomMetaData(PMDefs.RoomMetaData roomMetaData) {
    }

    public void onRecvRoomTopic(PMDefs.RoomTopic roomTopic) {
    }

    public void onRecvRoomUserCountUpdateNotice(PMDefs.RoomUserCountUpdateNotice roomUserCountUpdateNotice) {
    }

    public void onRecvRoomUserList(PMDefs.RoomUserList roomUserList) {
    }

    public void onSendRoomBinaryMessageResp(PMDefs.SendRoomBinaryMessageResp sendRoomBinaryMessageResp) {
    }

    public void onSendRoomMessageResp(PMDefs.SendRoomMessageResp sendRoomMessageResp) {
    }

    public void onSetRoomDataResponse(PMDefs.SetRoomDataResp setRoomDataResp) {
    }

    public void onSetRoomDataSubscribeOptionResponse(PMDefs.SetRoomSubscribeOptionResponse setRoomSubscribeOptionResponse) {
    }

    public void onSetRoomSubscribeOptionResponse(PMDefs.SetRoomSubscribeOptionResponse setRoomSubscribeOptionResponse) {
    }

    public void onSetRoomsDataResponse(PMDefs.SetRoomsDataResp setRoomsDataResp) {
    }
}
