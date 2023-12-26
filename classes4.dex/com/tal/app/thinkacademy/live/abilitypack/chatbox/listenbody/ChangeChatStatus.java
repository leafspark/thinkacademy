package com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChangeChatStatus;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "isOpenChat", "", "text", "", "(ZLjava/lang/String;)V", "()Z", "setOpenChat", "(Z)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxListenerBody.kt */
public final class ChangeChatStatus extends ChatBoxListenerBody {
    private boolean isOpenChat;
    private String text;

    public ChangeChatStatus(boolean z, String str) {
        super((DefaultConstructorMarker) null);
        this.isOpenChat = z;
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isOpenChat() {
        return this.isOpenChat;
    }

    public final void setOpenChat(boolean z) {
        this.isOpenChat = z;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
