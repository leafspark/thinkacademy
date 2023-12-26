package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "Ljava/io/Serializable;", "rightRate", "", "startTime", "interactStatus", "studentInteractStatus", "isAnswer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInteractStatus", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "getRightRate", "getStartTime", "getStudentInteractStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatus.kt */
public final class GameStatus implements Serializable {
    private final String interactStatus;
    private String isAnswer;
    private final String rightRate;
    private final String startTime;
    private final String studentInteractStatus;

    public static /* synthetic */ GameStatus copy$default(GameStatus gameStatus, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameStatus.rightRate;
        }
        if ((i & 2) != 0) {
            str2 = gameStatus.startTime;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = gameStatus.interactStatus;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = gameStatus.studentInteractStatus;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = gameStatus.isAnswer;
        }
        return gameStatus.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.rightRate;
    }

    public final String component2() {
        return this.startTime;
    }

    public final String component3() {
        return this.interactStatus;
    }

    public final String component4() {
        return this.studentInteractStatus;
    }

    public final String component5() {
        return this.isAnswer;
    }

    public final GameStatus copy(String str, String str2, String str3, String str4, String str5) {
        return new GameStatus(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameStatus)) {
            return false;
        }
        GameStatus gameStatus = (GameStatus) obj;
        return Intrinsics.areEqual(this.rightRate, gameStatus.rightRate) && Intrinsics.areEqual(this.startTime, gameStatus.startTime) && Intrinsics.areEqual(this.interactStatus, gameStatus.interactStatus) && Intrinsics.areEqual(this.studentInteractStatus, gameStatus.studentInteractStatus) && Intrinsics.areEqual(this.isAnswer, gameStatus.isAnswer);
    }

    public int hashCode() {
        String str = this.rightRate;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.startTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.interactStatus;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.studentInteractStatus;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.isAnswer;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "GameStatus(rightRate=" + this.rightRate + ", startTime=" + this.startTime + ", interactStatus=" + this.interactStatus + ", studentInteractStatus=" + this.studentInteractStatus + ", isAnswer=" + this.isAnswer + ')';
    }

    public GameStatus(String str, String str2, String str3, String str4, String str5) {
        this.rightRate = str;
        this.startTime = str2;
        this.interactStatus = str3;
        this.studentInteractStatus = str4;
        this.isAnswer = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GameStatus(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? "2" : str5);
    }

    public final String getRightRate() {
        return this.rightRate;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getInteractStatus() {
        return this.interactStatus;
    }

    public final String getStudentInteractStatus() {
        return this.studentInteractStatus;
    }

    public final String isAnswer() {
        return this.isAnswer;
    }

    public final void setAnswer(String str) {
        this.isAnswer = str;
    }
}
