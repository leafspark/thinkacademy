package com.tal100.chatsdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PMDefs {

    public static class ChatSdkProperty {
        public SdkPropertyEntity confService;
        public SdkPropertyEntity logService;
    }

    public static class HistoryBinMsgReqParam {
        public int count;
        public String key;
        public long msgId;
        public HistoryMsgOption option;
        public boolean order;
    }

    public static class LiveInfo {
        public String businessId;
        public String classId;
        public String liveId;
        public String nickname;
        public List<String> roomIds;
    }

    public interface MessageType {
        public static final int MSG_TYPE_BIN = 110;
        public static final int MSG_TYPE_COMMAND = 3;
        public static final int MSG_TYPE_INFO = 2;
        public static final int MSG_TYPE_INTERACT = 98;
        public static final int MSG_TYPE_NOTICE = 1;
        public static final int MSG_TYPE_PRI = 99;
        public static final int MSG_TYPE_ROOMDATA = 111;
        public static final int MSG_TYPE_TOPIC = 0;
    }

    public interface NetStatus {
        public static final int PMNetStatus_Connected = 4;
        public static final int PMNetStatus_Connecting = 3;
        public static final int PMNetStatus_DisConnected = 5;
        public static final int PMNetStatus_ServerFailed = 2;
        public static final int PMNetStatus_Unavailable = 1;
        public static final int PMNetStatus_Unkown = 0;
    }

    public interface PMChatRole {
        public static final int PMChatRole_Student = 2;
        public static final int PMChatRole_Teacher = 1;
    }

    public interface PMRoomUserMode {
        public static final int PMRoomUserMode_All = 1;
        public static final int PMRoomUserMode_None = 0;
        public static final int PMRoomUserMode_Teacher = 2;
    }

    public static class PeerChatBinaryMessage {
        public long binMsgId;
        public byte[] content;
        public PsIdEntity fromUserInfo;
        public long msgId;
        public long timestamp;
        public PsIdEntity toUserInfo;
    }

    public static class PeerChatMessage {
        public String content;
        public PsIdEntity fromUserId;
        public long msgId;
        public int msgPriority;
        public long timestamp;
        public PsIdEntity toUserId;
    }

    public interface ResultCode {
        public static final int Result_AlreadyInit = 19;
        public static final int Result_AlreadyLogined = 17;
        public static final int Result_EmptyContent = 503;
        public static final int Result_EmptyNickname = 202;
        public static final int Result_EmptyRecv = 500;
        public static final int Result_ErrorUnknown = 100;
        public static final int Result_ExistNickname = 204;
        public static final int Result_InvalidDeviceType = 206;
        public static final int Result_InvalidNickname = 203;
        public static final int Result_InvalidParam = 106;
        public static final int Result_InvalidPassword = 201;
        public static final int Result_InvalidPriority = 508;
        public static final int Result_KickoutException = 399;
        public static final int Result_KickoutRepeat = 301;
        public static final int Result_KickoutRequest = 302;
        public static final int Result_NotInRoom = 505;
        public static final int Result_ParaError = 1;
        public static final int Result_PathNotExist = 13;
        public static final int Result_PsIdNotExsit = 200;
        public static final int Result_RecvNicknameNotExist = 502;
        public static final int Result_RecvNotInRoom = 506;
        public static final int Result_RoomAreadyJoin = 405;
        public static final int Result_RoomData = 51;
        public static final int Result_RoomInvalidRoomId = 404;
        public static final int Result_RoomNoPermission = 402;
        public static final int Result_RoomNotExsit = 400;
        public static final int Result_RoomSendNoPermission = 504;
        public static final int Result_RoomTooMany = 401;
        public static final int Result_RoomTopic = 50;
        public static final int Result_RoomUpperLimit = 403;
        public static final int Result_RoomUserList = 52;
        public static final int Result_RoomUserListEnd = 53;
        public static final int Result_SendTooFast = 14;
        public static final int Result_SendUpLimit = 509;
        public static final int Result_SensitiveWord = 507;
        public static final int Result_Success = 0;
        public static final int Result_TimeOut = 2;
        public static final int Result_UnInit = 11;
        public static final int Result_UnLogined = 12;
        public static final int Result_logging = 18;
        public static final int SResult_RecvPsIdNotExist = 501;
    }

    public static class RoomChatBinaryMessage {
        public byte[] content;
        public PsIdEntity from;
        public String key;
        public long keyMsgId;
        public long msgId;
        public String roomId;
        public long timestamp;
    }

    public static class RoomChatMessage {
        public String content;
        public long curMsgSeq;
        public PsIdEntity fromUserId;
        public long msgId;
        public int msgPriority;
        public long preMsgSeq;
        public long timestamp;
        public String toRoomId;
    }

    public interface SdkPrivisonStatus {
        public static final int PMSdkProvisionStatus_ConfigError = 2;
        public static final int PMSdkProvisionStatus_DispatchError = 1;
        public static final int PMSdkProvisionStatus_Success = 0;
        public static final int PMSdkProvisionStatus_UnknownError = 100;
    }

    public static class SdkPropertyEntity {
        public String backupIp;
        public String hostname;
        public int port;
        public String protocol;
        public String url;
    }

    public interface TMClientResultCode {
        public static final int TMClientResultErrAuthFail = 20;
        public static final int TMClientResultErrCreateSessionFail = 30;
        public static final int TMClientResultErrInvalidParam = 11;
        public static final int TMClientResultErrSessionIvalid = 40;
        public static final int TMClientResultErrTokenInvalid = 21;
        public static final int TMClientResultErrUnknown = 10;
        public static final int TMClientResultFail = 2;
        public static final int TMClientResultParaError = 1;
        public static final int TMClientResultSuccess = 0;
        public static final int TMClientResultTimeout = 3;
    }

    public static class TMPushRawMessage {
        public String msgContent;
        public String msgId;
    }

    public static class TMRecvChannelBinaryDataNotice {
        public byte[] content;
        public String from;
        public String msgId;
        public int size;
        public long timestamp;
    }

    public static class TMRecvChannelDataNotice {
        public String content;
        public String from;
        public String msgId;
        public long timestamp;
    }

    public static class SdkPrivisionStatusNotice {
        public String info;
        public int privisonStatus;

        public SdkPrivisionStatusNotice(int i, String str) {
            this.privisonStatus = i;
            this.info = str;
        }
    }

    public static class ChannelResult {
        public int code;
        public ITMChannel tmChannel;

        public ChannelResult(int i, TMChannel tMChannel) {
            this.code = i;
            this.tmChannel = tMChannel;
        }
    }

    public static class TMChannelStatusNotice {
        public int status;

        public TMChannelStatusNotice(int i) {
            this.status = i;
        }
    }

    public static class TMSendChannelDataResponse {
        public int code;
        public String info;
        public String msgId;
        public long preMsgId;
        public long timestamp;

        public TMSendChannelDataResponse(String str, long j, long j2, int i, String str2) {
            this.msgId = str;
            this.preMsgId = j;
            this.timestamp = j2;
            this.code = i;
            this.info = str2;
        }
    }

    public static class TMSendChannelBinaryDataResponse {
        public int code;
        public String info;
        public String msgId;
        public long preMsgId;
        public long timestamp;

        public TMSendChannelBinaryDataResponse(String str, long j, long j2, int i, String str2) {
            this.msgId = str;
            this.preMsgId = j;
            this.timestamp = j2;
            this.code = i;
            this.info = str2;
        }
    }

    public static class TMChannelKickoutNotice {
        public String reason;

        public TMChannelKickoutNotice(String str) {
            this.reason = str;
        }
    }

    public static class TMChannelKickoutResponse {
        public int code;
        public String info;

        public TMChannelKickoutResponse(int i, String str) {
            this.code = i;
            this.info = str;
        }
    }

    public static class TMPushMsgEntity {
        public static final int MSG_TYPE_NOTIFICATION = 0;
        public static final int MSG_TYPE_TRANSMISSION = 1;
        private String channelId;
        private String description;
        private String extra;
        private String msgId;
        private int msgType;
        private String payload;
        private String title;

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public String getPayload() {
            return this.payload;
        }

        public void setPayload(String str) {
            this.payload = str;
        }

        public String getMsgId() {
            return this.msgId;
        }

        public void setMsgId(String str) {
            this.msgId = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getExtra() {
            return this.extra;
        }

        public void setExtra(String str) {
            this.extra = str;
        }

        public int getMsgType() {
            return this.msgType;
        }

        public void setMsgType(int i) {
            this.msgType = i;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public void setChannelId(String str) {
            this.channelId = str;
        }

        public String toString() {
            return "TMPushMsgEntity{msgType=" + this.msgType + ", msgId='" + this.msgId + '\'' + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", payload='" + this.payload + '\'' + ", extra='" + this.extra + '\'' + ", channelId='" + this.channelId + '\'' + '}';
        }
    }

    public static class NetStatusResp {
        public int netStatus;

        public NetStatusResp(int i) {
            this.netStatus = i;
        }
    }

    public static class PsIdEntity {
        public String nickname;
        public String psid;

        public PsIdEntity(String str, String str2) {
            this.nickname = str;
            this.psid = str2;
        }
    }

    public static class LoginResp {
        public int code;
        public String info;
        public PsIdEntity userInfo;

        public LoginResp(int i, String str, PsIdEntity psIdEntity) {
            this.code = i;
            this.info = str;
            this.userInfo = psIdEntity;
        }
    }

    public static class LogoutNotice {
        public int code;
        public String info;
        public ArrayList<String> roomIds;
        public PsIdEntity userInfo;

        public LogoutNotice(int i, String str, PsIdEntity psIdEntity, ArrayList<String> arrayList) {
            this.code = i;
            this.info = str;
            this.userInfo = psIdEntity;
            this.roomIds = arrayList;
        }
    }

    public static class KickoutNotice {
        public int code;
        public String info;

        public KickoutNotice(int i, String str) {
            this.code = i;
            this.info = str;
        }
    }

    public static class JoinRoomResp {
        public int code;
        public String info;
        public String roomId;
        public PsIdEntity userInfo;

        public JoinRoomResp(int i, String str, String str2, PsIdEntity psIdEntity) {
            this.code = i;
            this.info = str;
            this.roomId = str2;
            this.userInfo = psIdEntity;
        }
    }

    public static class JoinRoomNotice {
        public String info;
        public String roomId;
        public PsIdEntity userInfo;

        public JoinRoomNotice(String str, String str2, PsIdEntity psIdEntity) {
            this.info = str;
            this.roomId = str2;
            this.userInfo = psIdEntity;
        }
    }

    public static class SubOptionRespEntity {
        public int code;
        public String info;
        public String roomId;

        public SubOptionRespEntity(int i, String str, String str2) {
            this.code = i;
            this.info = str;
            this.roomId = str2;
        }
    }

    public static class SetRoomSubscribeOptionResponse {
        public List<SubOptionRespEntity> roomSubOptionResps;

        public SetRoomSubscribeOptionResponse(ArrayList<SubOptionRespEntity> arrayList) {
            this.roomSubOptionResps = arrayList;
        }
    }

    public static class RoomMetaData {
        public int code;
        public Map<String, String> content;
        public String roomId;

        public RoomMetaData(int i, String str, HashMap<String, String> hashMap) {
            this.code = i;
            this.roomId = str;
            this.content = hashMap;
        }
    }

    public static class RoomUserList {
        public int code;
        public String roomId;
        public List<PsIdEntity> userList;

        public RoomUserList(int i, String str, ArrayList<PsIdEntity> arrayList) {
            this.code = i;
            this.roomId = str;
            this.userList = arrayList;
        }
    }

    public static class RoomTopic {
        public int code;
        public String roomId;
        public String topic;

        public RoomTopic(int i, String str, String str2) {
            this.code = i;
            this.topic = str2;
            this.roomId = str;
        }
    }

    public static class LeaveRoomResp {
        public int code;
        public String info;
        public String roomId;
        public PsIdEntity userInfo;

        public LeaveRoomResp(int i, String str, String str2, PsIdEntity psIdEntity) {
            this.code = i;
            this.info = str;
            this.roomId = str2;
            this.userInfo = psIdEntity;
        }
    }

    public static class LeaveRoomNotice {
        public String info;
        public String roomId;
        public PsIdEntity userInfo;

        public LeaveRoomNotice(String str, String str2, PsIdEntity psIdEntity) {
            this.info = str;
            this.roomId = str2;
            this.userInfo = psIdEntity;
        }
    }

    public static class SendRoomMessageResp {
        public int code;
        public long curMsgSeq;
        public PsIdEntity fromUserInfo;
        public String info;
        public long msgId;
        public long preMsgId;
        public long preMsgSeq;
        public long timestamp;
        public String toRoomId;

        public SendRoomMessageResp(int i, String str, String str2, PsIdEntity psIdEntity) {
            this.code = i;
            this.info = str;
            this.toRoomId = str2;
            this.fromUserInfo = psIdEntity;
        }

        public SendRoomMessageResp(int i, String str, String str2, PsIdEntity psIdEntity, long j, long j2, long j3, long j4, long j5) {
            this.code = i;
            this.info = str;
            this.toRoomId = str2;
            this.fromUserInfo = psIdEntity;
            this.msgId = j;
            this.preMsgSeq = j2;
            this.curMsgSeq = j3;
            this.preMsgId = j5;
            this.timestamp = j4;
        }
    }

    public static class SendFailInfo {
        public int code;
        public String info;
        public String roomId;

        public SendFailInfo(int i, String str, String str2) {
            this.code = i;
            this.info = str;
            this.roomId = str2;
        }
    }

    public static class SendRoomBinaryMessageResp {
        public int code;
        public ArrayList<SendFailInfo> fails;
        public String info;
        public long msgId;
        public long preMsgId;
        public ArrayList<String> success;
        public long timestamp;

        public SendRoomBinaryMessageResp(int i, String str, long j, long j2, long j3, ArrayList<SendFailInfo> arrayList, ArrayList<String> arrayList2) {
            this.code = i;
            this.info = str;
            this.msgId = j;
            this.preMsgId = j2;
            this.timestamp = j3;
            this.fails = arrayList;
            this.success = arrayList2;
        }
    }

    public static class MuteRoomResp {
        public int code;
        public String info;
        public String roomId;

        public MuteRoomResp(int i, String str, String str2) {
            this.code = i;
            this.info = str;
            this.roomId = str2;
        }
    }

    public static class MuteRoomNotice {
        public int flag;
        public PsIdEntity handler;
        public String roomId;

        public MuteRoomNotice(int i, String str, PsIdEntity psIdEntity) {
            this.flag = i;
            this.roomId = str;
            this.handler = psIdEntity;
        }
    }

    public static class GetRoomMuteStatusResp {
        public int code;
        public int flag;
        public String info;
        public String roomId;

        public GetRoomMuteStatusResp(int i, String str, int i2, String str2) {
            this.flag = i2;
            this.roomId = str2;
            this.code = i;
            this.info = str;
        }
    }

    public static class RoomDataElement {
        public boolean persistent;
        public boolean save;
        public String value;

        public RoomDataElement(String str, boolean z) {
            this.value = str;
            this.save = z;
            this.persistent = false;
        }

        public RoomDataElement(String str, boolean z, boolean z2) {
            this.value = str;
            this.save = z;
            this.persistent = z2;
        }
    }

    public static class RoomData {
        public HashMap<String, RoomDataElement> data;
        public PsIdEntity handler;
        public long msgId;
        public String roomId;

        public RoomData(long j, String str, PsIdEntity psIdEntity, HashMap<String, RoomDataElement> hashMap) {
            this.data = hashMap;
            this.roomId = str;
            this.msgId = j;
            this.handler = psIdEntity;
        }
    }

    public static class SetRoomDataResp {
        public int code;
        public ArrayList<String> failKeys;
        public String info;
        public long msgId;
        public long requestId;
        public String roomId;

        public SetRoomDataResp(int i, String str, long j, long j2, String str2, ArrayList<String> arrayList) {
            this.code = i;
            this.info = str;
            this.requestId = j;
            this.msgId = j2;
            this.roomId = str2;
            this.failKeys = arrayList;
        }
    }

    public static class SetRoomsDataResp {
        public long msgId;
        public long requestId;
        public ArrayList<SetRoomDataResp> setRoomDataResps;

        public SetRoomsDataResp(long j, long j2, ArrayList<SetRoomDataResp> arrayList) {
            this.requestId = j;
            this.msgId = j2;
            this.setRoomDataResps = arrayList;
        }
    }

    public static class GetRoomDataResp {
        public int code;
        public HashMap<String, RoomDataElement> datas;
        public String info;
        public long requestId;
        public String roomId;

        public GetRoomDataResp(int i, String str, long j, String str2, HashMap<String, RoomDataElement> hashMap) {
            this.code = i;
            this.info = str;
            this.requestId = j;
            this.roomId = str2;
            this.datas = hashMap;
        }
    }

    public static class GetLiveStatisticsResp {
        public int code;
        public HashMap<String, String> datas;
        public String info;
        public String key;
        public long msgId;
        public HashMap<String, String> params;
        public long requestId;

        public GetLiveStatisticsResp(int i, String str, long j, long j2, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
            this.code = i;
            this.info = str;
            this.requestId = j;
            this.msgId = j2;
            this.key = str2;
            this.params = hashMap;
            this.datas = hashMap2;
        }
    }

    public static class GetRoomUserListResp {
        public int code;
        public String info;
        public long msgId;
        public long requestId;
        public HashMap<String, Integer> userCount;

        public GetRoomUserListResp(int i, String str, long j, long j2, HashMap<String, Integer> hashMap) {
            this.code = i;
            this.info = str;
            this.requestId = j;
            this.msgId = j2;
            this.userCount = hashMap;
        }
    }

    public static class RoomUserCountUpdateNotice {
        public HashMap<String, Integer> studentCount;
        public HashMap<String, Integer> teacherCount;
        public HashMap<String, Integer> userCount;

        public RoomUserCountUpdateNotice(HashMap<String, Integer> hashMap, HashMap<String, Integer> hashMap2, HashMap<String, Integer> hashMap3) {
            this.userCount = hashMap;
            this.studentCount = hashMap2;
            this.teacherCount = hashMap3;
        }
    }

    public static class SendPeerMessageResp {
        public int code;
        public PsIdEntity fromUserInfo;
        public String info;
        public long msgId;
        public long preMsgId;
        public long timestamp;
        public PsIdEntity toUserInfo;

        public SendPeerMessageResp(int i, String str, PsIdEntity psIdEntity, PsIdEntity psIdEntity2) {
            this.code = i;
            this.info = str;
            this.fromUserInfo = psIdEntity;
            this.toUserInfo = psIdEntity2;
        }

        public SendPeerMessageResp(int i, String str, PsIdEntity psIdEntity, PsIdEntity psIdEntity2, long j, long j2, long j3) {
            this.code = i;
            this.info = str;
            this.fromUserInfo = psIdEntity;
            this.toUserInfo = psIdEntity2;
            this.msgId = j;
            this.preMsgId = j3;
            this.timestamp = j2;
        }
    }

    public static class SendPeerBinaryMessageFailInfo {
        public int code;
        public String info;
        public PsIdEntity to;

        public SendPeerBinaryMessageFailInfo(int i, String str, PsIdEntity psIdEntity) {
            this.code = i;
            this.info = str;
            this.to = psIdEntity;
        }
    }

    public static class SendPeerBinaryMessageResp {
        public long binMsgId;
        public int code;
        public ArrayList<SendPeerBinaryMessageFailInfo> fails;
        public String info;
        public long msgId;
        public long preMsgId;
        public ArrayList<PsIdEntity> success;
        public long timestamp;

        public SendPeerBinaryMessageResp(int i, String str, long j, long j2, long j3, long j4, ArrayList<SendPeerBinaryMessageFailInfo> arrayList, ArrayList<PsIdEntity> arrayList2) {
            this.code = i;
            this.info = str;
            this.msgId = j;
            this.preMsgId = j2;
            this.binMsgId = j3;
            this.timestamp = j4;
            this.fails = arrayList;
            this.success = arrayList2;
        }
    }

    public static class RoomHistoryMessages {
        public int code;
        public ArrayList<RoomChatMessage> content;
        public String info;

        public RoomHistoryMessages(int i, String str, ArrayList<RoomChatMessage> arrayList) {
            this.code = i;
            this.info = str;
            this.content = arrayList;
        }
    }

    public static class RoomHistoryBinaryMessages {
        public int code;
        public ArrayList<RoomChatBinaryMessage> content;
        public String info;
        public String key;
        public boolean order;
        public long traceId;

        public RoomHistoryBinaryMessages(int i, String str, String str2, long j, boolean z, ArrayList<RoomChatBinaryMessage> arrayList) {
            this.code = i;
            this.info = str;
            this.key = str2;
            this.traceId = j;
            this.order = z;
            this.content = arrayList;
        }
    }

    public static class RoomBatchHistoryBinaryMessages {
        public int code;
        public String info;
        public ArrayList<RoomHistoryBinaryMessages> keyMsgs;
        public long traceId;

        public RoomBatchHistoryBinaryMessages(int i, String str, long j, ArrayList<RoomHistoryBinaryMessages> arrayList) {
            this.code = i;
            this.info = str;
            this.traceId = j;
            this.keyMsgs = arrayList;
        }
    }

    public static class HistoryMsgOption {
        public int historyLevel;

        public HistoryMsgOption(int i) {
            this.historyLevel = i;
        }

        public HistoryMsgOption() {
            this.historyLevel = 0;
        }
    }

    public static class ChatResp {
        public int code;
        public String info;
        public long msgId;

        public ChatResp(int i, String str, long j) {
            this.code = i;
            this.info = str;
            this.msgId = j;
        }

        public ChatResp(int i, String str) {
            this.code = i;
            this.info = str;
            this.msgId = 0;
        }
    }

    public static class MsgSubOption {
        public boolean isSub;
        public int msgType;

        public MsgSubOption(int i, boolean z) {
            this.msgType = i;
            this.isSub = z;
        }
    }

    public static class RoomDataSubOption {
        public boolean isSub;
        public String key;

        public RoomDataSubOption(String str, boolean z) {
            this.key = str;
            this.isSub = z;
        }
    }

    public static class MsgOption {
        public int historyLevel;
        public boolean isSaveHistory;

        public MsgOption(boolean z) {
            this.isSaveHistory = z;
            this.historyLevel = 0;
        }

        public MsgOption(boolean z, int i) {
            this.isSaveHistory = z;
            this.historyLevel = i;
        }

        public MsgOption() {
            this.isSaveHistory = true;
            this.historyLevel = 0;
        }
    }
}
