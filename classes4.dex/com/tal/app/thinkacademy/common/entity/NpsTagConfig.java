package com.tal.app.thinkacademy.common.entity;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001$B_\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "Ljava/io/Serializable;", "oneTagList", "", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig$NpsTag;", "twoTagList", "threeTagList", "fourTagList", "fiveTagList", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFiveTagList", "()Ljava/util/List;", "setFiveTagList", "(Ljava/util/List;)V", "getFourTagList", "setFourTagList", "getOneTagList", "setOneTagList", "getThreeTagList", "setThreeTagList", "getTwoTagList", "setTwoTagList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "NpsTag", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsTagConfig.kt */
public final class NpsTagConfig implements Serializable {
    private List<NpsTag> fiveTagList;
    private List<NpsTag> fourTagList;
    private List<NpsTag> oneTagList;
    private List<NpsTag> threeTagList;
    private List<NpsTag> twoTagList;

    public NpsTagConfig() {
        this((List) null, (List) null, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NpsTagConfig copy$default(NpsTagConfig npsTagConfig, List<NpsTag> list, List<NpsTag> list2, List<NpsTag> list3, List<NpsTag> list4, List<NpsTag> list5, int i, Object obj) {
        if ((i & 1) != 0) {
            list = npsTagConfig.oneTagList;
        }
        if ((i & 2) != 0) {
            list2 = npsTagConfig.twoTagList;
        }
        List<NpsTag> list6 = list2;
        if ((i & 4) != 0) {
            list3 = npsTagConfig.threeTagList;
        }
        List<NpsTag> list7 = list3;
        if ((i & 8) != 0) {
            list4 = npsTagConfig.fourTagList;
        }
        List<NpsTag> list8 = list4;
        if ((i & 16) != 0) {
            list5 = npsTagConfig.fiveTagList;
        }
        return npsTagConfig.copy(list, list6, list7, list8, list5);
    }

    public final List<NpsTag> component1() {
        return this.oneTagList;
    }

    public final List<NpsTag> component2() {
        return this.twoTagList;
    }

    public final List<NpsTag> component3() {
        return this.threeTagList;
    }

    public final List<NpsTag> component4() {
        return this.fourTagList;
    }

    public final List<NpsTag> component5() {
        return this.fiveTagList;
    }

    public final NpsTagConfig copy(List<NpsTag> list, List<NpsTag> list2, List<NpsTag> list3, List<NpsTag> list4, List<NpsTag> list5) {
        return new NpsTagConfig(list, list2, list3, list4, list5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NpsTagConfig)) {
            return false;
        }
        NpsTagConfig npsTagConfig = (NpsTagConfig) obj;
        return Intrinsics.areEqual(this.oneTagList, npsTagConfig.oneTagList) && Intrinsics.areEqual(this.twoTagList, npsTagConfig.twoTagList) && Intrinsics.areEqual(this.threeTagList, npsTagConfig.threeTagList) && Intrinsics.areEqual(this.fourTagList, npsTagConfig.fourTagList) && Intrinsics.areEqual(this.fiveTagList, npsTagConfig.fiveTagList);
    }

    public int hashCode() {
        List<NpsTag> list = this.oneTagList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<NpsTag> list2 = this.twoTagList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<NpsTag> list3 = this.threeTagList;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<NpsTag> list4 = this.fourTagList;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<NpsTag> list5 = this.fiveTagList;
        if (list5 != null) {
            i = list5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "NpsTagConfig(oneTagList=" + this.oneTagList + ", twoTagList=" + this.twoTagList + ", threeTagList=" + this.threeTagList + ", fourTagList=" + this.fourTagList + ", fiveTagList=" + this.fiveTagList + ')';
    }

    public NpsTagConfig(List<NpsTag> list, List<NpsTag> list2, List<NpsTag> list3, List<NpsTag> list4, List<NpsTag> list5) {
        this.oneTagList = list;
        this.twoTagList = list2;
        this.threeTagList = list3;
        this.fourTagList = list4;
        this.fiveTagList = list5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NpsTagConfig(java.util.List r4, java.util.List r5, java.util.List r6, java.util.List r7, java.util.List r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000b
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x000b:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0016
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
        L_0x0016:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0023
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r5
            java.util.List r6 = (java.util.List) r6
        L_0x0023:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0030
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r7 = r5
            java.util.List r7 = (java.util.List) r7
        L_0x0030:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x003d
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r8 = r5
            java.util.List r8 = (java.util.List) r8
        L_0x003d:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.NpsTagConfig.<init>(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<NpsTag> getOneTagList() {
        return this.oneTagList;
    }

    public final void setOneTagList(List<NpsTag> list) {
        this.oneTagList = list;
    }

    public final List<NpsTag> getTwoTagList() {
        return this.twoTagList;
    }

    public final void setTwoTagList(List<NpsTag> list) {
        this.twoTagList = list;
    }

    public final List<NpsTag> getThreeTagList() {
        return this.threeTagList;
    }

    public final void setThreeTagList(List<NpsTag> list) {
        this.threeTagList = list;
    }

    public final List<NpsTag> getFourTagList() {
        return this.fourTagList;
    }

    public final void setFourTagList(List<NpsTag> list) {
        this.fourTagList = list;
    }

    public final List<NpsTag> getFiveTagList() {
        return this.fiveTagList;
    }

    public final void setFiveTagList(List<NpsTag> list) {
        this.fiveTagList = list;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig$NpsTag;", "Ljava/io/Serializable;", "()V", "detailFlag", "", "getDetailFlag", "()I", "setDetailFlag", "(I)V", "id", "getId", "setId", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NpsTagConfig.kt */
    public static final class NpsTag implements Serializable {
        private int detailFlag;
        private int id = 1;
        private String name = "";

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final int getDetailFlag() {
            return this.detailFlag;
        }

        public final void setDetailFlag(int i) {
            this.detailFlag = i;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }
    }
}
