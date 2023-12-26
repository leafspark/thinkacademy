package com.tal.app.thinkacademy.business.login.entity.post;

import com.tal.app.thinkacademy.common.entity.Header;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/AddNewStudentRequest;", "", "header", "Lcom/tal/app/thinkacademy/common/entity/Header;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/NewStudent;", "(Lcom/tal/app/thinkacademy/common/entity/Header;Lcom/tal/app/thinkacademy/business/login/entity/post/NewStudent;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/NewStudent;", "getHeader", "()Lcom/tal/app/thinkacademy/common/entity/Header;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddNewStudentRequest.kt */
public final class AddNewStudentRequest {
    private final NewStudent data;
    private final Header header;

    public static /* synthetic */ AddNewStudentRequest copy$default(AddNewStudentRequest addNewStudentRequest, Header header2, NewStudent newStudent, int i, Object obj) {
        if ((i & 1) != 0) {
            header2 = addNewStudentRequest.header;
        }
        if ((i & 2) != 0) {
            newStudent = addNewStudentRequest.data;
        }
        return addNewStudentRequest.copy(header2, newStudent);
    }

    public final Header component1() {
        return this.header;
    }

    public final NewStudent component2() {
        return this.data;
    }

    public final AddNewStudentRequest copy(Header header2, NewStudent newStudent) {
        return new AddNewStudentRequest(header2, newStudent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddNewStudentRequest)) {
            return false;
        }
        AddNewStudentRequest addNewStudentRequest = (AddNewStudentRequest) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) addNewStudentRequest.header) && Intrinsics.areEqual((Object) this.data, (Object) addNewStudentRequest.data);
    }

    public int hashCode() {
        Header header2 = this.header;
        int i = 0;
        int hashCode = (header2 == null ? 0 : header2.hashCode()) * 31;
        NewStudent newStudent = this.data;
        if (newStudent != null) {
            i = newStudent.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AddNewStudentRequest(header=" + this.header + ", data=" + this.data + ')';
    }

    public AddNewStudentRequest(Header header2, NewStudent newStudent) {
        this.header = header2;
        this.data = newStudent;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final NewStudent getData() {
        return this.data;
    }
}
