package com.tal.app.thinkacademy.business.study.study.entity;

import com.chad.library.adapter.base.entity.SectionEntity;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¨\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001eR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Material;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "fileIcon", "", "fileUrl", "md5sum", "name", "size", "uploadTime", "fileExt", "materialId", "fileCate", "headerTitle", "isTop", "", "isBottom", "isHeader", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)V", "getFileCate", "()Ljava/lang/String;", "getFileExt", "getFileIcon", "getFileUrl", "getHeaderTitle", "setHeaderTitle", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setBottom", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "()Z", "setTop", "getMaterialId", "getMd5sum", "getName", "getSize", "getUploadTime", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)Lcom/tal/app/thinkacademy/business/study/study/entity/Material;", "equals", "other", "", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LearnMaterialsEntity.kt */
public final class Material implements SectionEntity {
    private final String fileCate;
    private final String fileExt;
    private final String fileIcon;
    private final String fileUrl;
    private String headerTitle;
    private Boolean isBottom;
    private final boolean isHeader;
    private Boolean isTop;
    private final String materialId;
    private final String md5sum;
    private final String name;
    private final String size;
    private final String uploadTime;

    public Material() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, false, 8191, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Material copy$default(Material material, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, Boolean bool2, boolean z, int i, Object obj) {
        Material material2 = material;
        int i2 = i;
        return material.copy((i2 & 1) != 0 ? material2.fileIcon : str, (i2 & 2) != 0 ? material2.fileUrl : str2, (i2 & 4) != 0 ? material2.md5sum : str3, (i2 & 8) != 0 ? material2.name : str4, (i2 & 16) != 0 ? material2.size : str5, (i2 & 32) != 0 ? material2.uploadTime : str6, (i2 & 64) != 0 ? material2.fileExt : str7, (i2 & 128) != 0 ? material2.materialId : str8, (i2 & 256) != 0 ? material2.fileCate : str9, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? material2.headerTitle : str10, (i2 & 1024) != 0 ? material2.isTop : bool, (i2 & 2048) != 0 ? material2.isBottom : bool2, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? material.isHeader() : z);
    }

    public final String component1() {
        return this.fileIcon;
    }

    public final String component10() {
        return this.headerTitle;
    }

    public final Boolean component11() {
        return this.isTop;
    }

    public final Boolean component12() {
        return this.isBottom;
    }

    public final boolean component13() {
        return isHeader();
    }

    public final String component2() {
        return this.fileUrl;
    }

    public final String component3() {
        return this.md5sum;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.size;
    }

    public final String component6() {
        return this.uploadTime;
    }

    public final String component7() {
        return this.fileExt;
    }

    public final String component8() {
        return this.materialId;
    }

    public final String component9() {
        return this.fileCate;
    }

    public final Material copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, Boolean bool2, boolean z) {
        return new Material(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, bool, bool2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Material)) {
            return false;
        }
        Material material = (Material) obj;
        return Intrinsics.areEqual((Object) this.fileIcon, (Object) material.fileIcon) && Intrinsics.areEqual((Object) this.fileUrl, (Object) material.fileUrl) && Intrinsics.areEqual((Object) this.md5sum, (Object) material.md5sum) && Intrinsics.areEqual((Object) this.name, (Object) material.name) && Intrinsics.areEqual((Object) this.size, (Object) material.size) && Intrinsics.areEqual((Object) this.uploadTime, (Object) material.uploadTime) && Intrinsics.areEqual((Object) this.fileExt, (Object) material.fileExt) && Intrinsics.areEqual((Object) this.materialId, (Object) material.materialId) && Intrinsics.areEqual((Object) this.fileCate, (Object) material.fileCate) && Intrinsics.areEqual((Object) this.headerTitle, (Object) material.headerTitle) && Intrinsics.areEqual((Object) this.isTop, (Object) material.isTop) && Intrinsics.areEqual((Object) this.isBottom, (Object) material.isBottom) && isHeader() == material.isHeader();
    }

    public int hashCode() {
        String str = this.fileIcon;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.md5sum;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.size;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.uploadTime;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.fileExt;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.materialId;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.fileCate;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.headerTitle;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool = this.isTop;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isBottom;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        int i2 = (hashCode11 + i) * 31;
        boolean isHeader2 = isHeader();
        if (isHeader2) {
            isHeader2 = true;
        }
        return i2 + (isHeader2 ? 1 : 0);
    }

    public String toString() {
        return "Material(fileIcon=" + this.fileIcon + ", fileUrl=" + this.fileUrl + ", md5sum=" + this.md5sum + ", name=" + this.name + ", size=" + this.size + ", uploadTime=" + this.uploadTime + ", fileExt=" + this.fileExt + ", materialId=" + this.materialId + ", fileCate=" + this.fileCate + ", headerTitle=" + this.headerTitle + ", isTop=" + this.isTop + ", isBottom=" + this.isBottom + ", isHeader=" + isHeader() + ')';
    }

    public Material(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, Boolean bool2, boolean z) {
        this.fileIcon = str;
        this.fileUrl = str2;
        this.md5sum = str3;
        this.name = str4;
        this.size = str5;
        this.uploadTime = str6;
        this.fileExt = str7;
        this.materialId = str8;
        this.fileCate = str9;
        this.headerTitle = str10;
        this.isTop = bool;
        this.isBottom = bool2;
        this.isHeader = z;
    }

    public int getItemType() {
        return SectionEntity.DefaultImpls.getItemType((SectionEntity) this);
    }

    public final String getFileIcon() {
        return this.fileIcon;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getMd5sum() {
        return this.md5sum;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getUploadTime() {
        return this.uploadTime;
    }

    public final String getFileExt() {
        return this.fileExt;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getFileCate() {
        return this.fileCate;
    }

    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    public final void setHeaderTitle(String str) {
        this.headerTitle = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Material(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.Boolean r25, java.lang.Boolean r26, boolean r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r15
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r16
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r17
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r18
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r19
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            java.lang.String r8 = "pdf"
            goto L_0x003c
        L_0x003a:
            r8 = r21
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r2
            goto L_0x0044
        L_0x0042:
            r9 = r22
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            java.lang.String r10 = "1"
            goto L_0x004d
        L_0x004b:
            r10 = r23
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r2 = r24
        L_0x0054:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            r12 = 0
            if (r11 == 0) goto L_0x005e
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r12)
            goto L_0x0060
        L_0x005e:
            r11 = r25
        L_0x0060:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0069
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)
            goto L_0x006b
        L_0x0069:
            r13 = r26
        L_0x006b:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r12 = r27
        L_0x0072:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r2
            r26 = r11
            r27 = r13
            r28 = r12
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.Material.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean isTop() {
        return this.isTop;
    }

    public final void setTop(Boolean bool) {
        this.isTop = bool;
    }

    public final Boolean isBottom() {
        return this.isBottom;
    }

    public final void setBottom(Boolean bool) {
        this.isBottom = bool;
    }

    public boolean isHeader() {
        return this.isHeader;
    }
}
