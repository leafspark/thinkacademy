package com.tal.app.thinkacademy.live.business.schulte.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "", "interactId", "", "pub", "", "showTopNum", "", "rankList", "", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableRankListUserDataBean;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;)V", "getInteractId", "()Ljava/lang/String;", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRankList", "()Ljava/util/List;", "getShowTopNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;)Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableShowRankListBean.kt */
public final class SchulteTableShowRankListBean {
    private final String interactId;
    private final Boolean pub;
    private final List<SchulteTableRankListUserDataBean> rankList;
    private final Integer showTopNum;

    public static /* synthetic */ SchulteTableShowRankListBean copy$default(SchulteTableShowRankListBean schulteTableShowRankListBean, String str, Boolean bool, Integer num, List<SchulteTableRankListUserDataBean> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schulteTableShowRankListBean.interactId;
        }
        if ((i & 2) != 0) {
            bool = schulteTableShowRankListBean.pub;
        }
        if ((i & 4) != 0) {
            num = schulteTableShowRankListBean.showTopNum;
        }
        if ((i & 8) != 0) {
            list = schulteTableShowRankListBean.rankList;
        }
        return schulteTableShowRankListBean.copy(str, bool, num, list);
    }

    public final String component1() {
        return this.interactId;
    }

    public final Boolean component2() {
        return this.pub;
    }

    public final Integer component3() {
        return this.showTopNum;
    }

    public final List<SchulteTableRankListUserDataBean> component4() {
        return this.rankList;
    }

    public final SchulteTableShowRankListBean copy(String str, Boolean bool, Integer num, List<SchulteTableRankListUserDataBean> list) {
        return new SchulteTableShowRankListBean(str, bool, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchulteTableShowRankListBean)) {
            return false;
        }
        SchulteTableShowRankListBean schulteTableShowRankListBean = (SchulteTableShowRankListBean) obj;
        return Intrinsics.areEqual(this.interactId, schulteTableShowRankListBean.interactId) && Intrinsics.areEqual(this.pub, schulteTableShowRankListBean.pub) && Intrinsics.areEqual(this.showTopNum, schulteTableShowRankListBean.showTopNum) && Intrinsics.areEqual(this.rankList, schulteTableShowRankListBean.rankList);
    }

    public int hashCode() {
        String str = this.interactId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.pub;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.showTopNum;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<SchulteTableRankListUserDataBean> list = this.rankList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SchulteTableShowRankListBean(interactId=" + this.interactId + ", pub=" + this.pub + ", showTopNum=" + this.showTopNum + ", rankList=" + this.rankList + ')';
    }

    public SchulteTableShowRankListBean(String str, Boolean bool, Integer num, List<SchulteTableRankListUserDataBean> list) {
        this.interactId = str;
        this.pub = bool;
        this.showTopNum = num;
        this.rankList = list;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final Integer getShowTopNum() {
        return this.showTopNum;
    }

    public final List<SchulteTableRankListUserDataBean> getRankList() {
        return this.rankList;
    }
}
