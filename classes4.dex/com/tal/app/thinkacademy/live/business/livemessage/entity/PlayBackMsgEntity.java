package com.tal.app.thinkacademy.live.business.livemessage.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgEntity;", "", "text", "", "ts", "", "sender", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getSender", "()Ljava/lang/String;", "getText", "getTs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgEntity;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackMsgEntity.kt */
public final class PlayBackMsgEntity {
    private final String sender;
    private final String text;
    private final Long ts;

    public static /* synthetic */ PlayBackMsgEntity copy$default(PlayBackMsgEntity playBackMsgEntity, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playBackMsgEntity.text;
        }
        if ((i & 2) != 0) {
            l = playBackMsgEntity.ts;
        }
        if ((i & 4) != 0) {
            str2 = playBackMsgEntity.sender;
        }
        return playBackMsgEntity.copy(str, l, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final Long component2() {
        return this.ts;
    }

    public final String component3() {
        return this.sender;
    }

    public final PlayBackMsgEntity copy(String str, Long l, String str2) {
        return new PlayBackMsgEntity(str, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayBackMsgEntity)) {
            return false;
        }
        PlayBackMsgEntity playBackMsgEntity = (PlayBackMsgEntity) obj;
        return Intrinsics.areEqual(this.text, playBackMsgEntity.text) && Intrinsics.areEqual(this.ts, playBackMsgEntity.ts) && Intrinsics.areEqual(this.sender, playBackMsgEntity.sender);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.ts;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.sender;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PlayBackMsgEntity(text=" + this.text + ", ts=" + this.ts + ", sender=" + this.sender + ')';
    }

    public PlayBackMsgEntity(String str, Long l, String str2) {
        this.text = str;
        this.ts = l;
        this.sender = str2;
    }

    public final String getText() {
        return this.text;
    }

    public final Long getTs() {
        return this.ts;
    }

    public final String getSender() {
        return this.sender;
    }
}
