package io.ktor.util.date;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/BO\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010\u001e\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "seconds", "", "minutes", "hours", "dayOfWeek", "Lio/ktor/util/date/WeekDay;", "dayOfMonth", "dayOfYear", "month", "Lio/ktor/util/date/Month;", "year", "timestamp", "", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)V", "getDayOfMonth", "()I", "getDayOfWeek", "()Lio/ktor/util/date/WeekDay;", "getDayOfYear", "getHours", "getMinutes", "getMonth", "()Lio/ktor/util/date/Month;", "getSeconds", "getTimestamp", "()J", "getYear", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "", "hashCode", "toString", "", "Companion", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Date.kt */
public final class GMTDate implements Comparable<GMTDate> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final GMTDate START = DateJvmKt.GMTDate(0L);
    private final int dayOfMonth;
    private final WeekDay dayOfWeek;
    private final int dayOfYear;
    private final int hours;
    private final int minutes;
    private final Month month;
    private final int seconds;
    private final long timestamp;
    private final int year;

    public static /* synthetic */ GMTDate copy$default(GMTDate gMTDate, int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month2, int i6, long j, int i7, Object obj) {
        GMTDate gMTDate2 = gMTDate;
        int i8 = i7;
        return gMTDate.copy((i8 & 1) != 0 ? gMTDate2.seconds : i, (i8 & 2) != 0 ? gMTDate2.minutes : i2, (i8 & 4) != 0 ? gMTDate2.hours : i3, (i8 & 8) != 0 ? gMTDate2.dayOfWeek : weekDay, (i8 & 16) != 0 ? gMTDate2.dayOfMonth : i4, (i8 & 32) != 0 ? gMTDate2.dayOfYear : i5, (i8 & 64) != 0 ? gMTDate2.month : month2, (i8 & Constants.ERR_WATERMARK_ARGB) != 0 ? gMTDate2.year : i6, (i8 & 256) != 0 ? gMTDate2.timestamp : j);
    }

    public final int component1() {
        return this.seconds;
    }

    public final int component2() {
        return this.minutes;
    }

    public final int component3() {
        return this.hours;
    }

    public final WeekDay component4() {
        return this.dayOfWeek;
    }

    public final int component5() {
        return this.dayOfMonth;
    }

    public final int component6() {
        return this.dayOfYear;
    }

    public final Month component7() {
        return this.month;
    }

    public final int component8() {
        return this.year;
    }

    public final long component9() {
        return this.timestamp;
    }

    public final GMTDate copy(int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month2, int i6, long j) {
        WeekDay weekDay2 = weekDay;
        Intrinsics.checkNotNullParameter(weekDay2, "dayOfWeek");
        Month month3 = month2;
        Intrinsics.checkNotNullParameter(month3, "month");
        return new GMTDate(i, i2, i3, weekDay2, i4, i5, month3, i6, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) obj;
        return this.seconds == gMTDate.seconds && this.minutes == gMTDate.minutes && this.hours == gMTDate.hours && this.dayOfWeek == gMTDate.dayOfWeek && this.dayOfMonth == gMTDate.dayOfMonth && this.dayOfYear == gMTDate.dayOfYear && this.month == gMTDate.month && this.year == gMTDate.year && this.timestamp == gMTDate.timestamp;
    }

    public int hashCode() {
        return (((((((((((((((this.seconds * 31) + this.minutes) * 31) + this.hours) * 31) + this.dayOfWeek.hashCode()) * 31) + this.dayOfMonth) * 31) + this.dayOfYear) * 31) + this.month.hashCode()) * 31) + this.year) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.seconds + ", minutes=" + this.minutes + ", hours=" + this.hours + ", dayOfWeek=" + this.dayOfWeek + ", dayOfMonth=" + this.dayOfMonth + ", dayOfYear=" + this.dayOfYear + ", month=" + this.month + ", year=" + this.year + ", timestamp=" + this.timestamp + ')';
    }

    public GMTDate(int i, int i2, int i3, WeekDay weekDay, int i4, int i5, Month month2, int i6, long j) {
        Intrinsics.checkNotNullParameter(weekDay, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month2, "month");
        this.seconds = i;
        this.minutes = i2;
        this.hours = i3;
        this.dayOfWeek = weekDay;
        this.dayOfMonth = i4;
        this.dayOfYear = i5;
        this.month = month2;
        this.year = i6;
        this.timestamp = j;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getHours() {
        return this.hours;
    }

    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    public final Month getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int compareTo(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "other");
        return Intrinsics.compare(this.timestamp, gMTDate.timestamp);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/util/date/GMTDate$Companion;", "", "()V", "START", "Lio/ktor/util/date/GMTDate;", "getSTART", "()Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Date.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GMTDate getSTART() {
            return GMTDate.START;
        }
    }
}
