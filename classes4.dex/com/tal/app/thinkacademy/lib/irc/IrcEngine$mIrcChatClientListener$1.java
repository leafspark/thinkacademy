package com.tal.app.thinkacademy.lib.irc;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal100.chatsdk.IChatClientListener;
import com.tal100.chatsdk.PMDefs;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcChatClientListener$1", "Lcom/tal100/chatsdk/IChatClientListener;", "onKickoutNotice", "", "kickoutNotice", "Lcom/tal100/chatsdk/PMDefs$KickoutNotice;", "onLoginResponse", "loginResp", "Lcom/tal100/chatsdk/PMDefs$LoginResp;", "onLogoutNotice", "logoutNotice", "Lcom/tal100/chatsdk/PMDefs$LogoutNotice;", "onNetStatusChanged", "netStatusResp", "Lcom/tal100/chatsdk/PMDefs$NetStatusResp;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcEngine.kt */
public final class IrcEngine$mIrcChatClientListener$1 extends IChatClientListener {
    final /* synthetic */ IrcEngine this$0;

    IrcEngine$mIrcChatClientListener$1(IrcEngine ircEngine) {
        this.this$0 = ircEngine;
    }

    public void onLoginResponse(PMDefs.LoginResp loginResp) {
        int i;
        Intrinsics.checkNotNullParameter(loginResp, "loginResp");
        XesLog.dt("ircEngine", "onLoginResponse : info = " + loginResp.info + "  code = " + loginResp.code);
        if (loginResp.code == 0 && this.this$0.mIsFirstLogin) {
            IrcInitInfo access$getMIrcInitInfo$p = this.this$0.mIrcInitInfo;
            List<String> roomIds = access$getMIrcInitInfo$p == null ? null : access$getMIrcInitInfo$p.getRoomIds();
            Collection collection = roomIds;
            if (collection == null || collection.isEmpty()) {
                XesLog.dt("ircEngine", "roomids is empty");
                return;
            }
            IrcInitInfo access$getMIrcInitInfo$p2 = this.this$0.mIrcInitInfo;
            if (access$getMIrcInitInfo$p2 != null && access$getMIrcInitInfo$p2.isCallAllUser()) {
                i = this.this$0.mChatClient.getRoomManager().joinChatRooms(roomIds);
            } else {
                i = this.this$0.mChatClient.getRoomManager().joinChatRooms(roomIds, 2);
            }
            this.this$0.mIsFirstLogin = false;
            XesLog.dt("ircEngine", Intrinsics.stringPlus("onLoginResponse joinroom code = ", Integer.valueOf(i)));
        }
    }

    public void onLogoutNotice(PMDefs.LogoutNotice logoutNotice) {
        Intrinsics.checkNotNullParameter(logoutNotice, "logoutNotice");
        XesLog.dt("ircEngine", "onLogoutNotice");
    }

    public void onKickoutNotice(PMDefs.KickoutNotice kickoutNotice) {
        Intrinsics.checkNotNullParameter(kickoutNotice, "kickoutNotice");
        XesLog.dt("ircEngine", "onKickoutNotice : code = " + kickoutNotice.code + " info = " + kickoutNotice.info);
    }

    public void onNetStatusChanged(PMDefs.NetStatusResp netStatusResp) {
        Intrinsics.checkNotNullParameter(netStatusResp, "netStatusResp");
        XesLog.dt("ircEngine", Intrinsics.stringPlus("onNetStatusChanged : status = ", Integer.valueOf(netStatusResp.netStatus)));
    }
}
