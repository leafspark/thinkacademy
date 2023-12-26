package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;", "", "ctype", "", "(I)V", "getCtype", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CurriculumListData.kt */
public final class CurriculumListData {
    private final int ctype;

    public static /* synthetic */ CurriculumListData copy$default(CurriculumListData curriculumListData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = curriculumListData.ctype;
        }
        return curriculumListData.copy(i);
    }

    public final int component1() {
        return this.ctype;
    }

    public final CurriculumListData copy(int i) {
        return new CurriculumListData(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CurriculumListData) && this.ctype == ((CurriculumListData) obj).ctype;
    }

    public int hashCode() {
        return this.ctype;
    }

    public String toString() {
        return "CurriculumListData(ctype=" + this.ctype + ')';
    }

    public CurriculumListData(int i) {
        this.ctype = i;
    }

    public final int getCtype() {
        return this.ctype;
    }
}
