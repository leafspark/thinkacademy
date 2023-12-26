package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperDetailRequest;", "", "paperId", "", "planId", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getPaperId", "()Ljava/lang/String;", "getPlanId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperDetailRequest;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaperDetailRequest.kt */
public final class PaperDetailRequest {
    private final String paperId;
    private final Integer planId;

    public static /* synthetic */ PaperDetailRequest copy$default(PaperDetailRequest paperDetailRequest, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paperDetailRequest.paperId;
        }
        if ((i & 2) != 0) {
            num = paperDetailRequest.planId;
        }
        return paperDetailRequest.copy(str, num);
    }

    public final String component1() {
        return this.paperId;
    }

    public final Integer component2() {
        return this.planId;
    }

    public final PaperDetailRequest copy(String str, Integer num) {
        return new PaperDetailRequest(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaperDetailRequest)) {
            return false;
        }
        PaperDetailRequest paperDetailRequest = (PaperDetailRequest) obj;
        return Intrinsics.areEqual((Object) this.paperId, (Object) paperDetailRequest.paperId) && Intrinsics.areEqual((Object) this.planId, (Object) paperDetailRequest.planId);
    }

    public int hashCode() {
        String str = this.paperId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.planId;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PaperDetailRequest(paperId=" + this.paperId + ", planId=" + this.planId + ')';
    }

    public PaperDetailRequest(String str, Integer num) {
        this.paperId = str;
        this.planId = num;
    }

    public final String getPaperId() {
        return this.paperId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }
}
