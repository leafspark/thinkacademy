package com.tal.app.thinkacademy.live.business.redpackagerain.bean;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainGameStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "GAME_STATUS_UN_KNOW", "GAME_STATUS_FAILED", "GAME_STATUS_SUCCESS", "GAME_STATUS_END", "GAME_STATUS_PLAYING", "GAME_STATUS_START_LOAD", "GAME_STATUS_TIME_OUT", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainGameStatus.kt */
public enum RedPackageRainGameStatus {
    GAME_STATUS_UN_KNOW(-1),
    GAME_STATUS_FAILED(0),
    GAME_STATUS_SUCCESS(1),
    GAME_STATUS_END(2),
    GAME_STATUS_PLAYING(3),
    GAME_STATUS_START_LOAD(4),
    GAME_STATUS_TIME_OUT(5);
    
    private final int status;

    private RedPackageRainGameStatus(int i) {
        this.status = i;
    }

    public final int getStatus() {
        return this.status;
    }
}
