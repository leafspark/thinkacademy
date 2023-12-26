package io.ktor.http;

import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/ktor/http/HttpMethod;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpMethod.kt */
public final class HttpMethod {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<HttpMethod> DefaultMethods;
    /* access modifiers changed from: private */
    public static final HttpMethod Delete;
    /* access modifiers changed from: private */
    public static final HttpMethod Get;
    /* access modifiers changed from: private */
    public static final HttpMethod Head;
    /* access modifiers changed from: private */
    public static final HttpMethod Options;
    /* access modifiers changed from: private */
    public static final HttpMethod Patch;
    /* access modifiers changed from: private */
    public static final HttpMethod Post;
    /* access modifiers changed from: private */
    public static final HttpMethod Put;
    private final String value;

    public static /* synthetic */ HttpMethod copy$default(HttpMethod httpMethod, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpMethod.value;
        }
        return httpMethod.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final HttpMethod copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new HttpMethod(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpMethod) && Intrinsics.areEqual(this.value, ((HttpMethod) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "HttpMethod(value=" + this.value + ')';
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lio/ktor/http/HttpMethod$Companion;", "", "()V", "DefaultMethods", "", "Lio/ktor/http/HttpMethod;", "getDefaultMethods", "()Ljava/util/List;", "Delete", "getDelete", "()Lio/ktor/http/HttpMethod;", "Get", "getGet", "Head", "getHead", "Options", "getOptions", "Patch", "getPatch", "Post", "getPost", "Put", "getPut", "parse", "method", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpMethod getGet() {
            return HttpMethod.Get;
        }

        public final HttpMethod getPost() {
            return HttpMethod.Post;
        }

        public final HttpMethod getPut() {
            return HttpMethod.Put;
        }

        public final HttpMethod getPatch() {
            return HttpMethod.Patch;
        }

        public final HttpMethod getDelete() {
            return HttpMethod.Delete;
        }

        public final HttpMethod getHead() {
            return HttpMethod.Head;
        }

        public final HttpMethod getOptions() {
            return HttpMethod.Options;
        }

        public final HttpMethod parse(String str) {
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_METHOD);
            if (Intrinsics.areEqual(str, getGet().getValue())) {
                return getGet();
            }
            if (Intrinsics.areEqual(str, getPost().getValue())) {
                return getPost();
            }
            if (Intrinsics.areEqual(str, getPut().getValue())) {
                return getPut();
            }
            if (Intrinsics.areEqual(str, getPatch().getValue())) {
                return getPatch();
            }
            if (Intrinsics.areEqual(str, getDelete().getValue())) {
                return getDelete();
            }
            if (Intrinsics.areEqual(str, getHead().getValue())) {
                return getHead();
            }
            if (Intrinsics.areEqual(str, getOptions().getValue())) {
                return getOptions();
            }
            return new HttpMethod(str);
        }

        public final List<HttpMethod> getDefaultMethods() {
            return HttpMethod.DefaultMethods;
        }
    }

    public HttpMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        HttpMethod httpMethod = new HttpMethod("GET");
        Get = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        Post = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        Put = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        Patch = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        Delete = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        Head = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("OPTIONS");
        Options = httpMethod7;
        DefaultMethods = CollectionsKt.listOf(new HttpMethod[]{httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, httpMethod7});
    }
}
