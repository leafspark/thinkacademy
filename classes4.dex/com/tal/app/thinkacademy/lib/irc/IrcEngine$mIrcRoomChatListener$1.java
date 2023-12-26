package com.tal.app.thinkacademy.lib.irc;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal100.chatsdk.IRoomChatListener;
import com.tal100.chatsdk.PMDefs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/tal/app/thinkacademy/lib/irc/IrcEngine$mIrcRoomChatListener$1", "Lcom/tal100/chatsdk/IRoomChatListener;", "onJoinRoomResponse", "", "joinRoomResp", "Lcom/tal100/chatsdk/PMDefs$JoinRoomResp;", "onMuteRoomNotice", "muteRoomNotice", "Lcom/tal100/chatsdk/PMDefs$MuteRoomNotice;", "onSendRoomMessageResp", "resp", "Lcom/tal100/chatsdk/PMDefs$SendRoomMessageResp;", "onSetRoomDataResponse", "Lcom/tal100/chatsdk/PMDefs$SetRoomDataResp;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcEngine.kt */
public final class IrcEngine$mIrcRoomChatListener$1 extends IRoomChatListener {
    final /* synthetic */ IrcEngine this$0;

    IrcEngine$mIrcRoomChatListener$1(IrcEngine ircEngine) {
        this.this$0 = ircEngine;
    }

    public void onJoinRoomResponse(PMDefs.JoinRoomResp joinRoomResp) {
        Intrinsics.checkNotNullParameter(joinRoomResp, "joinRoomResp");
        XesLog.it("ircEngine", Intrinsics.stringPlus("irc 加入房间回调 ", GsonUtils.toJson(joinRoomResp)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sendTime", -1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("roomId", joinRoomResp.roomId);
            jSONObject.put(IrcKey.LOCAL_JOIN_ROOM, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Function2 access$getMIrcDispatch$p = this.this$0.mIrcDispatch;
        if (access$getMIrcDispatch$p != null) {
            String jSONObject3 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "data.toString()");
            access$getMIrcDispatch$p.invoke(IrcKey.LOCAL_JOIN_ROOM, jSONObject3);
        }
    }

    public void onSendRoomMessageResp(PMDefs.SendRoomMessageResp sendRoomMessageResp) {
        Intrinsics.checkNotNullParameter(sendRoomMessageResp, "resp");
        String objToJson = GsonUtil.getInstance().objToJson(sendRoomMessageResp);
        boolean z = true;
        XesLog.it("ircEngine", Intrinsics.stringPlus("发送群聊消息结果回调=", objToJson));
        Function2 access$getMIrcMsgSendResult$p = this.this$0.mIrcMsgSendResult;
        if (access$getMIrcMsgSendResult$p != null) {
            if (sendRoomMessageResp.code != 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            Intrinsics.checkNotNullExpressionValue(objToJson, "result");
            access$getMIrcMsgSendResult$p.invoke(valueOf, objToJson);
        }
    }

    public void onSetRoomDataResponse(PMDefs.SetRoomDataResp setRoomDataResp) {
        Intrinsics.checkNotNullParameter(setRoomDataResp, "resp");
        IrcEngine$mIrcRoomChatListener$1.super.onSetRoomDataResponse(setRoomDataResp);
        String objToJson = GsonUtil.getInstance().objToJson(setRoomDataResp);
        boolean z = true;
        XesLog.it("ircEngine", Intrinsics.stringPlus("发送信令消息结果回调=", objToJson));
        Function2 access$getMIrcKVSendResult$p = this.this$0.mIrcKVSendResult;
        if (access$getMIrcKVSendResult$p != null) {
            if (setRoomDataResp.code != 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            Intrinsics.checkNotNullExpressionValue(objToJson, "result");
            access$getMIrcKVSendResult$p.invoke(valueOf, objToJson);
        }
    }

    public void onMuteRoomNotice(PMDefs.MuteRoomNotice muteRoomNotice) {
        Intrinsics.checkNotNullParameter(muteRoomNotice, "muteRoomNotice");
        XesLog.dt("ircEngine", "onMuteRoomNotice from = " + muteRoomNotice.handler.nickname + " roomId = " + muteRoomNotice.roomId + " flag = " + muteRoomNotice.flag);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("sendTime", -1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("roomId", muteRoomNotice.roomId);
            jSONObject2.putOpt("flag", Integer.valueOf(muteRoomNotice.flag));
            jSONObject.putOpt(IrcKey.LOCAL_MUTE, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Function2 access$getMIrcDispatch$p = this.this$0.mIrcDispatch;
        if (access$getMIrcDispatch$p != null) {
            String jSONObject3 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "data.toString()");
            access$getMIrcDispatch$p.invoke(IrcKey.LOCAL_MUTE, jSONObject3);
        }
    }
}
