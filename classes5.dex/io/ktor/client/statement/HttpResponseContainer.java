package io.ktor.client.statement;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lio/ktor/client/statement/HttpResponseContainer;", "", "expectedType", "Lio/ktor/util/reflect/TypeInfo;", "response", "(Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;)V", "getExpectedType", "()Lio/ktor/util/reflect/TypeInfo;", "getResponse", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpResponsePipeline.kt */
public final class HttpResponseContainer {
    private final TypeInfo expectedType;
    private final Object response;

    public static /* synthetic */ HttpResponseContainer copy$default(HttpResponseContainer httpResponseContainer, TypeInfo typeInfo, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            typeInfo = httpResponseContainer.expectedType;
        }
        if ((i & 2) != 0) {
            obj = httpResponseContainer.response;
        }
        return httpResponseContainer.copy(typeInfo, obj);
    }

    public final TypeInfo component1() {
        return this.expectedType;
    }

    public final Object component2() {
        return this.response;
    }

    public final HttpResponseContainer copy(TypeInfo typeInfo, Object obj) {
        Intrinsics.checkNotNullParameter(typeInfo, "expectedType");
        Intrinsics.checkNotNullParameter(obj, "response");
        return new HttpResponseContainer(typeInfo, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponseContainer)) {
            return false;
        }
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) obj;
        return Intrinsics.areEqual(this.expectedType, httpResponseContainer.expectedType) && Intrinsics.areEqual(this.response, httpResponseContainer.response);
    }

    public int hashCode() {
        return (this.expectedType.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "HttpResponseContainer(expectedType=" + this.expectedType + ", response=" + this.response + ')';
    }

    public HttpResponseContainer(TypeInfo typeInfo, Object obj) {
        Intrinsics.checkNotNullParameter(typeInfo, "expectedType");
        Intrinsics.checkNotNullParameter(obj, "response");
        this.expectedType = typeInfo;
        this.response = obj;
    }

    public final TypeInfo getExpectedType() {
        return this.expectedType;
    }

    public final Object getResponse() {
        return this.response;
    }
}
