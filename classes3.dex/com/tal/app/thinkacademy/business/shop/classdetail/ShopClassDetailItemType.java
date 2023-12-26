package com.tal.app.thinkacademy.business.shop.classdetail;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailItemType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CourseTitle", "CourseCard", "CourseHighlights", "TeacherTitle", "TeacherCard", "ScheduleTitle", "ScheduleInfo", "CourseDetailTitle", "CourseDetailInfo", "StepsTitle", "StepsInfo", "ScheduleMore", "Admission", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailItemType.kt */
public enum ShopClassDetailItemType {
    CourseTitle(0),
    CourseCard(1),
    CourseHighlights(2),
    TeacherTitle(3),
    TeacherCard(4),
    ScheduleTitle(5),
    ScheduleInfo(6),
    CourseDetailTitle(7),
    CourseDetailInfo(8),
    StepsTitle(9),
    StepsInfo(10),
    ScheduleMore(11),
    Admission(12);
    
    private final int type;

    private ShopClassDetailItemType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
