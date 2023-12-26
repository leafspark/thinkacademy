package io.ktor.http;

import io.ktor.http.Parameters;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\n\u0010\u0007\u001a\u00060\bj\u0002`\t\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\n2\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0000\u001a*\u0010\u0005\u001a\u00020\u0006*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t\u001a0\u0010\u0005\u001a\u00020\u0006*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\f0\u000b2\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0000\u001a\"\u0010\r\u001a\u00020\u0002*\u00020\u00012\f\b\u0002\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"formUrlEncode", "", "Lio/ktor/http/Parameters;", "", "Lkotlin/Pair;", "formUrlEncodeTo", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/http/ParametersBuilder;", "", "", "parseUrlEncodedParameters", "defaultEncoding", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "limit", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpUrlEncoded.kt */
public final class HttpUrlEncodedKt {
    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 1000;
        }
        return parseUrlEncodedParameters(str, charset, i);
    }

    public static final Parameters parseUrlEncodedParameters(String str, Charset charset, int i) {
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "defaultEncoding");
        Iterable<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, i, 2, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str3 : split$default) {
            arrayList.add(TuplesKt.to(StringsKt.substringBefore$default(str3, "=", (String) null, 2, (Object) null), StringsKt.substringAfter(str3, "=", "")));
        }
        Iterable<Pair> iterable = (List) arrayList;
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Pair) obj).getFirst(), "_charset_")) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair == null || (str2 = (String) pair.getSecond()) == null) {
            str2 = CharsetJVMKt.getName(charset);
        }
        Charset forName = Charset.forName(str2);
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        for (Pair pair2 : iterable) {
            Intrinsics.checkNotNullExpressionValue(forName, HttpAuthHeader.Parameters.Charset);
            Charset charset2 = forName;
            ParametersBuilder$default.append(CodecsKt.decodeURLQueryComponent$default((String) pair2.component1(), 0, 0, false, charset2, 7, (Object) null), CodecsKt.decodeURLQueryComponent$default((String) pair2.component2(), 0, 0, false, charset2, 7, (Object) null));
        }
        return ParametersBuilder$default.build();
    }

    public static final String formUrlEncode(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder sb = new StringBuilder();
        formUrlEncodeTo(list, (Appendable) sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final void formUrlEncodeTo(List<Pair<String, String>> list, Appendable appendable) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(appendable, "out");
        CollectionsKt.joinTo$default(list, appendable, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, HttpUrlEncodedKt$formUrlEncodeTo$1.INSTANCE, 60, (Object) null);
    }

    public static final String formUrlEncode(Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        Collection arrayList = new ArrayList();
        for (Map.Entry entry : parameters.entries()) {
            Iterable<String> iterable = (Iterable) entry.getValue();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String str : iterable) {
                arrayList2.add(TuplesKt.to(entry.getKey(), str));
            }
            CollectionsKt.addAll(arrayList, (List) arrayList2);
        }
        return formUrlEncode((List<Pair<String, String>>) (List) arrayList);
    }

    public static final void formUrlEncodeTo(Parameters parameters, Appendable appendable) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        Intrinsics.checkNotNullParameter(appendable, "out");
        formUrlEncodeTo((Set<? extends Map.Entry<String, ? extends List<String>>>) parameters.entries(), appendable);
    }

    public static final void formUrlEncodeTo(ParametersBuilder parametersBuilder, Appendable appendable) {
        Intrinsics.checkNotNullParameter(parametersBuilder, "<this>");
        Intrinsics.checkNotNullParameter(appendable, "out");
        formUrlEncodeTo((Set<? extends Map.Entry<String, ? extends List<String>>>) parametersBuilder.entries(), appendable);
    }

    public static final void formUrlEncodeTo(Set<? extends Map.Entry<String, ? extends List<String>>> set, Appendable appendable) {
        List list;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(appendable, "out");
        Collection arrayList = new ArrayList();
        for (Map.Entry entry : set) {
            String str = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            if (list2.isEmpty()) {
                list = CollectionsKt.listOf(TuplesKt.to(str, null));
            } else {
                Iterable<String> iterable = list2;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String str2 : iterable) {
                    arrayList2.add(TuplesKt.to(str, str2));
                }
                list = (List) arrayList2;
            }
            CollectionsKt.addAll(arrayList, list);
        }
        formUrlEncodeTo((List<Pair<String, String>>) (List) arrayList, appendable);
    }
}
