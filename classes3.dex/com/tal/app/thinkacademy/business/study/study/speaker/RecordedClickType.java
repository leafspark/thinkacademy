package com.tal.app.thinkacademy.business.study.study.speaker;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedClickType;", "", "type", "", "des", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDes", "()Ljava/lang/String;", "getType", "()I", "RecordedCourseType", "ExamType", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassParams.kt */
public enum RecordedClickType {
    RecordedCourseType(1, "录播课进教室"),
    ExamType(2, "考试");
    
    private final String des;
    private final int type;

    private RecordedClickType(int i, String str) {
        this.type = i;
        this.des = str;
    }

    public final String getDes() {
        return this.des;
    }

    public final int getType() {
        return this.type;
    }
}
