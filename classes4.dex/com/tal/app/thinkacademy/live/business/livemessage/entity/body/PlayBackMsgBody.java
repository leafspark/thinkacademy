package com.tal.app.thinkacademy.live.business.livemessage.entity.body;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/entity/body/PlayBackMsgBody;", "", "roomId", "", "page", "", "planId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlanId", "getRoomId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/live/business/livemessage/entity/body/PlayBackMsgBody;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackMsgBody.kt */
public final class PlayBackMsgBody {
    private final Integer page;
    private final Integer planId;
    private final String roomId;

    public static /* synthetic */ PlayBackMsgBody copy$default(PlayBackMsgBody playBackMsgBody, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playBackMsgBody.roomId;
        }
        if ((i & 2) != 0) {
            num = playBackMsgBody.page;
        }
        if ((i & 4) != 0) {
            num2 = playBackMsgBody.planId;
        }
        return playBackMsgBody.copy(str, num, num2);
    }

    public final String component1() {
        return this.roomId;
    }

    public final Integer component2() {
        return this.page;
    }

    public final Integer component3() {
        return this.planId;
    }

    public final PlayBackMsgBody copy(String str, Integer num, Integer num2) {
        return new PlayBackMsgBody(str, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayBackMsgBody)) {
            return false;
        }
        PlayBackMsgBody playBackMsgBody = (PlayBackMsgBody) obj;
        return Intrinsics.areEqual(this.roomId, playBackMsgBody.roomId) && Intrinsics.areEqual(this.page, playBackMsgBody.page) && Intrinsics.areEqual(this.planId, playBackMsgBody.planId);
    }

    public int hashCode() {
        String str = this.roomId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.page;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.planId;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PlayBackMsgBody(roomId=" + this.roomId + ", page=" + this.page + ", planId=" + this.planId + ')';
    }

    public PlayBackMsgBody(String str, Integer num, Integer num2) {
        this.roomId = str;
        this.page = num;
        this.planId = num2;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final Integer getPlanId() {
        return this.planId;
    }
}
