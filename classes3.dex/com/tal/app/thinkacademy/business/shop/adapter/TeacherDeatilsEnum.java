package com.tal.app.thinkacademy.business.shop.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/TeacherDeatilsEnum;", "", "value", "", "typeName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "getValue", "()I", "setValue", "(I)V", "VIDEO", "TEACHINGACHIEVEMENTS", "TEACHERINTRODUCE", "CLASSLISTTITLE", "CLASSLISTITEM", "RECORDEDLESSON", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDeatilsAdapter.kt */
public enum TeacherDeatilsEnum {
    VIDEO(0, "视频"),
    TEACHINGACHIEVEMENTS(1, "教学成果"),
    TEACHERINTRODUCE(2, "老师大段介绍"),
    CLASSLISTTITLE(3, "列表标题"),
    CLASSLISTITEM(4, "列表Item"),
    RECORDEDLESSON(5, "录播课班级卡片");
    
    private String typeName;
    private int value;

    private TeacherDeatilsEnum(int i, String str) {
        this.value = i;
        this.typeName = str;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setTypeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.typeName = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
