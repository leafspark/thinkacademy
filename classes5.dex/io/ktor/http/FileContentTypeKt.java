package io.ktor.http;

import io.ktor.http.ContentType;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002\u001a\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003*\u00020\u0004\u001a\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002\u001a<\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0001\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u00190\u0018H\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\f\u0010\u001b\u001a\u00020\u0004*\u00020\u0002H\u0000\"-\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00018BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"-\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00018BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u001c"}, d2 = {"contentTypesByExtensions", "", "", "", "Lio/ktor/http/ContentType;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions$delegate", "Lkotlin/Lazy;", "extensionsByContentType", "getExtensionsByContentType", "extensionsByContentType$delegate", "defaultForFileExtension", "Lio/ktor/http/ContentType$Companion;", "extension", "defaultForFilePath", "path", "fileExtensions", "fromFileExtension", "ext", "fromFilePath", "groupByPairs", "A", "B", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "selectDefault", "toContentType", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileContentType.kt */
public final class FileContentTypeKt {
    private static final Lazy contentTypesByExtensions$delegate = LazyKt.lazy(FileContentTypeKt$contentTypesByExtensions$2.INSTANCE);
    private static final Lazy extensionsByContentType$delegate = LazyKt.lazy(FileContentTypeKt$extensionsByContentType$2.INSTANCE);

    public static final ContentType defaultForFileExtension(ContentType.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "extension");
        return selectDefault(fromFileExtension(ContentType.Companion, str));
    }

    public static final ContentType defaultForFilePath(ContentType.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "path");
        return selectDefault(fromFilePath(ContentType.Companion, str));
    }

    public static final List<ContentType> fromFilePath(ContentType.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "path");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, '.', StringsKt.lastIndexOfAny$default(charSequence, CharsetKt.toCharArray("/\\"), 0, false, 6, (Object) null) + 1, false, 4, (Object) null);
        if (indexOf$default == -1) {
            return CollectionsKt.emptyList();
        }
        String substring = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return fromFileExtension(companion, substring);
    }

    public static final List<ContentType> fromFileExtension(ContentType.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "ext");
        String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(StringsKt.removePrefix(str, (CharSequence) "."));
        while (true) {
            if (!(lowerCasePreservingASCIIRules.length() > 0)) {
                return CollectionsKt.emptyList();
            }
            List<ContentType> list = getContentTypesByExtensions().get(lowerCasePreservingASCIIRules);
            if (list != null) {
                return list;
            }
            lowerCasePreservingASCIIRules = StringsKt.substringAfter(lowerCasePreservingASCIIRules, ".", "");
        }
    }

    public static final List<String> fileExtensions(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        List<String> list = getExtensionsByContentType().get(contentType);
        if (list != null) {
            return list;
        }
        List<String> list2 = getExtensionsByContentType().get(contentType.withoutParameters());
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final Map<String, List<ContentType>> getContentTypesByExtensions() {
        return (Map) contentTypesByExtensions$delegate.getValue();
    }

    private static final Map<ContentType, List<String>> getExtensionsByContentType() {
        return (Map) extensionsByContentType$delegate.getValue();
    }

    public static final ContentType selectDefault(List<ContentType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ContentType contentType = (ContentType) CollectionsKt.firstOrNull(list);
        if (contentType == null) {
            contentType = ContentType.Application.INSTANCE.getOctetStream();
        }
        return (!Intrinsics.areEqual(contentType.getContentType(), "text") || ContentTypesKt.charset(contentType) != null) ? contentType : ContentTypesKt.withCharset(contentType, Charsets.UTF_8);
    }

    public static final ContentType toContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return ContentType.Companion.parse(str);
        } catch (Throwable th) {
            throw new IllegalArgumentException("Failed to parse " + str, th);
        }
    }

    public static final <A, B> Map<A, List<B>> groupByPairs(Sequence<? extends Pair<? extends A, ? extends B>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
            Object first = ((Pair) next).getFirst();
            Object obj = linkedHashMap.get(first);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(first, obj);
            }
            ((List) obj).add(next);
        }
        Map<A, List<B>> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable<Pair> iterable = (Iterable) entry.getValue();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Pair second : iterable) {
                arrayList.add(second.getSecond());
            }
            linkedHashMap2.put(key, (List) arrayList);
        }
        return linkedHashMap2;
    }
}
