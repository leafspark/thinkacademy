package com.tal.app.thinkacademy.lib.player.track;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAYBACK", "SCREEN_SHARE", "SHOP_CLASS_DETAIL", "SHOP_TEACHER_DETAILS", "SHOP_GRADE_AGGREGATE", "LEARN_MATERIALS", "RECORDING_CLASS", "UNKNOWN", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerSceneType.kt */
public enum VideoPlayerSceneType {
    PLAYBACK("回放"),
    SCREEN_SHARE("屏幕共享"),
    SHOP_CLASS_DETAIL("商品购买详情页"),
    SHOP_TEACHER_DETAILS("老师详情页"),
    SHOP_GRADE_AGGREGATE("商品聚合详情页"),
    LEARN_MATERIALS("学习资料"),
    RECORDING_CLASS("录播课"),
    UNKNOWN("未知");
    
    private final String value;

    private VideoPlayerSceneType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
