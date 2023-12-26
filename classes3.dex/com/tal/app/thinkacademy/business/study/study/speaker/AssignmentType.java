package com.tal.app.thinkacademy.business.study.study.speaker;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/AssignmentType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "Hid", "UnPub", "UnSub", "Review", "Sumb", "Expired", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassParams.kt */
public enum AssignmentType {
    Hid(1),
    UnPub(2),
    UnSub(3),
    Review(4),
    Sumb(5),
    Expired(6);
    
    private final int code;

    private AssignmentType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
