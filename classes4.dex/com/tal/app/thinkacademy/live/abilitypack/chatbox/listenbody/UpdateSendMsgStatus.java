package com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody;

import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/UpdateSendMsgStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "chatBoxItemBean", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "(Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;)V", "getChatBoxItemBean", "()Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "setChatBoxItemBean", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxListenerBody.kt */
public final class UpdateSendMsgStatus extends ChatBoxListenerBody {
    private ChatBoxItemBean chatBoxItemBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateSendMsgStatus(ChatBoxItemBean chatBoxItemBean2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(chatBoxItemBean2, "chatBoxItemBean");
        this.chatBoxItemBean = chatBoxItemBean2;
    }

    public final ChatBoxItemBean getChatBoxItemBean() {
        return this.chatBoxItemBean;
    }

    public final void setChatBoxItemBean(ChatBoxItemBean chatBoxItemBean2) {
        Intrinsics.checkNotNullParameter(chatBoxItemBean2, "<set-?>");
        this.chatBoxItemBean = chatBoxItemBean2;
    }
}
