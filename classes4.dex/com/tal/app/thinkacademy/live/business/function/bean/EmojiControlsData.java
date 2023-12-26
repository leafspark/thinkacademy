package com.tal.app.thinkacademy.live.business.function.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/bean/EmojiControlsData;", "", "forbiddenStudentEmoji", "Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;", "index", "", "sendTime", "", "(Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;Ljava/lang/String;Ljava/lang/Long;)V", "getForbiddenStudentEmoji", "()Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;", "setForbiddenStudentEmoji", "(Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;)V", "getIndex", "()Ljava/lang/String;", "setIndex", "(Ljava/lang/String;)V", "getSendTime", "()Ljava/lang/Long;", "setSendTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Lcom/tal/app/thinkacademy/live/business/function/bean/ForbiddenStudentEmoji;Ljava/lang/String;Ljava/lang/Long;)Lcom/tal/app/thinkacademy/live/business/function/bean/EmojiControlsData;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiControlsData.kt */
public final class EmojiControlsData {
    @SerializedName("forbidden_student_emoji")
    private ForbiddenStudentEmoji forbiddenStudentEmoji;
    private String index;
    private Long sendTime;

    public static /* synthetic */ EmojiControlsData copy$default(EmojiControlsData emojiControlsData, ForbiddenStudentEmoji forbiddenStudentEmoji2, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            forbiddenStudentEmoji2 = emojiControlsData.forbiddenStudentEmoji;
        }
        if ((i & 2) != 0) {
            str = emojiControlsData.index;
        }
        if ((i & 4) != 0) {
            l = emojiControlsData.sendTime;
        }
        return emojiControlsData.copy(forbiddenStudentEmoji2, str, l);
    }

    public final ForbiddenStudentEmoji component1() {
        return this.forbiddenStudentEmoji;
    }

    public final String component2() {
        return this.index;
    }

    public final Long component3() {
        return this.sendTime;
    }

    public final EmojiControlsData copy(ForbiddenStudentEmoji forbiddenStudentEmoji2, String str, Long l) {
        return new EmojiControlsData(forbiddenStudentEmoji2, str, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmojiControlsData)) {
            return false;
        }
        EmojiControlsData emojiControlsData = (EmojiControlsData) obj;
        return Intrinsics.areEqual(this.forbiddenStudentEmoji, emojiControlsData.forbiddenStudentEmoji) && Intrinsics.areEqual(this.index, emojiControlsData.index) && Intrinsics.areEqual(this.sendTime, emojiControlsData.sendTime);
    }

    public int hashCode() {
        ForbiddenStudentEmoji forbiddenStudentEmoji2 = this.forbiddenStudentEmoji;
        int i = 0;
        int hashCode = (forbiddenStudentEmoji2 == null ? 0 : forbiddenStudentEmoji2.hashCode()) * 31;
        String str = this.index;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.sendTime;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "EmojiControlsData(forbiddenStudentEmoji=" + this.forbiddenStudentEmoji + ", index=" + this.index + ", sendTime=" + this.sendTime + ')';
    }

    public EmojiControlsData(ForbiddenStudentEmoji forbiddenStudentEmoji2, String str, Long l) {
        this.forbiddenStudentEmoji = forbiddenStudentEmoji2;
        this.index = str;
        this.sendTime = l;
    }

    public final ForbiddenStudentEmoji getForbiddenStudentEmoji() {
        return this.forbiddenStudentEmoji;
    }

    public final void setForbiddenStudentEmoji(ForbiddenStudentEmoji forbiddenStudentEmoji2) {
        this.forbiddenStudentEmoji = forbiddenStudentEmoji2;
    }

    public final String getIndex() {
        return this.index;
    }

    public final void setIndex(String str) {
        this.index = str;
    }

    public final Long getSendTime() {
        return this.sendTime;
    }

    public final void setSendTime(Long l) {
        this.sendTime = l;
    }
}
