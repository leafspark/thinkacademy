package com.tal.app.thinkacademy.business.shop.bean.teachernode;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/teachernode/TeacherIngachievemNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "achievementList", "", "", "childNode", "", "(Ljava/util/List;Ljava/util/List;)V", "getAchievementList", "()Ljava/util/List;", "setAchievementList", "(Ljava/util/List;)V", "getChildNode", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherIngachievemNode.kt */
public final class TeacherIngachievemNode extends BaseNode {
    private List<String> achievementList;
    private final List<BaseNode> childNode;

    public static /* synthetic */ TeacherIngachievemNode copy$default(TeacherIngachievemNode teacherIngachievemNode, List<String> list, List<BaseNode> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = teacherIngachievemNode.achievementList;
        }
        if ((i & 2) != 0) {
            list2 = teacherIngachievemNode.getChildNode();
        }
        return teacherIngachievemNode.copy(list, list2);
    }

    public final List<String> component1() {
        return this.achievementList;
    }

    public final List<BaseNode> component2() {
        return getChildNode();
    }

    public final TeacherIngachievemNode copy(List<String> list, List<BaseNode> list2) {
        Intrinsics.checkNotNullParameter(list, "achievementList");
        return new TeacherIngachievemNode(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherIngachievemNode)) {
            return false;
        }
        TeacherIngachievemNode teacherIngachievemNode = (TeacherIngachievemNode) obj;
        return Intrinsics.areEqual((Object) this.achievementList, (Object) teacherIngachievemNode.achievementList) && Intrinsics.areEqual((Object) getChildNode(), (Object) teacherIngachievemNode.getChildNode());
    }

    public int hashCode() {
        return (this.achievementList.hashCode() * 31) + (getChildNode() == null ? 0 : getChildNode().hashCode());
    }

    public String toString() {
        return "TeacherIngachievemNode(achievementList=" + this.achievementList + ", childNode=" + getChildNode() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherIngachievemNode(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : list2);
    }

    public final List<String> getAchievementList() {
        return this.achievementList;
    }

    public final void setAchievementList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.achievementList = list;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public TeacherIngachievemNode(List<String> list, List<BaseNode> list2) {
        Intrinsics.checkNotNullParameter(list, "achievementList");
        this.achievementList = list;
        this.childNode = list2;
    }
}
