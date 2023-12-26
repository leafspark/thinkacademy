package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ContactInfoType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "weChat", "whatsApp", "line", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactInformationAdapter.kt */
public enum ContactInfoType {
    weChat("weChat"),
    whatsApp("whatsApp"),
    line("line");
    
    private String typeName;

    private ContactInfoType(String str) {
        this.typeName = str;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final void setTypeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.typeName = str;
    }
}
