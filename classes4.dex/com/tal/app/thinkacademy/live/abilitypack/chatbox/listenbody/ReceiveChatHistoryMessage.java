package com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody;

import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ReceiveChatHistoryMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "chatBoxItemBeans", "", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "(Ljava/util/List;)V", "getChatBoxItemBeans", "()Ljava/util/List;", "setChatBoxItemBeans", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxListenerBody.kt */
public final class ReceiveChatHistoryMessage extends ChatBoxListenerBody {
    private List<? extends ChatBoxItemBean> chatBoxItemBeans;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveChatHistoryMessage(List<? extends ChatBoxItemBean> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "chatBoxItemBeans");
        this.chatBoxItemBeans = list;
    }

    public final List<ChatBoxItemBean> getChatBoxItemBeans() {
        return this.chatBoxItemBeans;
    }

    public final void setChatBoxItemBeans(List<? extends ChatBoxItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.chatBoxItemBeans = list;
    }
}
