package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/ChangeNickNameRequest;", "", "nickName", "", "(Ljava/lang/String;)V", "getNickName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyRequest.kt */
public final class ChangeNickNameRequest {
    private final String nickName;

    public static /* synthetic */ ChangeNickNameRequest copy$default(ChangeNickNameRequest changeNickNameRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changeNickNameRequest.nickName;
        }
        return changeNickNameRequest.copy(str);
    }

    public final String component1() {
        return this.nickName;
    }

    public final ChangeNickNameRequest copy(String str) {
        return new ChangeNickNameRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChangeNickNameRequest) && Intrinsics.areEqual((Object) this.nickName, (Object) ((ChangeNickNameRequest) obj).nickName);
    }

    public int hashCode() {
        String str = this.nickName;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ChangeNickNameRequest(nickName=" + this.nickName + ')';
    }

    public ChangeNickNameRequest(String str) {
        this.nickName = str;
    }

    public final String getNickName() {
        return this.nickName;
    }
}
