package com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateDiagnosisNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "title", "", "description", "examId", "childNode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChildNode", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getExamId", "setExamId", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDiagnosisNode.kt */
public final class GradeAggregateDiagnosisNode extends BaseNode {
    private final List<BaseNode> childNode;
    private String description;
    private String examId;
    private String title;

    public GradeAggregateDiagnosisNode() {
        this((String) null, (String) null, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateDiagnosisNode copy$default(GradeAggregateDiagnosisNode gradeAggregateDiagnosisNode, String str, String str2, String str3, List<BaseNode> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gradeAggregateDiagnosisNode.title;
        }
        if ((i & 2) != 0) {
            str2 = gradeAggregateDiagnosisNode.description;
        }
        if ((i & 4) != 0) {
            str3 = gradeAggregateDiagnosisNode.examId;
        }
        if ((i & 8) != 0) {
            list = gradeAggregateDiagnosisNode.getChildNode();
        }
        return gradeAggregateDiagnosisNode.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.examId;
    }

    public final List<BaseNode> component4() {
        return getChildNode();
    }

    public final GradeAggregateDiagnosisNode copy(String str, String str2, String str3, List<BaseNode> list) {
        return new GradeAggregateDiagnosisNode(str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateDiagnosisNode)) {
            return false;
        }
        GradeAggregateDiagnosisNode gradeAggregateDiagnosisNode = (GradeAggregateDiagnosisNode) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) gradeAggregateDiagnosisNode.title) && Intrinsics.areEqual((Object) this.description, (Object) gradeAggregateDiagnosisNode.description) && Intrinsics.areEqual((Object) this.examId, (Object) gradeAggregateDiagnosisNode.examId) && Intrinsics.areEqual((Object) getChildNode(), (Object) gradeAggregateDiagnosisNode.getChildNode());
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.examId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        if (getChildNode() != null) {
            i = getChildNode().hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GradeAggregateDiagnosisNode(title=" + this.title + ", description=" + this.description + ", examId=" + this.examId + ", childNode=" + getChildNode() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateDiagnosisNode(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getExamId() {
        return this.examId;
    }

    public final void setExamId(String str) {
        this.examId = str;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public GradeAggregateDiagnosisNode(String str, String str2, String str3, List<BaseNode> list) {
        this.title = str;
        this.description = str2;
        this.examId = str3;
        this.childNode = list;
    }
}
