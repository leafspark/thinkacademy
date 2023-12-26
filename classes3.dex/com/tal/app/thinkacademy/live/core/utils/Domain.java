package com.tal.app.thinkacademy.live.core.utils;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/Domain;", "", "type", "Lcom/tal/app/thinkacademy/live/core/utils/DomainType;", "code", "", "msg", "", "path", "(Lcom/tal/app/thinkacademy/live/core/utils/DomainType;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getPath", "setPath", "getType", "()Lcom/tal/app/thinkacademy/live/core/utils/DomainType;", "setType", "(Lcom/tal/app/thinkacademy/live/core/utils/DomainType;)V", "toString", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public class Domain {
    private int code;
    private String msg;
    private String path;
    private DomainType type;

    public Domain(DomainType domainType, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(domainType, ClassParamsKt.TYPE);
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "path");
        this.type = domainType;
        this.code = i;
        this.msg = str;
        this.path = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Domain(DomainType domainType, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(domainType, i, str, (i2 & 8) != 0 ? "" : str2);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPath() {
        return this.path;
    }

    public final DomainType getType() {
        return this.type;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msg = str;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setType(DomainType domainType) {
        Intrinsics.checkNotNullParameter(domainType, "<set-?>");
        this.type = domainType;
    }

    public String toString() {
        return "{ type:" + this.type + ", code:" + this.code + ", msg:" + this.msg + ", path:" + this.path + " }";
    }
}
