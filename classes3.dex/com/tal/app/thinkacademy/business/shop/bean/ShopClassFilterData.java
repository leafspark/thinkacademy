package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "", "()V", "day", "", "", "getDay", "()Ljava/util/List;", "setDay", "(Ljava/util/List;)V", "teacher", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "getTeacher", "setTeacher", "time", "getTime", "setTime", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassData.kt */
public final class ShopClassFilterData {
    private List<String> day;
    private List<ShopClassTeacherData> teacher;
    private List<String> time;

    public final List<String> getDay() {
        return this.day;
    }

    public final void setDay(List<String> list) {
        this.day = list;
    }

    public final List<String> getTime() {
        return this.time;
    }

    public final void setTime(List<String> list) {
        this.time = list;
    }

    public final List<ShopClassTeacherData> getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(List<ShopClassTeacherData> list) {
        this.teacher = list;
    }
}
