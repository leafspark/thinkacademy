package com.tal.app.thinkacademy.live.abilitypack.chatbox;

import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.irc.IrcKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxEmojiMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendMsgStatus;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.core.irc.entity.MessageInfo;
import com.tal.app.thinkacademy.live.core.irc.listener.IIrcListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel$ircListener$1", "Lcom/tal/app/thinkacademy/live/core/irc/listener/IIrcListener;", "onRoomHistoryMessage", "", "historyMessages", "", "Lcom/tal/app/thinkacademy/live/core/irc/entity/MessageInfo;", "onSendPeerMessageFailed", "errorCode", "", "errorMsg", "", "preMsgId", "", "onSendPeerMessageSuccess", "onSendRoomMessageFailed", "onSendRoomMessageSuccess", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxViewModel.kt */
public final class ChatBoxViewModel$ircListener$1 extends IIrcListener {
    final /* synthetic */ ChatBoxViewModel this$0;

    ChatBoxViewModel$ircListener$1(ChatBoxViewModel chatBoxViewModel) {
        this.this$0 = chatBoxViewModel;
    }

    public void onSendRoomMessageSuccess(long j) {
        if (this.this$0.mSendingMessages != null && this.this$0.mSendingMessages.containsKey(Long.valueOf(j))) {
            ChatBoxItemBean chatBoxItemBean = (ChatBoxItemBean) this.this$0.mSendingMessages.get(Long.valueOf(j));
            if (chatBoxItemBean != null) {
                chatBoxItemBean.setSendStatus(ChatBoxSendMsgStatus.SUCCESS.name());
            }
            this.this$0.mSendingMessages.remove(Long.valueOf(j));
            XesLog.i(ChatBoxViewModel.TAG, Intrinsics.stringPlus("群聊消息发送成功>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
            this.this$0.updateSendMsgStatus(chatBoxItemBean);
        }
    }

    public void onSendRoomMessageFailed(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        if (this.this$0.mSendingMessages != null && this.this$0.mSendingMessages.containsKey(Long.valueOf(j))) {
            ChatBoxItemBean chatBoxItemBean = (ChatBoxItemBean) this.this$0.mSendingMessages.get(Long.valueOf(j));
            if (chatBoxItemBean != null) {
                chatBoxItemBean.setSendStatus(ChatBoxSendMsgStatus.FAIL.name());
            }
            this.this$0.mSendingMessages.remove(Long.valueOf(j));
            XesLog.i(ChatBoxViewModel.TAG, "群聊消息发送失败>>>errorCode=" + i + "，errorMsg=" + str + "，bean=" + GsonUtil.getInstance().objToJson(chatBoxItemBean));
            this.this$0.updateSendMsgStatus(chatBoxItemBean);
        }
    }

    public void onSendPeerMessageSuccess(long j) {
        if (this.this$0.mSendingPrivateMessages != null && this.this$0.mSendingPrivateMessages.containsKey(Long.valueOf(j))) {
            ChatBoxItemBean chatBoxItemBean = (ChatBoxItemBean) this.this$0.mSendingPrivateMessages.get(Long.valueOf(j));
            if (chatBoxItemBean != null) {
                chatBoxItemBean.setSendStatus(ChatBoxSendMsgStatus.SUCCESS.name());
            }
            this.this$0.mSendingPrivateMessages.remove(Long.valueOf(j));
            XesLog.i(ChatBoxViewModel.TAG, Intrinsics.stringPlus("私聊消息发送成功>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
            this.this$0.updateSendPrivateMsgStatus(chatBoxItemBean);
        }
    }

    public void onSendPeerMessageFailed(int i, String str, long j) {
        if (this.this$0.mSendingPrivateMessages != null && this.this$0.mSendingPrivateMessages.containsKey(Long.valueOf(j))) {
            ChatBoxItemBean chatBoxItemBean = (ChatBoxItemBean) this.this$0.mSendingPrivateMessages.get(Long.valueOf(j));
            if (chatBoxItemBean != null) {
                chatBoxItemBean.setSendStatus(ChatBoxSendMsgStatus.FAIL.name());
            }
            this.this$0.mSendingPrivateMessages.remove(Long.valueOf(j));
            XesLog.i(ChatBoxViewModel.TAG, "私聊消息发送失败>>>errorCode=" + i + "，errorMsg=" + str + "，bean=" + GsonUtil.getInstance().objToJson(chatBoxItemBean));
            this.this$0.updateSendPrivateMsgStatus(chatBoxItemBean);
        }
    }

    public void onRoomHistoryMessage(List<? extends MessageInfo> list) {
        Intrinsics.checkNotNullParameter(list, "historyMessages");
        if (!list.isEmpty()) {
            List arrayList = new ArrayList();
            for (MessageInfo next : list) {
                if (next != null) {
                    if (Intrinsics.areEqual(IrcKey.LOCAL_CHAT_MSG, next.getIrcType())) {
                        ChatBoxViewModel chatBoxViewModel = this.this$0;
                        String msg = next.getMsg();
                        Intrinsics.checkNotNullExpressionValue(msg, "messageInfo.msg");
                        ChatBoxTextMsgBean access$parseRoomTextMessage = chatBoxViewModel.parseRoomTextMessage(msg);
                        if (access$parseRoomTextMessage != null) {
                            arrayList.add(access$parseRoomTextMessage);
                        }
                    } else if (Intrinsics.areEqual(DataBusKey.SEND_EMOJI, next.getIrcType()) || Intrinsics.areEqual("animation_emoji", next.getIrcType())) {
                        ChatBoxViewModel chatBoxViewModel2 = this.this$0;
                        String msg2 = next.getMsg();
                        Intrinsics.checkNotNullExpressionValue(msg2, "messageInfo.msg");
                        ChatBoxEmojiMsgBean access$parseRoomEmojiMessage = chatBoxViewModel2.parseRoomEmojiMessage(msg2);
                        if (access$parseRoomEmojiMessage != null) {
                            arrayList.add(access$parseRoomEmojiMessage);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.this$0.addData((List<? extends ChatBoxItemBean>) arrayList, false);
                this.this$0.sendHistoryMessagesEvent(arrayList);
            }
        }
    }
}
