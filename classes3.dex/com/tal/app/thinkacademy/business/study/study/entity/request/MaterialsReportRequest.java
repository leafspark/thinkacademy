package com.tal.app.thinkacademy.business.study.study.entity.request;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J+\u0010\n\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R)\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/MaterialsReportRequest;", "", "materialIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getMaterialIds", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialsReportRequest.kt */
public final class MaterialsReportRequest {
    private final ArrayList<String> materialIds;

    public MaterialsReportRequest() {
        this((ArrayList) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MaterialsReportRequest copy$default(MaterialsReportRequest materialsReportRequest, ArrayList<String> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = materialsReportRequest.materialIds;
        }
        return materialsReportRequest.copy(arrayList);
    }

    public final ArrayList<String> component1() {
        return this.materialIds;
    }

    public final MaterialsReportRequest copy(ArrayList<String> arrayList) {
        return new MaterialsReportRequest(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MaterialsReportRequest) && Intrinsics.areEqual((Object) this.materialIds, (Object) ((MaterialsReportRequest) obj).materialIds);
    }

    public int hashCode() {
        ArrayList<String> arrayList = this.materialIds;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public String toString() {
        return "MaterialsReportRequest(materialIds=" + this.materialIds + ')';
    }

    public MaterialsReportRequest(ArrayList<String> arrayList) {
        this.materialIds = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaterialsReportRequest(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<String> getMaterialIds() {
        return this.materialIds;
    }
}
