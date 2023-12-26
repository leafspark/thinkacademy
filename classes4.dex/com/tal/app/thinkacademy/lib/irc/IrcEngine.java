package com.tal.app.thinkacademy.lib.irc;

import android.content.Context;
import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal100.chatsdk.ChatClient;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.RoomChatManager;
import com.tal100.chatsdk.TMSdkManager;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0006\u0012\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\rJ \u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\u0006\u0010\"\u001a\u00020\u000bJ2\u0010#\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001a2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\nJ\"\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J>\u0010/\u001a\u00020\u000b26\u00100\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000b0\tJ>\u00104\u001a\u00020\u000b26\u00100\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000b0\tJ>\u00107\u001a\u00020\u000b26\u00100\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/tal/app/thinkacademy/lib/irc/IrcEngine;", "", "()V", "mChatClient", "Lcom/tal100/chatsdk/ChatClient;", "mIrcChatClientListener", "com/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcChatClientListener$1", "Lcom/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcChatClientListener$1;", "mIrcDispatch", "Lkotlin/Function2;", "", "", "mIrcInitInfo", "Lcom/tal/app/thinkacademy/lib/irc/IrcInitInfo;", "mIrcKVSendResult", "", "mIrcMsgSendResult", "mIrcRoomChatListener", "com/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcRoomChatListener$1", "Lcom/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcRoomChatListener$1;", "mIsFirstLogin", "mLiveInfo", "Lcom/tal100/chatsdk/PMDefs$LiveInfo;", "mWorkSpaceDir", "Ljava/io/File;", "create", "", "context", "Landroid/content/Context;", "appId", "appKey", "info", "initSDK", "login", "release", "sendMessage", "roomIds", "", "message", "msgPriority", "preMsgId", "", "sendNoticeMessage", "msg", "sendRoomKV", "key", "value", "setIrcDispatch", "block", "Lkotlin/ParameterName;", "name", "data", "setIrcKVSendResult", "success", "result", "setIrcMsgSendResult", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcEngine.kt */
public final class IrcEngine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<String> IRC_DATA_PATH$delegate = LazyKt.lazy(IrcEngine$Companion$IRC_DATA_PATH$2.INSTANCE);
    private static final String TAG = "ircEngine";
    /* access modifiers changed from: private */
    public ChatClient mChatClient;
    private IrcEngine$mIrcChatClientListener$1 mIrcChatClientListener = new IrcEngine$mIrcChatClientListener$1(this);
    /* access modifiers changed from: private */
    public Function2<? super String, ? super String, Unit> mIrcDispatch;
    /* access modifiers changed from: private */
    public IrcInitInfo mIrcInitInfo;
    /* access modifiers changed from: private */
    public Function2<? super Boolean, ? super String, Unit> mIrcKVSendResult;
    /* access modifiers changed from: private */
    public Function2<? super Boolean, ? super String, Unit> mIrcMsgSendResult;
    private IrcEngine$mIrcRoomChatListener$1 mIrcRoomChatListener = new IrcEngine$mIrcRoomChatListener$1(this);
    /* access modifiers changed from: private */
    public boolean mIsFirstLogin = true;
    private PMDefs.LiveInfo mLiveInfo;
    private File mWorkSpaceDir;

    public IrcEngine() {
        ChatClient instance = ChatClient.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.mChatClient = instance;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/irc/IrcEngine$Companion;", "", "()V", "IRC_DATA_PATH", "", "getIRC_DATA_PATH", "()Ljava/lang/String;", "IRC_DATA_PATH$delegate", "Lkotlin/Lazy;", "TAG", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IrcEngine.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String getIRC_DATA_PATH() {
            return (String) IrcEngine.IRC_DATA_PATH$delegate.getValue();
        }
    }

    public final int create(Context context, String str, String str2, IrcInitInfo ircInitInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        Intrinsics.checkNotNullParameter(ircInitInfo, "info");
        XesLog.dt(TAG, "初始化 irc");
        this.mChatClient.addListener(this.mIrcChatClientListener);
        this.mChatClient.getRoomManager().addListener(this.mIrcRoomChatListener);
        this.mIrcInitInfo = ircInitInfo;
        if (this.mLiveInfo == null) {
            PMDefs.LiveInfo liveInfo = new PMDefs.LiveInfo();
            liveInfo.liveId = ircInitInfo.getLiveId();
            liveInfo.nickname = ircInitInfo.getNickname();
            liveInfo.businessId = ircInitInfo.getBusinessId();
            liveInfo.classId = ircInitInfo.getClassId();
            this.mLiveInfo = liveInfo;
        }
        int initSDK = initSDK(context, str, str2);
        if (initSDK != 0 && initSDK != 19) {
            return initSDK;
        }
        int login = login();
        if (login != 0) {
            return login;
        }
        return 0;
    }

    private final int initSDK(Context context, String str, String str2) {
        try {
            File file = new File(PathUtils.getExternalAppDataPath(), Companion.getIRC_DATA_PATH());
            this.mWorkSpaceDir = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            PMDefs.SdkPropertyEntity sdkPropertyEntity = new PMDefs.SdkPropertyEntity();
            PMDefs.SdkPropertyEntity sdkPropertyEntity2 = new PMDefs.SdkPropertyEntity();
            IrcInitInfo ircInitInfo = this.mIrcInitInfo;
            if (ircInitInfo != null) {
                DeviceIrcConfServer confServiceV3 = ircInitInfo.getConfServiceV3();
                if (confServiceV3 != null) {
                    sdkPropertyEntity.protocol = confServiceV3.getProtocol();
                    sdkPropertyEntity.hostname = confServiceV3.getHostname();
                    sdkPropertyEntity.backupIp = confServiceV3.getBackupIp();
                    sdkPropertyEntity.url = confServiceV3.getUrl();
                    sdkPropertyEntity.port = confServiceV3.getPort();
                }
            }
            IrcInitInfo ircInitInfo2 = this.mIrcInitInfo;
            if (ircInitInfo2 != null) {
                DeviceIrcConfServer logService = ircInitInfo2.getLogService();
                if (logService != null) {
                    sdkPropertyEntity2.protocol = logService.getProtocol();
                    sdkPropertyEntity2.hostname = logService.getHostname();
                    sdkPropertyEntity2.backupIp = logService.getBackupIp();
                    sdkPropertyEntity2.url = logService.getUrl();
                    sdkPropertyEntity2.port = logService.getPort();
                }
            }
            TMSdkManager instance = TMSdkManager.getInstance();
            Context applicationContext = context.getApplicationContext();
            File file2 = this.mWorkSpaceDir;
            String absolutePath = file2 == null ? null : file2.getAbsolutePath();
            IrcInitInfo ircInitInfo3 = this.mIrcInitInfo;
            int init = instance.init(applicationContext, str, str2, absolutePath, ircInitInfo3 == null ? null : ircInitInfo3.getLocationV3(), sdkPropertyEntity2, sdkPropertyEntity);
            XesLog.dt(TAG, Intrinsics.stringPlus("initCode = ", Integer.valueOf(init)));
            if (init != 0) {
                return init;
            }
            int init2 = this.mChatClient.init(context.getApplicationContext(), 2);
            XesLog.dt(TAG, Intrinsics.stringPlus("initChatCode = ", Integer.valueOf(init2)));
            return init2;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private final int login() {
        int i;
        String uid;
        String uid2;
        XesLog.dt(TAG, Intrinsics.stringPlus("setLiveInfo = ", Integer.valueOf(this.mChatClient.setLiveInfo(this.mLiveInfo))));
        IrcInitInfo ircInitInfo = this.mIrcInitInfo;
        String str = "avisitor";
        if (!(ircInitInfo == null || (uid2 = ircInitInfo.getUid()) == null)) {
            str = uid2;
        }
        IrcInitInfo ircInitInfo2 = this.mIrcInitInfo;
        String str2 = "123456";
        if (!(ircInitInfo2 == null || (uid = ircInitInfo2.getUid()) == null)) {
            str2 = uid;
        }
        IrcInitInfo ircInitInfo3 = this.mIrcInitInfo;
        if (ircInitInfo3 != null && ircInitInfo3.isCallAllUser()) {
            i = this.mChatClient.login(str, str2);
        } else {
            i = this.mChatClient.login(str, str2, true, 1);
        }
        XesLog.dt(TAG, Intrinsics.stringPlus("loginCode = ", Integer.valueOf(i)));
        return i;
    }

    public static /* synthetic */ boolean sendRoomKV$default(IrcEngine ircEngine, String str, String str2, long[] jArr, int i, Object obj) {
        if ((i & 4) != 0) {
            jArr = null;
        }
        return ircEngine.sendRoomKV(str, str2, jArr);
    }

    public final boolean sendRoomKV(String str, String str2, long[] jArr) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        IrcInitInfo ircInitInfo = this.mIrcInitInfo;
        List<String> roomIds = ircInitInfo == null ? null : ircInitInfo.getRoomIds();
        boolean z = true;
        Map mutableMapOf = MapsKt.mutableMapOf(new Pair[]{new Pair(str, str2)});
        if (roomIds == null || roomIds.size() <= 0) {
            return false;
        }
        XesLog.it(TAG, "发送信令消息>>>roomIds=" + GsonUtil.getInstance().objToJson(roomIds) + ",content=" + GsonUtil.getInstance().objToJson(mutableMapOf) + ",msgPriority" + jArr);
        RoomChatManager roomManager = this.mChatClient.getRoomManager();
        String str3 = roomIds.get(0);
        if (jArr == null) {
            jArr = new long[0];
        }
        if (roomManager.setRoomData(str3, mutableMapOf, jArr) != 0) {
            z = false;
        }
        return z;
    }

    public final boolean sendNoticeMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        IrcInitInfo ircInitInfo = this.mIrcInitInfo;
        List<String> roomIds = ircInitInfo == null ? null : ircInitInfo.getRoomIds();
        if (TextUtils.isEmpty(str) || roomIds == null || roomIds.size() <= 0) {
            return false;
        }
        return sendMessage$default(this, roomIds, str, 1, (long[]) null, 8, (Object) null);
    }

    static /* synthetic */ boolean sendMessage$default(IrcEngine ircEngine, List list, String str, int i, long[] jArr, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            jArr = null;
        }
        return ircEngine.sendMessage(list, str, i, jArr);
    }

    private final boolean sendMessage(List<String> list, String str, int i, long[] jArr) {
        XesLog.it(TAG, "发送群聊消息>>>roomIds=" + GsonUtil.getInstance().objToJson(list) + ",content=" + str + ",msgPriority" + i);
        RoomChatManager roomManager = this.mChatClient.getRoomManager();
        if (jArr == null) {
            jArr = new long[0];
        }
        if (roomManager.sendRoomMessage(list, str, i, jArr) == 0) {
            return true;
        }
        return false;
    }

    public final void setIrcDispatch(Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.mIrcDispatch = function2;
    }

    public final void setIrcMsgSendResult(Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.mIrcMsgSendResult = function2;
    }

    public final void setIrcKVSendResult(Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.mIrcKVSendResult = function2;
    }

    public final void release() {
        boolean z = true;
        XesLog.dt(TAG, "release");
        this.mIsFirstLogin = true;
        List<String> list = null;
        this.mIrcDispatch = null;
        this.mIrcMsgSendResult = null;
        this.mIrcKVSendResult = null;
        IrcInitInfo ircInitInfo = this.mIrcInitInfo;
        if (ircInitInfo != null) {
            List<String> roomIds = ircInitInfo.getRoomIds();
            Collection collection = roomIds;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (z) {
                list = roomIds;
            }
            if (list != null) {
                this.mChatClient.getRoomManager().leaveChatRooms(list);
            }
        }
        this.mChatClient.logout("destory");
        this.mChatClient.unInit();
        this.mChatClient.getRoomManager().removeListener(this.mIrcRoomChatListener);
        this.mChatClient.removeListener(this.mIrcChatClientListener);
    }
}
