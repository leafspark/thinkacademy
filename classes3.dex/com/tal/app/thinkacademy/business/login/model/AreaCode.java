package com.tal.app.thinkacademy.business.login.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/model/AreaCode;", "Ljava/io/Serializable;", "id", "", "nationName", "", "nationalCode", "phoneLength", "minZipLength", "maxZipLength", "(ILjava/lang/String;Ljava/lang/String;III)V", "getId", "()I", "setId", "(I)V", "getMaxZipLength", "setMaxZipLength", "getMinZipLength", "setMinZipLength", "getNationName", "()Ljava/lang/String;", "setNationName", "(Ljava/lang/String;)V", "getNationalCode", "setNationalCode", "getPhoneLength", "setPhoneLength", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AreaCode.kt */
public final class AreaCode implements Serializable {
    private int id;
    private int maxZipLength;
    private int minZipLength;
    private String nationName;
    private String nationalCode;
    private int phoneLength;

    public AreaCode() {
        this(0, (String) null, (String) null, 0, 0, 0, 63, (DefaultConstructorMarker) null);
    }

    public AreaCode(int i, String str, String str2, int i2, int i3, int i4) {
        this.id = i;
        this.nationName = str;
        this.nationalCode = str2;
        this.phoneLength = i2;
        this.minZipLength = i3;
        this.maxZipLength = i4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AreaCode(int r6, java.lang.String r7, java.lang.String r8, int r9, int r10, int r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r1 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r1
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.model.AreaCode.<init>(int, java.lang.String, java.lang.String, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getNationName() {
        return this.nationName;
    }

    public final void setNationName(String str) {
        this.nationName = str;
    }

    public final String getNationalCode() {
        return this.nationalCode;
    }

    public final void setNationalCode(String str) {
        this.nationalCode = str;
    }

    public final int getPhoneLength() {
        return this.phoneLength;
    }

    public final void setPhoneLength(int i) {
        this.phoneLength = i;
    }

    public final int getMinZipLength() {
        return this.minZipLength;
    }

    public final void setMinZipLength(int i) {
        this.minZipLength = i;
    }

    public final int getMaxZipLength() {
        return this.maxZipLength;
    }

    public final void setMaxZipLength(int i) {
        this.maxZipLength = i;
    }
}
