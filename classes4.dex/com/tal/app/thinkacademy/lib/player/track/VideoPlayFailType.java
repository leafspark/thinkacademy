package com.tal.app.thinkacademy.lib.player.track;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayFailType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIDEO_URL_EMPTY", "CALL_PLAY_METHOD_FAIL", "PLAY_ERROR", "PLAY_CHANNEL_NOT_EXIST", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayFailType.kt */
public enum VideoPlayFailType {
    VIDEO_URL_EMPTY("播放地址为空"),
    CALL_PLAY_METHOD_FAIL("调用播放接口失败"),
    PLAY_ERROR("播放错误"),
    PLAY_CHANNEL_NOT_EXIST("频道不存在");
    
    private final String value;

    private VideoPlayFailType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
