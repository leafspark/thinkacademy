package com.tal.app.thinkacademy.live.core.irc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.Constants;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.Tag;
import com.tal.app.thinkacademy.live.core.callback.BinaryMessageCallback;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import com.tal.app.thinkacademy.live.core.irc.entity.HistoryBinMsgReqParam;
import com.tal.app.thinkacademy.live.core.irc.entity.IrcInitEntity;
import com.tal.app.thinkacademy.live.core.irc.entity.MessageInfo;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.irc.listener.IIrcListener;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal100.chatsdk.ChatClient;
import com.tal100.chatsdk.IChatClientListener;
import com.tal100.chatsdk.IPeerChatListener;
import com.tal100.chatsdk.IRoomChatListener;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.TMSdkManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class IrcController implements IircControllerProvider {
    private static final String IRC_DATA_PATH = Constants.getIRC_PATH();
    private static final String TAG = "IRC_LOG";
    /* access modifiers changed from: private */
    public boolean mAlluser;
    /* access modifiers changed from: private */
    public ChatClient mChatClient;
    private Context mContext;
    private IrcChatClientListener mIrcChatClientListener;
    /* access modifiers changed from: private */
    public List<IrcChatListener> mIrcChatListeners = new ArrayList();
    private List<IIrcListener> mIrcListeners = Collections.synchronizedList(new ArrayList());
    private IrcPeerChatListener mIrcPeerChatListener;
    private IrcRoomChatListener mIrcRoomChatListener;
    /* access modifiers changed from: private */
    public boolean mIsFirstConnect = true;
    /* access modifiers changed from: private */
    public boolean mIsFirstLogin = true;
    /* access modifiers changed from: private */
    public ILiveControllerProvider mLiveControllerProvider;
    private PMDefs.LiveInfo mLiveInfo;
    /* access modifiers changed from: private */
    public int mNetStatusResp;
    /* access modifiers changed from: private */
    public List<String> mRoomids;

    public static class SimpleIrcChatListener implements IrcChatListener {
        public void onNetStatusChanged(int i) {
        }
    }

    public IrcController(ILiveControllerProvider iLiveControllerProvider, IrcInitEntity ircInitEntity) {
        this.mRoomids = ircInitEntity.getRoomIds();
        this.mAlluser = ircInitEntity.isAlluser();
        this.mContext = (Context) iLiveControllerProvider.getWeakRefContext().get();
        this.mLiveControllerProvider = iLiveControllerProvider;
        initLiveInfo(ircInitEntity);
    }

    private void initLiveInfo(IrcInitEntity ircInitEntity) {
        PMDefs.LiveInfo liveInfo = new PMDefs.LiveInfo();
        this.mLiveInfo = liveInfo;
        liveInfo.nickname = ircInitEntity.getNickname();
        this.mLiveInfo.liveId = ircInitEntity.getLiveId();
        this.mLiveInfo.classId = ircInitEntity.getClassId();
        this.mLiveInfo.roomIds = ircInitEntity.getRoomIds();
        this.mLiveInfo.businessId = ircInitEntity.getBusinessId();
    }

    public void initController() {
        this.mChatClient = ChatClient.getInstance();
        this.mIrcChatClientListener = new IrcChatClientListener();
        this.mIrcRoomChatListener = new IrcRoomChatListener();
        this.mIrcPeerChatListener = new IrcPeerChatListener();
        this.mChatClient.addListener(this.mIrcChatClientListener);
        this.mChatClient.getRoomManager().addListener(this.mIrcRoomChatListener);
        this.mChatClient.getPeerManager().addListener(this.mIrcPeerChatListener);
        if (initSdkV3() == 0) {
            login();
        }
    }

    private int initSdkV3() {
        String locationV3 = ImConfig.INSTANCE.getIrcServer() == null ? null : ImConfig.INSTANCE.getIrcServer().getLocationV3();
        IrcTrackUtil.INSTANCE.trackStartEvent(this.mLiveInfo, this.mRoomids, locationV3);
        try {
            File file = new File(PathUtils.getInternalAppFilesPath(), IRC_DATA_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            ILiveControllerProvider iLiveControllerProvider = this.mLiveControllerProvider;
            if (iLiveControllerProvider == null || iLiveControllerProvider.getDataStorage() == null) {
                XesLog.e(Tag.IRC_MONITOR, new Object[]{"IRC初始化失败，数据仓库为空"});
                IrcTrackUtil.INSTANCE.trackFailEvent(IrcFailEventType.INIT_FAIL, "IRC初始化失败，数据仓库为空");
                return -1002;
            }
            EnterConfigProxy enterConfig = this.mLiveControllerProvider.getDataStorage().getEnterConfig();
            if (enterConfig != null) {
                String appId = enterConfig.getAppId();
                String appKey = enterConfig.getAppKey();
                PMDefs.SdkPropertyEntity sdkPropertyEntity = new PMDefs.SdkPropertyEntity();
                PMDefs.SdkPropertyEntity sdkPropertyEntity2 = new PMDefs.SdkPropertyEntity();
                if (!(ImConfig.INSTANCE.getIrcServer() == null || ImConfig.INSTANCE.getIrcServer().getConfService() == null)) {
                    sdkPropertyEntity.protocol = ImConfig.INSTANCE.getIrcServer().getConfServiceV3().getProtocol();
                    sdkPropertyEntity.hostname = ImConfig.INSTANCE.getIrcServer().getConfServiceV3().getHostname();
                    sdkPropertyEntity.backupIp = ImConfig.INSTANCE.getIrcServer().getConfServiceV3().getBackupIp();
                    sdkPropertyEntity.url = ImConfig.INSTANCE.getIrcServer().getConfServiceV3().getUrl();
                    sdkPropertyEntity.port = ImConfig.INSTANCE.getIrcServer().getConfServiceV3().getPort();
                }
                if (!(ImConfig.INSTANCE.getIrcServer() == null || ImConfig.INSTANCE.getIrcServer().getLogService() == null)) {
                    sdkPropertyEntity2.protocol = ImConfig.INSTANCE.getIrcServer().getLogService().getProtocol();
                    sdkPropertyEntity2.hostname = ImConfig.INSTANCE.getIrcServer().getLogService().getHostname();
                    sdkPropertyEntity2.backupIp = ImConfig.INSTANCE.getIrcServer().getLogService().getBackupIp();
                    sdkPropertyEntity2.url = ImConfig.INSTANCE.getIrcServer().getLogService().getUrl();
                    sdkPropertyEntity2.port = ImConfig.INSTANCE.getIrcServer().getLogService().getPort();
                }
                int init = TMSdkManager.getInstance().init(this.mContext.getApplicationContext(), appId, appKey, file.getAbsolutePath(), locationV3, sdkPropertyEntity2, sdkPropertyEntity);
                if (init == 0) {
                    XesLog.s(Tag.IRC_MONITOR, new Object[]{"IRC初始化成功"});
                    return initChat();
                }
                Tag tag = Tag.IRC_MONITOR;
                XesLog.e(tag, new Object[]{"IRC初始化失败，错误码=" + init});
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcFailEventType ircFailEventType = IrcFailEventType.INIT_FAIL;
                ircTrackUtil.trackFailEvent(ircFailEventType, "IRC初始化失败，错误码=" + init);
                return init;
            }
            XesLog.e(Tag.IRC_MONITOR, new Object[]{"IRC初始化失败,enter接口configs为空"});
            IrcTrackUtil.INSTANCE.trackFailEvent(IrcFailEventType.INIT_FAIL, "IRC初始化失败,enter接口configs为空");
            return -1003;
        } catch (Exception e) {
            Tag tag2 = Tag.IRC_MONITOR;
            XesLog.e(tag2, new Object[]{"IRC初始化异常=" + Log.getStackTraceString(e)});
            IrcTrackUtil ircTrackUtil2 = IrcTrackUtil.INSTANCE;
            IrcFailEventType ircFailEventType2 = IrcFailEventType.INIT_FAIL;
            ircTrackUtil2.trackFailEvent(ircFailEventType2, "IRC初始化异常=" + Log.getStackTraceString(e));
            return -1001;
        }
    }

    private int initChat() {
        XesLog.s(Tag.IRC_MONITOR, new Object[]{"IRC聊天模块初始化"});
        int init = this.mChatClient.init(this.mContext.getApplicationContext(), 2);
        if (init == 0) {
            XesLog.s(Tag.IRC_MONITOR, new Object[]{"IRC聊天模块初始化成功"});
        } else {
            Tag tag = Tag.IRC_MONITOR;
            XesLog.e(tag, new Object[]{"IRC聊天模块初始化失败，错误码=" + init});
            IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
            IrcFailEventType ircFailEventType = IrcFailEventType.INIT_FAIL;
            ircTrackUtil.trackFailEvent(ircFailEventType, "IRC初始化失败，错误码=" + init);
        }
        return init;
    }

    private void login() {
        String str;
        String str2;
        int i;
        int liveInfo = this.mChatClient.setLiveInfo(this.mLiveInfo);
        if (liveInfo == 0) {
            Tag tag = Tag.IRC_MONITOR;
            XesLog.s(tag, new Object[]{"IRC设置直播间信息成功=" + GsonUtil.getInstance().objToJson(this.mLiveInfo)});
            ILiveControllerProvider iLiveControllerProvider = this.mLiveControllerProvider;
            if (iLiveControllerProvider == null || iLiveControllerProvider.getDataStorage() == null || this.mLiveControllerProvider.getDataStorage().getUserInfo() == null) {
                str2 = "avisitor";
                str = "123456";
            } else {
                str2 = this.mLiveControllerProvider.getDataStorage().getUserInfo().getId();
                str = this.mLiveControllerProvider.getDataStorage().getUserInfo().getId();
            }
            Tag tag2 = Tag.IRC_MONITOR;
            XesLog.i(tag2, new Object[]{"IRC开始登录，用户id=" + str2});
            if (this.mAlluser) {
                i = this.mChatClient.login(str2, str);
            } else {
                i = this.mChatClient.login(str2, str, true, 1);
            }
            if (i != 0) {
                Tag tag3 = Tag.IRC_MONITOR;
                XesLog.e(tag3, new Object[]{"IRC调用登录接口失败，用户id=" + str2 + "，错误码=" + i});
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcFailEventType ircFailEventType = IrcFailEventType.CALL_LOGIN_METHOD_FAIL;
                ircTrackUtil.trackFailEvent(ircFailEventType, "IRC调用登录接口失败，用户id=" + str2 + "，错误码=" + i);
                return;
            }
            return;
        }
        Tag tag4 = Tag.IRC_MONITOR;
        XesLog.e(tag4, new Object[]{"IRC设置直播间信息失败=" + GsonUtil.getInstance().objToJson(this.mLiveInfo) + "，错误码=" + liveInfo});
        IrcTrackUtil ircTrackUtil2 = IrcTrackUtil.INSTANCE;
        IrcFailEventType ircFailEventType2 = IrcFailEventType.SET_LIVE_INFO_FAIL;
        ircTrackUtil2.trackFailEvent(ircFailEventType2, "IRC设置直播间信息失败=" + GsonUtil.getInstance().objToJson(this.mLiveInfo) + "，错误码=" + liveInfo);
    }

    public void requestAllRoomData(String str) {
        long[] jArr = new long[0];
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.getRoomManager().getAllRoomData(str, jArr);
        }
    }

    public void requestHistoryBinaryMessage(String str, long j, boolean z, int i) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.getRoomManager().getRoomHistoryBinaryMessages(str, j, z, i);
        }
    }

    public void requestHistoryBinaryMessage(String str, long j, boolean z) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.getRoomManager().getRoomHistoryBinaryMessages(str, j, z);
        }
    }

    public void requestBatchHistoryBinaryMessage(List<HistoryBinMsgReqParam> list) {
        if (this.mChatClient != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (HistoryBinMsgReqParam next : list) {
                if (!TextUtils.isEmpty(next.key)) {
                    PMDefs.HistoryBinMsgReqParam historyBinMsgReqParam = new PMDefs.HistoryBinMsgReqParam();
                    historyBinMsgReqParam.key = next.key;
                    historyBinMsgReqParam.msgId = next.msgId;
                    historyBinMsgReqParam.count = next.count;
                    historyBinMsgReqParam.order = next.order;
                    arrayList.add(historyBinMsgReqParam);
                }
            }
            this.mChatClient.getRoomManager().getRoomBatchHistoryBinaryMessages(arrayList);
        }
    }

    public void addBinaryMessageCallback(BinaryMessageCallback binaryMessageCallback) {
        this.mLiveControllerProvider.getBinaryCallbackList().add(binaryMessageCallback);
    }

    public void removeBinaryMessageCallback(BinaryMessageCallback binaryMessageCallback) {
        this.mLiveControllerProvider.getBinaryCallbackList().remove(binaryMessageCallback);
    }

    public void requestRoomHistoryMessages(String str, long j) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.getRoomManager().getRoomHistoryMessages(str, j);
        }
    }

    public boolean sendPeerMessage(String str, String str2, int i) {
        return sendPeerMessage(new String[]{str}, str2, i, new long[0]);
    }

    public boolean sendPeerMessage(String str, String str2, int i, long[] jArr) {
        return sendPeerMessage(new String[]{str}, str2, i, jArr);
    }

    public boolean sendPeerNormalMessage(String str, MsgBean msgBean) {
        String objToJson = GsonUtil.getInstance().objToJson(msgBean);
        if (TextUtils.isEmpty(objToJson)) {
            return false;
        }
        return sendPeerMessage(new String[]{str}, objToJson, 99, new long[0]);
    }

    public boolean sendPeerNoticeMessage(String str, String str2) {
        return sendPeerMessage(new String[]{str}, str2, 1, new long[0]);
    }

    public boolean sendPeerNoticeMessage(String str, MsgBean msgBean) {
        String objToJson = GsonUtil.getInstance().objToJson(msgBean);
        if (TextUtils.isEmpty(objToJson)) {
            return false;
        }
        return sendPeerMessage(new String[]{str}, objToJson, 1, new long[0]);
    }

    private boolean sendPeerMessage(String[] strArr, String str, int i, long[] jArr) {
        XesLog.i(Tag.IRC, new Object[]{"发送私聊消息，用户昵称=" + GsonUtil.getInstance().objToJson(strArr) + "，消息内容=" + str + "，消息优先级=" + i});
        ArrayList arrayList = new ArrayList();
        if (jArr == null) {
            jArr = new long[0];
        }
        for (String psIdEntity : strArr) {
            arrayList.add(new PMDefs.PsIdEntity(psIdEntity, ""));
        }
        ChatClient chatClient = this.mChatClient;
        if ((chatClient != null ? chatClient.getPeerManager().sendPeerMessage(arrayList, str, i, jArr) : -1) == 0) {
            return true;
        }
        return false;
    }

    public boolean sendMessage(String str, String str2) {
        List arrayList = new ArrayList();
        if (this.mRoomids.size() == 1 || str == null) {
            arrayList = this.mRoomids;
        } else {
            arrayList.add(str);
        }
        return sendMessage(arrayList, str2, 99, new long[0]);
    }

    public boolean sendMessage(String str, String str2, long[] jArr) {
        List arrayList = new ArrayList();
        if (this.mRoomids.size() == 1 || str == null) {
            arrayList = this.mRoomids;
        } else {
            arrayList.add(str);
        }
        return sendMessage(arrayList, str2, 99, jArr);
    }

    public boolean sendNormalMessage(MsgBean msgBean) {
        List<String> list;
        String objToJson = GsonUtil.getInstance().objToJson(msgBean);
        if (TextUtils.isEmpty(objToJson) || (list = this.mRoomids) == null || list.size() <= 0) {
            return false;
        }
        return sendMessage(this.mRoomids, objToJson, 99, new long[0]);
    }

    public boolean sendNormalMessage(MsgBean msgBean, long[] jArr) {
        List<String> list;
        String objToJson = GsonUtil.getInstance().objToJson(msgBean);
        if (TextUtils.isEmpty(objToJson) || (list = this.mRoomids) == null || list.size() <= 0) {
            return false;
        }
        return sendMessage(this.mRoomids, objToJson, 99, jArr);
    }

    public boolean sendNoticeMessage(MsgBean msgBean) {
        List<String> list;
        String objToJson = GsonUtil.getInstance().objToJson(msgBean);
        if (TextUtils.isEmpty(objToJson) || (list = this.mRoomids) == null || list.size() <= 0) {
            return false;
        }
        return sendMessage(this.mRoomids, objToJson, 1, new long[0]);
    }

    private boolean sendMessage(List<String> list, String str, int i, long[] jArr) {
        Tag tag = Tag.IRC;
        XesLog.i(tag, new Object[]{"发送群聊消息，房间ID=" + GsonUtil.getInstance().objToJson(list) + "，消息内容=" + str + "优先级=" + i});
        if (jArr == null) {
            jArr = new long[0];
        }
        int i2 = -1;
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            i2 = chatClient.getRoomManager().sendRoomMessage(list, str, i, jArr);
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    public boolean sendRoomBinaryMessage(String str, long j, byte[] bArr) {
        return sendRoomBinaryMessage(str, j, bArr, new long[]{0});
    }

    public boolean sendRoomBinaryMessage(String str, long j, byte[] bArr, long[] jArr) {
        ILiveControllerProvider iLiveControllerProvider;
        Tag tag = Tag.IRC;
        XesLog.i(tag, new Object[]{"发送二进制聊天室消息>>>key=" + str + ",keyMsgId=" + j});
        ChatClient chatClient = this.mChatClient;
        int sendRoomBinaryMessage = (chatClient == null || chatClient.getRoomManager() == null) ? -1 : this.mChatClient.getRoomManager().sendRoomBinaryMessage(str, j, bArr, jArr);
        if (!(sendRoomBinaryMessage == 0 || (iLiveControllerProvider = this.mLiveControllerProvider) == null || iLiveControllerProvider.getBinaryCallbackList() == null || this.mLiveControllerProvider.getBinaryCallbackList().size() <= 0)) {
            for (BinaryMessageCallback binaryMessageCallback : this.mLiveControllerProvider.getBinaryCallbackList()) {
                if (binaryMessageCallback != null) {
                    long j2 = 0;
                    if (jArr != null && jArr.length > 0) {
                        j2 = jArr[0];
                    }
                    binaryMessageCallback.onSendRoomBinaryMessageFailed(sendRoomBinaryMessage, "", j2);
                }
            }
        }
        if (sendRoomBinaryMessage == 0) {
            return true;
        }
        return false;
    }

    public void getUserList(int i) {
        ChatClient chatClient = this.mChatClient;
        if (chatClient != null) {
            chatClient.getRoomManager().getRoomUserList(this.mRoomids, i, new long[0]);
        }
    }

    public void onDestroy() {
        if (this.mChatClient != null) {
            List<String> list = this.mRoomids;
            if (list != null && !list.isEmpty()) {
                this.mChatClient.getRoomManager().leaveChatRooms(this.mRoomids);
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("logout", "destory");
            XesLog.ut(TAG, jsonObject);
            this.mChatClient.logout("destory");
            this.mChatClient.unInit();
            TMSdkManager.getInstance().unInit();
            this.mChatClient.getPeerManager().removeListener(this.mIrcPeerChatListener);
            this.mChatClient.getRoomManager().removeListener(this.mIrcRoomChatListener);
            this.mChatClient.removeListener(this.mIrcChatClientListener);
            this.mChatClient = null;
        }
    }

    public void addIrcChatListener(IrcChatListener ircChatListener) {
        if (!this.mIrcChatListeners.contains(ircChatListener)) {
            this.mIrcChatListeners.add(ircChatListener);
            ircChatListener.onNetStatusChanged(this.mNetStatusResp);
        }
    }

    public void removeIrcChatListener(IrcChatListener ircChatListener) {
        List<IrcChatListener> list = this.mIrcChatListeners;
        if (list != null) {
            list.remove(ircChatListener);
        }
    }

    public void addIrcListener(IIrcListener iIrcListener) {
        synchronized (this.mIrcListeners) {
            if (!this.mIrcListeners.contains(iIrcListener)) {
                this.mIrcListeners.add(iIrcListener);
            }
        }
    }

    public void removeIrcListener(IIrcListener iIrcListener) {
        if (iIrcListener != null) {
            this.mIrcListeners.remove(iIrcListener);
        }
    }

    class IrcChatClientListener extends IChatClientListener {
        public void onLogoutNotice(PMDefs.LogoutNotice logoutNotice) {
        }

        IrcChatClientListener() {
        }

        public void onLoginResponse(PMDefs.LoginResp loginResp) {
            int i;
            if (loginResp.code == 0) {
                Tag tag = Tag.IRC_MONITOR;
                XesLog.s(tag, new Object[]{"登录成功=" + GsonUtil.getInstance().objToJson(loginResp)});
            } else {
                Tag tag2 = Tag.IRC_MONITOR;
                XesLog.e(tag2, new Object[]{"登录失败=" + GsonUtil.getInstance().objToJson(loginResp) + "，错误码=" + loginResp.code});
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcFailEventType ircFailEventType = IrcFailEventType.LOGIN_FAIL;
                ircTrackUtil.trackFailEvent(ircFailEventType, "登录失败=" + GsonUtil.getInstance().objToJson(loginResp) + "，错误码=" + loginResp.code);
            }
            if (loginResp.code == 0 && IrcController.this.mIsFirstLogin) {
                XesLog.i(Tag.IRC_MONITOR, new Object[]{"IRC开始加入房间"});
                if (IrcController.this.mRoomids.isEmpty()) {
                    XesLog.e(Tag.IRC_MONITOR, new Object[]{"调用加入房间接口失败，房间信息为空"});
                    IrcTrackUtil.INSTANCE.trackFailEvent(IrcFailEventType.CALL_JOIN_ROOM_METHOD_FAIL, "调用加入房间接口失败，房间信息为空");
                    return;
                }
                if (IrcController.this.mAlluser) {
                    i = IrcController.this.mChatClient.getRoomManager().joinChatRooms(IrcController.this.mRoomids);
                } else {
                    i = IrcController.this.mChatClient.getRoomManager().joinChatRooms(IrcController.this.mRoomids, 2);
                }
                boolean unused = IrcController.this.mIsFirstLogin = false;
                if (loginResp.code != 0) {
                    Tag tag3 = Tag.IRC_MONITOR;
                    XesLog.e(tag3, new Object[]{"调用加入房间接口失败，房间信息=" + GsonUtil.getInstance().objToJson(IrcController.this.mRoomids) + "，错误码=" + i});
                    IrcTrackUtil ircTrackUtil2 = IrcTrackUtil.INSTANCE;
                    IrcFailEventType ircFailEventType2 = IrcFailEventType.CALL_JOIN_ROOM_METHOD_FAIL;
                    ircTrackUtil2.trackFailEvent(ircFailEventType2, "调用加入房间接口失败，房间信息=" + GsonUtil.getInstance().objToJson(IrcController.this.mRoomids) + "，错误码=" + i);
                }
            }
        }

        public void onKickoutNotice(PMDefs.KickoutNotice kickoutNotice) {
            Tag tag = Tag.IRC_MONITOR;
            XesLog.e(tag, new Object[]{"被踢出直播间=" + GsonUtil.getInstance().objToJson(kickoutNotice)});
            if (kickoutNotice.code == 301 || kickoutNotice.code == 302 || kickoutNotice.code == 399) {
                IrcController.this.onDestroy();
                IrcController.this.mLiveControllerProvider.backLiveRoom(ExitLiveRoom.KICK_OUT);
                ToastUtils.showLong(StringUtils.getString(R.string.kick_out));
                XesLog.ut("student.IRCKick", new JsonObject());
            }
        }

        public void onNetStatusChanged(PMDefs.NetStatusResp netStatusResp) {
            int unused = IrcController.this.mNetStatusResp = netStatusResp.netStatus;
            if (IrcController.this.mNetStatusResp == 4) {
                XesLog.s(Tag.IRC_MONITOR, new Object[]{"IRC连接成功"});
                IrcTrackUtil.INSTANCE.trackConnectSuccessEvent();
            } else if (IrcController.this.mNetStatusResp == 3) {
                if (IrcController.this.mIsFirstConnect) {
                    XesLog.i(Tag.IRC_MONITOR, new Object[]{"IRC首次连接中"});
                    boolean unused2 = IrcController.this.mIsFirstConnect = false;
                    IrcTrackUtil.INSTANCE.trackConnectStartEvent();
                } else {
                    XesLog.i(Tag.IRC_MONITOR, new Object[]{"IRC重连接中"});
                    IrcTrackUtil.INSTANCE.trackReStartEvent();
                    IrcTrackUtil.INSTANCE.trackConnectReStartEvent();
                }
            } else if (IrcController.this.mNetStatusResp == 5) {
                XesLog.e(Tag.IRC_MONITOR, new Object[]{"IRC断开链接"});
            } else {
                Tag tag = Tag.IRC_MONITOR;
                XesLog.e(tag, new Object[]{"IRC连接失败>>>错误码=" + IrcController.this.mNetStatusResp + "，状态码描述：0：未知网络，1：网络不可用，2：服务器连接失败,设备是否有网=" + NetworkUtils.isConnected()});
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcFailEventType ircFailEventType = IrcFailEventType.CONNECT_FAIL;
                ircTrackUtil.trackFailEvent(ircFailEventType, "IRC连接失败>>>错误码=" + IrcController.this.mNetStatusResp + "，状态码描述：0：未知网络，1：网络不可用，2：服务器连接失败,设备是否有网=" + NetworkUtils.isConnected());
                IrcTrackUtil ircTrackUtil2 = IrcTrackUtil.INSTANCE;
                ircTrackUtil2.trackConnectFailEvent("错误码=" + IrcController.this.mNetStatusResp + "，状态码描述：0：未知网络，1：网络不可用，2：服务器连接失败,设备是否有网=" + NetworkUtils.isConnected());
            }
            if (netStatusResp.netStatus == 0 || 1 == netStatusResp.netStatus || 2 == netStatusResp.netStatus || 5 == netStatusResp.netStatus) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("sendTime", -1);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("status", Integer.valueOf(netStatusResp.netStatus));
                    jSONObject.putOpt(LocalBusinessKey.LOCAL_NET_DISCONNECT, jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_NET_DISCONNECT, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            }
            if (4 == netStatusResp.netStatus) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.putOpt("sendTime", -1);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("status", Integer.valueOf(netStatusResp.netStatus));
                    jSONObject3.putOpt(LocalBusinessKey.LOCAL_NET_CONNECTED, jSONObject4);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_NET_CONNECTED, !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3));
            }
            if (IrcController.this.mIrcChatListeners != null && IrcController.this.mIrcChatListeners.size() != 0) {
                for (IrcChatListener ircChatListener : IrcController.this.mIrcChatListeners) {
                    if (ircChatListener != null) {
                        ircChatListener.onNetStatusChanged(netStatusResp.netStatus);
                    }
                }
            }
        }
    }

    class IrcPeerChatListener extends IPeerChatListener {
        IrcPeerChatListener() {
        }

        public void onRecvPeerMessage(PMDefs.PeerChatMessage peerChatMessage) {
            if (peerChatMessage != null && !TextUtils.isEmpty(peerChatMessage.content)) {
                Tag tag = Tag.IRC;
                XesLog.i(tag, new Object[]{"IrcController-收到私聊消息=" + GsonUtil.getInstance().objToJson(peerChatMessage)});
                try {
                    JSONObject jSONObject = new JSONObject(peerChatMessage.content);
                    int optInt = jSONObject.optInt(ClassParamsKt.TYPE);
                    if (optInt == 130) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("sendTime", -1);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("sender", peerChatMessage.fromUserId.nickname);
                        jSONObject3.putOpt("content", peerChatMessage.content);
                        jSONObject2.putOpt(LocalBusinessKey.PEER_CHAT_MSG, jSONObject3);
                        Tag tag2 = Tag.IRC;
                        Object[] objArr = new Object[1];
                        StringBuilder sb = new StringBuilder();
                        sb.append("返回业务层私聊消息，ircType=peer_chat_msgircMessage=");
                        sb.append(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
                        objArr[0] = sb.toString();
                        XesLog.i(tag2, objArr);
                        IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.PEER_CHAT_MSG, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
                    } else if (optInt == 140) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.putOpt("sendTime", -1);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.putOpt("sender", peerChatMessage.fromUserId.nickname);
                        jSONObject5.putOpt("content", peerChatMessage.content);
                        jSONObject4.putOpt(LocalBusinessKey.HOMEWORK_BOX_CHECK, jSONObject5);
                        Tag tag3 = Tag.IRC;
                        Object[] objArr2 = new Object[1];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("返回业务层私聊消息，ircType=homework_box_checkircMessage=");
                        sb2.append(!(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4));
                        objArr2[0] = sb2.toString();
                        XesLog.i(tag3, objArr2);
                        IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.HOMEWORK_BOX_CHECK, !(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4));
                    } else {
                        String optString = jSONObject.optString("ircType");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!jSONObject.has("sendTime")) {
                                jSONObject.putOpt("sendTime", Long.valueOf(peerChatMessage.timestamp));
                            }
                            if (peerChatMessage.fromUserId != null) {
                                if (!jSONObject.has("from")) {
                                    JSONObject jSONObject6 = new JSONObject();
                                    if (!TextUtils.isEmpty(peerChatMessage.fromUserId.nickname)) {
                                        jSONObject6.putOpt("ircNickname", peerChatMessage.fromUserId.nickname);
                                    }
                                    if (!TextUtils.isEmpty(peerChatMessage.fromUserId.psid)) {
                                        jSONObject6.putOpt("userId", peerChatMessage.fromUserId.psid);
                                    }
                                    if (!TextUtils.isEmpty(!(jSONObject6 instanceof JSONObject) ? jSONObject6.toString() : JSONObjectInstrumentation.toString(jSONObject6))) {
                                        jSONObject.putOpt("from", jSONObject6);
                                    }
                                } else {
                                    JSONObject optJSONObject = jSONObject.optJSONObject("from");
                                    if (!TextUtils.isEmpty(peerChatMessage.fromUserId.nickname)) {
                                        optJSONObject.putOpt("ircNickname", peerChatMessage.fromUserId.nickname);
                                    }
                                    if (!TextUtils.isEmpty(peerChatMessage.fromUserId.psid)) {
                                        optJSONObject.putOpt("userId", peerChatMessage.fromUserId.psid);
                                    }
                                }
                            }
                            Tag tag4 = Tag.IRC;
                            Object[] objArr3 = new Object[1];
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("返回业务层私聊消息，ircType=");
                            sb3.append(optString);
                            sb3.append("ircMessage=");
                            sb3.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                            objArr3[0] = sb3.toString();
                            XesLog.i(tag4, objArr3);
                            IrcController.this.mLiveControllerProvider.dispatchIrcMessage(optString, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onSendPeerMessageResponse(PMDefs.SendPeerMessageResp sendPeerMessageResp) {
            if (sendPeerMessageResp != null) {
                if (sendPeerMessageResp.code == 0) {
                    Tag tag = Tag.IRC_MONITOR;
                    XesLog.s(tag, new Object[]{"发送私聊消息成功=" + GsonUtil.getInstance().objToJson(sendPeerMessageResp)});
                    IrcTrackUtil.INSTANCE.trackSendMessageSuccessEvent(IrcMsgType.PEER_MSG);
                    IrcController.this.onSendPeerMessageSuccess(sendPeerMessageResp.preMsgId);
                    return;
                }
                Tag tag2 = Tag.IRC_MONITOR;
                XesLog.e(tag2, new Object[]{"发送私聊消息失败=" + GsonUtil.getInstance().objToJson(sendPeerMessageResp)});
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", sendPeerMessageResp.msgId);
                    if (sendPeerMessageResp.fromUserInfo != null) {
                        jSONObject.put("fromNickname", sendPeerMessageResp.fromUserInfo.nickname);
                    }
                    if (sendPeerMessageResp.toUserInfo != null) {
                        jSONObject.put("toNickname", sendPeerMessageResp.toUserInfo.nickname);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcMsgType ircMsgType = IrcMsgType.PEER_MSG;
                SendMsgFailEventType sendMsgFailEventType = SendMsgFailEventType.SEND_PEER_MSG_FAIL;
                ircTrackUtil.trackSendMessageFailEvent(ircMsgType, sendMsgFailEventType, "错误码=" + sendPeerMessageResp.code + "，错误信息=" + sendPeerMessageResp.info, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                IrcController.this.onSendPeerMessageFailed(sendPeerMessageResp.code, sendPeerMessageResp.info, sendPeerMessageResp.preMsgId);
            }
        }
    }

    class IrcRoomChatListener extends IRoomChatListener {
        private List<PMDefs.PsIdEntity> userLists;

        public void onGetRoomUserListResponse(PMDefs.GetRoomUserListResp getRoomUserListResp) {
        }

        IrcRoomChatListener() {
        }

        public void onJoinRoomResponse(PMDefs.JoinRoomResp joinRoomResp) {
            if (joinRoomResp.code == 0) {
                Tag tag = Tag.IRC_MONITOR;
                XesLog.s(tag, new Object[]{"加入房间成功=" + GsonUtil.getInstance().objToJson(joinRoomResp)});
                IrcTrackUtil.INSTANCE.trackSuccessEvent();
            } else {
                Tag tag2 = Tag.IRC_MONITOR;
                XesLog.e(tag2, new Object[]{"加入房间失败=" + GsonUtil.getInstance().objToJson(joinRoomResp) + "，错误码=" + joinRoomResp.code});
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcFailEventType ircFailEventType = IrcFailEventType.JOIN_ROOM_FAIL;
                ircTrackUtil.trackFailEvent(ircFailEventType, "加入房间失败=" + GsonUtil.getInstance().objToJson(joinRoomResp) + "，错误码=" + joinRoomResp.code);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sendTime", -1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("roomId", joinRoomResp.roomId);
                jSONObject.put(LocalBusinessKey.LOCAL_JOIN_ROOM, jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_JOIN_ROOM, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        }

        public void onRecvRoomUserList(PMDefs.RoomUserList roomUserList) {
            Tag tag = Tag.IRC;
            XesLog.i(tag, new Object[]{"onRecvRoomUserList code = " + roomUserList.code + " size = " + roomUserList.userList.size()});
            if (this.userLists == null) {
                this.userLists = new ArrayList();
            }
            if (IrcController.this.mAlluser) {
                if (52 == roomUserList.code) {
                    if (roomUserList.userList != null && !roomUserList.userList.isEmpty()) {
                        this.userLists.addAll(roomUserList.userList);
                    }
                } else if (53 == roomUserList.code) {
                    if (roomUserList.userList != null && !roomUserList.userList.isEmpty()) {
                        this.userLists.addAll(roomUserList.userList);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("sendTime", -1);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("count", Integer.valueOf(this.userLists.size()));
                        jSONObject2.putOpt("roomId", roomUserList.roomId);
                        jSONObject.putOpt(LocalBusinessKey.LOCAL_USER_COUNT, jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_USER_COUNT, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                    this.userLists.clear();
                }
            } else if (52 == roomUserList.code) {
                if (roomUserList.userList != null && !roomUserList.userList.isEmpty()) {
                    this.userLists.addAll(roomUserList.userList);
                }
            } else if (53 == roomUserList.code) {
                if (roomUserList.userList != null && !roomUserList.userList.isEmpty()) {
                    this.userLists.addAll(roomUserList.userList);
                }
                for (int i = 0; i < this.userLists.size(); i++) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.putOpt("sendTime", -1);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.putOpt("onJoin", this.userLists.get(i).nickname);
                        jSONObject4.putOpt("roomId", roomUserList.roomId);
                        jSONObject3.putOpt(LocalBusinessKey.LOCAL_USER_COUNT, jSONObject4);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_USER_COUNT, !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3));
                }
                this.userLists.clear();
            }
        }

        public void onRecvRoomMessage(PMDefs.RoomChatMessage roomChatMessage) {
            PMDefs.RoomChatMessage roomChatMessage2 = roomChatMessage;
            try {
                Tag tag = Tag.IRC;
                XesLog.i(tag, new Object[]{"IrcController-收到群聊消息=" + GsonUtil.getInstance().objToJson(roomChatMessage2)});
                JSONObject jSONObject = new JSONObject(roomChatMessage2.content);
                int optInt = jSONObject.optInt(ClassParamsKt.TYPE);
                String optString = jSONObject.optString("to_uid");
                if (optInt != 130) {
                    if (optInt == 139) {
                        if (IrcController.this.checkIsMyPrivateMsg(roomChatMessage2.fromUserId.nickname, optString)) {
                        }
                    }
                    if (optInt == 142) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("sendTime", -1);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("sender", roomChatMessage2.fromUserId.nickname);
                        jSONObject3.putOpt("content", roomChatMessage2.content);
                        jSONObject2.putOpt(LocalBusinessKey.LEVEL_CHAT_MSG, jSONObject3);
                        Tag tag2 = Tag.IRC;
                        Object[] objArr = new Object[1];
                        StringBuilder sb = new StringBuilder();
                        sb.append("返回业务层群聊消息，ircType=level_chat_msgircMessage=");
                        sb.append(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
                        objArr[0] = sb.toString();
                        XesLog.i(tag2, objArr);
                        IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LEVEL_CHAT_MSG, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
                        return;
                    }
                    String optString2 = jSONObject.optString("ircType");
                    if (!TextUtils.isEmpty(optString2)) {
                        if (!jSONObject.has("sendTime")) {
                            jSONObject.putOpt("sendTime", Long.valueOf(roomChatMessage2.timestamp));
                        }
                        if (roomChatMessage2.fromUserId != null) {
                            if (!jSONObject.has("from")) {
                                JSONObject jSONObject4 = new JSONObject();
                                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.nickname)) {
                                    jSONObject4.putOpt("ircNickname", roomChatMessage2.fromUserId.nickname);
                                }
                                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.psid)) {
                                    jSONObject4.putOpt("userId", roomChatMessage2.fromUserId.psid);
                                }
                                if (!TextUtils.isEmpty(!(jSONObject4 instanceof JSONObject) ? jSONObject4.toString() : JSONObjectInstrumentation.toString(jSONObject4))) {
                                    jSONObject.putOpt("from", jSONObject4);
                                }
                            } else {
                                JSONObject optJSONObject = jSONObject.optJSONObject("from");
                                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.nickname)) {
                                    optJSONObject.putOpt("ircNickname", roomChatMessage2.fromUserId.nickname);
                                }
                                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.psid)) {
                                    optJSONObject.putOpt("userId", roomChatMessage2.fromUserId.psid);
                                }
                            }
                        }
                        Tag tag3 = Tag.IRC;
                        Object[] objArr2 = new Object[1];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("返回业务层群聊消息，ircType=");
                        sb2.append(optString2);
                        sb2.append("ircMessage=");
                        sb2.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                        objArr2[0] = sb2.toString();
                        XesLog.i(tag3, objArr2);
                        IrcController.this.mLiveControllerProvider.dispatchIrcMessage(optString2, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("sendTime", -1);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.putOpt("sender", roomChatMessage2.fromUserId.nickname);
                jSONObject6.putOpt("content", roomChatMessage2.content);
                JSONObject jSONObject7 = new JSONObject();
                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.nickname)) {
                    jSONObject7.putOpt("ircNickname", roomChatMessage2.fromUserId.nickname);
                }
                if (!TextUtils.isEmpty(roomChatMessage2.fromUserId.psid)) {
                    jSONObject7.putOpt("userId", roomChatMessage2.fromUserId.psid);
                }
                if (!TextUtils.isEmpty(!(jSONObject7 instanceof JSONObject) ? jSONObject7.toString() : JSONObjectInstrumentation.toString(jSONObject7))) {
                    jSONObject6.putOpt("from", jSONObject7);
                }
                jSONObject5.putOpt(LocalBusinessKey.LOCAL_CHAT_MSG, jSONObject6);
                Tag tag4 = Tag.IRC;
                Object[] objArr3 = new Object[1];
                StringBuilder sb3 = new StringBuilder();
                sb3.append("返回业务层群聊消息，ircType=local_chat_msgircMessage=");
                sb3.append(!(jSONObject5 instanceof JSONObject) ? jSONObject5.toString() : JSONObjectInstrumentation.toString(jSONObject5));
                objArr3[0] = sb3.toString();
                XesLog.i(tag4, objArr3);
                IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_CHAT_MSG, !(jSONObject5 instanceof JSONObject) ? jSONObject5.toString() : JSONObjectInstrumentation.toString(jSONObject5));
            } catch (Exception e) {
                e.printStackTrace();
                XesLog.i(Tag.IRC, new Object[]{"解析群聊消息异常"});
            }
        }

        public void onRecvRoomBinaryMessage(PMDefs.RoomChatBinaryMessage roomChatBinaryMessage) {
            if (roomChatBinaryMessage != null) {
                BinaryMessageInfo binaryMessageInfo = new BinaryMessageInfo();
                binaryMessageInfo.key = roomChatBinaryMessage.key;
                binaryMessageInfo.keyMsgId = roomChatBinaryMessage.keyMsgId;
                binaryMessageInfo.msgId = roomChatBinaryMessage.msgId;
                binaryMessageInfo.content = roomChatBinaryMessage.content;
                binaryMessageInfo.timestamp = roomChatBinaryMessage.timestamp;
                binaryMessageInfo.from = roomChatBinaryMessage.from.nickname;
                IrcController.this.mLiveControllerProvider.dispatchBinaryMessage(binaryMessageInfo);
            }
        }

        public void onSendRoomBinaryMessageResp(PMDefs.SendRoomBinaryMessageResp sendRoomBinaryMessageResp) {
            if (sendRoomBinaryMessageResp != null) {
                if (sendRoomBinaryMessageResp.code == 0) {
                    Tag tag = Tag.IRC_MONITOR;
                    XesLog.s(tag, new Object[]{"发送二进制聊天室消息成功>>>resp=" + GsonUtil.getInstance().objToJson(sendRoomBinaryMessageResp)});
                    IrcTrackUtil.INSTANCE.trackSendMessageSuccessEvent(IrcMsgType.ROOM_BINARY_MSG);
                } else {
                    Tag tag2 = Tag.IRC_MONITOR;
                    XesLog.e(tag2, new Object[]{"发送二进制聊天室消息失败>>>resp=" + GsonUtil.getInstance().objToJson(sendRoomBinaryMessageResp)});
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msgId", sendRoomBinaryMessageResp.msgId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                    IrcMsgType ircMsgType = IrcMsgType.ROOM_BINARY_MSG;
                    SendMsgFailEventType sendMsgFailEventType = SendMsgFailEventType.SEND_ROOM_BINARY_MSG_FAIL;
                    ircTrackUtil.trackSendMessageFailEvent(ircMsgType, sendMsgFailEventType, "错误码=" + sendRoomBinaryMessageResp.code + "，错误信息=" + sendRoomBinaryMessageResp.info, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                }
                if (sendRoomBinaryMessageResp.code != 0 && IrcController.this.mLiveControllerProvider != null && IrcController.this.mLiveControllerProvider.getBinaryCallbackList() != null && IrcController.this.mLiveControllerProvider.getBinaryCallbackList().size() > 0) {
                    for (BinaryMessageCallback binaryMessageCallback : IrcController.this.mLiveControllerProvider.getBinaryCallbackList()) {
                        if (binaryMessageCallback != null) {
                            binaryMessageCallback.onSendRoomBinaryMessageFailed(sendRoomBinaryMessageResp.code, sendRoomBinaryMessageResp.info, sendRoomBinaryMessageResp.preMsgId);
                        }
                    }
                }
            }
        }

        public void onSendRoomMessageResp(PMDefs.SendRoomMessageResp sendRoomMessageResp) {
            if (sendRoomMessageResp != null) {
                if (sendRoomMessageResp.code == 0) {
                    Tag tag = Tag.IRC_MONITOR;
                    XesLog.s(tag, new Object[]{"发送群聊消息成功=" + GsonUtil.getInstance().objToJson(sendRoomMessageResp)});
                    IrcTrackUtil.INSTANCE.trackSendMessageSuccessEvent(IrcMsgType.ROOM_MSG);
                    IrcController.this.onSendRoomMessageSuccess(sendRoomMessageResp.preMsgId);
                    return;
                }
                Tag tag2 = Tag.IRC_MONITOR;
                XesLog.e(tag2, new Object[]{"发送群聊消息失败=" + GsonUtil.getInstance().objToJson(sendRoomMessageResp)});
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", sendRoomMessageResp.msgId);
                    jSONObject.put("toRoomId", sendRoomMessageResp.toRoomId);
                    if (sendRoomMessageResp.fromUserInfo != null) {
                        jSONObject.put("nickname", sendRoomMessageResp.fromUserInfo.nickname);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                IrcTrackUtil ircTrackUtil = IrcTrackUtil.INSTANCE;
                IrcMsgType ircMsgType = IrcMsgType.ROOM_MSG;
                SendMsgFailEventType sendMsgFailEventType = SendMsgFailEventType.SEND_ROOM_MSG_FAIL;
                ircTrackUtil.trackSendMessageFailEvent(ircMsgType, sendMsgFailEventType, "错误码=" + sendRoomMessageResp.code + "，错误信息=" + sendRoomMessageResp.info, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                IrcController.this.onSendRoomMessageFailed(sendRoomMessageResp.code, sendRoomMessageResp.info, sendRoomMessageResp.preMsgId);
            }
        }

        public void onGetRoomHistoryBinaryMessagesResponse(PMDefs.RoomHistoryBinaryMessages roomHistoryBinaryMessages) {
            IrcController.this.mLiveControllerProvider.dispatchBinaryMessage(binaryMessageChange(roomHistoryBinaryMessages));
        }

        private BinaryMessage binaryMessageChange(PMDefs.RoomHistoryBinaryMessages roomHistoryBinaryMessages) {
            BinaryMessage binaryMessage = new BinaryMessage();
            if (roomHistoryBinaryMessages == null) {
                binaryMessage.code = -1;
            } else {
                binaryMessage.code = roomHistoryBinaryMessages.code;
                binaryMessage.info = roomHistoryBinaryMessages.info;
                binaryMessage.key = roomHistoryBinaryMessages.key;
                binaryMessage.order = roomHistoryBinaryMessages.order;
                binaryMessage.traceId = roomHistoryBinaryMessages.traceId;
                binaryMessage.contents = new ArrayList();
                if (roomHistoryBinaryMessages.content != null) {
                    Iterator it = roomHistoryBinaryMessages.content.iterator();
                    while (it.hasNext()) {
                        PMDefs.RoomChatBinaryMessage roomChatBinaryMessage = (PMDefs.RoomChatBinaryMessage) it.next();
                        BinaryMessageInfo binaryMessageInfo = new BinaryMessageInfo();
                        binaryMessageInfo.key = roomChatBinaryMessage.key;
                        binaryMessageInfo.keyMsgId = roomChatBinaryMessage.keyMsgId;
                        binaryMessageInfo.msgId = roomChatBinaryMessage.msgId;
                        binaryMessageInfo.content = roomChatBinaryMessage.content;
                        binaryMessageInfo.timestamp = roomChatBinaryMessage.timestamp;
                        binaryMessageInfo.from = roomChatBinaryMessage.from.nickname;
                        binaryMessage.contents.add(binaryMessageInfo);
                    }
                }
            }
            binaryMessage.isHistory = true;
            return binaryMessage;
        }

        public void onGetRoomBatchHistoryBinaryMessagesResponse(PMDefs.RoomBatchHistoryBinaryMessages roomBatchHistoryBinaryMessages) {
            BatchBinaryMessage batchBinaryMessage = new BatchBinaryMessage();
            if (roomBatchHistoryBinaryMessages == null) {
                batchBinaryMessage.code = -1;
            } else {
                batchBinaryMessage.code = roomBatchHistoryBinaryMessages.code;
                batchBinaryMessage.info = roomBatchHistoryBinaryMessages.info;
                batchBinaryMessage.keyMsgs = new ArrayList();
                if (roomBatchHistoryBinaryMessages.keyMsgs != null && !roomBatchHistoryBinaryMessages.keyMsgs.isEmpty()) {
                    Iterator it = roomBatchHistoryBinaryMessages.keyMsgs.iterator();
                    while (it.hasNext()) {
                        batchBinaryMessage.keyMsgs.add(binaryMessageChange((PMDefs.RoomHistoryBinaryMessages) it.next()));
                    }
                }
            }
            IrcController.this.mLiveControllerProvider.dispatchBatchBinaryMessage(batchBinaryMessage);
        }

        public void onMuteRoomNotice(PMDefs.MuteRoomNotice muteRoomNotice) {
            Tag tag = Tag.IRC;
            XesLog.i(tag, new Object[]{"onMuteRoomNotice from = " + muteRoomNotice.handler.nickname + " roomId = " + muteRoomNotice.roomId + " flag = " + muteRoomNotice.flag});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("sendTime", -1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("roomId", muteRoomNotice.roomId);
                jSONObject2.putOpt("flag", Integer.valueOf(muteRoomNotice.flag));
                jSONObject.putOpt(LocalBusinessKey.LOCAL_MUTE, jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_MUTE, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        }

        public void onRecvRoomDataUpdateNotice(PMDefs.RoomData roomData) {
            if (roomData != null) {
                try {
                    Tag tag = Tag.IRC;
                    XesLog.i(tag, new Object[]{"聊天室数据更新通知，msgId = " + roomData.msgId + ",roomId = " + roomData.roomId + ",sender = " + GsonUtil.getInstance().objToJson(roomData.handler)});
                    HashMap hashMap = roomData.data;
                    if (hashMap != null) {
                        for (String str : hashMap.keySet()) {
                            PMDefs.RoomDataElement roomDataElement = (PMDefs.RoomDataElement) hashMap.get(str);
                            if (roomDataElement != null) {
                                XesLog.i(Tag.IRC_INTERACT, new Object[]{roomDataElement.value});
                                IrcController.this.mLiveControllerProvider.dispatchIrcMessage(str, roomDataElement.value);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onGetRoomDataResponse(PMDefs.GetRoomDataResp getRoomDataResp) {
            Tag tag = Tag.IRC;
            XesLog.i(tag, new Object[]{"onGetRoomDataResponse>>>" + GsonUtil.getInstance().objToJson(getRoomDataResp)});
            if (getRoomDataResp != null) {
                HashMap hashMap = getRoomDataResp.datas;
                HashMap hashMap2 = new HashMap();
                if (hashMap != null && hashMap.size() > 0) {
                    for (String str : hashMap.keySet()) {
                        hashMap2.put(str, ((PMDefs.RoomDataElement) hashMap.get(str)).value);
                    }
                    IrcController.this.mLiveControllerProvider.dispatchIrcMessage(hashMap2);
                }
            }
        }

        public void onGetLiveStatisticsResponse(PMDefs.GetLiveStatisticsResp getLiveStatisticsResp) {
            Tag tag = Tag.IRC;
            XesLog.i(tag, new Object[]{"onGetLiveStatisticsResponse key = " + getLiveStatisticsResp.key + " data tostring = " + getLiveStatisticsResp.datas.toString()});
        }

        public void onRecvRoomUserCountUpdateNotice(PMDefs.RoomUserCountUpdateNotice roomUserCountUpdateNotice) {
            Tag tag = Tag.IRC;
            XesLog.i(tag, new Object[]{"onRecvRoomUserCountUpdateNotice size = " + roomUserCountUpdateNotice.userCount.size()});
            HashMap hashMap = roomUserCountUpdateNotice.userCount;
            for (String str : hashMap.keySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("sendTime", -1);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("count", hashMap.get(str));
                    jSONObject2.putOpt("roomId", str);
                    jSONObject.putOpt(LocalBusinessKey.LOCAL_USER_COUNT, jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                IrcController.this.mLiveControllerProvider.dispatchIrcMessage(LocalBusinessKey.LOCAL_USER_COUNT, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            }
        }

        public void onGetRoomHistoryMessagesResponse(PMDefs.RoomHistoryMessages roomHistoryMessages) {
            if (roomHistoryMessages != null) {
                try {
                    if (roomHistoryMessages.content != null && roomHistoryMessages.content.size() > 0) {
                        ArrayList arrayList = roomHistoryMessages.content;
                        int size = arrayList.size();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = size - 1; i >= 0; i--) {
                            PMDefs.RoomChatMessage roomChatMessage = (PMDefs.RoomChatMessage) arrayList.get(i);
                            JSONObject jSONObject = new JSONObject(roomChatMessage.content);
                            int optInt = jSONObject.optInt(ClassParamsKt.TYPE);
                            String optString = jSONObject.optString("to_uid");
                            if (optInt != 130) {
                                if (optInt == 139) {
                                    if (IrcController.this.checkIsMyPrivateMsg(roomChatMessage.fromUserId.nickname, optString)) {
                                    }
                                }
                                String optString2 = jSONObject.optString("ircType");
                                if (!TextUtils.isEmpty(optString2)) {
                                    if (!jSONObject.has("sendTime")) {
                                        jSONObject.putOpt("sendTime", Long.valueOf(roomChatMessage.timestamp));
                                    }
                                    if (roomChatMessage.fromUserId != null) {
                                        if (!jSONObject.has("from")) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.nickname)) {
                                                jSONObject2.putOpt("ircNickname", roomChatMessage.fromUserId.nickname);
                                            }
                                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.psid)) {
                                                jSONObject2.putOpt("userId", roomChatMessage.fromUserId.psid);
                                            }
                                            if (!TextUtils.isEmpty(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2))) {
                                                jSONObject.putOpt("from", jSONObject2);
                                            }
                                        } else {
                                            JSONObject optJSONObject = jSONObject.optJSONObject("from");
                                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.nickname)) {
                                                optJSONObject.putOpt("ircNickname", roomChatMessage.fromUserId.nickname);
                                            }
                                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.psid)) {
                                                optJSONObject.putOpt("userId", roomChatMessage.fromUserId.psid);
                                            }
                                        }
                                    }
                                    Tag tag = Tag.IRC;
                                    Object[] objArr = new Object[1];
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("历史消息，ircType=");
                                    sb.append(optString2);
                                    sb.append("ircMessage=");
                                    sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                                    objArr[0] = sb.toString();
                                    XesLog.i(tag, objArr);
                                    MessageInfo messageInfo = new MessageInfo();
                                    messageInfo.setIrcType(optString2);
                                    messageInfo.setMsg(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                                    arrayList2.add(messageInfo);
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("sendTime", -1);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.putOpt("sender", roomChatMessage.fromUserId.nickname);
                            jSONObject4.putOpt("content", roomChatMessage.content);
                            JSONObject jSONObject5 = new JSONObject();
                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.nickname)) {
                                jSONObject5.putOpt("ircNickname", roomChatMessage.fromUserId.nickname);
                            }
                            if (!TextUtils.isEmpty(roomChatMessage.fromUserId.psid)) {
                                jSONObject5.putOpt("userId", roomChatMessage.fromUserId.psid);
                            }
                            if (!TextUtils.isEmpty(!(jSONObject5 instanceof JSONObject) ? jSONObject5.toString() : JSONObjectInstrumentation.toString(jSONObject5))) {
                                jSONObject4.putOpt("from", jSONObject5);
                            }
                            jSONObject3.putOpt(LocalBusinessKey.LOCAL_CHAT_MSG, jSONObject4);
                            Tag tag2 = Tag.IRC;
                            Object[] objArr2 = new Object[1];
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("历史消息>>>");
                            sb2.append(!(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3));
                            objArr2[0] = sb2.toString();
                            XesLog.i(tag2, objArr2);
                            MessageInfo messageInfo2 = new MessageInfo();
                            messageInfo2.setIrcType(LocalBusinessKey.LOCAL_CHAT_MSG);
                            messageInfo2.setMsg(!(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3));
                            arrayList2.add(messageInfo2);
                        }
                        if (arrayList2.size() > 0) {
                            IrcController.this.onRoomHistoryMessage(arrayList2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean checkIsMyPrivateMsg(String str, String str2) {
        ILiveControllerProvider iLiveControllerProvider = this.mLiveControllerProvider;
        String id = (iLiveControllerProvider == null || iLiveControllerProvider.getDataStorage() == null || this.mLiveControllerProvider.getDataStorage().getUserInfo() == null) ? null : this.mLiveControllerProvider.getDataStorage().getUserInfo().getId();
        return id != null && ((str != null && str.contains(id)) || id.equals(str2));
    }

    /* access modifiers changed from: private */
    public void onSendRoomMessageSuccess(final long j) {
        List<IIrcListener> list = this.mIrcListeners;
        if (list != null && list.size() > 0) {
            synchronized (this.mIrcListeners) {
                try {
                    for (final IIrcListener next : this.mIrcListeners) {
                        if (next != null) {
                            ThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    IIrcListener iIrcListener = next;
                                    if (iIrcListener != null) {
                                        iIrcListener.onSendRoomMessageSuccess(j);
                                    }
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSendRoomMessageFailed(int i, String str, long j) {
        List<IIrcListener> list = this.mIrcListeners;
        if (list != null && list.size() > 0) {
            synchronized (this.mIrcListeners) {
                try {
                    for (final IIrcListener next : this.mIrcListeners) {
                        final int i2 = i;
                        final String str2 = str;
                        final long j2 = j;
                        ThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                IIrcListener iIrcListener = next;
                                if (iIrcListener != null) {
                                    iIrcListener.onSendRoomMessageFailed(i2, str2, j2);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onRoomHistoryMessage(final List<MessageInfo> list) {
        List<IIrcListener> list2;
        if (list != null && list.size() > 0 && (list2 = this.mIrcListeners) != null && list2.size() > 0) {
            synchronized (this.mIrcListeners) {
                try {
                    for (final IIrcListener next : this.mIrcListeners) {
                        ThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                IIrcListener iIrcListener = next;
                                if (iIrcListener != null) {
                                    iIrcListener.onRoomHistoryMessage(list);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSendPeerMessageSuccess(final long j) {
        List<IIrcListener> list = this.mIrcListeners;
        if (list != null && list.size() > 0) {
            synchronized (this.mIrcListeners) {
                try {
                    for (final IIrcListener next : this.mIrcListeners) {
                        if (next != null) {
                            ThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    IIrcListener iIrcListener = next;
                                    if (iIrcListener != null) {
                                        iIrcListener.onSendPeerMessageSuccess(j);
                                    }
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSendPeerMessageFailed(int i, String str, long j) {
        List<IIrcListener> list = this.mIrcListeners;
        if (list != null && list.size() > 0) {
            synchronized (this.mIrcListeners) {
                try {
                    for (final IIrcListener next : this.mIrcListeners) {
                        final int i2 = i;
                        final String str2 = str;
                        final long j2 = j;
                        ThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                IIrcListener iIrcListener = next;
                                if (iIrcListener != null) {
                                    iIrcListener.onSendPeerMessageFailed(i2, str2, j2);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
