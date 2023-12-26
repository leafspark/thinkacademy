package com.tal.app.thinkacademy.live.business.interactivegames.bean.body;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;", "", "planId", "", "interactId", "", "rightRate", "isAnswer", "classId", "", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getClassId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInteractId", "()Ljava/lang/String;", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlanId", "getRightRate", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitGameDataBody.kt */
public final class SubmitGameDataBody {
    private final Integer classId;
    private final String interactId;
    private final Long isAnswer;
    private final Long planId;
    private final Long rightRate;

    public SubmitGameDataBody(Long l, String str, Long l2, Long l3, Integer num) {
        this.planId = l;
        this.interactId = str;
        this.rightRate = l2;
        this.isAnswer = l3;
        this.classId = num;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitGameDataBody(Long l, String str, Long l2, Long l3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str, (i & 4) != 0 ? 0L : l2, (i & 8) != 0 ? 2L : l3, num);
    }

    public final Long getRightRate() {
        return this.rightRate;
    }

    public final Long isAnswer() {
        return this.isAnswer;
    }

    public final Integer getClassId() {
        return this.classId;
    }
}
