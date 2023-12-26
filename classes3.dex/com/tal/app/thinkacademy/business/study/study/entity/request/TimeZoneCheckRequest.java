package com.tal.app.thinkacademy.business.study.study.entity.request;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequest;", "", "data", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequestData;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequestData;)V", "getData", "()Lcom/tal/app/thinkacademy/business/study/study/entity/request/TimeZoneCheckRequestData;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneCheckRequest.kt */
public final class TimeZoneCheckRequest {
    private TimeZoneCheckRequestData data;

    public static /* synthetic */ TimeZoneCheckRequest copy$default(TimeZoneCheckRequest timeZoneCheckRequest, TimeZoneCheckRequestData timeZoneCheckRequestData, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZoneCheckRequestData = timeZoneCheckRequest.data;
        }
        return timeZoneCheckRequest.copy(timeZoneCheckRequestData);
    }

    public final TimeZoneCheckRequestData component1() {
        return this.data;
    }

    public final TimeZoneCheckRequest copy(TimeZoneCheckRequestData timeZoneCheckRequestData) {
        Intrinsics.checkNotNullParameter(timeZoneCheckRequestData, DbParams.KEY_DATA);
        return new TimeZoneCheckRequest(timeZoneCheckRequestData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TimeZoneCheckRequest) && Intrinsics.areEqual((Object) this.data, (Object) ((TimeZoneCheckRequest) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "TimeZoneCheckRequest(data=" + this.data + ')';
    }

    public TimeZoneCheckRequest(TimeZoneCheckRequestData timeZoneCheckRequestData) {
        Intrinsics.checkNotNullParameter(timeZoneCheckRequestData, DbParams.KEY_DATA);
        this.data = timeZoneCheckRequestData;
    }

    public final TimeZoneCheckRequestData getData() {
        return this.data;
    }

    public final void setData(TimeZoneCheckRequestData timeZoneCheckRequestData) {
        Intrinsics.checkNotNullParameter(timeZoneCheckRequestData, "<set-?>");
        this.data = timeZoneCheckRequestData;
    }
}
