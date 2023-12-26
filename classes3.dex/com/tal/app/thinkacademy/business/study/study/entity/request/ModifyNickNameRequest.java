package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/ModifyNickNameRequest;", "", "data", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/Body;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/Body;)V", "getData", "()Lcom/tal/app/thinkacademy/business/study/study/entity/request/Body;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifyNickNameRequest.kt */
public final class ModifyNickNameRequest {
    private final Body data;

    public static /* synthetic */ ModifyNickNameRequest copy$default(ModifyNickNameRequest modifyNickNameRequest, Body body, int i, Object obj) {
        if ((i & 1) != 0) {
            body = modifyNickNameRequest.data;
        }
        return modifyNickNameRequest.copy(body);
    }

    public final Body component1() {
        return this.data;
    }

    public final ModifyNickNameRequest copy(Body body) {
        return new ModifyNickNameRequest(body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ModifyNickNameRequest) && Intrinsics.areEqual((Object) this.data, (Object) ((ModifyNickNameRequest) obj).data);
    }

    public int hashCode() {
        Body body = this.data;
        if (body == null) {
            return 0;
        }
        return body.hashCode();
    }

    public String toString() {
        return "ModifyNickNameRequest(data=" + this.data + ')';
    }

    public ModifyNickNameRequest(Body body) {
        this.data = body;
    }

    public final Body getData() {
        return this.data;
    }
}
