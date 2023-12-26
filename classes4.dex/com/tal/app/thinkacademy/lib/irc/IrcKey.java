package com.tal.app.thinkacademy.lib.irc;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/irc/IrcKey;", "", "()V", "LEVEL_CHAT_MSG", "", "LOCAL_CHAT_MSG", "LOCAL_JOIN_ROOM", "LOCAL_MUTE", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrcEngine.kt */
public final class IrcKey {
    public static final IrcKey INSTANCE = new IrcKey();
    public static final String LEVEL_CHAT_MSG = "level_chat_msg";
    public static final String LOCAL_CHAT_MSG = "local_chat_msg";
    public static final String LOCAL_JOIN_ROOM = "local_joinRoom";
    public static final String LOCAL_MUTE = "local_mute";

    private IrcKey() {
    }
}
