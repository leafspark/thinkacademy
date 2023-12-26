package com.tal.app.thinkacademy.common.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/H5PhotoLibraryCallbackBean;", "", "type", "", "status", "queId", "photoList", "", "videoList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getPhotoList", "()Ljava/util/List;", "setPhotoList", "(Ljava/util/List;)V", "getQueId", "()Ljava/lang/String;", "setQueId", "(Ljava/lang/String;)V", "getStatus", "setStatus", "getType", "setType", "getVideoList", "setVideoList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5PhotoLibraryCallbackBean.kt */
public final class H5PhotoLibraryCallbackBean {
    private List<String> photoList;
    private String queId;
    private String status;
    private String type;
    private List<String> videoList;

    public H5PhotoLibraryCallbackBean() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ H5PhotoLibraryCallbackBean copy$default(H5PhotoLibraryCallbackBean h5PhotoLibraryCallbackBean, String str, String str2, String str3, List<String> list, List<String> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = h5PhotoLibraryCallbackBean.type;
        }
        if ((i & 2) != 0) {
            str2 = h5PhotoLibraryCallbackBean.status;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = h5PhotoLibraryCallbackBean.queId;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            list = h5PhotoLibraryCallbackBean.photoList;
        }
        List<String> list3 = list;
        if ((i & 16) != 0) {
            list2 = h5PhotoLibraryCallbackBean.videoList;
        }
        return h5PhotoLibraryCallbackBean.copy(str, str4, str5, list3, list2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.queId;
    }

    public final List<String> component4() {
        return this.photoList;
    }

    public final List<String> component5() {
        return this.videoList;
    }

    public final H5PhotoLibraryCallbackBean copy(String str, String str2, String str3, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "queId");
        return new H5PhotoLibraryCallbackBean(str, str2, str3, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5PhotoLibraryCallbackBean)) {
            return false;
        }
        H5PhotoLibraryCallbackBean h5PhotoLibraryCallbackBean = (H5PhotoLibraryCallbackBean) obj;
        return Intrinsics.areEqual(this.type, h5PhotoLibraryCallbackBean.type) && Intrinsics.areEqual(this.status, h5PhotoLibraryCallbackBean.status) && Intrinsics.areEqual(this.queId, h5PhotoLibraryCallbackBean.queId) && Intrinsics.areEqual(this.photoList, h5PhotoLibraryCallbackBean.photoList) && Intrinsics.areEqual(this.videoList, h5PhotoLibraryCallbackBean.videoList);
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.status.hashCode()) * 31) + this.queId.hashCode()) * 31;
        List<String> list = this.photoList;
        int i = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.videoList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "H5PhotoLibraryCallbackBean(type=" + this.type + ", status=" + this.status + ", queId=" + this.queId + ", photoList=" + this.photoList + ", videoList=" + this.videoList + ')';
    }

    public H5PhotoLibraryCallbackBean(String str, String str2, String str3, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "queId");
        this.type = str;
        this.status = str2;
        this.queId = str3;
        this.photoList = list;
        this.videoList = list2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ H5PhotoLibraryCallbackBean(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.List r7, java.util.List r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.String r4 = "homeworkFiles"
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            java.lang.String r5 = "0"
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            java.lang.String r6 = ""
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001b
            r1 = r6
            goto L_0x001c
        L_0x001b:
            r1 = r7
        L_0x001c:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0022
            r2 = r6
            goto L_0x0023
        L_0x0022:
            r2 = r8
        L_0x0023:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.entity.H5PhotoLibraryCallbackBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getQueId() {
        return this.queId;
    }

    public final void setQueId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.queId = str;
    }

    public final List<String> getPhotoList() {
        return this.photoList;
    }

    public final void setPhotoList(List<String> list) {
        this.photoList = list;
    }

    public final List<String> getVideoList() {
        return this.videoList;
    }

    public final void setVideoList(List<String> list) {
        this.videoList = list;
    }
}
