package io.ktor.http.content;

import io.ktor.http.DateUtilsKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0014\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aJ\u0014\u0010\u001b\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001d0\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/ktor/http/content/LastModifiedVersion;", "Lio/ktor/http/content/Version;", "lastModified", "Lio/ktor/util/date/GMTDate;", "(Lio/ktor/util/date/GMTDate;)V", "getLastModified", "()Lio/ktor/util/date/GMTDate;", "truncatedModificationDate", "appendHeadersTo", "", "builder", "Lio/ktor/http/HeadersBuilder;", "check", "Lio/ktor/http/content/VersionCheckResult;", "requestHeaders", "Lio/ktor/http/Headers;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "ifModifiedSince", "dates", "", "ifUnmodifiedSince", "toString", "", "parseDates", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Versions.kt */
public final class LastModifiedVersion implements Version {
    private final GMTDate lastModified;
    private final GMTDate truncatedModificationDate;

    public static /* synthetic */ LastModifiedVersion copy$default(LastModifiedVersion lastModifiedVersion, GMTDate gMTDate, int i, Object obj) {
        if ((i & 1) != 0) {
            gMTDate = lastModifiedVersion.lastModified;
        }
        return lastModifiedVersion.copy(gMTDate);
    }

    public final GMTDate component1() {
        return this.lastModified;
    }

    public final LastModifiedVersion copy(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "lastModified");
        return new LastModifiedVersion(gMTDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LastModifiedVersion) && Intrinsics.areEqual(this.lastModified, ((LastModifiedVersion) obj).lastModified);
    }

    public int hashCode() {
        return this.lastModified.hashCode();
    }

    public String toString() {
        return "LastModifiedVersion(lastModified=" + this.lastModified + ')';
    }

    public LastModifiedVersion(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "lastModified");
        this.lastModified = gMTDate;
        this.truncatedModificationDate = DateKt.truncateToSeconds(gMTDate);
    }

    public final GMTDate getLastModified() {
        return this.lastModified;
    }

    public VersionCheckResult check(Headers headers) {
        List<GMTDate> parseDates;
        List<GMTDate> parseDates2;
        Intrinsics.checkNotNullParameter(headers, "requestHeaders");
        List<String> all = headers.getAll(HttpHeaders.INSTANCE.getIfModifiedSince());
        if (all != null && (parseDates2 = parseDates(all)) != null && !ifModifiedSince(parseDates2)) {
            return VersionCheckResult.NOT_MODIFIED;
        }
        List<String> all2 = headers.getAll(HttpHeaders.INSTANCE.getIfUnmodifiedSince());
        if (all2 == null || (parseDates = parseDates(all2)) == null || ifUnmodifiedSince(parseDates)) {
            return VersionCheckResult.OK;
        }
        return VersionCheckResult.PRECONDITION_FAILED;
    }

    public final boolean ifModifiedSince(List<GMTDate> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "dates");
        Iterable<GMTDate> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (GMTDate compareTo : iterable) {
                if (this.truncatedModificationDate.compareTo(compareTo) > 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean ifUnmodifiedSince(List<GMTDate> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "dates");
        Iterable<GMTDate> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (GMTDate compareTo : iterable) {
                if (this.truncatedModificationDate.compareTo(compareTo) <= 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    public void appendHeadersTo(HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "builder");
        headersBuilder.set(HttpHeaders.INSTANCE.getLastModified(), DateUtilsKt.toHttpDate(this.lastModified));
    }

    private final List<GMTDate> parseDates(List<String> list) {
        GMTDate gMTDate;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!StringsKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (String fromHttpToGmtDate : (List) arrayList) {
            try {
                gMTDate = DateUtilsKt.fromHttpToGmtDate(fromHttpToGmtDate);
            } catch (Throwable unused) {
                gMTDate = null;
            }
            if (gMTDate != null) {
                arrayList2.add(gMTDate);
            }
        }
        List<GMTDate> list2 = (List) arrayList2;
        if (!list2.isEmpty()) {
            return list2;
        }
        return null;
    }
}
