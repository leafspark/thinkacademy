package com.tal.app.thinkacademy.business.shop.adapter;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/ClassTagRes;", "", "textRes", "", "bgRes", "(II)V", "getBgRes", "()I", "setBgRes", "(I)V", "getTextRes", "setTextRes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListAdapter.kt */
final class ClassTagRes {
    private int bgRes;
    private int textRes;

    public static /* synthetic */ ClassTagRes copy$default(ClassTagRes classTagRes, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = classTagRes.textRes;
        }
        if ((i3 & 2) != 0) {
            i2 = classTagRes.bgRes;
        }
        return classTagRes.copy(i, i2);
    }

    public final int component1() {
        return this.textRes;
    }

    public final int component2() {
        return this.bgRes;
    }

    public final ClassTagRes copy(int i, int i2) {
        return new ClassTagRes(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassTagRes)) {
            return false;
        }
        ClassTagRes classTagRes = (ClassTagRes) obj;
        return this.textRes == classTagRes.textRes && this.bgRes == classTagRes.bgRes;
    }

    public int hashCode() {
        return (this.textRes * 31) + this.bgRes;
    }

    public String toString() {
        return "ClassTagRes(textRes=" + this.textRes + ", bgRes=" + this.bgRes + ')';
    }

    public ClassTagRes(int i, int i2) {
        this.textRes = i;
        this.bgRes = i2;
    }

    public final int getBgRes() {
        return this.bgRes;
    }

    public final int getTextRes() {
        return this.textRes;
    }

    public final void setBgRes(int i) {
        this.bgRes = i;
    }

    public final void setTextRes(int i) {
        this.textRes = i;
    }
}
