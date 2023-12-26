package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "", "id", "", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "equals", "", "other", "hashCode", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddNewStudent.kt */
public final class AddNewStudent {
    private Integer id;

    public AddNewStudent() {
        this((Integer) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AddNewStudent copy$default(AddNewStudent addNewStudent, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = addNewStudent.id;
        }
        return addNewStudent.copy(num);
    }

    public final Integer component1() {
        return this.id;
    }

    public final AddNewStudent copy(Integer num) {
        return new AddNewStudent(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddNewStudent) && Intrinsics.areEqual((Object) this.id, (Object) ((AddNewStudent) obj).id);
    }

    public int hashCode() {
        Integer num = this.id;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "AddNewStudent(id=" + this.id + ')';
    }

    public AddNewStudent(Integer num) {
        this.id = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddNewStudent(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num);
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }
}
