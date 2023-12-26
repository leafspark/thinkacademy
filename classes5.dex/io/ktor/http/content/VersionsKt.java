package io.ktor.http.content;

import io.ktor.util.AttributeKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\"\u001d\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"VersionListProperty", "Lio/ktor/util/AttributeKey;", "", "Lio/ktor/http/content/Version;", "getVersionListProperty", "()Lio/ktor/util/AttributeKey;", "value", "versions", "Lio/ktor/http/content/OutgoingContent;", "getVersions", "(Lio/ktor/http/content/OutgoingContent;)Ljava/util/List;", "setVersions", "(Lio/ktor/http/content/OutgoingContent;Ljava/util/List;)V", "EntityTagVersion", "Lio/ktor/http/content/EntityTagVersion;", "spec", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Versions.kt */
public final class VersionsKt {
    private static final AttributeKey<List<Version>> VersionListProperty = new AttributeKey<>("VersionList");

    public static final AttributeKey<List<Version>> getVersionListProperty() {
        return VersionListProperty;
    }

    public static final List<Version> getVersions(OutgoingContent outgoingContent) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        List<Version> list = (List) outgoingContent.getProperty(VersionListProperty);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final void setVersions(OutgoingContent outgoingContent, List<? extends Version> list) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(list, "value");
        outgoingContent.setProperty(VersionListProperty, list);
    }

    public static final EntityTagVersion EntityTagVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "spec");
        return EntityTagVersion.Companion.parseSingle(str);
    }
}
