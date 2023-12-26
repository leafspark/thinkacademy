package com.tal.app.thinkacademy.lib.player.ijkplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo;", "", "()V", "mErrorCode", "", "getMErrorCode", "()I", "setMErrorCode", "(I)V", "mErrorMsg", "", "getMErrorMsg", "()Ljava/lang/String;", "setMErrorMsg", "(Ljava/lang/String;)V", "mPlayerErrorCode", "getMPlayerErrorCode", "setMPlayerErrorCode", "Companion", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaErrorInfo.kt */
public final class MediaErrorInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PLAY_COMPLETE = 0;
    public static final int PSChannelNotExist = 7;
    public static final int PSDispatchFailed = -102;
    public static final int PSPlayerError = -100;
    public static final int PSServer403 = -103;
    private int mErrorCode;
    private String mErrorMsg;
    private int mPlayerErrorCode;

    public final int getMErrorCode() {
        return this.mErrorCode;
    }

    public final void setMErrorCode(int i) {
        this.mErrorCode = i;
    }

    public final int getMPlayerErrorCode() {
        return this.mPlayerErrorCode;
    }

    public final void setMPlayerErrorCode(int i) {
        this.mPlayerErrorCode = i;
    }

    public final String getMErrorMsg() {
        return this.mErrorMsg;
    }

    public final void setMErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo$Companion;", "", "()V", "PLAY_COMPLETE", "", "PSChannelNotExist", "PSDispatchFailed", "PSPlayerError", "PSServer403", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MediaErrorInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
