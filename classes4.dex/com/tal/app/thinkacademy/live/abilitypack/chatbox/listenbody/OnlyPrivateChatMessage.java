package com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/OnlyPrivateChatMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "isOnlyPrivateChat", "", "(Z)V", "()Z", "setOnlyPrivateChat", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxListenerBody.kt */
public final class OnlyPrivateChatMessage extends ChatBoxListenerBody {
    private boolean isOnlyPrivateChat;

    public OnlyPrivateChatMessage(boolean z) {
        super((DefaultConstructorMarker) null);
        this.isOnlyPrivateChat = z;
    }

    public final boolean isOnlyPrivateChat() {
        return this.isOnlyPrivateChat;
    }

    public final void setOnlyPrivateChat(boolean z) {
        this.isOnlyPrivateChat = z;
    }
}
