package com.tal.app.thinkacademy.business.study.study.speaker;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ClickType;", "", "type", "", "des", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDes", "()Ljava/lang/String;", "getType", "()I", "Common", "Homework", "PreviewQuestion", "Exam", "ParentAudit", "LessonExam", "ExamNew", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassParams.kt */
public enum ClickType {
    Common(1, "普通点击"),
    Homework(2, "作业"),
    PreviewQuestion(3, "课前测"),
    Exam(4, "考试"),
    ParentAudit(5, "家长旁听点击"),
    LessonExam(6, "课中考试"),
    ExamNew(7, "课中考试课后作答");
    
    private final String des;
    private final int type;

    private ClickType(int i, String str) {
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
