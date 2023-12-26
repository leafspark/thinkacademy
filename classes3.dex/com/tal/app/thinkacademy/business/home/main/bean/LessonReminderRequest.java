package com.tal.app.thinkacademy.business.home.main.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderRequest;", "", "header", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderHeader;", "data", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminder;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderHeader;Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminder;)V", "getData", "()Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminder;", "getHeader", "()Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LessonReminderRequest.kt */
public final class LessonReminderRequest {
    private final LessonReminder data;
    private final LessonReminderHeader header;

    public LessonReminderRequest() {
        this((LessonReminderHeader) null, (LessonReminder) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LessonReminderRequest copy$default(LessonReminderRequest lessonReminderRequest, LessonReminderHeader lessonReminderHeader, LessonReminder lessonReminder, int i, Object obj) {
        if ((i & 1) != 0) {
            lessonReminderHeader = lessonReminderRequest.header;
        }
        if ((i & 2) != 0) {
            lessonReminder = lessonReminderRequest.data;
        }
        return lessonReminderRequest.copy(lessonReminderHeader, lessonReminder);
    }

    public final LessonReminderHeader component1() {
        return this.header;
    }

    public final LessonReminder component2() {
        return this.data;
    }

    public final LessonReminderRequest copy(LessonReminderHeader lessonReminderHeader, LessonReminder lessonReminder) {
        return new LessonReminderRequest(lessonReminderHeader, lessonReminder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LessonReminderRequest)) {
            return false;
        }
        LessonReminderRequest lessonReminderRequest = (LessonReminderRequest) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) lessonReminderRequest.header) && Intrinsics.areEqual((Object) this.data, (Object) lessonReminderRequest.data);
    }

    public int hashCode() {
        LessonReminderHeader lessonReminderHeader = this.header;
        int i = 0;
        int hashCode = (lessonReminderHeader == null ? 0 : lessonReminderHeader.hashCode()) * 31;
        LessonReminder lessonReminder = this.data;
        if (lessonReminder != null) {
            i = lessonReminder.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LessonReminderRequest(header=" + this.header + ", data=" + this.data + ')';
    }

    public LessonReminderRequest(LessonReminderHeader lessonReminderHeader, LessonReminder lessonReminder) {
        this.header = lessonReminderHeader;
        this.data = lessonReminder;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LessonReminderRequest(LessonReminderHeader lessonReminderHeader, LessonReminder lessonReminder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LessonReminderHeader((String) null, 1, (DefaultConstructorMarker) null) : lessonReminderHeader, (i & 2) != 0 ? new LessonReminder((String) null, 1, (DefaultConstructorMarker) null) : lessonReminder);
    }

    public final LessonReminderHeader getHeader() {
        return this.header;
    }

    public final LessonReminder getData() {
        return this.data;
    }
}
