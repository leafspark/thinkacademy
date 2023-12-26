package io.ktor.http.content;

import io.ktor.http.ApplicationResponsePropertiesKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001eJ\u0014\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000\u001eJ\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006#"}, d2 = {"Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/http/content/Version;", "etag", "", "weak", "", "(Ljava/lang/String;Z)V", "getEtag", "()Ljava/lang/String;", "normalized", "getWeak", "()Z", "appendHeadersTo", "", "builder", "Lio/ktor/http/HeadersBuilder;", "check", "Lio/ktor/http/content/VersionCheckResult;", "requestHeaders", "Lio/ktor/http/Headers;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "match", "givenMatchEtags", "", "noneMatch", "givenNoneMatchEtags", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Versions.kt */
public final class EntityTagVersion implements Version {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final EntityTagVersion STAR = new EntityTagVersion("*", false);
    private final String etag;
    private final String normalized;
    private final boolean weak;

    public static /* synthetic */ EntityTagVersion copy$default(EntityTagVersion entityTagVersion, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entityTagVersion.etag;
        }
        if ((i & 2) != 0) {
            z = entityTagVersion.weak;
        }
        return entityTagVersion.copy(str, z);
    }

    public final String component1() {
        return this.etag;
    }

    public final boolean component2() {
        return this.weak;
    }

    public final EntityTagVersion copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "etag");
        return new EntityTagVersion(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntityTagVersion)) {
            return false;
        }
        EntityTagVersion entityTagVersion = (EntityTagVersion) obj;
        return Intrinsics.areEqual(this.etag, entityTagVersion.etag) && this.weak == entityTagVersion.weak;
    }

    public int hashCode() {
        int hashCode = this.etag.hashCode() * 31;
        boolean z = this.weak;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "EntityTagVersion(etag=" + this.etag + ", weak=" + this.weak + ')';
    }

    public EntityTagVersion(String str, boolean z) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "etag");
        this.etag = str;
        this.weak = z;
        if (!Intrinsics.areEqual(str, "*") && !StringsKt.startsWith$default(str, "\"", false, 2, (Object) null)) {
            str2 = HeaderValueWithParametersKt.quote(str);
        } else {
            str2 = str;
        }
        this.normalized = str2;
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = this.etag.charAt(i);
            if (Intrinsics.compare(charAt, 32) <= 0 || charAt == '\"') {
                if (!(i == 0 || i == StringsKt.getLastIndex(this.etag))) {
                    throw new IllegalArgumentException(("Character '" + charAt + "' is not allowed in entity-tag.").toString());
                }
            }
            i++;
        }
    }

    public final String getEtag() {
        return this.etag;
    }

    public final boolean getWeak() {
        return this.weak;
    }

    public VersionCheckResult check(Headers headers) {
        List<EntityTagVersion> parse;
        VersionCheckResult match;
        List<EntityTagVersion> parse2;
        VersionCheckResult noneMatch;
        Intrinsics.checkNotNullParameter(headers, "requestHeaders");
        String str = headers.get(HttpHeaders.INSTANCE.getIfNoneMatch());
        if (str != null && (parse2 = Companion.parse(str)) != null && (noneMatch = noneMatch(parse2)) != VersionCheckResult.OK) {
            return noneMatch;
        }
        String str2 = headers.get(HttpHeaders.INSTANCE.getIfMatch());
        if (str2 == null || (parse = Companion.parse(str2)) == null || (match = match(parse)) == VersionCheckResult.OK) {
            return VersionCheckResult.OK;
        }
        return match;
    }

    public final boolean match(EntityTagVersion entityTagVersion) {
        Intrinsics.checkNotNullParameter(entityTagVersion, "other");
        EntityTagVersion entityTagVersion2 = STAR;
        if (Intrinsics.areEqual(this, entityTagVersion2) || Intrinsics.areEqual(entityTagVersion, entityTagVersion2)) {
            return true;
        }
        return Intrinsics.areEqual(this.normalized, entityTagVersion.normalized);
    }

    public final VersionCheckResult noneMatch(List<EntityTagVersion> list) {
        Intrinsics.checkNotNullParameter(list, "givenNoneMatchEtags");
        if (list.contains(STAR)) {
            return VersionCheckResult.OK;
        }
        Iterable iterable = list;
        boolean z = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (match((EntityTagVersion) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            return VersionCheckResult.NOT_MODIFIED;
        }
        return VersionCheckResult.OK;
    }

    public final VersionCheckResult match(List<EntityTagVersion> list) {
        Intrinsics.checkNotNullParameter(list, "givenMatchEtags");
        if (list.isEmpty()) {
            return VersionCheckResult.OK;
        }
        if (list.contains(STAR)) {
            return VersionCheckResult.OK;
        }
        for (EntityTagVersion match : list) {
            if (match(match)) {
                return VersionCheckResult.OK;
            }
        }
        return VersionCheckResult.PRECONDITION_FAILED;
    }

    public void appendHeadersTo(HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "builder");
        ApplicationResponsePropertiesKt.etag(headersBuilder, this.normalized);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/http/content/EntityTagVersion$Companion;", "", "()V", "STAR", "Lio/ktor/http/content/EntityTagVersion;", "getSTAR", "()Lio/ktor/http/content/EntityTagVersion;", "parse", "", "headerValue", "", "parseSingle", "value", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Versions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EntityTagVersion getSTAR() {
            return EntityTagVersion.STAR;
        }

        public final List<EntityTagVersion> parse(String str) {
            Intrinsics.checkNotNullParameter(str, "headerValue");
            Iterable<HeaderValue> parseHeaderValue = HttpHeaderValueParserKt.parseHeaderValue(str);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parseHeaderValue, 10));
            for (HeaderValue headerValue : parseHeaderValue) {
                if (!(headerValue.getQuality() == 1.0d)) {
                    throw new IllegalStateException(("entity-tag quality parameter is not allowed: " + headerValue.getQuality() + '.').toString());
                } else if (headerValue.getParams().isEmpty()) {
                    arrayList.add(EntityTagVersion.Companion.parseSingle(headerValue.getValue()));
                } else {
                    throw new IllegalStateException(("entity-tag parameters are not allowed: " + headerValue.getParams() + '.').toString());
                }
            }
            return (List) arrayList;
        }

        public final EntityTagVersion parseSingle(String str) {
            boolean z;
            Intrinsics.checkNotNullParameter(str, "value");
            if (Intrinsics.areEqual(str, "*")) {
                return getSTAR();
            }
            if (StringsKt.startsWith$default(str, "W/", false, 2, (Object) null)) {
                z = true;
                str = StringsKt.drop(str, 2);
            } else {
                z = false;
            }
            if (!StringsKt.startsWith$default(str, "\"", false, 2, (Object) null)) {
                str = HeaderValueWithParametersKt.quote(str);
            }
            return new EntityTagVersion(str, z);
        }
    }
}
