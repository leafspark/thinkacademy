package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/LearnMaterialsEntity;", "", "planInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/PlanInfo;", "planBlackboards", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Material;", "materials", "allMaterialsList", "(Lcom/tal/app/thinkacademy/business/study/study/entity/PlanInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAllMaterialsList", "()Ljava/util/List;", "setAllMaterialsList", "(Ljava/util/List;)V", "getMaterials", "getPlanBlackboards", "getPlanInfo", "()Lcom/tal/app/thinkacademy/business/study/study/entity/PlanInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LearnMaterialsEntity.kt */
public final class LearnMaterialsEntity {
    private List<Material> allMaterialsList;
    private final List<Material> materials;
    private final List<Material> planBlackboards;
    private final PlanInfo planInfo;

    public static /* synthetic */ LearnMaterialsEntity copy$default(LearnMaterialsEntity learnMaterialsEntity, PlanInfo planInfo2, List<Material> list, List<Material> list2, List<Material> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            planInfo2 = learnMaterialsEntity.planInfo;
        }
        if ((i & 2) != 0) {
            list = learnMaterialsEntity.planBlackboards;
        }
        if ((i & 4) != 0) {
            list2 = learnMaterialsEntity.materials;
        }
        if ((i & 8) != 0) {
            list3 = learnMaterialsEntity.allMaterialsList;
        }
        return learnMaterialsEntity.copy(planInfo2, list, list2, list3);
    }

    public final PlanInfo component1() {
        return this.planInfo;
    }

    public final List<Material> component2() {
        return this.planBlackboards;
    }

    public final List<Material> component3() {
        return this.materials;
    }

    public final List<Material> component4() {
        return this.allMaterialsList;
    }

    public final LearnMaterialsEntity copy(PlanInfo planInfo2, List<Material> list, List<Material> list2, List<Material> list3) {
        return new LearnMaterialsEntity(planInfo2, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LearnMaterialsEntity)) {
            return false;
        }
        LearnMaterialsEntity learnMaterialsEntity = (LearnMaterialsEntity) obj;
        return Intrinsics.areEqual((Object) this.planInfo, (Object) learnMaterialsEntity.planInfo) && Intrinsics.areEqual((Object) this.planBlackboards, (Object) learnMaterialsEntity.planBlackboards) && Intrinsics.areEqual((Object) this.materials, (Object) learnMaterialsEntity.materials) && Intrinsics.areEqual((Object) this.allMaterialsList, (Object) learnMaterialsEntity.allMaterialsList);
    }

    public int hashCode() {
        PlanInfo planInfo2 = this.planInfo;
        int i = 0;
        int hashCode = (planInfo2 == null ? 0 : planInfo2.hashCode()) * 31;
        List<Material> list = this.planBlackboards;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Material> list2 = this.materials;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Material> list3 = this.allMaterialsList;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "LearnMaterialsEntity(planInfo=" + this.planInfo + ", planBlackboards=" + this.planBlackboards + ", materials=" + this.materials + ", allMaterialsList=" + this.allMaterialsList + ')';
    }

    public LearnMaterialsEntity(PlanInfo planInfo2, List<Material> list, List<Material> list2, List<Material> list3) {
        this.planInfo = planInfo2;
        this.planBlackboards = list;
        this.materials = list2;
        this.allMaterialsList = list3;
    }

    public final PlanInfo getPlanInfo() {
        return this.planInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LearnMaterialsEntity(PlanInfo planInfo2, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(planInfo2, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2, (i & 8) != 0 ? new ArrayList() : list3);
    }

    public final List<Material> getPlanBlackboards() {
        return this.planBlackboards;
    }

    public final List<Material> getMaterials() {
        return this.materials;
    }

    public final List<Material> getAllMaterialsList() {
        return this.allMaterialsList;
    }

    public final void setAllMaterialsList(List<Material> list) {
        this.allMaterialsList = list;
    }
}
